package com.jmedinilla.secondfragment;

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

    public static final String TEXT_KEY = "param_1";
    public static final String SIZE_KEY = "param_2";
    public static final String TAG_FRAGMENTB = "fragmentBTag";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public static FragmentB newInstance(Bundle arguments) {
        FragmentB fragment = new FragmentB();
        if (arguments != null) {
            fragment.setArguments(arguments);
        }
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        displayMetrics = getResources().getDisplayMetrics();
        View view = inflater.inflate(R.layout.fragmentb, container, false);
        if (view != null) {
            txtFragmentB = (TextView) view.findViewById(R.id.txtFragmentB);

            Bundle bundle = getArguments();
            if (bundle != null) {
                txtFragmentB.setTextSize(bundle.getInt(SIZE_KEY));
                txtFragmentB.setText(bundle.getString(TEXT_KEY));
            }
        }
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(TEXT_KEY, txtFragmentB.getText().toString());
        outState.putFloat(SIZE_KEY, txtFragmentB.getTextSize());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            txtFragmentB.setText(savedInstanceState.getString(TEXT_KEY));
            txtFragmentB.setTextSize(savedInstanceState.getFloat(SIZE_KEY) / displayMetrics.density);
        }
        super.onViewStateRestored(savedInstanceState);
    }
}
