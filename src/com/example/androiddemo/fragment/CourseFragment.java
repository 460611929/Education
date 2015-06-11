package com.example.androiddemo.fragment;

import com.example.androiddemo.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class CourseFragment extends Fragment
{

	Fragment[] mFragments;
	private FragmentTransaction transaction;

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{

		View view = inflater.inflate(R.layout.fragment_cource, container, false);
		RadioGroup rg = (RadioGroup) view.findViewById(R.id.rg);
		rg.setOnCheckedChangeListener(listener);

		mFragments = new Fragment[2];

		mFragments[0] = getChildFragmentManager().findFragmentById(R.id.cource_video);
		mFragments[1] = getChildFragmentManager().findFragmentById(R.id.cource_article);
		transaction = getActivity().getSupportFragmentManager().beginTransaction().hide(mFragments[0]).hide(mFragments[1]);
		transaction.show(mFragments[0]).commit();

		return view;
	}

	private OnCheckedChangeListener listener = new OnCheckedChangeListener()
	{

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId)
		{

			transaction = getActivity().getSupportFragmentManager().beginTransaction().hide(mFragments[0]).hide(mFragments[1]);
			for (int i = 0; i < group.getChildCount(); i++)
			{
				if (group.getChildAt(i).getId() == checkedId)
				{
					transaction.show(mFragments[i]).commit();
				}
			}

		}
	};

}
