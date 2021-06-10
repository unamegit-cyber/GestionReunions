package com.openclassrooms.gestionreunions.ui;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.openclassrooms.gestionreunions.BR;
import com.openclassrooms.gestionreunions.R;
import com.openclassrooms.gestionreunions.model.Meeting;
import com.openclassrooms.gestionreunions.databinding.FragmentMeetingBinding;

import java.util.List;

public class MyMeetingRecyclerViewAdapter
        extends RecyclerView.Adapter<MyMeetingRecyclerViewAdapter.ViewHolder>
        implements ItemClickListener {

    private List<Meeting> MeetingList;
    private Context context;

    public MyMeetingRecyclerViewAdapter(List<Meeting> meetingList, Context ctx) {
        this.MeetingList = meetingList;
        context = ctx;
    }

    @Override
    public MyMeetingRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                      int viewType) {
        FragmentMeetingBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.fragment_meeting, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Meeting meeting = MeetingList.get(position);
        holder.bind(meeting);
        holder.fragmentMeeting.setItemClickListener(this);
        holder.fragmentMeeting.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return MeetingList.size();
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

    @Override
    public void removeSingleItem(Meeting meeting, int position) {
        //MeetingList.remove(meeting);
        //MeetingList.remove(position);
        this.notifyItemRemoved(position);
    }
}