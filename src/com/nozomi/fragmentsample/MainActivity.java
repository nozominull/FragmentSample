package com.nozomi.fragmentsample;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends FragmentActivity {

	private FragmentManager fm = null;
	private BackFragment currentFragment = null;
	private FirstFragment firstFragment = null;
	private SecondFragment secondFragment = null;
	private ThirdFragment thirdFragment = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);

		fm = getSupportFragmentManager();

		initView();

	}

	private void initView() {
		Button firstView = (Button) findViewById(R.id.first);
		firstView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				setFrament("FirstFragment", null);
			}
		});

		Button secondView = (Button) findViewById(R.id.second);
		secondView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				setFrament("SecondFragment", null);
			}
		});

		setFrament("FirstFragment", null);
	}

	public void setFrament(String name, Bundle bundle) {
		if (name.equals("FirstFragment")) {
			if (firstFragment == null) {
				firstFragment = new FirstFragment();
			}
			currentFragment = firstFragment;
		} else if (name.equals("SecondFragment")) {
			if (secondFragment == null) {
				secondFragment = new SecondFragment();
			}
			currentFragment = secondFragment;
		} else if (name.equals("ThirdFragment")) {
			if (thirdFragment == null) {
				thirdFragment = new ThirdFragment();
			}
			currentFragment = thirdFragment;
		}

		currentFragment.setBundle(bundle);
		FragmentTransaction ft = fm.beginTransaction();
		ft.replace(R.id.main_content, currentFragment);
		ft.commit();
	}

	@Override
	public void onBackPressed() {
		currentFragment.onBackPressed();
	}

}
