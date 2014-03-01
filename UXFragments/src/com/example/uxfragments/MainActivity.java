package com.example.uxfragments;

import com.example.uxfragments.FragmentListado.CorreosListener;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

public class MainActivity extends FragmentActivity implements CorreosListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		FragmentListado frgListado = (FragmentListado) getSupportFragmentManager().findFragmentById(R.id.FrgListado);
		frgListado.setCorreosListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void OnCorreoSeleccionado(Correo correo) {
		boolean hayDetalle = (getSupportFragmentManager().findFragmentById(R.id.FrgDetalle) != null);
		
		System.out.println(hayDetalle);
		
		if(hayDetalle){
			((FragmentDetalle) getSupportFragmentManager().findFragmentById(R.id.FrgDetalle)).mostrarDetalle(correo.getTexto());
		}
		else
		{
			Intent i = new Intent(this, DetalleActivity.class);
			System.out.println("txt: " + correo.getTexto());
			i.putExtra(DetalleActivity.EXTRA_TEXTO, correo.getTexto());
			startActivity(i);
		}
		
	}

}
