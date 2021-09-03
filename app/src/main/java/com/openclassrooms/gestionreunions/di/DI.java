package com.openclassrooms.gestionreunions.di;

import com.openclassrooms.gestionreunions.service.DummyMeetingApiService;
import com.openclassrooms.gestionreunions.service.MeetingApiService;

public class DI {

    private static MeetingApiService service = new DummyMeetingApiService();

    public static MeetingApiService getMeetingApiService() {
        return service;
    }

    public static MeetingApiService getNewInstanceApiService() {
        return new DummyMeetingApiService();
    }
}