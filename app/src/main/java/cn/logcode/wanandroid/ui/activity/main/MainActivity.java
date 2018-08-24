package cn.logcode.wanandroid.ui.activity.main;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;


import com.yinglan.alphatabs.OnTabChangedListner;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import cn.logcode.wanandroid.R;
import cn.logcode.wanandroid.base.BaseActivity;
import cn.logcode.wanandroid.utils.ColorUtils;

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
        EventBus.getDefault().register(this);
        mView.setToolbarBackgroundColor(ColorUtils.getColor());

        mView.showLeftTitle("首页");
        searchView("搜索");

        mView.mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mView.showToolBar();
                switch (position) {
                    //首页
                    case 0:
                        mView.setToolbarBackgroundColor(ColorUtils.getColor());
                        mView.showLeftTitle("首页");
                        break;
                    // 体系
                    case 1:
                        mView.setToolbarBackgroundColor(ColorUtils.getColor());
                        mView.showLeftTitle("体系");
                        break;
                    //项目
                    case 2:
                        mView.setToolbarBackgroundColor(ColorUtils.getColor());
                        mView.showLeftTitle("项目");
                        break;
                    //我的
                    case 3:
                        mView.hideToolBar();
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void searchView(String text) {
        mView.showSearch(text, (view) -> {

        });
    }


    /**
     * 项目fragment发送过来的更改状态栏颜色
     *
     * @param color
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventProjectBack(Integer color) {
        mView.setToolbarBackgroundColor(color);
    }


    @Override
    public Class<?> getViewClass() {
        return MainView.class;
    }

    @Override
    public Class<?> getModelClass() {
        return MainModel.class;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
