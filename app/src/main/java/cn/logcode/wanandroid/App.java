package cn.logcode.wanandroid;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import java.io.IOException;

import cn.logcode.library.ApplicationLibrary;
import cn.logcode.library.config.HttpConfig;
import cn.logcode.library.http.HttpManager;
import cn.logcode.library.utils.imageload.ImageLoader;
import cn.logcode.library.utils.imageload.LoadStrategy;
import cn.logcode.wanandroid.config.AppConfig;
import cn.logcode.wanandroid.config.Constants;
import cn.logcode.wanandroid.http.CookieManager;
import cn.logcode.wanandroid.http.WanAndroidApiService;
import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by CaostGrace on 2018/8/10 13:54
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.wanandroid
 * @class_name: App
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();



        ApplicationLibrary.Builder builder = new ApplicationLibrary.Builder()
                .baseUrl(Constants.BASE_URL)
                .isOpenLitepal(true)
                .buglyId("")
                .build();
        ApplicationLibrary.init(this, builder);



        HttpManager httpManager = new HttpManager
                .Builder()
                .baseUrl(Constants.BASE_URL)
                .cookieJar(new CookieManager())
                .build();

        httpManager.apiService(WanAndroidApiService.class);

        ImageLoader.init(LoadStrategy.defaule);

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
