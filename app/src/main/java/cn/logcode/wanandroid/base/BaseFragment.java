package cn.logcode.wanandroid.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.widget.FrameLayout;

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
public abstract class BaseFragment extends FragmentDelegate {
    private View parent;
    private FrameLayout contentContainer;

    @Override
    public View getLayoutId() {
        parent = View.inflate(getContext(), R.layout.base_fragment, null);
        contentContainer = parent.findViewById(R.id.content_container);
        contentContainer.addView(View.inflate(getContext(), childLayoutId(), null), 0);
        return parent;
    }

    public abstract @LayoutRes
    int childLayoutId();


    @Override
    public Class<?> getViewClass() {
        return null;
    }

    @Override
    public Class<?> getModelClass() {
        return null;
    }
}
