package com.example.othebe.recyclerviewgestures.swipers.swipe_in;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.othebe.recyclerviewgestures.R;
import com.example.othebe.recyclerviewgestures.swipers.PersonViewHolder;
import com.example.othebe.recyclerviewgestures.swipers.RecyclerViewAdapter;

/**
 * Created by othebe on 5/20/16.
 */
public class SwipeInRecyclerViewAdapter extends RecyclerViewAdapter<PersonViewHolder> {
    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewPager view = (ViewPager) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person_swipe_in, parent, false);
        SwipeInPagerAdapter adapter = new SwipeInPagerAdapter();
        view.setAdapter(adapter);

//        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
//        view.getLayoutParams().width = displayMetrics.widthPixels;
//        view.requestLayout();

        view.addOnPageChangeListener(new SwipeInPageChangeListener(view));

        view.setCurrentItem(0);

        return new PersonViewHolder(view);
    }
}
