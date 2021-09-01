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
import java.util.ArrayList;
import java.util.HashMap;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.content.SharedPreferences;
import android.os.Bundle;
import java.io.InputStream;
import android.content.Intent;
import android.net.Uri;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.AdapterView;
import android.view.View;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.DialogFragment;


public class LevelActivity extends Activity {
	
	private double level = 0;
	
	private ArrayList<HashMap<String, Object>> number = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private TextView textview1;
	private Button button1;
	private ListView listview1;
	
	private SharedPreferences sp;
	private Intent i = new Intent();
	private AlertDialog.Builder explainer;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.level);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		textview1 = (TextView) findViewById(R.id.textview1);
		button1 = (Button) findViewById(R.id.button1);
		listview1 = (ListView) findViewById(R.id.listview1);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		explainer = new AlertDialog.Builder(this);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), SettingsActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				sp.edit().putString("level", number.get((int)_position).get("level").toString()).commit();
				if (_position == 0) {
					i.setClass(getApplicationContext(), TutorialActivity.class);
					startActivity(i);
					finish();
				}
				if (_position == 1) {
					sp.edit().putString("speed", "1000").commit();
					i.setClass(getApplicationContext(), GameActivity.class);
					startActivity(i);
					finish();
				}
				if (_position == 2) {
					sp.edit().putString("speed", "950").commit();
					if (sp.getString("Level 1", "").equals("ok")) {
						i.setClass(getApplicationContext(), GameActivity.class);
						startActivity(i);
						finish();
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "Oh no! ".concat(sp.getString("username", "").concat(", level locked")));
					}
				}
				if (_position == 3) {
					sp.edit().putString("speed", "900").commit();
					if (sp.getString("Level 2", "").equals("ok")) {
						i.setClass(getApplicationContext(), GameActivity.class);
						startActivity(i);
						finish();
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "Oh no! ".concat(sp.getString("username", "").concat(", level locked")));
					}
				}
				if (_position == 4) {
					sp.edit().putString("speed", "850").commit();
					if (sp.getString("Level 3", "").equals("ok")) {
						i.setClass(getApplicationContext(), GameActivity.class);
						startActivity(i);
						finish();
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "Oh no! ".concat(sp.getString("username", "").concat(", level locked")));
					}
				}
				if (_position == 5) {
					sp.edit().putString("speed", "800").commit();
					if (sp.getString("Level 4", "").equals("ok")) {
						i.setClass(getApplicationContext(), GameActivity.class);
						startActivity(i);
						finish();
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "Oh no! ".concat(sp.getString("username", "").concat(", level locked")));
					}
				}
				if (_position == 6) {
					sp.edit().putString("speed", "750").commit();
					if (sp.getString("Level 5", "").equals("ok")) {
						i.setClass(getApplicationContext(), GameActivity.class);
						startActivity(i);
						finish();
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "Oh no! ".concat(sp.getString("username", "").concat(", level locked")));
					}
				}
				if (_position == 7) {
					sp.edit().putString("speed", "700").commit();
					if (sp.getString("Level 6", "").equals("ok")) {
						i.setClass(getApplicationContext(), GameActivity.class);
						startActivity(i);
						finish();
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "Oh no! ".concat(sp.getString("username", "").concat(", level locked")));
					}
				}
				if (_position == 8) {
					sp.edit().putString("speed", "650").commit();
					if (sp.getString("Level 7", "").equals("ok")) {
						i.setClass(getApplicationContext(), GameActivity.class);
						startActivity(i);
						finish();
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "Oh no! ".concat(sp.getString("username", "").concat(", level locked")));
					}
				}
				if (_position == 9) {
					sp.edit().putString("speed", "600").commit();
					if (sp.getString("Level 8", "").equals("ok")) {
						i.setClass(getApplicationContext(), GameActivity.class);
						startActivity(i);
						finish();
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "Oh no! ".concat(sp.getString("username", "").concat(", level locked")));
					}
				}
				if (_position == 10) {
					sp.edit().putString("speed", "550").commit();
					if (sp.getString("Level 9", "").equals("ok")) {
						i.setClass(getApplicationContext(), GameActivity.class);
						startActivity(i);
						finish();
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "Oh no! ".concat(sp.getString("username", "").concat(", level locked")));
					}
				}
			}
		});
	}
	
	private void initializeLogic() {
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			int clrs [] = {0xFF4CAF50,0xFF8BC34A};
			SketchUi= new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, clrs);
			SketchUi.setCornerRadius(d*46);
			SketchUi.setStroke(d*2,0xFF009688);
			button1.setElevation(d*5);
			android.graphics.drawable.RippleDrawable SketchUiRD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFF009688}), SketchUi, null);
			button1.setBackground(SketchUiRD);
			button1.setClickable(true);
		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("level", "Tutorial ");
			number.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("level", "Level 1");
			number.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("level", "Level 2");
			number.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("level", "Level 3");
			number.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("level", "Level 4");
			number.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("level", "Level 5");
			number.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("level", "Level 6");
			number.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("level", "Level 7");
			number.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("level", "Level 8");
			number.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("level", "Level 9");
			number.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("level", "Level 10");
			number.add(_item);
		}
		
		listview1.setAdapter(new Listview1Adapter(number));
		((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
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
	public void onStart() {
		super.onStart();
		if (sp.getString("darkmode", "").equals("on")) {
			explainer = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
			{
				android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
				int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
				int clrs [] = {0xFF00C853,0xFFA5D6A7};
				SketchUi= new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, clrs);
				SketchUi.setCornerRadius(d*46);
				SketchUi.setStroke(d*2,0xFF004D40);
				button1.setElevation(d*5);
				android.graphics.drawable.RippleDrawable SketchUiRD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFF009688}), SketchUi, null);
				button1.setBackground(SketchUiRD);
				button1.setClickable(true);
			}
			linear1.setBackgroundColor(0xFF212121);
			linear2.setBackgroundColor(0xFF212121);
			listview1.setBackgroundColor(0xFF212121);
			textview1.setTextColor(0xFFFFFFFF);
		}
		if (!sp.getString("2.8", "").equals("ok")) {
			explainer.setTitle("What's New in 2.8?");
			explainer.setMessage("- Added Backup and Restore for exporting and backuping data\n- Added Version\n- Added What's New\n- Nature part updated in Setting (Check Nature option in Settings)");
			explainer.setCancelable(false);
			explainer.setPositiveButton("OKAY!", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					sp.edit().putString("2.8", "ok").commit();
				}
			});
			explainer.create().show();
		}
	}
	public class Listview1Adapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.levels, null);
			}
			
			final LinearLayout linear1 = (LinearLayout) _view.findViewById(R.id.linear1);
			final TextView level = (TextView) _view.findViewById(R.id.level);
			final ImageView lock = (ImageView) _view.findViewById(R.id.lock);
			final ImageView unlock = (ImageView) _view.findViewById(R.id.unlock);
			
			level.setText(number.get((int)_position).get("level").toString());
			if (sp.getString("darkmode", "").equals("on")) {
				linear1.setBackgroundColor(0xFF212121);
				level.setTextColor(0xFFFFFFFF);
				lock.setImageResource(R.drawable.ic_lock_white);
				unlock.setImageResource(R.drawable.ic_lock_open_white);
			}
			if (_position == 0) {
				lock.setVisibility(View.GONE);
				unlock.setVisibility(View.GONE);
			}
			else {
				if (_position == 1) {
					lock.setVisibility(View.GONE);
				}
				else {
					if (_position == 2) {
						if (sp.getString("Level 1", "").equals("ok")) {
							lock.setVisibility(View.GONE);
						}
						else {
							unlock.setVisibility(View.GONE);
						}
					}
					if (_position == 3) {
						if (sp.getString("Level 2", "").equals("ok")) {
							lock.setVisibility(View.GONE);
						}
						else {
							unlock.setVisibility(View.GONE);
						}
					}
					if (_position == 4) {
						if (sp.getString("Level 3", "").equals("ok")) {
							lock.setVisibility(View.GONE);
						}
						else {
							unlock.setVisibility(View.GONE);
						}
					}
					if (_position == 5) {
						if (sp.getString("Level 4", "").equals("ok")) {
							lock.setVisibility(View.GONE);
						}
						else {
							unlock.setVisibility(View.GONE);
						}
					}
					if (_position == 6) {
						if (sp.getString("Level 5", "").equals("ok")) {
							lock.setVisibility(View.GONE);
						}
						else {
							unlock.setVisibility(View.GONE);
						}
					}
					if (_position == 7) {
						if (sp.getString("Level 6", "").equals("ok")) {
							lock.setVisibility(View.GONE);
						}
						else {
							unlock.setVisibility(View.GONE);
						}
					}
					if (_position == 8) {
						if (sp.getString("Level 7", "").equals("ok")) {
							lock.setVisibility(View.GONE);
						}
						else {
							unlock.setVisibility(View.GONE);
						}
					}
					if (_position == 9) {
						if (sp.getString("Level 8", "").equals("ok")) {
							lock.setVisibility(View.GONE);
						}
						else {
							unlock.setVisibility(View.GONE);
						}
					}
					if (_position == 10) {
						if (sp.getString("Level 9", "").equals("ok")) {
							lock.setVisibility(View.GONE);
						}
						else {
							unlock.setVisibility(View.GONE);
						}
					}
				}
			}
			
			return _view;
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