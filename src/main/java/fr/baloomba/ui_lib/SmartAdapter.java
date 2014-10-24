package fr.baloomba.ui_lib;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class SmartAdapter<T> extends BaseAdapter {

    // <editor-fold desc="VARIABLES">

    private static final String TAG = SmartAdapter.class.getSimpleName();

    protected static LayoutInflater sInflater;
    protected Fragment mFragment;

    protected ArrayList<T> mData = new ArrayList<T>();
    protected Boolean mIsLoading = false;

    // </editor-fold>

    // <editor-fold desc="CONSTRUCTORS">

    public SmartAdapter(Fragment fragment) {
        mFragment = fragment;
        sInflater = (LayoutInflater)mFragment.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // </editor-fold>

    // <editor-fold desc="BASE ADAPTER OVERRIDDEN METHODS">

    @Override
    public int getCount() {
        return mData != null ? mData.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return mData != null ? mData.get(i) : null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    // </editor-fold>

    // <editor-fold desc="METHODS">

    public void clear() {
        if (mData != null)
            mData.clear();
    }

    public Boolean getIsLoading() {
        return mIsLoading;
    }

    public void loadMore() {
        request();
    }

    public void update() {
        request();
    }

    protected void request() {}

    // </editor-fold>

}
