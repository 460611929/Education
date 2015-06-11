package com.example.androiddemo.fragment;

import com.example.androiddemo.R;
import com.example.androiddemo.common.BaseAdapterHelper;
import com.example.androiddemo.common.QuickAdapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

public class CourseVideosFragment extends Fragment
{

	private static final String ARG = "arg";
	private GridView gridView;

	public static CourseVideosFragment newInstance(int firstArgument)
	{
		CourseVideosFragment fragment = new CourseVideosFragment();

		Bundle bundle = new Bundle();

		bundle.putInt(ARG, firstArgument);

		fragment.setArguments(bundle);

		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_course_videos, container, false);
		initView(view);
		return view;
	}

	private void initView(View view)
	{
		gridView = (GridView) view.findViewById(R.id.gridview);
		QuickAdapter adapter = new QuickAdapter(getActivity(), R.layout.item_video)
		{

			@Override
			protected void convert(BaseAdapterHelper helper, Object item)
			{

			}
		};

		gridView.setAdapter(adapter);
		for (int i = 0; i < 10; i++)
		{
			adapter.add(i);
		}

	}

}
