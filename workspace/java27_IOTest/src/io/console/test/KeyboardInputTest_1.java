package io.console.test;

import java.io.*;

public class KeyboardInputTest_1 {

	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		
		String line = br.readLine();
		
		System.out.println("Reading Data :: " + line);
		ir.close();
		br.close();
	}

}
