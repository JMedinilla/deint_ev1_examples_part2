package com.jmedinilla.capturinglongclickevent;

import android.app.Activity;
import android.app.Fragment;
import android.app.usage.UsageEvents;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main_Fragment extends Fragment {
    private int cont = 0;
    private TextView tvCont;
    private LinearLayout btnIncrementar;
    private ResetDialogFragment resetDialogFragment;

    private LongClickListener listener;

    public interface LongClickListener {
        void onLongButtonClick();// Eventos de la pulsación larga

    }

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (LongClickListener) activity;

        } catch (ClassCastException e) {
            throw new ClassCastException(
                    activity.toString() +
                            " no implementó OnSimpleDialogListener");

        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_layout,container,false);
        tvCont = (TextView)view.findViewById(R.id.mensaje_mantener);
        btnIncrementar=(LinearLayout)view.findViewById(R.id.btn_Pulsar);
        btnIncrementar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                update_cont();
            }

        });
        btnIncrementar.setOnLongClickListener(new View.OnLongClickListener() {

            public boolean onLongClick(View v) {
                // TODO Auto-generated method stub;
                listener.onLongButtonClick();
                return true;
            }

        });
        return view;
    }


    private void update_cont() {
        cont++;
        String contador = String.valueOf(cont);
        tvCont.setText(contador);
    }


    public void resetCont() {
        this.cont = 0;
        String contador = String.valueOf(cont);
        tvCont.setText(contador);
    }


}
