package org.example;

// Echo9001.java
import com.sun.net.httpserver.*;

import java.net.*;
public class Echo9001 {
    public static void main(String[] a) throws Exception {
        HttpServer s = HttpServer.create(new InetSocketAddress(9001), 0);
        s.createContext("/health", ex -> { byte[] b="OK".getBytes(); ex.sendResponseHeaders(200,b.length); ex.getResponseBody().write(b); ex.close(); });
        s.createContext("/", ex -> { byte[] b=("9001 -> "+ex.getRequestURI()).getBytes(); ex.sendResponseHeaders(200,b.length); ex.getResponseBody().write(b); ex.close(); });
        s.start(); System.out.println("Backend 9001 up");
    }
}
