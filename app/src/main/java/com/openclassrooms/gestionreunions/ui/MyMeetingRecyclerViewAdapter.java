package com.openclassrooms.gestionreunions.ui;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.openclassrooms.gestionreunions.BR;
import com.openclassrooms.gestionreunions.R;
import com.openclassrooms.gestionreunions.model.Meeting;
import com.openclassrooms.gestionreunions.databinding.FragmentMeetingBinding;

import java.util.List;

public class MyMeetingRecyclerViewAdapter
        extends RecyclerView.Adapter<MyMeetingRecyclerViewAdapter.ViewHolder>
        implements CustomClickListener {

    private List<Meeting> MeetingList;
    private Context context;

    public MyMeetingRecyclerViewAdapter(List<Meeting> meetingList, Context ctx) {
        this.MeetingList = meetingList;
        context = ctx;
    }
// notifydatasetchanged
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
Log.d("meeting", meeting.getSubject());
        holder.bind(meeting);
        holder.fragmentMeeting.setItemClickListener(this);
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
    public void cardClicked(Meeting meeting) {
        Toast.makeText(context, "You clicked " + meeting.getSubject(),
                Toast.LENGTH_LONG).show();
    }
}