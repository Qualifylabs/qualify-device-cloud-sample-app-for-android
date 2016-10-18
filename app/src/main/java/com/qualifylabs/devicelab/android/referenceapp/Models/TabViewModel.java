package com.qualifylabs.devicelab.android.referenceapp.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Model representing a tab within the viewpager
 */
public final class TabViewModel implements Parcelable{
    private String tab_id;
    private String tab_name;
    private String tab_headline;

    public String getTab_id() {
        return tab_id;
    }

    public String getTab_name() {
        return tab_name;
    }

    public String getTab_headline() {
        return tab_headline;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.tab_id);
        dest.writeString(this.tab_name);
        dest.writeString(this.tab_headline);
    }

    public TabViewModel() {
    }

    protected TabViewModel(Parcel in) {
        this.tab_id = in.readString();
        this.tab_name = in.readString();
        this.tab_headline = in.readString();
    }

    public static final Creator<TabViewModel> CREATOR = new Creator<TabViewModel>() {
        public TabViewModel createFromParcel(Parcel source) {
            return new TabViewModel(source);
        }

        public TabViewModel[] newArray(int size) {
            return new TabViewModel[size];
        }
    };
}
