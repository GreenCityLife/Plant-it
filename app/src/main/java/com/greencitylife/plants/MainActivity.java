package com.greencitylife.plants;

import android.app.Activity;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;
import java.io.InputStream;
import android.content.Intent;
import android.net.Uri;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import java.util.Timer;
import java.util.TimerTask;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.DialogFragment;


public class MainActivity extends Activity {
	private Timer _timer = new Timer();
	
	private boolean darkModeEnabled = false;
	
	private LinearLayout linear1;
	private ImageView imageview1;
	private TextView textview2;
	private TextView textview1;
	
	private Intent i = new Intent();
	private SharedPreferences sp;
	private MediaPlayer mp;
	private TimerTask timer;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview2 = (TextView) findViewById(R.id.textview2);
		textview1 = (TextView) findViewById(R.id.textview1);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
	}
	
	private void initializeLogic() {
		_hidenavigation();
		imageview1.setOnLongClickListener(new View.OnLongClickListener() {@Override public boolean onLongClick(View v){
				
				if (sp.getString("fhh", "").equals("activate")) {
					if (!sp.getString("logo", "").equals("fhh")) {
						sp.edit().putString("fhht", String.valueOf((long)(Double.parseDouble(sp.getString("fhht", "")) + 1))).commit();
						sp.edit().putString("logo", "fhh").commit();
									SketchwareUtil.showMessage(getApplicationContext(), "🥚".concat(sp.getString("fhht", "")));
						if (sp.getString("fhht", "").equals("3")) {
							SketchwareUtil.showMessage(getApplicationContext(), "You have completed the easter egg challenge, Screenshot this toast");
							   }
						 }
				}
				
				return false;
				
			}});
		mp = MediaPlayer.create(getApplicationContext(), R.raw.kuil);
		mp.start();
		textview1.setVisibility(View.GONE);
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						textview2.setVisibility(View.GONE);
						textview1.setVisibility(View.VISIBLE);
					}
				});
			}
		};
		_timer.schedule(timer, (int)(2000));
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (sp.getString("username", "").equals("")) {
							SketchwareUtil.showMessage(getApplicationContext(), "Please Enter Your Name.");
							i.setClass(getApplicationContext(), NameActivity.class);
							startActivity(i);
							finish();
						}
						else {
							i.setClass(getApplicationContext(), LevelActivity.class);
							startActivity(i);
							finish();
						}
					}
				});
			}
		};
		_timer.schedule(timer, (int)(4000));
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		mp.pause();
	}
	
	@Override
	public void onStart() {
		super.onStart();
		if (sp.getString("darkmode", "").equals("on")) {
			linear1.setBackgroundColor(0xFF212121);
			textview2.setTextColor(0xFFFFFFFF);
			textview1.setTextColor(0xFFFFFFFF);
		}
		if (sp.getString("mode", "").equals("")) {
			sp.edit().putString("mode", "normal").commit();
		}
	}
	public void _hidenavigation () {
		getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}