package cn.logcode.commandcore.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


import com.orhanobut.logger.Logger;


/**
 * Created by CaostGrace on 2018/8/8 9:36
 *
 * @author caost
 * @project_name: ComponentBased
 * @package_name: cn.logcode.basemodule.utils
 * @class_name: NetworkUtils
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content: 网络工具包
 */
public class NetworkUtils {

    /**
     * 网络是否连接
     * @return
     */
    public static boolean isNetworkConnected(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo == null){
            return false;
        }

        if(networkInfo.isConnected()){
            return true;
        }

        return false;
    }

    /**
     * 是否是wifi连接
     * @param context
     * @return
     */
    public static boolean isWIFIConnected(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo == null){
            return false;
        }
        //MOBILE
        //WIFI
        Logger.d(networkInfo.getTypeName());
        if(networkInfo.getType() == ConnectivityManager.TYPE_WIFI){
            Logger.d(networkInfo.getTypeName());
            return true;
        }

        return false;
    }
}
