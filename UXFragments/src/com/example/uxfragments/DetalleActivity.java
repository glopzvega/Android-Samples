package com.example.uxfragments;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

public class DetalleActivity extends FragmentActivity{

	public static final String EXTRA_TEXTO = "com.example.uxfragments.FragmentDetalle";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalle);
		
		FragmentDetalle detalle = (FragmentDetalle) getSupportFragmentManager().findFragmentById(R.id.FrgDetalle);
		
		Toast.makeText(this, getIntent().getStringExtra(EXTRA_TEXTO), Toast.LENGTH_SHORT).show();
		
		detalle.mostrarDetalle(getIntent().getStringExtra(EXTRA_TEXTO));		
	}
}
