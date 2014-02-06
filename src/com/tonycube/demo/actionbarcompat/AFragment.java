package com.tonycube.demo.actionbarcompat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AFragment extends Fragment implements TabListener {

	private Fragment mFragment;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.fragment_a, container, false);
		return view;
	}

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		mFragment = new AFragment();
		ft.add(android.R.id.content, mFragment);
		ft.attach(mFragment);
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		if (mFragment != null) {
			ft.remove(mFragment);
		}
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		if (mFragment != null) {
			mFragment = null;
		}
	}
	
}
