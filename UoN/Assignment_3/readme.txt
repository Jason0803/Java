*To run the DemoServer & DemoClient,

open Terminal (or cmd) and

1. orbd -ORBInitialPort <port number> -ORBInitialHost localhost
2. To run server:
	java DemoServer -ORBInitialPort 2287 -ORBInitialHost localhost

3. To run client:
	java DemoClient -ORBInitialPort 2287 -ORBInitialHost localhost

4. In the running time,

there will be 5 seconds of pause after ‘Call to server’ when deferred synchronous
interaction.