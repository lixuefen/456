package com.example.lenovo.zuoye922;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;



import java.util.ArrayList;

public class MyVpFragmentAdapter extends FragmentStatePagerAdapter {
    private ArrayList<VpFragment> list;

    public MyVpFragmentAdapter(FragmentManager fm, ArrayList<VpFragment> list) {
        super(fm);
        this.list = list;
    }

    public MyVpFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return list.size();
    }
}
