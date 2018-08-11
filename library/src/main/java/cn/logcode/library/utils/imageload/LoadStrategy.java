package cn.logcode.library.utils.imageload;

import android.content.Context;
import android.widget.ImageView;

import cn.logcode.library.R;

/**
 * Created by CaostGrace on 2018/8/10 14:34
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.library.utils.imageload
 * @class_name: LoadStrategy
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public interface LoadStrategy {

    /**
     * 根据本地路径或网络路径加载圆形图片
     *
     * @param context
     * @param url
     * @param imageView
     */
    void loadCircleImage(Context context, String url, ImageView imageView);

    /**
     * 根据资源Id加载圆形图片
     *
     * @param context
     * @param resId
     * @param imageView
     */
    void loadCircleImage(Context context, int resId, ImageView imageView);


    /**
     * 根据本地路径或者网络路径加载圆角图片
     *
     * @param context
     * @param url
     * @param imageView
     */
    void loadRoundImage(Context context, String url, ImageView imageView);

    /**
     * 根据资源Id加载圆角图片
     *
     * @param context
     * @param resId
     * @param imageView
     */
    void loadRoundImage(Context context, int resId, ImageView imageView);

    /**
     * 根据本地路径或者网络路径加载普通图片
     *
     * @param context
     * @param url
     * @param imageView
     */
    void loadDefaultImage(Context context, String url, ImageView imageView);

    /**
     * 根据资源Id加载普通图片
     *
     * @param context
     * @param resId
     * @param imageView
     */
    void loadDefaultImage(Context context, int resId, ImageView imageView);


}
