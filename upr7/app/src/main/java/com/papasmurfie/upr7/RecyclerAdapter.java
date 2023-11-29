package com.papasmurfie.upr7;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerHolder> {
    private List<Vegetable> shopData;
    private Context context;

    public RecyclerAdapter(List<Vegetable> shopData){
        this.shopData = shopData;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inicializirame contexta kudeto se namira RecyclerView(view)
        context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);

        //Suzdava View ot personaliziran izgled(layot_line_item)
        View shopView = inflater.inflate(R.layout.recycler_lineine_item_layout, parent, false);

        //suzdavane holder chrez view
        RecyclerHolder holder = new RecyclerHolder(shopView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
        //Vzemame tekustiq element ot kolekciqta
        Vegetable item = shopData.get(position);

        //postavqne stoinostta v suotvetniq TextView
        holder.setName(item.getName());
        holder.setPrice(item.getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(item instanceof Fruit)
                {
                    Fruit fruit = (Fruit) item;
                    Intent intent = new Intent(context, ItemData.class);
                    intent.putExtra("fruit", fruit);
                    ((Activity)context).startActivity(intent);
                }else {
                    Vegetable vegetable = (Vegetable) item;
                    Intent intent = new Intent(context, ItemData.class);
                    intent.putExtra("vegetable", vegetable);
                    ((Activity)context).startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return shopData.size();
    }
}
