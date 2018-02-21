package com.example.listasuperapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by niccolo on 03/06/2017.
 * Esta nuestra actividad principal de las listas.
 */

public class ListaActivity extends AppCompatActivity implements View.OnClickListener{

    //Llamado cuando se clica en el boton Ver Listas
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listas);

        /**Creacion botones y metodo OnClickListener, asi sabremos que lista se ha seleccionado*/
        Button b11 = (Button) findViewById(R.id.button11);
        b11.setOnClickListener(this);
        Button b12 = (Button) findViewById(R.id.button12);
        b12.setOnClickListener(this);
        Button b13 = (Button) findViewById(R.id.button13);
        b13.setOnClickListener(this);
        Button b14 = (Button) findViewById(R.id.button14);
        b14.setOnClickListener(this);




    }
    public void close(View view){
        finish();
    }

    @Override
    public void onClick(View v) {
        CharSequence text = null;

        switch (v.getId()){
            /**
             * Llamadas a cada boton.
             */

            case R.id.button11:
                Intent intent = new Intent(this, ListaView.class);
                Button txtMsg = (Button) findViewById(R.id.button11);
                // linea para ver el nombre del boton si se carga correctamente con el toast se muestra --> text = txtMsg.getText();
                //En la siguiente linia ponemos en el intent el nombre del boton que necesitamos en el ListaView.java
                //con un putExtra() y luegos iniciamos la actividad con el intent pasando la informacion extra.
                intent.putExtra("nombre_boton",txtMsg.getText());
                startActivity(intent);
                break;
            case R.id.button12:
                Intent intent2 = new Intent(this, ListaView.class);
                Button txtMsg2 = (Button) findViewById(R.id.button12);
                text = txtMsg2.getText();
                intent2.putExtra("nombre_boton",txtMsg2.getText());
                startActivity(intent2);
                break;

            case R.id.button13:
                Intent intent3 = new Intent(this, ListaView.class);
                Button txtMsg3 = (Button) findViewById(R.id.button13);
                text = txtMsg3.getText();
                intent3.putExtra("nombre_boton",txtMsg3.getText());
                startActivity(intent3);
                break;

            case R.id.button14:
                Intent intent4 = new Intent(this, ListaView.class);
                Button txtMsg4 = (Button) findViewById(R.id.button14);
                text = txtMsg4.getText();
                intent4.putExtra("nombre_boton",txtMsg4.getText());
                startActivity(intent4);
                break;


        }
        Context context = getApplicationContext();

        /*Cuando necesitamos testear que funciona correctamente utilizamos los toast 
        para ver la info por pantalla
        Toast toast = Toast.makeText(context, text,Toast.LENGTH_LONG);
        toast.show();*/


    }

    /**
     * Opciones de menu para el action bar, de forma que tengamos los botones
     * en el action bar para ir atras, home, cerrar la app, setting, etc.
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
