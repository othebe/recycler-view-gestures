package com.example.othebe.recyclerviewgestures.swipers;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.othebe.recyclerviewgestures.R;
import com.example.othebe.recyclerviewgestures.models.Person;

/**
 * Created by othebe on 5/20/16.
 */
public class PersonViewHolder extends RecyclerView.ViewHolder {
    private TextView nameTv;
    private boolean isMarked;

    public PersonViewHolder(View view) {
        super(view);

        isMarked = false;
        nameTv = (TextView) view.findViewById(R.id.person_item__name);
    }

    public void setPerson(Person person) {
        nameTv.setText(person.name);
    }

    public void mark() {
        View v = itemView.findViewById(R.id.person_swipe_under_item__person);
        v.setBackgroundColor(Color.GRAY);
        isMarked = true;
    }

    public boolean isMarked() {
        return isMarked;
    }
}
