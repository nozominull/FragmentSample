package com.nozomi.fragmentsample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ThirdFragment extends BackFragment {

	private int value = 0;;

	@Override
	public void setBundle(Bundle bundle) {
		if(bundle!=null){
		value = bundle.getInt("value");
		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.third_fragment, container, false);

		initView(view);

		return view;
	}

	private void initView(View view) {
		TextView valueView = (TextView) view.findViewById(R.id.value);
		valueView.setText(String.valueOf(value));

		Button refreshView = (Button) view.findViewById(R.id.refresh);
		refreshView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				((MainActivity) getActivity())
						.setFrament("ThirdFragment", null);
			}
		});

		Button backView = (Button) view.findViewById(R.id.back);
		backView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				onBackPressed();
			}
		});
	}

	@Override
	public void onBackPressed() {
		((MainActivity) getActivity()).setFrament("FirstFragment", null);
	}
}