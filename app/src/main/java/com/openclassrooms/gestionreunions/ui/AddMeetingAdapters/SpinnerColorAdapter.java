package com.openclassrooms.gestionreunions.ui.AddMeetingAdapters;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.openclassrooms.gestionreunions.model.Location;

import java.util.List;

public class SpinnerColorAdapter extends ArrayAdapter<Integer> {

    private Context context;

    private List<Integer> colors;

    public SpinnerColorAdapter(@NonNull Context context, int resource, List<Integer> colors) {
        super(context, resource, colors);
        this.context = context;
        this.colors = colors;
    }

    @Override
    public int getCount(){
        return colors.size();
    }

    @Override
    public Integer getItem(int position){
        return colors.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView label = (TextView) super.getView(position, convertView, parent);
        label.setBackgroundColor(this.colors.get(position));
        label.setText("");
        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView label = (TextView) super.getDropDownView(position, convertView, parent);
        label.setBackgroundColor(this.colors.get(position));
        label.setText("");
        return label;
    }

}
