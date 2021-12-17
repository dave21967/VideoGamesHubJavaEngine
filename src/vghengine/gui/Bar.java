/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vghengine.gui;

import vghengine.entities.GameObject;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author david
 */
public class Bar extends GameObject {
    private double x;
    private double y;
    private double w;
    private double h;
    private double value;
    private Color color;
    private Color bgColor;
    
    public Bar(double x, double y, double w, double h) {
        setX(x);
        setY(y);
        setW(w);
        setH(h);
        setValue(0);
        setColor(Color.BLUE);
        setBgColor(Color.RED);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        if(value < w) {
            this.value = value;
        }
        else {
            this.value = w;
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getBgColor() {
        return bgColor;
    }

    public void setBgColor(Color bgColor) {
        this.bgColor = bgColor;
    }
    
    public void draw(Graphics g) {
        g.drawRect((int)x, (int)y, (int)w, (int)h);
        g.setColor(bgColor);
        g.fillRect((int)x+1, (int)y+1, (int)w-1, (int)h-1);
        g.setColor(color);
        g.fillRect((int)x+1, (int)y+1, (int)value-1, (int)h-1);
    }
}
