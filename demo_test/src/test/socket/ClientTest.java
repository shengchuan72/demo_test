package test.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ClientTest {

	public static void main(String[] args) throws IOException {
		Socket s = new Socket("127.0.0.1",9999);
		InputStream in = s.getInputStream();
		InputStreamReader r = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(r);
		String line = br.readLine();
		System.out.println("服务器说：" + line);
		
		OutputStream os = s.getOutputStream();
		PrintStream ps = new PrintStream(os);
		ps.println("服务器晚上好！");
		ps.flush();
		ps.close();
		br.close();
	}
}
