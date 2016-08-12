package com.cct.marvelwallapop.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by carloscarrasco on 10/8/16.
 */

public class Image implements Serializable{

    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("extension")
    @Expose
    private String extension;

    public String getImage() {
        return path + "." + extension;
    }

    private String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
