package io.console.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamTest_5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filenName = "src/poem.txt";
		String fileName2 = "src/poem2.txt";
		
		FileInputStream fis = new FileInputStream(filenName);
		DataInputStream dis = new DataInputStream(fis);
		
		FileOutputStream fos = new FileOutputStream(fileName2);
		DataOutputStream dos = new DataOutputStream(fos);
		
		int data = 0;
		while( (data = dis.read()) != -1 ) {
			dos.write((char)data);
		}
		
	}

}
