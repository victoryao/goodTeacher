package com.goodteacher.im.student.ui;

import com.goodteacher.im.student.R;
import com.goodteacher.im.student.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class AboutActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		initTopBarForLeft("关于我们");
	}
}
