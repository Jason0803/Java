package chatting.server.step1;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;

public class ChatServer {
	ServerSocket server;
	Socket s;
	BufferedReader br;
	
	public void net() throws IOException {
		server = new ServerSocket(5500);
		System.out.println("Server Ready ..");
		
		s = server.accept();
		System.out.println("Client Connection...");
		
		String line;
		br = new BufferedReader(new InputStreamReader(s.getInputStream() ));
		
		while( (line = br.readLine()) != null ) {
			System.out.println(line);
		}
		br.close();
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		ChatServer cServ = new ChatServer();
		cServ.net();
	}
	


}
