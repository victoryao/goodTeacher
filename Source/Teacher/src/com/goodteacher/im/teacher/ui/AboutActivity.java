package com.goodteacher.im.teacher.ui;

import android.os.Bundle;

import com.goodteacher.im.teacher.R;


public class AboutActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		initTopBarForLeft("关于我们");
	}
}
