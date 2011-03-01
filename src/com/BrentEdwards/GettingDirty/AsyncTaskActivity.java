package com.BrentEdwards.GettingDirty;

import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class AsyncTaskActivity extends Activity {
	private TextView _output;
	private ProgressDialog _dialog;
	private SampleAsyncTask _task;
	
	private Handler _handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			showResult();
		}
	};
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.async);
        
        _output = (TextView)findViewById(R.id.output);
        
        Button startTaskButton = (Button)findViewById(R.id.startTaskButton);
        startTaskButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				startTask();
			}
		});
	}
	
	private void startTask() {
		_output.setText("");
		_dialog = ProgressDialog.show(this, "Loading...", "Loading your stuff");
		
		_task = new SampleAsyncTask(_handler);
		_task.execute();
	}
	
	private void showResult() {
		_dialog.dismiss();
		
		try {
			_output.setText(_task.get());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		Animation animation = AnimationUtils.loadAnimation(this, R.anim.show_text_anim);
		_output.startAnimation(animation);
	}
}
