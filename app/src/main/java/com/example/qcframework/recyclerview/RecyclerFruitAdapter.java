package com.example.qcframework.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qcframework.MainActivity;
import com.example.qcframework.R;
import com.example.qcframework.utils.ActivityController;

import java.util.List;

public class RecyclerFruitAdapter extends RecyclerView.Adapter<RecyclerFruitAdapter.ViewHolder>{
    private List<RecyclerFruit> mFruitList;
    Context activity;


    public RecyclerFruitAdapter(List<RecyclerFruit>fruitList, Context packageContext){

        mFruitList = fruitList;
        activity = packageContext;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_fruit_item,viewGroup,false);

        //给view添加点击事件
        final ViewHolder holder = new ViewHolder(view);
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                RecyclerFruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(),"you clicked view   " + fruit.getName(),Toast.LENGTH_SHORT).show();

                /*
                    跳转控制器
                 */

                ActivityController activityController = new ActivityController();
                activityController.intentPush(activity,fruit.getName());


            }
        });
//        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int position = holder.getAdapterPosition();
//                RecyclerFruit fruit = mFruitList.get(position);
//                Toast.makeText(v.getContext(),"you clicked image   " + fruit.getName(),Toast.LENGTH_SHORT).show();
//
//            }
//        });
        return  holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {


        RecyclerFruit fruit = mFruitList.get(i);
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());


    }

    @Override
    public int getItemCount() {
        return mFruitList.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fruitView = itemView;
            fruitImage = (ImageView) itemView.findViewById(R.id.recycler_fruit_image);
            fruitName = (TextView) itemView.findViewById(R.id.recycler_fruit_name);

        }
    }
}
