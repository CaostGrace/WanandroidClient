package cn.logcode.wanandroid.base;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import cn.logcode.library.mvp.IviewImpl;
import cn.logcode.wanandroid.R;

/**
 * Created by CaostGrace on 2018/8/13 9:45
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.wanandroid.base
 * @class_name: BaseView
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public abstract class BaseView extends IviewImpl {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    public void initView() {
        ((AppCompatActivity) mContext).setSupportActionBar(mToolbar);

        


    }
}
