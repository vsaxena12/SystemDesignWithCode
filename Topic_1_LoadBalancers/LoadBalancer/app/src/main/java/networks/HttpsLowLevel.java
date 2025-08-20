package networks;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class HttpsLowLevel {
    public static void main(String[] args) throws Exception {
        String host = "example.com";
        int port = 443;

        SSLSocketFactory f = (SSLSocketFactory) SSLSocketFactory.getDefault();
        try (SSLSocket sock = (SSLSocket) f.createSocket(host, port)) {
            sock.startHandshake();

            OutputStream out = sock.getOutputStream();
            InputStream in = sock.getInputStream();

            String req = "GET / HTTP/1.1\r\n" +
                    "Host: " + host + "\r\n" +
                    "Connection: close\r\n\r\n";
            out.write(req.getBytes(StandardCharsets.US_ASCII));
            out.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
            for (String line; (line = br.readLine()) != null;) System.out.println(line);
        }
    }
}
