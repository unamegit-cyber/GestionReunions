  package com.openclassrooms.gestionreunions.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.openclassrooms.gestionreunions.R;
import com.openclassrooms.gestionreunions.databinding.ActivityAddMeetingBinding;
import com.openclassrooms.gestionreunions.di.DI;
import com.openclassrooms.gestionreunions.model.Location;
import com.openclassrooms.gestionreunions.model.Meeting;
import com.openclassrooms.gestionreunions.service.DummyMeetingGenerator;
import com.openclassrooms.gestionreunions.ui.AddMeetingAdapters.SpinnerColorAdapter;
import com.openclassrooms.gestionreunions.ui.AddMeetingAdapters.SpinnerLocationAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import static com.openclassrooms.gestionreunions.service.DummyMeetingGenerator.DUMMY_COLORS;
import static com.openclassrooms.gestionreunions.service.DummyMeetingGenerator.DUMMY_CONTRIBUTORS;
import static com.openclassrooms.gestionreunions.service.DummyMeetingGenerator.DUMMY_LOCATIONS;

public class AddMeetingActivity extends AppCompatActivity {

    private ActivityAddMeetingBinding binding;
    private SpinnerLocationAdapter locationAdapter;
    private SpinnerColorAdapter colorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_meeting);
        this.populateData();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
    }

    public static void navigate(FragmentActivity activity) {
        Intent intent = new Intent(activity, AddMeetingActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }

    public void showDatePicker(View view) {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                binding.date.setText(String.valueOf(year) + "-" + (String.valueOf(monthOfYear)) + "-" + (String.valueOf(dayOfMonth)));
            }
        };
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, dateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    public void showTimePicker(View view) {
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                binding.time.setText(String.valueOf(hourOfDay) + ":" + (String.valueOf(minute)));
            }
        };
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, timeSetListener, calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE), true);
        timePickerDialog.show();
    }

    public void addMeeting(View view) {
        Meeting meeting = new Meeting(
                DI.getMeetingApiService().getMeetings().size(),
                DummyMeetingGenerator.stringToDate(binding.date.getText() + " " + binding.time.getText()),
                DummyMeetingGenerator.DUMMY_LOCATIONS.get(binding.location.getSelectedItemPosition()),
                binding.subject.getText().toString(),
                binding.contributors.getItems(),
                DummyMeetingGenerator.DUMMY_COLORS.get(binding.color.getSelectedItemPosition())
        );
        DI.getMeetingApiService().createMeeting(meeting);
        finish();
    }

}