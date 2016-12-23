package com.jmedinilla.tablayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private int tabCount;
    private String[] tabTitles;

    ViewPagerAdapter(FragmentManager fm, int tabCount, String[] tabTitles) {
        super(fm);
        this.tabCount = tabCount;
        this.tabTitles = tabTitles;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();

        switch (position) {
            case 0:
                bundle.putString(CustomFragment.KEY_TEXT, "aaaaaaaaaa");
                break;
            case 1:
                bundle.putString(CustomFragment.KEY_TEXT, "bbbbbbbbbb");
                break;
            case 2:
                bundle.putString(CustomFragment.KEY_TEXT, "cccccccccc");
                break;
            case 3:
                bundle.putString(CustomFragment.KEY_TEXT, "dddddddddd");
                break;
            case 4:
                bundle.putString(CustomFragment.KEY_TEXT, "eeeeeeeeee");
                break;
            case 5:
                bundle.putString(CustomFragment.KEY_TEXT, "ffffffffff");
                break;
            case 6:
                bundle.putString(CustomFragment.KEY_TEXT, "gggggggggg");
                break;
            case 7:
                bundle.putString(CustomFragment.KEY_TEXT, "hhhhhhhhhh");
                break;
            case 8:
                bundle.putString(CustomFragment.KEY_TEXT, "iiiiiiiiii");
                break;
        }

        return CustomFragment.newInstance(bundle);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.tabTitles[position];
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
