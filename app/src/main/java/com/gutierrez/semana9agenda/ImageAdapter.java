package com.gutierrez.semana9agenda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {
    Context context;
    ArrayList<Celulares> datosCelularesArrayList;
    LayoutInflater layoutInflater;
    Celulares misCelulares;

    public ImageAdapter(Context context, ArrayList<Celulares> datosCelularesArrayList) {
        this.context = context;
        this.datosCelularesArrayList = datosCelularesArrayList;
    }
    @Override
    public int getCount() {
        return datosCelularesArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return datosCelularesArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return Long.parseLong(datosCelularesArrayList.get(i).getIdCelular());
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View Visor = layoutInflater.inflate(R.layout.activity_list_view_image,viewGroup,false);
        TextView temp = Visor.findViewById(R.id.lblGama);

        try {
            misCelulares = datosCelularesArrayList.get(i);
            temp.setText(misCelulares.getGama());

            temp = Visor.findViewById(R.id.lblMarca);
            temp.setText("Marca: " + misCelulares.getMarca());

            temp = Visor.findViewById(R.id.lblModelo);
            temp.setText("Modelo: " + misCelulares.getModelo());

            temp = Visor.findViewById(R.id.lblPrecio);
            temp.setText("Precio: " + misCelulares.getPrecio());

            temp = Visor.findViewById(R.id.lblVenta);
            temp.setText("Venta: " + misCelulares.getFecha_venta());


        }catch (Exception e){
            mensajeToast(e.getMessage());
        }

        return Visor;
    }

    private void mensajeToast(String msg){
        Toast.makeText(context.getApplicationContext(),msg, Toast.LENGTH_LONG).show();
    }
}
