package com.cct.marvelwallapop.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by carloscarrasco on 11/8/16.
 */

public class MarvelResponse {
    @SerializedName("code")
    private int code;
    @SerializedName("status")
    private String status;
    @SerializedName("copyright")
    private String copyright;
    @SerializedName("attributionText")
    private String attributionText;
    @SerializedName("attributionHTML")
    private String getAttributionHtml;
    @SerializedName("etag")
    private String etag;

    @SerializedName("data")
    private MarvelResult response;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getAttributionText() {
        return attributionText;
    }

    public void setAttributionText(String attributionText) {
        this.attributionText = attributionText;
    }

    public String getGetAttributionHtml() {
        return getAttributionHtml;
    }

    public void setGetAttributionHtml(String getAttributionHtml) {
        this.getAttributionHtml = getAttributionHtml;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public MarvelResult getResponse() {
        return response;
    }

    public void setResponse(MarvelResult response) {
        this.response = response;
    }
}
