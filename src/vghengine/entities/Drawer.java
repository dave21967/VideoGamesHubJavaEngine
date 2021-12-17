/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vghengine.entities;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author david
 */
public class Drawer {
    private Font font;
    private Color color;
    
    public Drawer() {
        font = new Font("Aryal", Font.BOLD, 20);
        color = Color.BLACK;
    }
    
    public void drawRect(Graphics2D g, double x, double y, double w, double h) {
        g.setColor(color);
        g.drawRect((int)x, (int)y, (int)w, (int)h);
    }
    
    public void fillRect(Graphics2D g, double x, double y, double w, double h) {
        g.setColor(color);
        g.fillRect((int)x, (int)y, (int)w, (int)h);
    }
    
    public void drawImage(Graphics2D g, double x, double y, BufferedImage image) {
        g.drawImage(image, (int)x, (int)y, null);
    }
    
    public void drawText(Graphics2D g, String txt, double x, double y) {
        g.setColor(color);
        g.setFont(font);
        g.drawString(txt, (int)x, (int)y);
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
