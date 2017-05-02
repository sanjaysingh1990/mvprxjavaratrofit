package com.captech.retrorx.Services;


import com.captech.retrorx.Utilities.Constants;

import java.io.IOException;

import io.reactivex.disposables.CompositeDisposable;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by android5 on 21/7/16.
 */
public class NetworkService {

    private static NetworkService singleton = new NetworkService();
    private NetworkAPI networkAPI;
    private CompositeDisposable mCompositeDisposable;

    public NetworkService() {

        mCompositeDisposable = new CompositeDisposable();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).client(buildClient())
                .build();

        networkAPI = retrofit.create(NetworkAPI.class);
    }

    public synchronized static NetworkService getInstance() {
        return singleton;
    }

    public OkHttpClient buildClient() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response response = chain.proceed(chain.request());
                // Do anything with response here
                //if we ant to grab a specific cookie or something..
                return response;
            }
        });

        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                //this is where we will add whatever we want to our request headers.
                Request request = chain.request().newBuilder().addHeader("Accept", "application/json").build();
                return chain.proceed(request);
            }
        });

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(interceptor);

        return builder.build();
    }


    /**
     * Method to return the API interface.
     *
     * @return
     */
    public NetworkAPI getAPI() {
        return networkAPI;
    }

    public CompositeDisposable getmCompositeDisposable()
    {
        return mCompositeDisposable;
    }

}