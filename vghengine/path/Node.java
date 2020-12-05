package vghengine.path;


import java.util.ArrayList;
import vghengine.math.Vector2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author david
 */
public class Node {
    private int x;
    private int y;
    private int h;
    private int g;
    private int f;
    private boolean block;
    private boolean closed;
    private Node parent;
    
    public Node(int X, int Y) {
        setX(X);
        setY(Y);
    }
    
    public void setClosed(boolean c) {
        this.closed = c;
    }
    
    public boolean isClosed() {
        return closed;
    }
    
    public Vector2 getPosition() {
        return new Vector2(x, y);
    }
    
    public void calculateH(Node endNode) {
        int dstX = Math.abs(x-endNode.getX());
        int dstY = Math.abs(y-endNode.getY());
        if(dstX > dstY) {
            this.h = 14*dstY + 10 * (dstX-dstY);
        }
        else {
            this.h = 14*dstX + 10*(dstY-dstX);
        }
    }
    
    public void calculateG(Node startNode) {
        int dstX = Math.abs(this.getX() - startNode.getX());
        int dstY = Math.abs(this.getY() - startNode.getY());

        if (dstX > dstY) {
            this.g = 14*dstY + 10* (dstX-dstY);
        } else {
            this.g = 14*dstX + 10 * (dstY-dstX);
        }
    }
    
    public void calculateF() {
        int finalCost = g+h;
        setF(finalCost);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public boolean isBlock() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
    
    
}
