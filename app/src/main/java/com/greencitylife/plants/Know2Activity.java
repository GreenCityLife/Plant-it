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
import android.widget.ScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.os.Bundle;
import java.io.InputStream;
import android.content.Intent;
import android.net.Uri;
import android.content.SharedPreferences;
import android.widget.AdapterView;
import android.view.View;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.DialogFragment;


public class Know2Activity extends Activity {
	
	private ArrayList<String> language = new ArrayList<>();
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear5;
	private LinearLayout linear4;
	private TextView textview1;
	private TextView textview2;
	private ImageView imageview1;
	private TextView textview3;
	private TextView textview4;
	private TextView textview5;
	private TextView textview6;
	private TextView textview7;
	private TextView textview8;
	private TextView textview9;
	private TextView textview10;
	private Spinner spinner1;
	private TextView textview13;
	private TextView textview14;
	private ImageView imageview2;
	private TextView textview15;
	private TextView textview16;
	private TextView textview17;
	private TextView textview18;
	private TextView textview19;
	private TextView textview20;
	private TextView textview21;
	private LinearLayout linear3;
	private TextView textview12;
	private TextView textview11;
	
	private Intent i = new Intent();
	private SharedPreferences sp;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.know2);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		textview1 = (TextView) findViewById(R.id.textview1);
		textview2 = (TextView) findViewById(R.id.textview2);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview3 = (TextView) findViewById(R.id.textview3);
		textview4 = (TextView) findViewById(R.id.textview4);
		textview5 = (TextView) findViewById(R.id.textview5);
		textview6 = (TextView) findViewById(R.id.textview6);
		textview7 = (TextView) findViewById(R.id.textview7);
		textview8 = (TextView) findViewById(R.id.textview8);
		textview9 = (TextView) findViewById(R.id.textview9);
		textview10 = (TextView) findViewById(R.id.textview10);
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		textview13 = (TextView) findViewById(R.id.textview13);
		textview14 = (TextView) findViewById(R.id.textview14);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		textview15 = (TextView) findViewById(R.id.textview15);
		textview16 = (TextView) findViewById(R.id.textview16);
		textview17 = (TextView) findViewById(R.id.textview17);
		textview18 = (TextView) findViewById(R.id.textview18);
		textview19 = (TextView) findViewById(R.id.textview19);
		textview20 = (TextView) findViewById(R.id.textview20);
		textview21 = (TextView) findViewById(R.id.textview21);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		textview12 = (TextView) findViewById(R.id.textview12);
		textview11 = (TextView) findViewById(R.id.textview11);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		
		spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (_position == 0) {
					_Language("English");
				}
				if (_position == 1) {
					_Language("Tamil");
				}
				if (_position == 2) {
					_Language("Hindi");
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		textview12.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), KnowActivity.class);
				startActivity(i);
				finish();
			}
		});
	}
	
	private void initializeLogic() {
		language.add("English");
		language.add("Tamil");
		language.add("Hindi");
		spinner1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, language));
		((ArrayAdapter)spinner1.getAdapter()).notifyDataSetChanged();
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
		i.setClass(getApplicationContext(), SettingsActivity.class);
		startActivity(i);
		finish();
	}
	
	@Override
	public void onStart() {
		super.onStart();
		if (sp.getString("darkmode", "").equals("on")) {
			_Dark();
			spinner1.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, language) {
				
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
		}
	}
	public void _Dark () {
		vscroll1.setBackgroundColor(0xFF212121);
		linear1.setBackgroundColor(0xFF212121);
		linear2.setBackgroundColor(0xFF212121);
		linear4.setBackgroundColor(0xFF212121);
		linear3.setBackgroundColor(0xFF212121);
		textview1.setTextColor(0xFFFFFFFF);
		textview2.setTextColor(0xFFFFFFFF);
		textview3.setTextColor(0xFFFFFFFF);
		textview4.setTextColor(0xFFFFFFFF);
		textview5.setTextColor(0xFFFFFFFF);
		textview6.setTextColor(0xFFFFFFFF);
		textview7.setTextColor(0xFFFFFFFF);
		textview8.setTextColor(0xFFFFFFFF);
		textview9.setTextColor(0xFFFFFFFF);
		textview10.setTextColor(0xFFFFFFFF);
		textview12.setTextColor(0xFFFFFFFF);
		textview11.setTextColor(0xFFFFFFFF);
	}
	
	
	public void _Language (final String _value) {
		if (_value.equals("English")) {
			textview2.setText("This update topic is Lily, The another Water Plant.");
			textview4.setText("Summary");
			textview5.setText("Lilies are tall in height in 2 to 6 feet (60 - 180 cm). The flowers are large, mostly fragrant and has a wide range of colors including white, yellow, orange, pink, red, purple. The flowers will flower in late spring or summer.");
			textview6.setText("Toxic to Cats?");
			textview7.setText("Some lilium species are toxic to cats. Really, It's true. If you see cat eating lily with pollen, immediately take to Vetinary Hospital. Some lilium have parts that can intrupt Cat's Excretery system, This can also lead to cat's kidney failure.");
			textview8.setText("Uses?");
			textview9.setText("China, Taiwan, South Korea uses many species of Lilium as their traditional medicine.");
			textview14.setText("This update topic is Oleander.");
			textview16.setText("Summary");
			textview17.setText("Oleander grows up to 2 - 6 metres long. It is most commonly seen as a shrug but can also be a small tree with single trunk. Oleander can be found in colors white, pink and red.");
			textview18.setText("Toxic");
			textview19.setText("Oleander had historically said to be toxic because some parts of the plant is toxic, expecially animals when consumed in large quantities. Eating the toxic parts of plant causes nausea, vomiting, excess salaiva, abdominal pain, diarrhea.");
			textview20.setText("Treatment");
			textview21.setText("Oleander Toxic can cause immediate effect once it has been eaten. In that case, You need an immediate medical care. \nDigoxin immune fab is the way out to cure an oleander poisoning but not highly recommended due to its side effects.");
		}
		if (_value.equals("Tamil")) {
			textview2.setText("இந்த புதுப்பிப்பு தலைப்பு லில்லி, மற்றொரு நீர் ஆலை.");
			textview4.setText("சுருக்கம்");
			textview5.setText("அல்லிகள் 2 முதல் 6 அடி (60 - 180 செ.மீ) உயரத்தில் இருக்கும்.  மலர்கள் பெரியவை, பெரும்பாலும் மணம் கொண்டவை மற்றும் வெள்ளை, மஞ்சள், ஆரஞ்சு, இளஞ்சிவப்பு, சிவப்பு, ஊதா உள்ளிட்ட பல வண்ணங்களைக் கொண்டுள்ளன.  மலர்கள் வசந்த காலத்தின் பிற்பகுதியில் அல்லது கோடைகாலத்தில் பூக்கும்.");
			textview6.setText("பூனைகளுக்கு நச்சு?");
			textview7.setText("சில லிலியம் இனங்கள் பூனைகளுக்கு நச்சுத்தன்மை வாய்ந்தவை.  உண்மையில், இது உண்மை.  மகரந்தத்துடன் பூனை லில்லி சாப்பிடுவதை நீங்கள் கண்டால், உடனடியாக கால்நடை மருத்துவமனைக்கு கொண்டு செல்லுங்கள்.  சில லிலியத்தில் பூனைகளின் வெளியேற்ற அமைப்புக்கு இடையூறு விளைவிக்கும் பாகங்கள் உள்ளன, இது பூனையின் சிறுநீரக செயலிழப்புக்கும் வழிவகுக்கும்.");
			textview8.setText("பயன்கள்?");
			textview9.setText("சீனா, தைவான், தென் கொரியா பல வகையான லிலியத்தை தங்கள் பாரம்பரிய மருந்தாக பயன்படுத்துகின்றன.");
			textview14.setText("இந்த புதுப்பிப்பு தலைப்பு அரளி பூ.");
			textview16.setText("சுருக்கம்");
			textview17.setText("அரளி 2 - 6 மீட்டர் நீளம் வரை வளரும்.  இது பொதுவாக ஒரு சறுக்கலாகக் காணப்படுகிறது, ஆனால் ஒற்றை தண்டு கொண்ட ஒரு சிறிய மரமாகவும் இருக்கலாம்.  ஒலியாண்டரை வெள்ளை, இளஞ்சிவப்பு மற்றும் சிவப்பு வண்ணங்களில் காணலாம்.");
			textview18.setText("நச்சு");
			textview19.setText("அரளி வரலாற்று ரீதியாக நச்சுத்தன்மை வாய்ந்ததாகக் கூறியதால், தாவரத்தின் சில பகுதிகள் நச்சுத்தன்மையுடையவை, குறிப்பாக விலங்குகள் அதிக அளவில் உட்கொள்ளும்போது.  தாவரத்தின் நச்சு பாகங்களை சாப்பிடுவதால் குமட்டல், வாந்தி, அதிகப்படியான உமிழ்நீர், வயிற்று வலி, வயிற்றுப்போக்கு ஏற்படுகிறது.");
			textview20.setText("சிகிச்சை");
			textview21.setText("அரளி பூவின் நச்சு பகுதிகளை சாப்பிட்டவுடன் உடனடி விளைவை ஏற்படுத்தும்.  அவ்வாறான நிலையில், உங்களுக்கு உடனடி மருத்துவ பராமரிப்பு தேவை.\n டிகோக்சின் நோயெதிர்ப்பு ஃபேப் என்பது ஒரு ஒலியாண்டர் விஷத்தை குணப்படுத்துவதற்கான வழி, ஆனால் அதன் பக்க விளைவுகள் காரணமாக மிகவும் பரிந்துரைக்கப்படவில்லை.");
		}
		if (_value.equals("Hindi")) {
			textview2.setText("यह अद्यतन विषय लिली, एक और जल संयंत्र है।");
			textview4.setText("सारांश");
			textview5.setText("लिली की ऊंचाई 2 से 6 फीट (60 - 180 सेमी) में होती है।  फूल बड़े होते हैं, ज्यादातर सुगंधित होते हैं और सफेद, पीले, नारंगी, गुलाबी, लाल, बैंगनी सहित रंगों की एक विस्तृत श्रृंखला होती है।  फूल देर से वसंत या गर्मियों में खिलेंगे।");
			textview6.setText("बिल्लियों के लिए विषाक्त?");
			textview7.setText("कुछ लिलियम प्रजातियां बिल्लियों के लिए जहरीली होती हैं।  सच में, यह सच है।  यदि आप बिल्ली को पराग के साथ लिली खाते हुए देखते हैं, तो तुरंत पशु चिकित्सालय ले जाएँ।  कुछ लिलियम में ऐसे हिस्से होते हैं जो बिल्ली के उत्सर्जन तंत्र को बाधित कर सकते हैं, इससे बिल्ली की किडनी खराब भी हो सकती है।");
			textview8.setText("उपयोग?");
			textview9.setText("चीन, ताइवान, दक्षिण कोरिया अपनी पारंपरिक दवा के रूप में लिलियम की कई प्रजातियों का उपयोग करते हैं।");
			textview14.setText("यह अद्यतन विषय ओलियंडर है।");
			textview16.setText("सारांश");
			textview17.setText("ओलियंडर 2 - 6 मीटर लंबा होता है।  यह आमतौर पर एक झाड़ी के रूप में देखा जाता है, लेकिन यह एक छोटा पेड़ भी हो सकता है जिसमें एक ट्रंक होता है।  ओलियंडर सफेद, गुलाबी और लाल रंग में पाया जाता है।");
			textview18.setText("विषैला");
			textview19.setText("ओलियंडर ने ऐतिहासिक रूप से विषाक्त होने को कहा था क्योंकि पौधे के कुछ हिस्से जहरीले होते हैं, खासकर जानवर जब बड़ी मात्रा में सेवन करते हैं।  पौधे के विषैले भागों को खाने से जी मिचलाना, उल्टी, लार अधिक आना, पेट में दर्द, दस्त होता है।");
			textview20.setText("इलाज");
			textview21.setText("ओलियंडर टॉक्सिक खाने के बाद इसका तुरंत असर होता है।  उस मामले में, आपको तत्काल चिकित्सा देखभाल की आवश्यकता है।\n डिगॉक्सिन इम्यून फैब एक ओलियंडर विषाक्तता को ठीक करने का तरीका है, लेकिन इसके दुष्प्रभावों के कारण अत्यधिक अनुशंसित नहीं है।");
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