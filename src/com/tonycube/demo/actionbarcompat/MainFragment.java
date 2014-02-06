package com.tonycube.demo.actionbarcompat;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainFragment extends Fragment {
	
	private MainActivity activity;
	
	public static MainFragment create(){
		MainFragment mainFragment = new MainFragment();
		return mainFragment;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		activity = (MainActivity) this.getActivity();
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		ActionBar actionBar = activity.getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(false);
		actionBar.setHomeButtonEnabled(false);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		return initView(inflater, container);
	}

	private View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater.inflate(R.layout.fragment_main, container, false);
		
		Button btnOpenTab = (Button) view.findViewById(R.id.btnOpenTab);
		btnOpenTab.setOnClickListener(onClickOpenTab);
		
		Button btnOpenDetail = (Button) view.findViewById(R.id.btnOpenDetail);
		btnOpenDetail.setOnClickListener(onClickOpenDetail);
		
		return view;
	}
	
	private OnClickListener onClickOpenTab = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(activity, TabActivity.class);
			activity.startActivity(intent);
		}
	};
	
	private OnClickListener onClickOpenDetail = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			FragmentManager fragmentManager = activity.getSupportFragmentManager();
			Bundle bdl = new Bundle();
			bdl.putString(DetailFragment.DETAIL_VALUE, "ABC-123-(*.*)y");
			
			FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
			fragmentTransaction.replace(R.id.content_frame, DetailFragment.create(bdl));
			fragmentTransaction.addToBackStack("detail");
			fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
			fragmentTransaction.commit();
		}
	};
	
}
