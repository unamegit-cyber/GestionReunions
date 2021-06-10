package com.openclassrooms.gestionreunions.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.openclassrooms.gestionreunions.R;
import com.openclassrooms.gestionreunions.databinding.ActivityListMeetingBinding;
import com.openclassrooms.gestionreunions.model.Meeting;

import java.util.List;

import static com.openclassrooms.gestionreunions.service.DummyMeetingGenerator.DUMMY_MEETINGS;

public class ListMeetingActivity extends AppCompatActivity {

    private ActivityListMeetingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list_meeting);
        populateData();
    }

    private void populateData() {
        List<Meeting> meetingList = DUMMY_MEETINGS;

        MyMeetingRecyclerViewAdapter myMeetingRecyclerViewAdapter = new MyMeetingRecyclerViewAdapter(meetingList, this);
        binding.setMyAdapter(myMeetingRecyclerViewAdapter);
        binding.setAddClickListener(this);
    }

    public void addMeeting() {
        AddMeetingActivity.navigate(this);
    }

}