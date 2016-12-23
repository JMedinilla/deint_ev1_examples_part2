package com.jmedinilla.secondfragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentA.FragmentAListener {

    FragmentTransaction fragmentTransaction;
    private FragmentA fragmentA;
    private FragmentB fragmentB;
    private FragmentC fragmentC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();
        fragmentA = (FragmentA)fragmentManager.findFragmentByTag(FragmentA.TAG_FRAGMENTA);

        if(fragmentA == null){
            fragmentA = new FragmentA();
            getFragmentManager().beginTransaction().add(R.id.activity_main, fragmentA, FragmentA.TAG_FRAGMENTA).commit();
        }
    }

    @Override
    public void onFragmentIterationListener(int size, String text) {
        Bundle bundle = new Bundle();
        bundle.putString(FragmentB.TEXT_KEY, text);
        bundle.putInt(FragmentB.SIZE_KEY, size);
        fragmentB = FragmentB.newInstance(bundle);

        //Se empieza la transacción de un Fragment al otro

        fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_main, fragmentB);
        //Se debe guardar la transacción en la pila antes de hacer commit
        fragmentTransaction.addToBackStack("fragmentB");
        fragmentTransaction.commit();
    }
}
