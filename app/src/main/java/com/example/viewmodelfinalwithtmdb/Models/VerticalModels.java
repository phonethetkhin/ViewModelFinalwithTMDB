package com.example.viewmodelfinalwithtmdb.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class VerticalModels implements Parcelable {
    String title;
List<HorizontalModels> horizontalModelsList;

    public VerticalModels(String title, List<HorizontalModels> horizontalModelsList) {
        this.title = title;
        this.horizontalModelsList = horizontalModelsList;
    }

    public String getTitle() {
        return title;
    }

    public List<HorizontalModels> getHorizontalModelsList() {
        return horizontalModelsList;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeTypedList(this.horizontalModelsList);
    }

    protected VerticalModels(Parcel in) {
        this.title = in.readString();
        this.horizontalModelsList = in.createTypedArrayList(HorizontalModels.CREATOR);
    }

    public static final Parcelable.Creator<VerticalModels> CREATOR = new Parcelable.Creator<VerticalModels>() {
        @Override
        public VerticalModels createFromParcel(Parcel source) {
            return new VerticalModels(source);
        }

        @Override
        public VerticalModels[] newArray(int size) {
            return new VerticalModels[size];
        }
    };
}
