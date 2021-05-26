package com.openclassrooms.gestionreunions.ui;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.gestionreunions.R;
import com.openclassrooms.gestionreunions.model.Meeting;
import com.openclassrooms.gestionreunions.service.DummyMeetingGenerator;
import com.openclassrooms.gestionreunions.databinding.FragmentMeetingBinding;

import java.util.List;

public class MyMeetingRecyclerViewAdapter extends RecyclerView.Adapter<MyMeetingRecyclerViewAdapter.ViewHolder> {

    private final List<Meeting> mMeetings;
    private FragmentMeetingBinding binding;

    public MyMeetingRecyclerViewAdapter(List<Meeting> items) {
        mMeetings = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        binding = FragmentMeetingBinding.inflate(LayoutInflater.from(parent.getContext()));
        View view = binding.getRoot();
        /*
        setContentView(view);
         */
        return new ViewHolder(view);
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

    public class ViewHolder extends RecyclerView.ViewHolder {

        public View mView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
        }
    }
}