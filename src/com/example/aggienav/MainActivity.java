package com.example.aggienav;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.example.aggienav.R;
import com.example.aggienav.MainActivity;
import com.example.aggienav.MapActivity;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	Button bSubmit;
	String dest1, dest2, dest3, dest4, dest5, dest6;

	// Vector<String> dest = new Vector<String>();
	// Vector<EditText> txtBldg;

	EditText txtBldg1, txtBldg2, txtBldg3, txtBldg4, txtBldg5, txtBldg6;

	EditText testText1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bSubmit = (Button) findViewById(R.id.bSubmit);

		txtBldg1 = (EditText) findViewById(R.id.boxBldg1);
		txtBldg2 = (EditText) findViewById(R.id.boxBldg2);
		txtBldg3 = (EditText) findViewById(R.id.boxBldg3);
		txtBldg4 = (EditText) findViewById(R.id.boxBldg4);
		txtBldg5 = (EditText) findViewById(R.id.boxBldg5);
		txtBldg6 = (EditText) findViewById(R.id.boxBldg6);

		/*----Construct urlString to request direction using longtitude & latitude-------*/

		/*
		 * StringBuilder urlString = new StringBuilder();
		 * urlString.append("http://maps.google.com/maps?saddr=");
		 * //urlString.append("slong"); urlString.append(",");
		 * //urlString.append("slat"); urlString.append("&daddr=");
		 * //urlString.append("dlong"); urlString.append(",");
		 * //urlString.append("dlat");
		 * *******************************************
		 * **************************************
		 */

		// Reformat input value
		// dest1 =

		bSubmit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				// get value from EditText View
				dest1 = txtBldg1.getText().toString();
				dest2 = txtBldg2.getText().toString();
				dest3 = txtBldg3.getText().toString();
				dest4 = txtBldg4.getText().toString();
				dest5 = txtBldg5.getText().toString();
				dest6 = txtBldg6.getText().toString();

				/************
				 * Construct urlString to request direction*********** Does not
				 * work in all Abbrs. eb. BICH
				 *******************/

				dest1 = dest1
						+ ", Texas A%26M University, College Station, Texas 77840";
				dest2 = dest2
						+ ", Texas A%26M University, College Station, Texas 77840";
				dest3 = dest3
						+ ", Texas A%26M University, College Station, Texas 77840";
				dest4 = dest4
						+ ", Texas A%26M University, College Station, Texas 77840";
				dest5 = dest5
						+ ", Texas A%26M University, College Station, Texas 77840";
				dest6 = dest6
						+ ", Texas A%26M University, College Station, Texas 77840";

				testText1 = (EditText) findViewById(R.id.TestText1);

				// TODO Auto-generated method stub
				// Intent MapIntent = new Intent(MainActivity.this,
				// MapActivity.class);
				// startActivity(MapIntent);
				/*
				 * Intent intent = new
				 * Intent(android.content.Intent.ACTION_VIEW,
				 * Uri.parse("http://maps.google.com/maps?" +
				 * "saddr=30.623252,-96.347008&daddr=30.618169,-96.341209"));
				 */

				String url = "";
				HttpClient httpclient = new DefaultHttpClient();
				HttpGet httpget = new HttpGet(url);
				HttpResponse response;

				try {
					response = httpclient.execute(httpget);
					HttpEntity entity = response.getEntity();
					if (entity != null) {
						InputStream instream = entity.getContent();
						String result= convertStreamToString(instream);
					}

				} catch (Exception e) {
				}

				Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
						Uri.parse("http://maps.google.com/maps?" + "saddr="
								+ dest1 + "&daddr=" + dest2 + "&dirflg=w"));

				/*
				 * String uri = "http://maps.google.com/maps?" + "saddr="+ dest1
				 * +"&daddr="+ dest2 + "%2bto:" + dest3 + "%2bto:" + dest4 +
				 * "%2bto:" + dest5 + "%2bto:" + dest6;
				 */

				/*
				 * String uri =
				 * "https://maps.google.com/maps?saddr=Stasney St&daddr=30.607657,-96.344454 %2b to:30.62063,-96.340742 %2b to:30.619185,-96.342528"
				 * ; Intent intent = new
				 * Intent(android.content.Intent.ACTION_VIEW,Uri.parse(uri));
				 */

				startActivity(intent);

				// testText1.setText(uri);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public static String convertStreamToString(InputStream is) {
		/*
		 * To convert the InputStream to String we use the
		 * BufferedReader.readLine() method. We iterate until the BufferedReader
		 * return null which means there's no more data to read. Each line will
		 * appended to a StringBuilder and returned as String.
		 */
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}
