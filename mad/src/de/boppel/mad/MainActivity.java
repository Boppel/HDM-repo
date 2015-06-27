package de.boppel.mad;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
	
	// Assignment 1
	private int count = 0;
	private Button btn_click;
	private TextView txt_info;
	private OnClickListener countListener;
	
	// Assignment 2
	private Button btn_call;
	private Intent callIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Assignment 1
        btn_click = (Button) findViewById(R.id.btn_clickMe);
        txt_info  = (TextView) findViewById(R.id.txt_title);
        
        // ghetto inline
        countListener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				count++;
				txt_info.setText("Clicked " + "" + count + " times.");
			}
		};
		
        btn_click.setOnClickListener(countListener);
        // End of Assignment 1
        
        
        // Assignment 2
        btn_call = (Button) findViewById(R.id.btn_call);
        callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01788720226"));
        btn_call.setOnClickListener(callListener);
        // End of Assignment 2
        
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
    
    
    // Assignment 2: ClickListener for Button
    final OnClickListener callListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			startActivity(callIntent);
		}
	};
    
    
}
