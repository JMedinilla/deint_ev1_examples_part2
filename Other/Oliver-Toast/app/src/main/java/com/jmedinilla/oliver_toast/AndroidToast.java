package com.jmedinilla.oliver_toast;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AndroidToast extends Activity {

    private Button btnDefecto = null;
    private Button btnGravity = null;
    private Button btnLayout = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btnDefecto = (Button)findViewById(R.id.btnPorDefecto);
        btnGravity = (Button)findViewById(R.id.btnGravity);
        btnLayout = (Button)findViewById(R.id.btnLayout);

        btnDefecto.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast toast1 =
                        Toast.makeText(getApplicationContext(), "Toast por defecto", Toast.LENGTH_SHORT);

                toast1.show();
            }
        });

        btnGravity.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast toast2 =
                        Toast.makeText(getApplicationContext(), "Toast con gravity", Toast.LENGTH_SHORT);

                toast2.setGravity(Gravity.CENTER|Gravity.LEFT,0,0);
                toast2.show();
            }
        });

        btnLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast toast3 = new Toast(getApplicationContext());

                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.toast_layout,
                        (ViewGroup) findViewById(R.id.lytLayout));

                TextView txtMsg = (TextView)layout.findViewById(R.id.txtMensaje);
                txtMsg.setText("Toast Personalizado");

                toast3.setDuration(Toast.LENGTH_SHORT);
                toast3.setView(layout);
                toast3.show();
            }
        });
    }
}