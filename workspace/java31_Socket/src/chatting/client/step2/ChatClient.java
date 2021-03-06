package chatting.client.step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
	Socket socket;
	BufferedReader br, br2;
	PrintWriter pw;
	
	public void net() throws UnknownHostException, IOException {
		socket = new Socket("192.168.0.102", 60000);
		
		System.out.println("Hello Server !");
		
		br = new BufferedReader(new InputStreamReader(System.in));
		br2 = new BufferedReader(new InputStreamReader(socket.getInputStream()) );
		pw = new PrintWriter(socket.getOutputStream(),true);
		
		String line;
		while((line = br.readLine()) != null) {
			pw.println("Jason : " + line);
			System.out.println(br2.readLine());
		}
		br.close();
		pw.close();
		br2.close();
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		ChatClient cClient = new ChatClient();
		cClient.net();

	}

}
