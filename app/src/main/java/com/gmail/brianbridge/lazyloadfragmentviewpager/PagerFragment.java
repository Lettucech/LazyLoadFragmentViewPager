package com.gmail.brianbridge.lazyloadfragmentviewpager;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PagerFragment extends LazyLoadFragment {
	public static final String TAG = PagerFragment.class.getSimpleName();

	public static PagerFragment newInstance(String title) {
		Bundle args = new Bundle();
		PagerFragment fragment = new PagerFragment();

		args.putString("title", title);
		fragment.setArguments(args);
		return fragment;
	}

	private String title;
	private TextView textView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		title = getArguments().getString("title");
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_pager, container, false);
		((TextView)view.findViewById(R.id.textView)).setText(title);
		return view;
	}

	@Override
	public void fetchData() {
		Log.d(TAG, "fetchData() in Fragment " + title);
	}
}
