package networks.tcp;

import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5100);
        System.out.println("TCP Server listening on port 5100...");

        Socket client = server.accept();  // wait for client
        System.out.println("Client connected: " + client);

        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);

        String line;
        while ((line = in.readLine()) != null) {
            System.out.println("Received: " + line);
            out.println("Echo: " + line);  // send back
        }

        client.close();
        server.close();
    }
}
