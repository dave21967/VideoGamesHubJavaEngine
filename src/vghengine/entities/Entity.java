package vghengine.entities;

import vghengine.components.GraphicsComponent;
import vghengine.math.Vector2;
import vghengine.physics.Body2D;
import vghengine.physics.BoxCollider2D;
import vghengine.time.Time;

import javax.swing.*;

public class Entity extends GraphicsComponent {
    private Vector2 position;
    private Vector2 size;
    private BoxCollider2D collider;
    private Body2D body;

    public Entity() {
        position = new Vector2(0,0);
        size = new Vector2(32, 32);
        collider = new BoxCollider2D(position.x, position.y, size.x, size.y);
        body = new Body2D();
    }

    public BoxCollider2D getCollider() {
        return collider;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getSize() {
        return size;
    }

    public void setSize(Vector2 size) {
        this.size = size;
    }

    public Body2D getBody() {
        return body;
    }

    @Override
    public void update() {
        position.x += body.velocity.x;
        position.y += body.velocity.y;
        collider = new BoxCollider2D(position.x, position.y, size.x, size.y);
    }
}
