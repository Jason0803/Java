package chatting.client.step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
	Socket socket;
	BufferedReader br;
	PrintWriter pw;
	
	public void net() throws UnknownHostException, IOException {
		socket = new Socket("127.0.0.1", 5500);
		
		System.out.println("Hello Server !");
		
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(socket.getOutputStream(),true);
		
		String line;
		while((line = br.readLine()) != null) {
			pw.println(line);
		}
		br.close();
		pw.close();
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ChatClient cClient = new ChatClient();
		cClient.net();
	}

}
