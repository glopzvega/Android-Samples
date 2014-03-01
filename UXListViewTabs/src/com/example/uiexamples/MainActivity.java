package com.example.uiexamples;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	public static final String[] LIST = { "", "1", "2", "3", "4", "5", "6", "7", "8" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);

		ListView lv = (ListView) findViewById(R.id.listView1);
		lv.setAdapter(new MyListAdapter(this));
	}

	private class MyListAdapter extends BaseAdapter {

		private final Context mContext;

		public MyListAdapter(Context context) {
			mContext = context;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return LIST.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return LIST[position];
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			System.out.println("x");
			
			if (position == 0) {								

				View item = convertView;
				
				if (convertView == null || convertView.getTag() == "1") {

					item = LayoutInflater.from(mContext).inflate(
							R.layout.layout_title, parent, false);
					item.setTag("0");
					
				}
				return item;
			}

			View item = convertView;
			
			if (convertView == null || convertView.getTag() == "0" ) {							

				item = LayoutInflater.from(mContext).inflate(
						R.layout.layout_item, parent, false);
				item.setTag("1");

			}			
			
			TextView tv = (TextView) item.findViewById(R.id.lv_item_header);
			tv.setText(LIST[position]);

			return item;
		}

	}
}
