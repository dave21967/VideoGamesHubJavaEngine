/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vghengine.entities;

import java.awt.Graphics2D;
import vghengine.math.Vector2;

/**
 *
 * @author david
 */
public class Area2D extends Entity {
    
    public Area2D(Vector2 pos, Vector2 size) {
        super(pos, size);
    }
    
    public boolean isInside(Entity e) {
        if(e.getBoundingBox().intersects(getBoundingBox())) {
            return true;
        }
        else {
            return false;
        }
    }
    
    @Override
    public void draw(Graphics2D g) {
        g.drawRect((int)x, (int)y, (int)w, (int)h);
    }
}
