package cn.logcode.wanandroid.base;

import android.support.v4.widget.SwipeRefreshLayout;

import butterknife.BindView;
import cn.logcode.library.mvp.IviewImpl;
import cn.logcode.library.utils.CheckUtils;
import cn.logcode.wanandroid.R;

/**
 * Created by CaostGrace on 2018/8/13 9:46
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.wanandroid.base
 * @class_name: FragmentView
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public class FragmentView extends IviewImpl {

    @BindView(R.id.fragment_swipe)
    SwipeRefreshLayout mRefreshLayout;

    @Override
    public void initView() {
        enableSwipe(false);
    }


    public void enableSwipe(boolean flag) {
        if (CheckUtils.checkNotNull(mRefreshLayout)) {
            mRefreshLayout.setEnabled(flag);
            if(flag) mRefreshLayout.setOnRefreshListener((SwipeRefreshLayout.OnRefreshListener) mContext);
        }
    }


    @Override
    public void loadStart(String msg) {

    }

    @Override
    public void loadEnd() {

    }

    @Override
    public void loadError(int code, String errorMSg) {

    }
}
