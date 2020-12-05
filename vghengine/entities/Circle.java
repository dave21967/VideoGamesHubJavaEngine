package vghengine.entities;

import vghengine.math.Vector2;

import java.awt.*;

public class Circle extends Entity {
    private Color color;

    public Circle(Vector2 pos, Vector2 dimensions) {
        super(pos, dimensions);
    }

    public Circle(Vector2 pos) {
        super(pos);
    }

    public void setColor(Color c) {
        this.color = c;
    }

    public Color getColor() {
        return this.color;
    }

    public void draw(Graphics2D g) {
        if(isVisible()) {
            g.setColor(this.color);
            g.fillOval((int)this.x, (int)this.y, (int)this.w, (int)this.h);
        }
    }
}
