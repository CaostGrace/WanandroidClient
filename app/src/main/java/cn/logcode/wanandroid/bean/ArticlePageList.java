package cn.logcode.wanandroid.bean;

import org.litepal.crud.LitePalSupport;

import java.util.List;

/**
 * Created by CaostGrace on 2018/8/13 10:59
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.wanandroid.bean
 * @class_name: HomePageList
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content: 首页文章列表bean
 */
public class ArticlePageList extends LitePalSupport {


    /**
     * curPage : 6
     * datas : []
     * offset : 100
     * over : false
     * pageCount : 76
     * size : 20
     * total : 1516
     */

    public int curPage;
    public int offset;
    public boolean over;
    public int pageCount;
    public int size;
    public int total;
    public List<DatasBean> datas;

    @Override
    public String toString() {
        return "HomePageList{" +
                "curPage=" + curPage +
                ", offset=" + offset +
                ", over=" + over +
                ", pageCount=" + pageCount +
                ", size=" + size +
                ", total=" + total +
                ", datas=" + datas +
                '}';
    }

    public static class DatasBean {
        /**
         * apkLink :
         * author : leon2017
         * chapterId : 294
         * chapterName : 完整项目
         * collect : false
         * courseId : 13
         * desc : 本App是基于谷歌推出的Android Jetpack架构组件的干货集中营, app功能很简单, 基本上是针对 LiveData + ViewModel + Navigation + Paging 的MVVM的练手demo,更多的强大功能，请参考google的官方api

         * envelopePic : http://www.wanandroid.com/blogimgs/b38258d1-fa8c-49ca-836b-41585eea1011.png
         * fresh : false
         * id : 3117
         * link : http://www.wanandroid.com/blog/show/2208
         * niceDate : 2018-07-08
         * origin :
         * projectLink : https://github.com/leon2017/GankJetpack
         * publishTime : 1531059687000
         * superChapterId : 294
         * superChapterName : 开源项目主Tab
         * tags : [{"name":"项目","url":"/project/list/1?cid=294"}]
         * title : Android Jetpack架构组件的干货集中营  GankJetpack
         * type : 0
         * userId : -1
         * visible : 1
         * zan : 0
         */

        public String apkLink;
        public String author;
        public int chapterId;
        public String chapterName;
        public boolean collect;
        public int courseId;
        public String desc;
        public String envelopePic;
        public boolean fresh;
        public int id;
        public String link;
        public String niceDate;
        public String origin;
        public String projectLink;
        public long publishTime;
        public int superChapterId;
        public String superChapterName;
        public String title;
        public int type;
        public int userId;
        public int visible;
        public int zan;
        public List<TagsBean> tags;

        @Override
        public String toString() {
            return "DatasBean{" +
                    "apkLink='" + apkLink + '\'' +
                    ", author='" + author + '\'' +
                    ", chapterId=" + chapterId +
                    ", chapterName='" + chapterName + '\'' +
                    ", collect=" + collect +
                    ", courseId=" + courseId +
                    ", desc='" + desc + '\'' +
                    ", envelopePic='" + envelopePic + '\'' +
                    ", fresh=" + fresh +
                    ", id=" + id +
                    ", link='" + link + '\'' +
                    ", niceDate='" + niceDate + '\'' +
                    ", origin='" + origin + '\'' +
                    ", projectLink='" + projectLink + '\'' +
                    ", publishTime=" + publishTime +
                    ", superChapterId=" + superChapterId +
                    ", superChapterName='" + superChapterName + '\'' +
                    ", title='" + title + '\'' +
                    ", type=" + type +
                    ", userId=" + userId +
                    ", visible=" + visible +
                    ", zan=" + zan +
                    ", tags=" + tags +
                    '}';
        }

        public static class TagsBean {
            @Override
            public String toString() {
                return "TagsBean{" +
                        "name='" + name + '\'' +
                        ", url='" + url + '\'' +
                        '}';
            }

            /**
             * name : 项目
             * url : /project/list/1?cid=294
             */


            public String name;
            public String url;
        }
    }
}
