package com.example.othebe.recyclerviewgestures.swipers.swipe_under;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;

import com.example.othebe.recyclerviewgestures.R;

/**
 * Created by othebe on 5/20/16.
 */
public class SwipeUnderItemTouchHelperCallback extends ItemTouchHelper.Callback {
    ITouchCallbackListener touchCallbackListener;

    public SwipeUnderItemTouchHelperCallback(ITouchCallbackListener touchCallbackListener) {
        this.touchCallbackListener = touchCallbackListener;
    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        if (viewHolder != null){
            View front = viewHolder.itemView.findViewById(R.id.person_swipe_under_item__person);

            getDefaultUIUtil().onSelected(front);
        }
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return makeMovementFlags(0, ItemTouchHelper.LEFT);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        View front = viewHolder.itemView.findViewById(R.id.person_swipe_under_item__person);
        View back = viewHolder.itemView.findViewById(R.id.person_swipe_under_item__controls);

        viewHolder.itemView.invalidate();

    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        touchCallbackListener.onSwiped(viewHolder.getAdapterPosition());

        View front = viewHolder.itemView.findViewById(R.id.person_swipe_under_item__person);
        View back = viewHolder.itemView.findViewById(R.id.person_swipe_under_item__controls);

//        front
//                .animate()
//                .translationX(0)
//                .setDuration(1000);
    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        View front = viewHolder.itemView.findViewById(R.id.person_swipe_under_item__person);
        View back = viewHolder.itemView.findViewById(R.id.person_swipe_under_item__controls);

        c.save();
        getDefaultUIUtil().onDraw(c, recyclerView, front, dX, dY, actionState, isCurrentlyActive);
        c.restore();

        Log.d("tX", String.valueOf(front.getTranslationX()));

//        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }
}
