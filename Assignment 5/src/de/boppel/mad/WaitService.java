package de.boppel.mad;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class WaitService extends IntentService{

	public WaitService() {
		super("WaitService");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		int waitTime = (int) intent.getExtras().getInt("waitTime", 666);
		
		synchronized (this) {
			try {
				wait(waitTime * 1000);
				Log.e("wait time:", waitTime + " seconds");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	
}
