/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vghengine.managers;

import java.awt.*;

import vghengine.entities.Entity;

/**
 *
 * @author david
 */
public class CameraManager {
    private double offsetX;
    private double offsetY;
    private double width;
    private double height;
    
    public CameraManager(double ofx, double ofy, double w, double h) {
        setOffsetX(ofx);
        setOffsetY(ofy);
        setWidth(w);
        setHeight(h);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double heigh) {
        this.height = heigh;
    }
    
    
    public double getOffsetX() {
        return offsetX;
    }

    public void setOffsetX(double offsetX) {
        this.offsetX = offsetX;
    }

    public double getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(double offsetY) {
        this.offsetY = offsetY;
    }
    
    public void centerOn(Entity e) {
        setOffsetX(e.getPosition().x-getWidth()/2);
        setOffsetY(e.getPosition().y-getHeight()/2);
    }
    
    public void update(Graphics g) {
        g.translate((int)-getOffsetX(), (int)-getOffsetY());
    }
}
