package networks.udp;

import java.net.*;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(5101);
        byte[] buffer = new byte[1024];
        System.out.println("UDP Server listening on port 5101...");

        while (true) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            String msg = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Received: " + msg);

            // Echo back
            byte[] response = ("Echo: " + msg).getBytes();
            DatagramPacket reply = new DatagramPacket(
                    response, response.length, packet.getAddress(), packet.getPort()
            );
            socket.send(reply);
        }
    }
}
