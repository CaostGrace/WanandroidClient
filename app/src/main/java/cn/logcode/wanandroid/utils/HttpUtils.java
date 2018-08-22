package cn.logcode.wanandroid.utils;

import cn.logcode.library.http.HttpManager;
import cn.logcode.library.utils.CheckUtils;
import cn.logcode.wanandroid.http.WanAndroidApiService;

/**
 * Created by CaostGrace on 2018/8/21 10:44
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.wanandroid.utils
 * @class_name: HttpUtils
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public class HttpUtils {
    private static HttpManager<WanAndroidApiService> httpManager;
    private static HttpUtils instance;

    private HttpUtils() {
    }

    public static HttpManager<WanAndroidApiService> get() {
        httpManager = HttpManager.getInstance();
        return httpManager;
    }

    public static HttpUtils getInstance() {
        if (CheckUtils.checkNotNull(httpManager)) {
            httpManager = HttpManager.getInstance();
        }
        if (CheckUtils.checkNotNull(instance)) {
            instance = new HttpUtils();
        }
        return instance;
    }

}
