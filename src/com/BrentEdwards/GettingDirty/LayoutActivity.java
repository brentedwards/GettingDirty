package com.BrentEdwards.GettingDirty;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LayoutActivity extends Activity {
	private static final int LINEAR = 1;
	private static final int RELATIVE = 2;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setView(LINEAR);
    }
    
    private void setView(int view) {
    	switch (view) {
    	case LINEAR:
    		setContentView(R.layout.layout_linear);
    		break;
    		
    	case RELATIVE:
    		setContentView(R.layout.layout_relative);
    		break;
    	}
    }
}