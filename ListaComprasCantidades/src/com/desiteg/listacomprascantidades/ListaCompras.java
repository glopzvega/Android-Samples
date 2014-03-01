package com.desiteg.listacomprascantidades;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaCompras extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_compras);
		
		ListView lista = (ListView) findViewById(R.id.listaProductos);
		ArrayList<String> productos = new ArrayList<String>();
		
		productos.add("Producto x 1");
		productos.add("Producto x 2");
		productos.add("Producto x 3");
		
		String producto = getIntent().getExtras().getString("producto");		
		productos.add(producto.split(",")[0] + " x " + producto.split(",")[1]);		
		
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, productos);
		lista.setAdapter(adaptador);
		
	}
}
