package com.example.mad2;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

public class ArtistExplorer extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_artistexplorer);
		
		// example from the slides
		/*
		// entries of list = ArrayList
		List<String> bandlist = Arrays.asList("Deichkind", "Death", "Cynic", "Opeth", "Borknaroth Gorg");
		
		// predefined ArrayAdapter
		ArrayAdapter<String> bandArray = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, bandlist);
		// set the adapter
		setListAdapter(bandArray);
		*/
		
		// Assignment 4
		ContentResolver resolver = getContentResolver();
		
		String[] projection = {MediaStore.Audio.Media._ID,
							   MediaStore.Audio.Media.ARTIST,
						       MediaStore.Audio.Media.TITLE,
						       MediaStore.Audio.Media.DURATION};
		
		// nur noetig bei selection im SQL Stil mit prepared statements
		//String selection = MediaStore.Audio.Media.ARTIST = "LIKE ?";
		// oder im methoden aufruf null, null, null
		String selection = null;
		String[] selectionArgs = null;
		String sortOrder = MediaStore.Audio.Media._ID;
		
		Cursor cursor = resolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, 
									 projection, selection, selectionArgs, sortOrder);
		
		List<String> sdContent = new ArrayList<String>();
		while(cursor.moveToNext()) {
			sdContent.add(cursor.getString(1));
		}
		
		ArrayAdapter<String> sdAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sdContent);
		setListAdapter(sdAdapter);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.artist_explorer, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
