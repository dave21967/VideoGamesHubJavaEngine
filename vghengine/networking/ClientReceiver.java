/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vghengine.networking;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author davide
 */
public class ClientReceiver extends Thread {
    
    Socket socket;
    Scanner in;
    String data;
    
    public ClientReceiver (Socket s) throws IOException{
        socket = s;
        in = new Scanner(s.getInputStream());
        data = "";
    }
    
    public void run(){
        while (true) {
            data = in.nextLine();
            System.out.println(data);
            if(data.contains("Ciao utente!")) {
                break;
            }
        }
    }
    
    public void setData(String d) {
        data = d;
    }
    
    public String getData() {
        return data;
    }
    
}
