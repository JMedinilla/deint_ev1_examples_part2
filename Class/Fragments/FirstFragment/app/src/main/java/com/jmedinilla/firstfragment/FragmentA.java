package com.jmedinilla.firstfragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;

public class FragmentA extends Fragment {
    private static int seekvalue = 10;
    private EditText edtFragmentA;
    private FragmentAListener activityCallback;

    public interface FragmentAListener {
        void onFragmentIterationListener(int position, String text);
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
        SeekBar skbFragmentA = (SeekBar) view.findViewById(R.id.skbFragmentA);

        edtFragmentA.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                activityCallback.onFragmentIterationListener(seekvalue, edtFragmentA.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        skbFragmentA.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekvalue = i;
                activityCallback.onFragmentIterationListener(seekvalue, edtFragmentA.getText().toString());
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
