package com.example.othebe.recyclerviewgestures.swipers.swipe_in;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.othebe.recyclerviewgestures.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by othebe on 5/20/16.
 */
public class SwipeInPageChangeListener implements ViewPager.OnPageChangeListener {
    private static final long DELAY = 300L;

    private ViewPager viewPager;

    public SwipeInPageChangeListener(ViewPager viewPager) {
        this.viewPager = viewPager;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        return;
    }

    @Override
    public void onPageSelected(int position) {
        if (position == 1) {

            // Add a pause.
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    viewPager.setCurrentItem(0);
                }
            }, DELAY);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        return;
    }
}
