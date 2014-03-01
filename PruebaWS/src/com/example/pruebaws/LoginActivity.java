package com.example.pruebaws;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		SharedPreferences preferencias = getSharedPreferences("PREFERENCIAS",
				Context.MODE_PRIVATE);

		String login = preferencias.getString("login", "");

		if (!login.equals("")) {
			sendToMainIntent();
		} else {
			Button botonLogin = (Button) findViewById(R.id.btnLogin);

			botonLogin.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {

					CheckBox recordar = (CheckBox) findViewById(R.id.checkBoxRecordar);

					String distribuidor = ((EditText) findViewById(R.id.editTextDistribuidor))
							.getText().toString();
					String usuario = ((EditText) findViewById(R.id.editTextUsuario))
							.getText().toString();
					String password = ((EditText) findViewById(R.id.editTextPassword))
							.getText().toString();

					if (recordar.isChecked()) {

						guardarDatosLogin(distribuidor, usuario, password);

					}

					sendToMainIntent();
				}
			});
		}
	}

	private void guardarDatosLogin(String distribuidor, String usuario,
			String password) {

		SharedPreferences preferencias = getSharedPreferences("PREFERENCIAS",
				Context.MODE_PRIVATE);

		SharedPreferences.Editor editor = preferencias.edit();
		editor.putString("distribuidor", distribuidor);
		editor.putString("usuario", usuario);
		editor.putString("password", password);
		editor.putString("login", "1");
		editor.commit();

	}

	private void sendToMainIntent() {

		SharedPreferences preferencias = getSharedPreferences("PREFERENCIAS",
				Context.MODE_PRIVATE);
		Intent intent = new Intent(LoginActivity.this, MainActivity.class);
		intent.putExtra("distribuidor",
				preferencias.getString("distribuidor", ""));
		intent.putExtra("usuario", preferencias.getString("usuario", ""));
		intent.putExtra("password", preferencias.getString("password", ""));
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}