/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritimovalentao;

/**
 *
 * @author Thiago
 */
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpSocket{
  public static void main(String[] args) throws Exception {
    DatagramSocket socket = new DatagramSocket();

    // get the address to send the packet to
    InetAddress address = InetAddress.getByName("localhost");

    // send the packet
    byte[] data = "Hello, world!".getBytes();
    socket.send(new DatagramPacket(data, data.length, address, 8888));

    // receive the response
    byte[] buffer = new byte[1024];
    DatagramPacket response = new DatagramPacket(buffer, buffer.length);
    socket.receive(response);

    // print the response
    System.out.println(new String(response.getData()));

    // close the socket
    socket.close();
  }
}
