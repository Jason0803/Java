package chatting.server.step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


class ReceiveThread extends Thread {
	Socket socket;
	BufferedReader br;
	// PrintWriter pw;
	//ChatClient cClient;
	
	
	public ReceiveThread(Socket socket) {
		System.out.println("Client Thread Created !");
		this.socket = socket;
		
		try {
			this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
		} catch (Exception e) {
			
		}
	}
	
	public void run() {
		try {
			while(true) {
				System.out.println("Server :: " + br.readLine());
			}
		} catch(Exception e) {
			
		}
	}
	
}

public class ChatClient {
	Socket socket;
	BufferedReader br;
	PrintWriter pw;
	ReceiveThread rth;
	
	public void net() throws UnknownHostException, IOException {
		socket = new Socket("192.168.0.102", 60000);
		System.out.println("Client Socket Created !!");
		
		br = new BufferedReader(new InputStreamReader(System.in));
		// br2 = new BufferedReader(new InputStreamReader(socket.getInputStream()) );
		pw = new PrintWriter(socket.getOutputStream(),true);
		System.out.println("Stream Created !");
		
		rth = new ReceiveThread(socket);
		rth.start();
		
		String line;
		while((line = br.readLine()) != null) {
			pw.println("Jason : " + line);
			
			// System.out.println(br2.readLine());
		}
		br.close();
		pw.close();
		// br2.close();
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		ChatClient cClient = new ChatClient();
		cClient.net();

	}

}
