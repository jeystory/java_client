package com.ict.edu3;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Ex01 implements Runnable{
	Socket s;
	
	OutputStream out;
	OutputStreamWriter osw;
	BufferedWriter bw;
	
	InputStream in;
	InputStreamReader isr;
	BufferedReader br;
	
	Scanner scan = new Scanner(System.in);
	
	public Ex01() {
		new Thread(this).start();
	}
	@Override
	public void run() {
		try {
			while (true) {
				System.out.print("입력 : ");
				String msg = scan.next();
				
				s = new Socket("203.236.220.65",7780);
				
				// 보내자
				out = s.getOutputStream();
				osw = new OutputStreamWriter(out);
				bw = new BufferedWriter(osw);
				msg += System.getProperty("line.separator");
				bw.write(msg);
				bw.flush();
				
				// 받자
				in = s.getInputStream();
				isr = new InputStreamReader(in);
				br = new BufferedReader(isr);
				String reMsg = br.readLine();
				
				if(reMsg.equalsIgnoreCase("exit")) {
					break;
				}else {
					System.out.println("return : "+ reMsg);
				}
			}
			System.out.println("수고 하셨습니다.");
		} catch (Exception e) {
		} finally {
			try {
				s.close();
				bw.close();
				br.close();
				osw.close();
				isr.close();
				out.close();
				in.close();
			} catch (Exception e2) {
			}
		}
	}
	public static void main(String[] args) {
		new Ex01();
	}
}
