package com.mostafa.fci.languageapp;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class CategoryAdapter extends FragmentStatePagerAdapter {

    public CategoryAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new NumbersFragment();
        } else if (position == 1) {
            return new FamilyFragment();
        } else if (position == 2) {
            return new ColorsFragment();
        } else {
            return new PhrasesFragment();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return Constants.NUMBERS_SECTION;
        } else if (position == 1) {
            return Constants.FAMILY_SECTION;
        } else if (position == 2) {
            return Constants.COLORS_SECTION;
        } else {
            return Constants.PHRASES_SECTION;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
