package com.desiteg.listacomprascantidades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final EditText producto = (EditText) findViewById(R.id.editTextProducto);
		final EditText cantidad = (EditText) findViewById(R.id.editTextCantidad);
		Button botonAgregar = (Button) findViewById(R.id.botonAgregar);
		
		botonAgregar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {				
				Intent intento = new Intent(MainActivity.this, ListaCompras.class);
				intento.putExtra("producto", producto.getText().toString() + "," + cantidad.getText().toString());
				startActivity(intento);
			}
		});
		
	}


}
