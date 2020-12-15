/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vghengine.networking;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author davide
 */
public class Lobby extends Thread {
    private int clients;
    private ArrayList connections;
    private int maxConnections;
    private int roomCode;
    private Random random;
    private boolean action;
    public Network network;
    private boolean full;
    
    public Lobby() {
        try {
            this.network = new Network(1050);
            this.network.setAddress(InetAddress.getByName("127.0.0.1"));
        } catch (SocketException ex) {
            ex.printStackTrace();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Lobby.class.getName()).log(Level.SEVERE, null, ex);
        }
        setClients(0);
        setMaxConnections(3);
        connections = new ArrayList();
        random = new Random();
        setRoomCode(999+random.nextInt(9999));
        action = true;
        full = false;
    }

    public int getClients() {
        return clients;
    }

    public void setClients(int clients) {
        this.clients = clients;
    }

    public int getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    public int getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(int roomCode) {
        this.roomCode = roomCode;
    }
    
    public Network getNetwork() {
        return this.network;
    }

    public boolean isFull() {
        if(clients < maxConnections) {
            setFull(false);
        }
        else {
            setFull(true);
        }
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }
    
    public void addConnection(Network net) throws IOException {
        if(!isFull()) {
            connections.add(net);
            setClients(getClients()+1);
        }
        else if(isFull()) {
            Packet pkt = new Packet("Stanza piena!", net.getAddress(), net.getPort());
            net.send(pkt);
        }
    }
    
    public void removeConnection(int index) {
        if(getClients() > 0) {
            connections.remove(index);
            setClients(getClients()-1);
        }
    }
    
    public void execute() {
        
    }
    
    @Override
    public void run() {
        while(action) {
            execute();
        }
    }
}
