package com.goodteacher.im.teacher.ui.fragment;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import cn.bmob.im.bean.BmobChatUser;
import cn.bmob.im.bean.BmobRecent;
import cn.bmob.im.db.BmobDB;

import com.goodteacher.im.teacher.R;
import com.goodteacher.im.teacher.adapter.ForeignTeacherInfoAdapter;
import com.goodteacher.im.teacher.ui.FragmentBase;
import com.goodteacher.im.teacher.ui.TeacherInfoActivity;
import com.goodteacher.im.teacher.view.ClearEditText;

public class ForeignTeacherFragment extends FragmentBase implements OnItemClickListener{
	ClearEditText mClearEditText;
	
	ListView listview;
	
	ForeignTeacherInfoAdapter adapter;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_foreign_teacher, container, false);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		initView();
	}
	
	private void initView(){
		initTopBarForOnlyTitle("我的外教");
		listview = (ListView)findViewById(R.id.list);
		listview.setOnItemClickListener(this);
		List<BmobRecent> recentList = BmobDB.create(getActivity()).queryRecents();
		BmobRecent r = new BmobRecent();
		r.setUserName("1");
		recentList.add(r);
		adapter = new ForeignTeacherInfoAdapter(getActivity(), R.layout.item_foreign_teacher, recentList);
		listview.setAdapter(adapter);
		
		mClearEditText = (ClearEditText)findViewById(R.id.et_msg_search);
		mClearEditText.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				adapter.getFilter().filter(s);
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}

			@Override
			public void afterTextChanged(Editable s) {
			}
		});
		
	}
	
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		// TODO Auto-generated method stub
		BmobRecent recent = adapter.getItem(position);
		//重置未读消息
		BmobDB.create(getActivity()).resetUnread(recent.getTargetid());
		//组装聊天对象
		BmobChatUser user = new BmobChatUser();
		user.setAvatar(recent.getAvatar());
		user.setNick(recent.getNick());
		user.setUsername(recent.getUserName());
		user.setObjectId(recent.getTargetid());
		Intent intent = new Intent(getActivity(), TeacherInfoActivity.class);
		intent.putExtra("user", user);
		startAnimActivity(intent);
	}
	
	private boolean hidden;
	@Override
	public void onHiddenChanged(boolean hidden) {
		super.onHiddenChanged(hidden);
		this.hidden = hidden;
		if(!hidden){
			refresh();
		}
	}
	
	public void refresh(){
		try {
			getActivity().runOnUiThread(new Runnable() {
				public void run() {
					List<BmobRecent> recentList = BmobDB.create(getActivity()).queryRecents();
					BmobRecent r = new BmobRecent();
					r.setUserName("1");
					recentList.add(r);
					adapter = new ForeignTeacherInfoAdapter(getActivity(), R.layout.item_foreign_teacher, recentList);
					listview.setAdapter(adapter);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void onResume() {
		super.onResume();
		if(!hidden){
			refresh();
		}
	}


}
