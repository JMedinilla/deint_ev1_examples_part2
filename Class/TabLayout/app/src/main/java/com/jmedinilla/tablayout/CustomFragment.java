package com.jmedinilla.tablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CustomFragment extends Fragment {
    public static final String KEY_TEXT = "text";

    public static CustomFragment newInstance(Bundle args) {
        CustomFragment frg = new CustomFragment();
        if (args != null) {
            frg.setArguments(args);
        }
        return frg;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflamos la Vista que se debe mostrar en pantalla.
        View rootView = inflater.inflate(R.layout.fragment_layout, container,
                false);
        // Creamos instancia del TextView.
        TextView tvText =  (TextView)rootView.findViewById(R.id.tvText);
        // Recogemos el texto que guardamos al crear el Fragment.
        String text = getArguments().getString(KEY_TEXT);
        // Mostramos el texto en el TextView.
        tvText.setText(text);

        // Devolvemos la vista para que se muestre en pantalla.
        return rootView;
    }
}
