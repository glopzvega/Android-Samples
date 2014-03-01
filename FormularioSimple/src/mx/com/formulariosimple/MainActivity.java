package mx.com.formulariosimple;

import android.R.anim;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TextView resultado = (TextView) findViewById(R.id.textViewResultado);
		resultado.setText("Aqui se vera el resultado");
		
		Button botonUsuarioEnviar = (Button) findViewById(R.id.enviar);
		botonUsuarioEnviar.setOnClickListener(botonEnviarListener);	
		
		Button botonUsuarioLimpiar = (Button) findViewById(R.id.limpiar);
		botonUsuarioLimpiar.setOnClickListener(botonLimpiarListener);	
	}
	
	private OnClickListener botonLimpiarListener = new OnClickListener()
	{		
		public void onClick(android.view.View v) {
			
			EditText textoUsuarioNombre = (EditText) findViewById(R.id.txtNombre);
			textoUsuarioNombre.setText("");
			
			TextView resultadoNombre = (TextView) findViewById(R.id.resultNombre);
			resultadoNombre.setText("");
			
			EditText textoUsuarioApellido = (EditText) findViewById(R.id.txtApellido);
			textoUsuarioApellido.setText("");
			
			TextView resultadoApellido = (TextView) findViewById(R.id.resultApellido);
			resultadoApellido.setText("");
			
			EditText textoUsuarioTelefono = (EditText) findViewById(R.id.txtTelefono);
			textoUsuarioTelefono.setText("");
			
			TextView resultadoTelefono = (TextView) findViewById(R.id.resultTelefono);
			resultadoTelefono.setText("");
			
			EditText textoUsuarioEmail = (EditText) findViewById(R.id.txtEmail);
			textoUsuarioEmail.setText("");
			
			TextView resultadoEmail = (TextView) findViewById(R.id.resultEmail);
			resultadoEmail.setText("");
		}			
		
	};

	private OnClickListener botonEnviarListener = new OnClickListener(){
		
		public void onClick(android.view.View v){
		
			EditText textoUsuarioNombre = (EditText) findViewById(R.id.txtNombre);
			String valorTextoUsuarioNombre = textoUsuarioNombre.getText().toString();
			
			TextView resultadoNombre = (TextView) findViewById(R.id.resultNombre);
			resultadoNombre.setText(valorTextoUsuarioNombre);
			
			EditText textoUsuarioApellido = (EditText) findViewById(R.id.txtApellido);
			String valorTextoUsuarioApellido = textoUsuarioApellido.getText().toString();
			
			TextView resultadoApellido = (TextView) findViewById(R.id.resultApellido);
			resultadoApellido.setText(valorTextoUsuarioApellido);
			
			EditText textoUsuarioTelefono = (EditText) findViewById(R.id.txtTelefono);
			String valorTextoUsuarioTelefono = textoUsuarioTelefono.getText().toString();
			
			TextView resultadoTelefono = (TextView) findViewById(R.id.resultTelefono);
			resultadoTelefono.setText(valorTextoUsuarioTelefono);
			
			EditText textoUsuarioEmail = (EditText) findViewById(R.id.txtEmail);
			String valorTextoUsuarioEmail = textoUsuarioEmail.getText().toString();
			
			TextView resultadoEmail = (TextView) findViewById(R.id.resultEmail);
			resultadoEmail.setText(valorTextoUsuarioEmail);
		}		
	};

}
