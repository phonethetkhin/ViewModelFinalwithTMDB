package com.example.viewmodelfinalwithtmdb.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class HorizontalModels implements Parcelable {
    private String Photo,Name;
    private double Rating;

    public HorizontalModels(String photo, String name, double rating) {
        Photo = photo;
        Name = name;
        Rating = rating;
    }

    public String getPhoto() {
        return Photo;
    }

    public String getName() {
        return Name;
    }

    public double getRating() {
        return Rating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Photo);
        dest.writeString(this.Name);
        dest.writeDouble(this.Rating);
    }

    protected HorizontalModels(Parcel in) {
        this.Photo = in.readString();
        this.Name = in.readString();
        this.Rating = in.readDouble();
    }

    public static final Creator<HorizontalModels> CREATOR = new Creator<HorizontalModels>() {
        @Override
        public HorizontalModels createFromParcel(Parcel source) {
            return new HorizontalModels(source);
        }

        @Override
        public HorizontalModels[] newArray(int size) {
            return new HorizontalModels[size];
        }
    };
}
