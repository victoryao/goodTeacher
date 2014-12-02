package com.goodteacher.im.student.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.bmob.v3.datatype.BmobGeoPoint;

import com.goodteacher.im.student.CustomApplcation;
import com.goodteacher.im.student.R;
import com.goodteacher.im.student.adapter.base.BaseListAdapter;
import com.goodteacher.im.student.adapter.base.ViewHolder;
import com.goodteacher.im.student.bean.User;
import com.goodteacher.im.student.util.ImageLoadOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * 外教列表Adapter
 * 
 * @ClassName: BlackListAdapter
 * @Description: TODO
 * @author smile
 * @date 2014-6-24 下午5:27:14
 */
public class TeacherListAdapter extends BaseListAdapter<User> {

	public TeacherListAdapter(Context context, List<User> list) {
		super(context, list);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View bindView(int arg0, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_near_people, null);
		}
		final User contract = getList().get(arg0);
		TextView tv_name = ViewHolder.get(convertView, R.id.tv_name);
		TextView tv_logintime = ViewHolder.get(convertView, R.id.tv_logintime);
		ImageView iv_avatar = ViewHolder.get(convertView, R.id.iv_avatar);
		String avatar = contract.getAvatar();
		if (avatar != null && !avatar.equals("")) {
			ImageLoader.getInstance().displayImage(avatar, iv_avatar,
					ImageLoadOptions.getOptions());
		} else {
			iv_avatar.setImageResource(R.drawable.default_head);
		}
		
		tv_name.setText(contract.getUsername());
		tv_logintime.setText("最近登录时间:"+contract.getUpdatedAt());
		return convertView;
	}

}
