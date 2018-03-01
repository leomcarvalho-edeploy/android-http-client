# android-http-client
Componentes E-Deploy

Como usar:

Criar Interface do Retrofit:

    public interface MyRequestRetrofit{

        @GET("banner/api/banner")
        Observable<Response<ArrayList<BannerResponse>>> getBanner();

    }
    
Exemplo de implementação na Application:

    public class AppApplication extends Application {
    
        public ApiClient apiClient;
    
        @Override
        public void onCreate() {
            super.onCreate();
            apiClient = ApiClient.getInstance();
            ApiClient.apiRequest.setApiKey("8f14ce06-22ce-4de2-8e0d-9ee3ae5dcdd7");
            apiClient.apiRequest.setAppId("123");
            apiClient.apiRequest.setEndPoint("http://bkapp.devedp.com.br:6080/hom/v2/");
            apiClient.withLog();
        }
    
        public Retrofit getApiClient(){
            return apiClient.getClient();
        }
    }
    
Exemplo do retorno:

    public class MainActivity extends AppCompatActivity {
        @App
        public AppApplication appAplication;
    
        MyRequestRetrofit apiService;
    
        @AfterViews
        public void init() {
            apiService = appAplication.getApiClient().create(MyRequestRetrofit.class);
    
            apiService.getBanner().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
                    .subscribe(new Observer<Response<ArrayList<BannerResponse>>>() {
                        @Override
                        public void onSubscribe(Disposable d) {
    
                        }
    
                        @Override
                        public void onNext(Response<ArrayList<BannerResponse>> value) {
                            try {
                                Log.i("Teste API", value.toString());
                            } catch (Exception e) {
                                try {
                                    ErrorResponse errorResponse = new ErrorResponse();
                                    errorResponse.setServerError(true);
                                } catch (Exception ignore) {
                                    e.printStackTrace();
                                }
                            }
                        }
    
                        @Override
                        public void onError(Throwable e) {
                            Log.i("Error", e.toString());
                        }
    
                        @Override
                        public void onComplete() {
                            Log.i("Complete", "Completed");
                        }
                    });
        }
    }
