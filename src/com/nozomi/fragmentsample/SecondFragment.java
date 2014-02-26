package com.nozomi.fragmentsample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SecondFragment extends BackFragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater
				.inflate(R.layout.second_fragment, container, false);

		initView(view);

		return view;
	}

	private void initView(View view) {

	}

	@Override
	public void onBackPressed() {
		((MainActivity) getActivity()).setFrament(
				MainActivity.FragmentName.FirstFragment, null);
	}
}