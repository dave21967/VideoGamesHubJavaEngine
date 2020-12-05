/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vghengine.gui;

import vghengine.entities.GameObject;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class Label extends GameObject {
    private int x;
    private int y;
    private Rectangle boundingBox;
    private Font font;
    private Color color;
    private String string;
    private int fontSize;
    
    public Label(String s, int posx, int posy) {
        setString(s);
        setX(posx);
        setY(posy);
        setColor(Color.BLACK);
        setFont(new Font("Aryal", Font.BOLD, 20));
        fontSize = 20;
        boundingBox = new Rectangle(x, y, string.length()*fontSize, fontSize);
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(Rectangle boundingBox) {
        this.boundingBox = boundingBox;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
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

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
        this.fontSize = font.getSize();
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public void draw(Graphics g) {
        g.setFont(font);
        g.setColor(color);
        g.drawString(string, x, y);
    }
}
