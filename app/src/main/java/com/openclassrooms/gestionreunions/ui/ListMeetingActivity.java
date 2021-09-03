package com.openclassrooms.gestionreunions.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.openclassrooms.gestionreunions.R;
import com.openclassrooms.gestionreunions.databinding.ActivityListMeetingBinding;
import com.openclassrooms.gestionreunions.di.DI;
import com.openclassrooms.gestionreunions.generated.callback.OnClickListener;
import com.openclassrooms.gestionreunions.model.Meeting;
import com.openclassrooms.gestionreunions.service.DummyMeetingGenerator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

public class ListMeetingActivity extends AppCompatActivity {

    private ActivityListMeetingBinding binding;
    private ArrayList<Meeting> meetingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list_meeting);
        populateData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // switch item
        Log.d("item", String.valueOf(item.getTitle()));
        return super.onOptionsItemSelected(item);
    }

    private void populateData() {
        meetingList = new ArrayList<>(DI.getMeetingApiService().getMeetings());
        MyMeetingRecyclerViewAdapter myMeetingRecyclerViewAdapter = new MyMeetingRecyclerViewAdapter(meetingList, this);
        binding.setMyAdapter(myMeetingRecyclerViewAdapter);
        binding.setAddClickListener(this);
    }

    public void addMeeting() {
        AddMeetingActivity.navigate(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (binding.recyclerView.getAdapter() != null) {
            meetingList.clear();
            meetingList.addAll(DI.getMeetingApiService().getMeetings());
            binding.recyclerView.getAdapter().notifyDataSetChanged();
        }
    }

    public void filterByDate(MenuItem item){
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Log.e("DATE:", dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
            }
        };
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, dateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

}