package com.example.androiddemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androiddemo.R;

public class CreateDataFragment extends Fragment
{
	private static final String ARG_FIRSTARGUMENT_KEY = "position";
	private int mFirstArgument;

	public static CreateDataFragment newInstance(int firstArgument)
	{
		CreateDataFragment fragment = new CreateDataFragment();

		Bundle bundle = new Bundle();

		bundle.putInt(ARG_FIRSTARGUMENT_KEY, firstArgument);

		fragment.setArguments(bundle);

		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		if (getArguments() != null)
		{
			mFirstArgument = getArguments().getInt(ARG_FIRSTARGUMENT_KEY);
		}

		View view = inflater.inflate(R.layout.fragment_create_data, container, false);
		return view;
	}

}
