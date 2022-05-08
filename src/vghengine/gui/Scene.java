package vghengine.gui;

import vghengine.managers.GameManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public class Scene {
    private Color background;
    private GameManager gameManager;

    public Scene() {

    }

    public void setGameManager(GameManager gm) {
        gameManager = gm;
    }

    public GameManager getGameManager() {
        return gameManager;
    }

    public void draw(Graphics2D g) {

    }

    public Color getBackground() {
        return background;
    }

    public void onExit(WindowEvent we) {

    }

    public void setBackground(Color background) {
        this.background = background;
    }

    public void update() {

    }
}
