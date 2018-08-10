package cn.logcode.library.http;

import com.orhanobut.logger.Logger;

import java.io.IOException;

import cn.logcode.basemodule.config.HttpConfig;
import cn.logcode.commandcore.Log.LogUtils;
import cn.logcode.commandcore.utils.CheckUtils;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by CaostGrace on 2018/8/9 14:20
 *
 * @author caost
 * @project_name: ComponentBased
 * @package_name: cn.logcode.basemodule.http
 * @class_name: BaseUrlInterceptor
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content: baseurl  动态替换拦截
 */
public class BaseUrlInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();

        String dynamic = request.header(HttpConfig.DYNAMIC_NAME);


        if (CheckUtils.checkNullString(dynamic)) {
            Request interRequest;

            String url = request.url().toString();

//            url = url.replace(HttpManager.getBaseUrl(), dynamic);

            url = url.replace(HttpConfig.BASE_URL, dynamic);


            interRequest = request.newBuilder()
                    .url(url)
                    .build();

            Response response = chain.proceed(interRequest);
            return response;
        }

        Response response = chain.proceed(request);

        return response;
    }
}
