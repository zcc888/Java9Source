package org.omg.IOP;


/**
* org/omg/IOP/ComponentIdHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /scratch/opt/mach5/mesos/work_dir/slaves/5af44a71-976a-41b7-81de-5773b84ec572-S39643/frameworks/1735e8a2-a1db-478c-8104-60c8b0af87dd-0196/executors/a3f74ad9-294f-4385-b9cc-31da721d8f41/runs/504babbb-611e-4037-9ed3-2563bc56551c/workspace/corba/src/java.corba/share/classes/org/omg/PortableInterceptor/IOP.idl
* Tuesday, December 19, 2017 6:09:04 PM PST
*/


/**
     * Standard way of representing multicomponent profiles.
     * This would be encapsulated in a TaggedProfile.
     */
abstract public class ComponentIdHelper
{
  private static String  _id = "IDL:omg.org/IOP/ComponentId:1.0";

  public static void insert (org.omg.CORBA.Any a, int that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static int extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_ulong);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (org.omg.IOP.ComponentIdHelper.id (), "ComponentId", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static int read (org.omg.CORBA.portable.InputStream istream)
  {
    int value = (int)0;
    value = istream.read_ulong ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, int value)
  {
    ostream.write_ulong (value);
  }

}
