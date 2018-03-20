/*
 * Copyright (c) 1999, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.media.sound;

import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;

/**
 * MidiOutDevice class representing functionality of MidiOut devices.
 *
 * @author David Rivas
 * @author Kara Kytle
 * @author Florian Bomers
 */
final class MidiOutDevice extends AbstractMidiDevice {

    MidiOutDevice(AbstractMidiDeviceProvider.Info info) {
                super(info);
                if(Printer.trace) Printer.trace("MidiOutDevice CONSTRUCTOR");
    }

    @Override
    protected synchronized void implOpen() throws MidiUnavailableException {
        if (Printer.trace) Printer.trace("> MidiOutDevice: implOpen()");
        int index = ((AbstractMidiDeviceProvider.Info)getDeviceInfo()).getIndex();
        id = nOpen(index); // can throw MidiUnavailableException
        if (id == 0) {
            throw new MidiUnavailableException("Unable to open native device");
        }
        if (Printer.trace) Printer.trace("< MidiOutDevice: implOpen(): completed.");
    }

    @Override
    protected synchronized void implClose() {
        if (Printer.trace) Printer.trace("> MidiOutDevice: implClose()");
        // prevent further action
        long oldId = id;
        id = 0;

        super.implClose();

        // close the device
        nClose(oldId);
        if (Printer.trace) Printer.trace("< MidiOutDevice: implClose(): completed");
    }

    @Override
    public long getMicrosecondPosition() {
        long timestamp = -1;
        if (isOpen()) {
            timestamp = nGetTimeStamp(id);
        }
        return timestamp;
    }

    /** Returns if this device supports Receivers.
        This implementation always returns true.
        @return true, if the device supports Receivers, false otherwise.
    */
    @Override
    protected boolean hasReceivers() {
        return true;
    }

    @Override
    protected Receiver createReceiver() {
        return new MidiOutReceiver();
    }

    final class MidiOutReceiver extends AbstractReceiver {

        @Override
        void implSend(final MidiMessage message, final long timeStamp) {
            final int length = message.getLength();
            final int status = message.getStatus();
            if (length <= 3 && status != 0xF0 && status != 0xF7) {
                int packedMsg;
                if (message instanceof ShortMessage) {
                    if (message instanceof FastShortMessage) {
                        packedMsg = ((FastShortMessage) message).getPackedMsg();
                    } else {
                        ShortMessage msg = (ShortMessage) message;
                        packedMsg = (status & 0xFF)
                            | ((msg.getData1() & 0xFF) << 8)
                            | ((msg.getData2() & 0xFF) << 16);
                    }
                } else {
                    packedMsg = 0;
                    byte[] data = message.getMessage();
                    if (length>0) {
                        packedMsg = data[0] & 0xFF;
                        if (length>1) {
                            /* We handle meta messages here. The message
                               system reset (FF) doesn't get until here,
                               because it's length is only 1. So if we see
                               a status byte of FF, it's sure that we
                               have a Meta message. */
                            if (status == 0xFF) {
                                return;
                            }
                            packedMsg |= (data[1] & 0xFF) << 8;
                            if (length>2) {
                                packedMsg |= (data[2] & 0xFF) << 16;
                            }
                        }
                    }
                }
                nSendShortMessage(id, packedMsg, timeStamp);
            } else {
                final byte[] data;
                if (message instanceof FastSysexMessage) {
                    data = ((FastSysexMessage) message).getReadOnlyMessage();
                } else {
                    data = message.getMessage();
                }
                final int dataLength = Math.min(length, data.length);
                if (dataLength > 0) {
                    nSendLongMessage(id, data, dataLength, timeStamp);
                }
            }
        }

        /** shortcut for the Sun implementation */
        synchronized void sendPackedMidiMessage(int packedMsg, long timeStamp) {
            if (isOpen() && id != 0) {
                nSendShortMessage(id, packedMsg, timeStamp);
            }
        }
    } // class MidiOutReceiver

    private native long nOpen(int index) throws MidiUnavailableException;
    private native void nClose(long id);

    private native void nSendShortMessage(long id, int packedMsg, long timeStamp);
    private native void nSendLongMessage(long id, byte[] data, int size, long timeStamp);
    private native long nGetTimeStamp(long id);

} // class MidiOutDevice
