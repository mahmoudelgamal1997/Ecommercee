package katar.example.elgaml.ecommerce.retrofit;


import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRequest {
    private static final String BASE_URL = "https://e-commerce-dev.intcore.net/api/";
    private static Retrofit retrofit;
    static HeaderInterceptor headerInterceptor = new HeaderInterceptor();

       public static OkHttpClient getOkHttpClient(){
       return  new OkHttpClient.Builder()
                .addInterceptor(headerInterceptor)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .client(getOkHttpClient())
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static <S> S cteateService(Class<S> serviceClass) {
        return getRetrofitInstance().create(serviceClass);
    }


}