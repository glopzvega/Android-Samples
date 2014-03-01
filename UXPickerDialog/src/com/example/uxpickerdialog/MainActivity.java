package com.example.uxpickerdialog;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.uxpickerdialog.DatePickerFragment.DateSetListener;

public class MainActivity extends FragmentActivity implements DateSetListener{

	String [] months;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		months  = getResources().getStringArray(R.array.months);
		
		Button b = (Button) findViewById(R.id.button1);
		
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				showDatePickerDialog(v);				
			}
		});
		
	}
	
	public void showDatePickerDialog(View v) {
		DatePickerFragment newFragment = new DatePickerFragment();
	    newFragment.setDateSetListener(this);
	    newFragment.show(getSupportFragmentManager(), "datePicker");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void OnDateDefined(int year, int monthOfYear, int dayOfMonth) {
		
		Toast.makeText(this, "Fecha " + year + "-0" + (monthOfYear + 1) + "-0" + dayOfMonth, Toast.LENGTH_SHORT).show();
		
		
//		Toast.makeText(this, "año: " + year + " mes: " + monthOfYear + " dia: " + dayOfMonth,  Toast.LENGTH_SHORT).show();
		
		
	}
	

}
