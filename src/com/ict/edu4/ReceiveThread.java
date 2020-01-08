package com.ict.edu4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ReceiveThread implements Runnable {
	Socket s;
	public ReceiveThread(Socket s) {
		this.s = s;
	}
	@Override
	public void run() {
		try {
		
			while(true) {
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				VO vo = (VO)ois.readObject();
				System.out.println(vo.getMsg());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
