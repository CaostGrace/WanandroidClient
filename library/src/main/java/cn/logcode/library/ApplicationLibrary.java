package cn.logcode.library;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.Bugly;

import org.litepal.LitePal;
import org.litepal.LitePalApplication;

import cn.logcode.library.Log.LogUtils;
import cn.logcode.library.config.AppConfig;
import cn.logcode.library.config.HttpConfig;
import cn.logcode.library.service.LibraryService;
import cn.logcode.library.utils.ActivityUtils;

/**
 * Created by CaostGrace on 2018/5/30 22:03
 *
 * @project_name: FrameworkDemo
 * @package_name: cn.logcode.library
 * @class_name: Application
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public class ApplicationLibrary extends Application {
    public static Application Instance;

    public static Context getContext() {
        return Instance.getApplicationContext();
    }

    public static Application getInstance() {
        return Instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Builder builder = new Builder()
                .buglyId(AppConfig.BUGLY_APPID)
                .isOpenLitepal(AppConfig.IS_OPEN_LITEPAL)
                .build();
        init(this, builder);
    }


    public static void init(Application application, Builder builder) {
        Instance = application;

        if (!builder.buglyId.equals("")) {

            boolean isDebug = BuildConfig.DEBUG;
            LogUtils.d(isDebug);
            Bugly.init(application.getApplicationContext(), builder.buglyId, isDebug);

        }

        /**
         * 是否使用litepal来使用数据库
         */
        if (builder.isOpenLitepal) {
            LitePal.initialize(application);
        }

        /**
         * 是否打开内存泄漏 检查
         */
        if (AppConfig.IS_OPEN_LEAKCANARY && BuildConfig.DEBUG) {
            if (LeakCanary.isInAnalyzerProcess(application)) {
                // This process is dedicated to LeakCanary for heap analysis.
                // You should not init your app in this process.
                return;
            }
            LeakCanary.install(application);
        }


        LibraryService.init(application.getApplicationContext());

        //生命周期回调
        application.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                LogUtils.d("onActivityCreated==>" + activity.toString());
                ActivityUtils.add(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {
                LogUtils.d("onActivityStarted==>" + activity.toString());
            }

            @Override
            public void onActivityResumed(Activity activity) {
                LogUtils.d("onActivityResumed==>" + activity.toString());
            }

            @Override
            public void onActivityPaused(Activity activity) {
                LogUtils.d("onActivityPaused==>" + activity.toString());
            }

            @Override
            public void onActivityStopped(Activity activity) {
                LogUtils.d("onActivityStopped==>" + activity.toString());
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                LogUtils.d("onActivitySaveInstanceState==>" + activity.toString());
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                LogUtils.d("onActivityDestroyed==>" + activity.toString());
                ActivityUtils.remove(activity);
            }
        });
    }


    public static class Builder {
        private String buglyId = "";
        private boolean isOpenLitepal = false;


        public String getBuglyId() {
            return buglyId;
        }

        public boolean isOpenLitepal() {
            return isOpenLitepal;
        }

        public Builder() {
            buglyId = "";
            isOpenLitepal = false;
        }


        public Builder baseUrl(String baseurl) {
            HttpConfig.BASE_URL = baseurl;
            return this;
        }

        public Builder openLeakcanary(boolean isOpen) {
            AppConfig.IS_OPEN_LEAKCANARY = isOpen;
            return this;
        }

        public Builder buglyId(String buglyId) {
            this.buglyId = buglyId;
            AppConfig.BUGLY_APPID = buglyId;
            return this;
        }


        public Builder isOpenLitepal(boolean isOpen) {
            this.isOpenLitepal = isOpen;
            AppConfig.IS_OPEN_LITEPAL = isOpen;
            return this;
        }


        public Builder build() {
            return this;
        }
    }

}
