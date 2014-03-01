package com.desiteg.pasoparametrosintent;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaActividad extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_segunda_actividad);
		
		TextView textViewInfo = (TextView) findViewById(R.id.textViewInformacion);
		textViewInfo.setText(getIntent().getExtras().getString("informacion"));
	}	
}
