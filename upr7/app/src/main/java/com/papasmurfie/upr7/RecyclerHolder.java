package com.papasmurfie.upr7;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
//First create line layout
public class RecyclerHolder extends RecyclerView.ViewHolder {
    private TextView name;
    private TextView price;
    public RecyclerHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.linear_name);
        price = itemView.findViewById(R.id.linear_Price);
    }
    public void setName(String name) {
        this.name.setText(name);
    }
    public void setPrice(double price) {
        this.price.setText(Double.toString(price));
    }
}
