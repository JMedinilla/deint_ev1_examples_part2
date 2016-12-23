package com.jmedinilla.oliver_listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Titular_ListView extends Activity {

    private ArrayList<Titular> arrayTitular;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        Titular_Adapter adapter = new Titular_Adapter(this);

        ListView lstOpciones = (ListView) findViewById(R.id.LstOpciones);

        lstOpciones.setAdapter(adapter);
        lstOpciones.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                textIconToast(((Titular)adapterView.getItemAtPosition(i)).getTitulo(), R.drawable.icon,
                        Toast.LENGTH_SHORT);
            }
        });


    }

	/*
     * Método que muestra un mensaje
	 */

    @SuppressWarnings("unused")
    private void textOnlyToast(String message, int duration) {
        Toast toast = Toast
                .makeText(getApplicationContext(), message, duration);
        toast.show();
    }

    /*
     * Método que muestra un mensaje con un icono, creando componentes en tiempo
     * de ejecución
     */
    private void textIconToast(String message, int icon, int duration) {
        Toast toast = Toast
                .makeText(getApplicationContext(), message, duration);
        View textView = toast.getView();
        LinearLayout lay = new LinearLayout(getApplicationContext());
        lay.setOrientation(LinearLayout.HORIZONTAL);
        ImageView view = new ImageView(getApplicationContext());
        view.setImageResource(R.drawable.ic_item);
        lay.addView(view);
        lay.addView(textView);
        toast.setView(lay);
        toast.show();
    }

    static class ViewHolder {
        TextView titulo;
        TextView subtitulo;
    }


}
