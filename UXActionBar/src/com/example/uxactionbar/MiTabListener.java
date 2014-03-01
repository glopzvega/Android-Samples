package com.example.uxactionbar;

import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.util.Log;

public class MiTabListener implements TabListener{

	private Fragment fragment;
	
	public MiTabListener(Fragment fg){
		this.fragment = fg;
	}
	
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		Log.i("Action Bar", tab.getText() + " reseleccionada");
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		Log.i("Action Bar", tab.getText() + " seleccionada");
		ft.replace(android.R.id.content, fragment);
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		Log.i("Action Bar", tab.getText() + " deseleccionada");
		ft.remove(fragment);
	}

}
