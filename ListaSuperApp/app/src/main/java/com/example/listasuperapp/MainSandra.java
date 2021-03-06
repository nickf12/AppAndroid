package com.example.listasuperapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
/**
 * La clase MainSandra carga la actividad main_sandra.xml que nos permitara realizar solo
 * las acciones dadas al perfil de sandra, este perfil esta personalizado con la foto del 
 * usuario
 */

public class MainSandra extends AppCompatActivity  implements OnClickListener{
    /**Llamado cuando se clica en el boton sandra*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_sandra);

        /**Creacion botones y metodo OnClickListener*/
        Button bCLista = (Button) findViewById(R.id.button2);
        bCLista.setOnClickListener(this);
        Button bLista = (Button) findViewById(R.id.button3);
        bLista.setOnClickListener(this);
        Button bOfertas = (Button) findViewById(R.id.button4);
        bOfertas.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            /** Llamado cuando se hace click en el button crear lista*/
            case R.id.button2:
                Intent intent3 = new Intent(this,Productos.class);
                startActivity(intent3);
                break;
            /** Llamado cuando se hace click en el button ver listas*/
            case R.id.button3:
                Intent intent = new Intent(this, ListaActivity.class);
                startActivity(intent);
                break;
            /** Llamado cuando se hace click en el button crear ofertas*/
            case R.id.button4:
                Intent intent2 = new Intent(this, OfertasActivity.class);
                startActivity(intent2);
                break;

        }

    }


    /**
     * Opciones de menu para el action bar, de forma que tengamos los botones
     * en el action bar para ir atras, home, cerrar la app, setting, etc.
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_users, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
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
