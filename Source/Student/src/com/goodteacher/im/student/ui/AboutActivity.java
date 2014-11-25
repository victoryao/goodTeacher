package com.goodteacher.im.student.ui;

import com.goodteacher.im.student.R;

import android.os.Bundle;


public class AboutActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		initTopBarForLeft("关于我们");
	}
}
