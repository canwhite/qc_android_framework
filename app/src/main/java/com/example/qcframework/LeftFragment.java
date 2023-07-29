package com.example.qcframework;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.qcframework.listview.Fruit;
import com.example.qcframework.listview.FruitAdapter;
import com.example.qcframework.recyclerview.RecyclerFruit;
import com.example.qcframework.recyclerview.RecyclerFruitAdapter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import static android.media.CamcorderProfile.get;

public class LeftFragment extends Fragment implements OnBannerListener,RadioGroup.OnCheckedChangeListener {


    private static final String TAG = "LeftFragment";
    private ArrayList<String> list_path;
    private ArrayList<String> list_title;
    private Banner banner;
    private List<RecyclerFruit> fruitList = new ArrayList<>();
    private List<Fruit> listFruitList = new ArrayList<>();




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.left_fragment,container,false);

        this.initView(view);

        //初始化列表数据
        this.initFruits();

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        MainActivity activity = (MainActivity)getActivity();
        GridLayoutManager layoutManager = new GridLayoutManager(activity,4);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerFruitAdapter adapter = new RecyclerFruitAdapter(fruitList,(MainActivity)getActivity());
        recyclerView.setAdapter(adapter);





        return  view;

    }




    public void initView(View view){



        /*
            banner
         */
        banner = (Banner)view.findViewById(R.id.banner);
        //放标题和放图片的集合初始化
        list_path = new ArrayList<>();
        list_title = new ArrayList<>();


        list_path.add("https://www.baidu.com/img/bd_logo1.png");
        list_path.add("https://www.baidu.com/img/bd_logo1.png");
        list_path.add("https://www.baidu.com/img/bd_logo1.png");
        list_path.add("https://www.baidu.com/img/bd_logo1.png");
        list_title.add("好好学习");
        list_title.add("天天向上");
        list_title.add("热爱劳动");
        list_title.add("不搞对象");

        //设置内置样式，共有六种，可以点如入方法逐一体验使用,不要title和要title样式不同
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);

        //设置图片加载器，图片加载器写了一个内部类
        banner.setImageLoader(new MyLoader());

        //设置图片地址的集合
        banner.setImages(list_path);

        //设置轮播的动画效果，内设多种特效，可点入方法查找后逐一体验
        banner.setBannerAnimation(Transformer.Default);

        //设置轮播图的标题集合
        //banner.setBannerTitles(list_title);

        //设置轮播间隔时间
        banner.setDelayTime(3000);

        //设置是否为自动轮播，默认是"true"
        banner.isAutoPlay(true);


        //设置指示器的位置，小点点，左中右, 以上内容可以写成链式布局，以下是监听,和开始
        banner.setIndicatorGravity(BannerConfig.CENTER).setOnBannerListener(this).start();





        /*
            RadioGroup===新闻和公告部分========
         */

        RadioGroup radioGroup = (RadioGroup)view.findViewById(R.id.rg);
        radioGroup.setOnCheckedChangeListener(this);



         /*
            list
         */

         this.initList();
        ListView listView = (ListView)view.findViewById(R.id.list_view);

        final MainActivity activity = (MainActivity)getActivity();
        FruitAdapter adapter = new FruitAdapter(activity,R.layout.fruit_item,listFruitList);

        listView.setAdapter(adapter);


        //listview的点击事件

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Fruit fruit = listFruitList.get(position);
                Toast.makeText(activity,fruit.getName(),Toast.LENGTH_SHORT).show();

            }
        });






    }




    /*
        轮播图的点击监听
     */

    @Override
    public void OnBannerClick(int position) {

        Log.i("tag", "你点了第"+position+"张轮播图");


    }

    /*
        RadioGroup的点击监听
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        MainActivity activity = (MainActivity)getActivity();
        switch (group.getCheckedRadioButtonId()){


            case R.id.news:


                Toast.makeText(activity,"点击了新闻按钮",Toast.LENGTH_SHORT).show();

                break;

            case R.id.notice:

                Toast.makeText(activity,"点击了公告按钮",Toast.LENGTH_SHORT).show();

                break;
        }
    }

    //自定义图片加载器
    private  class MyLoader extends ImageLoader{
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {

            Glide.with(context).load((String)path).into(imageView);
        }
    }

    private void initFruits(){
        RecyclerFruit apple = new RecyclerFruit("apple",R.mipmap.apple);
        fruitList.add(apple);
        fruitList.add(apple);
        fruitList.add(apple);
        fruitList.add(apple);
        fruitList.add(apple);
        fruitList.add(apple);
        fruitList.add(apple);
        fruitList.add(apple);

        RecyclerFruit melon = new RecyclerFruit("melon",R.mipmap.apple);
        fruitList.add(melon);

    }


    private  void initList(){

        Fruit apple = new Fruit("Apple",R.mipmap.apple);
        listFruitList.add(apple);
        listFruitList.add(apple);
        listFruitList.add(apple);
        listFruitList.add(apple);
        listFruitList.add(apple);
        listFruitList.add(apple);
        listFruitList.add(apple);
        listFruitList.add(apple);
        listFruitList.add(apple);
        listFruitList.add(apple);





    }




}
