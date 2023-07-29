package com.example.qcframework.utils;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.qcframework.TitleTestActivity;

public class ActivityController {

    //作为页面跳转使用的模块
    public void intentPush(Context packageContext, String title){

        Intent intent;

        if (title.equals("melon")){

            /*
                点击西瓜按钮，我们做一个跳转测试
             */
            intent = new Intent(packageContext,TitleTestActivity.class);
            packageContext.startActivity(intent);


        }else if (title.equals("apple")){


            Toast.makeText(packageContext,"你点击了苹果按钮",Toast.LENGTH_SHORT).show();


        }else if (title.equals("banana")){
            Toast.makeText(packageContext,"你点击了香蕉按钮",Toast.LENGTH_SHORT).show();
        }
        /*
            如果模块还没有
         */
        else{
            Toast.makeText(packageContext,"此模块暂未开启",Toast.LENGTH_SHORT).show();
        }
    }

}
