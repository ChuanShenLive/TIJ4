
package sc.chuanshen.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class MyNetworkInterface {
	public static void main(String[] args) throws Exception {
		Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();
		while (nis.hasMoreElements()) {
			NetworkInterface ni = nis.nextElement();
			System.out.print(ni.toString() + ": ");
			Enumeration<InetAddress> ias = ni.getInetAddresses();
			while(ias.hasMoreElements())
				System.out.print(ias.nextElement());
			System.out.print("\n");
		}
	}
}
