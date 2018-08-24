package cn.logcode.wanandroid.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.logcode.library.utils.CheckUtils;
import cn.logcode.library.utils.imageload.ImageLoader;
import cn.logcode.wanandroid.R;
import cn.logcode.wanandroid.bean.ArticlePageList;

/**
 * Created by CaostGrace on 2018/8/21 16:52
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.wanandroid.adapter
 * @class_name: HomePageArticleAdapter
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public class HomePageArticleAdapter extends BaseQuickAdapter<ArticlePageList.DatasBean, BaseViewHolder> {

    public HomePageArticleAdapter(@Nullable List<ArticlePageList.DatasBean> data) {
        super(R.layout.item_home_article, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ArticlePageList.DatasBean item) {
        helper.setVisible(R.id.item_image, false);
        helper.setText(R.id.item_title, item.title);
//        helper.setText(R.id.item_desc, item.desc);
        helper.setText(R.id.item_author, item.author);
        helper.setText(R.id.item_category,  item.chapterName);
        helper.setText(R.id.item_time, item.niceDate);


//        if(CheckUtils.checkNullString(item.desc)){
//            helper.setVisible(R.id.item_desc, false);
//        }


        if (CheckUtils.checkNotNull(item.envelopePic) && !item.envelopePic.equals("")) {
            helper.setVisible(R.id.item_image, true);
            ImageLoader.get().loadRoundImage(mContext, item.envelopePic, helper.getView(R.id.item_image));
        }

        if (item.collect) {
            helper.setImageResource(R.id.collection_image, R.mipmap.icon_collection);
        } else {
            helper.setImageResource(R.id.collection_image, R.mipmap.icon_uncollection);
        }

        helper.getView(R.id.item_collection).setOnClickListener((view -> {
            if (CheckUtils.checkNotNull(collectionLinstener)) {
                collectionLinstener.onClick(view);
            }
        }));


    }


    private View.OnClickListener collectionLinstener;

    public void setCollectionLinstener(View.OnClickListener collectionLinstener) {
        this.collectionLinstener = collectionLinstener;
    }
}
