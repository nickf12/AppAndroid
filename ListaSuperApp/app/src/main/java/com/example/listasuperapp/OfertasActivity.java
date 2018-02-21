package com.example.listasuperapp;


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase OfertasActivity carga la actividad add_ofertas, que permitira al usuario
 * crear sus propias ofertas, agregando una imagen, nombre y el supermercado al que pertenece
 */


public class OfertasActivity extends AppCompatActivity implements View.OnClickListener
{
    private static final int PICK_IMAGE = 1;
    private String imageUri = "";
    private String name = "";
    private ImageView iView;
    private String superM = "";
    private Spinner sp1;
    EditText editT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_ofertas);
        final Button bElegir = (Button) findViewById(R.id.button7);
        bElegir.setEnabled(false);

        int cnt = 0;
        final List<String> list=new ArrayList<String>();
        for(MainActivity.supermercados s: MainActivity.supermercados.values())
        {
            if(s.toString().equals("FIRST")) list.add(cnt, "      ");
            else
            {
                list.add(cnt, s.toString());
                cnt++;
            }
        }
        //Con el spinner cargamos un array con los supermercados definidos
        sp1= (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adp=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,list);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adp);
        editT = (EditText) findViewById(R.id.editText);
        iView = (ImageView)findViewById(R.id.imageView7);
        iView.setImageResource(R.mipmap.icono_carrito);
        editT.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.equals("") )
                    name = s.toString();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,int position, long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(getBaseContext(), list.get(position), Toast.LENGTH_SHORT).show();
                superM = list.get(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                bElegir.setText("Elegir super");
            }
        });

    }

    public void close(View view){
        finish();
    }

    @Override
    public void onClick(View v)
    {

        Button b = (Button)v;

        Button bElegir = (Button) findViewById(R.id.button7);
        //String description = editT.getText().toString();
        String buttonText = b.getText().toString();
        if(buttonText.equals("Añadir"))
        {
            //Abrimos la base de datos y guardamos la nueva oferta con su imagen
            SQLiteDatabase db = openOrCreateDatabase("Items", Context.MODE_PRIVATE, null);
            inserTDb(db, name, "OFFERTA", 1.0,0, superM,"my offerta",  imageUri);

            editT.setText("add name", TextView.BufferType.EDITABLE);
            iView.setImageResource(R.mipmap.icono_carrito);
            bElegir.setText("Elegir Supermercado");
            imageUri = "";
            superM = "";
            name = "";
            db.close();
        }
        else if(buttonText.equals("Cancelar"))
        {
            //Al cancelar limpiamos el texto que se modifico y la imagen que se selecciono
            // y ponemos las que son por defecto
            editT.setText("Nombre", TextView.BufferType.EDITABLE);
            iView.setImageResource(R.mipmap.icono_carrito);
            bElegir.setText("Elegir Supermercado");
            imageUri = "";
            superM = "";
            name = "";
        }
        else if(buttonText.equals("Añadir foto"))
        {
            //Aqui seleccionamos la imagen/foto de la oferta de nuestra galeria
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        ImageView iView = (ImageView)findViewById(R.id.imageView7);

        switch(requestCode)
        {
            case PICK_IMAGE:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    iView.setImageURI(selectedImage);
                    imageUri = selectedImage.toString();
                }
        }
    }

    public void inserTDb(SQLiteDatabase db, String name, String tipo, double prezzo, int estado, String superM, String description, String imageRes) {

        db.execSQL("INSERT INTO Item VALUES('" + name + "','" + tipo +
                "','" + prezzo + "','" + estado + "','" + superM + "','" + description + "','" + imageRes + "');");
    }

    public Cursor getData(SQLiteDatabase db)
    {
        Cursor c = db.rawQuery("SELECT * FROM Item where supermercado='"+superM+"'", null);
        return c;

    }
    public void showMessage(String title, String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}

