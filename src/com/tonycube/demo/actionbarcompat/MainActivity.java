package com.tonycube.demo.actionbarcompat;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity  {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initView();
		
//		ActionBar actionBar = this.getSupportActionBar();
//		actionBar.setTitle("ABC");
//		actionBar.setIcon(R.drawable.ic_launcher);
//		actionBar.setDisplayHomeAsUpEnabled(false);
//		actionBar.setHomeButtonEnabled(false);
//		actionBar.hide();
	}
	
	private void initView(){
		setContentView(R.layout.fragment_content);
		initFragment();
	}
	
	private void initFragment() {
		MainFragment mainFragment = (MainFragment) MainFragment.create();
		
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.replace(R.id.content_frame, mainFragment, "main");
		fragmentTransaction.commit();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch(item.getItemId()){
	    	case android.R.id.home:
	    		FragmentManager fm = getSupportFragmentManager();
	    		if(fm.getBackStackEntryCount() > 0){
	    		   fm.popBackStack();
	    		}
	    		break;
	    	
	        case R.id.action_refresh:
	            Toast.makeText(this, "Refresh", Toast.LENGTH_SHORT).show();
	            return true;
	    }
	 
	    return false;
	}
	
}
