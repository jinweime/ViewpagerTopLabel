package com.example.administrator.labelpager.com.pager.label;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;

/**
 * Created by jwakyhhoa on 16/3/28.
 */
public class PagerAdapter extends android.support.v4.view.PagerAdapter {
    private ArrayList<View> views;
    private Context context;

    public PagerAdapter(Context context, ArrayList<View> views) {
        this.views = views;
        this.context = context;
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position));
        Object o = views.get(position);
        return o;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
