

(1) For server, 
java file and wsdl files include:

MyBMIAdmin.java   
MyBMIServer.java       
MyBMIAdmin.wsdl   
MyBMIServer.wsdl 


(2) For client,
the client is in clients folder. The only file written manually is
MyBMIClient.java.
Other classes files are executed by AXIS engine.

There is also a test script (Shell Script) under clients folder,
which shows how to use client once the server has been setup.
You need to change the path of axis library if you want to run the
script, since axis library is required to compile the client code.

