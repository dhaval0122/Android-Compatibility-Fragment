package com.Android_Compatibility_Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AndroidCompatibilityFragmentActivity extends FragmentActivity {
	private ListView list_v_;
	String items[] = { "Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread",
			"Honeycomb", "Ice Cream Sandwich" };
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_one);
		FragmentTransaction fragmentTransaction = getSupportFragmentManager()
				.beginTransaction();
		// add a fragment
		myfregment myFragment = new myfregment();
		fragmentTransaction.add(R.id.myfragment, myFragment);
		fragmentTransaction.commit();
		list_v_ = (ListView) findViewById(R.id.list_v);
		list_v_.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, items));
		list_v_.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
					long arg3) {
				// TODO Auto-generated method stub
				stackAFragment(pos + 1);
			}
		});
	}
	
	
	protected void stackAFragment(int i) {
		// TODO Auto-generated method stub
		Fragment f = new FragmentExample(i);

		android.app.FragmentTransaction ft = getFragmentManager()
				.beginTransaction();
		ft.replace(R.id.myfragment, f);
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		ft.addToBackStack(null);
		ft.commit();
	}

}
