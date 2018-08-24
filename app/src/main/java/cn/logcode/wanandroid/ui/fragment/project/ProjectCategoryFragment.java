package cn.logcode.wanandroid.ui.fragment.project;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.logcode.library.callback.CallBack;
import cn.logcode.library.utils.CheckUtils;
import cn.logcode.wanandroid.R;
import cn.logcode.wanandroid.adapter.ProjectCategroyDetailsAdapter;
import cn.logcode.wanandroid.base.BaseFragment;
import cn.logcode.wanandroid.bean.ArticlePageList;
import cn.logcode.wanandroid.bean.ProjectBean;
import cn.logcode.wanandroid.bean.ProjectListDataBean;
import cn.logcode.wanandroid.utils.JumpUtils;

/**
 * Created by CaostGrace on 2018/8/23 14:52
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.wanandroid.ui.fragment.project
 * @class_name: ProjectCategoryFragment
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content: 项目类别fragment
 */
public class ProjectCategoryFragment extends BaseFragment {

    private ProjectBean mBean;

    @BindView(R.id.pro_cate_recycler)
    RecyclerView proCateRecycler;

    ProjectCategroyDetailsAdapter mDetailsAdapter;

    private List<ProjectListDataBean.DatasBean> mDatasBeans;

    private ProjectListDataBean mProjectListDataBean;

    public static ProjectCategoryFragment getInstance(ProjectBean projectBean) {
        ProjectCategoryFragment projectCategoryFragment = new ProjectCategoryFragment();
        projectCategoryFragment.mBean = projectBean;
        return projectCategoryFragment;

    }


    public String getTitle() {
        if (CheckUtils.checkNotNull(mBean)) {
            return mBean.name;
        }
        return "";
    }

    @Override
    public int childLayoutId() {
        return R.layout.main_fragment_projectcategory;
    }

    @Override
    public void init(Bundle savedInstanceState) {

        mView.enableSwipe(true);

        mDatasBeans = new ArrayList<>();
        mDetailsAdapter = new ProjectCategroyDetailsAdapter(mDatasBeans);

        proCateRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        proCateRecycler.setAdapter(mDetailsAdapter);

        mDetailsAdapter.bindToRecyclerView(proCateRecycler);

        mDetailsAdapter.setEmptyView(R.layout.adapter_empty_view);

        mDetailsAdapter.setEnableLoadMore(true);
        mDetailsAdapter.enableLoadMoreEndClick(true);
        mDetailsAdapter.setLoadMoreView(new LoadMoreView() {
            @Override
            public int getLayoutId() {
                return R.layout.item_load_more;
            }

            @Override
            protected int getLoadingViewId() {
                return R.id.load_more_loading_view;
            }

            @Override
            protected int getLoadFailViewId() {
                return R.id.load_more_load_fail_view;
            }

            @Override
            protected int getLoadEndViewId() {
                return R.id.load_more_load_end_view;
            }
        });
        mDetailsAdapter.setPreLoadNumber(5);


        onRefresh();

        listener();

    }

    private void listener() {
        /**
         * 点击事件
         */
        mDetailsAdapter.setOnItemClickListener((BaseQuickAdapter adapter, View view, int position) -> {
            JumpUtils.jumpWebActivity(getContext(), mDatasBeans.get(position).link);
        });


        /**
         * 加载更多事件
         */
        mDetailsAdapter.setOnLoadMoreListener(() -> {

            if (CheckUtils.checkNotNull(mProjectListDataBean) && mProjectListDataBean.curPage <= mProjectListDataBean.pageCount && mProjectListDataBean.pageCount > 1) {
                mModel.getProjectDetailList(mProjectListDataBean.curPage+1, mBean.id, new CallBack<ProjectListDataBean>() {
                    @Override
                    public void data(ProjectListDataBean articlePageList) {
                        super.data(articlePageList);
                        mProjectListDataBean = articlePageList;
                        mDetailsAdapter.addData(articlePageList.datas);
                        mDetailsAdapter.loadMoreComplete();

                    }

                    @Override
                    public void onError(int code, String message) {
                        super.onError(code, message);
                        mDetailsAdapter.loadMoreFail();
                    }
                });

            } else {
                mDetailsAdapter.loadMoreEnd();
            }

        }, proCateRecycler);


    }


    @Override
    public void onRefresh() {
        super.onRefresh();
        mDetailsAdapter.setEnableLoadMore(true);

        mModel.getProjectDetailList(1, mBean.id, new CallBack<ProjectListDataBean>() {
            @Override
            public void data(ProjectListDataBean bean) {
                super.data(bean);
                updateProjectDetaiList(bean);
                mView.refreshEnd();
            }
        });


    }

    /**
     * 更新项目详情列表
     *
     * @param bean
     */
    private void updateProjectDetaiList(ProjectListDataBean bean) {


//        if ((bean.curPage == 0 || bean.curPage == 1) && bean.pageCount == 1) {
//
//        }

        this.mProjectListDataBean = bean;
        this.mDatasBeans = bean.datas;
        if (CheckUtils.checkNotNull(mDetailsAdapter)) {
            mDetailsAdapter.setNewData(this.mDatasBeans);
        }

    }


}
