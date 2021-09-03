package com.openclassrooms.gestionreunions.ui;

import com.openclassrooms.gestionreunions.model.Meeting;

public interface ItemClickListener {
    void removeItem(Meeting meeting);
    void addItem(Meeting meeting);
}