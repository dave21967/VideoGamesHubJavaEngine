/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vghengine.networking;

import java.net.InetAddress;

/**
 *
 * @author davide
 */
public class LoginPacket extends Packet {
    private String username;
    private String password;
    
    public LoginPacket(String usrName, String passwd) {
        super("");
        setFlag(PacketTypes.LOGIN);
        setUsername(usrName);
        setPassword(passwd);
    }
    
    public LoginPacket(String usrName, String passwd, InetAddress addr, int p) {
        super("");
        setFlag(PacketTypes.LOGIN);
        setUsername(usrName);
        setPassword(passwd);
        setAddress(addr);
        setPort(p);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
