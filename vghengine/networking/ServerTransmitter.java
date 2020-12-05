/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vghengine.networking;

import com.mysql.jdbc.CommunicationsException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sqlite.SQLiteException;
import vghengine.clock.Timer;

/**
 *
 * @author davide
 */
public class ServerTransmitter extends Thread {
    private ArrayList<PrintWriter> clients;
    private ArrayList<String> users;
    private Msg msg;
    private String data;
    private int numPlayers = 0;
    
    public ServerTransmitter(ArrayList<PrintWriter> c, ArrayList<String> userList, Msg m) throws IOException{
        clients = c;
        data = "";
        msg = m;
        users = userList;
    }
    
    public void printUsers(String n) {
        String info = "Utenti connessi: "+numPlayers+"\n";
        for(int i=0;i<users.size();i++) {
            info += users.get(i)+"\n";
        }
        for(int i=0;i<clients.size();i++) {
            if(users.get(i).equals(n)) {
                clients.get(i).println(info);
            }
        }
    }
    
    public void printServerCommands(String n) {
        String info = "Comandi server\n";
        info += "/help info comandi server\n";
        info += "/users visualizza utenti connessi\n";
        info += "/close esci dalla stanza\n";
        for(int i=0;i<clients.size();i++) {
            if(users.get(i).equals(n)) {
                clients.get(i).println(info);
            }
        }
    }
    
    public void run() {
        while (true) {
            data = msg.leggi();
            exec();
        }
    }
    
    public PrintWriter getClient(int index) {
        return clients.get(index);
    }
    
    public String getData() {
        return data;
    }
    
    /**
     * Override to run server!!!
     */
    public void exec() {
        
    }
}

