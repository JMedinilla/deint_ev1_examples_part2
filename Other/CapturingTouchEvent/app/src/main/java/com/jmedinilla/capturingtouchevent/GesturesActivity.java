package com.jmedinilla.capturingtouchevent;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Este ejemplo muestra como el textView como su ViewGroup recogen el evento simultáneamente.
 * Cambiar el valor true a false y se comprueba como únicamente se consume el primer evento pero
 * no los sucesivos al primer evento.
 */
public class GesturesActivity extends Activity {

    public static final String DEBUG_TAG = "GesturesActivity";
    private TextView tvTexto;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestures);

        relativeLayout = (RelativeLayout) findViewById(R.id.activity_gestures);
        relativeLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //Anular los callback de los hijos
                ((RelativeLayout) v).requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        tvTexto = (TextView) findViewById(R.id.tvText);
        tvTexto.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                int action = MotionEventCompat.getActionMasked(event);

                switch (action) {
                    case (MotionEvent.ACTION_DOWN):
                        Log.d(DEBUG_TAG, "La accion ha sido ABAJO");
                        return true;
                    case (MotionEvent.ACTION_MOVE):
                        Log.d(DEBUG_TAG, "La acción ha sido MOVER");
                        return true;
                    case (MotionEvent.ACTION_UP):
                        Log.d(DEBUG_TAG, "La acción ha sido ARRIBA");
                        return true;
                    case (MotionEvent.ACTION_CANCEL):
                        Log.d(DEBUG_TAG, "La accion ha sido CANCEL");
                        return true;
                    case (MotionEvent.ACTION_OUTSIDE):
                        Log.d(DEBUG_TAG, "La accion ha sido fuera del elemento de la pantalla");
                        return true;
                    default:
                        return true;
                }
            }
        });
    }

    /*
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        super.dispatchTouchEvent(ev);
        return true;
    }
    */
}
