package com.fedorvlasov.lazylist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {

	ListView list;
	LazyAdapter adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.realmain);

		// create an listener that is listening for action of the botton
		// specified below
		Button b = (Button) findViewById(R.id.button2);
		b.setOnClickListener(listener);
		
		Button b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(listener1);
	}

	public OnClickListener listener = new OnClickListener() {
		public void onClick(View v) {

			// create an Intent that will be put on the stack
			Intent myIntent = new Intent(MainActivity.this,
					ViewGalleryActivity.class);

			// by calling this method we put the activityon the top of the stack
			// when pressing the back button we take that ativity of the stack
			MainActivity.this.startActivity(myIntent);
		}
	};
	
	
	
	public OnClickListener listener1 = new OnClickListener() {
		public void onClick(View v) {

			// create an Intent that will be put on the stack
			Intent myIntent = new Intent(MainActivity.this,
					CameraActivity.class);

			// by calling this method we put the activityon the top of the stack
			// when pressing the back button we take that ativity of the stack
			MainActivity.this.startActivity(myIntent);
		}
	};
	
}