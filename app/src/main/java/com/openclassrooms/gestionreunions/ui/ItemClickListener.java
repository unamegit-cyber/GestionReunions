package com.openclassrooms.gestionreunions.ui;

import com.openclassrooms.gestionreunions.model.Meeting;

public interface ItemClickListener {
    void removeSingleItem(Meeting meeting, int position);
}