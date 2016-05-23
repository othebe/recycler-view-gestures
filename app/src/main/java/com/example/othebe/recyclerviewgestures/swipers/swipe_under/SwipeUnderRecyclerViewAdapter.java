package com.example.othebe.recyclerviewgestures.swipers.swipe_under;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.othebe.recyclerviewgestures.R;
import com.example.othebe.recyclerviewgestures.swipers.PersonViewHolder;
import com.example.othebe.recyclerviewgestures.swipers.RecyclerViewAdapter;

/**
 * Created by othebe on 5/20/16.
 */
public class SwipeUnderRecyclerViewAdapter extends RecyclerViewAdapter<PersonViewHolder> {
    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person_swipe_under, parent, false);

        return new PersonViewHolder(view);
    }
}
