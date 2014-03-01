package com.dg.manejomenus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TextView manejo_menus = (TextView) findViewById(R.id.manejo_menus);
		
		registerForContextMenu(manejo_menus);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {		
		super.onCreateContextMenu(menu, v, menuInfo);
		
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_contextual, menu);
		
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		
		switch(item.getItemId()){
		
		case R.id.copiar:
			Toast.makeText(MainActivity.this, "Copiar Seleccionado", Toast.LENGTH_LONG).show();
			break;
			
		case R.id.pegar:
			Toast.makeText(MainActivity.this, "Pegar Seleccionado", Toast.LENGTH_LONG).show();
			break;
			
		case R.id.cortar:
			Toast.makeText(MainActivity.this, "Cortar Seleccionado", Toast.LENGTH_LONG).show();
			break;		
		}
		
		return super.onContextItemSelected(item);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {		
		getMenuInflater().inflate(R.menu.main, menu);
		return true;				
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		Intent intent = null;
		
		switch(item.getItemId()){
		
		case R.id.version:
			intent  = new Intent(MainActivity.this,  AyudaActivity.class);
			startActivity(intent);
			break;
			
		case R.id.contenidoAyuda:
			Toast.makeText(MainActivity.this,  "Opción Contenido Ayuda Seleccionada",  Toast.LENGTH_LONG).show();
			break;
			
		case R.id.configuracion:
			intent = new Intent(MainActivity.this, ConfiguracionActivity.class);
			startActivity(intent);
			break;		
		}		
		
		return super.onOptionsItemSelected(item);
	}

}
