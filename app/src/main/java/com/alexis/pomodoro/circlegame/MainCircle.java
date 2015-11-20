package com.alexis.pomodoro.circlegame;

/**
 * Created by akuzin on 09.11.2015.
 */
public class MainCircle {
    public static final int INIT_RADIUS = 50;
    private int x;
    private int y;
    private int radius;

    public MainCircle(int x, int y) {
        this.x = x;
        this.y = y;
        this.radius = INIT_RADIUS;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }
}
