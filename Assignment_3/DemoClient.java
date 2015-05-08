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

public class DemoClient
{
    static Demo DemoImpl;
    static int i=1;
    static char var='*'; // the variable for first 5 iteratoins


    // -------------------------------------------------------------------------------------//
    // threads used for implementation of deffered sync. and async.
    
	// ThreadDemo = for deffered sync.
    public static class ThreadDemo extends Thread 
    {
	    private Thread t;
	    private String threadName;
	    private String args[];

	   	// Constructor
	    ThreadDemo( String name, String a[])
	    {
	       threadName = name;
		   args=a;
	    }
	    // ---------------------------------------------------------------------------------//
	    public void run()
	    {
	    	try
	    	{
	    		System.out.println("Demonstrating deferred synchronous interaction");

	    		var = '*';

	    		for(i=1; i<6; i++)
	    		{
	    			System.out.println(i+".   value is "+var);
	    		}

	    		System.out.println("Call to server");
	    		// 5 iteration to print random char
	    		// after 5 secs
	    		Thread.sleep(5000);

	    		// bring random character from server
	    		char temp = DemoImpl.randomChar();
	    		
	    		for(i=6; i<11; i++)
	    		{
	    			System.out.println(i+".   value is "+var);
	    		}

	    		var = temp;

	    		System.out.println("Fetch the response");
	    		for(i=11; i<16; i++)
	    		{
	    			System.out.println(i+".   value is "+var);
	    		}

	    	}
	    		catch(Exception e)
	    		{ System.out.println("exception"); }   	
	    }
	}
	// -------------------------------------------------------------------------------------------//
		// ThreadDemo2 = for async.
	    public static class ThreadDemo2 extends Thread
	    {
	    	private Thread t;
	    	private String threadName;
	    	

	    	// Constructor
	    	ThreadDemo2( String name )
	    	{
	    		threadName = name;
	    	}
	    	// -----------------------------------------------------------------------------------//
	    	public void run()
	    	{
	    		try
	    		{
	    			var = '*';
	    			int rndNumber = (int)(Math.random()*10)+10;

	    			System.out.println("Demonstrating asynchronous interaction");
	    			for(i=1; i<6; i++)
	    			{
	    				System.out.println(i+".   value is "+var);
	    			}
	    			System.out.println("Call to server");
	    			char temp = DemoImpl.randomChar();

	    			// indeterminate number of iteration
	    			while(i < rndNumber)
	    			{
	    				System.out.println(i+".   value is "+var);
	    				i++;
	    			}

	    			var = temp;
	    			System.out.println("Response Ready");
	    			for(int j=i; j<i+5; j++)
	    			{
	    				System.out.println(j+".   value is "+var);
	    			}

	    		}
	    		catch(Exception e)
	    		{ System.out.println("exception"); }
	    	}
	    }
// ----------------------------------End of Thread Implementation---------------------------------//
	public static void main(String args[])
	{
		char var='*';
		try
		{
		    ORB orb = ORB.init(args, null);
			org.omg.CORBA.Object objRef =
			    orb.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
			String namea = "Demo";
			DemoImpl = DemoHelper.narrow(ncRef.resolve_str(namea));


			// 1. Synchronous interaction
			System.out.println("Demonstrating synchronous interaction");

			for(i=1;i<6;i++)
			{
				System.out.println(i+".   value is "+var);
			}
			System.out.println("Call to server");

			// fetch result from server
        	var=DemoImpl.randomChar();
			for(i=6;i<11;i++)
			{
				System.out.println(i+".   value is "+var);
			}

			// 2. Deferred synchrnous interaction
			ThreadDemo T1 = new ThreadDemo("Thread_1", args);
			T1.run();

			// 3. Asynchronous interaction
			ThreadDemo2 T2 = new ThreadDemo2("Thread_2");
			T2.run();

			// shutdown
			DemoImpl.shutdown();
		}
		catch(Exception e)
		{
			System.out.println("Error: "+e);
			e.printStackTrace(System.out);
		}
	}
}