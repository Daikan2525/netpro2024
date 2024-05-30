package kadai6B;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MulticastClient {
    public static void main(String[] args) {
        try {
            InetAddress group = InetAddress.getByName("239.0.0.1");
            int port = 12345;

            DatagramSocket socket = new DatagramSocket();

            String command = "HOGEHOGE";

            byte[] buffer = command.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);
            socket.send(packet);

            System.out.println("Command sent: " + command);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

