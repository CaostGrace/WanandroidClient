package cn.logcode.library.http;

import cn.logcode.library.ApplicationLibrary;
import cn.logcode.library.Log.LogUtils;
import cn.logcode.library.mvp.IView;
import cn.logcode.library.utils.CheckUtils;
import cn.logcode.library.utils.NetworkUtils;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by CaostGrace on 2018/6/14 12:20
 *
 * @author caost
 * @project_name: graceLibrary
 * @package_name: cn.logcode.library.http
 * @class_name: BaseObserver
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public abstract class BaseObserver<T> implements Observer<T> {
    private static final String TAG = "BaseObserver";

    protected Disposable mDisposable;

    protected IView mNetworkLoadProcess;


    public Disposable getDisposable() {
        return mDisposable;
    }

    public BaseObserver(IView networkLoadProcess) {
        mNetworkLoadProcess = networkLoadProcess;
    }


    public BaseObserver() {
    }


    @Override
    public void onSubscribe(Disposable d) {
        mDisposable = d;


        if (NetworkUtils.isNetworkConnected(ApplicationLibrary.getContext())) {

            if (!CheckUtils.checkIsNull(mNetworkLoadProcess)) {
                mNetworkLoadProcess.loadStart("加载中...");
            }
        } else {
            mDisposable.dispose();
            onError(new ApiException(ApiException.NETWORK_ERROR, "网络连接错误"));
        }

    }


    @Override
    public void onError(Throwable throwable) {

        if (throwable instanceof ApiException) {

            ApiException apiException = (ApiException) throwable;

            LogUtils.e("errorCode:" + apiException.code + "  errorMsg:" + apiException.msg);

            if (!CheckUtils.checkIsNull(mNetworkLoadProcess)) {
                mNetworkLoadProcess.loadEnd();
                mNetworkLoadProcess.loadError(apiException.code, apiException.msg);
            }

            onHandleError(apiException.code, apiException.msg);
        } else {
            throwable.printStackTrace();

            if (!CheckUtils.checkIsNull(mNetworkLoadProcess)) {
                mNetworkLoadProcess.loadEnd();
                mNetworkLoadProcess.loadError(ApiException.UNKNOWN_ERROR, throwable.getMessage());
            }
            onHandleError(ApiException.UNKNOWN_ERROR, throwable.getMessage());
        }

    }

    @Override
    public void onComplete() {
    }

    /**
     * 请求错误
     *
     * @param code
     * @param msg
     */
    protected void onHandleError(int code, String msg) {

    }
}
