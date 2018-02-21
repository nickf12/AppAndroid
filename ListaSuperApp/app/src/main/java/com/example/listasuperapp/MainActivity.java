package com.example.listasuperapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.AlertDialog.Builder;

import android.view.View;
import android.widget.Button;

/*Esta es nuestra clase principal, aqui crearemos la base de datos si no existe
o si no existe la tabla la creamos*/

public class MainActivity extends Activity implements View.OnClickListener {

    /*Utilizamos la clase enum para crear objetos especificos como sera
    la clasificacion y los supermercados*/
    public enum classificacion {
        BEBIDA, ALIMGENERAL, FRESCOS, DROGUERIA, CONGELADOS
    }

    public enum supermercados {
        CAPRABO,
        MERCADONA,
        CARREFOUR,
        MERCADO,

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicial);


        /**
         * Creacion botones y metodo OnClickListener para darle vida a los botones
         */
        Button bNatalia = (Button) findViewById(R.id.button);
        bNatalia.setOnClickListener(this);
        Button bSandra = (Button) findViewById(R.id.button1);
        bSandra.setOnClickListener(this);

        /**
         * Creacion o apertura de la basse de datos
         */

        SQLiteDatabase db = openOrCreateDatabase("Items", Context.MODE_PRIVATE, null);

        //En caso de algun error utilizamos un drop table para borrar la tabla y crear una nueva
        //db.execSQL("DROP TABLE Item");
        db.execSQL("CREATE TABLE IF NOT EXISTS Item(name VARCHAR, classificacion VARCHAR, prezzo double, estado int, supermercado VARCHAR, description text, imageUrl VARCHAR);");
        Cursor c =  db.rawQuery("SELECT * FROM Item",null);

        //En caso de que la tabla este vacia, cargamos los siguientes productos predeterminados
        //por nuestra clienta. En caso contrario no se sustituyen
        if (c.getCount() == 0){
            inserTDb(db, "Papel higienico", classificacion.DROGUERIA.toString(), 2.50, 0, supermercados.CARREFOUR.toString(), "el mas suave", R.mipmap.toiletpaper+"");
            inserTDb(db, "cocaCola", classificacion.BEBIDA.toString(), 1, 1, supermercados.CARREFOUR.toString(), "", R.mipmap.cocacola+"");
            inserTDb(db, "pan", classificacion.ALIMGENERAL.toString(), 2, 1, supermercados.CARREFOUR.toString(), "", R.mipmap.bread+"");

            inserTDb(db, "Patatas", classificacion.CONGELADOS.toString(), 1, 0, supermercados.CAPRABO.toString(), "Patatas congeladas", R.mipmap.potatoes+"");
            inserTDb(db, "Agua", classificacion.BEBIDA.toString(), 1, 1, supermercados.CAPRABO.toString(), "Acqua fa bere il vino fa cantare! :)", R.mipmap.agua+"");
            inserTDb(db, "Queso", classificacion.FRESCOS.toString(), 1, 2, supermercados.CAPRABO.toString(), "", R.mipmap.cheese+"");
            inserTDb(db, "leche", classificacion.BEBIDA.toString(), 1, 0, supermercados.CAPRABO.toString(), "", R.mipmap.milk+"");

            inserTDb(db, "Vino", classificacion.BEBIDA.toString(), 1, 1, supermercados.MERCADONA.toString(), "", R.mipmap.wine+"");
            inserTDb(db, "Cafe", classificacion.ALIMGENERAL.toString(), 6, 2, supermercados.MERCADONA.toString(), "", R.mipmap.coffee+"");
            inserTDb(db, "Flan", classificacion.ALIMGENERAL.toString(), 1.35, 0, supermercados.MERCADONA.toString(), "Pack de 4", R.mipmap.flan+"");

            inserTDb(db, "Limon", classificacion.FRESCOS.toString(), 1, 0, supermercados.MERCADO.toString(), "", R.mipmap.lemon+"");
            inserTDb(db, "Carne", classificacion.FRESCOS.toString(), 6, 1, supermercados.MERCADO.toString(), "", R.mipmap.beef+"");
            inserTDb(db, "Fresas", classificacion.FRESCOS.toString(), 2.20, 2, supermercados.MERCADO.toString(), "1 kg", R.mipmap.fresa+"");
            inserTDb(db, "Manzanas", classificacion.FRESCOS.toString(), 1.10, 1, supermercados.MERCADO.toString(), "1 kg", R.mipmap.apple+"");
        }

            //Cerramos la tabla
            db.close();

    }


    public void showMessage(String title, String message) {
        Builder builder = new Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    /**
     * inserTDb nos sirve para insertar los items a la tabla
     */

    public void inserTDb(SQLiteDatabase db, String name, String tipo, double prezzo, int estado, String superM, String description, String imageRes) {

        db.execSQL("INSERT INTO Item VALUES('" + name + "','" + tipo +
                "','" + prezzo + "','" + estado + "','" + superM + "','" + description + "','" + imageRes + "');");
    }

    /**
     * El metodo onClick nos sirve para ejecutar alguna funcion cuando un boton es pulsado.
     */

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /** Llamado cuando se hace click en el button Sandra*/
            case R.id.button:
                Intent intent = new Intent(this, MainSandra.class);
                startActivity(intent);
                break;
            /** Llamado cuando se hace click en el button  Natalia*/
            case R.id.button1:
                Intent intent2 = new Intent(this, MainNatalia.class);
                startActivity(intent2);
                break;
        }

    }
}
