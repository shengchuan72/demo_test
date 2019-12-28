package test.thread;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;


public class EasyLoadThread {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("要下载哪个文件");
			String src = sc.nextLine();
			
			System.out.println("保存到哪里去");
			String desc = sc.nextLine();
			DownLoadThread a = new DownLoadThread(src, desc);
		}
	}
}


class DownLoadThread extends Thread{
	String src;
	String desc;
	public DownLoadThread(String src,String desc) {
		this.src = src;
		this.desc= desc;
		this.start();
	}
	public void copyFile() throws IOException {
		URL u = new URL(src);
		URLConnection connection = u.openConnection();
		InputStream inputStream = connection.getInputStream();
		RandomAccessFile out = new RandomAccessFile(desc, "rw");
		
		int i = inputStream.read();
		
		while(i != -1){
			out.write(i);
			i = inputStream.read();
		}
		
		inputStream.close();
		out.close();
	}
	
	public void run() {
		try {
			copyFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}