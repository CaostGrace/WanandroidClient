package cn.logcode.wanandroid.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import cn.logcode.wanandroid.ui.fragment.project.ProjectCategoryFragment;

/**
 * Created by CaostGrace on 2018/8/23 15:00
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.wanandroid.adapter
 * @class_name: ProjectCategoryAdapter
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content: 主界面项目类别的适配器
 */
public class ProjectCategoryAdapter extends FragmentPagerAdapter {

    private List<ProjectCategoryFragment> mFragmentList;

    public ProjectCategoryAdapter(FragmentManager fm, List<ProjectCategoryFragment> list) {
        super(fm);
        this.mFragmentList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentList.get(position).getTitle();
    }
}
