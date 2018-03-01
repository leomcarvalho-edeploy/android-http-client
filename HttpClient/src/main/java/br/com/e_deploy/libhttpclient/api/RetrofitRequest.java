package br.com.e_deploy.libhttpclient.api;


import br.com.e_deploy.libhttpclient.models.ApiRequest;
import okhttp3.Request;

/**
 * Interceptor for Retrofit to add auth attributes to header
 */
public abstract class RetrofitRequest {

    public static Request getRequest(Request original, ApiRequest apiRequest) {
        Request.Builder requestBuilder = original.newBuilder();
        if(!apiRequest.getAppId().isEmpty()) {
            requestBuilder.addHeader("appId", apiRequest.getAppId());
        }
        if(!apiRequest.getApiKey().isEmpty()) {
            requestBuilder.header("api-key", apiRequest.getApiKey());
        }
        requestBuilder.header("Content-Type", apiRequest.getContentType());
        requestBuilder.method(original.method(), original.body());

        return requestBuilder.build();
    }

}
