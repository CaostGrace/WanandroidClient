package cn.logcode.library.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import cn.logcode.library.config.HttpConfig;
import cn.logcode.library.utils.CheckUtils;
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
 * @content: 网络请求管理
 */
public class HttpManager<T> {

    private static HttpManager DEFAULT = null;

    private T service;

    private static String baseUrl;

    public static String getBaseUrl() {
        return baseUrl;
    }


    public static HttpManager getInstance() {

        if (DEFAULT == null) {
            DEFAULT = new Builder()
                    .baseUrl(HttpConfig.BASE_URL)
                    .build();
            baseUrl = HttpConfig.BASE_URL;
        }
        return DEFAULT;
    }

    public static HttpManager init() {
        if (DEFAULT == null) {
            DEFAULT = new Builder()
                    .baseUrl(HttpConfig.BASE_URL)
                    .build();
            baseUrl = HttpConfig.BASE_URL;
        }
        return DEFAULT;
    }


    public static void setHttpManager(HttpManager httpManager) {
        DEFAULT = httpManager;
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

        DEFAULT = this;

    }

    @Deprecated
    public Builder newBuilder() {
        return new Builder(client, retrofit);
    }

    public T apiService(Class<T> cls) {
        if (CheckUtils.checkIsNull(service)) {
            synchronized (DEFAULT) {
                if (CheckUtils.checkIsNull(service)) {
                    service = retrofit.create(cls);
                }
            }
        }
        return service;
    }

    public T apiService() {
        return service;
    }


    public static class Builder {

        private CallAdapter.Factory callFactory;
        private Converter.Factory converterFactory;

        private HttpUrl base_url;

        private OkHttpClient client;
        private Retrofit retrofit;


        private TimeUnit mTimeUnit;


        private long timeout;

        private List<Interceptor> mInterceptors;


        public Builder() {
            callFactory = RxJava2CallAdapterFactory.create();
            converterFactory = GsonConverterFactory.create(gson);
            mInterceptors = new ArrayList<>();
        }

        public Builder(OkHttpClient client, Retrofit retrofit) {
            this.client = client;
            this.retrofit = retrofit;

            mInterceptors = new ArrayList<>();
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

        public Builder timeUnit(TimeUnit timeUnit) {
            mTimeUnit = timeUnit;
            return this;
        }

        public Builder addInterceptor(Interceptor interceptor) {
            mInterceptors.add(interceptor);
            return this;
        }

        public Builder timeout(long timeout) {
            this.timeout = timeout;
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

        OkHttpClient.Builder builder;

        public HttpManager build() {

            if (timeout == 0) {
                timeout = 5;
            }

            if (mTimeUnit == null) {
                mTimeUnit = TimeUnit.SECONDS;
            }


            if (client == null) {

                builder = new OkHttpClient
                        .Builder()
                        .connectTimeout(5, TimeUnit.SECONDS)
                        .readTimeout(5, TimeUnit.SECONDS)
                        .writeTimeout(5, TimeUnit.SECONDS)
                        .addInterceptor(new BaseUrlInterceptor())
                        .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));

                for (int i = 0; i < mInterceptors.size(); i++) {
                    builder.addInterceptor(mInterceptors.get(i));
                }

                client = builder.build();

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
