package cn.logcode.wanandroid.ui.activity.main;

import android.support.v4.view.ViewPager;

import com.yinglan.alphatabs.AlphaTabView;
import com.yinglan.alphatabs.AlphaTabsIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.logcode.wanandroid.R;
import cn.logcode.wanandroid.adapter.MainViewPagerAdapter;
import cn.logcode.wanandroid.base.BaseFragment;
import cn.logcode.wanandroid.base.BaseView;
import cn.logcode.wanandroid.ui.fragment.MainHomePageFragment;
import cn.logcode.wanandroid.ui.fragment.MainMineFragment;
import cn.logcode.wanandroid.ui.fragment.MainProjectFragment;
import cn.logcode.wanandroid.ui.fragment.MainSystemFragment;

/**
 * Created by CaostGrace on 2018/8/14 13:50
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.wanandroid.ui.activity.main
 * @class_name: MainView
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public class MainView extends BaseView {

    @BindView(R.id.viewpager)
    ViewPager mViewPager;

    @BindView(R.id.bottom)
    AlphaTabsIndicator mIndicator;
    @BindView(R.id.home_page)
    AlphaTabView homePage;
    @BindView(R.id.system)
    AlphaTabView system;
    @BindView(R.id.project)
    AlphaTabView project;
    @BindView(R.id.mine)
    AlphaTabView mine;

    MainHomePageFragment mHomePageFragment;
    MainSystemFragment mSystemFragment;
    MainProjectFragment mProjectFragment;
    MainMineFragment mMineFragment;

    MainViewPagerAdapter mViewPagerAdapter;

    List<BaseFragment> mBaseFragments;

    @Override
    protected void initView() {
        super.initView();
        initBottom();

    }


    /**
     * 初始化底部导航栏
     */
    public void initBottom() {
        mBaseFragments = new ArrayList<>();

        mHomePageFragment = new MainHomePageFragment();
        mSystemFragment = new MainSystemFragment();
        mProjectFragment = new MainProjectFragment();
        mMineFragment = new MainMineFragment();

        mBaseFragments.add(mHomePageFragment);
        mBaseFragments.add(mSystemFragment);
        mBaseFragments.add(mProjectFragment);
        mBaseFragments.add(mMineFragment);

        mViewPagerAdapter = new MainViewPagerAdapter(mBaseFragments, getFragmentManager());

        mViewPager.setAdapter(mViewPagerAdapter);
        mViewPager.setOffscreenPageLimit(3);
        //不使用平滑滚动
        mViewPager.setCurrentItem(0, false);

        mIndicator.setViewPager(mViewPager);
        mIndicator.setTabCurrenItem(0);


    }

}
