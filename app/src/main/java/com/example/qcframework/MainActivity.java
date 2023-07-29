package com.example.qcframework;

import android.app.Activity;
import android.arch.core.util.Function;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;



public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*
            碎片相关
         */


        //初始化默认碎片
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.containner, new LeftFragment()).commit();

        //得到radioGroup
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.rg);
        radioGroup.setOnCheckedChangeListener(this);

    }

    private void replaceFragment(Fragment fragment) {

        //必须先开启manager
        android.support.v4.app.FragmentManager   fragmentManager = getSupportFragmentManager();

        //开启一个事务
        android.support.v4.app.FragmentTransaction  transaction = fragmentManager.beginTransaction();

        //替换碎片，第一个参数是原来的fragment布局，第二个是你要置换的framment实例
        transaction.replace(R.id.containner, fragment);

        //在碎片中模拟返回栈
        //transaction.addToBackStack(null);
        //对事务进行提交
        transaction.commit();

    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (group.getCheckedRadioButtonId()){

            case  R.id.radioButton_home:
                replaceFragment(new LeftFragment());
                break;
            case  R.id.radioButton_service:
                replaceFragment(new MidFragment());
                break;
            case  R.id.radioButton_mine:
                replaceFragment(new RightFragment());
                break;
        }



    }
}
