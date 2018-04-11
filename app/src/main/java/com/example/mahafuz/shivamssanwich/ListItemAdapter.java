package com.example.mahafuz.shivamssanwich;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import nl.dionsegijn.steppertouch.OnStepCallback;
import nl.dionsegijn.steppertouch.StepperTouch;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.MyViewHolder> {
    Context context;
    ViewGroup viewGroup;
    String[] nameData;
    String[] priceData;
    String user = FirebaseAuth.getInstance().getCurrentUser().getUid();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = database.getReference("Cart").child(user);

    public ListItemAdapter(String[] nameData, String[] priceData) {
        this.nameData = nameData;
        this.priceData = priceData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_data,parent,false);
        context = parent.getContext();
        this.viewGroup = parent;
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.foodName.setText(nameData[position]);
        holder.price.setText(priceData[position]);
        holder.addtoCard.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.addtoCard.setVisibility(View.GONE);
                holder.stepperTouch.setVisibility(View.VISIBLE);
                holder.stepperTouch.stepper.setMin(0);
                holder.stepperTouch.stepper.setValue(1);
                holder.stepperTouch.enableSideTap(true);
                Map<String, Integer> cartData = new HashMap<>();
                cartData.put("Price", Integer.parseInt(holder.price.getText().toString()));
                databaseReference.child(holder.foodName.getText().toString()).setValue(cartData);
            }
        });
        holder.stepperTouch.stepper.addStepCallback(new OnStepCallback() {
            @Override
            public void onStep(int i, boolean b) {
                if (i == 0) {
                    holder.stepperTouch.setVisibility(View.GONE);
                    holder.addtoCard.setVisibility(View.VISIBLE);
                    databaseReference.child(holder.foodName.getText().toString()).removeValue();

                }else {
                    Map<String, Integer> cartData = new HashMap<>();
                    cartData.put("Price", Integer.parseInt(holder.price.getText().toString())*i);
                    databaseReference.child(holder.foodName.getText().toString()).setValue(cartData);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return nameData.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        StepperTouch stepperTouch;
        Button addtoCard;
        TextView foodName,price;
        public MyViewHolder(View itemView) {
            super(itemView);
            stepperTouch = itemView.findViewById(R.id.stepper_touch);
            addtoCard = itemView.findViewById(R.id.addtocard);
            foodName = itemView.findViewById(R.id.foodName);
            price = itemView.findViewById(R.id.price);


        }

    }


}
