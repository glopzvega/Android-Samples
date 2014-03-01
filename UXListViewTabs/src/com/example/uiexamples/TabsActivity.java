package com.example.uiexamples;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.example.uiexamples.tabs.PhotosActivity;
import com.example.uiexamples.tabs.SongsActivity;
import com.example.uiexamples.tabs.VideosActivity;

public class TabsActivity extends TabActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TabHost tabHost = getTabHost();
		 
        // Tab for Photos
        TabSpec photospec = tabHost.newTabSpec("Photos");
        // setting Title and Icon for the Tab
        photospec.setIndicator("", getResources().getDrawable(R.drawable.icon_photos_tab));
        Intent photosIntent = new Intent(this, PhotosActivity.class);
        photospec.setContent(photosIntent);
 
        // Tab for Songs
        TabSpec songspec = tabHost.newTabSpec("Songs");
        songspec.setIndicator("Songs", getResources().getDrawable(R.drawable.icon_songs_tab));
        Intent songsIntent = new Intent(this, SongsActivity.class);
        songspec.setContent(songsIntent);
 
        // Tab for Videos
        TabSpec videospec = tabHost.newTabSpec("Videos");
        videospec.setIndicator("Videos", getResources().getDrawable(R.drawable.icon_videos_tab));
        Intent videosIntent = new Intent(this, VideosActivity.class);
        videospec.setContent(videosIntent);
 
        // Adding all TabSpec to TabHost
        tabHost.addTab(photospec); // Adding photos tab
        tabHost.addTab(songspec); // Adding songs tab
        tabHost.addTab(videospec); // Adding videos tab
		
	}
	

}
