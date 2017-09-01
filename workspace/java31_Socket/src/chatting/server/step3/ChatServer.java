package chatting.server.step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


class ServerThread extends Thread {
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw;
	private ChatServer cs;
	
	public ServerThread (Socket socket, ChatServer cs) {
		try {
			this.socket = socket;
			this.cs = cs;
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream());
			
			System.out.println(socket.getInetAddress() + "Has connected !");
			cs.broadcast(socket.getInetAddress() + "Has connected !");
			
		} catch (Exception e) {	}
	}

	public Socket getSocket() {
		return this.socket;
	}
	
	public void sendMessage(String str) {
		pw.println(str);
	}

	
	@Override
	public void run() {
		String msg;
		try {
			while ((msg = br.readLine()) !=null){ 
				cs.broadcast(msg);
			}
		} catch (Exception e) {
			System.out.println(socket.getInetAddress() + "Has disconnected !");
			cs.broadcast(socket.getInetAddress() + "Has disconnected !");
			cs.deleteThread(this);
		}
		
	}
	
}

public class ChatServer {
	ServerSocket server;
	Socket socket;
	ArrayList<ServerThread> ths; // = 
	ArrayList<Integer> ints = new ArrayList<Integer>();
	
	public ChatServer() {
		ths = new ArrayList<ServerThread>();
	}
	
	public void addThread(ServerThread st) {
		ths.add(st);
	}
	
	public void deleteThread(ServerThread st) {
		ths.remove(st);
	}
	
	public void broadcast(String message) {
		for(ServerThread st : ths) {
			st.sendMessage(message);
		}
	}
	
	public void net() throws Exception {
		server = new ServerSocket(60000);
		System.out.println("Server Open..");
		
		while(true) {
			socket = server.accept();
			ServerThread thread = new ServerThread(socket, this);
			this.addThread(thread);
		}
		
		// System.out.println("Client Connection : " + s.getInetAddress());
			
		
		// br = new BufferedReader(new InputStreamReader(s.getInputStream() ));
		// pw = new PrintWriter(s.getOutputStream(), true);
			
		/*
			while( (line = br.readLine()) != null ) {
				pw.println("Server : " + line);
			}
		*/
		
	}
	
	
		
	public static void main(String[] args) throws Exception {
		ChatServer cs = new ChatServer();
		cs.net();
			
	}
}
