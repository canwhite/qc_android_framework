package com.example.qcframework.listview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qcframework.R;
import com.example.qcframework.recyclerview.RecyclerFruit;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {


    private int resourceId;

    //继承自ArrayAdapter后，Alt + enter 选择有List的那个
    public FruitAdapter(Context context, int resource, List<Fruit> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    //getVie得到的是cell
    @NonNull
    @Override
    public View getView(int position,  @Nullable View convertView, @NonNull ViewGroup parent) {

        //获取当前项的数据
        Fruit fruit = getItem(position);
        //如果view在缓存中存在，就不新建了，否则新建
        View view;
        ListViewHolder viewHolder;



        if (convertView == null){
            //如果root不为null，attachToRoot为true，表示将layout布局添加到root布局中
            //如果root不为null，attachToRoot为false，表示不将layout布局添加到root布局，若要添加则需要手动addView
            //当是弹窗之类的不用确定root的，可以将attachToRoot设置为null，或者不设置
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ListViewHolder();
            viewHolder.fruitImage = (ImageView)view.findViewById(R.id.fruit_image);
            viewHolder.fruitName = (TextView)view.findViewById(R.id.fruit_name);

            view.setTag(viewHolder);


        }else{

            view = convertView;
            viewHolder = (ListViewHolder)view.getTag();

        }

        //缓存方式或者是创建方式获取viewholder之后再统一设置内容
        viewHolder.fruitName.setText(fruit.getName());
        viewHolder.fruitImage.setImageResource(fruit.getImageId());


        return  view;

    }
}
