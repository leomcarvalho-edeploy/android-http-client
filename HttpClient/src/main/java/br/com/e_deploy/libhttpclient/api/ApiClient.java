package br.com.e_deploy.libhttpclient.api;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import br.com.e_deploy.libhttpclient.exceptions.URLException;
import br.com.e_deploy.libhttpclient.models.ApiRequest;
import io.reactivex.annotations.NonNull;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static ApiClient apiClientInstance;

    private OkHttpClient.Builder clientBuilder;
    private ApiRequest apiRequest;
    private Retrofit client;

    private ApiClient() {
        apiClientInstance = this;
        apiRequest = new ApiRequest();
        clientBuilder = new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(new RetrofitInterceptor(apiRequest));
    }

    @NonNull
    public static ApiClient getInstance() {
        if (apiClientInstance == null) {
            new ApiClient();
        }
        return apiClientInstance;
    }

    protected Retrofit getClient() {
        if(client == null) {
            throw new URLException();
        }
        return client;
    }

    public void setApiKey(String apiKey) {
        apiRequest.setApiKey(apiKey);
    }

    public void setEndPoint(String endPoint) {
        apiRequest.setEndPoint(endPoint);
        client = new Retrofit.Builder()
                .baseUrl(apiRequest.getEndPoint())
                .client(clientBuilder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void setAppId(String appId) {
        apiRequest.setAppId(appId);
    }

    public void withLog() {
        try {
            clientBuilder = RetrofitLogging.logging(clientBuilder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
