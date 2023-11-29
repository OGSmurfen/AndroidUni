package com.papasmurfie.upr7;

import android.os.Parcel;

import androidx.annotation.NonNull;

public class Fruit extends Vegetable{
    private int sweetIndex;

    public int getSweetIndex() {
        return sweetIndex;
    }

    public void setSweetIndex(int sweetIndex) {
        this.sweetIndex = sweetIndex;
    }
    public Fruit(String name, int price, double quantity, int sweetIndex) {
        super(name, price, quantity);
        this.sweetIndex = sweetIndex;
    }
    protected Fruit(Parcel in) {
        super(in);
        this.sweetIndex = in.readInt();
    }

    @Override
    public int describeContents() {
        return super.describeContents();
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(sweetIndex);
    }

    public static final Creator<Fruit> CREATOR = new Creator<Fruit>() {
        @Override
        public Fruit createFromParcel(Parcel in) {
            return new Fruit(in);
        }

        @Override
        public Fruit[] newArray(int size) {
            return new Fruit[size];
        }
    };
}
