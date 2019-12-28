package test.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTest {

	public static void main(String[] args) throws IOException {
		ServerSocket s = new ServerSocket(9999);
		System.out.println("等待连接");
		Socket so = s.accept();
		System.out.println("连接者地址：" + so.getInetAddress());
		OutputStream out = so.getOutputStream();
		out.write("Hello\r\n".getBytes());
		out.flush();
		
		InputStream in = so.getInputStream();
		InputStreamReader r = new InputStreamReader(in);
		
		BufferedReader br = new BufferedReader(r);
		 String line = br.readLine();
		 System.err.println("对方说：" + line);
		 out.close();
		 br.close();
	}
}
