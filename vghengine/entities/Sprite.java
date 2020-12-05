/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vghengine.entities;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import vghengine.math.Vector2;

/**
 *
 * @author davide
 */
public class Sprite extends Entity {
    private BufferedImage texture;
    private AffineTransform at;
    private double angle;

    public Sprite(Vector2 pos, String img) {
        super(pos);
        setTexture(img);
        setW(texture.getWidth());
        setH(texture.getHeight());
        setBoundingBox(new Rectangle2D.Double(x, y, w, h));
        setAlpha(1.0);
        angle = 0;
        at = AffineTransform.getTranslateInstance(x, y);
    }

    public Sprite(Vector2 pos, BufferedImage txt) {
        super(pos);
        setTexture(txt);
        setW(texture.getWidth());
        setH(texture.getHeight());
        setBoundingBox(new Rectangle2D.Double(x, y, w, h));
        setAlpha(1.0);
        angle = 0;
        at = AffineTransform.getTranslateInstance(x, y);
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public void setTexture(String path) {
        try {
            this.texture = ImageIO.read(getClass().getResource(path));
        }
        catch(Exception e) {
            System.out.println("Texture not found!");
        }
    }

    public void setTexture(BufferedImage txt) {
        this.texture = txt;
    }

    public Rectangle2D.Double getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(Rectangle2D.Double boundingBox) {
        this.boundingBox = boundingBox;
    }
    
    public void setPosition(int posX, int posY) {
        setX(posX);
        setY(posY);
        setBoundingBox(new Rectangle2D.Double(x, y, w, h));
    }
    
    public AlphaComposite setAlphaComposite() {
        AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)getAlpha());
        return ac;
    }
    
    public void rotate(double angle) {
        at.rotate(Math.toDegrees(angle), w/2, h/2);
    }
    
    public void flipV() {
        at = AffineTransform.getScaleInstance(1, -1);
        at.translate(w, -h/2);
    }
    
    public void flipH() {
        at = AffineTransform.getScaleInstance(-1, 1);
        at.translate(-w/2, h);
    }
    
    public void update() {
        this.x += velocity.x;
        this.y += velocity.y;
        boundingBox = new Rectangle2D.Double(x, y, w, h);
        at = AffineTransform.getTranslateInstance(x, y);
    }
    
    public void lookAt(int x, int y) {
        double dx = x - this.x;
        double dy = y - this.y;
        angle = -Math.atan2(dx, dy);
        angle = Math.toDegrees(angle)+180;
    }
    
    @Override
    public void draw(Graphics2D g) {
       if(isVisible()) {
           g.setComposite(setAlphaComposite());
           g.drawImage(texture, at, null);
       }
    }

    public void setW(int width) {
        this.w = width;
        setBoundingBox(new Rectangle2D.Double(x, y, w, h));
    }
    
    public double getW() {
        return this.w;
    }
    
    public void setH(double height) {
        this.h = height;
        setBoundingBox(new Rectangle2D.Double(x, y, w, h));
    }
    
    public double getH() {
        return this.h;
    }
}
