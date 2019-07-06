package com.photo.test.first;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.photo.test.R;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
	}
}
