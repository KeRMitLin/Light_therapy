package com.angus.light_therapy;

import com.example.light_therapy.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SetupActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_setup);
        
        findViews();
		setListeners();
    }  
      
    private Button seg_1, seg_2, seg_3, seg_4, seg_5, seg_6, seg_7, seg_8, seg_9, seg_10, seg_11, seg_12;
	private int seg_count = 0;
	final Context context = this;
	private String[] color_seg = new String[12], hz_seg = new String[12], time_seg = new String[12];
	private SharedPreferences context_share;
    
    private void findViews() {  
    	seg_1 = (Button)findViewById(R.id.bt_in1);
    	seg_2 = (Button)findViewById(R.id.bt_in2);
    	seg_3 = (Button)findViewById(R.id.bt_in3);
    	seg_4 = (Button)findViewById(R.id.bt_in4);
    	seg_5 = (Button)findViewById(R.id.bt_in5);
    	seg_6 = (Button)findViewById(R.id.bt_in6);
    	seg_7 = (Button)findViewById(R.id.bt_in7);
    	seg_8 = (Button)findViewById(R.id.bt_in8);
    	seg_9 = (Button)findViewById(R.id.bt_in9);
    	seg_10 = (Button)findViewById(R.id.bt_in10);
    	seg_11 = (Button)findViewById(R.id.bt_in11);
    	seg_12 = (Button)findViewById(R.id.bt_in12);
    } 
    
    private void setListeners() {
    	seg_1.setOnClickListener(bt1);
    	seg_2.setOnClickListener(bt2);
    	seg_3.setOnClickListener(bt3);
    	seg_4.setOnClickListener(bt4);
    	seg_5.setOnClickListener(bt5);
    	seg_6.setOnClickListener(bt6);
    	seg_7.setOnClickListener(bt7);
    	seg_8.setOnClickListener(bt8);
    	seg_9.setOnClickListener(bt9);
    	seg_10.setOnClickListener(bt10);
    	seg_11.setOnClickListener(bt11);
    	seg_12.setOnClickListener(bt12);
	}
    
    private Button.OnClickListener bt1 = new Button.OnClickListener() {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			seg_count = 1;
			custom_context(1,seg_count);
		}
	};
	
	private Button.OnClickListener bt2 = new Button.OnClickListener() {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			seg_count = 2;
			custom_context(1,seg_count);
		}
	};
	
	private Button.OnClickListener bt3 = new Button.OnClickListener() {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			seg_count = 3;
			custom_context(1,seg_count);
		}
	};
	
	private Button.OnClickListener bt4 = new Button.OnClickListener() {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			seg_count = 4;
			custom_context(1,seg_count);
		}
	};
	
	private Button.OnClickListener bt5 = new Button.OnClickListener() {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			seg_count = 5;
			custom_context(1,seg_count);
		}
	};
	
	private Button.OnClickListener bt6 = new Button.OnClickListener() {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			seg_count = 6;
			custom_context(1,seg_count);
		}
	};
	
	private Button.OnClickListener bt7 = new Button.OnClickListener() {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			seg_count = 7;
			custom_context(1,seg_count);
		}
	};
	
	private Button.OnClickListener bt8 = new Button.OnClickListener() {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			seg_count = 8;
			custom_context(1,seg_count);
		}
	};
	
	private Button.OnClickListener bt9 = new Button.OnClickListener() {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			seg_count = 9;
			custom_context(1,seg_count);
		}
	};
	
	private Button.OnClickListener bt10 = new Button.OnClickListener() {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			seg_count = 10;
			custom_context(1,seg_count);
		}
	};
	
	private Button.OnClickListener bt11 = new Button.OnClickListener() {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			seg_count = 11;
			custom_context(1,seg_count);
		}
	};
	
	private Button.OnClickListener bt12 = new Button.OnClickListener() {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			seg_count = 12;
			custom_context(1,seg_count);
		}
	};
	
	public void custom_context(final int count, int total) {
		// custom dialog
		final Dialog dialog = new Dialog(context);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.custom_dialog_setup);

		// set the custom dialog components - text, image and button
		TextView tv_inner = (TextView) dialog.findViewById(R.id.inner_text);
		final EditText et_inner1 = (EditText) dialog.findViewById(R.id.editText1);
		final EditText et_inner2 = (EditText) dialog.findViewById(R.id.editText2);
		final Button bt_inner_1 = (Button) dialog.findViewById(R.id.bt_in1);
		final Button bt_inner_2 = (Button) dialog.findViewById(R.id.bt_in2);
		final Button bt_inner_3 = (Button) dialog.findViewById(R.id.bt_in3);
		final Button bt_inner_4 = (Button) dialog.findViewById(R.id.bt_in4);
		final Button bt_inner_5 = (Button) dialog.findViewById(R.id.bt_in5);
		Button bt_inner_6 = (Button) dialog.findViewById(R.id.bt_in6);

		tv_inner.setText("設定第"+count+"階段");
		bt_inner_6.setText("確定");

		bt_inner_1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				color_seg[count-1] = "red";
				
				bt_inner_1.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.dialogue_but_d));
				bt_inner_2.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.dialogue_but));
				bt_inner_3.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.dialogue_but));
				bt_inner_4.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.dialogue_but));
				bt_inner_5.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.dialogue_but));
			}
		});
		
		bt_inner_2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				color_seg[count-1] = "white";
				
				bt_inner_1.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.dialogue_but));
				bt_inner_2.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.dialogue_but_d));
				bt_inner_3.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.dialogue_but));
				bt_inner_4.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.dialogue_but));
				bt_inner_5.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.dialogue_but));
			}
		});
		
		bt_inner_3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				color_seg[count-1] = "blue";
				
				bt_inner_1.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.dialogue_but));
				bt_inner_2.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.dialogue_but));
				bt_inner_3.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.dialogue_but_d));
				bt_inner_4.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.dialogue_but));
				bt_inner_5.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.dialogue_but));
			}
		});
		
		bt_inner_4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				color_seg[count-1] = "yellow";
				
				bt_inner_1.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.dialogue_but));
				bt_inner_2.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.dialogue_but));
				bt_inner_3.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.dialogue_but));
				bt_inner_4.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.dialogue_but_d));
				bt_inner_5.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.dialogue_but));
			}
		});
		
		bt_inner_5.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				color_seg[count-1] = "green";
				
				bt_inner_1.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.dialogue_but));
				bt_inner_2.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.dialogue_but));
				bt_inner_3.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.dialogue_but));
				bt_inner_4.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.dialogue_but));
				bt_inner_5.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.dialogue_but_d));
			}
		});
		
		bt_inner_6.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				dialog.dismiss();
				
				
				if(count < seg_count)
				{
					hz_seg[count-1] = et_inner1.getText().toString();
					time_seg[count-1] = et_inner2.getText().toString();
					
					Log.v("count", String.valueOf(String.valueOf(count)));
					Log.v("color", String.valueOf(color_seg[count-1]));
					Log.v("hz", String.valueOf(hz_seg[count-1]));
					Log.v("time", String.valueOf(time_seg[count-1]));
					
					custom_context(count+1,seg_count);
				}
				else if(count == seg_count && seg_count == 1)
				{
					hz_seg[count-1] = et_inner1.getText().toString();
					time_seg[count-1] = et_inner2.getText().toString();
					
					//取得SharedPreference設定
			      	context_share = context.getSharedPreferences("context", 0);
			      	final Editor ed = context_share.edit();
			      	
			      	for(int i=1;i<=seg_count;i=i+1)
			      	{
			      		ed.putString("color_seg_share"+i, color_seg[i-1]);
			      		ed.putString("hz_seg_share"+i, hz_seg[i-1]);
			      		ed.putString("time_seg_share"+i, time_seg[i-1]);
			      	}
			      	ed.putInt("counter", 1);
			      	ed.putInt("seg_count", seg_count);
			      	ed.commit();
					
					Intent intent = new Intent();
					intent.setClass(SetupActivity.this, MainActivity.class);
					/*Bundle bundle = new Bundle();
		            bundle.putInt("seg_count", seg_count);
		            //將Bundle物件assign給intent
		            intent.putExtras(bundle);*/
					startActivity(intent);
					finish();
				}
				else if(count == seg_count && seg_count != 1)
				{
					hz_seg[count-1] = et_inner1.getText().toString();
					time_seg[count-1] = et_inner2.getText().toString();
					
					//取得SharedPreference設定
			      	context_share = context.getSharedPreferences("context", 0);
			      	final Editor ed = context_share.edit();
			      	
			      	for(int i=1;i<=seg_count;i=i+1)
			      	{
			      		ed.putString("color_seg_share"+i, color_seg[i-1]);
			      		ed.putString("hz_seg_share"+i, hz_seg[i-1]);
			      		ed.putString("time_seg_share"+i, time_seg[i-1]);
			      	}
			      	ed.putInt("counter", 1);
			      	ed.putInt("seg_count", seg_count);
			      	ed.commit();
					
					Intent intent = new Intent();
					intent.setClass(SetupActivity.this, MainActivity.class);
					/*Bundle bundle = new Bundle();
		            bundle.putInt("seg_count", seg_count);
		            //將Bundle物件assign給intent
		            intent.putExtras(bundle);*/
					startActivity(intent);
					finish();
				}
			}
		});

		// 調整大小
		WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
		lp.copyFrom(dialog.getWindow().getAttributes());
		lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
		lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

		dialog.show();

		dialog.getWindow().setAttributes(lp);
	}
}  
