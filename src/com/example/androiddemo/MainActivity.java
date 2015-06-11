package com.example.androiddemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.example.androiddemo.fragment.CreateDataFragment;
import com.example.androiddemo.view.LoadingDialog;

public class MainActivity extends ActionBarActivity
{

	Fragment[] mFragments;
	private FragmentTransaction transaction;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//getServerTime();
		mFragments = new Fragment[4];
		mFragments[0] = getSupportFragmentManager().findFragmentById(R.id.fragment_createdata);
		mFragments[1] = getSupportFragmentManager().findFragmentById(R.id.fragment_viewdata);
		mFragments[2] = getSupportFragmentManager().findFragmentById(R.id.fragment_course);
		mFragments[3] = getSupportFragmentManager().findFragmentById(R.id.fragment_expert);
		transaction = getSupportFragmentManager().beginTransaction().hide(mFragments[0]).hide(mFragments[1]).hide(mFragments[2]).hide(mFragments[3]);
		transaction.show(mFragments[0]).commit();
		
		
		RadioGroup rGroup = (RadioGroup) this.findViewById(R.id.main_radiogroup);
		rGroup.check(R.id.main1);
		rGroup.setOnCheckedChangeListener(listener);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void getServerTime()
	{
		LoadingDialog.getInstance().createLoadingDialog(this).show();

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		int id = item.getItemId();
		if (id == R.id.action_settings)
		{
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	OnCheckedChangeListener listener = new OnCheckedChangeListener()
	{

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId)
		{
			transaction = getSupportFragmentManager().beginTransaction()
					.hide(mFragments[0]).hide(mFragments[1])
					.hide(mFragments[2]).hide(mFragments[3]);
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
