package fr.baloomba.ui_lib.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

public class CustomFragmentPagerAdapter extends FragmentPagerAdapter {

    // <editor-fold desc="CONSTRUCTORS">

    public CustomFragmentPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    // </editor-fold>

    // <editor-fold desc="PAGER ADAPTER IMPLEMENTATION METHODS">

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }

    // </editor-fold>

    // <editor-fold desc="METHODS">

    public float getPageHeight(int position) {
        return 1.f;
    }

    // </editor-fold>

}
