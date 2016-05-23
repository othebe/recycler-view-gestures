package com.example.othebe.recyclerviewgestures.swipers.swipe_under;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.othebe.recyclerviewgestures.R;

/**
 * Created by othebe on 5/23/16.
 */
public class SwipeUnderOnTouchListener implements RecyclerView.OnItemTouchListener {
    private float x1;
    private float x2;

    public SwipeUnderOnTouchListener() {
        resetCoords();
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        return true;
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        View view;
        View front;

        Log.d("TOUCH", String.valueOf(e.getActionMasked()));

        switch(e.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                handleActionDown(e);
                break;
            case MotionEvent.ACTION_MOVE:
                handleActionMove(rv, e);
                break;
            case MotionEvent.ACTION_CANCEL:
                handleActionCancel(rv, e);
                break;
            case MotionEvent.ACTION_UP:
                handleActionCancel(rv, e);
                break;
            case MotionEvent.ACTION_OUTSIDE:
                handleActionCancel(rv, e);
                break;
        }
    }

    private void handleActionDown(MotionEvent e) {
        x1 = x2;
        x2 = e.getX();
    }

    private void handleActionMove(RecyclerView rv, MotionEvent e) {
        x1 = x2;
        x2 = e.getX();

        View view = rv.findChildViewUnder(e.getX(), e.getY());
        if (view == null) {
            return;
        }

        View front = view.findViewById(R.id.person_swipe_under_item__person);
        if (front == null) {
            return;
        }
        View back = view.findViewById(R.id.person_swipe_under_item__controls);
        if (back == null) {
            return;
        }

        if (x1 >= 0 && x2 >= 0) {
            front.animate().translationXBy(x2 - x1).setDuration(0);
            float currX = front.getX();
            Log.d("Px", String.valueOf(currX) + " / " + front.getWidth());

//            back.animate().translationX(front.getWidth() + front.getX()).setDuration(0);
        }
    }

    private void handleActionCancel(RecyclerView rv, MotionEvent e) {
        View view = rv.findChildViewUnder(e.getX(), e.getY());
        if (view == null) {
            return;
        }

        View front = view.findViewById(R.id.person_swipe_under_item__person);
        if (front == null) {
            return;
        }

        front.animate().translationX(0).setDuration(300);

        resetCoords();
    }

    private void resetCoords() {
        x1 = -1;
        x2 = -1;
    }
}
