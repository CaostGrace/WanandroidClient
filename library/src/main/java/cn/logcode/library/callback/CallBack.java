package cn.logcode.library.callback;

/**
 * Created by CaostGrace on 2018/8/10 14:10
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.library.CallBack
 * @class_name: CallBack
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public abstract class CallBack<T> {
    public void success(){}

    public void onError(int code, String message) {

    }

    public void data(T t) {
    }
}
