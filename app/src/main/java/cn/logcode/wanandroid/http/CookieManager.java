package cn.logcode.wanandroid.http;

import android.content.Context;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

import java.util.ArrayList;
import java.util.List;

import cn.logcode.library.Log.LogUtils;
import cn.logcode.wanandroid.bean.CookieBean;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * Created by CaostGrace on 2018/8/13 14:58
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.wanandroid.http
 * @class_name: CookieManager
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content: 登录cookie管理
 */
public class CookieManager implements CookieJar {

    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        LogUtils.d(url + "\r\n");
        LogUtils.d(url.toString());

        LogUtils.d(url.host());            //www.wanandroid.com
        LogUtils.d(url.encodedPath());     ///user/login


        for (int i = 0; i < cookies.size(); i++) {
            //必须有
//            LogUtils.d(cookies.get(i).domain());         // www.wanandroid.com
//            LogUtils.d(cookies.get(i).expiresAt());     //  253402300799999    过期时间
//            LogUtils.d(cookies.get(i).name());          //JSESSIONID      loginUserName     loginUserPassword
//            LogUtils.d(cookies.get(i).value());       //F9847675CE7650B08B7532DF1E5908FD       cccccc123


//            LogUtils.d(cookies.get(i).hostOnly());      //true
//            LogUtils.d(cookies.get(i).httpOnly());      //true
//            LogUtils.d(cookies.get(i).matches(url));    //true
//
//            LogUtils.d(cookies.get(i).path());         // /
//            LogUtils.d(cookies.get(i).persistent());   //false
//            LogUtils.d(cookies.get(i).secure());       //false
//            LogUtils.d(cookies.get(i).toString());

            CookieBean cookieBean = new CookieBean();
            cookieBean.domain = cookies.get(i).domain();
            cookieBean.expiresAt = cookies.get(i).expiresAt();
            cookieBean.name = cookies.get(i).name();
            cookieBean.value = cookies.get(i).value();

            cookieBean.hostOnly = cookies.get(i).hostOnly();
            cookieBean.httpOnly = cookies.get(i).httpOnly();

            cookieBean.path = cookies.get(i).path();
            cookieBean.persistent = cookies.get(i).persistent();
            cookieBean.secure = cookies.get(i).secure();


            cookieBean.saveOrUpdate("domain = ? and name = ?", cookieBean.domain, cookieBean.name);

            LogUtils.d(Thread.currentThread().getName());

        }

    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {

        List<Cookie> cookies = new ArrayList<>();


        LitePal.deleteAll(CookieBean.class, "expiresAt < ? and domain = ?",
                System.currentTimeMillis() + "", url.host());

        List<CookieBean> data = LitePal.where("domain = ?", url.host()).find(CookieBean.class);
        LogUtils.d(data.size());

        for (int i = 0; i < data.size(); i++) {

            Cookie cookie = new Cookie.Builder()
                    .domain(data.get(i).domain)
                    .expiresAt(data.get(i).expiresAt)
                    .name(data.get(i).name)
                    .value(data.get(i).value)
                    .path(data.get(i).path)
                    .build();

            cookies.add(cookie);
        }


        return cookies;
    }


}
