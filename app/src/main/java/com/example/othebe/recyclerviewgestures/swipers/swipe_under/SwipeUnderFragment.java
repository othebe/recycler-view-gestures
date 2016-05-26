package com.example.othebe.recyclerviewgestures.swipers.swipe_under;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.othebe.recyclerviewgestures.R;
import com.example.othebe.recyclerviewgestures.swipers.RecyclerViewAdapter;
import com.example.othebe.recyclerviewgestures.swipers.SwiperFragment;

/**
 * Created by othebe on 5/20/16.
 */
public class SwipeUnderFragment extends SwiperFragment implements ITouchCallbackListener {
    private RecyclerViewAdapter adapter;

    public SwipeUnderFragment() {
        this.adapter = new SwipeUnderRecyclerViewAdapter();
    }

    @Override
    protected RecyclerViewAdapter getRecyclerViewAdapter() {
        return adapter;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView.addOnItemTouchListener(new SwipeUnderOnTouchListener(adapter));
    }

    @Override
    public void onSwiped(int position) {
        adapter.notifyItemChanged(position);
    }
}
