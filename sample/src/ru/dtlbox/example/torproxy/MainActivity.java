package ru.dtlbox.example.torproxy;

import ru.dtlbox.custom.CustomOrbotHelper;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

	CustomOrbotHelper mCustomOrbotHelper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		CustomOrbotHelper.setContext(MainActivity.this);
		mCustomOrbotHelper = CustomOrbotHelper.getInstance();
		mCustomOrbotHelper.requestStartTor(this);
//		mCustomOrbotHelper.torServiceStartAsync();
		
		View v = findViewById(R.id.rl_main);
		v.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Log.d("isTorServiceRunning",String.valueOf(mCustomOrbotHelper.isTorServiceRunning()));
				
			}
		});
		
		
		
	}

	
}
