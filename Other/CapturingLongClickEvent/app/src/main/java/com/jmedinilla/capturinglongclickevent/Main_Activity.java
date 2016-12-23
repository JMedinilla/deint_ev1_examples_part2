package com.jmedinilla.capturinglongclickevent;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

public class Main_Activity extends FragmentActivity implements ResetDialogFragment.OnResetDialogListener, Main_Fragment.LongClickListener {

    private Main_Fragment fragment;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        if (savedInstanceState == null) {
            fragment = new Main_Fragment();
            getFragmentManager().beginTransaction().add(R.id.fragment_container,fragment,"fragmentb").commit();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.long_click, menu);
        return true;
    }

    public void onPossitiveButtonClick() {
        fragment.resetCont();
    }

    public void onLongButtonClick() {

        new ResetDialogFragment().show(getFragmentManager(), "ResetDialogFragment");
    }
}
