package com.example.qcframework.listview;

public class Fruit {
    private String name;
    private int imageId;

    //构造函数，Fruit的初始化，完成了set
    public Fruit(String name,int imageId){

        this.name = name;
        this.imageId = imageId;

    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

}
