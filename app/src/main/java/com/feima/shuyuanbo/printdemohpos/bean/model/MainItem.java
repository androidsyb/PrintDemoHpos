package com.feima.shuyuanbo.printdemohpos.bean.model;

import java.io.Serializable;

/**
 * Created by shuyuanbo on 17/1/19.
 */

public class MainItem implements Serializable {

    private String text;
    private int color;
    private int mode;

    public MainItem() {
    }

    public MainItem(String text, int color,int mode) {
        this.text = text;
        this.color = color;
        this.mode = mode;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return "MainItem{" +
                "text='" + text + '\'' +
                ", color=" + color +
                ", mode=" + mode +
                '}';
    }
}
