package cn.logcode.library.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import cn.logcode.commandcore.utils.CheckUtils;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by CaostGrace on 2018/5/28 21:37
 *
 * @author caost
 * @project_name: FrameworkDemo
 * @package_name: cn.logcode.library.http
 * @class_name: HttpManager
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public class HttpManager<A> {

    private static HttpManager DEFAULT = null;

    private A service;

    private static String baseUrl;

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static HttpManager getInstance(String base_url) {
        if (DEFAULT == null) {
            DEFAULT = newBuilder()
                    .baseUrl(base_url)
                    .build();
            baseUrl = base_url;
        }
        return DEFAULT;
    }



    public static Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            .serializeNulls()
            .create();



    private OkHttpClient client;
    private Retrofit retrofit;

    public Gson getGson() {
        return gson;
    }




    private HttpManager(OkHttpClient client, Retrofit retrofit) {
        this.client = client;
        this.retrofit = retrofit;
        baseUrl = retrofit.baseUrl().toString();
    }

    public Builder newBuilder() {
        return new Builder(client, retrofit);
    }

    public A createApi(Class<A> cls) {
        if (CheckUtils.checkIsNull(service)) {
            synchronized (DEFAULT) {
                if (CheckUtils.checkIsNull(service)) {
                    service = retrofit.create(cls);
                }
            }

        }

        return service;
    }


    public static class Builder {

        private CallAdapter.Factory callFactory;
        private Converter.Factory converterFactory;

        private HttpUrl base_url;

        private OkHttpClient client;
        private Retrofit retrofit;


        public Builder() {
            callFactory = RxJava2CallAdapterFactory.create();
            converterFactory = GsonConverterFactory.create(gson);

        }

        public Builder(OkHttpClient client, Retrofit retrofit) {
            this.client = client;
            this.retrofit = retrofit;


            callFactory = RxJava2CallAdapterFactory.create();
            converterFactory = GsonConverterFactory.create(gson);
            base_url = retrofit.baseUrl();


        }

        public Builder callAdapterFactory(CallAdapter.Factory factory) {
            this.callFactory = factory;
            return this;
        }

        public Builder converterFactory(Converter.Factory factory) {
            this.converterFactory = factory;
            return this;
        }

        public Builder client(OkHttpClient client) {
            this.client = client;
            return this;
        }


        public Builder baseUrl(String url) {
            this.base_url = HttpUrl.parse(url);
            return this;
        }



        public HttpManager build() {

            if (client == null) {
                client = new OkHttpClient
                        .Builder()
                        .connectTimeout(5, TimeUnit.SECONDS)
                        .readTimeout(5, TimeUnit.SECONDS)
                        .writeTimeout(5, TimeUnit.SECONDS)
                        .addInterceptor(new BaseUrlInterceptor())
                        .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                        .build();
            }


            retrofit = new Retrofit
                    .Builder()
                    .addConverterFactory(converterFactory)
                    .addCallAdapterFactory(callFactory)
                    .baseUrl(base_url)
                    .client(client)
                    .build();


            return new HttpManager(client, retrofit);
        }
    }
}
