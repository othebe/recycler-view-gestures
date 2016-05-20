package com.example.othebe.recyclerviewgestures.swipers.swipe_in;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.example.othebe.recyclerviewgestures.R;

/**
 * Created by othebe on 5/20/16.
 */
public class SwipeInPagerAdapter extends PagerAdapter {
    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int resId = 0;

        switch (position) {
            case 0:
                resId = R.id.person_swipe_in_item__person;
                break;
            case 1:
                resId = R.id.person_swipe_in_item__controls;
                break;
        }
        return container.findViewById(resId);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View) object);
    }
}
