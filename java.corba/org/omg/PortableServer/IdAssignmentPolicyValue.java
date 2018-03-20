package org.omg.PortableServer;


/**
* org/omg/PortableServer/IdAssignmentPolicyValue.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /scratch/opt/mach5/mesos/work_dir/slaves/5af44a71-976a-41b7-81de-5773b84ec572-S39643/frameworks/1735e8a2-a1db-478c-8104-60c8b0af87dd-0196/executors/a3f74ad9-294f-4385-b9cc-31da721d8f41/runs/504babbb-611e-4037-9ed3-2563bc56551c/workspace/corba/src/java.corba/share/classes/org/omg/PortableServer/poa.idl
* Tuesday, December 19, 2017 6:09:07 PM PST
*/


/**
	 * The IdAssignmentPolicyValue can have the following
	 * values. USER_ID - Objects created with that POA are 
	 * assigned Object Ids only by the application. 
	 *  SYSTEM_ID - Objects created with that POA are 
	 * assigned Object Ids only by the POA. If the POA also 
	 * has the PERSISTENT policy, assigned Object Ids must 
	 * be unique across all instantiations of the same POA.
	 */
public class IdAssignmentPolicyValue implements org.omg.CORBA.portable.IDLEntity
{
  private        int __value;
  private static int __size = 2;
  private static org.omg.PortableServer.IdAssignmentPolicyValue[] __array = new org.omg.PortableServer.IdAssignmentPolicyValue [__size];

  public static final int _USER_ID = 0;
  public static final org.omg.PortableServer.IdAssignmentPolicyValue USER_ID = new org.omg.PortableServer.IdAssignmentPolicyValue(_USER_ID);
  public static final int _SYSTEM_ID = 1;
  public static final org.omg.PortableServer.IdAssignmentPolicyValue SYSTEM_ID = new org.omg.PortableServer.IdAssignmentPolicyValue(_SYSTEM_ID);

  public int value ()
  {
    return __value;
  }

  public static org.omg.PortableServer.IdAssignmentPolicyValue from_int (int value)
  {
    if (value >= 0 && value < __size)
      return __array[value];
    else
      throw new org.omg.CORBA.BAD_PARAM ();
  }

  protected IdAssignmentPolicyValue (int value)
  {
    __value = value;
    __array[__value] = this;
  }
} // class IdAssignmentPolicyValue
