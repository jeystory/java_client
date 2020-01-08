package com.ict.edu2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
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
			while(true) {
				System.out.print("입력 :");
				String msg = scan.next();
				
				s = new Socket("127.0.0.1", 7779);
				// 보내자
				out = s.getOutputStream();
				osw = new OutputStreamWriter(out);
				bw = new BufferedWriter(osw);
				msg += System.getProperty("line.seperator");
				bw.write(msg);
				bw.flush();
				
				in = s.getInputStream();
				isr = new InputStreamReader(in);
				br = new BufferedReader(isr);
			
				String reMsg = br.readLine();
				if(reMsg.equalsIgnoreCase("exit")) {
					break;
				}else {
					System.out.println("return : "+msg);
				}
				 
				 
			}
		} catch (Exception e) {
			// TODO: handle exception
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
				// TODO: handle exception
			}
		}
		
	}

	public static void main(String[] args) {
		new Ex01();
	}
}
