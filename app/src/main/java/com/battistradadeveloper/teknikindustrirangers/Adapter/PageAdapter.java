package com.battistradadeveloper.teknikindustrirangers.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.battistradadeveloper.teknikindustrirangers.Fragment.RegisterFragment.RegisterAlumni;
import com.battistradadeveloper.teknikindustrirangers.Fragment.RegisterFragment.RegisterMahasiswa;

public class PageAdapter extends FragmentPagerAdapter {
	private int numOfTabs;

	public PageAdapter(FragmentManager fm, int numOfTabs) {
		super(fm);
		this.numOfTabs = numOfTabs;
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {
			case 0:
				return new RegisterMahasiswa();
			case 1:
				return new RegisterAlumni();
			default:
				return null;
		}
	}

	@Override
	public int getCount() {
		return numOfTabs;
	}
}
