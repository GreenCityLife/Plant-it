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


public class KnowActivity extends Activity {
	
	private ArrayList<String> language = new ArrayList<>();
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear6;
	private LinearLayout linear7;
	private LinearLayout linear5;
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
	private TextView textview28;
	private Spinner spinner1;
	private TextView textview10;
	private TextView textview11;
	private ImageView imageview2;
	private TextView textview12;
	private TextView textview13;
	private TextView textview14;
	private TextView textview15;
	private TextView textview16;
	private TextView textview17;
	private TextView textview18;
	private TextView textview19;
	private TextView textview20;
	private ImageView imageview4;
	private TextView textview21;
	private TextView textview22;
	private TextView textview23;
	private TextView textview24;
	private TextView textview25;
	private TextView textview26;
	private TextView textview27;
	private TextView textview29;
	private TextView textview30;
	private ImageView imageview5;
	private TextView textview31;
	private TextView textview32;
	private TextView textview33;
	private TextView textview34;
	private TextView textview35;
	private TextView textview36;
	private TextView textview37;
	private TextView textview38;
	private TextView textview39;
	private ImageView imageview7;
	private TextView textview40;
	private TextView textview41;
	private TextView textview42;
	private TextView textview43;
	private TextView textview44;
	private TextView textview45;
	private TextView textview46;
	private LinearLayout linear8;
	private TextView textview47;
	private TextView textview48;
	
	private Intent i = new Intent();
	private SharedPreferences sp;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.know);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
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
		textview28 = (TextView) findViewById(R.id.textview28);
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		textview10 = (TextView) findViewById(R.id.textview10);
		textview11 = (TextView) findViewById(R.id.textview11);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		textview12 = (TextView) findViewById(R.id.textview12);
		textview13 = (TextView) findViewById(R.id.textview13);
		textview14 = (TextView) findViewById(R.id.textview14);
		textview15 = (TextView) findViewById(R.id.textview15);
		textview16 = (TextView) findViewById(R.id.textview16);
		textview17 = (TextView) findViewById(R.id.textview17);
		textview18 = (TextView) findViewById(R.id.textview18);
		textview19 = (TextView) findViewById(R.id.textview19);
		textview20 = (TextView) findViewById(R.id.textview20);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		textview21 = (TextView) findViewById(R.id.textview21);
		textview22 = (TextView) findViewById(R.id.textview22);
		textview23 = (TextView) findViewById(R.id.textview23);
		textview24 = (TextView) findViewById(R.id.textview24);
		textview25 = (TextView) findViewById(R.id.textview25);
		textview26 = (TextView) findViewById(R.id.textview26);
		textview27 = (TextView) findViewById(R.id.textview27);
		textview29 = (TextView) findViewById(R.id.textview29);
		textview30 = (TextView) findViewById(R.id.textview30);
		imageview5 = (ImageView) findViewById(R.id.imageview5);
		textview31 = (TextView) findViewById(R.id.textview31);
		textview32 = (TextView) findViewById(R.id.textview32);
		textview33 = (TextView) findViewById(R.id.textview33);
		textview34 = (TextView) findViewById(R.id.textview34);
		textview35 = (TextView) findViewById(R.id.textview35);
		textview36 = (TextView) findViewById(R.id.textview36);
		textview37 = (TextView) findViewById(R.id.textview37);
		textview38 = (TextView) findViewById(R.id.textview38);
		textview39 = (TextView) findViewById(R.id.textview39);
		imageview7 = (ImageView) findViewById(R.id.imageview7);
		textview40 = (TextView) findViewById(R.id.textview40);
		textview41 = (TextView) findViewById(R.id.textview41);
		textview42 = (TextView) findViewById(R.id.textview42);
		textview43 = (TextView) findViewById(R.id.textview43);
		textview44 = (TextView) findViewById(R.id.textview44);
		textview45 = (TextView) findViewById(R.id.textview45);
		textview46 = (TextView) findViewById(R.id.textview46);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		textview47 = (TextView) findViewById(R.id.textview47);
		textview48 = (TextView) findViewById(R.id.textview48);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		
		spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (_position == 0) {
					textview2.setText("This update topic is Rafflesia, The World's Largest Flower.");
					textview4.setText("Summary");
					textview5.setText("Rafflesia Arnoldii are ony seen in Rainforests in SouthAfrica. It is a diameter of 106 cm shortly close to a meter. It weights 10 kg and are a lifespan of just 5 to 1 week. It can even hold a 2 years old baby. It smells like some rotten meat.");
					textview6.setText("What They Eat?");
					textview7.setText("They are capable of eating insects, flies and even sometimes frogs and if anyone feed them a small flesh of human they can eat.");
					textview8.setText("Any Uses?");
					textview9.setText("The main use is it will attract many foreign tourists has It's The World's biggest Flower.");
					textview11.setText("This update topic is Watermeal, The World's Smallest Flowering Plant.");
					textview13.setText("Summary");
					textview14.setText("Watermeal is the World's Smallest Flowering plant. As you can see from the image one dot is a individual plant. They are all over the world in the ponds. Although It's not useful though because many complained about Watermeal that blocking the sun rays of the pond.");
					textview15.setText("How to get rid of them?");
					textview16.setText("To get rid off them, You have to introduce pond fishes like Koi and Grass Carp. We recommend Koi because it will eat the Watermeal immediately meanwhile grass carp will eat other plants first. Also some ducks near pond will be useful.");
					textview17.setText("Is Watermeal Edible?");
					textview18.setText("Surprisingly, Yes. It is edible to humans. All Woffia Genus are edible to humans and the Watermeal the tiniest and tastiest of all Woffia Genus. But don't eat now, consult your doctor first.");
					textview20.setText("This update topic is Jasmines, The World's Fragnent Flower.");
					textview22.setText("Summary");
					textview23.setText("Jasmines can be either Diceduous (leaves falling in the autumn) or Evergreen (green all year around). The flowers are around 2.5 cm (0.98 inches). These flowers are very likely to be white or yellow, In some rare cases these are slightly red.");
					textview24.setText("Jasmine and World");
					textview25.setText("Some facts about Jasmine and The World.\n\n👉 Syria: The Syrian City is known as The City Of Jasmines.\n\n👉 Hawaii: Jasmine sambac (\"pikake\") is a common flower used in leis, and is the subject of many Hawaiian songs.\n\n👉  Indonesia: Jasminum sambac is the national flower, adopted at 1990 in Indonesia.\n\n👉 Pakistan: Jasmine officinale is known as the \"chambeli\" or \"yasmin\", it is the national flower.\n\n👉 Philippines: Jasmine sambac is the national flower. Adopted at 1935 in Philippines.\n\n👉 Thailand: Jasmine flowers are used as a symbol of motherhood.");
					textview26.setText("Uses?");
					textview27.setText("It is mainly cultivated for its flowers. Jasmine flowers are worn by womens in South and South East Asia. Jasmine Tea also prepared traditionally in China where they call it as Jasmine Flower Tea. Also in Okinawa, Japan, Jasmine Tea is called as sanpin cha.");
					textview30.setText("This update topic is Rose, The another fragrant flower.");
					textview32.setText("Summary");
					textview33.setText("About 50 million years ago, the first rose were found in America. But today's famous red rose come from the Chinese Red Rose which is found from the 18th Century. Most of us, Beleive that roses were grown earlier civilization 50000 years ago.");
					textview34.setText("Growing");
					textview35.setText("Do you think that growing roses are easy in your garden? If you say no, you are correct. Because Roses are affected by number of diseases. Cultivated Roses have severe damage from animals, Insects and Fungus diseases. In more cases they can't be used without proper care and treatment.");
					textview36.setText("All Uses");
					textview37.setText("Really Roses have many uses and cultivating it but The uses are very useful to us. Here are some uses of roses.\n\n👉 Ornamental Uses: Roses are the beat flower to grow in gardens because of their attractive color and their Fragrance.\n\n👉 Perfumes: Beacause of their Fragrance, Many Companies create rose perfumes worldwide for their profit.\n\n👉 Foods: Yes, Roses are used to make foods, sometimes they are made to jam, jelly, soups and even tea because of their high vitamin C.\n\n👉 Medicines: Because of their high Vitamin C, they are used as medicines for some deseases.\n\n👉 Art: Yes, Many old paintings have roses because it symoblizes  some secret meaning in their arts.");
					textview39.setText("This update topic is Lotus, The India's national flower.");
					textview41.setText("Summary");
					textview42.setText("Lotus plants will grow in the flood areaa and delta regions. A Lotus leaves about hundreds and thousands of seeds every year. Some will sprout and most of the animals eat the seeds while some will escape and grow as a new lotus.");
					textview43.setText("Water Plant");
					textview44.setText("The Lotus known as the king of the Water plants. If a lotus in the pond, it will be the pond's respect. Also, if also 1 lotus in the pond, people will say, it is a lotus pond.");
					textview45.setText("Uses");
					textview46.setText("The rhizomes of Lotus are widely conserved as a vegetable in Asian countries expecially in China, Japan and India. The are selled whole or cut into pieces are usually fresh, frozen or canned. Lotus Vegetables are fried or maked as soups, syrups.");
				}
				if (_position == 1) {
					textview2.setText("இந்த புதுப்பிப்பு தலைப்பு உலகின் மிகப்பெரிய மலர் ராஃப்லீசியா.");
					textview4.setText("சுருக்கம்");
					textview5.setText("ராஃப்லீசியா அர்னால்டி தென் ஆப்பிரிக்காவில் உள்ள மழைக்காடுகளில் காணப்படுகிறார்.  இது ஒரு மீட்டருக்கு விரைவில் நெருக்கமான 106 செ.மீ விட்டம் ஆகும்.  இது 10 கிலோ எடையும், 5 முதல் 1 வாரமும் மட்டுமே ஆயுட்காலம்.  இது 2 வயது குழந்தையை கூட வைத்திருக்க முடியும்.  இது சில அழுகிய இறைச்சியைப் போல வாசனை.");
					textview6.setText("அவர்கள் என்ன சாப்பிடுகிறார்கள்?");
					textview7.setText("அவை பூச்சிகள், ஈக்கள் மற்றும் சில நேரங்களில் தவளைகளை கூட உண்ணும் திறன் கொண்டவை, யாராவது அவர்களுக்கு மனிதனின் சிறிய மாமிசத்தை அளித்தால் அவர்கள் உண்ணலாம்.");
					textview8.setText("ஏதேனும் பயன்கள் உள்ளதா?");
					textview9.setText("முக்கிய பயன்பாடு இது பல வெளிநாட்டு சுற்றுலாப் பயணிகளை ஈர்க்கும், இது உலகின் மிகப்பெரிய மலர்.");
					textview11.setText("இந்த புதுப்பிப்பு தலைப்பு வாட்டர்மீல், உலகின் மிகச்சிறிய பூக்கும் ஆலை.");
					textview13.setText("சுருக்கம்");
					textview14.setText("வாட்டர்மீல் உலகின் மிகச்சிறிய பூக்கும் ஆலை.  படத்தில் இருந்து நீங்கள் பார்க்க முடியும் என ஒரு புள்ளி ஒரு தனி ஆலை.  அவை உலகம் முழுவதும் குளங்களில் உள்ளன.  குளத்தின் சூரிய கதிர்களைத் தடுப்பதாக வாட்டர்மீலைப் பற்றி பலர் புகார் செய்ததால் இது பயனுள்ளதாக இல்லை.");
					textview15.setText("அவற்றை எவ்வாறு அகற்றுவது?");
					textview16.setText("அவற்றிலிருந்து விடுபட, நீங்கள் கோய் மற்றும் புல் கார்ப் போன்ற குளம் மீன்களை அறிமுகப்படுத்த வேண்டும்.  நாங்கள் கோயை பரிந்துரைக்கிறோம், ஏனெனில் அது உடனடியாக வாட்டர்மீல் சாப்பிடும், இதற்கிடையில் புல் கெண்டை முதலில் மற்ற தாவரங்களை சாப்பிடும்.  குளத்திற்கு அருகிலுள்ள சில வாத்துகள் பயனுள்ளதாக இருக்கும்.");
					textview17.setText("வாட்டர்மீல் உண்ணக்கூடியதா?");
					textview18.setText("ஆச்சரியம் என்னவென்றால், ஆம்.  இது மனிதர்களுக்கு உண்ணக்கூடியது.  அனைத்து வோஃபியா இனங்களும் மனிதர்களுக்கு உண்ணக்கூடியவை மற்றும் வாட்டர்மீல் அனைத்து வோஃபியா இனத்திலும் மிகச்சிறிய மற்றும் சுவையானது.  ஆனால் இப்போது சாப்பிட வேண்டாம், முதலில் உங்கள் மருத்துவரை அணுகவும்.");
					textview20.setText("இந்த புதுப்பிப்பு தலைப்பு ஜாஸ்மின்கள், உலகின் வாசனை மலர்.");
					textview22.setText("சுருக்கம்");
					textview23.setText("மல்லிகை துண்டுகளாக்கப்படலாம் (இலையுதிர்காலத்தில் இலைகள் விழும்) அல்லது எவர்க்ரீன் (ஆண்டு முழுவதும் பச்சை).  மலர்கள் சுமார் 2.5 செ.மீ (0.98 அங்குலங்கள்) ஆகும்.  இந்த பூக்கள் வெள்ளை அல்லது மஞ்சள் நிறமாக இருக்க வாய்ப்புள்ளது, சில அரிதான சந்தர்ப்பங்களில் இவை சற்று சிவப்பு நிறத்தில் இருக்கும்.");
					textview24.setText("மல்லிகை மற்றும் உலகம்");
					textview25.setText("மல்லிகை மற்றும் உலகத்தைப் பற்றிய சில உண்மைகள்.\n\n👉 சிரியா: சிரிய நகரம் மல்லிகை நகரம் என்று அழைக்கப்படுகிறது.\n\n 👉 ஹவாய்: மல்லிகை சம்பாக் (\"பிககே\") என்பது லீஸில் பயன்படுத்தப்படும் ஒரு பொதுவான மலர், இது பல ஹவாய் பாடல்களின் பொருள்.\n\n👉 இந்தோனேசியா: ஜாஸ்மினம் சம்பாக் என்பது தேசிய மலர் ஆகும், இது 1990 இல் இந்தோனேசியாவில் ஏற்றுக்கொள்ளப்பட்டது.\n\n 👉 பாகிஸ்தான்: மல்லிகை அஃபிசினேல் \"சாம்பேலி\" அல்லது \"யாஸ்மின்\" என்று அழைக்கப்படுகிறது, இது தேசிய மலர்.\n\n👉 பிலிப்பைன்ஸ்: மல்லிகை சம்பாக் தேசிய மலர்.  1935 இல் பிலிப்பைன்ஸில் தத்தெடுக்கப்பட்டது.\n\n 👉 தாய்லாந்து: தாய்மையின் அடையாளமாக மல்லிகைப் பூக்கள் பயன்படுத்தப்படுகின்றன.");
					textview26.setText("பயன்கள்?");
					textview27.setText("இது முக்கியமாக அதன் பூக்களுக்காக பயிரிடப்படுகிறது.  மல்லிகை பூக்கள் தென் மற்றும் தென்கிழக்கு ஆசியாவில் பெண்கள் அணியப்படுகின்றன.  மல்லிகை தேநீர் சீனாவில் பாரம்பரியமாக தயாரிக்கப்பட்டது, அங்கு அவர்கள் அதை மல்லிகை மலர் தேநீர் என்று அழைக்கிறார்கள்.  ஜப்பானின் ஒகினாவாவிலும், மல்லிகை தேயிலை சான்பின் சா என்று அழைக்கப்படுகிறது.");
					textview30.setText("இந்த புதுப்பிப்பு தலைப்பு ரோஸ், மற்றொரு மணம் மலர்.");
					textview32.setText("சுருக்கம்");
					textview33.setText("சுமார் 50 மில்லியன் ஆண்டுகளுக்கு முன்பு, முதல் ரோஜா அமெரிக்காவில் காணப்பட்டது.  ஆனால் இன்றைய பிரபலமான சிவப்பு ரோஜா 18 ஆம் நூற்றாண்டில் இருந்து காணப்படும் சீன சிவப்பு ரோஜாவிலிருந்து வருகிறது.  நம்மில் பெரும்பாலோர், 50000 ஆண்டுகளுக்கு முன்பு ரோஜாக்கள் முந்தைய நாகரிகமாக வளர்க்கப்பட்டன.");
					textview34.setText("வளர்ந்து வருகிறது");
					textview35.setText("உங்கள் தோட்டத்தில் ரோஜாக்கள் வளர்வது எளிது என்று நினைக்கிறீர்களா?  இல்லை என்று சொன்னால், நீங்கள் சொல்வது சரிதான்.  ஏனெனில் ரோஜாக்கள் பல நோய்களால் பாதிக்கப்படுகின்றன.  பயிரிடப்பட்ட ரோஜாக்களுக்கு விலங்குகள், பூச்சிகள் மற்றும் பூஞ்சை நோய்களிலிருந்து கடுமையான சேதம் ஏற்படுகிறது.  அதிகமான சந்தர்ப்பங்களில் சரியான பராமரிப்பு மற்றும் சிகிச்சை இல்லாமல் அவற்றைப் பயன்படுத்த முடியாது.");
					textview36.setText("அனைத்து பயன்கள்");
					textview37.setText("உண்மையில் ரோஜாக்களுக்கு பல பயன்கள் உள்ளன, அதை வளர்க்கின்றன, ஆனால் பயன்கள் நமக்கு மிகவும் பயனுள்ளதாக இருக்கும்.  ரோஜாக்களின் சில பயன்பாடுகள் இங்கே.\n\n 👉 அலங்காரப் பயன்கள்: ரோஜாக்கள் தோட்டங்களில் வளரத் துடிக்கும் பூ, அவற்றின் கவர்ச்சியான நிறம் மற்றும் மணம் காரணமாக.\n\n👉 வாசனை திரவியங்கள்: அவற்றின் நறுமணத்தின் காரணமாக, பல நிறுவனங்கள் தங்கள் லாபத்திற்காக உலகளவில் ரோஜா வாசனை திரவியங்களை உருவாக்குகின்றன.\n\n👉 உணவுகள்: ஆமாம், ரோஜாக்கள் உணவுகளை தயாரிக்கப் பயன்படுகின்றன, சில சமயங்களில் அவை அதிக வைட்டமின் சி இருப்பதால் ஜாம், ஜெல்லி, சூப்கள் மற்றும் தேநீர் போன்றவற்றுக்கும் தயாரிக்கப்படுகின்றன.\n\n👉 மருந்துகள்: அவற்றின் வைட்டமின் சி அதிகமாக இருப்பதால், அவை சில தேய்மானங்களுக்கு மருந்துகளாகப் பயன்படுத்தப்படுகின்றன.\n\n 👉 கலை: ஆமாம், பல பழைய ஓவியங்கள் ரோஜாக்களைக் கொண்டுள்ளன, ஏனெனில் இது அவர்களின் கலைகளில் சில ரகசிய அர்த்தங்களை ஒருங்கிணைக்கிறது.");
					textview39.setText("இந்த புதுப்பிப்பு தலைப்பு தாமரை, இந்தியாவின் தேசிய மலர்.");
					textview41.setText("சுருக்கம்");
					textview42.setText("தாமரை தாவரங்கள் வெள்ள பகுதி மற்றும் டெல்டா பகுதிகளில் வளரும்.  ஒரு தாமரை ஒவ்வொரு ஆண்டும் நூற்றுக்கணக்கான மற்றும் ஆயிரக்கணக்கான விதைகளை விட்டு விடுகிறது.  சில முளைக்கும் மற்றும் பெரும்பாலான விலங்குகள் விதைகளை சாப்பிடுகின்றன, சில தப்பித்து புதிய தாமரையாக வளரும்.");
					textview43.setText("தேசிய மலர்");
					textview44.setText("தாமரை இந்தியாவின் தேசிய மலர் என்று அழைக்கப்படுகிறது.  இதன் அறிவியல் பெயர் நெலம்போ நியூசிஃபெரா.  மேலும் தமிழில் ஒரு திருக்குறள் உள்ளது.\n\n\"வெள்ளத் தளைய மலர்நீட்டம் மாந்தர்தம்\nஉள்ள தனைய உயர்வு\". அதாவது கடல் கடலின் ஆழத்தைப் பொறுத்து தண்டு வளரும், அதேபோல் ஒரு மனிதனும் உக்கத்தை பொறுத்து வளருவான்.");
					textview45.setText("பயன்கள்");
					textview46.setText("தாமரையின் வேர்த்தண்டுக்கிழங்குகள் ஆசிய நாடுகளில் குறிப்பாக சீனா, ஜப்பான் மற்றும் இந்தியாவில் காய்கறியாக பரவலாக பாதுகாக்கப்படுகின்றன.  அவை முழுமையாக விற்கப்படுகின்றன அல்லது துண்டுகளாக வெட்டப்படுகின்றன பொதுவாக புதியவை, உறைந்தவை அல்லது பதிவு செய்யப்பட்டவை.  தாமரை காய்கறிகள் வறுத்த அல்லது சூப்கள், சிரப் என தயாரிக்கப்படுகின்றன.");
				}
				if (_position == 2) {
					textview2.setText("यह अद्यतन विषय दुनिया का सबसे बड़ा फूल रैफलेसिया है।");
					textview4.setText("सारांश");
					textview5.setText("रैफलेसिया अर्नोल्डी केवल दक्षिण अफ्रीका के वर्षावनों में देखे जाते हैं।  यह एक मीटर के करीब 106 सेमी का व्यास है।  इसका वजन 10 किलो है और इसका जीवनकाल सिर्फ 5 से 1 सप्ताह है।  इसमें 2 साल का बच्चा भी हो सकता है।  यह कुछ सड़े हुए मांस की तरह गंध करता है।");
					textview6.setText("वे क्या खाते हैं?");
					textview7.setText("ये कीड़े, मक्खियाँ और यहाँ तक कि कभी-कभी मेंढक भी खाने में सक्षम होते हैं और अगर कोई उन्हें इंसानों का एक छोटा सा मांस खिलाता है तो वे खा सकते हैं।");
					textview8.setText("कोई उपयोग?");
					textview9.setText("मुख्य उपयोग यह है कि यह कई विदेशी पर्यटकों को आकर्षित करेगा यह दुनिया का सबसे बड़ा फूल है।");
					textview11.setText("यह अद्यतन विषय है वाटरमील, दुनिया का सबसे छोटा फूल वाला पौधा।");
					textview13.setText("सारांश");
					textview14.setText("वाटरमील दुनिया का सबसे छोटा फूल वाला पौधा है।  जैसा कि आप छवि से देख सकते हैं कि एक बिंदु एक व्यक्तिगत पौधा है।  वे पूरी दुनिया में तालाबों में हैं।  हालांकि यह उपयोगी नहीं है, क्योंकि कई लोगों ने वाटरमील के बारे में शिकायत की है कि तालाब की सूरज की किरणों को अवरुद्ध कर रहा है।");
					textview15.setText("उनसे कैसे छुटकारा पाया जाए?");
					textview16.setText("उनसे छुटकारा पाने के लिए, आपको तालाब की मछलियों जैसे कोई और ग्रास कार्प को पेश करना होगा।  हम कोई की सलाह देते हैं क्योंकि यह तुरंत तरबूज खाएगा इस बीच ग्रास कार्प पहले अन्य पौधों को खाएगा।  साथ ही तालाब के पास कुछ बत्तखें उपयोगी होंगी।");
					textview17.setText("क्या तरबूज खाने योग्य है?");
					textview18.setText("हैरानी की बात है, हाँ।  यह मनुष्यों के लिए खाद्य है।  सभी Woffia Genus मनुष्यों के लिए खाद्य हैं और सभी Woffia Genus का सबसे नन्हा और स्वादिष्ट तरबूज।  लेकिन अभी न खाएं, पहले अपने डॉक्टर से सलाह लें।");
					textview20.setText("यह अद्यतन विषय है जैस्मीन्स, द वर्ल्ड्स फ्रेग्नेंट फ्लावर।");
					textview22.setText("सारांश");
					textview23.setText("चमेली या तो पर्णपाती (शरद ऋतु में गिरने वाले पत्ते) या सदाबहार (पूरे साल हरे) हो सकते हैं।  फूल लगभग 2.5 सेमी (0.98 इंच) के होते हैं।  इन फूलों के सफेद या पीले होने की बहुत संभावना होती है, कुछ दुर्लभ मामलों में ये थोड़े लाल होते हैं।");
					textview24.setText("चमेली और दुनिया");
					textview25.setText("जैस्मीन और द वर्ल्ड के बारे में कुछ तथ्य।\n\n👉 सीरिया: सीरियाई शहर को जैस्मीन के शहर के रूप में जाना जाता है।\n\n 👉 हवाई: जैस्मीन सांबक (\"पिकाके\") लीस में इस्तेमाल होने वाला एक सामान्य फूल है, और यह कई हवाईयन गीतों का विषय है।\n\n👉 इंडोनेशिया: जैस्मीनम सांबाक राष्ट्रीय फूल है, जिसे 1990 में इंडोनेशिया में अपनाया गया था।\n\n👉 पाकिस्तान: जैस्मीन ऑफ़िसिनेल को \"चंबेली\" या \"यास्मीन\" के रूप में जाना जाता है, यह राष्ट्रीय फूल है।\n\n👉 फिलीपींस: जैस्मीन सांबाक राष्ट्रीय फूल है।  1935 में फिलीपींस में अपनाया गया।\n\n👉 थाईलैंड: चमेली के फूलों का उपयोग मातृत्व के प्रतीक के रूप में किया जाता है।");
					textview26.setText("उपयोग?");
					textview27.setText("इसकी खेती मुख्य रूप से इसके फूलों के लिए की जाती है।  चमेली के फूल दक्षिण और दक्षिण पूर्व एशिया में महिलाओं द्वारा पहने जाते हैं।  चमेली की चाय भी चीन में पारंपरिक रूप से तैयार की जाती है जहाँ वे इसे जैस्मीन फ्लावर टी कहते हैं।  जापान के ओकिनावा में भी जैस्मीन टी को सैनपिन चा कहा जाता है।");
					textview30.setText("यह अद्यतन विषय गुलाब, एक और सुगंधित फूल है।");
					textview32.setText("सारांश");
					textview33.setText("लगभग 50 मिलियन वर्ष पहले अमेरिका में पहला गुलाब पाया गया था।  लेकिन आज का प्रसिद्ध लाल गुलाब चीनी लाल गुलाब से आता है जो 18वीं शताब्दी से पाया जाता है।  हम में से अधिकांश, विश्वास करते हैं कि गुलाब ५०००० साल पहले सभ्यता से पहले उगाए गए थे।");
					textview34.setText("बढ़ रही है");
					textview35.setText("क्या आपको लगता है कि आपके बगीचे में गुलाब उगाना आसान है?  यदि आप नहीं कहते हैं, तो आप सही हैं।  क्योंकि गुलाब कई तरह की बीमारियों से प्रभावित होते हैं।  उगाए गए गुलाबों को जानवरों, कीड़ों और कवक रोगों से गंभीर नुकसान होता है।  अधिक मामलों में उचित देखभाल और उपचार के बिना उनका उपयोग नहीं किया जा सकता है।");
					textview36.setText("सभी उपयोग");
					textview37.setText("वास्तव में गुलाब के कई उपयोग हैं और इसकी खेती करते हैं लेकिन उपयोग हमारे लिए बहुत उपयोगी हैं।  यहाँ गुलाब के कुछ उपयोग दिए गए हैं।\n\n👉 सजावटी उपयोग: गुलाब अपने आकर्षक रंग और उनकी सुगंध के कारण बगीचों में उगने वाला हरा फूल है।\n\n👉 परफ्यूम: अपनी खुशबू के कारण, कई कंपनियां अपने लाभ के लिए दुनिया भर में गुलाब के परफ्यूम बनाती हैं।\n\n👉 खाद्य पदार्थ: हां, गुलाब का उपयोग खाद्य पदार्थ बनाने के लिए किया जाता है, कभी-कभी वे जैम, जेली, सूप और यहां तक ​​कि चाय में भी उच्च विटामिन सी के कारण बनाए जाते हैं।\n\n👉 दवाएं: इनमें विटामिन सी की मात्रा अधिक होने के कारण इनका उपयोग कुछ रोगों के लिए औषधि के रूप में किया जाता है।\n\n👉 कला: हाँ, कई पुराने चित्रों में गुलाब हैं क्योंकि यह उनकी कलाओं में कुछ गुप्त अर्थों का प्रतीक है।");
					textview39.setText("यह अद्यतन विषय कमल, भारत का राष्ट्रीय फूल है।");
					textview41.setText("सारांश");
					textview42.setText("बाढ़ क्षेत्र और डेल्टा क्षेत्रों में कमल के पौधे उगेंगे।  एक कमल हर साल लगभग सैकड़ों और हजारों बीज छोड़ता है।  कुछ अंकुरित होंगे और अधिकांश जानवर बीज खाएंगे जबकि कुछ बच निकलेंगे और नए कमल के रूप में विकसित होंगे।");
					textview43.setText("राष्ट्रीय फूल");
					textview44.setText("कमल को भारत का राष्ट्रीय फूल कहा जाता है।  कमल एक जल पौधा है।  यह जल संयंत्र का राजा है।");
					textview45.setText("उपयोग");
					textview46.setText("कमल के प्रकंद एशियाई देशों में विशेष रूप से चीन, जापान और भारत में एक सब्जी के रूप में व्यापक रूप से संरक्षित हैं।  पूरे बेचे जाते हैं या टुकड़ों में काटे जाते हैं, आमतौर पर ताजा, जमे हुए या डिब्बाबंद होते हैं।  कमल की सब्जियों को तल कर या सूप, चाशनी के रूप में बनाया जाता है।");
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		textview48.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), Know2Activity.class);
				startActivity(i);
				finish();
			}
		});
	}
	
	private void initializeLogic() {
		_textview();
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
		i.setClass(getApplicationContext(), LevelActivity.class);
		startActivity(i);
		finish();
	}
	
	@Override
	public void onStart() {
		super.onStart();
		if (sp.getString("darkmode", "").equals("on")) {
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
					textView1.setTextSize(18);
					textView1.setBackgroundColor(Color.parseColor("#ff212121"));
					return textView1; }
			});
			_Dark();
		}
	}
	public void _Dark () {
		vscroll1.setBackgroundColor(0xFF212121);
			linear1.setBackgroundColor(0xFF212121);
			linear2.setBackgroundColor(0xFF212121);
			linear3.setBackgroundColor(0xFF212121);
			linear4.setBackgroundColor(0xFF212121);
		
		linear5.setBackgroundColor(0xFF212121);
		
		linear6.setBackgroundColor(0xFF212121);
		
		linear7.setBackgroundColor(0xFF212121);
		
		linear8.setBackgroundColor(0xFF212121);
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
			textview11.setTextColor(0xFFFFFFFF);
			textview12.setTextColor(0xFFFFFFFF);
			textview13.setTextColor(0xFFFFFFFF);
			textview14.setTextColor(0xFFFFFFFF);
			textview15.setTextColor(0xFFFFFFFF);
			textview16.setTextColor(0xFFFFFFFF);
			textview17.setTextColor(0xFFFFFFFF);
			textview18.setTextColor(0xFFFFFFFF);
			textview19.setTextColor(0xFFFFFFFF);
			textview20.setTextColor(0xFFFFFFFF);
			textview21.setTextColor(0xFFFFFFFF);
			textview22.setTextColor(0xFFFFFFFF);
			textview23.setTextColor(0xFFFFFFFF);
			textview24.setTextColor(0xFFFFFFFF);
			textview25.setTextColor(0xFFFFFFFF);
			textview26.setTextColor(0xFFFFFFFF);
			textview27.setTextColor(0xFFFFFFFF);
		
		textview28.setTextColor(0xFFFFFFFF);
		
		textview29.setTextColor(0xFFFFFFFF);
			textview30.setTextColor(0xFFFFFFFF);
			textview31.setTextColor(0xFFFFFFFF);
			textview32.setTextColor(0xFFFFFFFF);
			textview33.setTextColor(0xFFFFFFFF);
			textview34.setTextColor(0xFFFFFFFF);
			textview35.setTextColor(0xFFFFFFFF);
			textview36.setTextColor(0xFFFFFFFF);
			textview37.setTextColor(0xFFFFFFFF);
		
		textview38.setTextColor(0xFFFFFFFF);
			textview39.setTextColor(0xFFFFFFFF);
			textview40.setTextColor(0xFFFFFFFF);
		
			textview41.setTextColor(0xFFFFFFFF);
		
		textview42.setTextColor(0xFFFFFFFF);
			textview43.setTextColor(0xFFFFFFFF);
			textview44.setTextColor(0xFFFFFFFF);
			textview45.setTextColor(0xFFFFFFFF);
			textview46.setTextColor(0xFFFFFFFF);
		
		textview47.setTextColor(0xFFFFFFFF);
		
		textview48.setTextColor(0xFFFFFFFF);
	}
	
	
	public void _textview () {
		textview14.setText("Watermeal is the World's Smallest Flowering plant. As you can see from the image one dot is a individual plant. They are all over the world in the ponds. Although It's not useful though because many complained about Watermeal that blocking the sun rays of the pond.");
		textview25.setText("Some facts about Jasmine and The World.\n\n👉 Syria: The Syrian City is known as The City Of Jasmines.\n\n👉 Hawaii: Jasmine sambac (\"pikake\") is a common flower used in leis, and is the subject of many Hawaiian songs.\n\n👉  Indonesia: Jasminum sambac is the national flower, adopted at 1990 in Indonesia.\n\n👉 Pakistan: Jasmine officinale is known as the \"chambeli\" or \"yasmin\", it is the national flower.\n\n👉 Philippines: Jasmine sambac is the national flower. Adopted at 1935 in Philippines.\n\n👉 Thailand: Jasmine flowers are used as a symbol of motherhood.");
		textview27.setText("It is mainly cultivated for its flowers. Jasmine flowers are worn by womens in South and South East Asia. Jasmine Tea also prepared traditionally in China where they call it as Jasmine Flower Tea. Also in Okinawa, Japan, Jasmine Tea is called as sanpin cha.");
		textview35.setText("Do you think that growing roses are easy in your garden? If you say no, you are correct. Because Roses are affected by number of diseases. Cultivated Roses have severe damage from animals, Insects and Fungus diseases. In more cases they can't be used without proper care and treatment.");
		textview37.setText("Really Roses have many uses and cultivating it but The uses are very useful to us. Here are some uses of roses.\n\n👉 Ornamental Uses: Roses are the beat flower to grow in gardens because of their attractive color and their Fragrance.\n\n👉 Perfumes: Beacause of their Fragrance, Many Companies create rose perfumes worldwide for their profit.\n\n👉 Foods: Yes, Roses are used to make foods, sometimes they are made to jam, jelly, soups and even tea because of their high vitamin C.\n\n👉 Medicines: Because of their high Vitamin C, they are used as medicines for some deseases.\n\n👉 Art: Yes, Many old paintings have roses because it symoblizes  some secret meaning in their arts.");
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