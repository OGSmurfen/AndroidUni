package com.papasmurfie.upr7;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Vegetable implements Parcelable {
    private String name;
    private int price;
    private double quantity;
    protected Vegetable(Parcel in) {
        name = in.readString();
        price = in.readInt();
        quantity = in.readDouble();

    }

    public static final Creator<Vegetable> CREATOR = new Creator<Vegetable>() {
        @Override
        public Vegetable createFromParcel(Parcel in) {
            return new Vegetable(in);
        }

        @Override
        public Vegetable[] newArray(int size) {
            return new Vegetable[size];
        }
    };
    public Vegetable(String name, int price, double quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(price);
        parcel.writeDouble(quantity);
    }
}
