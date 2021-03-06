package io.file3.self.java;

import java.io.*;
import java.util.*;

public class IOProb1{
	public static void main(String[] args)throws Exception{
		String fileName = "src/data/score.txt";
		InputStreamReader is = new InputStreamReader(new FileInputStream(fileName), "UTF-8");
		BufferedReader br = new BufferedReader(is);
		
		OutputStreamWriter sw = new OutputStreamWriter(new FileOutputStream(fileName, true));
		
		
		/* Read all the lines from given file */
		int lineCount = 0;
		int sum = 0;
		double avg = 0.0;
		
		String line = br.readLine();
		String temp = "";
		ArrayList<Integer> scores = new ArrayList<Integer>();
		
		while( line != null ){
			temp = line.substring(line.indexOf(':')+1);
			scores.add(Integer.parseInt(temp));
			lineCount++;
			line = br.readLine();
		}
		
		System.out.println(scores);
		
		
		for(int score : scores) {
			sum += score;
		}
		
		avg = (sum/lineCount);
		
		sw.write("\n총점 : " + sum);
		sw.write("\n평균 : " + avg);
		
		
		sw.close();
	}
}  