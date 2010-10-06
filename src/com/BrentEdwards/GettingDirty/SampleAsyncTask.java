package com.BrentEdwards.GettingDirty;

import android.os.AsyncTask;
import android.os.Handler;

public class SampleAsyncTask extends AsyncTask<Void, Integer, String> {
	private Handler _handler;
	
	public SampleAsyncTask(Handler handler) {
		_handler = handler;
	}
	
	protected void onPreExecute() {
		
	}
	
	@Override
	protected String doInBackground(Void... arg0) {
		try {
			// Simulate some long-running task such as downloading.
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return "Here's your stuff!";
	}

    protected void onPostExecute(String result) {
    	_handler.sendEmptyMessage(0);
    }
}
