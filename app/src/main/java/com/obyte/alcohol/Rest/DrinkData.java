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

    @SerializedName("규격")
    @Expose
    private String volume;

    @SerializedName("주원료")
    @Expose
    private String ingredients;

    @SerializedName("제조사")
    @Expose
    private String manufacturer;

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }

    public String getVolume() {
        return volume;
    }

    public String getIngredients() {return ingredients;}

    public String getManufacturer() {return manufacturer;}
}
