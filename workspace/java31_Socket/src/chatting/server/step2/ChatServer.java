package chatting.server.step2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	ServerSocket server;
	Socket s;
	BufferedReader br;
	PrintWriter pw;
	
	public void net() throws Exception {
		server = new ServerSocket(5500);
		System.out.println("Server Open..");
		s = server.accept();
		
		System.out.println("Client Connection : " + s.getInetAddress());
		
		String line;
		br = new BufferedReader(new InputStreamReader(s.getInputStream() ));
		pw = new PrintWriter(s.getOutputStream(), true);
		
		while( (line = br.readLine()) != null ) {
			pw.println("Server : " + line);
		}
	
	}
	
	public static void main(String[] args) throws Exception {
		ChatServer cs = new ChatServer();
		cs.net();
		
	}

}
