package com.ict.edu;

import java.io.IOException;
import java.net.Socket;

// 클라이언트 : 소켓만 사용

public class Ex02 implements Runnable{
	static Socket s = null;
	
	public static void main(String[] args) {
		Ex02 test = new Ex02();
		new Thread(test).start();
		try {
			
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

	@Override
	public void run() {
		
		try {
			s = new  Socket("203.236.220.65", 7777);
			System.out.println("bye");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
}
