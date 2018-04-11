package com.example.mahafuz.shivamssanwich;

import android.graphics.Color;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Mahafuz on 3/23/2018.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
    String item_name_array[] = new String[]{"Sandwich","Burger","Pasta","Maggi","Coffee","Drink","Dessert"};

    int image_array[] = new int[]{
            R.mipmap.sandwich_icon,
    };
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.item_name.setText(item_name_array[position]);

    }

    @Override
    public int getItemCount() {
        return item_name_array.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView item_name;
        ImageView food_image;
        ConstraintLayout constraintLayout;
        public MyViewHolder(View itemView) {
            super(itemView);
            item_name = itemView.findViewById(R.id.name_food);
            food_image = itemView.findViewById(R.id.foodImage);
            constraintLayout = itemView.findViewById(R.id.item_cl);

        }
    }
}
