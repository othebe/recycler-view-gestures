package com.example.othebe.recyclerviewgestures.swipers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.othebe.recyclerviewgestures.R;
import com.example.othebe.recyclerviewgestures.models.Person;

import java.util.ArrayList;

/**
 * Created by othebe on 5/20/16.
 */
public abstract class RecyclerViewAdapter<T> extends RecyclerView.Adapter<PersonViewHolder> {
    private ArrayList<Person> persons = new ArrayList<>(0);

    @Override
    public int getItemCount() {
        return persons.size();
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        holder.setPerson(persons.get(position));
    }

    public void setData(ArrayList<Person> persons) {
        this.persons = persons;
        notifyDataSetChanged();
    }

    public Person getDataAt(int position) {
        return persons.get(position);
    }

    public void removeDataAt(int position) {
        persons.remove(position);
        notifyItemRemoved(position);
    }

    public void addDataAt(Person person, int position) {
        persons.add(position, person);
        notifyItemInserted(position);
    }
}
