package test.socket;

import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UDPDemo {

	public static void main(String[] args) {
		try {
			InetSocketAddress addr = new InetSocketAddress("localhost",8888);
			DatagramSocket socket = new DatagramSocket(addr);
//			socket.bind(addr);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
}
