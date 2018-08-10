package cn.logcode.library.http;

import cn.logcode.library.Log.LogUtils;
import cn.logcode.library.mvp.IView;

/**
 * Created by CaostGrace on 2018/7/6 13:11
 *
 * @author caost
 * @project_name: Android
 * @package_name: cn.logcode.library.http
 * @class_name: EntityObserver
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public abstract class EntityObserver<T> extends BaseObserver<BaseEntity<T>> {

    private static final String TAG = "EntityObserver";


    public EntityObserver(IView iView){
        super(iView);
    }

    public EntityObserver(){
        super();
    }



    @Override
    public void onNext(BaseEntity<T> value) {

        if (mView != null){
            mView.hideLoadingView();
            LogUtils.d("取消加载框");
        }

        if (value.status == 0) {
            T t = value.data;
            onHandleSuccess(t);
        } else {
            onHandleError(value.status,value.msg);
        }
    }


    protected abstract void onHandleSuccess(T t);

}