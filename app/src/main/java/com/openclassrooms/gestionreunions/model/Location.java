package com.openclassrooms.gestionreunions.model;

public class Location {

    private long id;

    private String room;

    public Location(long id, String room) {
        this.id = id;
        this.room = room;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoom() {
        return this.room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

}
