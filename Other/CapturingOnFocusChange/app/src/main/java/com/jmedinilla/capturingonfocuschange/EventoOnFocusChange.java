package com.jmedinilla.capturingonfocuschange;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

public class EventoOnFocusChange extends Activity implements
        OnFocusChangeListener {

    private EditText nombre, apellidos;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.focus_event);
        nombre = (EditText) findViewById(R.id.nombre);
        apellidos = (EditText) findViewById(R.id.apellidos);
        nombre.setOnFocusChangeListener(this);
        apellidos.setOnFocusChangeListener(this);
        nombre.requestFocus();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.focus_event, menu);
        return true;
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {

        if (hasFocus == true && v instanceof EditText) {
            v.setBackgroundColor(Color.rgb(255, 165, 0));
        } else {
            v.setBackgroundColor(Color.GRAY);
        }

    }
}
