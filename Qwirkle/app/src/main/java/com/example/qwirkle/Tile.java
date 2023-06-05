package com.example.qwirkle;

import android.widget.ImageView;

public class Tile {
    private ImageView imageView;
    private String color;
    private String shape;
    private Boolean isCounted=false;

    public Tile(ImageView imageView, String color, String shape) {
        this.imageView = imageView;
        this.color = color;
        this.shape = shape;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public String getColor() {
        return color;
    }

    public String getShape() {
        return shape;
    }

    public Boolean getCounted() {
        return isCounted;
    }

    public void setCounted(Boolean counted) {
        isCounted = counted;
    }
}
