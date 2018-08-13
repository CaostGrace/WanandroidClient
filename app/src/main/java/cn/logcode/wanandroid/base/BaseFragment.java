package cn.logcode.wanandroid.base;

import android.os.Bundle;

import cn.logcode.library.mvp.fragment.FragmentDelegate;

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
public class BaseFragment extends FragmentDelegate {
    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void init(Bundle savedInstanceState) {

    }

    @Override
    public void doSomething() {

    }


    @Override
    public Class<?> getViewClass() {
        return null;
    }

    @Override
    public Class<?> getModelClass() {
        return null;
    }
}
