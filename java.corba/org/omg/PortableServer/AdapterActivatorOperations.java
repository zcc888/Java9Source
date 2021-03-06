package org.omg.PortableServer;


/**
* org/omg/PortableServer/AdapterActivatorOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /scratch/opt/mach5/mesos/work_dir/slaves/5af44a71-976a-41b7-81de-5773b84ec572-S39643/frameworks/1735e8a2-a1db-478c-8104-60c8b0af87dd-0196/executors/a3f74ad9-294f-4385-b9cc-31da721d8f41/runs/504babbb-611e-4037-9ed3-2563bc56551c/workspace/corba/src/java.corba/share/classes/org/omg/PortableServer/poa.idl
* Tuesday, December 19, 2017 6:09:07 PM PST
*/


/**
	 * An adapter activator supplies a POA with the ability 
	 * to create child POAs on demand, as a side-effect of 
	 * receiving a request that names the child POA 
	 * (or one of its children), or when find_POA is called 
	 * with an activate parameter value of TRUE.
	 */
public interface AdapterActivatorOperations 
{

  /**
  	 * This operation is invoked when the ORB receives 
  	 * a request for an object reference that identifies 
  	 * a target POA that does not exist. The ORB invokes 
  	 * this operation once for each POA that must be 
  	 * created in order for the target POA to exist.
  	 * @param parent indicates the parent POA for the POA
  	 *               that needs to be created.
  	 * @param name identifies the name of the POA relative to
  	 *             the parent.
  	 * @return returns TRUE if the POA was created or FALSE
  	 *         otherwise.
  	 */
  boolean unknown_adapter (org.omg.PortableServer.POA parent, String name);
} // interface AdapterActivatorOperations
