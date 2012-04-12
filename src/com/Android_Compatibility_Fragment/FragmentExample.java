package com.Android_Compatibility_Fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class FragmentExample extends Fragment {
	private int nAndroids = 0;
	public FragmentExample() {}
	public FragmentExample(int nAndroids) {this.nAndroids = nAndroids;}
	public void onCreate(Bundle saved) {
		super.onCreate(saved);
		if (null != saved) {nAndroids = saved.getInt("nAndroids");}}
	public void onSaveInstanceState(Bundle toSave) {toSave.putInt("nAndroids", nAndroids);}
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle saved) { View myView = null;
		switch (nAndroids) {
		case 0:
			myView = inflater.inflate(R.layout.main, container, false);
			break;
		case 1:
			myView = inflater.inflate(R.layout.cupcake, container, false);
			break;
		case 2:
			myView = inflater.inflate(R.layout.dounut, container, false);
			break;
		case 3:
			myView = inflater.inflate(R.layout.eclair, container, false);
			break;
		}
		return myView;
	}
}


