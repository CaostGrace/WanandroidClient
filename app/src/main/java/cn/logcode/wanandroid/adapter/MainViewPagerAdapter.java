package cn.logcode.wanandroid.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import cn.logcode.library.utils.CheckUtils;
import cn.logcode.wanandroid.base.BaseFragment;

/**
 * Created by CaostGrace on 2018/8/21 14:05
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.wanandroid.adapter
 * @class_name: MainViewPagerAdapter
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public class MainViewPagerAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> mFragments;

    public MainViewPagerAdapter(List<BaseFragment> fragments, FragmentManager fm) {
        super(fm);
        if (CheckUtils.checkNotNull(fragments)) {

            this.mFragments = fragments;
        } else {
            this.mFragments = new ArrayList<>();
        }
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
