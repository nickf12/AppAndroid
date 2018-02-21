package com.example.listasuperapp;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by niccolo on 30/05/2017.
 * En este apartado es la vista de las lista
 * aqui cargamos los productos segun el boton seleccionado
 * en el ListaActivity.java
 */

public class ListaView extends AppCompatActivity{
    int estado;
    CharSequence text = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_view);
        final ListView lista = (ListView) findViewById(R.id.listView);
        lista.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        //Utilizamos el nombre del boton para saber que productos cargar
        //En la siguiente  linea tomamos el string con getIntent()

        String recuperamos_nombre_boton = getIntent().getStringExtra("nombre_boton");

        /**
         * Cursor para movernos dentro de la Tabla y seleccionar los productos de la lista
         */
        final SQLiteDatabase db = openOrCreateDatabase("Items",Context.MODE_PRIVATE, null);
        Cursor c = db.rawQuery("SELECT * FROM Item where supermercado='"+recuperamos_nombre_boton+"'", null);
        final ArrayList<MyItem> itemList= new ArrayList<>(c.getCount());
        while(c.moveToNext())
        {
            String name = c.getString(0);
            String classificacion = c.getString(1);
            int price = c.getInt(2);
            estado = c.getInt(3);
            String superM = c.getString(4);
            String description = c.getString(5);
            String imageRes = c.getString(6);
            itemList.add(new MyItem(name, classificacion, price, estado, superM, description, imageRes));
        }


        ItemAdapter adapter = new ItemAdapter(this, itemList);
        lista.setAdapter(adapter);

        /**
         * Para destacar si nos falta un producto o no, hacemos que el listview sea clicable y asi
         * segun las veces que lo toquemos cambia el color del fondo del producto. Rojo falta, verde comprado, blanco no hace falta.
         */
        lista.setClickable(true);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyItem elegido = (MyItem) parent.getItemAtPosition(position);
                String name = elegido.getName();
                //Aviso de cual producto/item he seleccionado
                //Toast.makeText(getApplicationContext(),elegido.getName(),Toast.LENGTH_LONG).show();
                if(estado==0){
                    estado++;
                    lista.getChildAt(position).setBackgroundResource(R.color.colorFalta);
                    db.execSQL("UPDATE Item SET estado="+estado+" WHERE name='"+name+"';");

                }else if(estado==1){
                    estado++;
                    lista.getChildAt(position).setBackgroundResource(R.color.colorComprado);
                    db.execSQL("UPDATE Item SET estado="+estado+" WHERE name='"+name+"';");
                }else {
                    estado=0;
                    lista.getChildAt(position).setBackgroundResource(R.color.colorBackground);
                    db.execSQL("UPDATE Item SET estado="+estado+" WHERE name='"+name+"';");
                }


            }


        });

    }
    public void close(View view){
        finish();
    }

    /**
     * Opciones de menu para el action bar, de forma que tengamos los botones
     * en el action bar para ir atras, home, cerrar la app, setting, etc.
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_lista_super, menu);
        return true;
    }
    /*
     * Con onOptionsItemSelected podemos obtener que boton de la action bar ha sido seleccionado
     * y ejecutar la accion adecuada, atras, inicio, etc.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            /** Llamado cuando se hace click en el button atras*/
            case R.id.back:
                Intent intent = new Intent(this, ListaActivity.class);
                startActivity(intent);
                break;
            /** Llamado cuando se hace click en el button home*/
            case R.id.home:
                Intent intent2 = new Intent(this, MainActivity.class);
                startActivity(intent2);
                break;
            case R.id.action_settings:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
