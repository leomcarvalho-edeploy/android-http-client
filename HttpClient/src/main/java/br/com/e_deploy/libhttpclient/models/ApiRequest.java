package br.com.e_deploy.libhttpclient.models;

public class ApiRequest{

    private String endPoint;
    private String authEndPoint;
    private String consumerKey;
    private String consumerSecret;
    private String authToken;
    private String appId;
    private String apiKey;
    private String contentType = "application/json";
    private Boolean withAuth = false;

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getAuthEndPoint() {
        return authEndPoint;
    }

    public void setAuthEndPoint(String authEndPoint) {
        this.authEndPoint = authEndPoint;
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public void setConsumerKey(String consumerKey) {
        this.consumerKey = consumerKey;
    }

    public String getConsumerSecret() {
        return consumerSecret;
    }

    public void setConsumerSecret(String consumerSecret) {
        this.consumerSecret = consumerSecret;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Boolean withAuth() {
        return withAuth;
    }

    public void withAuth(Boolean withAuth) {
        this.withAuth = withAuth;
    }
}
