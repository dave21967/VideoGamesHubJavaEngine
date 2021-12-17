/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vghengine.gui;

import vghengine.entities.GameObject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;


/**
 *
 * @author david
 */
public class Button extends GameObject {
    private int x;
    private int y;
    private int w;
    private int h;
    private Font font;

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }
    private String text;
    private Color color;
    public Rectangle rect;
    private boolean pressed;
    
    public Button(String txt, int x, int y, int w, int h) {
        setText(txt);
        setX(x);
        setY(y);
        setW(w);
        setH(h);
        setPressed(false);
        rect = new Rectangle(x, y, w, h);
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

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isPressed() {
        return pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }

    public void draw(Graphics g) {
        g.setFont(font);
        g.setColor(color);
        g.fillRect((int) rect.getX(), (int)rect.getY(), (int)rect.getWidth(), (int)rect.getHeight());
        g.setColor(Color.BLACK);
        g.drawString(text, x+w/3, y+h/2);
    }
}
