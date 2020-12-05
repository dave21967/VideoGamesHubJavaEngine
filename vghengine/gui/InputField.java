/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vghengine.gui;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import vghengine.entities.GameObject;
import vghengine.math.Vector2;
/**
 *
 * @author david
 */
public class InputField extends GameObject {
    private double x;
    private double y;
    private double w;
    private double h;
    private Rectangle2D.Double boundingBox;
    private Color color;
    private int fontSize;
    private String text;
    private String placeHolder;
    private boolean focused;
    
    public InputField(Vector2 pos, int fs) {
        setX(pos.x);
        setY(pos.y);
        setW(100);
        setH(fs);
        setText("");
        setPlaceHolder("Text: ");
        setFontSize(fs);
        setBoundingBox(new Rectangle2D.Double(x, y, w, h));
        setFocused(false);
        setColor(Color.BLACK);
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

    public Rectangle2D.Double getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(Rectangle2D.Double boundingBox) {
        this.boundingBox = boundingBox;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isFocused() {
        return focused;
    }

    public void setFocused(boolean focused) {
        this.focused = focused;
    }

    public String getPlaceHolder() {
        return placeHolder;
    }

    public void setPlaceHolder(String placeHolder) {
        this.placeHolder = placeHolder;
    }
    
    public void update() {
        if(focused) {
            setColor(color);
        }
        else {
            setColor(Color.RED);
        }
    }
    
    public boolean isEmpty() {
        if(text.equals("")) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public void draw(Graphics g) {
        g.setFont(new Font("Aryal", Font.BOLD, fontSize));
        g.setColor(color);
        g.drawString(placeHolder+text, (int)x, (int)y);
        g.drawRect((int)boundingBox.getX(), (int)boundingBox.getY(), (int)boundingBox.getWidth(), (int)boundingBox.getHeight());
    }
}
