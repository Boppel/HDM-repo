package de.boppel.mad;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class BrowserActivity extends Activity {

	private WebView mWebView;
	private ProgressBar bar;
	private boolean doneLoading = false;
	int debug = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_browser);
		
		mWebView = (WebView) findViewById(R.id.wv_ghettobrowser);
		mWebView.loadUrl("http://www.reddit.com");
		
		bar = (ProgressBar) findViewById(R.id.progressBar);
		
		mWebView.setWebChromeClient(new WebChromeClient() {
			public void onProgressChanged(WebView view, int progress) {
				bar.setProgress(progress);
				if(progress >= 95) {
					doneLoading = true;
				}
			}
		});
		
		if(doneLoading) {
			bar.setVisibility(ProgressBar.INVISIBLE);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.browser, menu);
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
