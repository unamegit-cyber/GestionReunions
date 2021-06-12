package com.openclassrooms.gestionreunions.service;

import android.graphics.Color;

import com.openclassrooms.gestionreunions.model.Contributor;
import com.openclassrooms.gestionreunions.model.Location;
import com.openclassrooms.gestionreunions.model.Meeting;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DummyMeetingGenerator {

    private static String DATE_FORMAT = "yyyy-MM-dd HH:mm";

    private static Date stringToDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
        try {
            return format.parse(date);
        } catch (ParseException e) {
            return new Date();
        }
    }

    public static List<Contributor> DUMMY_CONTRIBUTORS = Arrays.asList(
            new Contributor(0, "Bob0", "Smith0", "bob0.smith0@free.fr"),
            new Contributor(1, "Bob1", "Smith1", "bob1.smith1@free.fr"),
            new Contributor(2, "Bob2", "Smith2", "bob2.smith2@free.fr"),
            new Contributor(3, "Bob3", "Smith3", "bob3.smith3@free.fr")
    );

    public static List<Location> DUMMY_LOCATIONS = Arrays.asList(
            new Location(0, "Room1"),
            new Location(1, "Room2"),
            new Location(2, "Room3"),
            new Location(3, "Room4")
    );

    public static List<Integer> DUMMY_COLORS = Arrays.asList(
            Color.parseColor("#FF0000"),
            Color.parseColor("#00FF00"),
            Color.parseColor("#555555"),
            Color.parseColor("#0000FF")
    );

    private static Date now = Calendar.getInstance().getTime();

    public static List<Meeting> DUMMY_MEETINGS = Arrays.asList(
            new Meeting(0, now, DUMMY_LOCATIONS.get(0), "today qu'est ce que la vie ?", Arrays.asList(DUMMY_CONTRIBUTORS.get(0), DUMMY_CONTRIBUTORS.get(2)), DUMMY_COLORS.get(0)),
            new Meeting(1, now, DUMMY_LOCATIONS.get(1), "today Pourquoi la vie ?", Arrays.asList(DUMMY_CONTRIBUTORS.get(1), DUMMY_CONTRIBUTORS.get(2), DUMMY_CONTRIBUTORS.get(3)), DUMMY_COLORS.get(1)),
            new Meeting(2, stringToDate("2022-10-11 12:35"), DUMMY_LOCATIONS.get(0), "parce que la vie", Arrays.asList(DUMMY_CONTRIBUTORS.get(0), DUMMY_CONTRIBUTORS.get(1), DUMMY_CONTRIBUTORS.get(2)), DUMMY_COLORS.get(2)),
            new Meeting(3, stringToDate("2021-10-02 09:22"), DUMMY_LOCATIONS.get(0), "qu'est ce que la vie ?", Arrays.asList(DUMMY_CONTRIBUTORS.get(0), DUMMY_CONTRIBUTORS.get(2)), DUMMY_COLORS.get(3)),
            new Meeting(4, stringToDate("2020-12-13 19:45"), DUMMY_LOCATIONS.get(1), "Pourquoi la vie ?", Arrays.asList(DUMMY_CONTRIBUTORS.get(1), DUMMY_CONTRIBUTORS.get(2), DUMMY_CONTRIBUTORS.get(3)), DUMMY_COLORS.get(0)),
            new Meeting(5, stringToDate("2022-10-11 12:35"), DUMMY_LOCATIONS.get(0), "parce que la vie", Arrays.asList(DUMMY_CONTRIBUTORS.get(0), DUMMY_CONTRIBUTORS.get(1), DUMMY_CONTRIBUTORS.get(2)), DUMMY_COLORS.get(0)),
            new Meeting(6, stringToDate("2021-10-02 09:22"), DUMMY_LOCATIONS.get(0), "qu'est ce que la vie ?", Arrays.asList(DUMMY_CONTRIBUTORS.get(0), DUMMY_CONTRIBUTORS.get(2)), DUMMY_COLORS.get(2)),
            new Meeting(7, stringToDate("2020-12-13 19:45"), DUMMY_LOCATIONS.get(1), "Pourquoi la vie ?", Arrays.asList(DUMMY_CONTRIBUTORS.get(1), DUMMY_CONTRIBUTORS.get(2), DUMMY_CONTRIBUTORS.get(3)), DUMMY_COLORS.get(3)),
            new Meeting(9, stringToDate("2022-10-11 12:35"), DUMMY_LOCATIONS.get(0), "parce que la vie", Arrays.asList(DUMMY_CONTRIBUTORS.get(0), DUMMY_CONTRIBUTORS.get(1), DUMMY_CONTRIBUTORS.get(2)), DUMMY_COLORS.get(0)),
            new Meeting(10, stringToDate("2021-10-02 09:22"), DUMMY_LOCATIONS.get(0), "qu'est ce que la vie ?", Arrays.asList(DUMMY_CONTRIBUTORS.get(0), DUMMY_CONTRIBUTORS.get(2)), DUMMY_COLORS.get(1)),
            new Meeting(11, stringToDate("2020-12-13 19:45"), DUMMY_LOCATIONS.get(1), "Pourquoi la vie ?", Arrays.asList(DUMMY_CONTRIBUTORS.get(1), DUMMY_CONTRIBUTORS.get(2), DUMMY_CONTRIBUTORS.get(3)), DUMMY_COLORS.get(2)),
            new Meeting(12, stringToDate("2022-10-11 12:35"), DUMMY_LOCATIONS.get(0), "parce que la vie", Arrays.asList(DUMMY_CONTRIBUTORS.get(0), DUMMY_CONTRIBUTORS.get(1), DUMMY_CONTRIBUTORS.get(2)), DUMMY_COLORS.get(2)),
            new Meeting(13, stringToDate("2021-10-02 09:22"), DUMMY_LOCATIONS.get(0), "qu'est ce que la vie ?", Arrays.asList(DUMMY_CONTRIBUTORS.get(0), DUMMY_CONTRIBUTORS.get(2)), DUMMY_COLORS.get(0)),
            new Meeting(14, stringToDate("2020-12-13 19:45"), DUMMY_LOCATIONS.get(1), "Pourquoi la vie ?", Arrays.asList(DUMMY_CONTRIBUTORS.get(1), DUMMY_CONTRIBUTORS.get(2), DUMMY_CONTRIBUTORS.get(3)), DUMMY_COLORS.get(3)),
            new Meeting(15, stringToDate("2022-10-11 12:35"), DUMMY_LOCATIONS.get(0), "parce que la vie", Arrays.asList(DUMMY_CONTRIBUTORS.get(0), DUMMY_CONTRIBUTORS.get(1), DUMMY_CONTRIBUTORS.get(2)), DUMMY_COLORS.get(1)),
            new Meeting(16, stringToDate("2021-10-02 09:22"), DUMMY_LOCATIONS.get(0), "qu'est ce que la vie ?", Arrays.asList(DUMMY_CONTRIBUTORS.get(0), DUMMY_CONTRIBUTORS.get(2)), DUMMY_COLORS.get(0)),
            new Meeting(17, stringToDate("2020-12-13 19:45"), DUMMY_LOCATIONS.get(1), "Pourquoi la vie ?", Arrays.asList(DUMMY_CONTRIBUTORS.get(1), DUMMY_CONTRIBUTORS.get(2), DUMMY_CONTRIBUTORS.get(3)), DUMMY_COLORS.get(0)),
            new Meeting(18, stringToDate("2022-10-11 12:35"), DUMMY_LOCATIONS.get(0), "parce que la vie", Arrays.asList(DUMMY_CONTRIBUTORS.get(0), DUMMY_CONTRIBUTORS.get(1), DUMMY_CONTRIBUTORS.get(2)), DUMMY_COLORS.get(3))
    );

    static List<Meeting> generateMeetings() {
        return new ArrayList<>(DUMMY_MEETINGS);
    }

}
