package cn.logcode.wanandroid.ui.fragment.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import cn.logcode.library.callback.CallBack;
import cn.logcode.library.utils.CheckUtils;
import cn.logcode.wanandroid.R;
import cn.logcode.wanandroid.base.BaseFragment;
import cn.logcode.wanandroid.base.BaseModel;
import cn.logcode.wanandroid.bean.ArticlePageList;
import cn.logcode.wanandroid.bean.Banner;
import cn.logcode.wanandroid.config.Constants;
import cn.logcode.wanandroid.ui.activity.WebActivity;
import cn.logcode.wanandroid.utils.JumpUtils;

/**
 * Created by CaostGrace on 2018/8/21 13:55
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.wanandroid.ui.fragment
 * @class_name: HomePageFragment
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content: 首页fragment
 */
public class MainHomePageFragment extends BaseFragment<HomeView, BaseModel> {

    private ArticlePageList mArticlePage;

    @Override
    public int childLayoutId() {
        return R.layout.main_fragment_home;
    }

    @Override
    public void init(Bundle savedInstanceState) {
//        initData();

        onRefresh();

        initListener();


    }

    /**
     * 首次加载事件监听
     */
    private void initListener() {

        mView.setHomePageArticleItemListener((ArticlePageList.DatasBean bean) -> {
            JumpUtils.jumpWebActivity(getContext(), bean.link);
        });

        mView.mArticleAdapter.setOnLoadMoreListener(() -> {

            if (CheckUtils.checkNotNull(mArticlePage) && mArticlePage.curPage < mArticlePage.pageCount) {
                mModel.getHomePageArticle(mArticlePage.curPage, new CallBack<ArticlePageList>() {
                    @Override
                    public void data(ArticlePageList articlePageList) {
                        super.data(articlePageList);
                        mArticlePage = articlePageList;
                        mView.mArticleAdapter.addData(articlePageList.datas);
                        mView.mArticleAdapter.loadMoreComplete();

                    }

                    @Override
                    public void onError(int code, String message) {
                        super.onError(code, message);
                        mView.mArticleAdapter.loadMoreFail();
                    }
                });

            } else {
                mView.mArticleAdapter.loadMoreEnd();
            }


        }, mView.homeRecycler);
    }

    /**
     * 首次加载初始化
     */
    private void initData() {
        /**
         * 获取banner数据
         */
        mModel.getBanner(new CallBack<List<Banner>>() {
            @Override
            public void data(List<Banner> banners) {
                super.data(banners);
                banner(banners);
            }
        });

        /**
         * 获取首页文章列表
         */
        mModel.getHomePageArticle(0, new CallBack<ArticlePageList>() {
            @Override
            public void data(ArticlePageList articlePageList) {
                super.data(articlePageList);
                mArticlePage = articlePageList;
                mView.updateHomePageList(articlePageList.datas);
            }
        });


    }


    /**
     * 加载banner
     *
     * @param banners
     */
    private void banner(List<Banner> banners) {
        List<String> imageUrls = new ArrayList<>();
        List<String> title = new ArrayList<>();
        List<String> contentUrls = new ArrayList<>();
        for (int i = 0; i < banners.size(); i++) {
            imageUrls.add(banners.get(i).imagePath);
            title.add(banners.get(i).title);
            contentUrls.add(banners.get(i).url);
        }
        mView.initBanner(imageUrls, title, contentUrls);
    }


    @Override
    public void onRefresh() {
        super.onRefresh();

        mView.mArticleAdapter.setEnableLoadMore(true);
        mModel.getBanner(new CallBack<List<Banner>>() {
            @Override
            public void data(List<Banner> banners) {
                super.data(banners);
                banner(banners);

            }

            @Override
            public void onError(int code, String message) {
                super.onError(code, message);

            }
        });

        mModel.getHomePageArticle(0, new CallBack<ArticlePageList>() {
            @Override
            public void data(ArticlePageList articlePageList) {
                super.data(articlePageList);
                mArticlePage = articlePageList;
                mView.updateHomePageList(articlePageList.datas);
                mView.refreshEnd();
            }

            @Override
            public void onError(int code, String message) {
                super.onError(code, message);
                mView.refreshEnd();

            }
        });


    }

    @Override
    public void onStart() {
        super.onStart();
        mView.bannerStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mView.bannerStop();
    }

    @Override
    public Class<?> getViewClass() {
        return HomeView.class;
    }


}
