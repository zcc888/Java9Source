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

/**
 * Defines the AWT and Swing user interface toolkits, plus APIs for
 * accessibility, audio, imaging, printing, and JavaBeans.
 *
 * @uses java.awt.im.spi.InputMethodDescriptor
 * @uses javax.accessibility.AccessibilityProvider
 * @uses javax.imageio.spi.ImageInputStreamSpi
 * @uses javax.imageio.spi.ImageOutputStreamSpi
 * @uses javax.imageio.spi.ImageReaderSpi
 * @uses javax.imageio.spi.ImageTranscoderSpi
 * @uses javax.imageio.spi.ImageWriterSpi
 * @uses javax.print.PrintServiceLookup
 * @uses javax.print.StreamPrintServiceFactory
 * @uses javax.sound.midi.spi.MidiDeviceProvider
 * @uses javax.sound.midi.spi.MidiFileReader
 * @uses javax.sound.midi.spi.MidiFileWriter
 * @uses javax.sound.midi.spi.SoundbankReader
 * @uses javax.sound.sampled.spi.AudioFileReader
 * @uses javax.sound.sampled.spi.AudioFileWriter
 * @uses javax.sound.sampled.spi.FormatConversionProvider
 * @uses javax.sound.sampled.spi.MixerProvider
 *
 * @moduleGraph
 * @since 9
 */
module java.desktop {
    // source file: file:///scratch/opt/mach5/mesos/work_dir/slaves/5af44a71-976a-41b7-81de-5773b84ec572-S39643/frameworks/1735e8a2-a1db-478c-8104-60c8b0af87dd-0196/executors/a3f74ad9-294f-4385-b9cc-31da721d8f41/runs/504babbb-611e-4037-9ed3-2563bc56551c/workspace/jdk/src/java.desktop/share/classes/module-info.java
    //              file:///scratch/opt/mach5/mesos/work_dir/jib-master/install/javafx/9.0.4/11/bundles/linux-x64/javafx-exports.zip/modules_src/java.desktop/module-info.java.extra
    //              file:///scratch/opt/mach5/mesos/work_dir/slaves/5af44a71-976a-41b7-81de-5773b84ec572-S39643/frameworks/1735e8a2-a1db-478c-8104-60c8b0af87dd-0196/executors/a3f74ad9-294f-4385-b9cc-31da721d8f41/runs/504babbb-611e-4037-9ed3-2563bc56551c/workspace/jdk/src/closed/java.desktop/share/classes/module-info.java.extra
    requires java.prefs;
    requires transitive java.datatransfer;
    requires transitive java.xml;
    exports java.applet;
    exports java.awt;
    exports java.awt.color;
    exports java.awt.desktop;
    exports java.awt.dnd;
    exports java.awt.event;
    exports java.awt.font;
    exports java.awt.geom;
    exports java.awt.im;
    exports java.awt.im.spi;
    exports java.awt.image;
    exports java.awt.image.renderable;
    exports java.awt.print;
    exports java.beans;
    exports java.beans.beancontext;
    exports javax.accessibility;
    exports javax.imageio;
    exports javax.imageio.event;
    exports javax.imageio.metadata;
    exports javax.imageio.plugins.bmp;
    exports javax.imageio.plugins.jpeg;
    exports javax.imageio.plugins.tiff;
    exports javax.imageio.spi;
    exports javax.imageio.stream;
    exports javax.print;
    exports javax.print.attribute;
    exports javax.print.attribute.standard;
    exports javax.print.event;
    exports javax.sound.midi;
    exports javax.sound.midi.spi;
    exports javax.sound.sampled;
    exports javax.sound.sampled.spi;
    exports javax.swing;
    exports javax.swing.border;
    exports javax.swing.colorchooser;
    exports javax.swing.event;
    exports javax.swing.filechooser;
    exports javax.swing.plaf;
    exports javax.swing.plaf.basic;
    exports javax.swing.plaf.metal;
    exports javax.swing.plaf.multi;
    exports javax.swing.plaf.nimbus;
    exports javax.swing.plaf.synth;
    exports javax.swing.table;
    exports javax.swing.text;
    exports javax.swing.text.html;
    exports javax.swing.text.html.parser;
    exports javax.swing.text.rtf;
    exports javax.swing.tree;
    exports javax.swing.undo;
    exports java.awt.dnd.peer to javafx.swing;
    exports sun.awt to
        javafx.swing,
        jdk.accessibility,
        oracle.desktop;
    exports sun.awt.dnd to javafx.swing;
    exports sun.awt.image to javafx.swing;
    exports sun.font.lookup to javafx.graphics;
    exports sun.java2d to
        javafx.swing,
        oracle.desktop;
    exports sun.print to javafx.graphics;
    exports sun.swing to javafx.swing;
    opens com.sun.java.swing.plaf.windows to jdk.jconsole;
    opens javax.swing.plaf.basic to jdk.jconsole;

    uses java.awt.im.spi.InputMethodDescriptor;
    uses javax.accessibility.AccessibilityProvider;
    uses javax.imageio.spi.ImageInputStreamSpi;
    uses javax.imageio.spi.ImageOutputStreamSpi;
    uses javax.imageio.spi.ImageReaderSpi;
    uses javax.imageio.spi.ImageTranscoderSpi;
    uses javax.imageio.spi.ImageWriterSpi;
    uses javax.print.PrintServiceLookup;
    uses javax.print.StreamPrintServiceFactory;
    uses javax.sound.midi.spi.MidiDeviceProvider;
    uses javax.sound.midi.spi.MidiFileReader;
    uses javax.sound.midi.spi.MidiFileWriter;
    uses javax.sound.midi.spi.SoundbankReader;
    uses javax.sound.sampled.spi.AudioFileReader;
    uses javax.sound.sampled.spi.AudioFileWriter;
    uses javax.sound.sampled.spi.FormatConversionProvider;
    uses javax.sound.sampled.spi.MixerProvider;
    provides java.net.ContentHandlerFactory with sun.awt.www.content.MultimediaContentHandlers;
    provides javax.print.PrintServiceLookup with sun.print.PrintServiceLookupProvider;
    provides javax.print.StreamPrintServiceFactory with sun.print.PSStreamPrinterFactory;
    provides javax.sound.midi.spi.MidiDeviceProvider with
        com.sun.media.sound.MidiInDeviceProvider,
        com.sun.media.sound.MidiOutDeviceProvider,
        com.sun.media.sound.RealTimeSequencerProvider,
        com.sun.media.sound.SoftProvider;
    provides javax.sound.midi.spi.MidiFileReader with com.sun.media.sound.StandardMidiFileReader;
    provides javax.sound.midi.spi.MidiFileWriter with com.sun.media.sound.StandardMidiFileWriter;
    provides javax.sound.midi.spi.SoundbankReader with
        com.sun.media.sound.AudioFileSoundbankReader,
        com.sun.media.sound.DLSSoundbankReader,
        com.sun.media.sound.JARSoundbankReader,
        com.sun.media.sound.SF2SoundbankReader;
    provides javax.sound.sampled.spi.AudioFileReader with
        com.sun.media.sound.AiffFileReader,
        com.sun.media.sound.AuFileReader,
        com.sun.media.sound.SoftMidiAudioFileReader,
        com.sun.media.sound.WaveFileReader,
        com.sun.media.sound.WaveFloatFileReader,
        com.sun.media.sound.WaveExtensibleFileReader;
    provides javax.sound.sampled.spi.AudioFileWriter with
        com.sun.media.sound.AiffFileWriter,
        com.sun.media.sound.AuFileWriter,
        com.sun.media.sound.WaveFileWriter,
        com.sun.media.sound.WaveFloatFileWriter;
    provides javax.sound.sampled.spi.FormatConversionProvider with
        com.sun.media.sound.AlawCodec,
        com.sun.media.sound.AudioFloatFormatConverter,
        com.sun.media.sound.PCMtoPCMCodec,
        com.sun.media.sound.UlawCodec;
    provides javax.sound.sampled.spi.MixerProvider with
        com.sun.media.sound.DirectAudioDeviceProvider,
        com.sun.media.sound.PortMixerProvider;
    provides sun.datatransfer.DesktopDatatransferService with sun.awt.datatransfer.DesktopDatatransferServiceImpl;
}
