package com.openclassrooms.gestionreunions.model;

import android.text.format.DateFormat;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Meeting {

    private long id;

    private Date date;

    private Location location;

    private String subject;

    private List<Contributor> contributors;

    private Integer color;

    public Meeting(long id, Date date, Location location, String subject, List<Contributor> contributors, Integer color) {
        this.id = id;
        this.date = date;
        this.location = location;
        this.subject = subject;
        this.contributors = contributors;
        this.color = color;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getColor() {
        return this.color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public Date getDate() {
        return this.date;
    }

    public String getDay() {
        return DateFormat.format("dd/MM/yyyy", this.date).toString();
    }

    public String getHour() {
        return DateFormat.format("hh:mm", this.date).toString();
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<Contributor> getContributors() {
        return this.contributors;
    }

    public void setContributors(List<Contributor> contributors) {
        this.contributors = contributors;
    }

    public String getTitle() {
        return this.getSubject() + " - " + this.getHour() + " - " + this.getLocation().getRoom();
    }

    public String getContributorsEmails() {
        String contributorsEmailsList = "";
        for (int i = 0; i < this.contributors.size(); i++) {
            if (contributorsEmailsList != "") {
                contributorsEmailsList += ", ";
            }
            contributorsEmailsList += this.contributors.get(i).getEmail();
        }
        return contributorsEmailsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meeting meeting = (Meeting) o;
        return Objects.equals(this.id, meeting.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

}
