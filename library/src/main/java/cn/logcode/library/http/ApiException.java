package cn.logcode.library.http;

import android.app.Application;

/**
 * Created by CaostGrace on 2018/8/9 17:19
 *
 * @author caost
 * @project_name: ComponentBased
 * @package_name: cn.logcode.basemodule.http
 * @class_name: ApiException
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public class ApiException extends Exception {
    public int code;
    public String msg;

    public ApiException(int code, String msg){
        this.code = code;
        this.msg  =msg;
    }


    /**
     * 网络错误
     */
    public static final int NETWORK_ERROR  = 500;
    /**
     * 未知错误
     */
    public static final int UNKNOWN_ERROR  = 1000;

}
