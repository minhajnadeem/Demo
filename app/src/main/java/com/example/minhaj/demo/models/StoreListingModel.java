package com.example.minhaj.demo.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Minhaj on 15/09/2018.
 */
public class StoreListingModel implements Parcelable{

    private int resDrawableImg,unitPrice,dozenPrice,halfDozenPrice;
    private ArrayList<Integer> arrayListDetailImages;

    public StoreListingModel(int resDrawableImg,int unitPrice,int dozenPrice,int halfDozenPrice,ArrayList<Integer> arrayListDetailImages){
        setResDrawableImg(resDrawableImg);
        setUnitPrice(unitPrice);
        setDozenPrice(dozenPrice);
        setHalfDozenPrice(halfDozenPrice);
        setArrayListDetailImages(arrayListDetailImages);
    }

    protected StoreListingModel(Parcel in) {
        resDrawableImg = in.readInt();
        unitPrice = in.readInt();
        dozenPrice = in.readInt();
        halfDozenPrice = in.readInt();
        arrayListDetailImages = (ArrayList<Integer>) in.readSerializable();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(resDrawableImg);
        dest.writeInt(unitPrice);
        dest.writeInt(dozenPrice);
        dest.writeInt(halfDozenPrice);
        dest.writeSerializable(arrayListDetailImages);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<StoreListingModel> CREATOR = new Creator<StoreListingModel>() {
        @Override
        public StoreListingModel createFromParcel(Parcel in) {
            return new StoreListingModel(in);
        }

        @Override
        public StoreListingModel[] newArray(int size) {
            return new StoreListingModel[size];
        }
    };

    public int getResDrawableImg() {
        return resDrawableImg;
    }

    public void setResDrawableImg(int resDrawableImg) {
        this.resDrawableImg = resDrawableImg;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getDozenPrice() {
        return dozenPrice;
    }

    public void setDozenPrice(int dozenPrice) {
        this.dozenPrice = dozenPrice;
    }

    public int getHalfDozenPrice() {
        return halfDozenPrice;
    }

    public void setHalfDozenPrice(int halfDozenPrice) {
        this.halfDozenPrice = halfDozenPrice;
    }

    public ArrayList<Integer> getArrayListDetailImages() {
        return arrayListDetailImages;
    }

    public void setArrayListDetailImages(ArrayList<Integer> arrayListDetailImages) {
        this.arrayListDetailImages = arrayListDetailImages;
    }

}
