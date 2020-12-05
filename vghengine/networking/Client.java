/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vghengine.networking;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author david
 */
public class Client {
    private Socket s;
    private Socket socket;
    private ClientReceiver r;
    private PrintWriter out;
    private Scanner scanf;
    private String name;
        
        
    public Client(String nome, InetAddress addr, int port) throws IOException, UnknownHostException {
        s = new Socket(addr, port);
        r = new ClientReceiver(s);
        r.start();
        setName(nome);
        out = new PrintWriter(s.getOutputStream(), true);
        out.println("/name "+name);
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String n) {
        this.name = n;
    }
    
    public void send(String data) {
        out.println(data);
    }
    
    public void sendNull() {
        out.println("");
    }
    
    public String recv() {
        return r.getData();
    }
    
    public boolean equals(Client c) {
        if(this.name == c.getName()) {
            return true;
        }
        else {
            return false;
        }
    }
}
