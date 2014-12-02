package com.goodteacher.im.student.ui;

import java.util.ArrayList;
import java.util.List;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import cn.bmob.im.task.BRequest;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.CountListener;
import cn.bmob.v3.listener.FindListener;

import com.goodteacher.im.student.R;
import com.goodteacher.im.student.adapter.NearPeopleAdapter;
import com.goodteacher.im.student.adapter.TeacherListAdapter;
import com.goodteacher.im.student.bean.User;
import com.goodteacher.im.student.util.CollectionUtils;
import com.goodteacher.im.student.view.xlist.XListView;
import com.goodteacher.im.student.view.xlist.XListView.IXListViewListener;

/**
 * ƥ�������б�
 * 
 * @ClassName: MatchTeacherActivity
 * @Description: TODO
 * @date 2014-6-6 ����4:28:09
 */
public class MatchTeacherActivity extends ActivityBase implements IXListViewListener,OnItemClickListener {

	XListView mListView;
	TeacherListAdapter adapter;
	String from = "";

	List<User> lists = new ArrayList<User>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_near_people);
		initView();
	}

	private void initView() {
		initTopBarForLeft("ƥ������");
		initXListView();
	}

	private void initXListView() {
		mListView = (XListView) findViewById(R.id.list_near);
		mListView.setOnItemClickListener(this);
		// ���Ȳ�������ظ���
		mListView.setPullLoadEnable(false);
		// ��������
		mListView.setPullRefreshEnable(true);
		// ���ü�����
		mListView.setXListViewListener(this);
		//
		mListView.pullRefreshing();
		
		adapter = new TeacherListAdapter(this, lists);
		mListView.setAdapter(adapter);
		initMatchTeacherList(false);
	}

	
	int curPage = 0;
	ProgressDialog progress ;
	
	/**********************************************************************
	 * ���´�������λ�ȡƥ����⽻�Ĵ���
	 ***********************************************************************/
	private void initMatchTeacherList(final boolean isUpdate) {
		if (!isUpdate) {
			progress = new ProgressDialog(MatchTeacherActivity.this);
			progress.setMessage("���ڲ�ѯƥ������...");
			progress.setCanceledOnTouchOutside(true);
			progress.show();
		}
		// ��ȡ�û�
		User user = userManager.getCurrentUser(User.class);
		// ��ȡ����ƥ�������б�
		BmobQuery<User> query = new BmobQuery<User>();
		query.addWhereEqualTo("isTeacher", true);
		query.addWhereEqualTo("lang", user.getLang());
		query.setLimit(10);			//ÿҳ10��	
		query.findObjects(this, new FindListener<User>() {

			@Override
			public void onSuccess(List<User> arg0) {
				// TODO Auto-generated method stub
				if (CollectionUtils.isNotNull(arg0)) {
					if (isUpdate) {
						lists.clear();
					}
					adapter.addAll(arg0);
					if (arg0.size() < BRequest.QUERY_LIMIT_COUNT) {
						mListView.setPullLoadEnable(false);
						ShowToast("ƥ�������������!");
					} else {
						mListView.setPullLoadEnable(true);
					}
				} else {
					ShowToast("����ƥ������!");
				}

				if (!isUpdate) {
					progress.dismiss();
				} else {
					refreshPull();
				}
			}

			@Override
			public void onError(int arg0, String arg1) {
				// TODO Auto-generated method stub
				ShowToast("����ƥ������!");
				mListView.setPullLoadEnable(false);
				if (!isUpdate) {
					progress.dismiss();
				} else {
					refreshPull();
				}
			}

		});
	}
		
	/** ��ѯ����
	  * @Title: queryMoreNearList
	  * @Description: TODO
	  * @param @param page 
	  * @return void
	  * @throws
	  */
	private void queryMoreList(int page){
	
		// ��ȡ�û�
		User user = userManager.getCurrentUser(User.class);
		// ��ȡ����ƥ�������б�
		BmobQuery<User> query = new BmobQuery<User>();
		query.addWhereEqualTo("isTeacher", true);
		query.addWhereEqualTo("lang", user.getLang());
		query.setLimit(10);			//ÿҳ10��
		query.setSkip(page);
		query.findObjects(this, new FindListener<User>() {
			@Override
			public void onSuccess(List<User> arg0) {
				// TODO Auto-generated method stub
				if (CollectionUtils.isNotNull(arg0)) {
					adapter.addAll(arg0);
				}
				refreshLoad();
			}
			
			@Override
			public void onError(int arg0, String arg1) {
				// TODO Auto-generated method stub
				ShowLog("��ѯ����ƥ�����̳���:"+arg1);
				mListView.setPullLoadEnable(false);
				refreshLoad();
			}

		});
	}
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		// TODO Auto-generated method stub
		User user = (User) adapter.getItem(position-1);
		Intent intent =new Intent(this,SetMyInfoActivity.class);
		intent.putExtra("from", "add");
		intent.putExtra("username", user.getUsername());
		startAnimActivity(intent);		
	}

	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub
		initMatchTeacherList(true);
	}

	private void refreshLoad(){
		if (mListView.getPullLoading()) {
			mListView.stopLoadMore();
		}
	}
	
	private void refreshPull(){
		if (mListView.getPullRefreshing()) {
			mListView.stopRefresh();
		}
	}
	@Override
	public void onLoadMore() {
		// TODO Auto-generated method stub
		// ��ȡ�û�
		User user = userManager.getCurrentUser(User.class);
		// ��ȡ����ƥ�������б�
		BmobQuery<User> query = new BmobQuery<User>();
		query.addWhereEqualTo("isTeacher", true);
		query.addWhereEqualTo("lang", user.getLang());	
		query.count(this,User.class, new CountListener() {
			
			@Override
			public void onSuccess(int arg0) {
				// TODO Auto-generated method stub
				if(arg0 >lists.size()){
					curPage++;
					queryMoreList(curPage);
				}else{
					ShowToast("���ݼ������");
					mListView.setPullLoadEnable(false);
					refreshLoad();
				}
				
			}
			
			@Override
			public void onFailure(int arg0, String arg1) {
				// TODO Auto-generated method stub
				ShowLog("��ѯƥ����������ʧ��"+arg1);
				refreshLoad();			
			}
		});
	}		
}
