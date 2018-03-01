package br.com.e_deploy.libhttpclient.listerner;

import br.com.e_deploy.libhttpclient.response.ErrorResponse;

public interface ResponseListerner<MODEL> {

    void success(MODEL response);

    void error(ErrorResponse errorResponse);
}
