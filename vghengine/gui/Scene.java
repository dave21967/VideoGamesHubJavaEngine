package vghengine.gui;

import vghengine.entities.GameObject;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

public class Scene extends GameObject {
    private String title;
    private Color background;

    public Scene(String t) {
        this.title = t;
    }

    public Scene() {
        this.title = "Unknown";
    }

    public Color getBackground() {
        return background;
    }

    public void setBackground(Color background) {
        this.background = background;
    }
    
    

    public void onUpdate() {

    }

    public void onDraw(Graphics2D g) {

    }
    
    public void onKeyTyped(KeyEvent ke) {
        
    }
    
    public void onKeyPressed(KeyEvent ke) {

    }

    public void onKeyReleased(KeyEvent ke) {

    }

    public void onMousePressed(MouseEvent me) {

    }

    public void onMouseReleased(MouseEvent me) {

    }

    public void onMouseClicked(MouseEvent me) {

    }
    
    public void onMouseMoved(MouseEvent me) {
        
    }
    
    public void onDestroy(WindowEvent we) {
        
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String t) {
        this.title = t;
    }
}
