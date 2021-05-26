package com.openclassrooms.gestionreunions.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.openclassrooms.gestionreunions.R;
import com.openclassrooms.gestionreunions.databinding.ActivityListMeetingBinding;

public class ListMeetingActivity extends AppCompatActivity {

    ListMeetingPagerAdapter mPagerAdapter;
    private ActivityListMeetingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListMeetingBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        mPagerAdapter = new ListMeetingPagerAdapter(getSupportFragmentManager(), this);
        binding.viewPager.setAdapter(mPagerAdapter);
    }
}