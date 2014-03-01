package com.example.uxandroidtablayout;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TabHost host = getTabHost();
		
		TabSpec spec1 = host.newTabSpec("Tab1");
		TabSpec spec2 = host.newTabSpec("Tab2");
		TabSpec spec3 = host.newTabSpec("Tab3");
		
		spec1.setIndicator("", getResources().getDrawable(R.drawable.ic_newkey));
		Intent photosIntent = new Intent(this, Otra.class);
		spec1.setContent(photosIntent);

		spec2.setIndicator("", getResources().getDrawable(R.drawable.ic_nuevo));		
		spec2.setContent(photosIntent);
		
		spec3.setIndicator("", getResources().getDrawable(R.drawable.ic_trash));		
		spec3.setContent(photosIntent);
		
		host.addTab(spec1); // Adding photos tab
		host.addTab(spec2);
		host.addTab(spec3);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
