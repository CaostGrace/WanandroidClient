package cn.logcode.wanandroid.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import cn.logcode.library.mvp.activity.ActivityDelegate;
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
public class BaseActivity extends ActivityDelegate {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity);

    }

    @Override
    public Class<?> getViewClass() {
        return BaseView.class;
    }

    @Override
    public Class<?> getModelClass() {
        return BaseModel.class;
    }
}
