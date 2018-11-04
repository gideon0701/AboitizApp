package com.pentagon.myapplication;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    private static Retrofit retrofit = null;

    static Retrofit getClient() {
        try{
            OkHttpClient.Builder oktHttpClient = new OkHttpClient.Builder();
            oktHttpClient.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();
                    Request request = original.newBuilder()
                            .header("Authorization", "token cc84d57f4084333434f1068cde634ea6b7d20fa4")
                            .method(original.method(), original.body())
                            .build();
                    return chain.proceed(request);
                }
            });

            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api-dev.weathersolutions.ph/api/v1/forecast/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(oktHttpClient.build())
                    .build();

        }catch(Exception e) {
            Log.e("ERROR", e.toString());
        }

        return retrofit;
    }
}
