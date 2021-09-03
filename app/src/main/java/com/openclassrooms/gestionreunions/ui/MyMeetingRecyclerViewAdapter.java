package com.openclassrooms.gestionreunions.ui;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.openclassrooms.gestionreunions.BR;
import com.openclassrooms.gestionreunions.R;
import com.openclassrooms.gestionreunions.model.Meeting;
import com.openclassrooms.gestionreunions.databinding.FragmentMeetingBinding;

import java.util.ArrayList;
import java.util.List;

public class MyMeetingRecyclerViewAdapter
        extends RecyclerView.Adapter<MyMeetingRecyclerViewAdapter.ViewHolder>
        implements ItemClickListener {

    private ArrayList<Meeting> meetingList;
    private Context context;
    public MyMeetingRecyclerViewAdapter adapter;

    public MyMeetingRecyclerViewAdapter(ArrayList<Meeting> meetingList, Context ctx) {
        this.meetingList = meetingList;
        context = ctx;
        adapter = this;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        FragmentMeetingBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.fragment_meeting, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Meeting meeting = meetingList.get(position);
        holder.bind(meeting);
        holder.fragmentMeeting.setItemClickListener(this);
        holder.fragmentMeeting.setPosition(position);
        holder.fragmentMeeting.circle.setColorFilter(meeting.getColor(), PorterDuff.Mode.SRC_ATOP);
    }

    @Override
    public int getItemCount() {
        return meetingList.size();
    }

    public MyMeetingRecyclerViewAdapter getAdapter() {
        return adapter;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public FragmentMeetingBinding fragmentMeeting;

        public ViewHolder(FragmentMeetingBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.fragmentMeeting = itemRowBinding;
        }

        public void bind(Meeting meeting) {
            fragmentMeeting.setVariable(BR.meeting, meeting);
            fragmentMeeting.executePendingBindings();
        }
    }

    public void removeItem(Meeting meeting) {
//        int position = meetingList.indexOf(meeting);
        meetingList.remove(meeting);
        this.notifyDataSetChanged();
//        this.notifyItemRemoved(position);
    }

    public void addItem(Meeting meeting) {
        meetingList.add(meeting);
        this.notifyDataSetChanged();
    }

}