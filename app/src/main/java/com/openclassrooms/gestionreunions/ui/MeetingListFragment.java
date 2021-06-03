/*
package com.openclassrooms.gestionreunions.ui;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.openclassrooms.gestionreunions.R;
import com.openclassrooms.gestionreunions.model.Meeting;
import com.openclassrooms.gestionreunions.service.DummyMeetingGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MeetingListFragment extends Fragment {

    private int mColumnCount = 1;

    public MeetingListFragment() {
    }

    public static MeetingListFragment newInstance() {
        MeetingListFragment fragment = new MeetingListFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private List<Meeting> meetingListOfDay(List<Meeting> meetings, Date day) {
        List<Meeting> meetingList = new ArrayList();
        for (Meeting meeting : meetings) {
            if (DateFormat.format("dd/MM/yyyy", day).toString().equals(DateFormat.format("dd/MM/yyyy", meeting.getDate()).toString())) {
                meetingList.add(meeting);
            }
        }
        return meetingList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meeting_list, container, false);

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            recyclerView.setAdapter(new MyMeetingRecyclerViewAdapter(meetingListOfDay(DummyMeetingGenerator.DUMMY_MEETINGS, Calendar.getInstance().getTime())));
//            recyclerView.setAdapter(new MyMeetingRecyclerViewAdapter(DummyMeetingGenerator.DUMMY_MEETINGS));
        }

        return view;
    }
}
                    */