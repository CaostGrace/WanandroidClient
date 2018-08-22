package cn.logcode.wanandroid.widget;

import android.content.Context;
import android.widget.ImageView;

import com.youth.banner.loader.ImageLoader;

import cn.logcode.library.utils.CheckUtils;
import cn.logcode.library.utils.imageload.LoadStrategy;


/**
 * Created by CaostGrace on 2018/8/21 15:25
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.wanandroid.widget
 * @class_name: HomeBannerImageLoader
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:  banner 的图片加载
 */
public class HomeBannerImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        String imageUrl;
        if (CheckUtils.checkNotNull(path)) {
            imageUrl = path.toString();
        } else {
            imageUrl = "";
        }

        cn.logcode.library.utils.imageload.ImageLoader.get()
                .loadDefaultImage(context, imageUrl, imageView);
    }

}
