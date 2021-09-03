package com.openclassrooms.gestionreunions.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(this.id, location.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

}
