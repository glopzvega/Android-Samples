package mx.com.listatareas;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {	
	
	private EditText editTextTarea;
	private ArrayList<String> tareas;
	private ArrayAdapter<String> adaptador;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editTextTarea = (EditText) findViewById(R.id.editTextArea);
		ListView listViewTarea = (ListView) findViewById(R.id.listViewTarea);
		
		tareas = new ArrayList<String>();
		tareas.add("Tarea 1");
		tareas.add("Tarea 2");
		
		adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tareas);		
		listViewTarea.setAdapter(adaptador);
		
		editTextTarea.setOnKeyListener(tecladoListener);		
	}
	
	private OnKeyListener tecladoListener = new OnKeyListener(){

		@Override
		public boolean onKey(View vista, int keyCode, KeyEvent event) {
			if(event.getAction() == KeyEvent.ACTION_DOWN)
			{
				if(keyCode == KeyEvent.KEYCODE_DPAD_CENTER || keyCode == KeyEvent.KEYCODE_ENTER)
				{
					tareas.add(editTextTarea.getText().toString());
					editTextTarea.setText("");
					adaptador.notifyDataSetChanged();
					return true;
				}					
			}
			return false;
		}				
		
	};
}