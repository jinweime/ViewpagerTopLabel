package com.example.administrator.labelpager.com.pager.label;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.labelpager.R;

import java.util.ArrayList;

/**
 * Created by jwakyhhoa on 16/3/30.
 */
public class LabelPager extends LinearLayout {
    //top title x y
    int[] location = new int[2];
    int leftX = 0;
    int rightX;
    //默认5个标签数
    private static final int TOP_TITLE_SIZE = 5;
    private static final int RIGHT_INDEX = 4;
    private static final int WIDTH_ = 20;
    private ArrayList<String> titles = new ArrayList<>();
    private Context context;
    private HorizontalScrollView view;
    private LinearLayout jazz_title;
    public int mScreenWidth;

    public void setOnTabLinstener(LabelPager.onTabLinstener onTabLinstener) {
        this.onTabLinstener = onTabLinstener;
    }

    private onTabLinstener onTabLinstener;

    public LabelPager(Context context) {
        super(context);
        initView(context);
    }


    public LabelPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public LabelPager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }


    private void initView(Context context) {
        this.context = context;
        view = (HorizontalScrollView) View.inflate(context, R.layout.myhorizontal, null);
        jazz_title = (LinearLayout) view.findViewById(R.id.jazz_title);
        addView(view);
    }

    /**
     * **
     * add ,pager top title
     * ***
     */
    public void addTitle(ArrayList<String> titles) {
        int setwidth = 0;
        if (titles.size() <= TOP_TITLE_SIZE) {
            setwidth = getScreenWidth() / titles.size();
        } else {
            setwidth = getScreenWidth() / TOP_TITLE_SIZE;
        }
        for (int i = 0; i < titles.size(); i++) {
            View view = View.inflate(context, R.layout.jazzpager_title, null);
            TextView mTitle = (TextView) view.findViewById(R.id.title_tv);
            mTitle.setWidth(setwidth);
            mTitle.setText(titles.get(i));
            jazz_title.addView(view);
            final int finalI = i;
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    onTabLinstener.onItemClick(finalI);
                    topTitColorMove(finalI);
                }
            });
        }
        getTopLocation();
    }


    public void topTitColorMove(int index) {
        for (int i = 0; i < jazz_title.getChildCount(); i++) {
            RelativeLayout rview = (RelativeLayout) jazz_title.getChildAt(i);
            rview.getLocationOnScreen(location);
            TextView mTit = (TextView) rview.findViewById(R.id.title_tv);
            TextView mLinView = (TextView) rview.findViewById(R.id.lineview);
            //the view
            if (index == i) {
                rview.getLocationInWindow(location);
                if (location[0] > rightX) {
                    view.arrowScroll(View.FOCUS_RIGHT);
                } else if (location[0] < leftX) {
                    view.arrowScroll(View.FOCUS_LEFT);
                }
                mTit.setTextColor(getResources().getColor(R.color.xk_maincolor));
                mLinView.setWidth(mTit.getText().length() * WIDTH_);
                mLinView.setVisibility(View.VISIBLE);
            } else {
                mTit.setTextColor(getResources().getColor(R.color.black2));
                mLinView.setVisibility(View.GONE);
            }
        }
        getTopLocation();
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        getTopLocation();
    }

    /**
     * **
     * get ,top title X Y
     * ***
     */
    private void getTopLocation() {
        for (int i = 0; i < jazz_title.getChildCount(); i++) {
            RelativeLayout rview = (RelativeLayout) jazz_title.getChildAt(i);
            rview.getLocationInWindow(location);
            if (i == RIGHT_INDEX) {
                rightX = location[0];
            }
        }
    }

    public int getScreenWidth() {
        return DensityUtil.getScreenWidth((Activity) context);
    }

    public interface onTabLinstener {
        void onItemClick(int index);
    }
}
