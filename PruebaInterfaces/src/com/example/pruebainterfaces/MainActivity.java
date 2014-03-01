package com.example.pruebainterfaces;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	Dialog activeDialog = null;
	Context context = MainActivity.this;	
	Thread hilo = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button dialogos = (Button) findViewById(R.id.btnDialogos);

		dialogos.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				mostrarDialogos(0);

			}
		});

		Button progress = (Button) findViewById(R.id.btnProgreso);

		progress.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				mostrarDialogos(1);

				hilo = new Thread() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						super.run();
						try {
							System.out.println("Hilo: " + hilo.isAlive());
							Thread.sleep(3000);
							System.out.println("Hilo: " + hilo.isAlive());
							handler.sendEmptyMessage(0);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				};

				hilo.start();

			}
		});
		
		Button edittext = (Button) findViewById(R.id.btnEdittext);
		
		edittext.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				mostrarDialogos(2);
				
			}
		});
	}
	
	private Handler handler = new Handler(){
		
		public void handleMessage(android.os.Message msg) {
		
			activeDialog.dismiss();						
			
		};
	};

	private void mostrarDialogos(int id) {

		System.out.println("LOL");				
		
		showDialog(id);

	}

	@Override
	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		AlertDialog.Builder builder = new Builder(MainActivity.this);
		
		switch (id) {
		case 0:			

			builder.setTitle("Dialogo de Alerta Simple")
					.setMessage("Esta es una prueba de dialogos")
					.setPositiveButton("OK",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									Toast.makeText(context, "Alerta Simple OK",
											Toast.LENGTH_SHORT).show();
								}
							});

			activeDialog = builder.create();
			
			break;

		case 1:

			activeDialog = ProgressDialog.show(context, "Dialogo de Progreso",
					"Cargando");

			break;
		
		case 2: 
			
			LayoutInflater inflater = LayoutInflater.from(context);
			
			View view = inflater.inflate(R.layout.custom_layout, null);
			
			builder.setTitle("Custom Layout Dialog").setView(view)
					.setPositiveButton("Entrar", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							
							EditText texto =  (EditText) activeDialog.findViewById(R.id.editTextPassword);							
							
							System.out.println("textp: " + activeDialog);
							
							Toast.makeText(context, "Password " + texto.getText().toString(), Toast.LENGTH_SHORT).show();
							
							if(true){
								mostrarDialogos(3);
							}
							
						}
					})
					.setNegativeButton("Cancelar", null);
			
			activeDialog = builder.create();
			
			break;
		
		case 3: 
			builder.setTitle("Password Incorrecta").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					mostrarDialogos(2);					
				}
			});
			
			activeDialog = builder.create();
			
			break;
		}				

		return activeDialog;
	}

	@Override
	protected void onPrepareDialog(int id, Dialog dialog) {
		// TODO Auto-generated method stub
		super.onPrepareDialog(id, dialog);
		
		activeDialog = dialog;
		
		
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
