package cn.logcode.wanandroid.base;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import cn.logcode.library.Log.LogUtils;
import cn.logcode.library.mvp.IviewImpl;
import cn.logcode.library.utils.CheckUtils;
import cn.logcode.wanandroid.R;

/**
 * Created by CaostGrace on 2018/8/13 9:45
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.wanandroid.base
 * @class_name: BaseView
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public class BaseView extends IviewImpl {

    @BindView(R.id.swipe)
    SwipeRefreshLayout mSwipeRefreshLayout;

    public void enableSwipe(boolean flag) {
        if (CheckUtils.checkNotNull(mSwipeRefreshLayout)) {
            mSwipeRefreshLayout.setEnabled(flag);
            if (flag)
                mSwipeRefreshLayout.setOnRefreshListener((SwipeRefreshLayout.OnRefreshListener) mContext);
        }
    }


    /**
     * 显示隐藏toolbar
     */
    @BindView(R.id.toolbar)
    RelativeLayout mToolbar;

    public void hideToolBar() {
        if (CheckUtils.checkNotNull(mToolbar)) {
            mToolbar.setVisibility(View.GONE);
        }
    }

    public void showToolBar() {
        if (CheckUtils.checkNotNull(mToolbar)) {
            mToolbar.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 返回图标
     */
    @BindView(R.id.toolbar_icon_back)
    ImageView iconBack;

    public void showIconBack() {
        if (CheckUtils.checkNotNull(iconBack)) {
            iconBack.setVisibility(View.VISIBLE);
        }
    }

    public void hideIconBack() {
        if (CheckUtils.checkNotNull(iconBack)) {
            iconBack.setVisibility(View.GONE);
        }
    }

    /**
     * 左边布局，包含一个返回图标，以及一个小标题
     */
    @BindView(R.id.toolbar_left)
    LinearLayout toolbarLeft;

    public void showToolBarLeft(String subTitle, View.OnClickListener listener) {
        if (CheckUtils.checkNotNull(toolbarLeft) && CheckUtils.checkNotNull(iconBack)) {
            toolbarLeft.setVisibility(View.VISIBLE);
            iconBack.setVisibility(View.VISIBLE);
            if (CheckUtils.checkNotNull(subTitle) && !subTitle.equals("")) {
                showLeftTitle(subTitle);
            }
            toolbarLeft.setOnClickListener((view) -> {
                if (CheckUtils.checkNotNull(listener)) {
                    listener.onClick(view);
                }
            });
        }
    }

    public void hideToolBarLeft() {
        if (CheckUtils.checkNotNull(toolbarLeft) && CheckUtils.checkNotNull(iconBack)) {
            toolbarLeft.setVisibility(View.GONE);
            iconBack.setVisibility(View.GONE);
            hideLeftTitle();

        }
    }

    /**
     * 左边标题
     */
    @BindView(R.id.toolbar_title_left)
    TextView titleLeft;

    public void showLeftTitle(String text) {
        if (CheckUtils.checkNotNull(titleLeft)) {
            titleLeft.setVisibility(View.VISIBLE);
            if (CheckUtils.checkNotNull(text) && !text.equals("")) {
                titleLeft.setText(text);
            }
        }
    }

    public void hideLeftTitle() {
        if (CheckUtils.checkNotNull(titleLeft)) {
            titleLeft.setVisibility(View.GONE);
        }
    }


    /**
     * 中间标题
     */
    @BindView(R.id.toolbar_center_title)
    TextView centerTitle;

    public void showCenterTitle(String title) {
        if (CheckUtils.checkNotNull(centerTitle) && CheckUtils.checkNotNull(title) && !title.equals("")) {
            centerTitle.setVisibility(View.VISIBLE);
            centerTitle.setText(title);
        }
    }

    public void hideCenterTitle() {
        if (CheckUtils.checkNotNull(centerTitle)) {
            centerTitle.setVisibility(View.GONE);
        }
    }


    /**
     * 右边图标
     */
    @BindView(R.id.toolbar_icon_right)
    ImageView iconRight;

    public void shwoRightIcon(int resId, View.OnClickListener listener) {
        if (CheckUtils.checkNotNull(iconRight)) {
            if (resId != 0) {
                iconRight.setImageResource(resId);
            }

            iconRight.setVisibility(View.VISIBLE);

            if (CheckUtils.checkNotNull(listener)) {
                iconRight.setOnClickListener((view) -> {
                    listener.onClick(view);
                });
            }

        }
    }

    public void hideIconRight() {
        if (CheckUtils.checkNotNull(iconRight)) {
            iconRight.setVisibility(View.GONE);
        }
    }


    @Override
    protected void initView() {
        enableSwipe(false);
    }

    @Override
    public void loadStart(String msg) {

    }

    @Override
    public void loadEnd() {

    }

    @Override
    public void loadError(int code, String errorMSg) {

    }


}
