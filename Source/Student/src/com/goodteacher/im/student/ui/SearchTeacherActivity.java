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
 * 匹配的外教列表
 * 
 * @ClassName: SearchTeacherActivity
 * @Description: TODO
 * @date 2014-6-6 下午4:28:09
 */
public class SearchTeacherActivity extends ActivityBase implements IXListViewListener,OnItemClickListener {

	XListView mListView;
	TeacherListAdapter adapter;
	String from = "";
	
	//以下为查找条件
	/**************************begin***********************************/
	int sex = 2 ; //0： 女性，1：男性，2：所有			
	String lang = ""; //对外教是母语，对学生是想学习的语言		
	int minage = 0; //查找最小年龄  
	int maxage = 0; //查找最大年龄，0：最大年龄没有上限	
	String nationality = "";//国籍	
	String city = "";//当前居住城市，对于外教是指在中国的居住城市	
	String school = "";//外教或者学生当前在中国就读的学校。
	/****************************end*********************************/
		
	List<User> lists = new ArrayList<User>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_teacher);
		initView();
	}

	private void initView() {
		initTopBarForLeft("查找外教");
		initXListView();
	}
	
	//获取Intend携带的查询数据
	private void setSearchCondition(){
		
	}

	private void initXListView() {
		mListView = (XListView) findViewById(R.id.list_near);
		mListView.setOnItemClickListener(this);
		// 首先不允许加载更多
		mListView.setPullLoadEnable(false);
		// 允许下拉
		mListView.setPullRefreshEnable(true);
		// 设置监听器
		mListView.setXListViewListener(this);
		//
		mListView.pullRefreshing();
		
		adapter = new TeacherListAdapter(this, lists);
		mListView.setAdapter(adapter);
		setSearchCondition();
		initSearchTeacherList(false);
	}
	
	private void setQueryParam(BmobQuery<User> query,int page){
		query.addWhereEqualTo("isTeacher", true);
		if(lang != ""){
			query.addWhereEqualTo("lang", lang);
		}
		if(sex != 2){
			query.addWhereEqualTo("sex", sex == 0 ? false : true);
		}
		if(nationality != ""){
			query.addWhereEqualTo("nationality", nationality);
		}
		if(city != ""){
			query.addWhereEqualTo("city", city);
		}
		if(school != ""){
			query.addWhereContains("school", school);
		}
		if(minage > 0){
			query.addWhereGreaterThanOrEqualTo("age", minage);
		}
		if(maxage > 0){
			query.addWhereLessThanOrEqualTo("age", maxage);
		}
		query.setLimit(10);			//每页10个
		query.setSkip(page);
	}

	
	int curPage = 0;
	ProgressDialog progress ;
	
	/**********************************************************************
	 * 以下代码是如何获取匹配的外交的代码
	 ***********************************************************************/
	private void initSearchTeacherList(final boolean isUpdate) {
		if (!isUpdate) {
			progress = new ProgressDialog(SearchTeacherActivity.this);
			progress.setMessage("正在查询匹配的外教...");
			progress.setCanceledOnTouchOutside(true);
			progress.show();
		}
	
		// 获取语言匹配的外教列表
		BmobQuery<User> query = new BmobQuery<User>();
		setQueryParam(query,0);	
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
						ShowToast("匹配的外教搜索完成!");
					} else {
						mListView.setPullLoadEnable(true);
					}
				} else {
					ShowToast("暂无匹配的外教!");
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
				ShowToast("暂无匹配的外教!");
				mListView.setPullLoadEnable(false);
				if (!isUpdate) {
					progress.dismiss();
				} else {
					refreshPull();
				}
			}

		});
	}
		
	/** 查询更多
	  * @Title: queryMoreNearList
	  * @Description: TODO
	  * @param @param page 
	  * @return void
	  * @throws
	  */
	private void queryMoreList(int page){
	
		BmobQuery<User> query = new BmobQuery<User>();
		setQueryParam(query,page);	
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
				ShowLog("查询更多匹配的外教出错:"+arg1);
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
		initSearchTeacherList(true);
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
		// 获取用户
		User user = userManager.getCurrentUser(User.class);
		// 获取语言匹配的外教列表
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
					ShowToast("数据加载完成");
					mListView.setPullLoadEnable(false);
					refreshLoad();
				}
				
			}
			
			@Override
			public void onFailure(int arg0, String arg1) {
				// TODO Auto-generated method stub
				ShowLog("查询匹配的外教总数失败"+arg1);
				refreshLoad();			
			}
		});
	}		
}
