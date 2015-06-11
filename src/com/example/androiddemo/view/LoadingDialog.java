package com.example.androiddemo.view;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.androiddemo.R;

public class LoadingDialog
{

	private  Dialog dialog;
	private static LoadingDialog instance;

	public static LoadingDialog getInstance()
	{
		if (instance == null)
		{
			instance = new LoadingDialog();
		}
		return instance;
	}

	private LoadingDialog()
	{

	}

	/**
	 * 得到自定义的progressDialog
	 * @param context
	 * @param msg
	 * @return
	 */
	public Dialog createLoadingDialog(Context context)
	{
		LayoutInflater inflater = LayoutInflater.from(context);
		View v = inflater.inflate(R.layout.loading_dialog, null);// 得到加载view
		dialog = new Dialog(context, R.style.loading_dialog);
		dialog.setCancelable(true);// 不可以用“返回键”取消
		dialog.setContentView(v, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));// 设置布局
		return dialog;
	}

	public void dismiss()
	{
		dialog.dismiss();
	}

}
