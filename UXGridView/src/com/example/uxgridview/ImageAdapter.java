package com.example.uxgridview;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        TextView tx;
        View item;
        
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            
        	item = ((Activity) mContext).getLayoutInflater().inflate(R.layout.image_layout, parent, false);
        	
        	
//        	imageView = new ImageView(mContext);
//            imageView.setLayoutParams(new GridView.LayoutParams(45, 45));
////            imageView.setAdjustViewBounds(false);
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            imageView.setPadding(8, 8, 8, 8);
        } else {
        	item = convertView;
//            imageView = (ImageView) convertView;
        }
        
        imageView = (ImageView) item.findViewById(R.id.imageView1);
        tx = (TextView) item.findViewById(R.id.textView1);
        
         imageView.setImageResource(mThumbIds[position]);
         tx.setText(images[position]);
         return item;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7
    };
    
    private String[] images = {
    			"image2", "image3",
               "image4", "image5",
               "image6", "image7",
               "image0", "image1",
               "image2", "image3",
               "image4", "image5",
               "image6", "image7",
               "image0", "image1",
               "image2", "image3",
               "image4", "image5",
               "image6", "image7"
    };
}