package cn.logcode.library.http;


import cn.logcode.library.config.HttpConfig;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by CaostGrace on 2018/5/29 13:22
 *
 * @author caost
 * @project_name: FrameworkDemo
 * @package_name: cn.logcode.library.http
 * @class_name: TestApi
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public interface TestApi {

    /**
     * 更改baseUrl
     *
     * @return
     */
    @Headers({HttpConfig.DYNAMIC_NAME +": "+ HttpConfig.GANK_BASE_URL})
    @GET("api/today")
    Observable<String> test();

    /**
     * 不更改
     *
     * @return
     */
    @GET("article/list/0/json")
    Observable<String> test1();

}
