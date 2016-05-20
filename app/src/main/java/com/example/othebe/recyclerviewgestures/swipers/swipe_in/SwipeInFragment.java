package com.example.othebe.recyclerviewgestures.swipers.swipe_in;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.othebe.recyclerviewgestures.R;
import com.example.othebe.recyclerviewgestures.swipers.RecyclerViewAdapter;
import com.example.othebe.recyclerviewgestures.swipers.SwiperFragment;

/**
 * Created by othebe on 5/20/16.
 */
public class SwipeInFragment extends SwiperFragment {
    @Override
    protected RecyclerViewAdapter getRecyclerViewAdapter() {
        return new SwipeInRecyclerViewAdapter();
    }
}
