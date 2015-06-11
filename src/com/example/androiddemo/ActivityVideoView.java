package com.example.androiddemo;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class ActivityVideoView extends Activity
{
	String url = "http://g3.letv.cn/vod/v2/MTA0LzMvMy9sZXR2LXV0cy8xNC92ZXJfMDBfMjItMzExNTUzODIxLWF2Yy0yMzAxMDAtYWFjLTMyMDAxLTI3MDM5NjAtOTE2MDc3NjktNjU0NWE5NjhhNGU2MzNiODdhOGJlOTBjZGE0MTdkZWItMTQyNTc2MTczNTU2OC5tcDQ=?b=271&mmsid=1782541&tm=1433924434&key=912fc7a0fd47fc1fe318a8c3e1e53705&platid=1&splatid=1401&playid=0&tss=no&vtype=21&cvid=115354514639&payff=0&pip=d9e27cda56b2601e7ec4597d0c408d99&format=0&sign=mb&dname=mobile&expect=1&tag=mobile";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video_view);
		String path = getIntent().getStringExtra("path");

		VideoView videoView = (VideoView) this.findViewById(R.id.videoview);
		if (path != null)
		{
			Uri uri = Uri.parse(path);
			videoView.setMediaController(new MediaController(this));
			videoView.setVideoURI(uri);
			videoView.start();
			videoView.requestFocus();
		}else {
			finish();
		}

	}

}
