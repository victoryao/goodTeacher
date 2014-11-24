package com.goodteacher.im.student.ui;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

import com.goodteacher.im.student.R;


import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class FeedBackActivity extends Activity implements OnClickListener{
	
	@SuppressWarnings("unused")
	private static final String TAG = "FeedBackActivity";
	
	private EditText etContent;
	private Button btnSubmit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feed_back);
		
		initView();
	}
	
	private void initView() {
		etContent = (EditText) findViewById(R.id.et_feedback_content);
		btnSubmit = (Button) findViewById(R.id.btn_feedback_submit);
		btnSubmit.setOnClickListener(this);
	}
	
	/**
	 * �ύ�û��ķ�����Ϣ
	 */
	private void submit() {
		String content = etContent.getText().toString();
		if(content.equals("")) {
			toast("�ף�����д�㶫����");
		} else {
			BmobUser user = BmobUser.getCurrentUser(this);
//			FeedBack fb = new FeedBack();
//			fb.setUsername(user.getUsername());
//			fb.setEmail(user.getEmail());
//			fb.setContent(content);
//			fb.save(this, new SaveListener() {
//				
//				@Override
//				public void onSuccess() {
//					toast("�ύ�ɹ�, ���ǻᾡ��ظ�");
//					back();
//				}
//				
//				@Override
//				public void onFailure(int arg0, String msg) {
//					toast("�ύʧ��");
//				}
//				
//			});
			
		}
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_feedback_submit:
			submit();
			break;

		default:
			break;
		}
	}
	
	private void back() {
		finish();
	}
	
	public void clickFeedBack(View v) {
		finish();
	}
	
	private void toast(String toast) {
		Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
	}
	

}