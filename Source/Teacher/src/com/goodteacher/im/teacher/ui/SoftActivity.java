package com.goodteacher.im.teacher.ui;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.goodteacher.im.teacher.R;
import com.goodteacher.im.teacher.adapter.SoftAdapter;


public class SoftActivity extends BaseActivity implements OnItemClickListener{
	
	
	private String[] softItemNames = {"意见反馈", "检查更新", "关于我们"};
	private String[] softItemContents = {"", "", ""};
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
			ShowToast("已经是最新版本");
			break;
		case 2:
			Intent toAboutSoft = new Intent(SoftActivity.this, AboutActivity.class);
			startActivity(toAboutSoft);
			break;

		default:
			break;
		}
		
	}
	
}