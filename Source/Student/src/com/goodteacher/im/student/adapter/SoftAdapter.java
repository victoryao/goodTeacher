package com.goodteacher.im.student.adapter;

import com.goodteacher.im.student.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class SoftAdapter extends BaseAdapter {
	
	@SuppressWarnings("unused")
	private Context mContext;
	
	private String[] mItemNames; 		
	private String[] mItemContents;		
	private LayoutInflater mInflater = null;
	
	public SoftAdapter(Context context, String[] names, String[] contents) {
		mContext = context;
		mItemNames = names;
		mItemContents = contents;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return mItemNames.length;
	}

	@Override
	public Object getItem(int position) {
		return mItemNames[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		SoftHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.mine_soft_list_item, null);
			holder = new SoftHolder();
			holder.tvItemName = (TextView) convertView
					.findViewById(R.id.tv_item_name);
			holder.tvItemContent = (TextView) convertView.findViewById(R.id.tv_item_content);
			convertView.setTag(holder);
		} else {
			holder = (SoftHolder) convertView.getTag();
		}
		holder.tvItemName.setText(mItemNames[position]);
		holder.tvItemContent.setText(mItemContents[position]);
		return convertView;
	}

}
