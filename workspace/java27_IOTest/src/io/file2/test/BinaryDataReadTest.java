package io.file2.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryDataReadTest {

	public static void main(String[] args) {
		String fileName = "src/io/file2/test/watermelon.png";
		String outFileName = "src/io/file2/test/melon.png";
		
		// 1. Streams
		try {
			DataInputStream dis = new DataInputStream(new FileInputStream(fileName));
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(outFileName));
			
			// 2. readInt()
			int line = 0;
			while( (line = dis.readInt()) != -1) {
				dos.writeInt(line);
			}
			
			// 3. outFile 
			dos.close();
		} catch (EOFException eofe) {
			System.out.println(eofe.getMessage());
			
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}

}
