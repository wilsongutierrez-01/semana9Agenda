package com.gutierrez.semana9agenda;

public class Celulares {
    String idCelular;
    String Gama;
    String Marca;
    String Modelo;
    String Precio;
    String Fecha_venta;

    public Celulares(String idCelular, String gama, String marca, String modelo, String precio, String fecha_venta) {
        this.idCelular = idCelular;
        this.Gama = gama;
        this.Marca = marca;
        this.Modelo = modelo;
        this.Precio = precio;
        this.Fecha_venta = fecha_venta;
    }

    public String getIdCelular() {
        return idCelular;
    }
    public void setIdCelular(String idCelular) {
        this.idCelular = idCelular;
    }

    public String getGama() {
        return Gama;
    }
    public void setGama(String gama) {
        Gama = gama;
    }

    public String getMarca() {
        return Marca;
    }
    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }
    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public String getPrecio(){
        return Precio;
    }
    public void setPrecio(String precio){
        Precio = precio;
    }

    public String getFecha_venta(){
        return Fecha_venta;
    }
    public void setFecha_venta(String venta){
        Fecha_venta = venta;
    }
}
