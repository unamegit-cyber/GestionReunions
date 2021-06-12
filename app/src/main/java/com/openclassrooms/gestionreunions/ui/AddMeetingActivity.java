package com.openclassrooms.gestionreunions.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.openclassrooms.gestionreunions.R;
import com.openclassrooms.gestionreunions.databinding.ActivityAddMeetingBinding;
import com.openclassrooms.gestionreunions.model.Location;
import com.openclassrooms.gestionreunions.ui.AddMeetingAdapters.SpinnerColorAdapter;
import com.openclassrooms.gestionreunions.ui.AddMeetingAdapters.SpinnerLocationAdapter;

import java.util.List;

import static com.openclassrooms.gestionreunions.service.DummyMeetingGenerator.DUMMY_COLORS;
import static com.openclassrooms.gestionreunions.service.DummyMeetingGenerator.DUMMY_LOCATIONS;

public class AddMeetingActivity extends AppCompatActivity {

    private ActivityAddMeetingBinding binding;
    private Spinner mySpinner;
    private SpinnerLocationAdapter locationAdapter;
    private SpinnerColorAdapter colorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_meeting);
        this.populateData();
    }

    private void populateData() {
        List<Location> locationList = DUMMY_LOCATIONS;
        this.locationAdapter = new SpinnerLocationAdapter(this, android.R.layout.simple_spinner_item, locationList);
        binding.setLocationAdapter(this.locationAdapter);

        List<Integer> colorList = DUMMY_COLORS;
        this.colorAdapter = new SpinnerColorAdapter(this, android.R.layout.simple_spinner_item, colorList);
        binding.setColorAdapter(this.colorAdapter);
    }

    public static void navigate(FragmentActivity activity) {
        Intent intent = new Intent(activity, AddMeetingActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }

}