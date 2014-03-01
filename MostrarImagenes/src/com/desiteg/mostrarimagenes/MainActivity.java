package com.desiteg.mostrarimagenes;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ImageView  imagen = (ImageView)  findViewById(R.id.imageViewCapturada);
		imagen.setImageURI((Uri)  getIntent().getExtras().get(Intent.EXTRA_STREAM));
	}	

}
