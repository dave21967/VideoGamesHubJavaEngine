/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vghengine.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import vghengine.gui.Scene;
import vghengine.managers.GameManager;
/**
 *
 * @author david
 */
public class Window extends JFrame {
    private final int WIDTH;
    private final int HEIGHT;
    private final String TITLE;
    private GameManager gm;

    /**
     * When you draw sprites remember to resize the window...
     * there is a bug in sprite class
     * @param title
     * @param width
     * @param height
     */
    public Window(String title, int width, int height, Scene scene) {
        this.TITLE = title;
        this.WIDTH = width;
        this.HEIGHT = height;
        gm = new GameManager(WIDTH, HEIGHT);
        gm.setScene(scene);
        this.setTitle(TITLE);
        this.setPreferredSize(new Dimension(this.WIDTH, this.HEIGHT));
        this.add(gm);
        this.addKeyListener(gm);
        this.addMouseListener(gm);
        this.addMouseMotionListener(gm);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                gm.getScene().onDestroy(windowEvent);
            }
        });
        this.setVisible(true);
        this.pack();
        gm.start();
    }
    
    public void changeBg(Color c) {
        gm.setBackground(c);
    }
    
    public GameManager getGameManager() {
        return this.gm;
    }
}
