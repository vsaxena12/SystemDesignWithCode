package networks.udp;

import java.net.*;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");

        String msg = "Hello UDP Server!";
        byte[] buffer = msg.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 5101);
        socket.send(packet);

        // receive echo
        byte[] recvBuf = new byte[1024];
        DatagramPacket response = new DatagramPacket(recvBuf, recvBuf.length);
        socket.receive(response);
        System.out.println("Server says: " + new String(response.getData(), 0, response.getLength()));

        socket.close();
    }
}
