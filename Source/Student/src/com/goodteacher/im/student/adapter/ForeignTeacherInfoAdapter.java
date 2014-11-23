package com.goodteacher.im.student.adapter;

import java.util.List;

import android.content.Context;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import cn.bmob.im.bean.BmobRecent;
import cn.bmob.im.config.BmobConfig;
import cn.bmob.im.db.BmobDB;

import com.goodteacher.im.student.R;
import com.goodteacher.im.student.adapter.base.ViewHolder;
import com.goodteacher.im.student.util.FaceTextUtils;
import com.goodteacher.im.student.util.ImageLoadOptions;
import com.goodteacher.im.student.util.TimeUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

/** 会话适配器
  * @ClassName: ForeignTeacherInfoAdapter
  * @Description: TODO
  * @author yaoqiang
  * @date 2014-6-7 下午2:34:10
  */
public class ForeignTeacherInfoAdapter extends ArrayAdapter<BmobRecent> implements Filterable{
	
	private LayoutInflater inflater;
	private List<BmobRecent> mData;
	private Context mContext;
	
	public ForeignTeacherInfoAdapter(Context context, int textViewResourceId, List<BmobRecent> objects) {
		super(context, textViewResourceId, objects);
		inflater = LayoutInflater.from(context);
		this.mContext = context;
		mData = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final BmobRecent item = mData.get(position);
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.item_foreign_teacher, parent, false);
		}
		ImageView iv_teacher_pic = ViewHolder.get(convertView, R.id.iv_teacher_pic);
		TextView tv_teacher_name = ViewHolder.get(convertView, R.id.tv_teacher_name);
		TextView tv_teacher_msg = ViewHolder.get(convertView, R.id.tv_teacher_msg);
		TextView tv_teacher_evaluation = ViewHolder.get(convertView, R.id.tv_teacher_evaluation);
		TextView tv_teacher_location = ViewHolder.get(convertView, R.id.tv_teacher_location);
		
		//填充数据
		String avatar = item.getAvatar();
		if(avatar!=null&& !avatar.equals("")){
			ImageLoader.getInstance().displayImage(avatar, iv_teacher_pic, ImageLoadOptions.getOptions());
		}else{
			iv_teacher_pic.setImageResource(R.drawable.teacher);
		}
		
		tv_teacher_name.setText("Join");
		tv_teacher_evaluation.setText("五星");
		//显示内容
		if(item.getType()==BmobConfig.TYPE_TEXT){
			SpannableString spannableString = FaceTextUtils.toSpannableString(mContext, item.getMessage());
			tv_teacher_msg.setText(spannableString);
		}else if(item.getType()==BmobConfig.TYPE_IMAGE){
			tv_teacher_msg.setText("[图片]");
		}else if(item.getType()==BmobConfig.TYPE_LOCATION){
			String all =item.getMessage();
			if(all!=null &&!all.equals("")){//位置类型的信息组装格式：地理位置&维度&经度
				String address = all.split("&")[0];
				tv_teacher_msg.setText("[位置]"+address);
			}
		}else if(item.getType()==BmobConfig.TYPE_VOICE){
			tv_teacher_msg.setText("[语音]");
		}
		
		int num = BmobDB.create(mContext).getUnreadCount(item.getTargetid());
		tv_teacher_location.setText("英语/美国");
		if (num > 0) {
			tv_teacher_location.setVisibility(View.VISIBLE);
		} else {
			tv_teacher_location.setVisibility(View.VISIBLE);
		}
		return convertView;
	}

}
