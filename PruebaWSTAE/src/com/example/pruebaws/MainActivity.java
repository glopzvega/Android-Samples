package com.example.pruebaws;

import org.json.JSONArray;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

public class MainActivity extends Activity {

	private static final String NAMESPACE = "http://alpha.taecel.com/";
	private static final String URL = "http://alpha.taecel.com//ConexionCorporativa.php?wsdl"; 
	private static final String METODO = "RequestWS";
	private static final String SOAP_ACTION = "http://alpha.taecel.com/RequestWS";	
	
	private SoapObject request = null;
	private SoapSerializationEnvelope envelope = null;
	private SoapPrimitive resultsRequestSOAP = null;
		
	Gson gson ;	
	
	Button btn;
	ListView lsvAndroidOS;		
	
	
	private void ejemploWS(){
				
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?><Request><PosLogin><PosName>186348952</PosName><UserName>DG0000001</UserName><UserPass>ae622348fec7cac78c3491914ce71250</UserPass>" + 
				"</PosLogin><PosMethod><MethodName>ReservaTopUp</MethodName><Params><CountryCode>52</CountryCode><PhoneNumber>5555555555</PhoneNumber>" +
				"<CardID>1</CardID></Params></PosMethod><Options><ReturnType>json</ReturnType></Options></Request>";
		
		
		request = new SoapObject(NAMESPACE, METODO);						
		
		PropertyInfo PrimerParametro = new PropertyInfo();
		PrimerParametro.setName("StringWS");				
		PrimerParametro.setValue(xml);			
		
		//System.out.println(xml);
		
		request.addProperty(PrimerParametro);																
		envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);		
		envelope.dotNet = false;
		envelope.setAddAdornments(false);
		envelope.setOutputSoapObject(request);			
		
		HttpTransportSE transporte = new HttpTransportSE(URL);						
		transporte.debug = true;
		try {				
			
			transporte.call(SOAP_ACTION, envelope);						
			
			//Log.d("TAG REQ", "HTTP REQUEST:\n" + transporte.requestDump);
			//Log.d("TAG RES", "HTTP RESPONSE:\n" + transporte.responseDump);
			
			
			String result = (String) envelope.getResponse();								
			Log.d("r", (String) envelope.getResponse());
			
			/*gson = new Gson();
			
			Type lstT = (Type) new TypeToken<ArrayList>(){}.getType();
			
			ArrayList lista = new ArrayList();
			
			lista = gson.fromJson(result, (java.lang.reflect.Type) lstT);
			*/
			System.out.println(result);			
								
			
			
		} 
		
		catch (Exception e) {						
			e.printStackTrace();
		}				
		
		//String  strJSON = resultsRequestSOAP.toString();
		//Log.d("json", strJSON);
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btn = (Button) findViewById(R.id.btn);
		lsvAndroidOS = (ListView) findViewById(R.id.lst);
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				Thread thread = new Thread()
				{
				    @Override
				    public void run() {
				        try {
				            
				        	ejemploWS();
				                                           
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
