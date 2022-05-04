package com.obyte.alcohol.Rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DrinkData {
    @SerializedName("전통주명")
    @Expose
    private String name;

    @SerializedName("도수")
    @Expose
    private String level;

    @SerializedName("용량")
    @Expose
    private String volume;

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }

    public String getVolume() {
        return volume;
    }
}
