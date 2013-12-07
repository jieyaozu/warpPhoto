package com.example.warpphoto;

import java.io.File;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	private String TAG = MainActivity.class.getSimpleName();
	private boolean debug = true;
	
	static{
		System.loadLibrary("Hello");
	}
    private Bitmap mBmp;
    private static int c = 5550;
    private static int m = 10000;
    
    private WarpView image;
    private RelativeLayout zj_ll_set;
    private ImageButton imageButton;
    private boolean areButtonsShowing;
    boolean mSaving; // Whether the "save" button is already clicked.
    private final Handler mHandler = new Handler();
    
	private File file;
	public native int initArray();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.warp);
		
		Log.d(TAG, "onCreat");
		initArray();
		Resources rec = getResources();
		BitmapDrawable bitmapDrawable = (BitmapDrawable) rec.getDrawable(R.drawable.sample11);
		mBmp = bitmapDrawable.getBitmap();
		
		image = (WarpView) findViewById(R.id.warp_image);
	    image.setWarpBitmap(mBmp);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		if(debug)
		Log.d(TAG, "onDestroy");
		
		if(mBmp != null){
			mBmp.recycle();
			mBmp = null;
			System.gc();
		}
	}
	
}
