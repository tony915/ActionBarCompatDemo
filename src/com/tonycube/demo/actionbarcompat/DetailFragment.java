package com.tonycube.demo.actionbarcompat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFragment extends Fragment {
	
	public static final String DETAIL_VALUE = "detail_value";
	
	private MainActivity activity;
	private String value = "";

	public static DetailFragment create(Bundle bdl){
		DetailFragment detailFragment = new DetailFragment();
		detailFragment.setArguments(bdl);
		return detailFragment;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		activity = (MainActivity) this.getActivity();
		
		getArgumentsValue();
		initActionBar();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		return initView(inflater, container);
	}

	private void initActionBar() {
		ActionBar actionBar = activity.getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setHomeButtonEnabled(true);
	}

	private View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater.inflate(R.layout.fragment_detail, container, false);
		
		TextView txtValue = (TextView) view.findViewById(R.id.txtValue);
		txtValue.setText(value);
		
		return view;
	}
	
	private void getArgumentsValue(){
		value = this.getArguments().getString(DETAIL_VALUE);
	}
}
