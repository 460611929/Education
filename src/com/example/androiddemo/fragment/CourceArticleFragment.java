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
import android.widget.ListView;

public class CourceArticleFragment extends Fragment
{
	
	private static final String ARG = "arg";
	private ListView listView;

	public static CourceArticleFragment newInstance(int firstArgument)
	{
		CourceArticleFragment fragment = new CourceArticleFragment();

		Bundle bundle = new Bundle();

		bundle.putInt(ARG, firstArgument);

		fragment.setArguments(bundle);

		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_course_article, container, false);
		initView(view);
		return view;
	}

	private void initView(View view)
	{
		listView = (ListView) view.findViewById(R.id.listview);
		QuickAdapter adapter = new QuickAdapter(getActivity(), R.layout.item_article)
		{

			@Override
			protected void convert(BaseAdapterHelper helper, Object item)
			{

			}
		};

		listView.setAdapter(adapter);
		for (int i = 0; i < 10; i++)
		{
			adapter.add(i);
		}

	}
}
