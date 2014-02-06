package com.tonycube.demo.actionbarcompat;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;

public class TabActivity extends ActionBarActivity  {

	private Tab tab;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab);
		
		initActionBar();
	}
	
	

	private void initActionBar() {
		ActionBar actionBar = this.getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		actionBar.setDisplayShowHomeEnabled(true);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setIcon(R.drawable.ic_launcher);
		actionBar.setTitle("ActionBarCompat Demo");
		
		//create Actionbar Tabs
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		//first tab
		tab = actionBar.newTab().setTabListener(new AFragment());
		tab.setText("TAB A");
		actionBar.addTab(tab);
		
		//second tab
		tab = actionBar.newTab().setTabListener(new BFragment());
		tab.setText("TAB B");
		actionBar.addTab(tab);
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch(item.getItemId()){
	    	case android.R.id.home:
		    	this.finish();
		    	break;
	    }
	 
	    return false;
	}
	
}
