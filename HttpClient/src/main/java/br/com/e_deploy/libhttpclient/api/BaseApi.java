package br.com.e_deploy.libhttpclient.api;

import java.lang.reflect.ParameterizedType;

/**
 * Created by lcarvalho on 02/03/2018.
 */

public class BaseApi<I> {

    private Class<I> classI;

    @SuppressWarnings("unchecked")
    public BaseApi() {
        this.classI = (Class<I>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public I getApi() {
        return ApiClient.getInstance().getClient().create(classI);
    }
}
