package com.example.gridviewdashboard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnItemClickListener{

	static final String EXTRA_MAP = "map";
	
	static final LauncherIcon[] ICONS = {
		new LauncherIcon(R.drawable.ic_action_help, "Help", "ic_action_help.png"),
		new LauncherIcon(R.drawable.ic_action_info, "Info", "ic_action_info.png"),
		new LauncherIcon(R.drawable.ic_action_search, "Search", "ic_action_search.png"),
		new LauncherIcon(R.drawable.ic_action_settings, "Settings", "ic_action_settings.png"),
		new LauncherIcon(R.drawable.ic_action_warning, "Warning", "ic_action_warning.png"),
		new LauncherIcon(R.drawable.ic_action_error, "Error", "ic_action_error.png")
		
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		GridView gridview = (GridView) findViewById(R.id.dashboard_grid);
		gridview.setAdapter(new ImageAdapter(this));
		
		gridview.setOnItemClickListener(this);
		 
        // Hack to disable GridView scrolling
        gridview.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return event.getAction() == MotionEvent.ACTION_MOVE;
            }
        });
		
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
		
		Intent intent = new Intent(MainActivity.this, MapActivity.class);
		intent.putExtra(EXTRA_MAP, ICONS[position].map);
		startActivity(intent);
		
	}
	
	static class ImageAdapter extends BaseAdapter{

		private Context mContext;
		
		public ImageAdapter(Context context){
			this.mContext = context;
		}
		
		@Override
		public int getCount() {
			return ICONS.length;
		}

		@Override
		public Object getItem(int position) {			
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		static class ViewHolder{
			public ImageView icon;
			public TextView txt;
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			View v = convertView;
			ViewHolder holder;
			
			if(v == null){
				LayoutInflater vi = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				v = vi.inflate(R.layout.dashboard_icon, null);
				holder = new ViewHolder();
				holder.txt = (TextView) v.findViewById(R.id.dashboard_icon_text);
				holder.icon = (ImageView) v.findViewById(R.id.dashboard_icon_img);
				v.setTag(holder);				
			}else{
				holder = (ViewHolder) v.getTag();
			}
			
			holder.icon.setImageResource(ICONS[position].imgId);
			holder.txt.setText(ICONS[position].text);
			View view;
			
			if(position == 3 || position == 4 || position == 5){
				view = v.findViewById(R.id.view1);
				view.setVisibility(View.INVISIBLE);
			}
			
			if(position == 2 || position == 5){
				view = v.findViewById(R.id.view2);
				view.setVisibility(View.INVISIBLE);
			}

			return v;
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	

}
