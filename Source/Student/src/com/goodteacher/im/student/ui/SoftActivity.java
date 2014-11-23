package com.goodteacher.im.student.ui;


import com.goodteacher.im.student.R;

import com.goodteacher.im.student.adapter.SoftAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;


public class SoftActivity extends BaseActivity implements OnItemClickListener{
	
	
	private String[] softItemNames = {"意见反馈", "检查更新", "软件设置", "关于我们"};
	private String[] softItemContents = {"", "", "", ""};
	private ListView lvMineSoft;
	
	private SoftAdapter softListAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_soft);
				
		initView();
	}
	
	private void initView() {
		initTopBarForLeft("软件相关");
		lvMineSoft = (ListView) findViewById(R.id.lv_mine_soft);
		softListAdapter = new SoftAdapter(this, softItemNames, softItemContents);
		lvMineSoft.setAdapter(softListAdapter);
		lvMineSoft.setOnItemClickListener(this);
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		switch (position) {
		case 0: 
			Intent toFeedBack = new Intent(SoftActivity.this, FeedBackActivity.class);
			startActivity(toFeedBack);
			break;
		case 1:
			toast("已经是最新版本");
			break;
		case 2:
			break;
		case 3:
			Intent toAboutSoft = new Intent(SoftActivity.this, AboutActivity.class);
			startActivity(toAboutSoft);
			break;

		default:
			break;
		}
		
	}
	
	public void clickSoftBack(View v) {
		finish();
	}
	
	private void toast(String toast) {
		Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
	}
}