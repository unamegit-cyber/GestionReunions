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

public class SpinnerLocationAdapter extends ArrayAdapter<Location> {

    private Context context;

    private List<Location> locations;

    public SpinnerLocationAdapter(@NonNull Context context, int resource, List<Location> locations) {
        super(context, resource, locations);
        this.context = context;
        this.locations = locations;
    }

    @Override
    public int getCount(){
        return locations.size();
    }

    @Override
    public Location getItem(int position){
        return locations.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView label = (TextView) super.getView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        label.setText(this.locations.get(position).getRoom());
        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView label = (TextView) super.getDropDownView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        label.setText(locations.get(position).getRoom());
        return label;
    }

}
