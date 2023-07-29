package com.example.qcframework;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tencent.mmkv.MMKV;

public class RightFragment extends Fragment {

    private static final String TAG = "RightFragment";
    private MMKV mmkv;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View  view = inflater.inflate(R.layout.right_fragment,container,false);

        Button button = (Button)view.findViewById(R.id.sec_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "onClick: 我点击了右侧按钮");

                //mmkv的使用要先初始化
                mmkv = MMKV.defaultMMKV();
                mmkv.encode("isLogin",false);

                MainActivity activity = (MainActivity)getActivity();

                Intent intent = new Intent(activity,LoginActivity.class);
                startActivity(intent);
                //finish();//结束活动



            }
        });
        
        
        return  view;

    }
}
