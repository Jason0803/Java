package broker.three.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import config.DBConfig;

public class ProtocolHandler extends Thread {
	ServerSocket server;
	Socket s;
	JuryThread jury;
	Database db;
	
	public static final int MIDDLE_PORT = 60000;
	ProtocolHandler(String serverIp) {
		try {
			server = new ServerSocket(MIDDLE_PORT);
			db = new Database(serverIp);
			
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	public void run() {
		while(true) {
			try {
				s = server.accept();
				jury = new JuryThread(s,db);
				jury.start();
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void main(String[] args) {
		ProtocolHandler handler = new ProtocolHandler("127.0.0.1");
		handler.start();
	}
}
