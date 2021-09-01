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
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ImageView;
import android.content.SharedPreferences;
import android.os.Bundle;
import java.io.InputStream;
import android.content.Intent;
import android.net.Uri;
import java.util.Timer;
import java.util.TimerTask;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.animation.ObjectAnimator;
import android.view.animation.LinearInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.View;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.DialogFragment;


public class GameActivity extends Activity {
	private Timer _timer = new Timer();
	
	private double timer = 0;
	private double place = 0;
	private double points = 0;
	private double hearts = 0;
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private ScrollView vscroll;
	private TextView textview1;
	private TextView textview2;
	private TextView textview5;
	private TextView textview3;
	private TextView textview4;
	private LinearLayout linear4;
	private LinearLayout game;
	private ImageView imageview1;
	
	private SharedPreferences sp;
	private Intent i = new Intent();
	private TimerTask t;
	private TimerTask t2;
	private AlertDialog.Builder win;
	private ObjectAnimator up = new ObjectAnimator();
	private ObjectAnimator side = new ObjectAnimator();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.game);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		vscroll = (ScrollView) findViewById(R.id.vscroll);
		textview1 = (TextView) findViewById(R.id.textview1);
		textview2 = (TextView) findViewById(R.id.textview2);
		textview5 = (TextView) findViewById(R.id.textview5);
		textview3 = (TextView) findViewById(R.id.textview3);
		textview4 = (TextView) findViewById(R.id.textview4);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		game = (LinearLayout) findViewById(R.id.game);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		win = new AlertDialog.Builder(this);
		
		game.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				hearts--;
				textview5.setText("❤ ".concat(String.valueOf((long)(hearts))));
				SketchwareUtil.showMessage(getApplicationContext(), "💔");
				if (hearts == 0) {
					SketchwareUtil.showMessage(getApplicationContext(), "Oh no! ".concat(sp.getString("username", "").concat(", You Lost, Try again.")));
					i.setClass(getApplicationContext(), LevelActivity.class);
					startActivity(i);
					finish();
				}
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				points++;
				textview4.setText("Points: ".concat("0".concat(String.valueOf((long)(points)))));
				if (points > 9) {
					textview4.setText("Points: ".concat(String.valueOf((long)(points))));
				}
				_Win();
			}
		});
	}
	
	private void initializeLogic() {
		_Goal();
		textview1.setText(sp.getString("level", ""));
		_win_scan();
		imageview1.setVisibility(View.GONE);
		timer = 60;
		points = 0;
		hearts = 3;
		imageview1.setOnLongClickListener(new View.OnLongClickListener() {@Override public boolean onLongClick(View v){
				
				if (sp.getString("fhh", "").equals("activate")) {
					if (!sp.getString("plant", "").equals("fhh")) {
						sp.edit().putString("fhht", String.valueOf((long)(Double.parseDouble(sp.getString("fhht", "")) + 1))).commit();
						sp.edit().putString("plant", "fhh").commit();
									SketchwareUtil.showMessage(getApplicationContext(), "🥚".concat(sp.getString("fhht", "")));
						if (sp.getString("fhht", "").equals("3")) {
							SketchwareUtil.showMessage(getApplicationContext(), "You have completed the easter egg challenge, Screenshot this toast");
							   }
						  }
				}
				
				return false;
				
			}});
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						timer--;
						textview2.setText("00:".concat(String.valueOf((long)(timer))));
						if (10 > timer) {
							textview2.setText("00:0".concat(String.valueOf((long)(timer))));
						}
						if (timer == 0) {
							SketchwareUtil.showMessage(getApplicationContext(), "OOPS! ".concat(sp.getString("username", "").concat(", Time Over.")));
							i.setClass(getApplicationContext(), LevelActivity.class);
							startActivity(i);
							finish();
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(t, (int)(1000), (int)(1000));
		t2 = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						_animation();
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(t2, (int)(Double.parseDouble(sp.getString("speed", ""))), (int)(Double.parseDouble(sp.getString("speed", ""))));
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
	public void onBackPressed() {
		i.setClass(getApplicationContext(), LevelActivity.class);
		startActivity(i);
		finish();
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		timer = 0;
		t.cancel();
	}
	
	@Override
	public void onStart() {
		super.onStart();
		if (sp.getString("darkmode", "").equals("on")) {
			linear1.setBackgroundColor(0xFF212121);
			linear2.setBackgroundColor(0xFF212121);
			linear3.setBackgroundColor(0xFF212121);
			vscroll.setBackgroundColor(0xFF212121);
			linear4.setBackgroundColor(0xFF212121);
			game.setBackgroundColor(0xFF212121);
			textview1.setTextColor(0xFFFFFFFF);
			textview2.setTextColor(0xFFFFFFFF);
			textview5.setTextColor(0xFFFFFFFF);
			textview3.setTextColor(0xFFFFFFFF);
			textview4.setTextColor(0xFFFFFFFF);
		}
	}
	public void _Win () {
		if (sp.getString("mode", "").equals("easy")) {
			if (points == 25) {
				SketchwareUtil.showMessage(getApplicationContext(), "Congratulations ".concat(sp.getString("username", "").concat(", You won.")));
				sp.edit().putString(sp.getString("level", ""), "ok").commit();
				i.setClass(getApplicationContext(), LevelActivity.class);
				startActivity(i);
				finish();
			}
		}
		if (sp.getString("mode", "").equals("normal")) {
			if (points == 35) {
				SketchwareUtil.showMessage(getApplicationContext(), "Congratulations ".concat(sp.getString("username", "").concat(", You won.")));
				sp.edit().putString(sp.getString("level", ""), "ok").commit();
				i.setClass(getApplicationContext(), LevelActivity.class);
				startActivity(i);
				finish();
			}
		}
		if (sp.getString("mode", "").equals("hard")) {
			if (points == 45) {
				SketchwareUtil.showMessage(getApplicationContext(), "Congratulations ".concat(sp.getString("username", "").concat(", You won.")));
				sp.edit().putString(sp.getString("level", ""), "ok").commit();
				i.setClass(getApplicationContext(), LevelActivity.class);
				startActivity(i);
				finish();
			}
		}
		if (sp.getString("mode", "").equals("legend")) {
			if (points == 55) {
				SketchwareUtil.showMessage(getApplicationContext(), "Congratulations ".concat(sp.getString("username", "").concat(", You won.")));
				sp.edit().putString(sp.getString("level", ""), "ok").commit();
				i.setClass(getApplicationContext(), LevelActivity.class);
				startActivity(i);
				finish();
			}
		}
	}
	
	
	public void _Goal () {
		if (sp.getString("mode", "").equals("easy")) {
			textview3.setText("Goal: 25");
		}
		if (sp.getString("mode", "").equals("normal")) {
			textview3.setText("Goal: 35");
		}
		if (sp.getString("mode", "").equals("hard")) {
			textview3.setText("Goal: 45");
		}
		if (sp.getString("mode", "").equals("legend")) {
			textview3.setText("Goal: 55");
		}
	}
	
	
	public void _animation () {
		imageview1.setVisibility(View.VISIBLE);
		place = SketchwareUtil.getRandom((int)(1), (int)(6));
		if (place == 1) {
			up.setTarget(imageview1);
			side.setTarget(imageview1);
			up.setPropertyName("translationY");
			side.setPropertyName("translationX");
			up.setFloatValues((float)(imageview1.getTranslationY()), (float)(0));
			side.setFloatValues((float)(imageview1.getTranslationX()), (float)(0));
			up.start();
			side.start();
		}
		if (place == 2) {
			up.setTarget(imageview1);
			side.setTarget(imageview1);
			up.setPropertyName("translationY");
			side.setPropertyName("translationX");
			up.setFloatValues((float)(imageview1.getTranslationY()), (float)(0));
			side.setFloatValues((float)(imageview1.getTranslationX()), (float)(310));
			up.start();
			side.start();
		}
		if (place == 3) {
			up.setTarget(imageview1);
			side.setTarget(imageview1);
			up.setPropertyName("translationY");
			side.setPropertyName("translationX");
			up.setFloatValues((float)(imageview1.getTranslationY()), (float)(0));
			side.setFloatValues((float)(imageview1.getTranslationX()), (float)(620));
			up.start();
			side.start();
		}
		if (place == 4) {
			side.setTarget(imageview1);
			up.setTarget(imageview1);
			side.setPropertyName("translationX");
			up.setPropertyName("translationY");
			side.setFloatValues((float)(imageview1.getTranslationX()), (float)(0));
			up.setFloatValues((float)(imageview1.getTranslationY()), (float)(130));
			side.start();
			up.start();
		}
		if (place == 5) {
			side.setTarget(imageview1);
			up.setTarget(imageview1);
			side.setPropertyName("translationX");
			up.setPropertyName("translationY");
			side.setFloatValues((float)(imageview1.getTranslationX()), (float)(310));
			up.setFloatValues((float)(imageview1.getTranslationY()), (float)(130));
			side.start();
			up.start();
		}
		if (place == 6) {
			side.setTarget(imageview1);
			up.setTarget(imageview1);
			side.setPropertyName("translationX");
			up.setPropertyName("translationY");
			side.setFloatValues((float)(imageview1.getTranslationX()), (float)(620));
			up.setFloatValues((float)(imageview1.getTranslationY()), (float)(130));
			side.start();
			up.start();
		}
	}
	
	
	public void _win_scan () {
		if (sp.getString("level", "").equals("Level 1")) {
			if (sp.getString("Level 1", "").equals("ok")) {
				textview1.setText(textview1.getText().toString().concat(" (Completed)"));
			}
		}
		if (sp.getString("level", "").equals("Level 2")) {
			if (sp.getString("Level 2", "").equals("ok")) {
				textview1.setText(textview1.getText().toString().concat(" (Completed)"));
			}
		}
		if (sp.getString("level", "").equals("Level 3")) {
			if (sp.getString("Level 3", "").equals("ok")) {
				textview1.setText(textview1.getText().toString().concat(" (Completed)"));
			}
		}
		if (sp.getString("level", "").equals("Level 4")) {
			if (sp.getString("Level 4", "").equals("ok")) {
				textview1.setText(textview1.getText().toString().concat(" (Completed)"));
			}
		}
		if (sp.getString("level", "").equals("Level 5")) {
			if (sp.getString("Level 5", "").equals("ok")) {
				textview1.setText(textview1.getText().toString().concat(" (Completed)"));
			}
		}
		if (sp.getString("level", "").equals("Level 6")) {
			if (sp.getString("Level 6", "").equals("ok")) {
				textview1.setText(textview1.getText().toString().concat(" (Completed)"));
			}
		}
		if (sp.getString("level", "").equals("Level 7")) {
			if (sp.getString("Level 7", "").equals("ok")) {
				textview1.setText(textview1.getText().toString().concat(" (Completed)"));
			}
		}
		if (sp.getString("level", "").equals("Level 8")) {
			if (sp.getString("Level 8", "").equals("ok")) {
				textview1.setText(textview1.getText().toString().concat(" (Completed)"));
			}
		}
		if (sp.getString("level", "").equals("Level 9")) {
			if (sp.getString("Level 9", "").equals("ok")) {
				textview1.setText(textview1.getText().toString().concat(" (Completed)"));
			}
		}
		if (sp.getString("level", "").equals("Level 10")) {
			if (sp.getString("Level 10", "").equals("ok")) {
				textview1.setText(textview1.getText().toString().concat(" (Completed)"));
			}
		}
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