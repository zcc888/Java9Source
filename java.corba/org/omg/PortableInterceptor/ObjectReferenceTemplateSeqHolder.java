package org.omg.PortableInterceptor;


/**
* org/omg/PortableInterceptor/ObjectReferenceTemplateSeqHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /scratch/opt/mach5/mesos/work_dir/slaves/5af44a71-976a-41b7-81de-5773b84ec572-S39643/frameworks/1735e8a2-a1db-478c-8104-60c8b0af87dd-0196/executors/a3f74ad9-294f-4385-b9cc-31da721d8f41/runs/504babbb-611e-4037-9ed3-2563bc56551c/workspace/corba/src/java.corba/share/classes/org/omg/PortableInterceptor/Interceptors.idl
* Tuesday, December 19, 2017 6:09:05 PM PST
*/


/** Sequence of object reference templates is used for reporting state
   * changes that do not occur on the adapter manager.
   */
public final class ObjectReferenceTemplateSeqHolder implements org.omg.CORBA.portable.Streamable
{
  public org.omg.PortableInterceptor.ObjectReferenceTemplate value[] = null;

  public ObjectReferenceTemplateSeqHolder ()
  {
  }

  public ObjectReferenceTemplateSeqHolder (org.omg.PortableInterceptor.ObjectReferenceTemplate[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = org.omg.PortableInterceptor.ObjectReferenceTemplateSeqHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    org.omg.PortableInterceptor.ObjectReferenceTemplateSeqHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return org.omg.PortableInterceptor.ObjectReferenceTemplateSeqHelper.type ();
  }

}
