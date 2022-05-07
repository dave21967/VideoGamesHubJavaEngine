package vghengine.math;

public class Vector2 {
    public int x;
    public int y;

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Vector2 ZERO = new Vector2(0,0);
    public static Vector2 RIGHT = new Vector2(1, 0);
    public static Vector2 LEFT = new Vector2(-1, 0);
    public static Vector2 UP = new Vector2(0, -1);
    public static Vector2 DOWN = new Vector2(0, 1);
}