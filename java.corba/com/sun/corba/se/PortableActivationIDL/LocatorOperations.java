package com.sun.corba.se.PortableActivationIDL;


/**
* com/sun/corba/se/PortableActivationIDL/LocatorOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /scratch/opt/mach5/mesos/work_dir/slaves/5af44a71-976a-41b7-81de-5773b84ec572-S39643/frameworks/1735e8a2-a1db-478c-8104-60c8b0af87dd-0196/executors/a3f74ad9-294f-4385-b9cc-31da721d8f41/runs/504babbb-611e-4037-9ed3-2563bc56551c/workspace/corba/src/java.corba/share/classes/com/sun/corba/se/PortableActivationIDL/activation.idl
* Tuesday, December 19, 2017 6:09:01 PM PST
*/

public interface LocatorOperations 
{

  /** locate server - returns the port with a specific type for all registered
  	* ORBs of an active server.
  	* Starts the server if it is not already running.
  	*/
  com.sun.corba.se.PortableActivationIDL.LocatorPackage.ServerLocationPerType locateServer (String serverId, String endPoint) throws com.sun.corba.se.PortableActivationIDL.NoSuchEndPoint, com.sun.corba.se.PortableActivationIDL.ServerNotRegistered, com.sun.corba.se.PortableActivationIDL.ServerHeldDown;

  /** locate server - returns all ports registered with a specified ORB for
  	* an active server
  	* Starts the server if it is not already running.
  	*/
  com.sun.corba.se.PortableActivationIDL.LocatorPackage.ServerLocationPerORB locateServerForORB (String serverId, String orbId) throws com.sun.corba.se.PortableActivationIDL.InvalidORBid, com.sun.corba.se.PortableActivationIDL.ServerNotRegistered, com.sun.corba.se.PortableActivationIDL.ServerHeldDown;

  /** get the port for the endpoint of the locator
  	*/
  int getEndpoint (String endPointType) throws com.sun.corba.se.PortableActivationIDL.NoSuchEndPoint;

  /** Useful from external BadServerIdHandlers which need
  	* to pick a particular port type.
  	*/
  int getServerPortForType (com.sun.corba.se.PortableActivationIDL.LocatorPackage.ServerLocationPerORB location, String endPointType) throws com.sun.corba.se.PortableActivationIDL.NoSuchEndPoint;
} // interface LocatorOperations
