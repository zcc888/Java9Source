package org.omg.PortableServer;


/**
* org/omg/PortableServer/ThreadPolicyValue.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /scratch/opt/mach5/mesos/work_dir/slaves/5af44a71-976a-41b7-81de-5773b84ec572-S39643/frameworks/1735e8a2-a1db-478c-8104-60c8b0af87dd-0196/executors/a3f74ad9-294f-4385-b9cc-31da721d8f41/runs/504babbb-611e-4037-9ed3-2563bc56551c/workspace/corba/src/java.corba/share/classes/org/omg/PortableServer/poa.idl
* Tuesday, December 19, 2017 6:09:07 PM PST
*/


/**
	 * The ThreadPolicyValue can have the following values.
	 * ORB_CTRL_MODEL - The ORB is responsible for assigning 
	 * requests for an ORB- controlled POA to threads. 
	 * SINGLE_THREAD_MODEL - Requests for a single-threaded 
	 * POA are processed sequentially. 
	 */
public class ThreadPolicyValue implements org.omg.CORBA.portable.IDLEntity
{
  private        int __value;
  private static int __size = 2;
  private static org.omg.PortableServer.ThreadPolicyValue[] __array = new org.omg.PortableServer.ThreadPolicyValue [__size];

  public static final int _ORB_CTRL_MODEL = 0;
  public static final org.omg.PortableServer.ThreadPolicyValue ORB_CTRL_MODEL = new org.omg.PortableServer.ThreadPolicyValue(_ORB_CTRL_MODEL);
  public static final int _SINGLE_THREAD_MODEL = 1;
  public static final org.omg.PortableServer.ThreadPolicyValue SINGLE_THREAD_MODEL = new org.omg.PortableServer.ThreadPolicyValue(_SINGLE_THREAD_MODEL);

  public int value ()
  {
    return __value;
  }

  public static org.omg.PortableServer.ThreadPolicyValue from_int (int value)
  {
    if (value >= 0 && value < __size)
      return __array[value];
    else
      throw new org.omg.CORBA.BAD_PARAM ();
  }

  protected ThreadPolicyValue (int value)
  {
    __value = value;
    __array[__value] = this;
  }
} // class ThreadPolicyValue
