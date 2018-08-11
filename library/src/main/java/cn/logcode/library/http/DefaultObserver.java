package cn.logcode.library.http;


import cn.logcode.library.mvp.IView;
import cn.logcode.library.utils.CheckUtils;

/**
 * Created by CaostGrace on 2018/6/7 21:23
 *
 * @author caost
 * @project_name: FrameworkDemo
 * @package_name: cn.logcode.library.http
 * @class_name: DefaultObserver
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public abstract class DefaultObserver<T> extends BaseObserver<T> {

    public static final String TAG = DefaultObserver.class.getSimpleName();


    public DefaultObserver() {
        super();
    }


    public DefaultObserver(IView networkLoadProcess) {
        super(networkLoadProcess);
    }


    @Override
    public void onNext(T t) {
        if (!CheckUtils.checkIsNull(mNetworkLoadProcess)) {
            mNetworkLoadProcess.loadEnd();
        }
        onHandleSuccess(t);
    }



    /**
     * 成功
     *
     * @param t
     */
    public abstract void onHandleSuccess(T t);



}
