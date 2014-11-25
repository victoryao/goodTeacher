package com.goodteacher.im.student.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.goodteacher.im.student.R;

/**
 * @ClassName: TeacherInfoActivity
 * @Description: TODO
 * @author yaoqiang
 * @date 2014-6-23 下午3:28:49
 */
public class TeacherInfoActivity extends ActivityBase implements
		OnClickListener {

	Button reservebtn, cancelbtn;
	Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_teacher_info);
		initTopBarForLeft("外教详情");
		reservebtn = (Button) findViewById(R.id.reservebtn);
		cancelbtn = (Button) findViewById(R.id.cancelbtn);

		reservebtn.setOnClickListener(this);
		cancelbtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.reservebtn:// 发起聊天
			intent = new Intent(this, ChatActivity.class);
			startAnimActivity(intent);
			break;
		case R.id.cancelbtn:
			intent = new Intent(this, TeacherEvalutationActivity.class);
			startAnimActivity(intent);
			break;
		}
	}

}
