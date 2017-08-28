package io.console.test;

import java.io.*;

public class KeyboardInputTest_2 {

	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		
		String line = null;
				
		while( (line =br.readLine()) != null) {
			if(line.equalsIgnoreCase("q") ) {
				System.out.println("Quitting Program...");
				break;
			}
			
			System.out.println("Reading Data :: " + line);
		}
		
		
		ir.close();
		br.close();
	}

}
