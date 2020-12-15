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
public class DisconnectPacket extends Packet {
    public DisconnectPacket(InetAddress addr, int p) {
        super("", addr, p);
        setFlag(PacketTypes.DISCONNECT);
    }
}
