/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vghengine.entities;
import vghengine.path.Node;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import vghengine.math.Vector2;
import vghengine.path.Path;
/**
 *
 * @author david
 */
public class Entity extends GameObject {
    double x;
    double y;
    double w;
    double h;
    double alpha;
    String direction;
    private boolean visible;
    public Vector2 velocity;
    public Rectangle2D.Double boundingBox;
    private int i=0;
    
    public Entity(Vector2 pos, Vector2 dimensions) {
        super();
        this.x = pos.x;
        this.y = pos.y;
        this.w = dimensions.x;
        this.h = dimensions.y;
        setVisible(true);
        velocity = new Vector2(0, 0);
        direction = "idle";
        boundingBox = new Rectangle2D.Double(x, y, w, h);
    }

    public Entity(Vector2 pos) {
        super();
        setX(pos.x);
        setY(pos.y);
        setW(64);
        setH(64);
        setVisible(true);
        direction = "idle";
        velocity = new Vector2(0, 0);
        boundingBox = new Rectangle2D.Double(x, y, w, h);
    }
    
    public void moveTo(Node point) {
        if(!point.isClosed()) {
            if(x < point.getX()) {
                velocity.x = 1;
                velocity.y = 0;
            }
            else if(x > point.getX()) {
                velocity.x = -1;
                velocity.y = 0;
            }
            else if(y < point.getY()) {
                velocity.y = 1;
                velocity.x = 0;
            }
            else if(y > point.getY()) {
                velocity.y = -1;
                velocity.x = 0;
            }
            if(getPosition().equals(point.getPosition())) {
                point.setClosed(true);
                velocity = new Vector2(0, 0);
            }
        }
    }
    
    public void followPath(Path p) {
        if(i<p.getNodes()) {
            moveTo(p.getNode(i));
            if(p.getNode(i).isClosed()) {
                i++;
            }
        }
        else {
            i=0;
        }
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

    public void setAlpha(double a) {
        if(a > 0.0 && a < 255 || a < 1.0) {
            this.alpha = a;
        }
        else {
            this.alpha = 1.0;
        }
    }

    public double getAlpha() {
        return this.alpha;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setDirection(String d) {
        this.direction = d;
    }

    public String getDirection() {
        return this.direction;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public void setVelocity(int x, int y) {
        this.velocity = new Vector2(x, y);
    }

    public Rectangle2D.Double getBoundingBox() {
        return this.boundingBox;
    }

    public Vector2 getPosition() {
        return new Vector2(x, y);
    }

    public void update() {
        this.x += velocity.x;
        this.y += velocity.y;
        boundingBox = new Rectangle2D.Double(x, y, w, h);
    }
    
    public void moveAndCollide(ArrayList<Tile> tiles) {
        
    }
    
    public Rectangle2D.Double getBounds() {
        return new Rectangle2D.Double(x+(w/2)-((w/2)/2), y+(h/2), w, h/2);
    }
    
    public Rectangle2D.Double getBoundsTop() {
        return new Rectangle2D.Double(x+(w/2), y, w, h/2);
    }
    
    public Rectangle2D.Double getBoundsRight() {
        return new Rectangle2D.Double();
    }
    
    public boolean isColliding(Entity e) {
        if(this.boundingBox.intersects(e.getBoundingBox())) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean collideWithWalls(Sprite s, double vx, double vy) {
        if(boundingBox.intersects(s.getBoundingBox())) {
            if(vx < 0) {
                setX(s.getX()+s.getW());
            }
            else if(vx > 0) {
                setX(s.getX()-getW());
            }
            else if(vy < 0) {
                setY(s.getY()+s.getH());
            }
            else if(vy > 0) {
                setY(s.getY()-getH());
            }
            return true;
        }
        else {
            return false;
        }
    }
    
    public void draw(Graphics2D g) {
        
    }
}
