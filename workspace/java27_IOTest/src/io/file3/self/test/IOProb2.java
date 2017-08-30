package io.file3.self.test;

import java.io.*;
import java.util.ArrayList;
public class IOProb2 {
	public static void main(String[] args) throws Exception {
		String fileName = "src/data/data.txt";
		System.out.println("<< world 가 들어있는 라인 >>");
		searchWord(fileName, "world");
		System.out.println("<< you 가 들어있는 라인 >>");
		searchWord(fileName, "you");
	}

	private static void searchWord(String fileName, String searchKeyword) throws Exception{
		
		InputStreamReader is = new InputStreamReader(new FileInputStream(fileName), "UTF-8");
		BufferedReader br = new BufferedReader(is);
		
		//OutputStreamWriter sw = new OutputStreamWriter(new FileOutputStream(fileName, true));
		
		int lineCount = 0;
		int sum = 0;
		double avg = 0.0;
		
		String line; 
		
		while( (line = br.readLine()) != null ){
			lineCount++;
			if(line.contains(searchKeyword)) {
				System.out.println(lineCount + "-Line");
			}
		}
		

	}
}