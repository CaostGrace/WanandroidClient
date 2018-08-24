package cn.logcode.wanandroid.ui.fragment.project;

import android.os.Bundle;

import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import cn.logcode.library.Log.LogUtils;
import cn.logcode.library.callback.CallBack;
import cn.logcode.wanandroid.R;
import cn.logcode.wanandroid.base.BaseFragment;
import cn.logcode.wanandroid.bean.ProjectBean;
import cn.logcode.wanandroid.utils.ColorUtils;

/**
 * Created by CaostGrace on 2018/8/21 14:01
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.wanandroid.ui.fragment
 * @class_name: MainProjectFragment
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content: 项目project
 */
public class MainProjectFragment extends BaseFragment<MainProjectView, MainProjectModel> {

    private String[] mTitles;
    private List<ProjectCategoryFragment> mFragments;

    @Override
    public int childLayoutId() {
        return R.layout.main_fragment_project;
    }

    @Override
    public void init(Bundle savedInstanceState) {

        mFragments = new ArrayList<>();

        /**
         * 获取项目类别
         */
        mModel.getProjectCategory(new CallBack<List<ProjectBean>>() {
            @Override
            public void data(List<ProjectBean> beans) {
                super.data(beans);
                initData(beans);
            }
        });


    }

    /**
     * 初始化数据
     *
     * @param beans
     */
    public void initData(List<ProjectBean> beans) {

        mTitles = new String[beans.size()];
        for (int i = 0; i < beans.size(); i++) {
            ProjectBean bean = beans.get(i);
            mTitles[i] = bean.name;
            mFragments.add(ProjectCategoryFragment.getInstance(bean));
        }


        mView.showProjectView(mTitles, mFragments);


    }


    @Override
    public Class<?> getViewClass() {
        return MainProjectView.class;
    }

    @Override
    public Class<?> getModelClass() {
        return MainProjectModel.class;
    }
}
