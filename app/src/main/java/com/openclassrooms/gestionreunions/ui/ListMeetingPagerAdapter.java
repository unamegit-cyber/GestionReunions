package com.openclassrooms.gestionreunions.ui;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.openclassrooms.gestionreunions.R;

import java.util.Arrays;
import java.util.List;

public class ListMeetingPagerAdapter extends FragmentPagerAdapter {

    private List<MeetingListFragment> fragments = Arrays.asList(MeetingListFragment.newInstance());
    private Context context;

    public ListMeetingPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
//        if (position == 0) {
            return context.getResources().getString(R.string.Fragment_Meeting_List);
//        }
    }
}