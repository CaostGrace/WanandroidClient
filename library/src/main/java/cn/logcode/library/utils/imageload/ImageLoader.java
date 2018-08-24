package cn.logcode.library.utils.imageload;

import android.content.Context;
import android.widget.ImageView;


import cn.logcode.library.utils.CheckUtils;

/**
 * Created by CaostGrace on 2018/8/10 14:34
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.library.utils.imageload
 * @class_name: ImageLoader
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public class ImageLoader implements LoadStrategy {

    private static LoadStrategy loadStrategy;
    private static ImageLoader instance;


    public static void init(LoadStrategy strategy) {
        loadStrategy = strategy;
        if (instance == null) {
            instance = new ImageLoader();
        }
    }

    public static ImageLoader get() {
        return instance;
    }

    public ImageLoader setLoadStrategy(LoadStrategy strategy) {
        loadStrategy = strategy;
        return this;
    }


    @Override
    public void loadCircleImage(Context context, String url, ImageView imageView) {
        if (CheckUtils.checkNotNull(loadStrategy)) {
            loadStrategy.loadCircleImage(context, url, imageView);
        }
    }

    @Override
    public void loadCircleImage(Context context, int resId, ImageView imageView) {
        if (CheckUtils.checkNotNull(loadStrategy)) {
            loadStrategy.loadCircleImage(context, resId, imageView);
        }
    }

    @Override
    public void loadRoundImage(Context context, String url, ImageView imageView) {
        if (CheckUtils.checkNotNull(loadStrategy)) {
            loadStrategy.loadRoundImage(context, url, imageView);
        }
    }

    @Override
    public void loadRoundImage(Context context, int resId, ImageView imageView) {
        if (CheckUtils.checkNotNull(loadStrategy)) {
            loadStrategy.loadRoundImage(context, resId, imageView);
        }
    }

    @Override
    public void loadDefaultImage(Context context, String url, ImageView imageView) {
        if (CheckUtils.checkNotNull(loadStrategy)) {
            loadStrategy.loadDefaultImage(context, url, imageView);
        }
    }

    @Override
    public void loadDefaultImage(Context context, int resId, ImageView imageView) {
        if (CheckUtils.checkNotNull(loadStrategy)) {
            loadStrategy.loadDefaultImage(context, resId, imageView);
        }
    }
}
