package com.gmail.brianbridge.lazyloadfragmentviewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

public abstract class LazyLoadFragment extends Fragment {
	public static final String TAG = LazyLoadFragment.class.getSimpleName();
	protected boolean isViewInitiated;
	protected boolean isVisibleToUser;
	protected boolean isDataInitiated;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		isViewInitiated = true;
		prepareFetchData();
	}

	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		super.setUserVisibleHint(isVisibleToUser);
		this.isVisibleToUser = isVisibleToUser;
		prepareFetchData();
	}

	public abstract void fetchData();

	public boolean prepareFetchData() {
		return prepareFetchData(false);
	}

	public boolean prepareFetchData(boolean forceUpdate) {
		if (isVisibleToUser && isViewInitiated && (!isDataInitiated || forceUpdate)) {
			fetchData();
			isDataInitiated = true;
			return true;
		}
		return false;
	}
}
