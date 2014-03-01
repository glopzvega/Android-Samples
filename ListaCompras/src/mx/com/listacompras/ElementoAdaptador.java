package mx.com.listacompras;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ElementoAdaptador extends BaseAdapter{

	private Activity actividad;
	private ArrayList<Elemento> elementos;
	private ArrayList<Venta> ventas;
	
	
/*	public ElementoAdaptador(Activity actividad, ArrayList<Elemento> elementos) {		
		this.actividad = actividad;
		this.elementos = elementos;
	}*/
	
	public ElementoAdaptador(Activity actividad, ArrayList<Venta> ventas) {		
		this.actividad = actividad;
		this.ventas = ventas;
	}

	@Override
	public int getCount() {
		//return elementos.size();
		return ventas.size();
	}

	@Override
	public Object getItem(int position) {
//		return elementos.get(position);
		return ventas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return ventas.get(position).getId();
//		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View vista = convertView;
		if(vista == null){
			LayoutInflater inflater = (LayoutInflater) actividad.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			vista = inflater.inflate(R.layout.lista_elementos_layout,  null);
		}
		//Elemento elemento = elementos.get(position);
		Venta venta = ventas.get(position);
				
		//Modificamos el contenido del nombre del elemento
		TextView numero = (TextView) vista.findViewById(R.id.txtNumero);
		numero.setText("#" + venta.getNumero());
		
		TextView folio = (TextView) vista.findViewById(R.id.txtFolio);
		folio.setTextColor(Color.GRAY);
		folio.setText("Folio: " + venta.getFolio());
		
		TextView monto = (TextView) vista.findViewById(R.id.txtMonto);
		monto.setText(venta.getMonto());		
		
		TextView hora = (TextView) vista.findViewById(R.id.txtHora);
		hora.setTextColor(Color.GRAY);
		hora.setText(venta.getHora());
		
		
		//Modificamos el contenido de la imagen del elemento
//		ImageView imagen = (ImageView) vista.findViewById(R.id.imagenElemento);
//		//Recuperamos el identificador de la imagen
//		int recursoImagen = actividad.getResources().getIdentifier("drawable/" + elemento.getImagen(), null, actividad.getPackageName());
//		//Colocamos la imagen recuperada segun la clase R
//		imagen.setImageDrawable(actividad.getResources().getDrawable(recursoImagen));
//		
		return vista;
	}

	
}
