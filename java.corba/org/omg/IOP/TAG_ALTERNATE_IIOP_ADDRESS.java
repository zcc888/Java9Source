package org.omg.IOP;


/**
* org/omg/IOP/TAG_ALTERNATE_IIOP_ADDRESS.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /scratch/opt/mach5/mesos/work_dir/slaves/5af44a71-976a-41b7-81de-5773b84ec572-S39643/frameworks/1735e8a2-a1db-478c-8104-60c8b0af87dd-0196/executors/a3f74ad9-294f-4385-b9cc-31da721d8f41/runs/504babbb-611e-4037-9ed3-2563bc56551c/workspace/corba/src/java.corba/share/classes/org/omg/PortableInterceptor/IOP.idl
* Tuesday, December 19, 2017 6:09:04 PM PST
*/

public interface TAG_ALTERNATE_IIOP_ADDRESS
{

  /**
       * In cases where the same object key is used for more than one 
       * internet location, the following standard IOR Component is defined 
       * for support in IIOP version 1.2. 
       * <p>
       * The <code>TAG_ALTERNATE_IIOP_ADDRESS</code> component has an 
       * associated value of type:
       * <pre>
       *   <code>
       *     struct { 
       *         string HostID, 
       *         short Port 
       *     };
       *   </code>
       * </pre>
       * encoded as a CDR encapsulation. 
       * <p>
       * Zero or more instances of the <code>TAG_ALTERNATE_IIOP_ADDRESS</code> 
       * component type may be included in a version 1.2 
       * <code>TAG_INTERNET_IOP</code> Profile. Each of these alternative 
       * addresses may be used by the client orb, in addition to the host 
       * and port address expressed in the body of the Profile. In cases 
       * where one or more <code>TAG_ALTERNATE_IIOP_ADDRESS</code> components 
       * are present in a <code>TAG_INTERNET_IOP</code> Profile, no order of 
       * use is prescribed by Version 1.2 of IIOP.
       */
  public static final int value = (int)(3L);
}
