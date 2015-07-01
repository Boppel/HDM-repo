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
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {
	
	// Assignment 1
	private int count = 0;
	private Button btn_click;
	private TextView txt_info;
	private OnClickListener countListener;
	
	// Assignment 2
	private Button btn_call;
	private Button btn_detail;
	private Intent callIntent;
	private EditText txt_detail;
	
	// Assignment 3
	private Button btn_ghettoBrowser;
	private Button btn_browser;

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
        
        btn_detail = (Button) findViewById(R.id.btn_detail);
        final Intent detailIntent = new Intent(this, Detail.class);
        
        txt_detail = (EditText) findViewById(R.id.txt_detail);
        btn_detail.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// wichtig; scope vom onClick beachten!
		        String userInput = txt_detail.getText().toString();
		        detailIntent.putExtra("userInput", userInput);
				startActivity(detailIntent);
			}
		});
        // End of Assignment 2
        
        // Assignment 3
        btn_browser = (Button) findViewById(R.id.btn_browser);
        btn_ghettoBrowser = (Button) findViewById(R.id.btn_ghettoBrowser);
        
        final Intent browserIntent = new Intent (this, BrowserActivity.class);
        
        btn_ghettoBrowser.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent ghettoBrowserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.thecodinglove.com"));
				startActivity(ghettoBrowserIntent);
			}
		});
        
        btn_browser.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(browserIntent);
			}
		});
        // End of Assignment 3
        
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
