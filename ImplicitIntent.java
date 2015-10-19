package org.insatandroidclub.formation.implicitintent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class ImplicitIntentActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	public void callIntent(View view) {
		Intent intent = null;
		switch (view.getId()) {
		case R.id.btn_browser:
			intent = new Intent(Intent.ACTION_VIEW,
					Uri.parse("http://www.insatandroidclub.org/"));
			startActivity(intent);
			break;
		case R.id.btn_call:
			intent = new Intent(Intent.ACTION_CALL,
					Uri.parse("tel:(+216) 55 02 17 55"));
			startActivity(intent);
			break;
		case R.id.btn_dial:
			intent = new Intent(Intent.ACTION_DIAL,
					Uri.parse("tel:(+216) 55 02 17 55"));
			startActivity(intent);
			break;
		case R.id.btn_show_map:
			intent = new Intent(Intent.ACTION_VIEW,
					Uri.parse("geo:50.123,7.1434?z=19"));
			startActivity(intent);
			break;
		case R.id.btn_search_map:
			intent = new Intent(Intent.ACTION_VIEW,
					Uri.parse("geo:0,0?q=query"));
			startActivity(intent);
			break;
		case R.id.btn_picture:
			intent = new Intent("android.media.action.IMAGE_CAPTURE");
			startActivityForResult(intent, 0);
			break;
		case R.id.btn_contact:
			intent = new Intent(Intent.ACTION_VIEW,
					Uri.parse("content://contacts/people/"));
			startActivity(intent);
			break;
		case R.id.btn_edit_contact:
			intent = new Intent(Intent.ACTION_EDIT,
					Uri.parse("content://contacts/people/1"));
			startActivity(intent);
			break;
		default:
			break;
		}
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == Activity.RESULT_OK && requestCode == 0) {
			String result = data.toURI();
			Toast.makeText(this, result, Toast.LENGTH_LONG);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
