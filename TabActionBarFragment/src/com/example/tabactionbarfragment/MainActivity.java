package com.example.tabactionbarfragment;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ActionBar actionBar = getActionBar();
		
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		String label1 = getResources().getString(R.string.body1);
		String label2 = getResources().getString(R.string.body2);
		
		Tab tab = actionBar.newTab();
		tab.setText(label1);
		tab.setIcon(R.drawable.ic_newkey);
		
		TabListener<Tab1Fragment> t1 = new TabListener<Tab1Fragment>(this, label1, Tab1Fragment.class);
		tab.setTabListener(t1);
		actionBar.addTab(tab);
		
		tab = actionBar.newTab();
		tab.setText(label2);
		tab.setIcon(R.drawable.ic_nuevo);
		
		TabListener<Tab2Fragment> t2 = new TabListener<Tab2Fragment>(this, label2, Tab2Fragment.class);
		tab.setTabListener(t2);
		actionBar.addTab(tab);
		
		
		
	}
	
	private class TabListener<T extends Fragment> implements ActionBar.TabListener{

		private Fragment mFragment;
		private final Activity mActivity;
		private final String mTag;
		private final Class<T> mClass;		
		
		public TabListener(Activity activiy, String tag, Class<T> clz){
			this.mActivity = activiy;
			this.mTag = tag;
			this.mClass = clz;
		}
		
		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			
			if(mFragment != null){
				ft.attach(mFragment);
			}
			else
			{
				mFragment = Fragment.instantiate(mActivity, mClass.getName());
				ft.add(android.R.id.content, mFragment, mTag);				
			}			
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			
			if(mFragment != null){
				ft.detach(mFragment);
			}
			
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
