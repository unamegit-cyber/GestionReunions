package com.openclassrooms.gestionreunions.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.openclassrooms.gestionreunions.R;
import com.openclassrooms.gestionreunions.databinding.ActivityAddMeetingBinding;
import com.openclassrooms.gestionreunions.di.DI;
import com.openclassrooms.gestionreunions.model.Contributor;
import com.openclassrooms.gestionreunions.model.Location;
import com.openclassrooms.gestionreunions.model.Meeting;
import com.openclassrooms.gestionreunions.service.DummyMeetingApiService;
import com.openclassrooms.gestionreunions.service.DummyMeetingGenerator;
import com.openclassrooms.gestionreunions.service.MeetingApiService;
import com.openclassrooms.gestionreunions.ui.AddMeetingAdapters.SpinnerColorAdapter;
import com.openclassrooms.gestionreunions.ui.AddMeetingAdapters.SpinnerContributorAdapter;
import com.openclassrooms.gestionreunions.ui.AddMeetingAdapters.SpinnerLocationAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.openclassrooms.gestionreunions.service.DummyMeetingGenerator.DUMMY_COLORS;
import static com.openclassrooms.gestionreunions.service.DummyMeetingGenerator.DUMMY_CONTRIBUTORS;
import static com.openclassrooms.gestionreunions.service.DummyMeetingGenerator.DUMMY_LOCATIONS;

public class AddMeetingActivity extends AppCompatActivity {

    private ActivityAddMeetingBinding binding;
    private SpinnerLocationAdapter locationAdapter;
    private SpinnerColorAdapter colorAdapter;
    private SpinnerContributorAdapter contributorsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_meeting);
        this.populateData();
    }

    private void populateData() {
        binding.subject.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            @Override
            public void afterTextChanged(Editable s) {
                binding.create.setEnabled(s.length() > 0);
            }
        });

        List<Location> locationList = DUMMY_LOCATIONS;
        this.locationAdapter = new SpinnerLocationAdapter(this, android.R.layout.simple_spinner_item, locationList);
        binding.setLocationAdapter(this.locationAdapter);

        List<Integer> colorList = DUMMY_COLORS;
        this.colorAdapter = new SpinnerColorAdapter(this, android.R.layout.simple_spinner_item, colorList);
        binding.setColorAdapter(this.colorAdapter);

        String[] contributorsEmailsArray = new String[DUMMY_CONTRIBUTORS.size()];
        for (int i = 0; i < DUMMY_CONTRIBUTORS.size(); i++) {
            contributorsEmailsArray[i] = DUMMY_CONTRIBUTORS.get(i).getEmail();
        }
        binding.contributors.setItems(Arrays.asList(contributorsEmailsArray));
        /*
        List<Contributor> contributorsList = DUMMY_CONTRIBUTORS;
        this.contributorsAdapter = new SpinnerContributorAdapter(this, android.R.layout.simple_spinner_item, contributorsList);
        binding.setContributorsAdapter(this.contributorsAdapter);
        */
    }

    public static void navigate(FragmentActivity activity) {
        Intent intent = new Intent(activity, AddMeetingActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }

    public void addMeeting(View view) {
        MeetingApiService apiService = DI.getMeetingApiService();
//Log.d("nb", String.valueOf(apiService.getMeetings().size()));

        Meeting meeting = new Meeting(
                apiService.getMeetings().size(),
                DummyMeetingGenerator.stringToDate("2022-10-11 12:35"),
                new Location(2, "Room3"),
                binding.subject.getText().toString(),
                DummyMeetingGenerator.DUMMY_CONTRIBUTORS,//new ArrayList<Contributor>(), //binding.contributors.getSe
                Color.parseColor("#0000FF")
        );
        apiService.createMeeting(meeting);

/*
        ArrayList<Meeting> meetingList = new ArrayList<>(DI.getMeetingApiService().getMeetings());
        MyMeetingRecyclerViewAdapter myMeetingRecyclerViewAdapter = new MyMeetingRecyclerViewAdapter(meetingList, this);
        myMeetingRecyclerViewAdapter.getAdapter().notifyDataSetChanged();
//        RecyclerView.Adapter rootAdapter = myMeetingRecyclerViewAdapter.getAdapter();
        Log.d("nb", String.valueOf(apiService.getMeetings().size()));

        /*
        Date date = new Date();
        Meeting meeting = new Meeting(
                apiService.getMeetings().size(),
                date,
                (Location) binding.location.getSelectedItem(),
                binding.subject.getText().toString(),
                DummyMeetingGenerator.DUMMY_CONTRIBUTORS,//new ArrayList<Contributor>(), //binding.contributors.getSe
                (Integer) binding.color.getSelectedItem()
        );*/
        finish();
    }

}