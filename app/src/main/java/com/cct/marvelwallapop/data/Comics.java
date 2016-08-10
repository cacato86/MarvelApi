
package com.cct.marvelwallapop.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class Comics {

    @SerializedName("available")
    @Expose
    private Integer available;
    @SerializedName("items")
    @Expose
    private List<Comic> items = new ArrayList<>();

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public List<Comic> getItems() {
        return items;
    }

    public void setItems(List<Comic> items) {
        this.items = items;
    }
}
