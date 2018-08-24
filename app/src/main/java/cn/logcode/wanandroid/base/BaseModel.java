package cn.logcode.wanandroid.base;

import java.util.List;

import cn.logcode.library.callback.CallBack;
import cn.logcode.library.http.DefaultObserver;
import cn.logcode.library.http.EntityObserver;
import cn.logcode.library.http.RxSchedulers;
import cn.logcode.library.mvp.IModelImpl;
import cn.logcode.wanandroid.bean.ArticlePageList;
import cn.logcode.wanandroid.bean.Banner;
import cn.logcode.wanandroid.bean.ProjectListDataBean;
import cn.logcode.wanandroid.utils.HttpUtils;

/**
 * Created by CaostGrace on 2018/8/13 9:45
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.wanandroid.base
 * @class_name: BaseModel
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public class BaseModel extends IModelImpl {

    /**
     * 获取banner
     */
    public void getBanner(CallBack<List<Banner>> callBack) {
        addDisposable(HttpUtils.get()
                .apiService()
                .banner().compose(RxSchedulers.compose())
                .subscribeWith(new DefaultObserver<List<Banner>>() {
                    @Override
                    protected void onHandleSuccess(List<Banner> banners) {
                        callBack.data(banners);
                    }

                    @Override
                    protected void onHandleError(int code, String msg) {
                        super.onHandleError(code, msg);
                        callBack.onError(code, msg);
                    }
                }));
    }

    /**
     * 获取首页文章列表
     *
     * @param page 页码
     */
    public void getHomePageArticle(int page, CallBack<ArticlePageList> callBack) {
        addDisposable(HttpUtils.get()
                .apiService()
                .homePageList(page)
                .compose(RxSchedulers.compose())
                .subscribeWith(new DefaultObserver<ArticlePageList>() {
                    @Override
                    protected void onHandleSuccess(ArticlePageList list) {
                        callBack.data(list);
                    }

                    @Override
                    protected void onHandleError(int code, String msg) {
                        super.onHandleError(code, msg);
                        callBack.onError(code, msg);
                    }
                }));
    }


    /**
     * 获取项目分类详情的列表
     *
     * @param page
     * @param cid
     * @param callBack
     */
    public void getProjectDetailList(int page, int cid, CallBack<ProjectListDataBean> callBack) {
        addDisposable(HttpUtils.get().apiService().projectListData(page, cid)
                .compose(RxSchedulers.compose())
                .subscribeWith(new DefaultObserver<ProjectListDataBean>() {
                    @Override
                    protected void onHandleSuccess(ProjectListDataBean bean) {
                        callBack.data(bean);
                    }

                    @Override
                    protected void onHandleError(int code, String msg) {
                        super.onHandleError(code, msg);
                        callBack.onError(code, msg);
                    }
                }));
    }

}
