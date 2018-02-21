package com.example.listasuperapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Created by niccolo on 05/06/2017.
 * Este es nuestro adaptador que nos permitirá llenar la lista con 
 * las entradas de la base de datos
 */

public class ItemAdapter extends BaseAdapter {

    private Context iContext;
    private LayoutInflater iInflater;
    private ArrayList<MyItem> iDataSource;

    public ItemAdapter(Context iContext,  ArrayList<MyItem> iDataSource)
    {
        this.iContext = iContext;

        this.iDataSource = iDataSource;
        iInflater = (LayoutInflater) iContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return iDataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return iDataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View rowView = iInflater.inflate(R.layout.empty_text_view, parent, false);
        //get Title element
        TextView titleTextView = (TextView) rowView.findViewById(R.id.item_list_title);
        //get subTitle element
        TextView subtitleTextView = (TextView) rowView.findViewById(R.id.item_list_subtitle);
        //get description element
        TextView description = (TextView) rowView.findViewById(R.id.item_list_detail);
        //get thumbnail element
        ImageView imageView = (ImageView) rowView.findViewById(R.id.item_list_thumbnail);

        MyItem item = (MyItem) getItem(position);

        titleTextView.setText(item.getName());
        subtitleTextView.setText(Integer.toString(item.getPrice()));
        description.setText(item.getName());

        /*A continuacion, mediente un if, cargamos cada lista con el estado del objeto (item), 
        si falta (rojo), si ya lo has comprado (verde) o volver a empezar (gris). */

        if(item.getEstado()==1){
            rowView.setBackgroundResource(R.color.colorFalta);
        }else if(item.getEstado()==2){
            rowView.setBackgroundResource(R.color.colorComprado);
        }else{
            rowView.setBackgroundResource(R.color.colorBackground);
        }

        /*Nuevamente utilizamos un if para el caso en que tenemos agregadas ofertas.
        Aqui cargamos la imagen que seleccionamos al crear la oferta*/

        if (item.getClassificacion().equals("OFFERTA"))
            imageView.setImageURI(Uri.parse(item.getImageUrl()));
        else
            imageView.setImageResource(Integer.parseInt(item.getImageUrl()));

        return rowView;
    }

}
