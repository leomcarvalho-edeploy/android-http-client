package br.com.e_deploy.libhttpclient.api;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import br.com.e_deploy.libhttpclient.models.ApiRequest;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private OkHttpClient.Builder clientBuilder;

    private static volatile ApiClient apiClientInstance;

    public static volatile ApiRequest apiRequest;

    private ApiClient(){}

    public static ApiClient getInstance() {
        if(apiClientInstance == null){
            apiClientInstance = new ApiClient();
            apiRequest = ApiRequest.getInstance();
        }
        return apiClientInstance;
    }

    public Retrofit getClient() {
        if(clientBuilder==null) {
            clientBuilder = getClientBuilder();
        }
        return new Retrofit.Builder()
                .baseUrl(apiRequest.getEndPoint())
                .client(clientBuilder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private OkHttpClient.Builder getClientBuilder(){
        return new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(new RetrofitInterceptor(apiRequest));
    }

    public void withLog() {
        try {
            clientBuilder = RetrofitLogging.logging(clientBuilder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
