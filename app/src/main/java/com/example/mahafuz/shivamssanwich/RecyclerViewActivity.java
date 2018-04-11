package com.example.mahafuz.shivamssanwich;


import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.github.aakira.expandablelayout.Utils;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RecyclerViewActivity extends AppCompatActivity {
    NestedScrollView scrollView;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();

    }

    @BindView(R.id.navigation) BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);

        scrollView = findViewById(R.id.scrollView_recycler);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.cart_nav) {
                    Intent intent = new Intent(getApplicationContext(), NewLayout.class);
                    ActivityOptions options = null;
                    options = ActivityOptions.makeSceneTransitionAnimation(
                            RecyclerViewActivity.this,
                            android.util.Pair.create((View) bottomNavigationView, "bg"));
                    startActivity(intent, options.toBundle());
                }
                return false;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.nav_home);


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

        scrollView.getParent().requestChildFocus(scrollView, scrollView);


    }
}
