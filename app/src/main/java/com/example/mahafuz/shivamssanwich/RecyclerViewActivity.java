package com.example.mahafuz.shivamssanwich;


import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.github.aakira.expandablelayout.Utils;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewActivity extends AppCompatActivity {
    NestedScrollView scrollView;
    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        scrollView = findViewById(R.id.scrollView_recycler);
        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),NewLayout.class);
                ActivityOptions options = null;
                options = ActivityOptions.makeSceneTransitionAnimation(
                        RecyclerViewActivity.this,
                        android.util.Pair.create((View)fab,"bg"));
                startActivity(intent,options.toBundle());
            }
        });


        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final List<ItemModel> data = new ArrayList<>();
        data.add(new ItemModel(
                "Sandwich",
                R.color.material_yellow_100,
                R.color.material_yellow_100,
                Utils.createInterpolator(Utils.FAST_OUT_LINEAR_IN_INTERPOLATOR)));
        data.add(new ItemModel(
                "Sweet Sandwich",
                R.color.material_yellow_100,
                R.color.material_yellow_100,
                Utils.createInterpolator(Utils.FAST_OUT_LINEAR_IN_INTERPOLATOR)));
        data.add(new ItemModel(
                "Masala Sandwich",
                R.color.material_yellow_100,
                R.color.material_yellow_100,
                Utils.createInterpolator(Utils.FAST_OUT_LINEAR_IN_INTERPOLATOR)));
        data.add(new ItemModel(
                "Pizza Sandwich",
                R.color.material_yellow_100,
                R.color.material_yellow_100,
                Utils.createInterpolator(Utils.FAST_OUT_LINEAR_IN_INTERPOLATOR)));
        data.add(new ItemModel(
                "Maggi",
                R.color.material_yellow_100,
                R.color.material_yellow_100,
                Utils.createInterpolator(Utils.FAST_OUT_LINEAR_IN_INTERPOLATOR)));
        data.add(new ItemModel(
                "Pasta",
                R.color.material_yellow_100,
                R.color.material_yellow_100,
                Utils.createInterpolator(Utils.FAST_OUT_LINEAR_IN_INTERPOLATOR)));
        data.add(new ItemModel(
                "Burger",
                R.color.material_yellow_100,
                R.color.material_yellow_100,
                Utils.createInterpolator(Utils.FAST_OUT_LINEAR_IN_INTERPOLATOR)));
        data.add(new ItemModel(
                "Coffee",
                R.color.material_yellow_100,
                R.color.material_yellow_100,
                Utils.createInterpolator(Utils.FAST_OUT_LINEAR_IN_INTERPOLATOR)));
        data.add(new ItemModel(
                "Drinks",
                R.color.material_yellow_100,
                R.color.material_yellow_100,
                Utils.createInterpolator(Utils.FAST_OUT_LINEAR_IN_INTERPOLATOR)));
        data.add(new ItemModel(
                "Dessert",
                R.color.material_yellow_100,
                R.color.material_yellow_100,
                Utils.createInterpolator(Utils.FAST_OUT_LINEAR_IN_INTERPOLATOR)));

        recyclerView.setAdapter(new RecyclerViewRecyclerAdapter(data));

        scrollView.getParent().requestChildFocus(scrollView,scrollView);


    }
}
