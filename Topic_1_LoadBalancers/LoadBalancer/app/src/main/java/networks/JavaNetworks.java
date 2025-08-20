package networks;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.net.spi.InetAddressResolver;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class JavaNetworks {
    public static void main(String[] args) throws IOException {
        int c;
        Socket socket = new Socket("whois.internic.net", 43);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        String str = (args.length == 0 ? "google.com" : args[0]) + "\n";

        byte[] buffer = str.getBytes();

        out.write(buffer);

        while((c = in.read()) != -1 ) {
            System.out.print((char) c);
        }

        socket.close();
    }
}
