package mx.com.listacompras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ArrayList<Elemento> elementos;
	private ArrayList<Venta> ventas = new ArrayList<Venta>();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Recuperamos el ListView
		ListView listViewElementos = (ListView) findViewById(R.id.listViewElementos);
		
		//Obtenemos los elementos de la lista
		elementos = getElementos();
		ventas = getVentas();
		
		//Iniciamos el adaptador el cual llamara
		//ElementoAdaptador adaptador = new ElementoAdaptador(this, elementos);
		ElementoAdaptador adaptador = new ElementoAdaptador(this, ventas);
		
		//Asociamos el adaptador a la lista
		listViewElementos.setAdapter(adaptador);
		
		//Registramos el evento OnItemClick
		listViewElementos.setOnItemClickListener(itemListener);				
	}
	
	private OnItemClickListener itemListener = new OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> padre, View vista, int position,
				long id) {

			//Recuperamos el layout
			Elemento elementoSel = elementos.get(position);
			String mensaje = "Posicion " + position + " - " + elementoSel.getNombre();
			
			//Enviamos una notificacion
			Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();
			
		}
		
	};

	
	private ArrayList<Elemento> getElementos(){
		
		ArrayList<Elemento> elementos = new ArrayList<Elemento>();
		elementos.add(new  Elemento(1,  "Manzana",  "manzana"));
		elementos.add(new  Elemento(2,  "Kiwi",  "kiwi"));
		elementos.add(new  Elemento(3,  "Pera",  "pera"));
		return elementos;
	}
	
	private ArrayList<Venta> getVentas(){
		
		ArrayList<Venta> mapas = new ArrayList<Venta>();						
		
		mapas.add(new Venta(1, "11111", "1234567890", "00:00", "$50"));
		mapas.add(new Venta(2, "22222", "1111111111", "00:00", "$100"));
		mapas.add(new Venta(3, "33333", "5555555555", "00:00", "$20"));
		mapas.add(new Venta(4, "44444", "5555555551", "00:00", "$100"));
		mapas.add(new Venta(5, "55555", "5555555552", "00:00", "$30"));
		
		return mapas;
	}

}
