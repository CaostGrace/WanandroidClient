package cn.logcode.wanandroid.ui.fragment.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.logcode.library.utils.CheckUtils;
import cn.logcode.wanandroid.R;
import cn.logcode.wanandroid.adapter.HomePageArticleAdapter;
import cn.logcode.wanandroid.base.FragmentView;
import cn.logcode.wanandroid.bean.ArticlePageList;
import cn.logcode.wanandroid.utils.JumpUtils;
import cn.logcode.wanandroid.widget.HomeBannerImageLoader;

/**
 * Created by CaostGrace on 2018/8/21 14:58
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.wanandroid.ui.fragment.home
 * @class_name: HomeView
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public class HomeView extends FragmentView {


    Banner banner;
    @BindView(R.id.home_recycler)
    RecyclerView homeRecycler;

    List<ArticlePageList.DatasBean> homePageData;
    HomePageArticleAdapter mArticleAdapter;

    View headerView;


    public void initBanner(List<String> imageUrls, List<String> titles, List<String> contentUrls) {
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new HomeBannerImageLoader());
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.Default);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(5000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);

        //设置图片集合
        banner.setImages(imageUrls);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(titles);

        banner.setOnBannerListener((int position) -> {
            JumpUtils.jumpWebActivity(mContext, contentUrls.get(position));
        });

        //banner设置方法全部调用完毕时最后调用
        banner.start();

    }

    public void bannerStart() {
        banner.startAutoPlay();
    }

    public void bannerStop() {
        //banner设置方法全部调用完毕时最后调用
        banner.stopAutoPlay();
    }


    @Override
    public void initView() {
        super.initView();
        headerView = View.inflate(mContext, R.layout.item_homepage_header, null);
        banner = headerView.findViewById(R.id.banner);
        enableSwipe(true);
        initHomePageList();
    }

    /**
     * 初始化首页文章列表
     */
    private void initHomePageList() {
        homePageData = new ArrayList<>();
        mArticleAdapter = new HomePageArticleAdapter(homePageData);
        homeRecycler.setLayoutManager(new LinearLayoutManager(mContext));
        homeRecycler.setAdapter(mArticleAdapter);
        mArticleAdapter.setOnItemClickListener((BaseQuickAdapter adapter, View view, int position) -> {

            if (CheckUtils.checkNotNull(homePageArticleItemListener)) {
                homePageArticleItemListener.onClick(homePageData.get(position));
            }

        });

        mArticleAdapter.setEnableLoadMore(true);
        mArticleAdapter.enableLoadMoreEndClick(true);
        mArticleAdapter.setLoadMoreView(new LoadMoreView() {
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
        mArticleAdapter.setPreLoadNumber(5);

        mArticleAdapter.addHeaderView(headerView, 0);

    }

    /**
     * 更新文章列表
     *
     * @param lists
     */
    public void updateHomePageList(List<ArticlePageList.DatasBean> lists) {
        homePageData = lists;
        mArticleAdapter.setNewData(lists);
    }


    private HomePageArticleItemListener homePageArticleItemListener;

    public void setHomePageArticleItemListener(HomePageArticleItemListener homePageArticleItemListener) {
        this.homePageArticleItemListener = homePageArticleItemListener;
    }

    interface HomePageArticleItemListener {
        void onClick(ArticlePageList.DatasBean bean);
    }
}
