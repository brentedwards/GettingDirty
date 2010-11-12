package com.BrentEdwards.GettingDirty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    private void showAsyncTask() {
    	Intent intent = new Intent(this, AsyncTaskActivity.class);
    	startActivity(intent);
    }
    
    private void showLayout() {
    	Intent intent = new Intent(this, LayoutActivity.class);
		startActivity(intent);
    }
    
    private void showLifecycle() {
    	Intent intent = new Intent(this, LifecycleActivity.class);
		startActivity(intent);
    }
}