package com.example.uxactionbar;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ActionBar actionBar = getActionBar();
		
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		ActionBar.Tab tab1 = actionBar.newTab().setText("Tab 1");
		ActionBar.Tab tab2 = actionBar.newTab().setText("Tab 2");
		
		Fragment tab1Fragment = new Tab1Fragment();
		Fragment tab2Fragment = new Tab2Fragment();
		
		tab1.setTabListener(new MiTabListener(tab1Fragment));
		tab2.setTabListener(new MiTabListener(tab2Fragment));
		
		actionBar.addTab(tab1);
		actionBar.addTab(tab2);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
