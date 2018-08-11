package cn.logcode.library.utils.imageload;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import cn.logcode.library.ApplicationLibrary;
import cn.logcode.library.R;
import cn.logcode.library.widget.GlideRoundTransform;

/**
 * Created by CaostGrace on 2018/8/11 22:15
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.library.utils.imageload
 * @class_name: GlideImageLoaderStrategy
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content: glide加载图片策略
 */
public class GlideImageLoaderStrategy implements LoadStrategy {

    public static RequestOptions defaultOptions = new RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.ALL);

    public static RequestOptions circleOptions = new RequestOptions()
            .circleCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL);

    public static RequestOptions roundOptions = new RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .transform(new GlideRoundTransform(ApplicationLibrary.getContext(),10)) ;



    @Override
    public void loadCircleImage(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .apply(circleOptions)
                .into(imageView);
    }

    @Override
    public void loadCircleImage(Context context, int resId, ImageView imageView) {
        Glide.with(context)
                .load(resId)
                .apply(circleOptions)
                .into(imageView);
    }

    @Override
    public void loadRoundImage(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .apply(roundOptions)
                .into(imageView);
    }

    @Override
    public void loadRoundImage(Context context, int resId, ImageView imageView) {
        Glide.with(context)
                .load(resId)
                .apply(roundOptions)
                .into(imageView);
    }

    @Override
    public void loadDefaultImage(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .apply(defaultOptions)
                .into(imageView);
    }

    @Override
    public void loadDefaultImage(Context context, int resId, ImageView imageView) {
        Glide.with(context)
                .load(resId)
                .apply(defaultOptions)
                .into(imageView);
    }
}
