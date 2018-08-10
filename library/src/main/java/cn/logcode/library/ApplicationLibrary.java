package cn.logcode.library;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;

import com.tencent.bugly.Bugly;
import com.tencent.bugly.crashreport.CrashReport;

import butterknife.BuildConfig;
import cn.logcode.library.Log.LogUtils;

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
    public static ApplicationLibrary INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        //测试时为true，发布时为false
//        CrashReport.initCrashReport(getApplicationContext(), "注册时申请的APPID", true);
//        CrashReport.initCrashReport(getApplicationContext(), "注册时申请的APPID", true);

        if(!buglyAppId().equals("")){

            ApplicationInfo info= getApplicationInfo();
            boolean isDebug = (info.flags&ApplicationInfo.FLAG_DEBUGGABLE)!=0;
            LogUtils.d(isDebug);
            Bugly.init(getApplicationContext(), buglyAppId(), isDebug);
            
        }

        //生命周期回调
//        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
//            @Override
//            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
//                LogUtils.d("onActivityCreated==>"+activity.toString());
//            }
//
//            @Override
//            public void onActivityStarted(Activity activity) {
//                LogUtils.d("onActivityStarted==>"+activity.toString());
//            }
//
//            @Override
//            public void onActivityResumed(Activity activity) {
//                LogUtils.d("onActivityResumed==>"+activity.toString());
//            }
//
//            @Override
//            public void onActivityPaused(Activity activity) {
//                LogUtils.d("onActivityPaused==>"+activity.toString());
//            }
//
//            @Override
//            public void onActivityStopped(Activity activity) {
//                LogUtils.d("onActivityStopped==>"+activity.toString());
//            }
//
//            @Override
//            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
//                LogUtils.d("onActivitySaveInstanceState==>"+activity.toString());
//            }
//
//            @Override
//            public void onActivityDestroyed(Activity activity) {
//                LogUtils.d("onActivityDestroyed==>"+activity.toString());
//            }
//        });

    }
    public String getBaseUrl(){
        return "";
    };

    public String buglyAppId(){
        return "";
    }
}
