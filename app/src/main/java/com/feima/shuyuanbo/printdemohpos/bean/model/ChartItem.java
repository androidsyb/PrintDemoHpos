package com.feima.shuyuanbo.printdemohpos.bean.model;

import java.io.Serializable;

/**
 * Created by shuyuanbo on 17/1/20.
 */

public class ChartItem implements Serializable {

    private String title;
    private String desc;
    private int mode;

    public ChartItem(String title, String desc, int mode) {
        this.title = title;
        this.desc = desc;
        this.mode = mode;
    }

    public ChartItem() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return "ChartItem{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", mode='" + mode + '\'' +
                '}';
    }
}
