package com.example.uxpickerdialog;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;


public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener, DatePicker.OnDateChangedListener{

	private boolean fired = false;
	
	DateSetListener dateSetListener;
	
	public void setDateSetListener(DateSetListener dateSetListener) {
		this.dateSetListener = dateSetListener;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		final Calendar c = Calendar.getInstance();
	    int year = c.get(Calendar.YEAR);
	    int month = c.get(Calendar.MONTH);
	    int day = c.get(Calendar.DAY_OF_MONTH);
	    
	    DatePickerDialog picker = new DatePickerDialog(getActivity(), this, year, month, day);
	    picker.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancelar", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {								
			}
			
		});
	    
	    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
		    final Calendar min = Calendar.getInstance();
		    min.set(2012, 0, 1);	    
		    long timeMin = min.getTimeInMillis();
		    
		    final Calendar max = Calendar.getInstance();
		    max.set(year, 11, 31);	    
		    long timeMax = max.getTimeInMillis();
		    
		    picker.getDatePicker().setMinDate(timeMin);
		    picker.getDatePicker().setMaxDate(timeMax);	    
	    }
	    
	    return picker;
	}
	
	@Override
	public void onDateSet(DatePicker view, int year, int monthOfYear,
			int dayOfMonth) {
		if(fired)			
			dateSetListener.OnDateDefined(year, monthOfYear, dayOfMonth);
		fired = true;
	}
	
	
	
	public interface DateSetListener{
		public void OnDateDefined(int year, int monthOfYear, int dayOfMonth);
	}



	@Override
	public void onDateChanged(DatePicker view, int year, int monthOfYear,
			int dayOfMonth) {
		System.out.println("LOL");
	}
	
	

}
