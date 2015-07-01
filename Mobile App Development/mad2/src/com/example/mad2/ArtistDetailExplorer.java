package com.example.mad2;

import android.app.ListActivity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SimpleCursorAdapter;

public class ArtistDetailExplorer extends ListActivity {

	private Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
	private String[] projection = {
									MediaStore.Audio.Media._ID,
									MediaStore.Audio.Media.ARTIST,
									MediaStore.Audio.Media.TITLE,
									MediaStore.Audio.Media.DURATION
	};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_artistdetaill);
		
		ContentResolver resolver = getContentResolver();
		Cursor cursor = resolver.query(uri, projection, null, null, null);
		
		
		final SimpleCursorAdapter sca = new SimpleCursorAdapter(this, android.R.layout.two_line_list_item, cursor,new String[]{MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media.ARTIST}, new int[] {android.R.id.text1, android.R.id.text2},SimpleCursorAdapter.NO_SELECTION);
		setListAdapter(sca);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.artist_detail_explorer, menu);
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
