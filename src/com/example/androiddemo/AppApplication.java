package com.example.androiddemo;

import java.util.HashMap;
import java.util.Map;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.example.androiddemo.net.RequestManager;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

public class AppApplication extends Application
{
	private static Context applicationContext;
	/**
	 * 存放 一些 临时 要传递 的 数据
	 */
	private static Map<String, Object> tempMap = new HashMap<String, Object>();

	@Override
	public void onCreate()
	{
		super.onCreate();
		applicationContext = getApplicationContext();
		AppApplication.setContext(applicationContext);
		initImageLoader(this);
		RequestManager.init(getApplicationContext());

	}

	/**
	 * 
	 * 这个 方法的 意义 在于 Test 时候的 context 会先于 application 创建 前 创建 所以 在此之前 调用一些 方法
	 * 可能会出错
	 * 
	 * @param context
	 * @return
	 */
	public static void setContext(Context context)
	{
		applicationContext = context;
	}

	public static Context getContext()
	{
		return applicationContext;
	}

	/**
	 * 这个方法 用来存放 intent 不能 传递的 对象 （因为 要传递 必需 序列化 有的 序列化不了可以用这个 办法）
	 * 
	 * @param key
	 * @param obj
	 */
	public static void setObject(String key, Object obj)
	{
		tempMap.put(key, obj);
	}

	public static <T> T getObject(String key)
	{
		return (T) tempMap.get(key);
	}

	public static void removeObject(String key)
	{
		tempMap.remove(key);
	}

	/**
	 * 用完以后 清理 一下 temp
	 */
	public static void clearTemp()
	{
		tempMap.clear();
	}

	public void initImageLoader(Context context)
	{
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).threadPriority(Thread.NORM_PRIORITY - 2)
		        .denyCacheImageMultipleSizesInMemory().diskCacheFileNameGenerator(new Md5FileNameGenerator()).diskCacheSize(50 * 1024 * 1024)
		        // 50 Mb
		        .tasksProcessingOrder(QueueProcessingType.LIFO).writeDebugLogs() // Remove for release app
		        .build();
		// Initialize ImageLoader with configuration.
		ImageLoader.getInstance().init(config);
	}

	public static void updateImageBg(ImageView ivHead, String path)
	{
		ImageLoader imageLoader = ImageLoader.getInstance();

		DisplayImageOptions options = new DisplayImageOptions.Builder().showImageOnLoading(R.drawable.discover_pic)
		        .showImageForEmptyUri(R.drawable.discover_pic).showImageOnFail(R.drawable.discover_pic).cacheInMemory(true).cacheOnDisk(true)
		        .considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565).displayer(new RoundedBitmapDisplayer(5)).build();
		imageLoader.displayImage(path, ivHead, options);
	}

}
