package vghengine.window;

import vghengine.gui.Scene;
import vghengine.managers.GameManager;
import vghengine.math.Vector2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Window extends JFrame {
    private final int WIDTH;
    private final int HEIGHT;
    private final String title;
    private GameManager gm;

    public Window(String t, int w, int h, Scene mainScene) {
        WIDTH = w;
        HEIGHT = h;
        title = t;
        gm = new GameManager(WIDTH, HEIGHT);
        gm.getSceneTree().addScene("main", mainScene);
        mainScene.setGameManager(gm);
        setSize(new Vector2(WIDTH, HEIGHT));
        setTitle(title);
        add(gm);
        addKeyListener(gm);
        addMouseListener(gm);
        addMouseMotionListener(gm);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                gm.getSceneTree().getScene("main").onExit(e);
            }
        });
        setVisible(true);
        pack();
        gm.run();
    }

    public void setSize(Vector2 size) {
        setPreferredSize(new Dimension(size.x, size.y));
    }
}
