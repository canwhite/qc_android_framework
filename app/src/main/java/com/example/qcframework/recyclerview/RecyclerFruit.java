package com.example.qcframework.recyclerview;

public class RecyclerFruit {
    private String name;
    private int imageId;
    //构造函数，完成set的功能
    public RecyclerFruit(String name,int imageId){
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
