package cn.logcode.wanandroid.ui.activity.main;

import android.os.Bundle;


import cn.logcode.wanandroid.R;
import cn.logcode.wanandroid.base.BaseActivity;

/**
 * Created by CaostGrace on 2018/8/13 9:46
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.wanandroid.base
 * @class_name: MainActivity
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content: 主activity
 */
public class MainActivity extends BaseActivity<MainView, MainModel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        mView.hideCenterTitle();
        mView.showLeftTitle("玩Android");

    }


    @Override
    public Class<?> getViewClass() {
        return MainView.class;
    }

    @Override
    public Class<?> getModelClass() {
        return MainModel.class;
    }
}
