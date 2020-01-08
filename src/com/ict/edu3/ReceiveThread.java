package com.ict.edu3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiveThread implements Runnable {
	Socket s;
	public ReceiveThread(Socket s) {
		this.s = s;
	}
	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String receiveString ;
			while(true) {
				receiveString = br.readLine();
				if(receiveString.equals("bye~~")) break;
				System.out.println(receiveString);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
