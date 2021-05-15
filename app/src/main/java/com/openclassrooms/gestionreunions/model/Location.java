package com.openclassrooms.gestionreunions.model;

public class Location {

    private long id;

    private String Room;

    public Location(long id, String room) {
        this.id = id;
        Room = room;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoom() {
        return Room;
    }

    public void setRoom(String room) {
        Room = room;
    }

}
