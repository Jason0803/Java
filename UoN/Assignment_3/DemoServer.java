/*
 * Name: Soo Young Choi
 * StdNo: 3171700
 * Course: SENG3400
 * Assignment title: Assignment 3
 * Due date: 31/10/2014
 */

import DemoApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

import java.util.Properties;

class DemoImpl extends DemoPOA {
  private ORB orb;

  public void setORB(ORB orb_val) {
    orb = orb_val; 
  }
  
  
  // implement randomChar() method
  public char randomChar() {
    int rnd = (int) (Math.random() * 52); // low-case 26 + uppercase 26
    char base = (rnd < 26) ? 'A' : 'a';
    return (char) (base + rnd % 26);
  }
    
  // implement shutdown() method
  public void shutdown() {
    orb.shutdown(false);
  }
}


public class DemoServer {

  public static void main(String args[]) {
    try{
      // create and initialize the ORB
      ORB orb = ORB.init(args, null);

      // get reference to rootpoa and activate the POAManager
      POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
      rootpoa.the_POAManager().activate();

      // create servant and register it with the ORB
      DemoImpl DemoImpl = new DemoImpl();
      DemoImpl.setORB(orb); 

      // get object reference from the servant
      org.omg.CORBA.Object ref = rootpoa.servant_to_reference(DemoImpl);
      Demo href = DemoHelper.narrow(ref);
          
      // get the root naming context
      org.omg.CORBA.Object objRef =
          orb.resolve_initial_references("NameService");
      // Use NamingContextExt which is part of the Interoperable
      // Naming Service (INS) specification.
      NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

      // bind the Object Reference in Naming
      String name = "Demo";
      NameComponent path[] = ncRef.to_name( name );
      ncRef.rebind(path, href);

      System.out.println("DemoServer ready and waiting ...");

      // wait for invocations from clients
      orb.run();
    } 
        
      catch (Exception e) {
        System.err.println("ERROR: " + e);
        e.printStackTrace(System.out);
      }
          
      System.out.println("DemoServer Exiting ...");
        
  }
}