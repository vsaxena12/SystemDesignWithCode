package org.example;

import java.net.UnknownHostException;
import java.net.InetAddress;

public class InetAddressImpl {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println("Host Name: " + inetAddress.getHostName());
        System.out.println("Host Address: " + inetAddress.getHostAddress());
    }
}
