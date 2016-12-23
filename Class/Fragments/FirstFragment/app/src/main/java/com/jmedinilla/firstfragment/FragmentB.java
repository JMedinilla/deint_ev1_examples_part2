package com.jmedinilla.firstfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentB extends Fragment {
    private TextView txtFragmentB;
    DisplayMetrics displayMetrics;
    private static final String PARAM_1 = "param_1";
    private static final String PARAM_2 = "param_2";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        displayMetrics = getResources().getDisplayMetrics();
        View view = inflater.inflate(R.layout.fragmentb, container, false);
        txtFragmentB = (TextView) view.findViewById(R.id.txtFragmentB);
        return view;
    }

    public void changeTextProperties(int fontsize, String text) {
        txtFragmentB.setTextSize(fontsize);
        txtFragmentB.setText(text);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(PARAM_1, txtFragmentB.getText().toString());
        outState.putFloat(PARAM_2, txtFragmentB.getTextSize());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            txtFragmentB.setText(savedInstanceState.getString(PARAM_1));
            txtFragmentB.setTextSize(savedInstanceState.getFloat(PARAM_2) / displayMetrics.density);
        }
        super.onViewStateRestored(savedInstanceState);
    }
}
