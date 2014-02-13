package com.nozomi.fragmentsample;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public abstract class BackFragment extends Fragment {
	public abstract void onBackPressed();

	public abstract void setBundle(Bundle bundle);

}
