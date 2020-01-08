package com.ict.edu4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
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
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			VO vo = new VO(200, br.toString() );

			while (true) {
				oos.writeObject(vo);
				oos.flush();
			}
			
			// sendWriter.close();
			// br.close();
			// s.close();
		} catch (Exception e) {
		} 
	}
}
