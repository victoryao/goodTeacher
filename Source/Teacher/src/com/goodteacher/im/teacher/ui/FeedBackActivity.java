package com.goodteacher.im.teacher.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

import com.goodteacher.im.teacher.R;
import com.goodteacher.im.teacher.bean.FeedBack;



public class FeedBackActivity extends BaseActivity implements OnClickListener{
	
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
		initTopBarForLeft("�������");
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
			ShowToast("�ף�����д�㶫����");
		} else {
			BmobUser user = BmobUser.getCurrentUser(this);
			FeedBack fb = new FeedBack();
			fb.setUsername(user.getUsername());
			fb.setEmail(user.getEmail());
			fb.setContent(content);
			fb.save(this, new SaveListener() {
				
				@Override
				public void onSuccess() {
					ShowToast("�ύ�ɹ�, ���ǻᾡ��ظ�");
					back();
				}
				
				@Override
				public void onFailure(int arg0, String msg) {
					ShowToast("�ύʧ��");
				}
				
			});
			
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
	
}