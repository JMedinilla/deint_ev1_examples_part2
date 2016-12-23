package com.jmedinilla.buttonresponseevent;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                switch (v.getId()) {
                    case R.id.btnResponse:
                        final Snackbar snackbar = Snackbar.make(v, "Mensaje con Action", Snackbar.LENGTH_INDEFINITE);

                        View view = snackbar.getView();
                        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) view.getLayoutParams();
                        params.gravity = Gravity.TOP;
                        view.setLayoutParams(params);

                        snackbar.setAction("OK", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                snackbar.dismiss();
                            }
                        });
                        snackbar.show();
                        break;
                }
                return true;
            }
        };

        Button btnResponse = (Button) findViewById(R.id.btnResponse);

        btnResponse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Se ha pulsado el botón", Snackbar.LENGTH_SHORT).show();
            }
        });

        btnResponse.setOnLongClickListener(onLongClickListener);
    }
}
