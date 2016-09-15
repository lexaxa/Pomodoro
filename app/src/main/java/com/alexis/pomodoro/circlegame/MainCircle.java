package com.alexis.pomodoro.circlegame;

import android.graphics.Color;

/**
 * Created by akuzin on 09.11.2015.
 */
public class MainCircle {
    public static final int INIT_RADIUS = 200;
    private int x;
    private int y;
    private int radius;
    private int borderColor = Color.WHITE;
    private boolean isShowImg = false; // instead circle show image

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
