package cn.logcode.wanandroid.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.FrameLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import cn.logcode.library.Log.LogUtils;
import cn.logcode.library.mvp.activity.ActivityDelegate;
import cn.logcode.library.utils.CheckUtils;
import cn.logcode.wanandroid.R;

/**
 * Created by CaostGrace on 2018/8/13 9:45
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.wanandroid.base
 * @class_name: BaseActivity
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public class BaseActivity<V extends BaseView, M extends BaseModel> extends ActivityDelegate<BaseView, BaseModel> implements SwipeRefreshLayout.OnRefreshListener {

    private View parent;
    private FrameLayout contentContainer;

    protected V mView;
    protected M mModel;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        parent = View.inflate(this, R.layout.base_activity, null);
        contentContainer = parent.findViewById(R.id.content_container);
        mView = (V) super.mView;
        mModel = (M) super.mModel;

    }

    @Override
    public void setContentView(int layoutResID) {
        if (CheckUtils.checkNotNull(contentContainer)) {
            contentContainer.addView(View.inflate(this, layoutResID, null), 0);
        }
        super.setContentView(parent);

    }

    @Override
    public Class<?> getViewClass() {
        return BaseView.class;
    }

    @Override
    public Class<?> getModelClass() {
        return BaseModel.class;
    }

    @Override
    public void onRefresh() {
        LogUtils.d("onRefresh");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
