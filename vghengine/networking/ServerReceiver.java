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
public class ServerReceiver extends Thread {
    Socket socket;
    Scanner in;
    Msg msg;
    
    public ServerReceiver (Socket s, Msg m) throws IOException{
        socket = s;
        in = new Scanner(s.getInputStream());
        msg = m;
    }
    
    public void run(){
        while (true) {
            String data = in.nextLine();
            if(data.contains("/close")) {
                try {
                    socket.close();
                    break;
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                msg.metti(data);
            }
        }
    }
    
}
