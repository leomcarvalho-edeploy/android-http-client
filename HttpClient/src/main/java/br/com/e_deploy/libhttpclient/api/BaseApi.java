package br.com.e_deploy.libhttpclient.api;

import io.reactivex.annotations.NonNull;

/**
 * Created by lcarvalho on 02/03/2018.
 */

public class BaseApi<I> {

    private I api;

    public BaseApi(@NonNull Class<I> type) {
        this.api = ApiClient.getInstance().getClient().create(type);
    }

    public I getApi() {
        return api;
    }
}
