package com.photo.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.photo.test.first.SecondActivity;

public class MainActivity extends AppCompatActivity
		implements View.OnClickListener {

	private TextView displayTv;
	private String displayValue = "";
	private String secondTextValue = "";
	private String operation = "";
	private int firstValue = 0;
	private int secondValue = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		displayTv = findViewById(R.id.display_tv);
		findViewById(R.id.one_btn).setOnClickListener(this);
		findViewById(R.id.two_btn).setOnClickListener(this);
		findViewById(R.id.three_btn).setOnClickListener(this);
		findViewById(R.id.clear_btn).setOnClickListener(this);
		findViewById(R.id.plus_btn).setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.one_btn:
				if (ifEndWithOperation()){
					secondTextValue += "1";
				}
				displayValue += "1";

				break;
			case R.id.two_btn:
				if (ifEndWithOperation()){
					secondTextValue += "2";
				}
				displayValue += "2";

				break;
			case R.id.three_btn:
				if (ifEndWithOperation()){
					secondTextValue += "3";
				}
				displayValue += "3";

				break;
			case R.id.clear_btn:
				displayValue = "";
				secondTextValue = "";
				break;
			case R.id.plus_btn:
				if (!TextUtils.isEmpty(displayValue)
						&& TextUtils.isEmpty(secondTextValue)) {

					firstValue = Integer.valueOf(displayValue.replace("+", ""));
					displayValue += "+";
				} else if (!TextUtils.isEmpty(secondTextValue)){
					secondValue = Integer.valueOf(secondTextValue);
					firstValue = firstValue + secondValue;
					displayValue = firstValue + "+";
					secondValue = 0;
					secondTextValue = "";
				}
				operation = "+";
				Toast.makeText(this, String.valueOf(firstValue) , Toast.LENGTH_SHORT).show();
				break;
		}

		displayTv.setText(displayValue);

	}

	private boolean ifEndWithOperation(){
		return  displayValue.endsWith("+") ||
				displayValue.endsWith("-") ||
				displayValue.endsWith("/") ||
				displayValue.endsWith("*");
	}
}
