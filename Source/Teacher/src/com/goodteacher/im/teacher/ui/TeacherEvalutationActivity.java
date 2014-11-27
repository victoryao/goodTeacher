package com.goodteacher.im.teacher.ui;



import android.os.Bundle;

import com.goodteacher.im.teacher.R;

/**
 * @ClassName: TeacherInfoActivity
 * @Description: TODO
 * @author yaoqiang
 * @date 2014-6-23 下午3:28:49
 */
public class TeacherEvalutationActivity extends ActivityBase {

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_teacher_evaluation);
		initTopBarForLeft("老师评价");
	}
	
	

}
