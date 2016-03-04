package com.angus.light_therapy;

import com.example.light_therapy.R;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.ImageView;

public class AnimationActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_animation);
		
		findViews();

		/*Bundle seg_counter =this.getIntent().getExtras();
		total = seg_counter.getInt("seg_count");*/
		
		context_share = context.getSharedPreferences("context", 0);
		total = context_share.getInt("seg_count", 0);
		count = context_share.getInt("counter", 0);
		color_code = context_share.getString("color_seg_share"+count, "");
		hz = context_share.getString("hz_seg_share"+count, "");
		time = context_share.getString("time_seg_share"+count, "");
		
		Log.v("color_code", color_code);
		
		hz_int = Integer.parseInt(hz);
		time_int = Integer.parseInt(time);
		
		mHandler.postDelayed(count_time, 0);
		
		Log.v("count", String.valueOf(count));
	}
	
	private ImageView mImageView;
	private String color_code, hz, time;
	private int count, time_counter, total, hz_int, time_int;
	private Handler mHandler = new Handler();
	private SharedPreferences context_share;
	final Context context = this;
	private AnimationDrawable frameAnimation = null;
	
	private void findViews() {  
        mImageView = (ImageView)findViewById(R.id.animation_iv);
    } 
	
	@Override
	public void onWindowFocusChanged (boolean hasFocus) {
	   super.onWindowFocusChanged(hasFocus);
	   if (hasFocus)
		   startAnimation(); 
	}

	protected void startAnimation() {  
		frameAnimation = new AnimationDrawable();
        //mImageView.setBackgroundResource(R.drawable.frame_animation);  
        //frameAnimation = (AnimationDrawable)mImageView.getBackground();  
        
        if("red".equals(color_code))
        {
        	Bitmap bmp=BitmapFactory.decodeResource(getResources(), R.drawable.red);
            Drawable frame = new BitmapDrawable(getResources(),bmp);
            frameAnimation.addFrame (frame, 1000/(hz_int*2));
            
            Bitmap bmp2=BitmapFactory.decodeResource(getResources(), R.drawable.black);
            Drawable frame2 = new BitmapDrawable(getResources(),bmp2);
            frameAnimation.addFrame (frame2, 1000/(hz_int*2));
            
            mImageView.setBackgroundDrawable(frameAnimation);
        }
        else if("yellow".equals(color_code))
        {
        	Bitmap bmp=BitmapFactory.decodeResource(getResources(), R.drawable.yellow);
            Drawable frame = new BitmapDrawable(getResources(),bmp);
            frameAnimation.addFrame (frame, 1000/(hz_int*2));
            
            Bitmap bmp2=BitmapFactory.decodeResource(getResources(), R.drawable.black);
            Drawable frame2 = new BitmapDrawable(getResources(),bmp2);
            frameAnimation.addFrame (frame2, 1000/(hz_int*2));
            
            mImageView.setBackgroundDrawable(frameAnimation);
        }
        else if("blue".equals(color_code))
        {
        	Bitmap bmp=BitmapFactory.decodeResource(getResources(), R.drawable.blue);
            Drawable frame = new BitmapDrawable(getResources(),bmp);
            frameAnimation.addFrame (frame, 1000/(hz_int*2));
            
            Bitmap bmp2=BitmapFactory.decodeResource(getResources(), R.drawable.black);
            Drawable frame2 = new BitmapDrawable(getResources(),bmp2);
            frameAnimation.addFrame (frame2, 1000/(hz_int*2));
            
            mImageView.setBackgroundDrawable(frameAnimation);
        }
        else if("green".equals(color_code))
        {
        	Bitmap bmp=BitmapFactory.decodeResource(getResources(), R.drawable.green);
            Drawable frame = new BitmapDrawable(getResources(),bmp);
            frameAnimation.addFrame (frame, 1000/(hz_int*2));
            
            Bitmap bmp2=BitmapFactory.decodeResource(getResources(), R.drawable.black);
            Drawable frame2 = new BitmapDrawable(getResources(),bmp2);
            frameAnimation.addFrame (frame2, 1000/(hz_int*2));
            
            mImageView.setBackgroundDrawable(frameAnimation);
        }
        else if("white".equals(color_code))
        {
        	Bitmap bmp=BitmapFactory.decodeResource(getResources(), R.drawable.white);
            Drawable frame = new BitmapDrawable(getResources(),bmp);
            frameAnimation.addFrame (frame, 1000/(hz_int*2));
            
            Bitmap bmp2=BitmapFactory.decodeResource(getResources(), R.drawable.black);
            Drawable frame2 = new BitmapDrawable(getResources(),bmp2);
            frameAnimation.addFrame (frame2, 1000/(hz_int*2));
            
            mImageView.setBackgroundDrawable(frameAnimation);
        }
        
        frameAnimation.setOneShot(false);
        frameAnimation.start();
        
        /*if (frameAnimation.isRunning()){  
            frameAnimation.stop();  
        }else{  
            frameAnimation.stop();  
            frameAnimation.start();  
        } */ 
    }
	
	private Runnable count_time = new Runnable() {
		public void run() {
			mHandler.postDelayed(this, 1000);
			
			time_counter = time_counter + 1;
			Log.v("time_counter", String.valueOf(time_counter));
			
			if(time_counter == time_int + 1)
			{
				//check total
				if(count < total)
				{
					context_share.edit().putInt("counter", count + 1).commit();
					
					Intent intent = new Intent();
					intent.setClass(AnimationActivity.this, AnimationActivity.class);
					Bundle bundle = new Bundle();
		            bundle.putInt("seg_count", total);
		            //將Bundle物件assign給intent
		            intent.putExtras(bundle);
					startActivity(intent);
					mHandler.removeCallbacks(this);
					finish();
				}
				else if(count == total)
				{
					context_share.edit().putInt("counter", 1).commit();
					
					Intent intent = new Intent();
					intent.setClass(AnimationActivity.this, MainActivity.class);
					startActivity(intent);
					mHandler.removeCallbacks(this);
					finish();
				}
			}
		}
	};
	
	/*public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK) {

			// 按下BACK鍵要做的事
			Intent intent = new Intent();
			intent.setClass(AnimationActivity.this, MainActivity.class);
			startActivity(intent);
			mHandler.removeCallbacks(count_time, intent);
			finish();
			return true;
		}
		return false;
	}*/

}
