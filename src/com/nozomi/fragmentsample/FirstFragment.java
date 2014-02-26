package com.nozomi.fragmentsample;

import java.util.Random;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class FirstFragment extends BackFragment {

	private Random random = new Random();
	private int value = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.first_fragment, container, false);

		initView(view);

		return view;
	}

	private void initView(View view) {
		Button initValueView = (Button) view.findViewById(R.id.init_value);
		initValueView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				value = random.nextInt();
				Toast.makeText(getActivity(), String.valueOf(value),
						Toast.LENGTH_SHORT).show();
			}
		});

		Button jump2thirdView = (Button) view.findViewById(R.id.jump2third);
		jump2thirdView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Bundle bundle = new Bundle();
				bundle.putInt("value", value);

				((MainActivity) getActivity()).setFrament(
						MainActivity.FragmentName.ThirdFragment, bundle);
			}
		});
	}

	@Override
	public void onBackPressed() {
		getActivity().finish();
	}
}