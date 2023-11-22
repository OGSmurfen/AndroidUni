package com.papasmurfie.upr4.FRAGM;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class BirthdayCard implements Parcelable {
    private  String name;
    private int age;
    private String wish;
    private int background_color;

    public BirthdayCard(String name, int age, String wish, int background_color) {
        this.name = name;
        this.age = age;
        this.wish = wish;
        this.background_color = background_color;
    }

    protected BirthdayCard(Parcel in) {
        name = in.readString();
        age = in.readInt();
        wish = in.readString();
        background_color = in.readInt();
    }

    public static final Creator<BirthdayCard> CREATOR = new Creator<BirthdayCard>() {
        @Override
        public BirthdayCard createFromParcel(Parcel in) {
            return new BirthdayCard(in);
        }

        @Override
        public BirthdayCard[] newArray(int size) {
            return new BirthdayCard[size];
        }
    };

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getWish() {
        return wish;
    }

    public int getBackground_color() {
        return background_color;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(age);
        parcel.writeString(wish);
        parcel.writeInt(background_color);
    }

    @Override
    public String toString() {
        return "BirthdayCard{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", wish='" + wish + '\'' +
                ", background_color=" + background_color +
                '}';
    }
}
