package com.toh.carection;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class RegistrationOpenHelper extends SQLiteOpenHelper {
	// Database name
	public static final String DATABASE_NAME = "REGISTRATION_DB";

	// Table names
	public static final String TABLE_NAME1 = "REGISTRATION_TABLE1";
	public static final String TABLE_NAME2 = "REGISTRATION_TABLE2";
	public static final String TABLE_NAME3 = "REGISTRATION_TABLE3";
	public static final String TABLE_NAME4 = "REGISTRATION_TABLE4";
	public static final String TABLE_NAME5 = "REGISTRATION_TABLE5";
	public static final String TABLE_NAME6 = "REGISTRATION_TABLE6";
	public static final String TABLE_NAME7 = "REGISTRATION_TABLE7";
	public static final String TABLE_NAME8 = "REGISTRATION_TABLE8";

	public static final int VERSION = 1;
	public static final String KEY_ID = "_id";
	public static final String SQUARE111 = "SQUARE111";
	public static final String SQUARE112 = "SQUARE112";
	public static final String SQUARE113 = "SQUARE113";
	public static final String SQUARE114 = "SQUARE114";
	public static final String SQUARE115 = "SQUARE115";
	public static final String SQUARE116 = "SQUARE116";
	public static final String SQUARE117 = "SQUARE117";
	public static final String SQUARE118 = "SQUARE118";

	public static final String SQUARE121 = "SQUARE121";
	public static final String SQUARE122 = "SQUARE122";
	public static final String SQUARE123 = "SQUARE123";
	public static final String SQUARE124 = "SQUARE124";
	public static final String SQUARE125 = "SQUARE125";
	public static final String SQUARE126 = "SQUARE126";
	public static final String SQUARE127 = "SQUARE127";
	public static final String SQUARE128 = "SQUARE128";

	public static final String SQUARE131 = "SQUARE131";
	public static final String SQUARE132 = "SQUARE132";
	public static final String SQUARE133 = "SQUARE133";
	public static final String SQUARE134 = "SQUARE134";
	public static final String SQUARE135 = "SQUARE135";
	public static final String SQUARE136 = "SQUARE136";
	public static final String SQUARE137 = "SQUARE137";
	public static final String SQUARE138 = "SQUARE138";

	public static final String SQUARE141 = "SQUARE141";
	public static final String SQUARE142 = "SQUARE142";
	public static final String SQUARE143 = "SQUARE143";
	public static final String SQUARE144 = "SQUARE144";
	public static final String SQUARE145 = "SQUARE145";
	public static final String SQUARE146 = "SQUARE146";
	public static final String SQUARE147 = "SQUARE147";
	public static final String SQUARE148 = "SQUARE148";

	public static final String SQUARE151 = "SQUARE151";
	public static final String SQUARE152 = "SQUARE152";
	public static final String SQUARE153 = "SQUARE153";
	public static final String SQUARE154 = "SQUARE154";
	public static final String SQUARE155 = "SQUARE155";
	public static final String SQUARE156 = "SQUARE156";
	public static final String SQUARE157 = "SQUARE157";
	public static final String SQUARE158 = "SQUARE158";

	public static final String SQUARE211 = "SQUARE211";
	public static final String SQUARE212 = "SQUARE212";
	public static final String SQUARE213 = "SQUARE213";
	public static final String SQUARE214 = "SQUARE214";
	public static final String SQUARE215 = "SQUARE215";
	public static final String SQUARE216 = "SQUARE216";
	public static final String SQUARE217 = "SQUARE217";
	public static final String SQUARE218 = "SQUARE218";

	public static final String SQUARE221 = "SQUARE221";
	public static final String SQUARE222 = "SQUARE222";
	public static final String SQUARE223 = "SQUARE223";
	public static final String SQUARE224 = "SQUARE224";
	public static final String SQUARE225 = "SQUARE225";
	public static final String SQUARE226 = "SQUARE226";
	public static final String SQUARE227 = "SQUARE227";
	public static final String SQUARE228 = "SQUARE228";

	public static final String SQUARE231 = "SQUARE231";
	public static final String SQUARE232 = "SQUARE232";
	public static final String SQUARE233 = "SQUARE233";
	public static final String SQUARE234 = "SQUARE234";
	public static final String SQUARE235 = "SQUARE235";
	public static final String SQUARE236 = "SQUARE236";
	public static final String SQUARE237 = "SQUARE237";
	public static final String SQUARE238 = "SQUARE238";

	public static final String SQUARE241 = "SQUARE241";
	public static final String SQUARE242 = "SQUARE242";
	public static final String SQUARE243 = "SQUARE243";
	public static final String SQUARE244 = "SQUARE244";
	public static final String SQUARE245 = "SQUARE245";
	public static final String SQUARE246 = "SQUARE246";
	public static final String SQUARE247 = "SQUARE247";
	public static final String SQUARE248 = "SQUARE248";

	public static final String SQUARE251 = "SQUARE251";
	public static final String SQUARE252 = "SQUARE252";
	public static final String SQUARE253 = "SQUARE253";
	public static final String SQUARE254 = "SQUARE254";
	public static final String SQUARE255 = "SQUARE255";
	public static final String SQUARE256 = "SQUARE256";
	public static final String SQUARE257 = "SQUARE257";
	public static final String SQUARE258 = "SQUARE258";

	public static final String SQUARE311 = "SQUARE311";
	public static final String SQUARE312 = "SQUARE312";
	public static final String SQUARE313 = "SQUARE313";
	public static final String SQUARE314 = "SQUARE314";
	public static final String SQUARE315 = "SQUARE315";
	public static final String SQUARE316 = "SQUARE316";
	public static final String SQUARE317 = "SQUARE317";
	public static final String SQUARE318 = "SQUARE318";

	public static final String SQUARE321 = "SQUARE321";
	public static final String SQUARE322 = "SQUARE322";
	public static final String SQUARE323 = "SQUARE323";
	public static final String SQUARE324 = "SQUARE324";
	public static final String SQUARE325 = "SQUARE325";
	public static final String SQUARE326 = "SQUARE326";
	public static final String SQUARE327 = "SQUARE327";
	public static final String SQUARE328 = "SQUARE328";

	public static final String SQUARE331 = "SQUARE331";
	public static final String SQUARE332 = "SQUARE332";
	public static final String SQUARE333 = "SQUARE333";
	public static final String SQUARE334 = "SQUARE334";
	public static final String SQUARE335 = "SQUARE335";
	public static final String SQUARE336 = "SQUARE336";
	public static final String SQUARE337 = "SQUARE337";
	public static final String SQUARE338 = "SQUARE338";

	public static final String SQUARE341 = "SQUARE341";
	public static final String SQUARE342 = "SQUARE342";
	public static final String SQUARE343 = "SQUARE343";
	public static final String SQUARE344 = "SQUARE344";
	public static final String SQUARE345 = "SQUARE345";
	public static final String SQUARE346 = "SQUARE346";
	public static final String SQUARE347 = "SQUARE347";
	public static final String SQUARE348 = "SQUARE348";

	public static final String SQUARE351 = "SQUARE351";
	public static final String SQUARE352 = "SQUARE352";
	public static final String SQUARE353 = "SQUARE353";
	public static final String SQUARE354 = "SQUARE354";
	public static final String SQUARE355 = "SQUARE355";
	public static final String SQUARE356 = "SQUARE356";
	public static final String SQUARE357 = "SQUARE357";
	public static final String SQUARE358 = "SQUARE358";

	public static final String SQUARE411 = "SQUARE411";
	public static final String SQUARE412 = "SQUARE412";
	public static final String SQUARE413 = "SQUARE413";
	public static final String SQUARE414 = "SQUARE414";
	public static final String SQUARE415 = "SQUARE415";
	public static final String SQUARE416 = "SQUARE416";
	public static final String SQUARE417 = "SQUARE417";
	public static final String SQUARE418 = "SQUARE418";

	public static final String SQUARE421 = "SQUARE421";
	public static final String SQUARE422 = "SQUARE422";
	public static final String SQUARE423 = "SQUARE423";
	public static final String SQUARE424 = "SQUARE424";
	public static final String SQUARE425 = "SQUARE425";
	public static final String SQUARE426 = "SQUARE426";
	public static final String SQUARE427 = "SQUARE427";
	public static final String SQUARE428 = "SQUARE428";

	public static final String SQUARE431 = "SQUARE431";
	public static final String SQUARE432 = "SQUARE432";
	public static final String SQUARE433 = "SQUARE433";
	public static final String SQUARE434 = "SQUARE434";
	public static final String SQUARE435 = "SQUARE435";
	public static final String SQUARE436 = "SQUARE436";
	public static final String SQUARE437 = "SQUARE437";
	public static final String SQUARE438 = "SQUARE438";

	public static final String SQUARE441 = "SQUARE441";
	public static final String SQUARE442 = "SQUARE442";
	public static final String SQUARE443 = "SQUARE443";
	public static final String SQUARE444 = "SQUARE444";
	public static final String SQUARE445 = "SQUARE445";
	public static final String SQUARE446 = "SQUARE446";
	public static final String SQUARE447 = "SQUARE447";
	public static final String SQUARE448 = "SQUARE448";

	public static final String SQUARE451 = "SQUARE451";
	public static final String SQUARE452 = "SQUARE452";
	public static final String SQUARE453 = "SQUARE453";
	public static final String SQUARE454 = "SQUARE454";
	public static final String SQUARE455 = "SQUARE455";
	public static final String SQUARE456 = "SQUARE456";
	public static final String SQUARE457 = "SQUARE457";
	public static final String SQUARE458 = "SQUARE458";

	public static final String SQUARE511 = "SQUARE511";
	public static final String SQUARE512 = "SQUARE512";
	public static final String SQUARE513 = "SQUARE513";
	public static final String SQUARE514 = "SQUARE514";
	public static final String SQUARE515 = "SQUARE515";
	public static final String SQUARE516 = "SQUARE516";
	public static final String SQUARE517 = "SQUARE517";
	public static final String SQUARE518 = "SQUARE518";

	public static final String SQUARE521 = "SQUARE521";
	public static final String SQUARE522 = "SQUARE522";
	public static final String SQUARE523 = "SQUARE523";
	public static final String SQUARE524 = "SQUARE524";
	public static final String SQUARE525 = "SQUARE525";
	public static final String SQUARE526 = "SQUARE526";
	public static final String SQUARE527 = "SQUARE527";
	public static final String SQUARE528 = "SQUARE528";

	public static final String SQUARE531 = "SQUARE531";
	public static final String SQUARE532 = "SQUARE532";
	public static final String SQUARE533 = "SQUARE533";
	public static final String SQUARE534 = "SQUARE534";
	public static final String SQUARE535 = "SQUARE535";
	public static final String SQUARE536 = "SQUARE536";
	public static final String SQUARE537 = "SQUARE537";
	public static final String SQUARE538 = "SQUARE538";

	public static final String SQUARE541 = "SQUARE541";
	public static final String SQUARE542 = "SQUARE542";
	public static final String SQUARE543 = "SQUARE543";
	public static final String SQUARE544 = "SQUARE544";
	public static final String SQUARE545 = "SQUARE545";
	public static final String SQUARE546 = "SQUARE546";
	public static final String SQUARE547 = "SQUARE547";
	public static final String SQUARE548 = "SQUARE548";

	public static final String SQUARE551 = "SQUARE551";
	public static final String SQUARE552 = "SQUARE552";
	public static final String SQUARE553 = "SQUARE553";
	public static final String SQUARE554 = "SQUARE554";
	public static final String SQUARE555 = "SQUARE555";
	public static final String SQUARE556 = "SQUARE556";
	public static final String SQUARE557 = "SQUARE557";
	public static final String SQUARE558 = "SQUARE558";

	public static final String SQUARE611 = "SQUARE611";
	public static final String SQUARE612 = "SQUARE612";
	public static final String SQUARE613 = "SQUARE613";
	public static final String SQUARE614 = "SQUARE614";
	public static final String SQUARE615 = "SQUARE615";
	public static final String SQUARE616 = "SQUARE616";
	public static final String SQUARE617 = "SQUARE617";
	public static final String SQUARE618 = "SQUARE618";

	public static final String SQUARE621 = "SQUARE621";
	public static final String SQUARE622 = "SQUARE622";
	public static final String SQUARE623 = "SQUARE623";
	public static final String SQUARE624 = "SQUARE624";
	public static final String SQUARE625 = "SQUARE625";
	public static final String SQUARE626 = "SQUARE626";
	public static final String SQUARE627 = "SQUARE627";
	public static final String SQUARE628 = "SQUARE628";

	public static final String SQUARE631 = "SQUARE631";
	public static final String SQUARE632 = "SQUARE632";
	public static final String SQUARE633 = "SQUARE633";
	public static final String SQUARE634 = "SQUARE634";
	public static final String SQUARE635 = "SQUARE635";
	public static final String SQUARE636 = "SQUARE636";
	public static final String SQUARE637 = "SQUARE637";
	public static final String SQUARE638 = "SQUARE638";

	public static final String SQUARE641 = "SQUARE641";
	public static final String SQUARE642 = "SQUARE642";
	public static final String SQUARE643 = "SQUARE643";
	public static final String SQUARE644 = "SQUARE644";
	public static final String SQUARE645 = "SQUARE645";
	public static final String SQUARE646 = "SQUARE646";
	public static final String SQUARE647 = "SQUARE647";
	public static final String SQUARE648 = "SQUARE648";

	public static final String SQUARE651 = "SQUARE651";
	public static final String SQUARE652 = "SQUARE652";
	public static final String SQUARE653 = "SQUARE653";
	public static final String SQUARE654 = "SQUARE654";
	public static final String SQUARE655 = "SQUARE655";
	public static final String SQUARE656 = "SQUARE656";
	public static final String SQUARE657 = "SQUARE657";
	public static final String SQUARE658 = "SQUARE658";

	public static final String SQUARE711 = "SQUARE711";
	public static final String SQUARE712 = "SQUARE712";
	public static final String SQUARE713 = "SQUARE713";
	public static final String SQUARE714 = "SQUARE714";
	public static final String SQUARE715 = "SQUARE715";
	public static final String SQUARE716 = "SQUARE716";
	public static final String SQUARE717 = "SQUARE717";
	public static final String SQUARE718 = "SQUARE718";

	public static final String SQUARE721 = "SQUARE721";
	public static final String SQUARE722 = "SQUARE722";
	public static final String SQUARE723 = "SQUARE723";
	public static final String SQUARE724 = "SQUARE724";
	public static final String SQUARE725 = "SQUARE725";
	public static final String SQUARE726 = "SQUARE726";
	public static final String SQUARE727 = "SQUARE727";
	public static final String SQUARE728 = "SQUARE728";

	public static final String SQUARE731 = "SQUARE731";
	public static final String SQUARE732 = "SQUARE732";
	public static final String SQUARE733 = "SQUARE733";
	public static final String SQUARE734 = "SQUARE734";
	public static final String SQUARE735 = "SQUARE735";
	public static final String SQUARE736 = "SQUARE736";
	public static final String SQUARE737 = "SQUARE737";
	public static final String SQUARE738 = "SQUARE738";

	public static final String SQUARE741 = "SQUARE741";
	public static final String SQUARE742 = "SQUARE742";
	public static final String SQUARE743 = "SQUARE743";
	public static final String SQUARE744 = "SQUARE744";
	public static final String SQUARE745 = "SQUARE745";
	public static final String SQUARE746 = "SQUARE746";
	public static final String SQUARE747 = "SQUARE747";
	public static final String SQUARE748 = "SQUARE748";

	public static final String SQUARE751 = "SQUARE751";
	public static final String SQUARE752 = "SQUARE752";
	public static final String SQUARE753 = "SQUARE753";
	public static final String SQUARE754 = "SQUARE754";
	public static final String SQUARE755 = "SQUARE755";
	public static final String SQUARE756 = "SQUARE756";
	public static final String SQUARE757 = "SQUARE757";
	public static final String SQUARE758 = "SQUARE758";
	
	public static final String SQUARE811 = "SQUARE811";
	public static final String SQUARE812 = "SQUARE812";
	public static final String SQUARE813 = "SQUARE813";
	public static final String SQUARE814 = "SQUARE814";
	public static final String SQUARE815 = "SQUARE815";
	public static final String SQUARE816 = "SQUARE816";
	public static final String SQUARE817 = "SQUARE817";
	public static final String SQUARE818 = "SQUARE818";

	public static final String SQUARE821 = "SQUARE821";
	public static final String SQUARE822 = "SQUARE822";
	public static final String SQUARE823 = "SQUARE823";
	public static final String SQUARE824 = "SQUARE824";
	public static final String SQUARE825 = "SQUARE825";
	public static final String SQUARE826 = "SQUARE826";
	public static final String SQUARE827 = "SQUARE827";
	public static final String SQUARE828 = "SQUARE828";

	public static final String SQUARE831 = "SQUARE831";
	public static final String SQUARE832 = "SQUARE832";
	public static final String SQUARE833 = "SQUARE833";
	public static final String SQUARE834 = "SQUARE834";
	public static final String SQUARE835 = "SQUARE835";
	public static final String SQUARE836 = "SQUARE836";
	public static final String SQUARE837 = "SQUARE837";
	public static final String SQUARE838 = "SQUARE838";

	public static final String SQUARE841 = "SQUARE841";
	public static final String SQUARE842 = "SQUARE842";
	public static final String SQUARE843 = "SQUARE843";
	public static final String SQUARE844 = "SQUARE844";
	public static final String SQUARE845 = "SQUARE845";
	public static final String SQUARE846 = "SQUARE846";
	public static final String SQUARE847 = "SQUARE847";
	public static final String SQUARE848 = "SQUARE848";

	public static final String SQUARE851 = "SQUARE851";
	public static final String SQUARE852 = "SQUARE852";
	public static final String SQUARE853 = "SQUARE853";
	public static final String SQUARE854 = "SQUARE854";
	public static final String SQUARE855 = "SQUARE855";
	public static final String SQUARE856 = "SQUARE856";
	public static final String SQUARE857 = "SQUARE857";
	public static final String SQUARE858 = "SQUARE858";

	public static final String SCRIPT1 = "create table " + TABLE_NAME1 + " ("
			+ KEY_ID + " integer primary key autoincrement, " + SQUARE111
			+ " text not null, " + SQUARE112 + " text not null, " + SQUARE113
			+ " text not null, " + SQUARE114 + " text not null, " + SQUARE115
			+ " text not null, " + SQUARE116 + " text not null, " + SQUARE117
			+ " text not null, " + SQUARE118 + " text not null, " + SQUARE121
			+ " text not null, " + SQUARE122 + " text not null, " + SQUARE123
			+ " text not null, " + SQUARE124 + " text not null, " + SQUARE125
			+ " text not null, " + SQUARE126 + " text not null, " + SQUARE127
			+ " text not null, " + SQUARE128 + " text not null, " + SQUARE131
			+ " text not null, " + SQUARE132 + " text not null, " + SQUARE133
			+ " text not null, " + SQUARE134 + " text not null, " + SQUARE135
			+ " text not null, " + SQUARE136 + " text not null, " + SQUARE137
			+ " text not null, " + SQUARE138 + " text not null, " + SQUARE141
			+ " text not null, " + SQUARE142 + " text not null, " + SQUARE143
			+ " text not null, " + SQUARE144 + " text not null, " + SQUARE145
			+ " text not null, " + SQUARE146 + " text not null, " + SQUARE147
			+ " text not null, " + SQUARE148 + " text not null, " + SQUARE151
			+ " text not null, " + SQUARE152 + " text not null, " + SQUARE153
			+ " text not null, " + SQUARE154 + " text not null, " + SQUARE155
			+ " text not null, " + SQUARE156 + " text not null, " + SQUARE157
			+ " text not null, " + SQUARE158 + " text not null);";
	
	public static final String SCRIPT2 = "create table " + TABLE_NAME2 + " ("
			+ KEY_ID + " integer primary key autoincrement, " + SQUARE211
			+ " text not null, " + SQUARE212 + " text not null, " + SQUARE213
			+ " text not null, " + SQUARE214 + " text not null, " + SQUARE215
			+ " text not null, " + SQUARE216 + " text not null, " + SQUARE217
			+ " text not null, " + SQUARE218 + " text not null, " + SQUARE221
			+ " text not null, " + SQUARE222 + " text not null, " + SQUARE223
			+ " text not null, " + SQUARE224 + " text not null, " + SQUARE225
			+ " text not null, " + SQUARE226 + " text not null, " + SQUARE227
			+ " text not null, " + SQUARE228 + " text not null, " + SQUARE231
			+ " text not null, " + SQUARE232 + " text not null, " + SQUARE233
			+ " text not null, " + SQUARE234 + " text not null, " + SQUARE235
			+ " text not null, " + SQUARE236 + " text not null, " + SQUARE237
			+ " text not null, " + SQUARE238 + " text not null, " + SQUARE241
			+ " text not null, " + SQUARE242 + " text not null, " + SQUARE243
			+ " text not null, " + SQUARE244 + " text not null, " + SQUARE245
			+ " text not null, " + SQUARE246 + " text not null, " + SQUARE247
			+ " text not null, " + SQUARE248 + " text not null, " + SQUARE251
			+ " text not null, " + SQUARE252 + " text not null, " + SQUARE253
			+ " text not null, " + SQUARE254 + " text not null, " + SQUARE255
			+ " text not null, " + SQUARE256 + " text not null, " + SQUARE257
			+ " text not null, " + SQUARE258 + " text not null);";
	
	public static final String SCRIPT3 = "create table " + TABLE_NAME3 + " ("
			+ KEY_ID + " integer primary key autoincrement, " + SQUARE311
			+ " text not null, " + SQUARE312 + " text not null, " + SQUARE313
			+ " text not null, " + SQUARE314 + " text not null, " + SQUARE315
			+ " text not null, " + SQUARE316 + " text not null, " + SQUARE317
			+ " text not null, " + SQUARE318 + " text not null, " + SQUARE321
			+ " text not null, " + SQUARE322 + " text not null, " + SQUARE323
			+ " text not null, " + SQUARE324 + " text not null, " + SQUARE325
			+ " text not null, " + SQUARE326 + " text not null, " + SQUARE327
			+ " text not null, " + SQUARE328 + " text not null, " + SQUARE331
			+ " text not null, " + SQUARE332 + " text not null, " + SQUARE333
			+ " text not null, " + SQUARE334 + " text not null, " + SQUARE335
			+ " text not null, " + SQUARE336 + " text not null, " + SQUARE337
			+ " text not null, " + SQUARE338 + " text not null, " + SQUARE341
			+ " text not null, " + SQUARE342 + " text not null, " + SQUARE343
			+ " text not null, " + SQUARE344 + " text not null, " + SQUARE345
			+ " text not null, " + SQUARE346 + " text not null, " + SQUARE347
			+ " text not null, " + SQUARE348 + " text not null, " + SQUARE351
			+ " text not null, " + SQUARE352 + " text not null, " + SQUARE353
			+ " text not null, " + SQUARE354 + " text not null, " + SQUARE355
			+ " text not null, " + SQUARE356 + " text not null, " + SQUARE357
			+ " text not null, " + SQUARE358 + " text not null);";
	
	public static final String SCRIPT4 = "create table " + TABLE_NAME4 + " ("
			+ KEY_ID + " integer primary key autoincrement, " + SQUARE411
			+ " text not null, " + SQUARE412 + " text not null, " + SQUARE413
			+ " text not null, " + SQUARE414 + " text not null, " + SQUARE415
			+ " text not null, " + SQUARE416 + " text not null, " + SQUARE417
			+ " text not null, " + SQUARE418 + " text not null, " + SQUARE421
			+ " text not null, " + SQUARE422 + " text not null, " + SQUARE423
			+ " text not null, " + SQUARE424 + " text not null, " + SQUARE425
			+ " text not null, " + SQUARE426 + " text not null, " + SQUARE427
			+ " text not null, " + SQUARE428 + " text not null, " + SQUARE431
			+ " text not null, " + SQUARE432 + " text not null, " + SQUARE433
			+ " text not null, " + SQUARE434 + " text not null, " + SQUARE435
			+ " text not null, " + SQUARE436 + " text not null, " + SQUARE437
			+ " text not null, " + SQUARE438 + " text not null, " + SQUARE441
			+ " text not null, " + SQUARE442 + " text not null, " + SQUARE443
			+ " text not null, " + SQUARE444 + " text not null, " + SQUARE445
			+ " text not null, " + SQUARE446 + " text not null, " + SQUARE447
			+ " text not null, " + SQUARE448 + " text not null, " + SQUARE451
			+ " text not null, " + SQUARE452 + " text not null, " + SQUARE453
			+ " text not null, " + SQUARE454 + " text not null, " + SQUARE455
			+ " text not null, " + SQUARE456 + " text not null, " + SQUARE457
			+ " text not null, " + SQUARE458 + " text not null);";
	
	public static final String SCRIPT5 = "create table " + TABLE_NAME5 + " ("
			+ KEY_ID + " integer primary key autoincrement, " + SQUARE511
			+ " text not null, " + SQUARE512 + " text not null, " + SQUARE513
			+ " text not null, " + SQUARE514 + " text not null, " + SQUARE515
			+ " text not null, " + SQUARE516 + " text not null, " + SQUARE517
			+ " text not null, " + SQUARE518 + " text not null, " + SQUARE521
			+ " text not null, " + SQUARE522 + " text not null, " + SQUARE523
			+ " text not null, " + SQUARE524 + " text not null, " + SQUARE525
			+ " text not null, " + SQUARE526 + " text not null, " + SQUARE527
			+ " text not null, " + SQUARE528 + " text not null, " + SQUARE531
			+ " text not null, " + SQUARE532 + " text not null, " + SQUARE533
			+ " text not null, " + SQUARE534 + " text not null, " + SQUARE535
			+ " text not null, " + SQUARE536 + " text not null, " + SQUARE537
			+ " text not null, " + SQUARE538 + " text not null, " + SQUARE541
			+ " text not null, " + SQUARE542 + " text not null, " + SQUARE543
			+ " text not null, " + SQUARE544 + " text not null, " + SQUARE545
			+ " text not null, " + SQUARE546 + " text not null, " + SQUARE547
			+ " text not null, " + SQUARE548 + " text not null, " + SQUARE551
			+ " text not null, " + SQUARE552 + " text not null, " + SQUARE553
			+ " text not null, " + SQUARE554 + " text not null, " + SQUARE555
			+ " text not null, " + SQUARE556 + " text not null, " + SQUARE557
			+ " text not null, " + SQUARE558 + " text not null);";
	
	public static final String SCRIPT6 = "create table " + TABLE_NAME6 + " ("
			+ KEY_ID + " integer primary key autoincrement, " + SQUARE611
			+ " text not null, " + SQUARE612 + " text not null, " + SQUARE613
			+ " text not null, " + SQUARE614 + " text not null, " + SQUARE615
			+ " text not null, " + SQUARE616 + " text not null, " + SQUARE617
			+ " text not null, " + SQUARE618 + " text not null, " + SQUARE621
			+ " text not null, " + SQUARE622 + " text not null, " + SQUARE623
			+ " text not null, " + SQUARE624 + " text not null, " + SQUARE625
			+ " text not null, " + SQUARE626 + " text not null, " + SQUARE627
			+ " text not null, " + SQUARE628 + " text not null, " + SQUARE631
			+ " text not null, " + SQUARE632 + " text not null, " + SQUARE633
			+ " text not null, " + SQUARE634 + " text not null, " + SQUARE635
			+ " text not null, " + SQUARE636 + " text not null, " + SQUARE637
			+ " text not null, " + SQUARE638 + " text not null, " + SQUARE641
			+ " text not null, " + SQUARE642 + " text not null, " + SQUARE643
			+ " text not null, " + SQUARE644 + " text not null, " + SQUARE645
			+ " text not null, " + SQUARE646 + " text not null, " + SQUARE647
			+ " text not null, " + SQUARE648 + " text not null, " + SQUARE651
			+ " text not null, " + SQUARE652 + " text not null, " + SQUARE653
			+ " text not null, " + SQUARE654 + " text not null, " + SQUARE655
			+ " text not null, " + SQUARE656 + " text not null, " + SQUARE657
			+ " text not null, " + SQUARE658 + " text not null);";
	
	public static final String SCRIPT7 = "create table " + TABLE_NAME7 + " ("
			+ KEY_ID + " integer primary key autoincrement, " + SQUARE711
			+ " text not null, " + SQUARE712 + " text not null, " + SQUARE713
			+ " text not null, " + SQUARE714 + " text not null, " + SQUARE715
			+ " text not null, " + SQUARE716 + " text not null, " + SQUARE717
			+ " text not null, " + SQUARE718 + " text not null, " + SQUARE721
			+ " text not null, " + SQUARE722 + " text not null, " + SQUARE723
			+ " text not null, " + SQUARE724 + " text not null, " + SQUARE725
			+ " text not null, " + SQUARE726 + " text not null, " + SQUARE727
			+ " text not null, " + SQUARE728 + " text not null, " + SQUARE731
			+ " text not null, " + SQUARE732 + " text not null, " + SQUARE733
			+ " text not null, " + SQUARE734 + " text not null, " + SQUARE735
			+ " text not null, " + SQUARE736 + " text not null, " + SQUARE737
			+ " text not null, " + SQUARE738 + " text not null, " + SQUARE741
			+ " text not null, " + SQUARE742 + " text not null, " + SQUARE743
			+ " text not null, " + SQUARE744 + " text not null, " + SQUARE745
			+ " text not null, " + SQUARE746 + " text not null, " + SQUARE747
			+ " text not null, " + SQUARE748 + " text not null, " + SQUARE751
			+ " text not null, " + SQUARE752 + " text not null, " + SQUARE753
			+ " text not null, " + SQUARE754 + " text not null, " + SQUARE755
			+ " text not null, " + SQUARE756 + " text not null, " + SQUARE757
			+ " text not null, " + SQUARE758 + " text not null);";
	
	public static final String SCRIPT8 = "create table " + TABLE_NAME8 + " ("
			+ KEY_ID + " integer primary key autoincrement, " + SQUARE811
			+ " text not null, " + SQUARE812 + " text not null, " + SQUARE813
			+ " text not null, " + SQUARE814 + " text not null, " + SQUARE815
			+ " text not null, " + SQUARE816 + " text not null, " + SQUARE817
			+ " text not null, " + SQUARE818 + " text not null, " + SQUARE821
			+ " text not null, " + SQUARE822 + " text not null, " + SQUARE823
			+ " text not null, " + SQUARE824 + " text not null, " + SQUARE825
			+ " text not null, " + SQUARE826 + " text not null, " + SQUARE827
			+ " text not null, " + SQUARE828 + " text not null, " + SQUARE831
			+ " text not null, " + SQUARE832 + " text not null, " + SQUARE833
			+ " text not null, " + SQUARE834 + " text not null, " + SQUARE835
			+ " text not null, " + SQUARE836 + " text not null, " + SQUARE837
			+ " text not null, " + SQUARE838 + " text not null, " + SQUARE841
			+ " text not null, " + SQUARE842 + " text not null, " + SQUARE843
			+ " text not null, " + SQUARE844 + " text not null, " + SQUARE845
			+ " text not null, " + SQUARE846 + " text not null, " + SQUARE847
			+ " text not null, " + SQUARE848 + " text not null, " + SQUARE851
			+ " text not null, " + SQUARE852 + " text not null, " + SQUARE853
			+ " text not null, " + SQUARE854 + " text not null, " + SQUARE855
			+ " text not null, " + SQUARE856 + " text not null, " + SQUARE857
			+ " text not null, " + SQUARE858 + " text not null);";

	// public static final String USERINFO_TABLE = "create table " + USER_INFO
	// + " (" + KEY_ID + " integer primary key autoincrement, " + GENDER
	// + " text not null, " + AGE + " text not null, " + WEIGHT
	// + " text not null );";

	public RegistrationOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(SCRIPT1);
		db.execSQL(SCRIPT2);
		db.execSQL(SCRIPT3);
		db.execSQL(SCRIPT4);
		db.execSQL(SCRIPT5);
		db.execSQL(SCRIPT6);
		db.execSQL(SCRIPT7);
		db.execSQL(SCRIPT8);
		// db.execSQL(USERINFO_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("drop table " + TABLE_NAME1);
		db.execSQL("drop table " + TABLE_NAME2);
		db.execSQL("drop table " + TABLE_NAME3);
		db.execSQL("drop table " + TABLE_NAME4);
		db.execSQL("drop table " + TABLE_NAME5);
		db.execSQL("drop table " + TABLE_NAME6);
		db.execSQL("drop table " + TABLE_NAME7);
		db.execSQL("drop table " + TABLE_NAME8);
		// db.execSQL("drop table " + USER_INFO);
		onCreate(db);
	}

}