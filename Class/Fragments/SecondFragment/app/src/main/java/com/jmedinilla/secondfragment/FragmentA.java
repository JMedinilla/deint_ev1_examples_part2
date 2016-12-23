package com.jmedinilla.secondfragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

public class FragmentA extends Fragment {
    private static int seekvalue = 10;
    private EditText edtFragmentA;
    private Button btnFragmentA;
    private FragmentAListener activityCallback;
    public static final String TAG_FRAGMENTA = "fragmentATag";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public interface FragmentAListener {
        void onFragmentIterationListener(int size, String text);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activityCallback = (FragmentAListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmenta, container, false);

        edtFragmentA = (EditText) view.findViewById(R.id.edtFragmentA);
        btnFragmentA = (Button) view.findViewById(R.id.btnFragmentA);
        SeekBar skbFragmentA = (SeekBar) view.findViewById(R.id.skbFragmentA);
        skbFragmentA.setProgress(seekvalue);

        btnFragmentA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityCallback.onFragmentIterationListener(seekvalue, edtFragmentA.getText().toString());
            }
        });

        skbFragmentA.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekvalue = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        return view;
    }
}
