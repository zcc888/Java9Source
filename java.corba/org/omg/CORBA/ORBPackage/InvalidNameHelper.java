/*
 * Copyright (c) 2014, 2017, Oracle and/or its affiliates. All rights reserved.
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

package org.omg.CORBA.ORBPackage;


/**
 * This Helper class is used to facilitate the marshalling of
 * {@code ORBPackage/InvalidName}.
 * For more information on Helper files, see
 * <a href="{@docRoot}/org/omg/CORBA/doc-files/generatedfiles.html#helper">
 * "Generated Files: Helper Files"</a>.
 */

abstract public class InvalidNameHelper
{
  private static String  _id = "IDL:omg.org.CORBA/ORB/InvalidName:1.0";

  public static void insert (org.omg.CORBA.Any a, org.omg.CORBA.ORBPackage.InvalidName that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static org.omg.CORBA.ORBPackage.InvalidName extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [0];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          __typeCode = org.omg.CORBA.ORB.init ().create_exception_tc (org.omg.CORBA.ORBPackage.InvalidNameHelper.id (), "InvalidName", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static org.omg.CORBA.ORBPackage.InvalidName read (org.omg.CORBA.portable.InputStream istream)
  {
    org.omg.CORBA.ORBPackage.InvalidName value = new org.omg.CORBA.ORBPackage.InvalidName ();
    // read and discard the repository ID
    istream.read_string ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, org.omg.CORBA.ORBPackage.InvalidName value)
  {
    // write the repository ID
    ostream.write_string (id ());
  }

}
