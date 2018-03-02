package br.com.e_deploy.libhttpclient.exceptions;

/**
 * Created by lcarvalho on 02/03/2018.
 */

public class URLException extends CoreException {

    public URLException() {
        super("Endpoint não encontrado");
    }
}
