package com.BrentEdwards.GettingDirty;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LifecycleActivity extends Activity {
	
	private EditText _input;
	private TextView _text;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lifecycle);
        
        _input = (EditText)findViewById(R.id.input);
        _text = (TextView)findViewById(R.id.text);
        
        Button setTextButton = (Button)findViewById(R.id.setTextButton);
        setTextButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				String inputText = _input.getText().toString();
				setText(inputText);
			}
		});
    }
	
	@Override
    public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		
		outState.putString("InputText", _text.getText().toString());
	}
	
    @Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		
		String inputText = savedInstanceState.getString("InputText");
		setText(inputText);
    }
	
	private void setText(String text)
	{
		_text.setText(text);
	}
}
