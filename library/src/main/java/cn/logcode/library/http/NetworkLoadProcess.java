package cn.logcode.library.http;

/**
 * Created by CaostGrace on 2018/8/8 9:25
 *
 * @author caost
 * @project_name: ComponentBased
 * @package_name: cn.logcode.basemodule.http
 * @class_name: NetworkLoadProcessIntercept
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public interface NetworkLoadProcess{
    /**
     * 网络请求开始
     * @param msg
     */
    void networkRequestStart(String msg);

    /**
     * 网络请求结束
     */
    void networkRequestEnd();

    /**
     * 网络请求错误
     * @param code
     * @param errorMSg
     */
    void networkRequestError(int code, String errorMSg);

}
