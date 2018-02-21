package com.example.listasuperapp;

/**
 * Created by niccolo on 04/06/2017.
 * Esta clase nos permitira manejar de una forma muy practica la tabla de la base de datos
 */

public class MyItem
{
    private String name;
    private String description;
    private String imageRes;
    private int price;
    private int estado;
    private String superM;
    private String classificacion;
    public MyItem()
    {
        super();
    }
    public MyItem(String name, String classificacion,int price, int estado, String superM, String description, String imageRes)
    {
        this.name = name;
        this.description = description;
        this.imageRes = imageRes;
        this.price = price;
        this.estado = estado;
        this.classificacion = classificacion;
        this.superM = superM;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setSuperM(String superM){ this.superM = superM;}
    public void setClassificacion(String classificacion){ this.classificacion = classificacion;}
    public void setDescription(String description)
    {
        this.description = description;
    }
    public void setImageUrl(String imageRes)
    {
        this.imageRes = imageRes;
    }
    public void setPrice(int price)
    {
        this.price = price;
    }
    public void setEstado(int set){ this.estado =estado;}
    public String getName()
    {
        return name;
    }
    public String getImageUrl()
    {
        return imageRes;
    }
    public String getDescription()
    {
        return description;
    }
    public int getPrice()
    {
        return price;
    }
    public int getEstado(){return estado;}
    public String getClassificacion() { return classificacion;}

    public String getSuperM() {
        return superM;
    }
}
