package com.example.mahafuz.shivamssanwich;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.aakira.expandablelayout.ExpandableLayout;
import com.github.aakira.expandablelayout.ExpandableLayoutListenerAdapter;
import com.github.aakira.expandablelayout.ExpandableLinearLayout;
import com.github.aakira.expandablelayout.Utils;

import java.util.List;

import nl.dionsegijn.steppertouch.StepperTouch;

public class RecyclerViewRecyclerAdapter extends RecyclerView.Adapter<RecyclerViewRecyclerAdapter.ViewHolder> {

    private final List<ItemModel> data;
    private Context context;
    private ViewGroup parent;
    private SparseBooleanArray expandState = new SparseBooleanArray();
    ListItemAdapter adapter;

    public RecyclerViewRecyclerAdapter(final List<ItemModel> data) {
        this.data = data;
        for (int i = 0; i < data.size(); i++) {
            expandState.append(i, false);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        this.context = parent.getContext();
        this.parent = parent;
        return new ViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.recycler_view_list_row, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        setHolder(position,holder);
        
        holder.recyclerView.setLayoutManager(new GridLayoutManager(context,3));
        final ItemModel item = data.get(position);
        holder.setIsRecyclable(false);
        holder.textView.setText(item.description);
        holder.itemView.setBackgroundColor(ContextCompat.getColor(context, item.colorId1));
        holder.expandableLayout.setInRecyclerView(true);
        //holder.expandableLayout.setBackgroundColor(ContextCompat.getColor(context, item.colorId2));
        holder.expandableLayout.setInterpolator(item.interpolator);
        holder.expandableLayout.setExpanded(expandState.get(position));

        holder.expandableLayout.setListener(new ExpandableLayoutListenerAdapter() {
            @Override
            public void onPreOpen() {
                //createRotateAnimator(holder.buttonLayout, 0f, 180f).start();
                holder.view_layout.setVisibility(View.GONE);
                expandState.put(position, true);
                holder.backgroundLayout.setBackgroundResource(R.color.material_yellow_100);
            }

            @Override
            public void onPreClose() {
                //createRotateAnimator(holder.buttonLayout, 180f, 0f).start();
                holder.view_layout.setVisibility(View.VISIBLE);
                expandState.put(position, false);
                holder.backgroundLayout.setBackgroundResource(R.color.white);
            }
        });

        //holder.buttonLayout.setRotation(expandState.get(position) ? 180f : 0f);
        holder.buttonLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                onClickButton(holder.expandableLayout);
            }
        });
    }

    private void setHolder(int position,ViewHolder holder) {
        String[] sandwichData = new String[]{"Veg Sandwich","Veg Cheese Sandwich","Paneer Sandwich","Paneer Cheese Sandwich",
                "Paneer Corn Sandwich","Paneer Corn Cheese Sandwich","Paneer Masala Sandwich","Paneer Masala Cheese Sandwich",
                "Mushroom Sandwich","Chicken Sandwich","Chicken Cheese Sandwich"
        };
        String[] sandwichPriceData = new String[]{"35","50","45","60","45","60","45","60","70","75","90"};

        String[] sweetSandwichName = new String[]{"Ice Cream Sandwich","Chocolate Cheese Sandwich"};
        String[] sweetSandwichPrice = new String[]{"70","55"};

        String[] masalaSandwich = new String[]{"Masala Sandwich","Masala Cheese Sandwich"};
        String[] masalaSandwichPrice = new String[]{"40","65"};

        String[] pizzaSandwichName = new String[]{"Pizza Sandwich","Mayo Pizza Sandwich","Masala Pizza Sandwich","American Corn Sandwich",
                "Pizza Sandwich with Mushroom","Chicken Pizza Sandwich","Chicken Cheese Sandwich"
        };

        String[] pizzaSandwichPrice = new String[]{"70","85","95","65","65","90","90","90"};

        String[] burgerData = new String[]{"Veg Burger","Veg Cheese Burger","Paneer Burger","Paneer Cheese Burger"};
        String[] burgerPriceData = new String[]{"35","50","45","60"};

        String[] pastaName = new String[]{"White Sauce","Mix Sauce","White Sauce Pasta with Chicken","Mix Sauce Pasta with Chicken"};
        String[] pastaPrice = new String[]{"70","70","90","90"};

        String[] maggiName = new String[]{"Veg Maggi","Veg Cheese Maggi","Chilli Maggi",
                "Chicken Maggi","Chicken Cheese Maggi","Chilli Maggi with Chicken"};
        String[] maggiPrice = new String[]{"30","40","50","50","65","70"};

        String[] coffeeName = new String[]{"Hot Coffee","Cold Coffee","Oreo Shake"};
        String[] coffeePrice = new String[]{"15","35","70"};

        String[] drinkName = new String[]{"Blue Lagoon","Strawberry Crush","Black Current"};
        String[] drinkPrice = new String[]{"40","35","35"};

        String[] dessertName = new String[]{"Vanilla Ice Cream"};
        String[] dessertPrice = new String[]{"70"};


        switch (position){
            case 0:
                adapter = new ListItemAdapter(sandwichData,sandwichPriceData);
                holder.recyclerView.setAdapter(adapter);
                break;
            case 1:
                adapter = new ListItemAdapter(sweetSandwichName,sweetSandwichPrice);
                holder.recyclerView.setAdapter(adapter);
                break;
            case 2:
                adapter = new ListItemAdapter(masalaSandwich,masalaSandwichPrice);
                holder.recyclerView.setAdapter(adapter);
                break;
            case 3:
                adapter = new ListItemAdapter(pizzaSandwichName,pizzaSandwichPrice);
                holder.recyclerView.setAdapter(adapter);
                break;
            case 4:
                adapter = new ListItemAdapter(maggiName,maggiPrice);
                holder.recyclerView.setAdapter(adapter);
                break;
            case 5:
                adapter = new ListItemAdapter(pastaName,pastaPrice);
                holder.recyclerView.setAdapter(adapter);
                break;
            case 6:
                adapter = new ListItemAdapter(burgerData,burgerPriceData);
                holder.recyclerView.setAdapter(adapter);
                break;
            case 7:
                adapter = new ListItemAdapter(coffeeName,coffeePrice);
                holder.recyclerView.setAdapter(adapter);
                break;
            case 8:
                adapter = new ListItemAdapter(drinkName,drinkPrice);
                holder.recyclerView.setAdapter(adapter);
                break;
            case 9:
                adapter = new ListItemAdapter(dessertName,dessertPrice);
                holder.recyclerView.setAdapter(adapter);
                break;
        }
    }

    private void onClickButton(final ExpandableLayout expandableLayout) {
        expandableLayout.toggle();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public LinearLayout buttonLayout,backgroundLayout;
        public View view_layout;
        public RecyclerView recyclerView;
        public ExpandableLinearLayout expandableLayout;

        public ViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.name_food);
            buttonLayout = v.findViewById(R.id.ll_recycler_view);
            expandableLayout = v.findViewById(R.id.expandableLayout);
            view_layout = v.findViewById(R.id.layout_view_home);
            backgroundLayout = v.findViewById(R.id.item_cl);
            recyclerView = v.findViewById(R.id.listData);
        }
    }

    public ObjectAnimator createRotateAnimator(final View target, final float from, final float to) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(target, "rotation", from, to);
        animator.setDuration(300);
        animator.setInterpolator(Utils.createInterpolator(Utils.LINEAR_INTERPOLATOR));
        return animator;
    }
}