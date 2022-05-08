package vghengine.entities;

import vghengine.components.GraphicsComponent;
import vghengine.math.Vector2;

import java.awt.*;

public class Rect2D extends Entity {
    private boolean visible;
    private Color color;

    public Rect2D(Vector2 rectSize) {
        super();
        setSize(rectSize);
        visible = true;
        color = Color.BLACK;
    }

    public void setColor(Color c) {
        color = c;
    }

    public Color getColor() {
        return color;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void draw(Graphics2D g) {
        if(isVisible()) {
            g.setColor(color);
            g.fillRect(getPosition().x, getPosition().y, getSize().x, getSize().y);
        }
    }
}
