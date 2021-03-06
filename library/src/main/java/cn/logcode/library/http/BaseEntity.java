package cn.logcode.library.http;

import com.google.gson.annotations.SerializedName;

/**
 * Created by CaostGrace on 2018/5/28 21:50
 *
 * @author caost
 * @project_name: FrameworkDemo
 * @package_name: cn.logcode.library.http
 * @class_name: BaseEntity
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */

public class BaseEntity<R> {
    @SerializedName("errorCode")
    public int status;
    @SerializedName("errorMsg")
    public String msg;
    @SerializedName("data")
    public R data;


    @Override
    public String toString() {
        return "BaseEntity{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}

