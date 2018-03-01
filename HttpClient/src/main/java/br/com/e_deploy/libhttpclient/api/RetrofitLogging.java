package br.com.e_deploy.libhttpclient.api;


import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Interceptor for Retrofit to add auth attributes to header
 */
public abstract class RetrofitLogging {
    public static OkHttpClient.Builder logging(OkHttpClient.Builder clientBuilder) throws IOException {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        clientBuilder.addInterceptor(logging);

        return clientBuilder.addInterceptor(logging);
    }
}
