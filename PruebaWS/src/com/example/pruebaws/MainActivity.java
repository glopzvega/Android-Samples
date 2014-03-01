package com.example.pruebaws;

import org.json.JSONObject;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.pruebaws.util.Utilerias;

public class MainActivity extends Activity {

	private static final String NAMESPACE = "http://alpha.taecel.com/";
	private static final String URL = "http://alpha.taecel.com//ConexionCorporativa.php?wsdl"; 
	private static final String METODO = "RequestWS";
	private static final String SOAP_ACTION = "http://alpha.taecel.com/RequestWS";	
	
	private SoapObject request = null;
	private SoapSerializationEnvelope envelope = null;						
	
	private void ejemploWS(String distribuidor, String usuario, String password){
		//186348952,DG0000001,ae622348fec7cac78c3491914ce71250
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?><Request>" + 
				"<PosLogin>" + 
					"<PosName>" + distribuidor + "</PosName>" + 
					"<UserName>" + usuario + "</UserName>" + 
					"<UserPass>" + Utilerias.md5(password) + "</UserPass>" + 
				"</PosLogin>" + 
				"<PosMethod>" + 
					"<MethodName>ReservaTopUp</MethodName>" + 
					"<Params>" + 
						"<CountryCode>52</CountryCode>" + 
						"<PhoneNumber>5555555555</PhoneNumber>" + 
						"<CardID>1</CardID>" + 
					"</Params>" + 
				"</PosMethod>" +
				"<Options><ReturnType>json</ReturnType></Options></Request>";
		
		
		request = new SoapObject(NAMESPACE, METODO);						
		
		PropertyInfo PrimerParametro = new PropertyInfo();
		PrimerParametro.setName("StringWS");				
		PrimerParametro.setValue(xml);			
		
		System.out.println(xml);
		
		request.addProperty(PrimerParametro);																
		envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);		
		envelope.dotNet = false;
		envelope.setAddAdornments(false);
		envelope.setOutputSoapObject(request);			
		
		HttpTransportSE transporte = new HttpTransportSE(URL);						
		transporte.debug = true;
		try {				
			
			transporte.call(SOAP_ACTION, envelope);						
			
			Log.d("TAG REQ", "HTTP REQUEST:\n" + transporte.requestDump);
			Log.d("TAG RES", "HTTP RESPONSE:\n" + transporte.responseDump);
						
			String result = (String) envelope.getResponse();							
			Log.d("r", (String) envelope.getResponse());			
			
			JSONObject json = new JSONObject(result);							
			
			json = json.getJSONObject("Response");
						
			Integer success = json.getInt("Success");						
			JSONObject fields = json.getJSONObject("Fields");						
			
			Log.d("Success", success.toString());
			Log.d("Status", fields.getString("Status"));
			Log.d("TransRef", fields.getString("TransRef"));
			
		} 
		
		catch (Exception e) {						
			e.printStackTrace();
		}				
	}

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final String distribuidor = getIntent().getExtras().getString("distribuidor");
		final String usuario = getIntent().getExtras().getString("usuario");
		final String password = getIntent().getExtras().getString("password");
		
		TextView md5 = (TextView) findViewById(R.id.textViewPassMd5);
		md5.setText(distribuidor);
		
		Button btn = (Button) findViewById(R.id.btn_recarga);		
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				Thread thread = new Thread()
				{
				    @Override
				    public void run() {
				        try {
				            
				        	ejemploWS(distribuidor, usuario, password);
				                                           
				        } catch (Exception e) {
				            e.printStackTrace();
				        }
				    }
				};								
				
				thread.start();							
				
			}
		});				
		
	}
	
	
}
