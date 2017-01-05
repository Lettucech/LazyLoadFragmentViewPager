package com.gmail.brianbridge.lazyloadfragmentviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class PagerAdapter extends EnhancedFragmentPagerAdapter {
	public PagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		return PagerFragment.newInstance("Fragment " + position);
	}

	@Override
	public int getCount() {
		return 5;
	}
}
