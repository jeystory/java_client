package com.ict.edu;

import java.net.Socket;

// Ŭ���̾�Ʈ : ���ϸ� ���

public class Ex01 {
	public static void main(String[] args) {
		Socket s = null;
		try {
			s = new  Socket("203.236.220.65", 7777);
			
			System.out.println("bye");
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
}
