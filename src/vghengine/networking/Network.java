/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vghengine.networking;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author davide
 */
public class Network {
    private UUID id;
    private DatagramSocket socket;
    private InetAddress address;
    private int port;
    /**
     * Server constructor
     * @param p 
     */
    public Network(int p) throws SocketException {
        socket = new DatagramSocket(p);
        id = UUID.randomUUID();
        setPort(p);
    }
    /**
     * Client constructor
     * @param destAddr
     * @param destPort 
     */
    public Network() throws SocketException {
        socket = new DatagramSocket();
        id = UUID.randomUUID();
    }
    
    public Network(InetAddress addr, int p) throws SocketException {
        socket = new DatagramSocket();
        id = UUID.randomUUID();
        setPort(p);
        setAddress(addr);
        System.out.println(socket.getLocalAddress().getHostAddress());
    }

    public InetAddress getAddress() {
        return address;
    }

    public void setAddress(InetAddress address) {
        this.address = address;
    }
    
    public static InetAddress getIpAddress() {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("google.com", 80));
            return socket.getLocalAddress();
        } catch (IOException ex) {
            Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
    
    public void send(Packet pkt) throws IOException {
        byte[] buff = Packet.encode(pkt);
        DatagramPacket dgPacket = new DatagramPacket(buff, buff.length, pkt.getAddress(), pkt.getPort());
        socket.send(dgPacket);
    }
    
    public Packet recv(int bufferSize) throws IOException, ClassNotFoundException {
        DatagramPacket recvd = new DatagramPacket(new byte[bufferSize], bufferSize);
        socket.receive(recvd);
        Packet pkt = (Packet)Packet.decode(recvd.getData());
        pkt.setAddress(recvd.getAddress());
        pkt.setPort(recvd.getPort());
        return pkt;
    }

    public UUID getId() {
        return this.id;
    }
}
