package com.ict.edu;

import java.net.Socket;

public class Ex04{
	Socket s;
	public Ex04() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					s = new Socket("203.236.220.65", 7777);
					
				} catch (Exception e) {
					// TODO: handle exception
				} finally {
					try {
						s.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				
			}
		}).start();
	}
	
	public static void main(String[] args) {
		new Ex04();
	}

}
