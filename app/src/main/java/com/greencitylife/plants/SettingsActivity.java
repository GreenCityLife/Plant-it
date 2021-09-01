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
import android.widget.ScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Switch;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.os.Bundle;
import java.io.InputStream;
import android.content.Intent;
import android.net.Uri;
import android.content.SharedPreferences;
import java.util.Timer;
import java.util.TimerTask;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.ClipData;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.DialogFragment;
import android.Manifest;
import android.content.pm.PackageManager;


public class SettingsActivity extends Activity {
	public final int REQ_CD_FP = 101;
	private Timer _timer = new Timer();
	
	private String export = "";
	private String restoring = "";
	private double time = 0;
	private String encrypted = "";
	private String decrypted = "";
	
	private ArrayList<String> mode = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> recover = new ArrayList<>();
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private TextView textview1;
	private LinearLayout linear2;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private LinearLayout linear9;
	private TextView textview2;
	private LinearLayout linear11;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear7;
	private LinearLayout linear8;
	private LinearLayout linear10;
	private Switch switch1;
	private TextView textview5;
	private TextView textview6;
	private Spinner spinner1;
	private TextView textview9;
	private TextView textview10;
	private TextView textview11;
	private TextView textview14;
	private TextView textview3;
	private TextView textview4;
	private TextView textview7;
	private TextView textview8;
	private TextView textview12;
	private TextView textview13;
	
	private Intent i = new Intent();
	private SharedPreferences sp;
	private TimerTask t;
	private AlertDialog.Builder restore;
	private Intent fp = new Intent(Intent.ACTION_GET_CONTENT);
	private AlertDialog.Builder backup;
	private AlertDialog.Builder additions;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.settings);
		initialize(_savedInstanceState);
		if (Build.VERSION.SDK_INT >= 23) {
			if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
			|| checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
				requestPermissions(new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
			}
			else {
				initializeLogic();
			}
		}
		else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		textview1 = (TextView) findViewById(R.id.textview1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		textview2 = (TextView) findViewById(R.id.textview2);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		switch1 = (Switch) findViewById(R.id.switch1);
		textview5 = (TextView) findViewById(R.id.textview5);
		textview6 = (TextView) findViewById(R.id.textview6);
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		textview9 = (TextView) findViewById(R.id.textview9);
		textview10 = (TextView) findViewById(R.id.textview10);
		textview11 = (TextView) findViewById(R.id.textview11);
		textview14 = (TextView) findViewById(R.id.textview14);
		textview3 = (TextView) findViewById(R.id.textview3);
		textview4 = (TextView) findViewById(R.id.textview4);
		textview7 = (TextView) findViewById(R.id.textview7);
		textview8 = (TextView) findViewById(R.id.textview8);
		textview12 = (TextView) findViewById(R.id.textview12);
		textview13 = (TextView) findViewById(R.id.textview13);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		restore = new AlertDialog.Builder(this);
		fp.setType("application/json");
		fp.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		backup = new AlertDialog.Builder(this);
		additions = new AlertDialog.Builder(this);
		
		linear5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), NameActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		linear11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (sp.getString("fhh", "").equals("activate")) {
					if (!sp.getString("what", "").equals("fhh")) {
						additions.setTitle("What's New in 2.8?");
						additions.setMessage("- Added Backup and Restore for exporting and backuping data\n- Added Version\n- Added What's New\n- Nature part updated in Setting (Check Nature option in Settings)");
						additions.setCancelable(false);
						additions.setPositiveButton("OKAY!", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								
							}
						});
						additions.setNegativeButton("🥚", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								sp.edit().putString("what", "fhh").commit();
								sp.edit().putString("fhht", String.valueOf((long)(Double.parseDouble(sp.getString("fhht", "")) + 1))).commit();
								SketchwareUtil.showMessage(getApplicationContext(), "🥚".concat(sp.getString("fhht", "")));
								if (sp.getString("fhht", "").equals("3")) {
									SketchwareUtil.showMessage(getApplicationContext(), "You have completed the easter egg challenge, Screenshot this toast");
								}
								i.setClass(getApplicationContext(), SettingsActivity.class);
								startActivity(i);
								finish();
							}
						});
						additions.create().show();
					}
					else {
						additions.setTitle("What's New in 2.8?");
						additions.setMessage("- Added Backup and Restore for exporting and backuping data\n- Added Version\n- Added What's New\n- Nature part updated in Setting (Check Nature option in Settings)");
						additions.setCancelable(false);
						additions.setPositiveButton("OKAY!", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								
							}
						});
						additions.create().show();
					}
				}
				else {
					additions.setTitle("What's New in 2.8?");
					additions.setMessage("- Added Backup and Restore for exporting and backuping data\n- Added Version\n- Added What's New\n- Nature part updated in Setting (Check Nature option in Settings)");
					additions.setCancelable(false);
					additions.setPositiveButton("OKAY!", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					additions.create().show();
				}
			}
		});
		
		linear3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (sp.getString("Level 1", "").equals("ok")) {
					i.setClass(getApplicationContext(), KnowActivity.class);
					startActivity(i);
					finish();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Sorry ".concat(sp.getString("username", "").concat(", atleast win level 1 to unlock.")));
				}
			}
		});
		
		linear4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse("mailto:GreenCityLife.Sketchub@gmail.com"));
				SketchwareUtil.showMessage(getApplicationContext(), "Please add screenshots to repair bugs much more faster and efficient.");
				startActivity(i);
				finish();
			}
		});
		
		linear7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), "Processing........");
				sp.edit().remove("Level 1").commit();
				sp.edit().remove("Level 2").commit();
				sp.edit().remove("Level 3").commit();
				sp.edit().remove("Level 4").commit();
				sp.edit().remove("Level 5").commit();
				sp.edit().remove("Level 6").commit();
				sp.edit().remove("Level 7").commit();
				sp.edit().remove("Level 8").commit();
				sp.edit().remove("Level 9").commit();
				sp.edit().remove("Level 10").commit();
				t = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								SketchwareUtil.showMessage(getApplicationContext(), "Reset done!");
							}
						});
					}
				};
				_timer.schedule(t, (int)(5000));
			}
		});
		
		linear8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse("android-app://com.greencitylife.plants.leaderboard"));
				startActivity(i);
			}
		});
		
		switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					sp.edit().putString("darkmode", "on").commit();
					vscroll1.setBackgroundColor(0xFF212121);
					linear1.setBackgroundColor(0xFF212121);
					textview1.setTextColor(0xFFFFFFFF);
					textview2.setTextColor(0xFFFFFFFF);
					switch1.setTextColor(0xFFFFFFFF);
					textview3.setTextColor(0xFFFFFFFF);
					textview4.setTextColor(0xFFFFFFFF);
					textview5.setTextColor(0xFFFFFFFF);
					textview6.setTextColor(0xFFFFFFFF);
					textview7.setTextColor(0xFFFFFFFF);
					textview8.setTextColor(0xFFFFFFFF);
					textview12.setTextColor(0xFFFFFFFF);
					textview14.setTextColor(0xFFFFFFFF);
				}
				else {
					sp.edit().putString("darkmode", "off").commit();
					vscroll1.setBackgroundColor(0xFFFFFFFF);
					linear1.setBackgroundColor(0xFFFFFFFF);
					textview1.setTextColor(0xFF000000);
					textview2.setTextColor(0xFF000000);
					switch1.setTextColor(0xFF000000);
					textview3.setTextColor(0xFF000000);
					textview4.setTextColor(0xFF000000);
					textview5.setTextColor(0xFF000000);
					textview6.setTextColor(0xFF000000);
					textview7.setTextColor(0xFF000000);
					textview8.setTextColor(0xFF000000);
					textview12.setTextColor(0xFF000000);
					textview14.setTextColor(0xFF000000);
				}
			}
		});
		
		spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (_position == 0) {
					sp.edit().putString("mode", "easy").commit();
				}
				if (_position == 1) {
					sp.edit().putString("mode", "normal").commit();
				}
				if (_position == 2) {
					sp.edit().putString("mode", "hard").commit();
				}
				if (_position == 3) {
					sp.edit().putString("mode", "legend").commit();
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		textview9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				backup.setTitle("Backup Confirmation");
				backup.setMessage("Are you sure do you want to backup your game data? This includes levels finished, game mode and your name.");
				backup.setPositiveButton("Backup", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						{
							HashMap<String, Object> _item = new HashMap<>();
							_item.put("level1", sp.getString("Level 1", ""));
							recover.add(_item);
						}
						
						{
							HashMap<String, Object> _item = new HashMap<>();
							_item.put("level2", sp.getString("Level 2", ""));
							recover.add(_item);
						}
						
						{
							HashMap<String, Object> _item = new HashMap<>();
							_item.put("level3", sp.getString("Level 3", ""));
							recover.add(_item);
						}
						
						{
							HashMap<String, Object> _item = new HashMap<>();
							_item.put("level4", sp.getString("Level 4", ""));
							recover.add(_item);
						}
						
						{
							HashMap<String, Object> _item = new HashMap<>();
							_item.put("level5", sp.getString("Level 5", ""));
							recover.add(_item);
						}
						
						{
							HashMap<String, Object> _item = new HashMap<>();
							_item.put("level6", sp.getString("Level 6", ""));
							recover.add(_item);
						}
						
						{
							HashMap<String, Object> _item = new HashMap<>();
							_item.put("level7", sp.getString("Level 7", ""));
							recover.add(_item);
						}
						
						{
							HashMap<String, Object> _item = new HashMap<>();
							_item.put("level8", sp.getString("Level 8", ""));
							recover.add(_item);
						}
						
						{
							HashMap<String, Object> _item = new HashMap<>();
							_item.put("level9", sp.getString("Level 9", ""));
							recover.add(_item);
						}
						
						{
							HashMap<String, Object> _item = new HashMap<>();
							_item.put("level10", sp.getString("Level 10", ""));
							recover.add(_item);
						}
						
						{
							HashMap<String, Object> _item = new HashMap<>();
							_item.put("mode", sp.getString("mode", ""));
							recover.add(_item);
						}
						
						{
							HashMap<String, Object> _item = new HashMap<>();
							_item.put("name", sp.getString("username", ""));
							recover.add(_item);
						}
						
						export = new Gson().toJson(recover);
						_EncryptedStringKey(export, "36");
					}
				});
				backup.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				backup.create().show();
			}
		});
		
		textview11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(fp, REQ_CD_FP);
			}
		});
		
		textview12.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (sp.getString("fhh", "").equals("activate")) {
						time++;
						if (time == 8) {
								SketchwareUtil.showMessage(getApplicationContext(), "DEACTIVATED");
								sp.edit().putString("fhh", "deactivate").commit();
						sp.edit().putString("fhht", "0").commit();
								time = 0;
						}
				} else {
						time++;
						if (time == 8) {
								SketchwareUtil.showMessage(getApplicationContext(), "ACTIVATED");
								sp.edit().putString("fhh", "activate").commit();
						sp.edit().putString("fhht", "0").commit();
								time = 0;
						}
				}
			}
		});
	}
	
	private void initializeLogic() {
		setTitle("Settings");
		try { android.content.pm.PackageInfo pinfo = getPackageManager().getPackageInfo("com.greencitylife.plants", PackageManager.GET_ACTIVITIES); 
			textview12.setText("Version "+pinfo.versionName); } catch (android.content.pm.PackageManager.NameNotFoundException e) { 
			showMessage(e.toString()); 
		}
		mode.add("Beginner");
		mode.add("Plant Planter");
		mode.add("Garden Owner");
		mode.add("Farmer");
		spinner1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, mode));
		((ArrayAdapter)spinner1.getAdapter()).notifyDataSetChanged();
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			case REQ_CD_FP:
			if (_resultCode == Activity.RESULT_OK) {
				ArrayList<String> _filePath = new ArrayList<>();
				if (_data != null) {
					if (_data.getClipData() != null) {
						for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
							ClipData.Item _item = _data.getClipData().getItemAt(_index);
							_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
						}
					}
					else {
						_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
					}
				}
				_DecryptedStringKey(FileUtil.readFile(_filePath.get((int)(0))), "36");
			}
			else {
				
			}
			break;
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
	public void onStart() {
		super.onStart();
		if (sp.getString("darkmode", "").equals("on")) {
			spinner1.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, mode) {
				
				@Override
				public View getView(int position, View convertView, ViewGroup parent) {
					TextView textView1 = (TextView) super.getView(position, convertView, parent);
					textView1.setTextColor(Color.WHITE);
					textView1.setTextSize(18);
					textView1.setBackgroundColor(Color.parseColor("#ff212121"));
					return textView1; }
				
				@Override
				public View getDropDownView(int position, View convertView, ViewGroup parent) {
					TextView textView1 = (TextView) super.getDropDownView(position, convertView, parent); textView1.setTextColor(Color.WHITE);
					textView1.setBackgroundColor(Color.parseColor("#ff212121"));
					textView1.setTextSize(18);
					return textView1; }
			});
			switch1.setChecked(true);
			restore = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
			backup = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
			additions = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
		}
		if (sp.getString("mode", "").equals("easy")) {
				spinner1.setSelection((int)(0));
		}
		if (sp.getString("mode", "").equals("normal")) {
				spinner1.setSelection((int)(1));
		}
		if (sp.getString("mode", "").equals("hard")) {
				spinner1.setSelection((int)(2));
		}
		if (sp.getString("mode", "").equals("legend")) {
				spinner1.setSelection((int)(3));
		}
	}
	public void _LibEncryptedDecrypted () {
	}
	private javax.crypto.SecretKey generateKey(String pwd) throws Exception {
		
		final java.security.MessageDigest digest = java.security.MessageDigest.getInstance("SHA-256");
		
		byte[] b = pwd.getBytes("UTF-8");
		
		digest.update(b,0,b.length);
		
		byte[] key = digest.digest();
		
		javax.crypto.spec.SecretKeySpec sec = new javax.crypto.spec.SecretKeySpec(key, "AES");
		
		return sec;
	}
	
	
	public void _EncryptedStringKey (final String _string, final String _key) {
		try {
			
			javax.crypto.SecretKey key = generateKey(_key);
			
			javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("AES");
			
			c.init(javax.crypto.Cipher.ENCRYPT_MODE, key);
			
			byte[] encVal = c.doFinal(_string.getBytes());
			
			encrypted = android.util.Base64.encodeToString(encVal,android.util.Base64.DEFAULT);
			FileUtil.writeFile(FileUtil.getExternalStorageDir().concat("/Plant it/Backups/Backup.json"), encrypted);
			SketchwareUtil.showMessage(getApplicationContext(), "Backuped to Plant it/Backup/Backup.json");
		} catch (Exception ex) {
			SketchwareUtil.showMessage(getApplicationContext(), "Failed to encrypt data we're sorry.");
		}
	}
	
	
	public void _DecryptedStringKey (final String _string, final String _key) {
		try {
			
			javax.crypto.spec.SecretKeySpec key = (javax.crypto.spec.SecretKeySpec) generateKey(_key);
			
			javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("AES");
			
			c.init(javax.crypto.Cipher.DECRYPT_MODE, key);
			
			byte[] decode = android.util.Base64.decode(_string,android.util.Base64.DEFAULT);
			
			byte[] decval = c.doFinal(decode);
			
			decrypted = new String(decval);
			recover = new Gson().fromJson(decrypted, new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			sp.edit().putString("Level 1", recover.get((int)0).get("level1").toString()).commit();
			sp.edit().putString("Level 2", recover.get((int)1).get("level2").toString()).commit();
			sp.edit().putString("Level 3", recover.get((int)2).get("level3").toString()).commit();
			sp.edit().putString("Level 4", recover.get((int)3).get("level4").toString()).commit();
			sp.edit().putString("Level 5", recover.get((int)4).get("level5").toString()).commit();
			sp.edit().putString("Level 6", recover.get((int)5).get("level6").toString()).commit();
			sp.edit().putString("Level 7", recover.get((int)6).get("level7").toString()).commit();
			sp.edit().putString("Level 8", recover.get((int)7).get("level8").toString()).commit();
			sp.edit().putString("Level 9", recover.get((int)8).get("level9").toString()).commit();
			sp.edit().putString("Level 10", recover.get((int)9).get("level10").toString()).commit();
			sp.edit().putString("mode", recover.get((int)10).get("mode").toString()).commit();
			sp.edit().putString("username", recover.get((int)11).get("name").toString()).commit();
			restore.setTitle("Restore");
			restore.setMessage("Restore Completed, Please restart the application to make new changes.");
			restore.setCancelable(false);
			restore.setPositiveButton("Restart", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					i.setClass(getApplicationContext(), MainActivity.class);
					startActivity(i);
					finish();
				}
			});
			restore.create().show();
		} catch (Exception ex) {
			SketchwareUtil.showMessage(getApplicationContext(), "Something went wrong");
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