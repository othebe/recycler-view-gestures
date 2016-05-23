package com.example.othebe.recyclerviewgestures;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.othebe.recyclerviewgestures.models.Person;
import com.example.othebe.recyclerviewgestures.swipers.SwiperFragment;
import com.example.othebe.recyclerviewgestures.swipers.swipe_in.SwipeInFragment;
import com.example.othebe.recyclerviewgestures.swipers.swipe_under.SwipeUnderFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SwiperFragment swipeInFragment;
    private SwiperFragment swipeUnderFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupFragments();

        showSwipeUnder();

        findViewById(R.id.main_activity__swipe_in_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSwipeIn();
            }
        });

        findViewById(R.id.main_activity__swipe_under_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSwipeUnder();
            }
        });
    }

    private void setupFragments() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        swipeInFragment = new SwipeInFragment();
        fragmentTransaction.add(R.id.main_activity__content_swipe_in, swipeInFragment);

        swipeUnderFragment = new SwipeUnderFragment();
        fragmentTransaction.add(R.id.main_activity__content_swipe_under, swipeUnderFragment);

        fragmentTransaction.commit();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        ArrayList<Person> data = new ArrayList();
        data.add(new Person("Andy"));
        data.add(new Person("Ben"));
        data.add(new Person("Charlie"));
        data.add(new Person("Denny"));
        data.add(new Person("Edward"));
        data.add(new Person("FuManChu"));
        data.add(new Person("George"));

        swipeInFragment.setData(data);
        swipeUnderFragment.setData(data);
    }

    private void showSwipeIn() {
        findViewById(R.id.main_activity__swipe_in_btn).setBackgroundColor(Color.GREEN);
        findViewById(R.id.main_activity__swipe_under_btn).setBackgroundColor(Color.GRAY);
        findViewById(R.id.main_activity__content_swipe_in).setVisibility(View.VISIBLE);
        findViewById(R.id.main_activity__content_swipe_under).setVisibility(View.GONE);
    }

    private void showSwipeUnder() {
        findViewById(R.id.main_activity__swipe_in_btn).setBackgroundColor(Color.GRAY);
        findViewById(R.id.main_activity__swipe_under_btn).setBackgroundColor(Color.GREEN);
        findViewById(R.id.main_activity__content_swipe_in).setVisibility(View.GONE);
        findViewById(R.id.main_activity__content_swipe_under).setVisibility(View.VISIBLE);
    }
}
