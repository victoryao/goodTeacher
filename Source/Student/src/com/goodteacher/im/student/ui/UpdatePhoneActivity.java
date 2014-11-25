package com.goodteacher.im.student.ui;

import android.os.Bundle;
import android.widget.EditText;
import cn.bmob.v3.listener.UpdateListener;

import com.goodteacher.im.student.R;
import com.goodteacher.im.student.bean.User;
import com.goodteacher.im.student.view.HeaderLayout.onRightImageButtonClickListener;

/**
 * 设置电话号码
 * 
 * @ClassName: UpdatePhoneActivity
 * @Description: TODO
 * @author smile
 * @date 2014-6-7 下午4:03:40
 */
public class UpdatePhoneActivity extends ActivityBase {

	EditText edit_phone;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_set_updatephone);
		initView();
	}

	private void initView() {
		initTopBarForBoth("修改电话", R.drawable.base_action_bar_true_bg_selector,
				new onRightImageButtonClickListener() {

					@Override
					public void onClick() {
						// TODO Auto-generated method stub
						String phone = edit_phone.getText().toString();
						if (phone.equals("")) {
							ShowToast("请填写电话!");
							return;
						}
						updateInfo(phone);
					}
				});
		edit_phone = (EditText) findViewById(R.id.edit_phone);
	}

	/** 修改资料
	  * updateInfo
	  * @Title: updateInfo
	  * @return void
	  * @throws
	  */
	private void updateInfo(String phone) {
		final User user = userManager.getCurrentUser(User.class);
		user.setPhone(phone);
		user.update(this, new UpdateListener() {

			@Override
			public void onSuccess() {
				// TODO Auto-generated method stub
				final User u = userManager.getCurrentUser(User.class);
				ShowToast("修改成功:"+u.getPhone());
				finish();
			}

			@Override
			public void onFailure(int arg0, String arg1) {
				// TODO Auto-generated method stub
				ShowToast("电话号码修改失败:" + arg1);
			}
		});
	}
}
