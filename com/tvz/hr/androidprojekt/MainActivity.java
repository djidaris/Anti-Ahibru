package com.tvz.hr.androidprojekt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	public final String googleQuerry = "http://www.google.com/search?q=";
	public final String wolframQuerry = "http://m.wolframalpha.com/input/?i=";

	public static String link;
	EditText input;
	TextView textView;
	Button buttonGoogle;
	Button buttonWolfram;
	Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		input = (EditText) findViewById(R.id.input);
		textView = (TextView) findViewById(R.id.header);
		intent = new Intent(getApplicationContext(), BrowserActivity.class);

		buttonGoogle = (Button) findViewById(R.id.buttonGoogle);
		buttonGoogle.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				link = googleQuerry + input.getText().toString();
				startActivity(intent);
			}
		});

		buttonWolfram = (Button) findViewById(R.id.buttonWolfram);
		buttonWolfram.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// %2B <---> +
				// - <---> -
				// * <---> *
				// %2F <---> /
				String fixLink = input.getText().toString();
				fixLink = fixLink.replace("+", "%2B");
				fixLink = fixLink.replace("/", "%2F");
				String fixAd = "&x=0&y=0&js=off"; // fix za reklamu od wolframa

				link = wolframQuerry + fixLink + fixAd;
				// Toast.makeText(getApplicationContext(), link,
				// Toast.LENGTH_SHORT).show();
				startActivity(intent);

			}

		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
