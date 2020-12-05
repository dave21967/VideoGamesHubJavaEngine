/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vghengine.managers;

import vghengine.gui.Scene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

/**
 *
 * @author david
 */
public class GameManager extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener {
    final int WIDTH;
    final int HEIGHT;
    private ArrayList<Scene> scenes;
    private Scene scene;

    public GameManager(int width, int height) {
        super();
        this.WIDTH = width;
        this.HEIGHT = height;
        scenes = new ArrayList<>();
        scene = new Scene();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.WHITE);
    }

    public void setScene(Scene s) {
        this.scene = s;
    }

    public void setScene(String t) {
        for(int i=0;i<scenes.size();i++) {
            if(scenes.get(i).getTitle().equals(t)) {
                this.scene = scenes.get(i);
                break;
            }
        }
    }
    
    public Scene getScene() {
        return this.scene;
    }
    
    public void addScene(Scene s) {
        scenes.add(s);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        this.onDraw(g2d);
    }

    @Override
    public void run() {
        while(true) {
            setBackground(scene.getBackground());
            this.onUpdate();
            super.repaint();
            
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                System.out.println(ex.toString());
            }
        }
    }

    public void onDraw(Graphics2D g) {
        this.scene.onDraw(g);
    }

    public void onUpdate() {
        this.scene.onUpdate();
    }
    
    public void start() {
        run();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        scene.onKeyTyped(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        scene.onKeyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        scene.onKeyReleased(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        scene.onMouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        scene.onMousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        scene.onMouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        scene.onMouseMoved(e);
    }
}
