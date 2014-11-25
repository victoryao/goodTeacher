package com.goodteacher.im.student.ui;

import android.os.Bundle;
import android.widget.EditText;
import cn.bmob.v3.listener.UpdateListener;

import com.goodteacher.im.student.R;
import com.goodteacher.im.student.bean.User;
import com.goodteacher.im.student.view.HeaderLayout.onRightImageButtonClickListener;

/**
 * ���õ绰����
 * 
 * @ClassName: UpdatePhoneActivity
 * @Description: TODO
 * @author smile
 * @date 2014-6-7 ����4:03:40
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
		initTopBarForBoth("�޸ĵ绰", R.drawable.base_action_bar_true_bg_selector,
				new onRightImageButtonClickListener() {

					@Override
					public void onClick() {
						// TODO Auto-generated method stub
						String phone = edit_phone.getText().toString();
						if (phone.equals("")) {
							ShowToast("����д�绰!");
							return;
						}
						updateInfo(phone);
					}
				});
		edit_phone = (EditText) findViewById(R.id.edit_phone);
	}

	/** �޸�����
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
				ShowToast("�޸ĳɹ�:"+u.getPhone());
				finish();
			}

			@Override
			public void onFailure(int arg0, String arg1) {
				// TODO Auto-generated method stub
				ShowToast("�绰�����޸�ʧ��:" + arg1);
			}
		});
	}
}
