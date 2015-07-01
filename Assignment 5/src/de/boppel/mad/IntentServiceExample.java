package de.boppel.mad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class IntentServiceExample extends Activity {

	private EditText text_inputTime;
	private Button btn_start;
	private int waitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service_example);
        
        text_inputTime = (EditText) findViewById(R.id.inputTime);
        btn_start = (Button) findViewById(R.id.btn_wait);
        
        btn_start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// start Service
		        waitTime = Integer.parseInt(text_inputTime.getText().toString().trim());
				Intent i = new Intent(getApplicationContext(), WaitService.class);
				i.putExtra("waitTime", waitTime);
				getApplicationContext().startService(i);
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.intent_service_example, menu);
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
