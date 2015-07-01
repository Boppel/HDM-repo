package com.example.assignment8;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends Activity {
	
	private Button button;
	private ProgressBar bar;
	private UpdateProgressBarTask task;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button = (Button) findViewById(R.id.button);
		bar = (ProgressBar) findViewById(R.id.progress);
		task = new UpdateProgressBarTask();
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				task.execute(25);
			}
		});
	}

	private class UpdateProgressBarTask extends AsyncTask<Integer, Integer, Void>  {

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			bar.setVisibility(View.VISIBLE);
			bar.setMax(100);
		}
		
		@Override
		protected void onCancelled() {
			// TODO Auto-generated method stub
			bar.setProgress(0);
		}
		
		@Override
		protected Void doInBackground(Integer... params) {
			// TODO Auto-generated method stub
			int start = params[0];
			for(int i=start; i<=100; i+=5) {
				
				try {
					bar.setProgress(i);
					publishProgress(i);
					SystemClock.sleep(500);
					Log.i("Progress: " + i, "yolo");
				} catch (Exception e) {
					Log.e("Fehler", e.toString());
				}
			}
			return null;
		}
		
		@Override
		protected void onProgressUpdate(Integer... values) {
			// HIER LAG DER FEHLER!!!!b
			bar.setProgress(values[0]);
			super.onProgressUpdate(values);
		}
		
		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			Log.i("Done!", "Juhu!");
		}
		
	}
}
