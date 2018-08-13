package cn.logcode.wanandroid.http;

import java.util.List;

import cn.logcode.library.http.BaseEntity;
import cn.logcode.wanandroid.bean.Banner;
import cn.logcode.wanandroid.bean.CommonWebsiteBean;
import cn.logcode.wanandroid.bean.HomePageList;
import cn.logcode.wanandroid.bean.HotKeyBean;
import cn.logcode.wanandroid.bean.NavBean;
import cn.logcode.wanandroid.bean.ProjectBean;
import cn.logcode.wanandroid.bean.ProjectListDataBean;
import cn.logcode.wanandroid.bean.TreeArticleBean;
import cn.logcode.wanandroid.bean.TreeDataBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by CaostGrace on 2018/8/10 14:06
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.wanandroid.http
 * @class_name: WanAndroidApiService
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public interface WanAndroidApiService {

    /**
     * 1.1 首页文章列表
     *
     * @param page 页码
     * @return
     */
    @GET(HttpConstants.ARTICLE)
    Observable<BaseEntity<HomePageList>> homePageList(@Path(HttpConstants.PAGE) int page);

    /**
     * 1.2 首页banner
     *
     * @return
     */
    @GET(HttpConstants.BANNER)
    Observable<BaseEntity<List<Banner>>> banner();

    /**
     * 1.3 常用网站
     *
     * @return
     */
    @GET(HttpConstants.FRIEND)
    Observable<BaseEntity<List<CommonWebsiteBean>>> commonWebsites();


    /**
     * 1.4 搜索热词
     *
     * @return
     */
    @GET(HttpConstants.HOTKEY)
    Observable<BaseEntity<List<HotKeyBean>>> hotkey();


    /**
     * 2.1 体系数据
     *
     * @return
     */
    @GET(HttpConstants.TREE)
    Observable<BaseEntity<List<TreeDataBean>>> tree();

    /**
     * 2.2 知识体系下的文章
     *
     * @param page 页码
     * @param id   文章id
     * @return
     */
    @GET(HttpConstants.TREE_ARTICLE)
    Observable<BaseEntity<TreeArticleBean>> treeArticle(@Path(HttpConstants.PAGE) int page, @Path(HttpConstants.ID) int id);


    /**
     * 3.1 导航数据
     *
     * @return
     */
    @GET(HttpConstants.NAVI)
    Observable<BaseEntity<List<NavBean>>> navi();


    /**
     * 4.1 项目分类
     *
     * @return
     */
    @GET(HttpConstants.PROJECT)
    Observable<BaseEntity<List<ProjectBean>>> project();

    /**
     * 4.2 项目列表数据
     *
     * @param page 页码
     * @param id   id
     * @return
     */
    @GET(HttpConstants.PROJECT_LIST_DATA)
    Observable<BaseEntity<ProjectListDataBean>> projectListData(@Path(HttpConstants.PAGE) int page, @Path(HttpConstants.ID) int id);




}
