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
import android.widget.EditText;
import android.widget.Button;
import android.content.SharedPreferences;
import android.os.Bundle;
import java.io.InputStream;
import android.content.Intent;
import android.net.Uri;
import android.content.ClipData;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.DialogFragment;
import android.Manifest;
import android.content.pm.PackageManager;


public class NameActivity extends Activity {
	public final int REQ_CD_FP = 101;
	
	private String restoring = "";
	private String decrypted = "";
	
	private ArrayList<HashMap<String, Object>> data = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> recover = new ArrayList<>();
	
	private LinearLayout linear1;
	private TextView textview1;
	private EditText edittext1;
	private Button button1;
	private TextView textview2;
	private TextView textview3;
	private Button button2;
	
	private SharedPreferences sp;
	private Intent i = new Intent();
	private Intent fp = new Intent(Intent.ACTION_GET_CONTENT);
	private AlertDialog.Builder restore;
	private AlertDialog.Builder New;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.name);
		initialize(_savedInstanceState);
		if (Build.VERSION.SDK_INT >= 23) {
			if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
				requestPermissions(new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
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
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		textview1 = (TextView) findViewById(R.id.textview1);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		button1 = (Button) findViewById(R.id.button1);
		textview2 = (TextView) findViewById(R.id.textview2);
		textview3 = (TextView) findViewById(R.id.textview3);
		button2 = (Button) findViewById(R.id.button2);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		fp.setType("application/json");
		fp.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		restore = new AlertDialog.Builder(this);
		New = new AlertDialog.Builder(this);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext1.getText().toString().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "No Name found!");
				}
				else {
					New.setTitle("Hello New User!");
					New.setMessage("Click continue to start the app. Want help? Feel free to ask us in Report bugs and Suggestions.");
					New.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							SketchwareUtil.showMessage(getApplicationContext(), "Name saved!");
							sp.edit().putString("username", edittext1.getText().toString()).commit();
							i.setClass(getApplicationContext(), LevelActivity.class);
							startActivity(i);
							finish();
						}
					});
					New.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					New.create().show();
				}
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(fp, REQ_CD_FP);
			}
		});
	}
	
	private void initializeLogic() {
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			SketchUi.setColor(0xFFFFFFFF);
			SketchUi.setCornerRadius(d*360);
			SketchUi.setStroke(d*3,0xFF009688);
			button1.setElevation(d*5);
			android.graphics.drawable.RippleDrawable SketchUiRD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFE0E0E0}), SketchUi, null);
			button1.setBackground(SketchUiRD);
			button1.setClickable(true);
		}
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			SketchUi.setColor(0xFFFFFFFF);
			SketchUi.setCornerRadius(d*360);
			SketchUi.setStroke(d*3,0xFF009688);
			button2.setElevation(d*5);
			android.graphics.drawable.RippleDrawable SketchUiRD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFE0E0E0}), SketchUi, null);
			button2.setBackground(SketchUiRD);
			button2.setClickable(true);
		}
		edittext1.setFilters(new InputFilter[] { new InputFilter.LengthFilter(10) });
		button1.setTransformationMethod(null);
		button2.setTransformationMethod(null);
		if (!sp.getString("username", "").equals("")) {
			textview2.setVisibility(View.GONE);
			textview3.setVisibility(View.GONE);
			button2.setVisibility(View.GONE);
			textview1.setText("Edit your details");
			button1.setText("Edit");
		}
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
	public void onStart() {
		super.onStart();
		if (sp.getString("darkmode", "").equals("on")) {
			linear1.setBackgroundColor(0xFF212121);
			textview1.setTextColor(0xFFFFFFFF);
			edittext1.setTextColor(0xFFFFFFFF);
			button1.setTextColor(0xFFFFFFFF);
			button2.setTextColor(0xFFFFFFFF);
			textview2.setTextColor(0xFFFFFFFF);
			textview3.setTextColor(0xFFFFFFFF);
			edittext1.setHintTextColor(0xFFFFFFFF);
			{
				android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
				int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
				SketchUi.setColor(0xFF000000);
				SketchUi.setCornerRadius(d*360);
				SketchUi.setStroke(d*3,0xFF009688);
				button1.setElevation(d*5);
				android.graphics.drawable.RippleDrawable SketchUiRD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFE0E0E0}), SketchUi, null);
				button1.setBackground(SketchUiRD);
				button1.setClickable(true);
			}
			{
				android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
				int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
				SketchUi.setColor(0xFF000000);
				SketchUi.setCornerRadius(d*360);
				SketchUi.setStroke(d*3,0xFF009688);
				button2.setElevation(d*5);
				android.graphics.drawable.RippleDrawable SketchUiRD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFE0E0E0}), SketchUi, null);
				button2.setBackground(SketchUiRD);
				button2.setClickable(true);
			}
		}
		if (!sp.getString("username", "").equals("")) {
			edittext1.setText(sp.getString("username", ""));
		}
	}
	
	@Override
	public void onBackPressed() {
		if (!sp.getString("username", "").equals("")) {
			i.setClass(getApplicationContext(), LevelActivity.class);
			startActivity(i);
			finish();
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
			restore.setTitle("Welcome back!");
			restore.setMessage("Welcome back Plant it! User. Please click continue to confirm restore.");
			restore.setCancelable(false);
			restore.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					i.setClass(getApplicationContext(), LevelActivity.class);
					startActivity(i);
					finish();
				}
			});
			restore.create().show();
		} catch (Exception ex) {
			SketchwareUtil.showMessage(getApplicationContext(), "Something went wrong.");
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