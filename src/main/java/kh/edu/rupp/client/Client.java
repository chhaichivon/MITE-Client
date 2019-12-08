package kh.edu.rupp.client;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * @author Chhai Chivon on Dec 8, 2019
 * Senior Software Developer
 */

public class Client {
	public static void main(String[] args) {
		try {
			//start connect server
			Socket socket  = new Socket("localhost",1234);
			
			//Prepare for write
			OutputStream  outputStream  = socket.getOutputStream();
			OutputStreamWriter  outputStreamWriter  = new OutputStreamWriter(outputStream);
			
			String message = "sum#=>1,2"+"\n";
			outputStreamWriter.write(message);
			outputStreamWriter.flush();
			
			//Response from server
			InputStream  inputStream = socket.getInputStream();
			Scanner scanner  = new Scanner(inputStream);
			while (scanner.hasNext()) {
				String response  = scanner.nextLine();
				System.out.println("response "+response);
			}
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
