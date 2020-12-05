/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vghengine.networking;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author davide
 */
public class ClientTransmitter extends Thread{
    Socket socket;
    Scanner usrin;
    String msg;
    public String username;
    private PrintWriter out;
    boolean end;
    
    public ClientTransmitter(Socket s) throws IOException{
        socket=s;
        out = new PrintWriter(s.getOutputStream(), true);
        usrin = new Scanner(System.in);
        msg="";
    }
    
    public void setMsg(String m) {
        this.msg = m;
    }
    
    public void run(){
        username = usrin.nextLine();
        out.println("/name "+username);
        System.out.println("Benvenuto utente "+username);
        System.out.println("/help per visualizzare i comandi del server");
        while(true) {
            if(msg.equals("")) {
                System.out.println("null");
            }
            else {
                System.out.println("not null");
                if(msg.contains("/close")) {
                    out.println(msg+" "+username);
                    try {
                        socket.close();
                        System.out.println("Close");
                        break;
                    }
                    catch(Exception e) {
                        e.printStackTrace();
                    }
                }
                else if(msg.contains("/")) {
                    out.println(msg+" "+username);
                }
                else if(msg.contains("/name")) {
                    out.println("Comando non disponibile");
                }
            }
        }
    }
    
}
