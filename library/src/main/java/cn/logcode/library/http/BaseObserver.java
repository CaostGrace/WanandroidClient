package cn.logcode.library.http;

import cn.logcode.library.Log.LogUtils;
import cn.logcode.library.mvp.IView;
import cn.logcode.library.utils.ToastUtil;
import cn.logcode.library.utils.Utils;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by CaostGrace on 2018/6/14 12:20
 *
 * @project_name: graceLibrary
 * @package_name: cn.logcode.library.http
 * @class_name: BaseObserver
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public abstract class BaseObserver<T> implements Observer<T> {
    private static final String TAG = "BaseObserver";


    private Disposable mDisposable;

    public Disposable getDisposable() {
        return mDisposable;
    }

    protected IView mView;

    public BaseObserver(IView iView){
        this.mView = iView;
    }

    public BaseObserver(){}


    @Override
    public void onSubscribe(Disposable d) {
        mDisposable = d;

        if(!Utils.isNetworkConnected()) {
            LogUtils.d("无网络连接");
            if(mView != null){

                mView.showErrorMsg("无网络连接");
                d.dispose();
            }
            return;
        }
        if(mView != null){
            mView.showLoadingView("加载中");
            LogUtils.d("加载框");
        }
    }



    @Override
    public void onError(Throwable e) {
        LogUtils.e(TAG, "error:" + e.toString());
        LogUtils.e("error====>"+e.getMessage());
        if(mView != null){
            mView.hideLoadingView();
            mView.showErrorMsg(e.getMessage());
            LogUtils.d("error:" + e.toString());
        }


        onHandleError(404,"连接不到服务器");
    }

    @Override
    public void onComplete() {
//        LogUtils.d("onComplete" );
    }

    protected void onHandleError(int code,String msg) {
        LogUtils.d("Error===>",msg);



    }

}
