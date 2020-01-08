package com.ict.edu3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SendThread implements Runnable {
	Socket s;

	public SendThread(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		try {
			// 키보드에서 정보 받기
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter sendWriter = new PrintWriter(s.getOutputStream());

			String sendString;
			while (true) {
				sendString = br.readLine();
				// if(sendString.equals("exit")) break;
				
				sendWriter.println(sendString);
				sendWriter.flush();
			}
			
			// sendWriter.close();
			// br.close();
			// s.close();
		} catch (Exception e) {
		} 
	}
}
