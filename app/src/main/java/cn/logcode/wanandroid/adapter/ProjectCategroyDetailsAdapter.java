package cn.logcode.wanandroid.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.logcode.library.utils.CheckUtils;
import cn.logcode.library.utils.imageload.ImageLoader;
import cn.logcode.wanandroid.R;
import cn.logcode.wanandroid.bean.ProjectListDataBean;

/**
 * Created by CaostGrace on 2018/8/23 17:00
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.wanandroid.adapter
 * @class_name: ProjectCategroyDetailsAdapter
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public class ProjectCategroyDetailsAdapter extends BaseQuickAdapter<ProjectListDataBean.DatasBean, BaseViewHolder> {
    public ProjectCategroyDetailsAdapter(@Nullable List<ProjectListDataBean.DatasBean> data) {
        super(R.layout.item_project, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProjectListDataBean.DatasBean item) {


        ImageLoader.get().loadRoundImage(mContext, item.envelopePic + "", helper.getView(R.id.project_image));
        helper.setText(R.id.project_title, item.title + "");
        helper.setText(R.id.project_desc, item.desc + "");
        helper.setText(R.id.project_time, item.niceDate + "");
        helper.setText(R.id.project_author, item.author + "");

        if (item.collect) {
            ImageLoader.get().loadRoundImage(mContext, R.mipmap.icon_collection, helper.getView(R.id.project_collect));
        } else {
            ImageLoader.get().loadRoundImage(mContext, R.mipmap.icon_uncollection, helper.getView(R.id.project_collect));
        }

    }




}
