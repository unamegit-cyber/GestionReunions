package com.openclassrooms.gestionreunions.service;

import com.openclassrooms.gestionreunions.model.Meeting;

import java.util.ArrayList;
import java.util.List;

public class DummyMeetingApiService implements MeetingApiService {

    private List<Meeting> meetings = DummyMeetingGenerator.generateMeetings();

    @Override
    public List<Meeting> getMeetings() {
        return meetings;
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
