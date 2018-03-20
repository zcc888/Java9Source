/*
 * Copyright (c) 2014, 2016, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package com.oracle.tools.packager.mac;

import com.oracle.tools.packager.AbstractBundler;
import com.oracle.tools.packager.BundlerParamInfo;
import com.oracle.tools.packager.StandardBundlerParam;
import com.oracle.tools.packager.Log;
import com.oracle.tools.packager.ConfigException;
import com.oracle.tools.packager.IOUtils;
import com.oracle.tools.packager.Platform;
import com.oracle.tools.packager.UnsupportedPlatformException;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.oracle.tools.packager.StandardBundlerParam.*;

public abstract class MacBaseInstallerBundler extends AbstractBundler {

    private static final ResourceBundle I18N =
            ResourceBundle.getBundle(MacBaseInstallerBundler.class.getName());

    //This could be generalized more to be for any type of Image Bundler
    public static final BundlerParamInfo<MacAppBundler> APP_BUNDLER = new StandardBundlerParam<>(
            I18N.getString("param.app-bundler.name"),
            I18N.getString("param.app-bundle.description"),
            "mac.app.bundler",
            MacAppBundler.class,
            params -> new MacAppBundler(),
            (s, p) -> null);

    public final BundlerParamInfo<File> APP_IMAGE_BUILD_ROOT = new StandardBundlerParam<>(
            I18N.getString("param.app-image-build-root.name"),
            I18N.getString("param.app-image-build-root.description"),
            "mac.app.imageRoot",
            File.class,
            params -> {
                File imageDir = IMAGES_ROOT.fetchFrom(params);
                if (!imageDir.exists()) imageDir.mkdirs();
                try {
                    return Files.createTempDirectory(imageDir.toPath(), "image-").toFile();
                } catch (IOException e) {
                    return new File(imageDir, getID()+ ".image");
                }
            },
            (s, p) -> new File(s));

    public static final StandardBundlerParam<File> MAC_APP_IMAGE = new StandardBundlerParam<>(
            I18N.getString("param.app-image.name"),
            I18N.getString("param.app-image.description"),
            "mac.app.image",
            File.class,
            params -> null,
            (s, p) -> new File(s));


    public static final BundlerParamInfo<MacDaemonBundler> DAEMON_BUNDLER = new StandardBundlerParam<>(
            I18N.getString("param.daemon-bundler.name"),
            I18N.getString("param.daemon-bundler.description"),
            "mac.daemon.bundler",
            MacDaemonBundler.class,
            params -> new MacDaemonBundler(),
            (s, p) -> null);


    public final BundlerParamInfo<File> DAEMON_IMAGE_BUILD_ROOT = new StandardBundlerParam<>(
            I18N.getString("param.daemon-image-build-root.name"),
            I18N.getString("param.daemon-image-build-root.description"),
            "mac.daemon.image",
            File.class,
            params -> {
                File imageDir = IMAGES_ROOT.fetchFrom(params);
                if (!imageDir.exists()) imageDir.mkdirs();
                return new File(imageDir, getID()+ ".daemon");
            },
            (s, p) -> new File(s));


    public static final BundlerParamInfo<File> CONFIG_ROOT = new StandardBundlerParam<>(
            I18N.getString("param.config-root.name"),
            I18N.getString("param.config-root.description"),
            "configRoot",
            File.class,
            params -> {
                File imagesRoot = new File(BUILD_ROOT.fetchFrom(params), "macosx");
                imagesRoot.mkdirs();
                return imagesRoot;
            },
            (s, p) -> null);

    public static final BundlerParamInfo<String> SIGNING_KEY_USER = new StandardBundlerParam<>(
            I18N.getString("param.signing-key-name.name"),
            I18N.getString("param.signing-key-name.description"),
            "mac.signing-key-user-name",
            String.class,
            params -> "",
            null);

    public static final BundlerParamInfo<String> SIGNING_KEYCHAIN = new StandardBundlerParam<>(
            I18N.getString("param.signing-keychain.name"),
            I18N.getString("param.signing-keychain.description"),
            "mac.signing-keychain",
            String.class,
            params -> "",
            null);

    public static final BundlerParamInfo<String> INSTALLER_NAME = new StandardBundlerParam<> (
            I18N.getString("param.installer-name.name"),
            I18N.getString("param.installer-name.description"),
            "mac.installerName",
            String.class,
            params -> {
                String nm = APP_NAME.fetchFrom(params);
                if (nm == null) return null;

                String version = VERSION.fetchFrom(params);
                if (version == null) {
                    return nm;
                } else {
                    return nm + "-" + version;
                }
            },
            (s, p) -> s);

    public static File getPredefinedImage(Map<String, ? super Object> p) {
        File applicationImage = null;
        if (MAC_APP_IMAGE.fetchFrom(p) != null) {
            applicationImage = MAC_APP_IMAGE.fetchFrom(p);
            Log.debug("Using App Image from " + applicationImage);
            if (!applicationImage.exists()) {
                throw new RuntimeException(
                        MessageFormat.format(I18N.getString("message.app-image-dir-does-not-exist"), MAC_APP_IMAGE.getID(), applicationImage.toString()));
            }
        }
        return applicationImage;
    }

    protected void validateAppImageAndBundeler(Map<String, ? super Object> params) throws ConfigException, UnsupportedPlatformException {
        if (MAC_APP_IMAGE.fetchFrom(params) != null) {
            File applicationImage = MAC_APP_IMAGE.fetchFrom(params);
            if (!applicationImage.exists()) {
                throw new ConfigException(
                        MessageFormat.format(I18N.getString("message.app-image-dir-does-not-exist"), MAC_APP_IMAGE.getID(), applicationImage.toString()),
                        MessageFormat.format(I18N.getString("message.app-image-dir-does-not-exist.advice"), MAC_APP_IMAGE.getID()));
            }
            if (APP_NAME.fetchFrom(params) == null) {
                throw new ConfigException(
                        I18N.getString("message.app-image-requires-app-name"),
                        I18N.getString("message.app-image-requires-app-name.advice"));
            }
            if (IDENTIFIER.fetchFrom(params) == null) {
                throw new ConfigException(
                        I18N.getString("message.app-image-requires-identifier"),
                        I18N.getString("message.app-image-requires-identifier.advice"));
            }
        } else {
            APP_BUNDLER.fetchFrom(params).doValidate(params);
        }
    }

    protected File prepareAppBundle(Map<String, ? super Object> p) {
        File predefinedImage = getPredefinedImage(p);
        if (predefinedImage != null) {
            return predefinedImage;
        }

        File appImageRoot = APP_IMAGE_BUILD_ROOT.fetchFrom(p);
        return APP_BUNDLER.fetchFrom(p).doBundle(p, appImageRoot, true);
    }

    protected File prepareDaemonBundle(Map<String, ? super Object> p) {
        File daemonImageRoot = DAEMON_IMAGE_BUILD_ROOT.fetchFrom(p);
        return DAEMON_BUNDLER.fetchFrom(p).doBundle(p, daemonImageRoot, true);
    }

    @Override
    public Collection<BundlerParamInfo<?>> getBundleParameters() {
        Collection<BundlerParamInfo<?>> results = new LinkedHashSet<>();

        results.addAll(MacAppBundler.getAppBundleParameters());
        results.addAll(Arrays.asList(
                APP_BUNDLER,
                CONFIG_ROOT,
                APP_IMAGE_BUILD_ROOT,
                MAC_APP_IMAGE
        ));

        return results;
    }

    @Override
    public String getBundleType() {
        return "INSTALLER";
    }

    public static String findKey(String key, String keychainName, boolean verbose) {
        if (Platform.getPlatform() != Platform.MAC) {
            return null;
        }

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream(); PrintStream ps = new PrintStream(baos)) {
            List<String> searchOptions = new ArrayList<>();
            searchOptions.add("security");
            searchOptions.add("find-certificate");
            searchOptions.add("-c");
            searchOptions.add(key);
            searchOptions.add("-a");
            if (keychainName != null && !keychainName.isEmpty()) {
                searchOptions.add(keychainName);
            }

            ProcessBuilder pb = new ProcessBuilder(searchOptions);

            IOUtils.exec(pb, verbose, false, ps);
            Pattern p = Pattern.compile("\"alis\"<blob>=\"([^\"]+)\"");
            Matcher m = p.matcher(baos.toString());
            if (!m.find()) {
                Log.info("Did not find a key matching '" + key + "'");
                return null;
            }
            String matchedKey = m.group(1);
            if (m.find()) {
                Log.info("Found more than one key matching '"  + key + "'");
                return null;
            }
            Log.debug("Using key '" + matchedKey + "'");
            return matchedKey;
        } catch (IOException ioe) {
            ioe.printStackTrace();
            Log.verbose(ioe);
            return null;
        }
    }
}
