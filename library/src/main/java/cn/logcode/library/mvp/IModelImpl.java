package cn.logcode.library.mvp;

import android.content.Context;

import cn.logcode.library.ApplicationLibrary;
import cn.logcode.library.http.BaseObserver;
import cn.logcode.library.http.HttpManager;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by CaostGrace on 2018/6/7 20:45
 *
 * @project_name: FrameworkDemo
 * @package_name: cn.logcode.library.mvp
 * @class_name: BaseModel
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public class IModelImpl implements IModel {


    protected CompositeDisposable mCompositeDisposable;

    public IDelegate mDelegate;

    public Context mContext;


    @Override
    public void onAttach(IDelegate delegate) {
        mDelegate = delegate;
        mContext = delegate.getContext();
        mCompositeDisposable = new CompositeDisposable();

    }


    public void addDisposable(Disposable disposable){
        if(mCompositeDisposable != null){
            mCompositeDisposable.add(disposable);
        }
    }


    public void addDisposable(BaseObserver observer){
        if(mCompositeDisposable != null){
            mCompositeDisposable.add(observer.getDisposable());
        }
    }


    @Override
    public void deAttach() {
        mDelegate = null;
        mContext = null;
        if(mCompositeDisposable != null){
            mCompositeDisposable.dispose();
            mCompositeDisposable = null;
        }
    }

}
