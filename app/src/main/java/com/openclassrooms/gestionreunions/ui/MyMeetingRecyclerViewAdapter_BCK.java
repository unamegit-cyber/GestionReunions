/*package com.openclassrooms.gestionreunions.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.openclassrooms.gestionreunions.R;
import com.openclassrooms.gestionreunions.databinding.FragmentMeetingBinding;
import com.openclassrooms.gestionreunions.model.Meeting;

import java.util.List;

public class MyMeetingRecyclerViewAdapter_BCK extends RecyclerView.Adapter<MyMeetingRecyclerViewAdapter_BCK.ViewHolder> implements CustomClickListener {

    private final List<Meeting> mMeetings;
    private FragmentMeetingBinding binding;

    public MyMeetingRecyclerViewAdapter_BCK(List<Meeting> items) {
        mMeetings = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        binding = FragmentMeetingBinding.inflate(LayoutInflater.from(parent.getContext()));
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_meeting, parent, false);
        //View view = binding.getRoot();
        /*
        setContentView(view);
         *
//        return new ViewHolder(view);
        return new ViewHolder(binding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Meeting meeting = mMeetings.get(position);
        binding.label.setText(meeting.getHour() + " " + meeting.getLocation().getRoom() + " " + meeting.getSubject());
        binding.contributors.setText(meeting.getContributors().get(0).getEmail());
    }

    @Override
    public int getItemCount() {
        return mMeetings.size();
    }

    @Override
    public void cardClicked(Meeting meeting) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public View mView;

        public ViewHolder(@NonNull FragmentMeetingBinding binding) {
            super(binding.getRoot());
//            mView = view;
        }
    }
}*/