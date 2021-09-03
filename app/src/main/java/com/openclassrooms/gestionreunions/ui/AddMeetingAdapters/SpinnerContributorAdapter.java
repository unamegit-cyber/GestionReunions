package com.openclassrooms.gestionreunions.ui.AddMeetingAdapters;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.openclassrooms.gestionreunions.model.Contributor;

import java.util.List;

public class SpinnerContributorAdapter extends ArrayAdapter<Contributor> {

    private Context context;

    private List<Contributor> contributors;

    public SpinnerContributorAdapter(@NonNull Context context, int resource, List<Contributor> contributors) {
        super(context, resource, contributors);
        this.context = context;
        this.contributors = contributors;
    }

    @Override
    public int getCount(){
        return contributors.size();
    }

    @Override
    public Contributor getItem(int position){
        return contributors.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView label = (TextView) super.getView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        label.setText(this.contributors.get(position).getEmail());
        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView label = (TextView) super.getDropDownView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        label.setText(contributors.get(position).getEmail());
        return label;
    }

}
