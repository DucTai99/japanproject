package com.example.japan.model;

import java.io.Serializable;

public class ObjectGeneral implements Serializable {
    private int id;
    private String name;
    private String content;
    private int srcImg;

    public ObjectGeneral(int id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.srcImg = 0;
    }

    public ObjectGeneral(int id, String name, String content, int srcImg) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.srcImg = srcImg;
    }

    public int getSrcImg() {
        return srcImg;
    }

    public void setSrcImg(int srcImg) {
        this.srcImg = srcImg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
