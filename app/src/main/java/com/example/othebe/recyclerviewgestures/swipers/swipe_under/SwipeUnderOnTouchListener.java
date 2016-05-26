package com.example.othebe.recyclerviewgestures.swipers.swipe_under;

import android.animation.Animator;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Toast;

import com.example.othebe.recyclerviewgestures.R;
import com.example.othebe.recyclerviewgestures.models.Person;
import com.example.othebe.recyclerviewgestures.swipers.PersonViewHolder;
import com.example.othebe.recyclerviewgestures.swipers.RecyclerViewAdapter;

/**
 * Created by othebe on 5/23/16.
 */
public class SwipeUnderOnTouchListener implements RecyclerView.OnItemTouchListener {
    private final float POSITION_THRESHOLD = 0.7f;

    private float x1;
    private float x2;

    View dataView;
    View controlsView;
    PersonViewHolder personViewHolder;

    private RecyclerViewAdapter adapter;

    public SwipeUnderOnTouchListener(RecyclerViewAdapter adapter) {
        this.adapter = adapter;
        resetCoords();
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

        switch(e.getActionMasked()) {
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
        return false;
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        Log.d("TOUCH", String.valueOf(e.getActionMasked()));

//        switch(e.getActionMasked()) {
//            case MotionEvent.ACTION_MOVE:
//                handleActionMove(rv, e);
//                break;
//            case MotionEvent.ACTION_CANCEL:
//                handleActionCancel(rv, e);
//                break;
//            case MotionEvent.ACTION_UP:
//                handleActionCancel(rv, e);
//                break;
//            case MotionEvent.ACTION_OUTSIDE:
//                handleActionCancel(rv, e);
//                break;
//        }
    }

    private void handleActionMove(RecyclerView rv, MotionEvent e) {
        x1 = x2;
        x2 = e.getX();

        View view = rv.findChildViewUnder(e.getX(), e.getY());

        if (view == null) {
            return;
        }

        personViewHolder = (PersonViewHolder) rv.findContainingViewHolder(view);

        if (dataView == null) {
            dataView = view.findViewById(R.id.person_swipe_under_item__person);
        }
        if (controlsView ==  null) {
            controlsView = view.findViewById(R.id.person_swipe_under_item__controls);
        }

        if (x1 >= 0 && x2 >= 0) {
            translateViewsBy(x2 - x1);
        }
    }

    private void handleActionCancel(RecyclerView rv, MotionEvent e) {
        // Should not happen.
        if (dataView == null || controlsView == null) {
            resetCoords();
            resetActionViews();
            return;
        }

        if (isOverPositionThreshold()) {
            dismissAndChange();
        } else {
            translateViewsTo(0, 300L, null, 0);
            resetCoords();
            resetActionViews();
        }
    }

    private void dismissAndChange() {
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                personViewHolder.mark();
                translateViewsTo(0, 300L, null, 1000);
                resetCoords();
                resetActionViews();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        };

        if (personViewHolder.isMarked()) {
            final int position = personViewHolder.getAdapterPosition();
            final Person removed = adapter.getDataAt(position);

            Snackbar snackbar = Snackbar.make(personViewHolder.itemView, "Removed", 5000)
                    .setAction("Undo", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            adapter.addDataAt(removed, position);
                        }
                    });
            snackbar.show();

            adapter.removeDataAt(personViewHolder.getAdapterPosition());
            translateViewsTo(0, 0, null, 0);
            resetCoords();
            resetActionViews();
        } else {
            translateViewsTo(dataView.getRight() * -1, 100L, animatorListener, 0);
        }
    }

    private void translateViewsBy(float translateXBy) {
        float dataViewTranslationX = dataView.getTranslationX();
        float dataViewWidth = dataView.getWidth();

        dataView.setTranslationX(dataViewTranslationX + translateXBy);
        controlsView.setTranslationX(dataViewTranslationX + dataViewWidth + translateXBy);
    }

    private void translateViewsTo(float translateXTo, long duration, Animator.AnimatorListener listener, long startDelay) {
        dataView.animate().setStartDelay(startDelay).translationX(translateXTo).setDuration(duration);
        controlsView.animate().setStartDelay(startDelay).translationX(dataView.getWidth() + translateXTo).setDuration(duration).setListener(listener);
    }

    private boolean isOverPositionThreshold() {
        float currentDataViewTranslationX = dataView.getTranslationX();
        float width = dataView.getWidth();

        return (Math.abs(currentDataViewTranslationX) / width) >= POSITION_THRESHOLD;
    }

    private void resetActionViews() {
        dataView = null;
        controlsView = null;
    }

    private void resetCoords() {
        x1 = -1;
        x2 = -1;
    }
}
