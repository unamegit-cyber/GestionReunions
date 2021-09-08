package com.openclassrooms.gestionreunions.service;

import com.openclassrooms.gestionreunions.model.Meeting;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class DummyMeetingApiService implements MeetingApiService {

    private List<Meeting> meetings = DummyMeetingGenerator.generateMeetings();

    @Override
    public List<Meeting> getMeetings() {
        return meetings;
    }

    @Override
    public List<Meeting> getMeetingsFilteredByDate(int year, int monthOfYear, int dayOfMonth) {
        List<Meeting> meetingsFilteredByDate = new ArrayList<>();
        for (Meeting meeting : meetings) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(meeting.getDate());
            if (cal.get(Calendar.DAY_OF_MONTH) == dayOfMonth &&
                cal.get(Calendar.MONTH) == monthOfYear &&
                cal.get(Calendar.YEAR) == year) {
                meetingsFilteredByDate.add(meeting);
            }
        }
        return meetingsFilteredByDate;
    }

    @Override
    public Meeting getMeeting(long id) {
        for (Meeting meeting : meetings) {
            if (meeting.getId() == id) {
                return meeting;
            }
        }
        return null;
    }

    @Override
    public void deleteMeeting(Meeting meeting) {
        meetings.remove(meeting);
    }

    @Override
    public void createMeeting(Meeting meeting) {
        meetings.add(meeting);
    }

}
