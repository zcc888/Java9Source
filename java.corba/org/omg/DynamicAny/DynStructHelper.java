package org.omg.DynamicAny;


/**
* org/omg/DynamicAny/DynStructHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /scratch/opt/mach5/mesos/work_dir/slaves/5af44a71-976a-41b7-81de-5773b84ec572-S39643/frameworks/1735e8a2-a1db-478c-8104-60c8b0af87dd-0196/executors/a3f74ad9-294f-4385-b9cc-31da721d8f41/runs/504babbb-611e-4037-9ed3-2563bc56551c/workspace/corba/src/java.corba/share/classes/org/omg/DynamicAny/DynamicAny.idl
* Tuesday, December 19, 2017 6:09:03 PM PST
*/


/**
    * DynStruct objects support the manipulation of IDL struct and exception values.
    * Members of the exceptions are handled in the same way as members of a struct.
    */
abstract public class DynStructHelper
{
  private static String  _id = "IDL:omg.org/DynamicAny/DynStruct:1.0";

  public static void insert (org.omg.CORBA.Any a, org.omg.DynamicAny.DynStruct that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static org.omg.DynamicAny.DynStruct extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (org.omg.DynamicAny.DynStructHelper.id (), "DynStruct");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static org.omg.DynamicAny.DynStruct read (org.omg.CORBA.portable.InputStream istream)
  {
      throw new org.omg.CORBA.MARSHAL ();
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, org.omg.DynamicAny.DynStruct value)
  {
      throw new org.omg.CORBA.MARSHAL ();
  }

  public static org.omg.DynamicAny.DynStruct narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof org.omg.DynamicAny.DynStruct)
      return (org.omg.DynamicAny.DynStruct)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      org.omg.DynamicAny._DynStructStub stub = new org.omg.DynamicAny._DynStructStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static org.omg.DynamicAny.DynStruct unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof org.omg.DynamicAny.DynStruct)
      return (org.omg.DynamicAny.DynStruct)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      org.omg.DynamicAny._DynStructStub stub = new org.omg.DynamicAny._DynStructStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
