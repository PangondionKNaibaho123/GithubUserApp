package com.zephyr.githubuserapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class user_github implements Parcelable {
    private String url_userpict;
    private String username;
    private String name;

    public user_github(){

    }

    public String getUrl_userpict() {
        return url_userpict;
    }

    public void setUrl_userpict(String url_userpict) {
        this.url_userpict = url_userpict;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected user_github(Parcel in) {
        url_userpict = in.readString();
        username = in.readString();
        name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(url_userpict);
        parcel.writeString(username);
        parcel.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<user_github> CREATOR = new Creator<user_github>() {
        @Override
        public user_github createFromParcel(Parcel in) {
            return new user_github(in);
        }

        @Override
        public user_github[] newArray(int size) {
            return new user_github[size];
        }
    };

}
