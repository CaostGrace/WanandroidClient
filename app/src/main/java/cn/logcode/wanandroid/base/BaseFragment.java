package cn.logcode.wanandroid.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.FrameLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import cn.logcode.library.mvp.fragment.FragmentDelegate;
import cn.logcode.wanandroid.R;

/**
 * Created by CaostGrace on 2018/8/13 9:46
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.wanandroid.base
 * @class_name: BaseFragment
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public abstract class BaseFragment<V extends FragmentView, M extends BaseModel> extends FragmentDelegate<FragmentView, BaseModel> implements SwipeRefreshLayout.OnRefreshListener {
    private View parent;
    private FrameLayout contentContainer;

    protected V mView;
    protected M mModel;

    @Override
    public View getLayoutId() {

        parent = View.inflate(getContext(), R.layout.base_fragment, null);
        contentContainer = parent.findViewById(R.id.content_container);
        contentContainer.addView(View.inflate(getContext(), childLayoutId(), null), 0);
        mView = (V) super.mView;
        mModel = (M) super.mModel;
        return parent;
    }

    public abstract @LayoutRes
    int childLayoutId();


    @Override
    public void onRefresh() {

    }



    @Override
    public Class<?> getViewClass() {
        return FragmentView.class;
    }

    @Override
    public Class<?> getModelClass() {
        return BaseModel.class;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
