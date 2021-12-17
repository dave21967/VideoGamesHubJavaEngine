/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vghengine.entities;

import java.awt.*;

import vghengine.math.Vector2;

/**
 *
 * @author david
 */
public class Rect extends Entity {
    private Color color;
    
    public Rect(Vector2 pos) {
        super(pos);
    }
    
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    @Override
    public void draw(Graphics2D g) {
        if(isVisible()) {
            g.setColor(color);
            g.fillRect((int)x, (int)y, (int)w, (int)h);
        }
    }
}
