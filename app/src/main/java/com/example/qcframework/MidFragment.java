package com.example.qcframework;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.qcframework.listview.Fruit;
import com.example.qcframework.listview.FruitAdapter;

import java.util.ArrayList;
import java.util.List;

public class MidFragment extends Fragment {
    private static final String TAG = "MidFragment";
    private List<Fruit> fruitList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.mid_fragment,container,false);




        Button button = (Button)view.findViewById(R.id.mid_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "onClick: 我点击了中间按钮");

            }
        });
        return  view;
    }
    private  void initFruits(){


    }

}
