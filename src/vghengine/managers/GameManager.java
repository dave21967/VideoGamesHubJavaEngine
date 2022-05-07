package vghengine.managers;

import vghengine.math.Vector2;
import vghengine.time.Time;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.security.Key;

public class GameManager extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener {
    final int WIDTH;
    final int HEIGHT;
    private SceneManager sceneTree;
    private long startTime;
    
    public GameManager(int width, int height) {
        super();
        WIDTH = width;
        HEIGHT = height;

        sceneTree = new SceneManager();
        startTime = System.nanoTime() / 1000000;
    }

    public SceneManager getSceneTree() {
        return sceneTree;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        sceneTree.getScene("main").draw(g2d);
    }

    @Override
    public void run() {
        while(true) {

            long time = System.nanoTime();
            Time.deltaTime = (time - startTime);
            startTime = time;

            setBackground(sceneTree.getScene("main").getBackground());
            sceneTree.getScene("main").update(Time.deltaTime);
            this.repaint();

            try {
                Thread.sleep(10);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        Input.keyTyped = e.getKeyChar();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Input.keyPressed = e.getKeyChar();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Input.keyPressed = 0;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

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
        Input.mousePosition = new Vector2(e.getX(), e.getY());
    }
}
