package com.openclassrooms.gestionreunions.service;

import com.openclassrooms.gestionreunions.model.Meeting;

import java.util.List;

public interface MeetingApiService {

    List<Meeting> getMeetings();

    List<Meeting> getMeetingsFilteredByDate(int year, int monthOfYear, int dayOfMonth);

    public Meeting getMeeting(long id);

    void deleteMeeting(Meeting meeting);

    void createMeeting(Meeting meeting);

}
