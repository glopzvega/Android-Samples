package com.desiteg.pasoparametrosintent;

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
		
		final EditText textInfo = (EditText) findViewById(R.id.editTextInfo);
		Button botonEnviar = (Button) findViewById(R.id.botonEnviar);
		
		botonEnviar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {				
				Intent intent = new Intent(MainActivity.this, SegundaActividad.class);
				intent.putExtra("informacion", textInfo.getText().toString());
				startActivity(intent);
			}
		});
		
	}
}
