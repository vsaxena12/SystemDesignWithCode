package networks;

import java.net.UnknownHostException;

public class InetAddress {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = null; // = InetAddress.getLocalHost();
        System.out.println(inetAddress);
    }
}
