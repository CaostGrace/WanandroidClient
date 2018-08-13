package cn.logcode.wanandroid.bean;

import java.util.List;

/**
 * Created by CaostGrace on 2018/8/13 11:45
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.wanandroid.bean
 * @class_name: ProjectBean
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content: 项目分类bean   是一个list
 * 
 */
public class ProjectBean {


    /**
     * children : []
     * courseId : 13
     * id : 294            // 该id在获取该分类下项目时需要用到
     * name : 完整项目
     * order : 145000
     * parentChapterId : 293
     * visible : 0
     */

    public int courseId;
    public int id;
    public String name;
    public int order;
    public int parentChapterId;
    public int visible;
    public List<?> children;
}
