package com.example.bikram_paint_app;

import android.graphics.Path;
public class Finger_Path{

    public int color;
    public int strokeWidth;
    public Path path;

    // Constructor with the needed variables of a line
    public Finger_Path(int color, int strokeWidth, Path path) {
        this.color = color;
        this.strokeWidth = strokeWidth;
        this.path = path;
    }
}