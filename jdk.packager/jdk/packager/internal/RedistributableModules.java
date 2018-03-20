/*
 * Copyright (c) 2015, 2017, Oracle and/or its affiliates. All rights reserved.
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
package jdk.packager.internal;


import com.oracle.tools.packager.IOUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import jdk.tools.jlink.internal.packager.AppRuntimeImageBuilder;

import java.lang.module.ModuleDescriptor;
import java.lang.module.ModuleFinder;
import java.lang.module.ModuleReference;
import java.lang.module.ModuleReader;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


public final class RedistributableModules {
    private static final String JDK_PACKAGER_MODULE = "jdk.packager";
    private static final String LEGACY_JRE_MODULES_FILENAME = "jdk/packager/internal/resources/tools/legacy/jre.list";

    private RedistributableModules() {}

    public static String stripComments(String line) {
        String result = "";
        int i = line.indexOf(";");

        if (i >= 0) {
          result = line.substring(0, i);
          result = result.trim();
        }
        else {
            result = line;
        }

        return result;
    }

    public static Set<String> getRedistributableModules(List<Path> modulePath) {
        Set<String> result = null;

        Set<String> addModules = new HashSet<>();
        Set<String> limitModules = new HashSet<>();
        ModuleFinder finder = AppRuntimeImageBuilder.moduleFinder(modulePath, addModules, limitModules);
        Optional<ModuleReference> mref = finder.find(JDK_PACKAGER_MODULE);

        if (mref.isPresent()) {
            ModuleReader reader = null;

            try {
                reader = mref.get().open();
            } catch (IOException ex) {
            }

            if (reader != null) {
                Optional<InputStream> stream = null;

                try {
                    stream = reader.open(LEGACY_JRE_MODULES_FILENAME);
                } catch (IOException ex) {
                }

                if (stream != null) {
                    if (stream.isPresent()) {
                        BufferedReader br = null;

                        try {
                            br = new BufferedReader(new InputStreamReader(stream.get(), "UTF-8"));
                        } catch (UnsupportedEncodingException ex) {
                        }

                        if (br != null) {
                            result = new LinkedHashSet();
                            String line;

                            try {
                                while ((line = br.readLine()) != null) {
                                    String module = stripComments(line);

                                    if (!module.isEmpty()) {
                                        result.add(line);
                                    }
                                }
                            } catch (IOException ex) {
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    public static String getModuleVersion(File moduleFile, List<Path> modulePath, Set<String> addModules, Set<String> limitModules) {
        String result = "";

        Module module = new Module(moduleFile);
        ModuleFinder finder = AppRuntimeImageBuilder.moduleFinder(modulePath, addModules, limitModules);
        Optional<ModuleReference> mref = finder.find(module.getModuleName());

        if (mref.isPresent()) {
            ModuleDescriptor descriptor = mref.get().descriptor();

            if (descriptor != null) {
                Optional<ModuleDescriptor.Version> version = descriptor.version();

                if (version.isPresent()) {
                    result = version.get().toString();
                }
            }
        }

        return result;
    }
}
