package vghengine.physics;

import vghengine.components.GraphicsComponent;

import java.awt.geom.Rectangle2D;

public class BoxCollider2D {
    int x;
    int y;
    int width;
    int height;
    private boolean active;

    public BoxCollider2D(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        active = false;
    }

    public void setActive(boolean act) {
        active = act;
    }

    public boolean isActive() {
        return active;
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean intersects(BoxCollider2D c2) {
        if(x > c2.getX() && x < c2.getX()+c2.getWidth()
        || y > c2.getY() && y < c2.getY()+c2.getHeight()) {
            return true;
        }
        else
            return false;
    }
}
