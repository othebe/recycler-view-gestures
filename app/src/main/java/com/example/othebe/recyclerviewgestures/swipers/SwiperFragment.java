package com.example.othebe.recyclerviewgestures.swipers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.othebe.recyclerviewgestures.R;
import com.example.othebe.recyclerviewgestures.models.Person;

import java.util.ArrayList;

/**
 * Created by othebe on 5/20/16.
 */
public abstract class SwiperFragment extends Fragment {
    private RecyclerView recyclerView;
    private LinearLayoutManager recyclerViewLayoutManager;
    private RecyclerViewAdapter recyclerViewAdapter;

    protected abstract RecyclerViewAdapter getRecyclerViewAdapter();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_swiper, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.swiper_fragment__recycler_view);
        recyclerViewLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(recyclerViewLayoutManager);

        recyclerViewAdapter = getRecyclerViewAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    public void setData(ArrayList<Person> data) {
        recyclerViewAdapter.setData(data);
    }
}
