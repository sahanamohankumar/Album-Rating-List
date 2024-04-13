package com.example.project;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class albums implements Parcelable {
    private String name, duration, year, numberOfSongs, awardsWon;
    private int imgSource,num;
    private float rating;

    public albums(String name, String duration, String year, String numberOfSongs,String awardsWon, int imgSource,int num) {
        this.name=name;
        this.duration=duration;
        this.year=year;
        this.numberOfSongs=numberOfSongs;
        this.awardsWon= awardsWon;
        this.imgSource = imgSource;
        this.num=num;

    }

    protected albums(Parcel in) {
        name = in.readString();
        duration = in.readString();
        year = in.readString();
        numberOfSongs = in.readString();
        awardsWon = in.readString();
        imgSource = in.readInt();
        rating = in.readFloat();
        num=in.readInt();
    }

    public static final Creator<albums> CREATOR = new Creator<albums>() {
        @Override
        public albums createFromParcel(Parcel in) {
            return new albums(in);
        }

        @Override
        public albums[] newArray(int size) {
            return new albums[size];
        }
    };

    public String getName(){

        return name;
    }
    public String getDuration(){

        return duration;
    }
    public String getYear(){

        return year;
    }
    public String getNumberOfSongs(){

        return numberOfSongs;
    }
    public String getAwardsWon(){

        return awardsWon;
    }
    public int getimgSource(){

        return imgSource;
    }
    public Float getRating(){

        return rating;
    }
    public Float setRating(float x){
        this.rating = x;
        return rating;
    }
    public int getNum(){
        return num;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(duration);
        dest.writeString(year);
        dest.writeString(numberOfSongs);
        dest.writeString(awardsWon);
        dest.writeInt(imgSource);
        dest.writeFloat(rating);
        dest.writeInt(num);


    }
}

