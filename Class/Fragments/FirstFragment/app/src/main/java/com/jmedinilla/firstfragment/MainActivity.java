package com.jmedinilla.firstfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentA.FragmentAListener {

    private FragmentB fragmentB;
    private FragmentC fragmentC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentB = (FragmentB)getFragmentManager().findFragmentById(R.id.fragmentb);
    }

    @Override
    public void onFragmentIterationListener(int position, String text) {
        fragmentB.changeTextProperties(position, text);
    }
}
