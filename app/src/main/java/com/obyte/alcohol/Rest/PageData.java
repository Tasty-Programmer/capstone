package com.obyte.alcohol.Rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;

public class PageData {
    @SerializedName("data")
    @Expose
    private ArrayList<DrinkData> data;

    public ArrayList<DrinkData> getData() {
        return data;
    }
}
