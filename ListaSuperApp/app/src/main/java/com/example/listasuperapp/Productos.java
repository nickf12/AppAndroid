package com.example.listasuperapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Productos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        /*Para finalizar la implementacion de la activity_productos, deberiamos
        cargar los productos segun su clasificacion para que fueran mas facil de encontrar.
        Aqui seria un buen punto tambien para la creacion de productos, pero no es algo que se nos
        pide.
         */

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
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            /** Llamado cuando se hace click en el button atras*/
            case R.id.back:
                Intent intent = new Intent(this, MainSandra.class);
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
