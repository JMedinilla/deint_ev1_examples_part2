package com.jmedinilla.oliver_listview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lourdes on 5/11/16.
 */

public class Titular_Adapter extends ArrayAdapter<Titular>{

    private Context context;

    public Titular_Adapter(Context context) {
        super(context, R.layout.listitem_titular);
        this.context = context;

        for (int i = 1; i <= 25; i++)
            add(new Titular("Título " + i, "Subtítulo largo " + i));
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View item = convertView;
        Titular_ListView.ViewHolder holder;

        if (item == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            item = inflater.inflate(R.layout.listitem_titular, null);

            holder = new Titular_ListView.ViewHolder();
            holder.titulo = (TextView) item.findViewById(R.id.LblTitulo);
            holder.subtitulo = (TextView) item
                    .findViewById(R.id.LblSubTitulo);

            item.setTag(holder);
        } else {
            holder = (Titular_ListView.ViewHolder) item.getTag();
        }

        holder.titulo.setText(getItem(position).getTitulo());
        holder.subtitulo.setText(getItem(position).getSubtitulo());

        return (item);
    }
}

