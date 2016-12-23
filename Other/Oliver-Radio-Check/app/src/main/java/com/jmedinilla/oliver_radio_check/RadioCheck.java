package com.jmedinilla.oliver_radio_check;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RadioCheck extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final CheckBox cb = (CheckBox) findViewById(R.id.ChkMarcame);

        cb.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                if (isChecked) {
                    cb.setText("Checkbox marcado!");
                } else {
                    cb.setText("Checkbox desmarcado!");
                }
            }
        });

        final TextView lblMensaje = (TextView) findViewById(R.id.LblSeleccion);
        final RadioGroup rg = (RadioGroup) findViewById(R.id.gruporb);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                lblMensaje.setText("ID opción seleccionada: " + checkedId);
            }
        });
    }
}