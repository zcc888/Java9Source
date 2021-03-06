package org.omg.CosNaming;


/**
* org/omg/CosNaming/NameHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /scratch/opt/mach5/mesos/work_dir/slaves/5af44a71-976a-41b7-81de-5773b84ec572-S39643/frameworks/1735e8a2-a1db-478c-8104-60c8b0af87dd-0196/executors/a3f74ad9-294f-4385-b9cc-31da721d8f41/runs/504babbb-611e-4037-9ed3-2563bc56551c/workspace/corba/src/java.corba/share/classes/org/omg/CosNaming/nameservice.idl
* Tuesday, December 19, 2017 6:09:02 PM PST
*/


/**
   * A name is a sequence of name components.
   */
abstract public class NameHelper
{
  private static String  _id = "IDL:omg.org/CosNaming/Name:1.0";

  public static void insert (org.omg.CORBA.Any a, org.omg.CosNaming.NameComponent[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static org.omg.CosNaming.NameComponent[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CosNaming.NameComponentHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (org.omg.CosNaming.NameHelper.id (), "Name", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static org.omg.CosNaming.NameComponent[] read (org.omg.CORBA.portable.InputStream istream)
  {
    org.omg.CosNaming.NameComponent value[] = null;
    int _len0 = istream.read_long ();
    value = new org.omg.CosNaming.NameComponent[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = org.omg.CosNaming.NameComponentHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, org.omg.CosNaming.NameComponent[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      org.omg.CosNaming.NameComponentHelper.write (ostream, value[_i0]);
  }

}
