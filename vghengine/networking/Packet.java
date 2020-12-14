/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vghengine.networking;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetAddress;

/**
 *
 * @author davide
 */
public class Packet implements Serializable {
    private String flag;
    private String data;
    private InetAddress address;
    private int port;
    
    public Packet(String d) {
        setData(d);
        setFlag("");
    }
    
    public Packet(String d, InetAddress addr, int p) {
        setData(d);
        setFlag("");
        setAddress(addr);
        setPort(p);
    }
    
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public InetAddress getAddress() {
        return address;
    }

    public void setAddress(InetAddress address) {
        this.address = address;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
    
    public static byte[] encode(Object obj) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(obj);
        oos.flush();
        return bos.toByteArray();
    }
    
    public static Object decode(byte[] array) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(array);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Object obj = (Object) ois.readObject();
        return obj;
    }
}
