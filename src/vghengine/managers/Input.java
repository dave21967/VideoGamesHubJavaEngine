package vghengine.managers;

import vghengine.math.Vector2;

public class Input {
    public static Vector2 mousePosition = new Vector2(0,0);
    public static char keyPressed;
    public static char keyTyped;
    public static char keyReleased;

    public static boolean isKeyPressed(int k) {
        return keyPressed == k;
    }

    public static void printKeyPressed() {
        if(keyPressed != 0)
            System.out.println(keyPressed);
    }
}
