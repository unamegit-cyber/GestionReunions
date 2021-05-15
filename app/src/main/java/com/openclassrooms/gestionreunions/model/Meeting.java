package com.openclassrooms.gestionreunions.model;

import java.util.Date;
import java.util.List;

public class Meeting {

    private long id;

    private Date date;

    private Location Location;

    private String Subjet;

    private List<Contributor> Contributors;

    public Meeting(long id, Date date, Location Location, String Subject, List<Contributor> Contributors) {
        this.id = id;
        this.date = date;
        this.Location = Location;
        this.Subjet = Subject;
        this.Contributors = Contributors;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Location getLocation() {
        return Location;
    }

    public void setLocation(Location location) {
        Location = location;
    }

    public String getSubjet() {
        return Subjet;
    }

    public void setSubjet(String subjet) {
        Subjet = subjet;
    }

    public List<Contributor> getContributors() {
        return Contributors;
    }

    public void setContributors(List<Contributor> contributors) {
        Contributors = contributors;
    }

}
