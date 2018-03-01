package br.com.e_deploy.libhttpclient.response;

import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;

public class Response<ENTITY_RESPONSE> {

    @SerializedName("error")
    private Boolean error;

    @SerializedName("errorMessage")
    private String errorMessage;

    @SerializedName("data")
    private ENTITY_RESPONSE data;

    public Boolean getError() {
        return error == null ? false : error;
    }

    public String getErrorMessage() {
        return TextUtils.isEmpty(errorMessage) ? "" : errorMessage.trim();
    }

    public ENTITY_RESPONSE getData() {
        return data;
    }
}
