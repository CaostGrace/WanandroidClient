package cn.logcode.wanandroid.ui.fragment.project;

import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import cn.logcode.library.Log.LogUtils;
import cn.logcode.wanandroid.R;
import cn.logcode.wanandroid.adapter.ProjectCategoryAdapter;
import cn.logcode.wanandroid.base.BaseFragment;
import cn.logcode.wanandroid.base.FragmentView;
import cn.logcode.wanandroid.utils.ColorUtils;

/**
 * Created by CaostGrace on 2018/8/23 14:41
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.wanandroid.ui.fragment.project
 * @class_name: MainProjectView
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public class MainProjectView extends FragmentView {

    @BindView(R.id.tab_layout)
    SlidingTabLayout mTabLayout;
    @BindView(R.id.viewpager)
    ViewPager mViewPager;


    ProjectCategoryAdapter categoryAdapter;

    @Override
    public void initView() {
        super.initView();

    }


    /**
     * 显示项目界面
     */

    public void showProjectView(String[] titles, List<ProjectCategoryFragment> fragments) {


        categoryAdapter = new ProjectCategoryAdapter(getFragmentManager(), fragments);

        mViewPager.setAdapter(categoryAdapter);
        
        mTabLayout.setViewPager(mViewPager,titles);
        mTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                int color = ColorUtils.getColor();
                mTabLayout.setIndicatorColor(color);
                EventBus.getDefault().post(color);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int color = ColorUtils.getColor();
                mTabLayout.setIndicatorColor(color);
                EventBus.getDefault().post(color);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }


}
