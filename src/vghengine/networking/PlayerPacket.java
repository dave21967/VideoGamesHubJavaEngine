/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vghengine.networking;

import java.net.InetAddress;
import java.util.HashMap;

/**
 *
 * @author davide
 */
public class PlayerPacket extends Packet {
    private HashMap dict;
    
    public PlayerPacket(String d) {
        super(d);
        setFlag(PacketTypes.PLAYER_UPDATE);
        dict = new HashMap();
    }
    
    public PlayerPacket(String d, InetAddress addr, int p) {
        super(d, addr, p);
        setFlag(PacketTypes.PLAYER_UPDATE);
        dict = new HashMap();
    }
    
    public void addItem(Object key, Object value) {
        dict.put(key, value);
    }
    
    public Object getItem(Object key) {
        return dict.get(key);
    }
    
    public void removeItem(Object key) {
        dict.remove(key);
    }
    
}
