package jfj.example.ghostdetector;

//Text to speech code used from
/**
 * Author : James Elsey
 * Date : 26/Feb/2011
 * Title : TextToSpeechDemo
 * URL : Http://www.JamesElsey.co.uk
 */
//


import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class GhostTalk extends Activity implements TextToSpeech.OnInitListener
{
    private TextToSpeech mTts;
    // This code can be any value you want, its just a checksum.
    private static final int MY_DATA_CHECK_CODE = 1234;
 
    /**
     * Called when the activity is first created.
     */

	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ghosttalk_layout);
		
		Intent checkIntent = new Intent();
        checkIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkIntent, MY_DATA_CHECK_CODE);
		
		//ADDING BIG STRING LIST AS TEMPORARY MEASURE> CREATETEXT FILE AND IMPORT INTO A DICT!!!!!
        //Source from http://www.vocabulary.com/lists/190098#view=list
	    final String [] speak;  
	    speak = new String[830];  
	    speak[0]= new String("a");
	    speak[1]= new String("able");
	    speak[2]= new String("about");
	    speak[3]= new String("account");
	    speak[4]= new String("acid");
	    speak[5]= new String("across");
	    speak[6]= new String("act");
	    speak[7]= new String("addition");
	    speak[8]= new String("adjustment");
	    speak[9]= new String("advertisement");
	    speak[10]= new String("after");
	    speak[11]= new String("again");
	    speak[12]= new String("agreement");
	    speak[13]= new String("air");
	    speak[14]= new String("all");
	    speak[15]= new String("almost");
	    speak[16]= new String("amount");
	    speak[17]= new String("amusement");
	    speak[18]= new String("angle");
	    speak[19]= new String("angry");
	    speak[20]= new String("animal");
	    speak[21]= new String("answer");
	    speak[22]= new String("ant");
	    speak[23]= new String("any");
	    speak[24]= new String("apparatus");
	    speak[25]= new String("apple");
	    speak[26]= new String("approval");
	    speak[27]= new String("arch");
	    speak[28]= new String("argument");
	    speak[29]= new String("arm");
	    speak[30]= new String("army");
	    speak[31]= new String("art");
	    speak[32]= new String("as");
	    speak[33]= new String("at");
	    speak[34]= new String("attack");
	    speak[35]= new String("attempt");
	    speak[36]= new String("attention");
	    speak[37]= new String("attraction");
	    speak[38]= new String("authority");
	    speak[39]= new String("automatic");
	    speak[40]= new String("awake");
	    speak[41]= new String("baby");
	    speak[42]= new String("back");
	    speak[43]= new String("bad");
	    speak[44]= new String("bag");
	    speak[45]= new String("balance");
	    speak[46]= new String("ball");
	    speak[47]= new String("band");
	    speak[48]= new String("base");
	    speak[49]= new String("basin");
	    speak[50]= new String("basket");
	    speak[51]= new String("bath");
	    speak[52]= new String("be");
	    speak[53]= new String("beautiful");
	    speak[54]= new String("bed");
	    speak[55]= new String("bee");
	    speak[56]= new String("before");
	    speak[57]= new String("behavior");
	    speak[58]= new String("belief");
	    speak[59]= new String("bell");
	    speak[60]= new String("bent");
	    speak[61]= new String("berry");
	    speak[62]= new String("between");
	    speak[63]= new String("bird");
	    speak[64]= new String("birth");
	    speak[65]= new String("bit");
	    speak[66]= new String("bite");
	    speak[67]= new String("bitter");
	    speak[68]= new String("black");
	    speak[69]= new String("blade");
	    speak[70]= new String("blood");
	    speak[71]= new String("blow");
	    speak[72]= new String("blue");
	    speak[73]= new String("board");
	    speak[74]= new String("boat");
	    speak[75]= new String("body");
	    speak[76]= new String("boiling");
	    speak[77]= new String("bone");
	    speak[78]= new String("book");
	    speak[79]= new String("boot");
	    speak[80]= new String("bottle");
	    speak[81]= new String("box");
	    speak[82]= new String("boy");
	    speak[83]= new String("brain");
	    speak[84]= new String("brake");
	    speak[85]= new String("branch");
	    speak[86]= new String("brass");
	    speak[87]= new String("bread");
	    speak[88]= new String("breath");
	    speak[89]= new String("brick");
	    speak[90]= new String("bridge");
	    speak[91]= new String("bright");
	    speak[92]= new String("broken");
	    speak[93]= new String("brother");
	    speak[94]= new String("brown");
	    speak[95]= new String("brush");
	    speak[96]= new String("bucket");
	    speak[97]= new String("building");
	    speak[98]= new String("bulb");
	    speak[99]= new String("burn");
	    speak[100]= new String("burst");
	    speak[101]= new String("business");
	    speak[102]= new String("but");
	    speak[103]= new String("butter");
	    speak[104]= new String("button");
	    speak[105]= new String("by");
	    speak[106]= new String("cake");
	    speak[107]= new String("camera");
	    speak[108]= new String("canvas");
	    speak[109]= new String("card");
	    speak[110]= new String("care");
	    speak[111]= new String("carriage");
	    speak[112]= new String("cart");
	    speak[113]= new String("cat");
	    speak[114]= new String("cause");
	    speak[115]= new String("certain");
	    speak[116]= new String("chain");
	    speak[117]= new String("chalk");
	    speak[118]= new String("chance");
	    speak[119]= new String("change");
	    speak[120]= new String("cheap");
	    speak[121]= new String("cheese");
	    speak[122]= new String("chemical");
	    speak[123]= new String("chest");
	    speak[124]= new String("chief");
	    speak[125]= new String("chin");
	    speak[126]= new String("church");
	    speak[127]= new String("circle");
	    speak[128]= new String("clean");
	    speak[129]= new String("clear");
	    speak[130]= new String("clock");
	    speak[131]= new String("cloth");
	    speak[132]= new String("cloud");
	    speak[133]= new String("coal");
	    speak[134]= new String("coat");
	    speak[135]= new String("cold");
	    speak[136]= new String("collar");
	    speak[137]= new String("color");
	    speak[138]= new String("comb");
	    speak[139]= new String("come");
	    speak[140]= new String("comfort");
	    speak[141]= new String("committee");
	    speak[142]= new String("common");
	    speak[143]= new String("company");
	    speak[144]= new String("comparison");
	    speak[145]= new String("competition");
	    speak[146]= new String("complete");
	    speak[147]= new String("complex");
	    speak[148]= new String("condition");
	    speak[149]= new String("connection");
	    speak[150]= new String("conscious");
	    speak[151]= new String("control");
	    speak[152]= new String("cook");
	    speak[153]= new String("copper");
	    speak[154]= new String("copy");
	    speak[155]= new String("cord");
	    speak[156]= new String("cork");
	    speak[157]= new String("cotton");
	    speak[158]= new String("cough");
	    speak[159]= new String("country");
	    speak[160]= new String("cover");
	    speak[161]= new String("cow");
	    speak[162]= new String("crack");
	    speak[163]= new String("credit");
	    speak[164]= new String("crime");
	    speak[165]= new String("cruel");
	    speak[166]= new String("crush");
	    speak[167]= new String("cry");
	    speak[168]= new String("cup");
	    speak[169]= new String("current");
	    speak[170]= new String("curtain");
	    speak[171]= new String("curve");
	    speak[172]= new String("cushion");
	    speak[173]= new String("cut");
	    speak[174]= new String("damage");
	    speak[175]= new String("danger");
	    speak[176]= new String("dark");
	    speak[177]= new String("daughter");
	    speak[178]= new String("day");
	    speak[179]= new String("dead");
	    speak[180]= new String("dear");
	    speak[181]= new String("death");
	    speak[182]= new String("debt");
	    speak[183]= new String("decision");
	    speak[184]= new String("deep");
	    speak[185]= new String("degree");
	    speak[186]= new String("delicate");
	    speak[187]= new String("dependent");
	    speak[188]= new String("design");
	    speak[189]= new String("desire");
	    speak[190]= new String("destruction");
	    speak[191]= new String("detail");
	    speak[192]= new String("development");
	    speak[193]= new String("different");
	    speak[194]= new String("digestion");
	    speak[195]= new String("direction");
	    speak[196]= new String("dirty");
	    speak[197]= new String("discovery");
	    speak[198]= new String("discussion");
	    speak[199]= new String("disease");
	    speak[200]= new String("disgust");
	    speak[201]= new String("distance");
	    speak[202]= new String("distribution");
	    speak[203]= new String("division");
	    speak[204]= new String("do");
	    speak[205]= new String("dog");
	    speak[206]= new String("door");
	    speak[207]= new String("doubt");
	    speak[208]= new String("down");
	    speak[209]= new String("drain");
	    speak[210]= new String("drawer");
	    speak[211]= new String("dress");
	    speak[212]= new String("drink");
	    speak[213]= new String("driving");
	    speak[214]= new String("drop");
	    speak[215]= new String("dry");
	    speak[216]= new String("dust");
	    speak[217]= new String("ear");
	    speak[218]= new String("early");
	    speak[219]= new String("earth");
	    speak[220]= new String("east");
	    speak[221]= new String("edge");
	    speak[222]= new String("education");
	    speak[223]= new String("effect");
	    speak[224]= new String("egg");
	    speak[225]= new String("elastic");
	    speak[226]= new String("electric");
	    speak[227]= new String("end");
	    speak[228]= new String("engine");
	    speak[229]= new String("enough");
	    speak[230]= new String("equal");
	    speak[231]= new String("error");
	    speak[232]= new String("even");
	    speak[233]= new String("event");
	    speak[234]= new String("ever");
	    speak[235]= new String("every");
	    speak[236]= new String("example");
	    speak[237]= new String("exchange");
	    speak[238]= new String("existence");
	    speak[239]= new String("expansion");
	    speak[240]= new String("experience");
	    speak[241]= new String("expert");
	    speak[242]= new String("eye");
	    speak[243]= new String("face");
	    speak[244]= new String("fact");
	    speak[245]= new String("fall");
	    speak[246]= new String("FALSE");
	    speak[247]= new String("family");
	    speak[248]= new String("far");
	    speak[249]= new String("farm");
	    speak[250]= new String("fat");
	    speak[251]= new String("father");
	    speak[252]= new String("fear");
	    speak[253]= new String("feather");
	    speak[254]= new String("feeble");
	    speak[255]= new String("feeling");
	    speak[256]= new String("female");
	    speak[257]= new String("fertile");
	    speak[258]= new String("fiction");
	    speak[259]= new String("field");
	    speak[260]= new String("fight");
	    speak[261]= new String("finger");
	    speak[262]= new String("fire");
	    speak[263]= new String("first");
	    speak[264]= new String("fish");
	    speak[265]= new String("fixed");
	    speak[266]= new String("flag");
	    speak[267]= new String("flame");
	    speak[268]= new String("flat");
	    speak[269]= new String("flight");
	    speak[270]= new String("floor");
	    speak[271]= new String("flower");
	    speak[272]= new String("fly");
	    speak[273]= new String("fold");
	    speak[274]= new String("food");
	    speak[275]= new String("foolish");
	    speak[276]= new String("foot");
	    speak[277]= new String("force");
	    speak[278]= new String("fork");
	    speak[279]= new String("form");
	    speak[280]= new String("forward");
	    speak[281]= new String("fowl");
	    speak[282]= new String("frame");
	    speak[283]= new String("free");
	    speak[284]= new String("frequent");
	    speak[285]= new String("friend");
	    speak[286]= new String("front");
	    speak[287]= new String("fruit");
	    speak[288]= new String("full");
	    speak[289]= new String("future");
	    speak[290]= new String("garden");
	    speak[291]= new String("general");
	    speak[292]= new String("get");
	    speak[293]= new String("girl");
	    speak[294]= new String("give");
	    speak[295]= new String("glass");
	    speak[296]= new String("glove");
	    speak[297]= new String("go");
	    speak[298]= new String("goat");
	    speak[299]= new String("gold");
	    speak[300]= new String("good");
	    speak[301]= new String("government");
	    speak[302]= new String("grain");
	    speak[303]= new String("grass");
	    speak[304]= new String("great");
	    speak[305]= new String("green");
	    speak[306]= new String("grey");
	    speak[307]= new String("grip");
	    speak[308]= new String("group");
	    speak[309]= new String("growth");
	    speak[310]= new String("guide");
	    speak[311]= new String("gun");
	    speak[312]= new String("hair");
	    speak[313]= new String("hammer");
	    speak[314]= new String("hand");
	    speak[315]= new String("hanging");
	    speak[316]= new String("happy");
	    speak[317]= new String("harbor");
	    speak[318]= new String("hard");
	    speak[319]= new String("harmony");
	    speak[320]= new String("hat");
	    speak[321]= new String("hate");
	    speak[322]= new String("have");
	    speak[323]= new String("he");
	    speak[324]= new String("head");
	    speak[325]= new String("healthy");
	    speak[326]= new String("hearing");
	    speak[327]= new String("heart");
	    speak[328]= new String("heat");
	    speak[329]= new String("help");
	    speak[330]= new String("here");
	    speak[331]= new String("high");
	    speak[332]= new String("history");
	    speak[333]= new String("hole");
	    speak[334]= new String("hollow");
	    speak[335]= new String("hook");
	    speak[336]= new String("hope");
	    speak[337]= new String("horn");
	    speak[338]= new String("horse");
	    speak[339]= new String("hospital");
	    speak[340]= new String("hour");
	    speak[341]= new String("house");
	    speak[342]= new String("humor");
	    speak[343]= new String("I");
	    speak[344]= new String("ice");
	    speak[345]= new String("idea");
	    speak[346]= new String("ill");
	    speak[347]= new String("important");
	    speak[348]= new String("impulse");
	    speak[349]= new String("in");
	    speak[350]= new String("increase");
	    speak[351]= new String("industry");
	    speak[352]= new String("ink");
	    speak[353]= new String("insect");
	    speak[354]= new String("instrument");
	    speak[355]= new String("insurance");
	    speak[356]= new String("interest");
	    speak[357]= new String("invention");
	    speak[358]= new String("iron");
	    speak[359]= new String("island");
	    speak[360]= new String("jelly");
	    speak[361]= new String("jewel");
	    speak[362]= new String("join");
	    speak[363]= new String("journey");
	    speak[364]= new String("judge");
	    speak[365]= new String("jump");
	    speak[366]= new String("keep");
	    speak[367]= new String("kettle");
	    speak[368]= new String("key");
	    speak[369]= new String("kick");
	    speak[370]= new String("kind");
	    speak[371]= new String("kiss");
	    speak[372]= new String("knee");
	    speak[373]= new String("knife");
	    speak[374]= new String("knot");
	    speak[375]= new String("knowledge");
	    speak[376]= new String("land");
	    speak[377]= new String("language");
	    speak[378]= new String("last");
	    speak[379]= new String("late");
	    speak[380]= new String("laugh");
	    speak[381]= new String("law");
	    speak[382]= new String("lead");
	    speak[383]= new String("leaf");
	    speak[384]= new String("learning");
	    speak[385]= new String("leather");
	    speak[386]= new String("left");
	    speak[387]= new String("leg");
	    speak[388]= new String("let");
	    speak[389]= new String("letter");
	    speak[390]= new String("level");
	    speak[391]= new String("library");
	    speak[392]= new String("lift");
	    speak[393]= new String("light");
	    speak[394]= new String("like");
	    speak[395]= new String("limit");
	    speak[396]= new String("line");
	    speak[397]= new String("linen");
	    speak[398]= new String("lip");
	    speak[399]= new String("liquid");
	    speak[400]= new String("list");
	    speak[401]= new String("little");
	    speak[402]= new String("living");
	    speak[403]= new String("lock");
	    speak[404]= new String("long");
	    speak[405]= new String("look");
	    speak[406]= new String("loose");
	    speak[407]= new String("loss");
	    speak[408]= new String("loud");
	    speak[409]= new String("love");
	    speak[410]= new String("low");
	    speak[411]= new String("machine");
	    speak[412]= new String("make");
	    speak[413]= new String("male");
	    speak[414]= new String("man");
	    speak[415]= new String("manager");
	    speak[416]= new String("map");
	    speak[417]= new String("mark");
	    speak[418]= new String("market");
	    speak[419]= new String("married");
	    speak[420]= new String("mass");
	    speak[421]= new String("match");
	    speak[422]= new String("material");
	    speak[423]= new String("may");
	    speak[424]= new String("meal");
	    speak[425]= new String("measure");
	    speak[426]= new String("meat");
	    speak[427]= new String("medical");
	    speak[428]= new String("meeting");
	    speak[429]= new String("memory");
	    speak[430]= new String("metal");
	    speak[431]= new String("middle");
	    speak[432]= new String("military");
	    speak[433]= new String("milk");
	    speak[434]= new String("mind");
	    speak[435]= new String("mine");
	    speak[436]= new String("minute");
	    speak[437]= new String("mist");
	    speak[438]= new String("mixed");
	    speak[439]= new String("money");
	    speak[440]= new String("monkey");
	    speak[441]= new String("month");
	    speak[442]= new String("moon");
	    speak[443]= new String("morning");
	    speak[444]= new String("mother");
	    speak[445]= new String("motion");
	    speak[446]= new String("mountain");
	    speak[447]= new String("mouth");
	    speak[448]= new String("move");
	    speak[449]= new String("much");
	    speak[450]= new String("muscle");
	    speak[451]= new String("music");
	    speak[452]= new String("nail");
	    speak[453]= new String("name");
	    speak[454]= new String("narrow");
	    speak[455]= new String("nation");
	    speak[456]= new String("natural");
	    speak[457]= new String("near");
	    speak[458]= new String("necessary");
	    speak[459]= new String("neck");
	    speak[460]= new String("need");
	    speak[461]= new String("needle");
	    speak[462]= new String("nerve");
	    speak[463]= new String("net");
	    speak[464]= new String("new");
	    speak[465]= new String("news");
	    speak[466]= new String("night");
	    speak[467]= new String("no");
	    speak[468]= new String("noise");
	    speak[469]= new String("normal");
	    speak[470]= new String("north");
	    speak[471]= new String("nose");
	    speak[472]= new String("not");
	    speak[473]= new String("note");
	    speak[474]= new String("now");
	    speak[475]= new String("number");
	    speak[476]= new String("nut");
	    speak[477]= new String("observation");
	    speak[478]= new String("off");
	    speak[479]= new String("offer");
	    speak[480]= new String("office");
	    speak[481]= new String("oil");
	    speak[482]= new String("old");
	    speak[483]= new String("on");
	    speak[484]= new String("only");
	    speak[485]= new String("open");
	    speak[486]= new String("operation");
	    speak[487]= new String("opinion");
	    speak[488]= new String("opposite");
	    speak[489]= new String("orange");
	    speak[490]= new String("order");
	    speak[491]= new String("organization");
	    speak[492]= new String("ornament");
	    speak[493]= new String("other");
	    speak[494]= new String("out");
	    speak[495]= new String("oven");
	    speak[496]= new String("over");
	    speak[497]= new String("owner");
	    speak[498]= new String("page");
	    speak[499]= new String("pain");
	    speak[500]= new String("paint");
	    speak[501]= new String("paper");
	    speak[502]= new String("parallel");
	    speak[503]= new String("parcel");
	    speak[504]= new String("part");
	    speak[505]= new String("past");
	    speak[506]= new String("paste");
	    speak[507]= new String("payment");
	    speak[508]= new String("peace");
	    speak[509]= new String("pen");
	    speak[510]= new String("pencil");
	    speak[511]= new String("person");
	    speak[512]= new String("physical");
	    speak[513]= new String("picture");
	    speak[514]= new String("pig");
	    speak[515]= new String("pin");
	    speak[516]= new String("pipe");
	    speak[517]= new String("place");
	    speak[518]= new String("plane");
	    speak[519]= new String("plant");
	    speak[520]= new String("plate");
	    speak[521]= new String("play");
	    speak[522]= new String("please");
	    speak[523]= new String("pleasure");
	    speak[524]= new String("plough");
	    speak[525]= new String("pocket");
	    speak[526]= new String("point");
	    speak[527]= new String("poison");
	    speak[528]= new String("polish");
	    speak[529]= new String("political");
	    speak[530]= new String("poor");
	    speak[531]= new String("porter");
	    speak[532]= new String("position");
	    speak[533]= new String("possible");
	    speak[534]= new String("pot");
	    speak[535]= new String("potato");
	    speak[536]= new String("powder");
	    speak[537]= new String("power");
	    speak[538]= new String("present");
	    speak[539]= new String("price");
	    speak[540]= new String("print");
	    speak[541]= new String("prison");
	    speak[542]= new String("private");
	    speak[543]= new String("probable");
	    speak[544]= new String("process");
	    speak[545]= new String("produce");
	    speak[546]= new String("profit");
	    speak[547]= new String("property");
	    speak[548]= new String("prose");
	    speak[549]= new String("protest");
	    speak[550]= new String("public");
	    speak[551]= new String("pull");
	    speak[552]= new String("pump");
	    speak[553]= new String("punishment");
	    speak[554]= new String("purpose");
	    speak[555]= new String("push");
	    speak[556]= new String("put");
	    speak[557]= new String("quality");
	    speak[558]= new String("question");
	    speak[559]= new String("quick");
	    speak[560]= new String("quiet");
	    speak[561]= new String("quite");
	    speak[562]= new String("rail");
	    speak[563]= new String("rain");
	    speak[564]= new String("range");
	    speak[565]= new String("rat");
	    speak[566]= new String("rate");
	    speak[567]= new String("ray");
	    speak[568]= new String("reaction");
	    speak[569]= new String("reading");
	    speak[570]= new String("ready");
	    speak[571]= new String("reason");
	    speak[572]= new String("receipt");
	    speak[573]= new String("record");
	    speak[574]= new String("red");
	    speak[575]= new String("regret");
	    speak[576]= new String("regular");
	    speak[577]= new String("relation");
	    speak[578]= new String("religion");
	    speak[579]= new String("representative");
	    speak[580]= new String("request");
	    speak[581]= new String("respect");
	    speak[582]= new String("responsible");
	    speak[583]= new String("rest");
	    speak[584]= new String("reward");
	    speak[585]= new String("rhythm");
	    speak[586]= new String("rice");
	    speak[587]= new String("right");
	    speak[588]= new String("ring");
	    speak[589]= new String("river");
	    speak[590]= new String("road");
	    speak[591]= new String("rod");
	    speak[592]= new String("roll");
	    speak[593]= new String("roof");
	    speak[594]= new String("room");
	    speak[595]= new String("root");
	    speak[596]= new String("rough");
	    speak[597]= new String("round");
	    speak[598]= new String("rub");
	    speak[599]= new String("rule");
	    speak[600]= new String("run");
	    speak[601]= new String("sad");
	    speak[602]= new String("safe");
	    speak[603]= new String("sail");
	    speak[604]= new String("salt");
	    speak[605]= new String("same");
	    speak[606]= new String("sand");
	    speak[607]= new String("say");
	    speak[608]= new String("scale");
	    speak[609]= new String("school");
	    speak[610]= new String("science");
	    speak[611]= new String("scissors");
	    speak[612]= new String("screw");
	    speak[613]= new String("sea");
	    speak[614]= new String("seat");
	    speak[615]= new String("second");
	    speak[616]= new String("secret");
	    speak[617]= new String("secretary");
	    speak[618]= new String("see");
	    speak[619]= new String("seed");
	    speak[620]= new String("seem");
	    speak[621]= new String("selection");
	    speak[622]= new String("self");
	    speak[623]= new String("send");
	    speak[624]= new String("sense");
	    speak[625]= new String("separate");
	    speak[626]= new String("serious");
	    speak[627]= new String("servant");
	    speak[628]= new String("sex");
	    speak[629]= new String("shade");
	    speak[630]= new String("shake");
	    speak[631]= new String("shame");
	    speak[632]= new String("sharp");
	    speak[633]= new String("sheep");
	    speak[634]= new String("shelf");
	    speak[635]= new String("ship");
	    speak[636]= new String("shirt");
	    speak[637]= new String("shock");
	    speak[638]= new String("shoe");
	    speak[639]= new String("short");
	    speak[640]= new String("shut");
	    speak[641]= new String("side");
	    speak[642]= new String("sign");
	    speak[643]= new String("silk");
	    speak[644]= new String("silver");
	    speak[645]= new String("simple");
	    speak[646]= new String("sister");
	    speak[647]= new String("size");
	    speak[648]= new String("skin");
	    speak[649]= new String("skirt");
	    speak[650]= new String("sky");
	    speak[651]= new String("sleep");
	    speak[652]= new String("slip");
	    speak[653]= new String("slope");
	    speak[654]= new String("slow");
	    speak[655]= new String("small");
	    speak[656]= new String("smash");
	    speak[657]= new String("smell");
	    speak[658]= new String("smile");
	    speak[659]= new String("smoke");
	    speak[660]= new String("smooth");
	    speak[661]= new String("snake");
	    speak[662]= new String("sneeze");
	    speak[663]= new String("snow");
	    speak[664]= new String("so");
	    speak[665]= new String("soap");
	    speak[666]= new String("society");
	    speak[667]= new String("sock");
	    speak[668]= new String("soft");
	    speak[669]= new String("solid");
	    speak[670]= new String("some");
	    speak[671]= new String("son");
	    speak[672]= new String("song");
	    speak[673]= new String("sort");
	    speak[674]= new String("sound");
	    speak[675]= new String("soup");
	    speak[676]= new String("south");
	    speak[677]= new String("space");
	    speak[678]= new String("spade");
	    speak[679]= new String("special");
	    speak[680]= new String("sponge");
	    speak[681]= new String("spoon");
	    speak[682]= new String("spring");
	    speak[683]= new String("square");
	    speak[684]= new String("stage");
	    speak[685]= new String("stamp");
	    speak[686]= new String("star");
	    speak[687]= new String("start");
	    speak[688]= new String("statement");
	    speak[689]= new String("station");
	    speak[690]= new String("steam");
	    speak[691]= new String("steel");
	    speak[692]= new String("stem");
	    speak[693]= new String("step");
	    speak[694]= new String("stick");
	    speak[695]= new String("sticky");
	    speak[696]= new String("stiff");
	    speak[697]= new String("still");
	    speak[698]= new String("stitch");
	    speak[699]= new String("stocking");
	    speak[700]= new String("stomach");
	    speak[701]= new String("stone");
	    speak[702]= new String("stop");
	    speak[703]= new String("store");
	    speak[704]= new String("story");
	    speak[705]= new String("straight");
	    speak[706]= new String("strange");
	    speak[707]= new String("street");
	    speak[708]= new String("stretch");
	    speak[709]= new String("strong");
	    speak[710]= new String("structure");
	    speak[711]= new String("substance");
	    speak[712]= new String("such");
	    speak[713]= new String("sudden");
	    speak[714]= new String("sugar");
	    speak[715]= new String("suggestion");
	    speak[716]= new String("summer");
	    speak[717]= new String("sun");
	    speak[718]= new String("support");
	    speak[719]= new String("surprise");
	    speak[720]= new String("sweet");
	    speak[721]= new String("swim");
	    speak[722]= new String("system");
	    speak[723]= new String("table");
	    speak[724]= new String("tail");
	    speak[725]= new String("take");
	    speak[726]= new String("talk");
	    speak[727]= new String("tall");
	    speak[728]= new String("taste");
	    speak[729]= new String("tax");
	    speak[730]= new String("teaching");
	    speak[731]= new String("tendency");
	    speak[732]= new String("test");
	    speak[733]= new String("then");
	    speak[734]= new String("theory");
	    speak[735]= new String("there");
	    speak[736]= new String("thick");
	    speak[737]= new String("thin");
	    speak[738]= new String("thing");
	    speak[739]= new String("though");
	    speak[740]= new String("thought");
	    speak[741]= new String("thread");
	    speak[742]= new String("throat");
	    speak[743]= new String("through");
	    speak[744]= new String("thumb");
	    speak[745]= new String("thunder");
	    speak[746]= new String("ticket");
	    speak[747]= new String("tight");
	    speak[748]= new String("till");
	    speak[749]= new String("time");
	    speak[750]= new String("tin");
	    speak[751]= new String("tired");
	    speak[752]= new String("toe");
	    speak[753]= new String("together");
	    speak[754]= new String("tomorrow");
	    speak[755]= new String("tongue");
	    speak[756]= new String("tooth");
	    speak[757]= new String("top");
	    speak[758]= new String("touch");
	    speak[759]= new String("town");
	    speak[760]= new String("trade");
	    speak[761]= new String("train");
	    speak[762]= new String("transport");
	    speak[763]= new String("tray");
	    speak[764]= new String("tree");
	    speak[765]= new String("trick");
	    speak[766]= new String("trouble");
	    speak[767]= new String("trouser");
	    speak[768]= new String("TRUE");
	    speak[769]= new String("turn");
	    speak[770]= new String("twist");
	    speak[771]= new String("umbrella");
	    speak[772]= new String("under");
	    speak[773]= new String("unit");
	    speak[774]= new String("up");
	    speak[775]= new String("use");
	    speak[776]= new String("value");
	    speak[777]= new String("verse");
	    speak[778]= new String("very");
	    speak[779]= new String("vessel");
	    speak[780]= new String("view");
	    speak[781]= new String("violent");
	    speak[782]= new String("voice");
	    speak[783]= new String("waiting");
	    speak[784]= new String("walk");
	    speak[785]= new String("wall");
	    speak[786]= new String("war");
	    speak[787]= new String("warm");
	    speak[788]= new String("wash");
	    speak[789]= new String("waste");
	    speak[790]= new String("watch");
	    speak[791]= new String("water");
	    speak[792]= new String("wave");
	    speak[793]= new String("wax");
	    speak[794]= new String("way");
	    speak[795]= new String("weather");
	    speak[796]= new String("week");
	    speak[797]= new String("weight");
	    speak[798]= new String("well");
	    speak[799]= new String("west");
	    speak[800]= new String("wet");
	    speak[801]= new String("wheel");
	    speak[802]= new String("while");
	    speak[803]= new String("whip");
	    speak[804]= new String("whistle");
	    speak[805]= new String("white");
	    speak[806]= new String("why");
	    speak[807]= new String("wide");
	    speak[808]= new String("will");
	    speak[809]= new String("wind");
	    speak[810]= new String("window");
	    speak[811]= new String("wine");
	    speak[812]= new String("wing");
	    speak[813]= new String("winter");
	    speak[814]= new String("wire");
	    speak[815]= new String("wise");
	    speak[816]= new String("woman");
	    speak[817]= new String("wood");
	    speak[818]= new String("wool");
	    speak[819]= new String("word");
	    speak[820]= new String("work");
	    speak[821]= new String("worm");
	    speak[822]= new String("wound");
	    speak[823]= new String("writing");
	    speak[824]= new String("wrong");
	    speak[825]= new String("year");
	    speak[826]= new String("yellow");
	    speak[827]= new String("yes");
	    speak[828]= new String("yesterday");
	    speak[829]= new String("young");

	    final int min = 0;
	    final int max = 830;
	    
	    final int minPicks = 1;
	    final int maxPicks = 5;

	    
	    //Onclick go through two random generators
	    Button speakButton = (Button) findViewById(R.id.btnSpeak);
		speakButton.setOnClickListener(new OnClickListener()
		{
		
			//Dear spirit - If you can read this please first pick how many words you would like to say between 1 and 5
			@Override
			public void onClick(View v) {
				Random r2 = new Random();
			    int i2 = r2.nextInt(maxPicks - minPicks + 1) + minPicks;
			  // Toast.makeText(getBaseContext(), Integer.toString(i2), Toast.LENGTH_LONG).show();
               String ghost = "";
			    
               //Thank you spirit - Now from the big list above, please pick the numbers beside the words you would like to say
			    for (int x=0; x<i2; x++)
			    {
			    	if (x<i2){
			    	Random r = new Random();
				     int ir = r.nextInt(max - min + 1) + min;
				     ghost = ghost + " " + speak[ir] + " ";
			    	}
				}
			    
			    //Thank you
				Toast.makeText(getBaseContext(), ghost, Toast.LENGTH_LONG).show();
		     {
				        mTts.speak(ghost,
				                TextToSpeech.QUEUE_FLUSH,  // Drop all pending entries in the playback queue.
				                null);
			    }
			}
			
		});
	}
    /**
     * Executed when a new TTS is instantiated. Some static text is spoken via TTS here.
     * @param i
     */
 
 
    /**
     * This is the callback from the TTS engine check, if a TTS is installed we
     * create a new TTS instance (which in turn calls onInit), if not then we will
     * create an intent to go off and install a TTS engine
     * @param requestCode int Request code returned from the check for TTS engine.
     * @param resultCode int Result code returned from the check for TTS engine.
     * @param data Intent Intent returned from the TTS check.
     */
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == MY_DATA_CHECK_CODE)
        {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS)
            {
                // success, create the TTS instance
                mTts = new TextToSpeech(this, this);
            }
            else
            {
                // missing data, install it
                Intent installIntent = new Intent();
                installIntent.setAction(
                        TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(installIntent);
            }
        }
    }
 
    /**
     * Be kind, once you've finished with the TTS engine, shut it down so other
     * applications can use it without us interfering with it :)
     */
    @Override
    public void onDestroy()
    {
        // Don't forget to shutdown!
        if (mTts != null)
        {
            mTts.stop();
            mTts.shutdown();
        }
        super.onDestroy();
    }
	@Override
	 public void onInit(int i)
    {
        mTts.speak("Welcome to Ghost Talk",
                TextToSpeech.QUEUE_FLUSH,  // Drop all pending entries in the playback queue.
                null);
    }
}