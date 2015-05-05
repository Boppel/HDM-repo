package com.example.helloandroid;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	private Button clickButton;
	private Button callButton;
	private Button startActivityButton;
	
	private EditText txt;
	private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        // Assignment 1
        clickButton = (Button) findViewById(R.id.countButton);
        clickButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				count++;
				clickButton.setText("" + count);
			}
		}); 
        
        // Assignment 2
        callButton = (Button) findViewById(R.id.callButton);
        callButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// implicit intent
				Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:123456789"));
				startActivity(dialIntent);
			}
		});
        
        txt = (EditText) findViewById(R.id.txtData);
        
        startActivityButton = (Button) findViewById(R.id.ActivityButton);
        startActivityButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// explicit inent
				// kein this weil nicht im context!
				// .toString wars -.-
				CharSequence arg = txt.getText().toString();
				
				Intent activityIntent = new Intent(getApplication(), SecondActivity.class);
				activityIntent.putExtra("arg", arg);
				startActivity(activityIntent);
			}
		});
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
