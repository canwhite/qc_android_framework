package com.example.qcframework.utils;

import android.content.Context;

import com.tencent.mmkv.MMKV;

public class SingleTonMMKV {

    //将构造函数私有化
    private SingleTonMMKV(){}


    //静态内部类
    public static class SingleTonHoulder{
        //内部类调用构造函数创建
        private  static  final  SingleTonMMKV singleTonInstance = new SingleTonMMKV();
    }

    //getInstance

    public  static SingleTonMMKV getInstance(){


        return  SingleTonHoulder.singleTonInstance;
    }

    //设置字符串
    public void setkeyAndStringValue(String key,String stringValue){
        MMKV mmkv = MMKV.defaultMMKV();
        mmkv.encode(key,stringValue);

    }

    //获取字符串
    public String getStringValueByKey(String key){
        MMKV mmkv = MMKV.defaultMMKV();
        String stringValue =  mmkv.decodeString(key,"");
        return  stringValue;

    }

    //设置bool值
    public void setKeyAndBoolValue(String key,Boolean boolvalue){

        MMKV mmkv = MMKV.defaultMMKV();
        mmkv.encode(key,boolvalue);

    }


    //获取bool值
    public  boolean getBoolvalueByKey(String key){

        MMKV mmkv = MMKV.defaultMMKV();
        Boolean boolValue = mmkv.decodeBool(key,false);
        return  boolValue;
    }


    //mmkv初始化
    public  void initMMKVWithContext(Context context){

        String rootDir =  MMKV.initialize(context);
        System.out.println("mmkv root: " + rootDir);
        this.setkeyAndStringValue("init",rootDir);


    }





}
