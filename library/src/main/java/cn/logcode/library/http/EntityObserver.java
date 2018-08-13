package cn.logcode.library.http;


import cn.logcode.library.config.HttpConfig;
import cn.logcode.library.mvp.IView;
import cn.logcode.library.utils.CheckUtils;

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


    public EntityObserver() {
        super();
    }

    public EntityObserver(IView networkLoadProcess) {
        super(networkLoadProcess);
    }

    @Override
    public void onNext(BaseEntity<T> value) {

        if (!CheckUtils.checkIsNull(mNetworkLoadProcess)) {
            mNetworkLoadProcess.loadEnd();
        }

        if (value.status == HttpConfig.REQUEST_SUCCESS) {
            T t = value.data;
            onHandleSuccess(t);
        } else {
            onError(new ApiException(value.status, value.msg));
        }
    }

    /**
     * 请求成功
     *
     * @param t
     */
    protected abstract void onHandleSuccess(T t);


}