package me.naiyu.android.stickylayoutdemos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void btnClick(View v) {
		Intent it = new Intent();
		switch (v.getId()) {
		case R.id.btn_way_one:
			it.setClass(this, WayOneActivity.class);
			break;

		default:
			break;
		}
		startActivity(it);
	}


}
