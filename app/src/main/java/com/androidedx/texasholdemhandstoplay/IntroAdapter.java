package com.androidedx.texasholdemhandstoplay;

import android.graphics.Color;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class IntroAdapter extends FragmentStatePagerAdapter {

    public IntroAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return IntroFragment.newInstance(Color.parseColor("#0A8905"), position); // blue
            default:
                return IntroFragment.newInstance(Color.parseColor("#0A8905"), position); // green
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

}
