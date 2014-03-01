package mx.com.gm.dialogosandroid;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import ejemplo.FireMissilesDialogFragment;
import ejemplo.FireMissilesDialogFragment.FireMissilesDialogListener;

public class MainActivity extends Activity implements FireMissilesDialogListener{	
	
	@Override
	public void OnDialogPositiveClick(FireMissilesDialogFragment obj) {
		
		EditText editTextPass = (EditText) obj.getDialog().findViewById(R.id.DialogPassword);
		String pass = editTextPass.getText().toString();
		Toast.makeText(MainActivity.this, pass, Toast.LENGTH_SHORT).show();				
	}

	@Override
	public void OnDialogNegativeClick(FireMissilesDialogFragment obj) {
		mostrarDialogo();		
	}	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
		
		Button b2 = (Button) findViewById(R.id.button2);
	
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				mostrarDialogo();										
			}
		});
	}	

	private void mostrarDialogo (){
		DialogFragment fire = new FireMissilesDialogFragment();
		fire.show(getFragmentManager(), "dialogo");	
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}		

}
