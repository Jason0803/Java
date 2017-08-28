package io.console.test;

import java.io.*;

public class FileReadingTest_1 {

	public static void main(String[] args) throws IOException {
		String inputFile = "src/poem.txt";
		String outputFile = "src/result.txt";
		
		BufferedReader br = new BufferedReader(new FileReader(inputFile));
		PrintWriter pw = new PrintWriter(new FileWriter(outputFile));
		System.out.println("result.txt file has been created..");
		
		String line;
		while( (line = br.readLine() ) != null ) {
			pw.println(line);
		}
		
		br.close();
		pw.close();
	}
}
