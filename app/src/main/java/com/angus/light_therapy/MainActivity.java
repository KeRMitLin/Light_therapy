package com.angus.light_therapy;

import com.example.light_therapy.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        findViews();
		setListeners();  
    }  
      
    
    //aaa
    private Button bt_start, bt_setup;
	final Context context = this;
	private String[] color_seg = new String[12], hz_seg = new String[12], time_seg = new String[12];
	private SharedPreferences context_share;
    
    private void findViews() {  
    	bt_start = (Button)findViewById(R.id.bt_in1);
    	bt_setup = (Button)findViewById(R.id.bt_in2);
    } 
    
    private void setListeners() {
    	bt_start.setOnClickListener(bt1);
    	bt_setup.setOnClickListener(bt2);
	}
    
    private Button.OnClickListener bt1 = new Button.OnClickListener() {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			context_share = context.getSharedPreferences("context", 0);
			String check = context_share.getString("hz_seg_share1", "");
			
			if("".equals(check))
			{
				AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).create();
		        dialog.setTitle("系統訊息");
		        dialog.setMessage("還沒設定本次療程內容喔！");
		        dialog.setButton("確認", new DialogInterface.OnClickListener() {
		            @Override
		            public void onClick(DialogInterface dialog, int which) {
		                // TODO Auto-generated method stub
		            }
		        });
		        dialog.show();
			}
			else
			{
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, AnimationActivity.class);
				startActivity(intent);
				finish();
			}
		}
	};
	
	private Button.OnClickListener bt2 = new Button.OnClickListener() {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			custom_context();
		}
	};
	
	public void custom_context() {
		// custom dialog
		final Dialog dialog = new Dialog(context);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.custom_dialog_pass);

		// set the custom dialog components - text, image and button
		TextView tv_inner = (TextView) dialog.findViewById(R.id.inner_text);
		final EditText et_inner1 = (EditText) dialog.findViewById(R.id.editText1);
		Button bt_inner_1 = (Button) dialog.findViewById(R.id.bt_in1);

		tv_inner.setText("請輸入密碼");
		bt_inner_1.setText("確定");

		//i
		bt_inner_1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				
				if ("710120".equals(et_inner1.getText().toString()))
				{
					Intent intent = new Intent();
					intent.setClass(MainActivity.this, SetupActivity.class);
					startActivity(intent);
					finish();
				}
				else
				{
					AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).create();
			        dialog.setTitle("系統訊息");
			        dialog.setMessage("密碼錯誤，請重新輸入。");
			        dialog.setButton("確認", new DialogInterface.OnClickListener() {
			            @Override
			            public void onClick(DialogInterface dialog, int which) {
			                // TODO Auto-generated method stub
			            	et_inner1.setText("");
			            }
			        });
			        dialog.show();
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
