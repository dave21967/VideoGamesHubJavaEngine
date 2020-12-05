/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vghengine.path;

import java.util.ArrayList;

/**
 *
 * @author david
 */
public class Path {
    private ArrayList<Node> nodes;
    
    public Path() {
        nodes = new ArrayList<>();
    }
    
    public int getNodes() {
        return nodes.size();
    }
    
    public void addNode(Node n) {
        nodes.add(n);
    }
    
    public Node getNode(int i) {
        return nodes.get(i);
    }
    
    public void removeNode(int i) {
        nodes.remove(i);
    }
}
