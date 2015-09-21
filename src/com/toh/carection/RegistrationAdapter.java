package com.toh.carection;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class RegistrationAdapter {
	SQLiteDatabase database_ob;
	RegistrationOpenHelper openHelper_ob;
	Context context;

	public RegistrationAdapter(Context c) {
		context = c;
	}

	public RegistrationAdapter opnToRead() {
		openHelper_ob = new RegistrationOpenHelper(context,
				openHelper_ob.DATABASE_NAME, null, openHelper_ob.VERSION);
		database_ob = openHelper_ob.getReadableDatabase();
		return this;

	}

	public RegistrationAdapter opnToWrite() {
		openHelper_ob = new RegistrationOpenHelper(context,
				openHelper_ob.DATABASE_NAME, null, openHelper_ob.VERSION);
		database_ob = openHelper_ob.getWritableDatabase();
		return this;

	}

	public void Close() {
		database_ob.close();
	}

	public Cursor select1() {
		database_ob = openHelper_ob.getReadableDatabase();
		Cursor cursor = database_ob.query(openHelper_ob.TABLE_NAME1, null, null, null, null,
				null, null);
		return cursor;
	}

	public long insertDetails1(String square111, String square112,
			String square113, String square114, String square115,
			String square116, String square117, String square118,
			String square121, String square122, String square123,
			String square124, String square125, String square126,
			String square127, String square128, String square131,
			String square132, String square133, String square134,
			String square135, String square136, String square137,
			String square138, String square141, String square142,
			String square143, String square144, String square145,
			String square146, String square147, String square148,
			String square151, String square152, String square153,
			String square154, String square155, String square156,
			String square157, String square158) {
		//Log.e("$$$", "insertDetails1");
		ContentValues contentValues = new ContentValues();
		contentValues.put(openHelper_ob.SQUARE111, square111);
		contentValues.put(openHelper_ob.SQUARE112, square112);
		contentValues.put(openHelper_ob.SQUARE113, square113);
		contentValues.put(openHelper_ob.SQUARE114, square114);
		contentValues.put(openHelper_ob.SQUARE115, square115);
		contentValues.put(openHelper_ob.SQUARE116, square116);
		contentValues.put(openHelper_ob.SQUARE117, square117);
		contentValues.put(openHelper_ob.SQUARE118, square118);

		contentValues.put(openHelper_ob.SQUARE121, square121);
		contentValues.put(openHelper_ob.SQUARE122, square122);
		contentValues.put(openHelper_ob.SQUARE123, square123);
		contentValues.put(openHelper_ob.SQUARE124, square124);
		contentValues.put(openHelper_ob.SQUARE125, square125);
		contentValues.put(openHelper_ob.SQUARE126, square126);
		contentValues.put(openHelper_ob.SQUARE127, square127);
		contentValues.put(openHelper_ob.SQUARE128, square128);

		contentValues.put(openHelper_ob.SQUARE131, square131);
		contentValues.put(openHelper_ob.SQUARE132, square132);
		contentValues.put(openHelper_ob.SQUARE133, square133);
		contentValues.put(openHelper_ob.SQUARE134, square134);
		contentValues.put(openHelper_ob.SQUARE135, square135);
		contentValues.put(openHelper_ob.SQUARE136, square136);
		contentValues.put(openHelper_ob.SQUARE137, square137);
		contentValues.put(openHelper_ob.SQUARE138, square138);

		contentValues.put(openHelper_ob.SQUARE141, square141);
		contentValues.put(openHelper_ob.SQUARE142, square142);
		contentValues.put(openHelper_ob.SQUARE143, square143);
		contentValues.put(openHelper_ob.SQUARE144, square144);
		contentValues.put(openHelper_ob.SQUARE145, square145);
		contentValues.put(openHelper_ob.SQUARE146, square146);
		contentValues.put(openHelper_ob.SQUARE147, square147);
		contentValues.put(openHelper_ob.SQUARE148, square148);

		contentValues.put(openHelper_ob.SQUARE151, square151);
		contentValues.put(openHelper_ob.SQUARE152, square152);
		contentValues.put(openHelper_ob.SQUARE153, square153);
		contentValues.put(openHelper_ob.SQUARE154, square154);
		contentValues.put(openHelper_ob.SQUARE155, square155);
		contentValues.put(openHelper_ob.SQUARE156, square156);
		contentValues.put(openHelper_ob.SQUARE157, square157);
		contentValues.put(openHelper_ob.SQUARE158, square158);
		opnToWrite();
		long val = database_ob.insert(openHelper_ob.TABLE_NAME1, null,
				contentValues);
		System.out.println("insertDetails1" + val);
		//System.out.println("insertDetails1v" + contentValues);
		Close();
		return val;

	}

	public long insertDetails2(String square211, String square212,
			String square213, String square214, String square215,
			String square216, String square217, String square218,
			String square221, String square222, String square223,
			String square224, String square225, String square226,
			String square227, String square228, String square231,
			String square232, String square233, String square234,
			String square235, String square236, String square237,
			String square238, String square241, String square242,
			String square243, String square244, String square245,
			String square246, String square247, String square248,
			String square251, String square252, String square253,
			String square254, String square255, String square256,
			String square257, String square258) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(openHelper_ob.SQUARE211, square211);
		contentValues.put(openHelper_ob.SQUARE212, square212);
		contentValues.put(openHelper_ob.SQUARE213, square213);
		contentValues.put(openHelper_ob.SQUARE214, square214);
		contentValues.put(openHelper_ob.SQUARE215, square215);
		contentValues.put(openHelper_ob.SQUARE216, square216);
		contentValues.put(openHelper_ob.SQUARE217, square217);
		contentValues.put(openHelper_ob.SQUARE218, square218);

		contentValues.put(openHelper_ob.SQUARE221, square221);
		contentValues.put(openHelper_ob.SQUARE222, square222);
		contentValues.put(openHelper_ob.SQUARE223, square223);
		contentValues.put(openHelper_ob.SQUARE224, square224);
		contentValues.put(openHelper_ob.SQUARE225, square225);
		contentValues.put(openHelper_ob.SQUARE226, square226);
		contentValues.put(openHelper_ob.SQUARE227, square227);
		contentValues.put(openHelper_ob.SQUARE228, square228);

		contentValues.put(openHelper_ob.SQUARE231, square231);
		contentValues.put(openHelper_ob.SQUARE232, square232);
		contentValues.put(openHelper_ob.SQUARE233, square233);
		contentValues.put(openHelper_ob.SQUARE234, square234);
		contentValues.put(openHelper_ob.SQUARE235, square235);
		contentValues.put(openHelper_ob.SQUARE236, square236);
		contentValues.put(openHelper_ob.SQUARE237, square237);
		contentValues.put(openHelper_ob.SQUARE238, square238);

		contentValues.put(openHelper_ob.SQUARE241, square241);
		contentValues.put(openHelper_ob.SQUARE242, square242);
		contentValues.put(openHelper_ob.SQUARE243, square243);
		contentValues.put(openHelper_ob.SQUARE244, square244);
		contentValues.put(openHelper_ob.SQUARE245, square245);
		contentValues.put(openHelper_ob.SQUARE246, square246);
		contentValues.put(openHelper_ob.SQUARE247, square247);
		contentValues.put(openHelper_ob.SQUARE248, square248);

		contentValues.put(openHelper_ob.SQUARE251, square251);
		contentValues.put(openHelper_ob.SQUARE252, square252);
		contentValues.put(openHelper_ob.SQUARE253, square253);
		contentValues.put(openHelper_ob.SQUARE254, square254);
		contentValues.put(openHelper_ob.SQUARE255, square255);
		contentValues.put(openHelper_ob.SQUARE256, square256);
		contentValues.put(openHelper_ob.SQUARE257, square257);
		contentValues.put(openHelper_ob.SQUARE258, square258);
		opnToWrite();
		long val = database_ob.insert(openHelper_ob.TABLE_NAME2, null,
				contentValues);
		Close();
		return val;

	}

	public long insertDetails3(String square311, String square312,
			String square313, String square314, String square315,
			String square316, String square317, String square318,
			String square321, String square322, String square323,
			String square324, String square325, String square326,
			String square327, String square328, String square331,
			String square332, String square333, String square334,
			String square335, String square336, String square337,
			String square338, String square341, String square342,
			String square343, String square344, String square345,
			String square346, String square347, String square348,
			String square351, String square352, String square353,
			String square354, String square355, String square356,
			String square357, String square358) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(openHelper_ob.SQUARE311, square311);
		contentValues.put(openHelper_ob.SQUARE312, square312);
		contentValues.put(openHelper_ob.SQUARE313, square313);
		contentValues.put(openHelper_ob.SQUARE314, square314);
		contentValues.put(openHelper_ob.SQUARE315, square315);
		contentValues.put(openHelper_ob.SQUARE316, square316);
		contentValues.put(openHelper_ob.SQUARE317, square317);
		contentValues.put(openHelper_ob.SQUARE318, square318);

		contentValues.put(openHelper_ob.SQUARE321, square321);
		contentValues.put(openHelper_ob.SQUARE322, square322);
		contentValues.put(openHelper_ob.SQUARE323, square323);
		contentValues.put(openHelper_ob.SQUARE324, square324);
		contentValues.put(openHelper_ob.SQUARE325, square325);
		contentValues.put(openHelper_ob.SQUARE326, square326);
		contentValues.put(openHelper_ob.SQUARE327, square327);
		contentValues.put(openHelper_ob.SQUARE328, square328);

		contentValues.put(openHelper_ob.SQUARE331, square331);
		contentValues.put(openHelper_ob.SQUARE332, square332);
		contentValues.put(openHelper_ob.SQUARE333, square333);
		contentValues.put(openHelper_ob.SQUARE334, square334);
		contentValues.put(openHelper_ob.SQUARE335, square335);
		contentValues.put(openHelper_ob.SQUARE336, square336);
		contentValues.put(openHelper_ob.SQUARE337, square337);
		contentValues.put(openHelper_ob.SQUARE338, square338);

		contentValues.put(openHelper_ob.SQUARE341, square341);
		contentValues.put(openHelper_ob.SQUARE342, square342);
		contentValues.put(openHelper_ob.SQUARE343, square343);
		contentValues.put(openHelper_ob.SQUARE344, square344);
		contentValues.put(openHelper_ob.SQUARE345, square345);
		contentValues.put(openHelper_ob.SQUARE346, square346);
		contentValues.put(openHelper_ob.SQUARE347, square347);
		contentValues.put(openHelper_ob.SQUARE348, square348);

		contentValues.put(openHelper_ob.SQUARE351, square351);
		contentValues.put(openHelper_ob.SQUARE352, square352);
		contentValues.put(openHelper_ob.SQUARE353, square353);
		contentValues.put(openHelper_ob.SQUARE354, square354);
		contentValues.put(openHelper_ob.SQUARE355, square355);
		contentValues.put(openHelper_ob.SQUARE356, square356);
		contentValues.put(openHelper_ob.SQUARE357, square357);
		contentValues.put(openHelper_ob.SQUARE358, square358);
		opnToWrite();
		long val = database_ob.insert(openHelper_ob.TABLE_NAME3, null,
				contentValues);
		Close();
		return val;

	}

	public long insertDetails4(String square411, String square412,
			String square413, String square414, String square415,
			String square416, String square417, String square418,
			String square421, String square422, String square423,
			String square424, String square425, String square426,
			String square427, String square428, String square431,
			String square432, String square433, String square434,
			String square435, String square436, String square437,
			String square438, String square441, String square442,
			String square443, String square444, String square445,
			String square446, String square447, String square448,
			String square451, String square452, String square453,
			String square454, String square455, String square456,
			String square457, String square458) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(openHelper_ob.SQUARE411, square411);
		contentValues.put(openHelper_ob.SQUARE412, square412);
		contentValues.put(openHelper_ob.SQUARE413, square413);
		contentValues.put(openHelper_ob.SQUARE414, square414);
		contentValues.put(openHelper_ob.SQUARE415, square415);
		contentValues.put(openHelper_ob.SQUARE416, square416);
		contentValues.put(openHelper_ob.SQUARE417, square417);
		contentValues.put(openHelper_ob.SQUARE418, square418);

		contentValues.put(openHelper_ob.SQUARE421, square421);
		contentValues.put(openHelper_ob.SQUARE422, square422);
		contentValues.put(openHelper_ob.SQUARE423, square423);
		contentValues.put(openHelper_ob.SQUARE424, square424);
		contentValues.put(openHelper_ob.SQUARE425, square425);
		contentValues.put(openHelper_ob.SQUARE426, square426);
		contentValues.put(openHelper_ob.SQUARE427, square427);
		contentValues.put(openHelper_ob.SQUARE428, square428);

		contentValues.put(openHelper_ob.SQUARE431, square431);
		contentValues.put(openHelper_ob.SQUARE432, square432);
		contentValues.put(openHelper_ob.SQUARE433, square433);
		contentValues.put(openHelper_ob.SQUARE434, square434);
		contentValues.put(openHelper_ob.SQUARE435, square435);
		contentValues.put(openHelper_ob.SQUARE436, square436);
		contentValues.put(openHelper_ob.SQUARE437, square437);
		contentValues.put(openHelper_ob.SQUARE438, square438);

		contentValues.put(openHelper_ob.SQUARE441, square441);
		contentValues.put(openHelper_ob.SQUARE442, square442);
		contentValues.put(openHelper_ob.SQUARE443, square443);
		contentValues.put(openHelper_ob.SQUARE444, square444);
		contentValues.put(openHelper_ob.SQUARE445, square445);
		contentValues.put(openHelper_ob.SQUARE446, square446);
		contentValues.put(openHelper_ob.SQUARE447, square447);
		contentValues.put(openHelper_ob.SQUARE448, square448);

		contentValues.put(openHelper_ob.SQUARE451, square451);
		contentValues.put(openHelper_ob.SQUARE452, square452);
		contentValues.put(openHelper_ob.SQUARE453, square453);
		contentValues.put(openHelper_ob.SQUARE454, square454);
		contentValues.put(openHelper_ob.SQUARE455, square455);
		contentValues.put(openHelper_ob.SQUARE456, square456);
		contentValues.put(openHelper_ob.SQUARE457, square457);
		contentValues.put(openHelper_ob.SQUARE458, square458);
		opnToWrite();
		long val = database_ob.insert(openHelper_ob.TABLE_NAME4, null,
				contentValues);
		Close();
		return val;

	}

	public long insertDetails5(String square511, String square512,
			String square513, String square514, String square515,
			String square516, String square517, String square518,
			String square521, String square522, String square523,
			String square524, String square525, String square526,
			String square527, String square528, String square531,
			String square532, String square533, String square534,
			String square535, String square536, String square537,
			String square538, String square541, String square542,
			String square543, String square544, String square545,
			String square546, String square547, String square548,
			String square551, String square552, String square553,
			String square554, String square555, String square556,
			String square557, String square558) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(openHelper_ob.SQUARE511, square511);
		contentValues.put(openHelper_ob.SQUARE512, square512);
		contentValues.put(openHelper_ob.SQUARE513, square513);
		contentValues.put(openHelper_ob.SQUARE514, square514);
		contentValues.put(openHelper_ob.SQUARE515, square515);
		contentValues.put(openHelper_ob.SQUARE516, square516);
		contentValues.put(openHelper_ob.SQUARE517, square517);
		contentValues.put(openHelper_ob.SQUARE518, square518);

		contentValues.put(openHelper_ob.SQUARE521, square521);
		contentValues.put(openHelper_ob.SQUARE522, square522);
		contentValues.put(openHelper_ob.SQUARE523, square523);
		contentValues.put(openHelper_ob.SQUARE524, square524);
		contentValues.put(openHelper_ob.SQUARE525, square525);
		contentValues.put(openHelper_ob.SQUARE526, square526);
		contentValues.put(openHelper_ob.SQUARE527, square527);
		contentValues.put(openHelper_ob.SQUARE528, square528);

		contentValues.put(openHelper_ob.SQUARE531, square531);
		contentValues.put(openHelper_ob.SQUARE532, square532);
		contentValues.put(openHelper_ob.SQUARE533, square533);
		contentValues.put(openHelper_ob.SQUARE534, square534);
		contentValues.put(openHelper_ob.SQUARE535, square535);
		contentValues.put(openHelper_ob.SQUARE536, square536);
		contentValues.put(openHelper_ob.SQUARE537, square537);
		contentValues.put(openHelper_ob.SQUARE538, square538);

		contentValues.put(openHelper_ob.SQUARE541, square541);
		contentValues.put(openHelper_ob.SQUARE542, square542);
		contentValues.put(openHelper_ob.SQUARE543, square543);
		contentValues.put(openHelper_ob.SQUARE544, square544);
		contentValues.put(openHelper_ob.SQUARE545, square545);
		contentValues.put(openHelper_ob.SQUARE546, square546);
		contentValues.put(openHelper_ob.SQUARE547, square547);
		contentValues.put(openHelper_ob.SQUARE548, square548);

		contentValues.put(openHelper_ob.SQUARE551, square551);
		contentValues.put(openHelper_ob.SQUARE552, square552);
		contentValues.put(openHelper_ob.SQUARE553, square553);
		contentValues.put(openHelper_ob.SQUARE554, square554);
		contentValues.put(openHelper_ob.SQUARE555, square555);
		contentValues.put(openHelper_ob.SQUARE556, square556);
		contentValues.put(openHelper_ob.SQUARE557, square557);
		contentValues.put(openHelper_ob.SQUARE558, square558);
		opnToWrite();
		long val = database_ob.insert(openHelper_ob.TABLE_NAME5, null,
				contentValues);
		Close();
		return val;

	}

	public long insertDetails6(String square611, String square612,
			String square613, String square614, String square615,
			String square616, String square617, String square618,
			String square621, String square622, String square623,
			String square624, String square625, String square626,
			String square627, String square628, String square631,
			String square632, String square633, String square634,
			String square635, String square636, String square637,
			String square638, String square641, String square642,
			String square643, String square644, String square645,
			String square646, String square647, String square648,
			String square651, String square652, String square653,
			String square654, String square655, String square656,
			String square657, String square658) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(openHelper_ob.SQUARE611, square611);
		contentValues.put(openHelper_ob.SQUARE612, square612);
		contentValues.put(openHelper_ob.SQUARE613, square613);
		contentValues.put(openHelper_ob.SQUARE614, square614);
		contentValues.put(openHelper_ob.SQUARE615, square615);
		contentValues.put(openHelper_ob.SQUARE616, square616);
		contentValues.put(openHelper_ob.SQUARE617, square617);
		contentValues.put(openHelper_ob.SQUARE618, square618);

		contentValues.put(openHelper_ob.SQUARE621, square621);
		contentValues.put(openHelper_ob.SQUARE622, square622);
		contentValues.put(openHelper_ob.SQUARE623, square623);
		contentValues.put(openHelper_ob.SQUARE624, square624);
		contentValues.put(openHelper_ob.SQUARE625, square625);
		contentValues.put(openHelper_ob.SQUARE626, square626);
		contentValues.put(openHelper_ob.SQUARE627, square627);
		contentValues.put(openHelper_ob.SQUARE628, square628);

		contentValues.put(openHelper_ob.SQUARE631, square631);
		contentValues.put(openHelper_ob.SQUARE632, square632);
		contentValues.put(openHelper_ob.SQUARE633, square633);
		contentValues.put(openHelper_ob.SQUARE634, square634);
		contentValues.put(openHelper_ob.SQUARE635, square635);
		contentValues.put(openHelper_ob.SQUARE636, square636);
		contentValues.put(openHelper_ob.SQUARE637, square637);
		contentValues.put(openHelper_ob.SQUARE638, square638);

		contentValues.put(openHelper_ob.SQUARE641, square641);
		contentValues.put(openHelper_ob.SQUARE642, square642);
		contentValues.put(openHelper_ob.SQUARE643, square643);
		contentValues.put(openHelper_ob.SQUARE644, square644);
		contentValues.put(openHelper_ob.SQUARE645, square645);
		contentValues.put(openHelper_ob.SQUARE646, square646);
		contentValues.put(openHelper_ob.SQUARE647, square647);
		contentValues.put(openHelper_ob.SQUARE648, square648);

		contentValues.put(openHelper_ob.SQUARE651, square651);
		contentValues.put(openHelper_ob.SQUARE652, square652);
		contentValues.put(openHelper_ob.SQUARE653, square653);
		contentValues.put(openHelper_ob.SQUARE654, square654);
		contentValues.put(openHelper_ob.SQUARE655, square655);
		contentValues.put(openHelper_ob.SQUARE656, square656);
		contentValues.put(openHelper_ob.SQUARE657, square657);
		contentValues.put(openHelper_ob.SQUARE658, square658);
		opnToWrite();
		long val = database_ob.insert(openHelper_ob.TABLE_NAME6, null,
				contentValues);
		Close();
		return val;

	}

	public long insertDetails7(String square711, String square712,
			String square713, String square714, String square715,
			String square716, String square717, String square718,
			String square721, String square722, String square723,
			String square724, String square725, String square726,
			String square727, String square728, String square731,
			String square732, String square733, String square734,
			String square735, String square736, String square737,
			String square738, String square741, String square742,
			String square743, String square744, String square745,
			String square746, String square747, String square748,
			String square751, String square752, String square753,
			String square754, String square755, String square756,
			String square757, String square758) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(openHelper_ob.SQUARE711, square711);
		contentValues.put(openHelper_ob.SQUARE712, square712);
		contentValues.put(openHelper_ob.SQUARE713, square713);
		contentValues.put(openHelper_ob.SQUARE714, square714);
		contentValues.put(openHelper_ob.SQUARE715, square715);
		contentValues.put(openHelper_ob.SQUARE716, square716);
		contentValues.put(openHelper_ob.SQUARE717, square717);
		contentValues.put(openHelper_ob.SQUARE718, square718);

		contentValues.put(openHelper_ob.SQUARE721, square721);
		contentValues.put(openHelper_ob.SQUARE722, square722);
		contentValues.put(openHelper_ob.SQUARE723, square723);
		contentValues.put(openHelper_ob.SQUARE724, square724);
		contentValues.put(openHelper_ob.SQUARE725, square725);
		contentValues.put(openHelper_ob.SQUARE726, square726);
		contentValues.put(openHelper_ob.SQUARE727, square727);
		contentValues.put(openHelper_ob.SQUARE728, square728);

		contentValues.put(openHelper_ob.SQUARE731, square731);
		contentValues.put(openHelper_ob.SQUARE732, square732);
		contentValues.put(openHelper_ob.SQUARE733, square733);
		contentValues.put(openHelper_ob.SQUARE734, square734);
		contentValues.put(openHelper_ob.SQUARE735, square735);
		contentValues.put(openHelper_ob.SQUARE736, square736);
		contentValues.put(openHelper_ob.SQUARE737, square737);
		contentValues.put(openHelper_ob.SQUARE738, square738);

		contentValues.put(openHelper_ob.SQUARE741, square741);
		contentValues.put(openHelper_ob.SQUARE742, square742);
		contentValues.put(openHelper_ob.SQUARE743, square743);
		contentValues.put(openHelper_ob.SQUARE744, square744);
		contentValues.put(openHelper_ob.SQUARE745, square745);
		contentValues.put(openHelper_ob.SQUARE746, square746);
		contentValues.put(openHelper_ob.SQUARE747, square747);
		contentValues.put(openHelper_ob.SQUARE748, square748);

		contentValues.put(openHelper_ob.SQUARE751, square751);
		contentValues.put(openHelper_ob.SQUARE752, square752);
		contentValues.put(openHelper_ob.SQUARE753, square753);
		contentValues.put(openHelper_ob.SQUARE754, square754);
		contentValues.put(openHelper_ob.SQUARE755, square755);
		contentValues.put(openHelper_ob.SQUARE756, square756);
		contentValues.put(openHelper_ob.SQUARE757, square757);
		contentValues.put(openHelper_ob.SQUARE758, square758);
		opnToWrite();
		long val = database_ob.insert(openHelper_ob.TABLE_NAME7, null,
				contentValues);
		Close();
		return val;

	}
	
	public long insertDetails8(String square811, String square812,
			String square813, String square814, String square815,
			String square816, String square817, String square818,
			String square821, String square822, String square823,
			String square824, String square825, String square826,
			String square827, String square828, String square831,
			String square832, String square833, String square834,
			String square835, String square836, String square837,
			String square838, String square841, String square842,
			String square843, String square844, String square845,
			String square846, String square847, String square848,
			String square851, String square852, String square853,
			String square854, String square855, String square856,
			String square857, String square858) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(openHelper_ob.SQUARE811, square811);
		contentValues.put(openHelper_ob.SQUARE812, square812);
		contentValues.put(openHelper_ob.SQUARE813, square813);
		contentValues.put(openHelper_ob.SQUARE814, square814);
		contentValues.put(openHelper_ob.SQUARE815, square815);
		contentValues.put(openHelper_ob.SQUARE816, square816);
		contentValues.put(openHelper_ob.SQUARE817, square817);
		contentValues.put(openHelper_ob.SQUARE818, square818);

		contentValues.put(openHelper_ob.SQUARE821, square821);
		contentValues.put(openHelper_ob.SQUARE822, square822);
		contentValues.put(openHelper_ob.SQUARE823, square823);
		contentValues.put(openHelper_ob.SQUARE824, square824);
		contentValues.put(openHelper_ob.SQUARE825, square825);
		contentValues.put(openHelper_ob.SQUARE826, square826);
		contentValues.put(openHelper_ob.SQUARE827, square827);
		contentValues.put(openHelper_ob.SQUARE828, square828);

		contentValues.put(openHelper_ob.SQUARE831, square831);
		contentValues.put(openHelper_ob.SQUARE832, square832);
		contentValues.put(openHelper_ob.SQUARE833, square833);
		contentValues.put(openHelper_ob.SQUARE834, square834);
		contentValues.put(openHelper_ob.SQUARE835, square835);
		contentValues.put(openHelper_ob.SQUARE836, square836);
		contentValues.put(openHelper_ob.SQUARE837, square837);
		contentValues.put(openHelper_ob.SQUARE838, square838);

		contentValues.put(openHelper_ob.SQUARE841, square841);
		contentValues.put(openHelper_ob.SQUARE842, square842);
		contentValues.put(openHelper_ob.SQUARE843, square843);
		contentValues.put(openHelper_ob.SQUARE844, square844);
		contentValues.put(openHelper_ob.SQUARE845, square845);
		contentValues.put(openHelper_ob.SQUARE846, square846);
		contentValues.put(openHelper_ob.SQUARE847, square847);
		contentValues.put(openHelper_ob.SQUARE848, square848);

		contentValues.put(openHelper_ob.SQUARE851, square851);
		contentValues.put(openHelper_ob.SQUARE852, square852);
		contentValues.put(openHelper_ob.SQUARE853, square853);
		contentValues.put(openHelper_ob.SQUARE854, square854);
		contentValues.put(openHelper_ob.SQUARE855, square855);
		contentValues.put(openHelper_ob.SQUARE856, square856);
		contentValues.put(openHelper_ob.SQUARE857, square857);
		contentValues.put(openHelper_ob.SQUARE858, square858);
		opnToWrite();
		long val = database_ob.insert(openHelper_ob.TABLE_NAME8, null,
				contentValues);
		Close();
		return val;

	}

	public Cursor queryName1() {
		String[] cols = { openHelper_ob.KEY_ID, openHelper_ob.SQUARE111,
				openHelper_ob.SQUARE112, openHelper_ob.SQUARE113,
				openHelper_ob.SQUARE114, openHelper_ob.SQUARE115,
				openHelper_ob.SQUARE116, openHelper_ob.SQUARE117,
				openHelper_ob.SQUARE118, openHelper_ob.SQUARE121,
				openHelper_ob.SQUARE122, openHelper_ob.SQUARE123,
				openHelper_ob.SQUARE124, openHelper_ob.SQUARE125,
				openHelper_ob.SQUARE126, openHelper_ob.SQUARE127,
				openHelper_ob.SQUARE128, openHelper_ob.SQUARE131,
				openHelper_ob.SQUARE132, openHelper_ob.SQUARE133,
				openHelper_ob.SQUARE134, openHelper_ob.SQUARE135,
				openHelper_ob.SQUARE136, openHelper_ob.SQUARE137,
				openHelper_ob.SQUARE138, openHelper_ob.SQUARE141,
				openHelper_ob.SQUARE142, openHelper_ob.SQUARE143,
				openHelper_ob.SQUARE144, openHelper_ob.SQUARE145,
				openHelper_ob.SQUARE146, openHelper_ob.SQUARE147,
				openHelper_ob.SQUARE148, openHelper_ob.SQUARE151,
				openHelper_ob.SQUARE152, openHelper_ob.SQUARE153,
				openHelper_ob.SQUARE154, openHelper_ob.SQUARE155,
				openHelper_ob.SQUARE156, openHelper_ob.SQUARE157,
				openHelper_ob.SQUARE158 };
		opnToWrite();
		Cursor c = database_ob.query(openHelper_ob.TABLE_NAME1, cols, null,
				null, null, null, null);
		return c;
	}

	public Cursor queryName2() {
		String[] cols = { openHelper_ob.KEY_ID, openHelper_ob.SQUARE211,
				openHelper_ob.SQUARE212, openHelper_ob.SQUARE213,
				openHelper_ob.SQUARE214, openHelper_ob.SQUARE215,
				openHelper_ob.SQUARE216, openHelper_ob.SQUARE217,
				openHelper_ob.SQUARE218, openHelper_ob.SQUARE221,
				openHelper_ob.SQUARE222, openHelper_ob.SQUARE223,
				openHelper_ob.SQUARE224, openHelper_ob.SQUARE225,
				openHelper_ob.SQUARE226, openHelper_ob.SQUARE227,
				openHelper_ob.SQUARE228, openHelper_ob.SQUARE231,
				openHelper_ob.SQUARE232, openHelper_ob.SQUARE233,
				openHelper_ob.SQUARE234, openHelper_ob.SQUARE235,
				openHelper_ob.SQUARE236, openHelper_ob.SQUARE237,
				openHelper_ob.SQUARE238, openHelper_ob.SQUARE241,
				openHelper_ob.SQUARE242, openHelper_ob.SQUARE243,
				openHelper_ob.SQUARE244, openHelper_ob.SQUARE245,
				openHelper_ob.SQUARE246, openHelper_ob.SQUARE247,
				openHelper_ob.SQUARE248, openHelper_ob.SQUARE251,
				openHelper_ob.SQUARE252, openHelper_ob.SQUARE253,
				openHelper_ob.SQUARE254, openHelper_ob.SQUARE255,
				openHelper_ob.SQUARE256, openHelper_ob.SQUARE257,
				openHelper_ob.SQUARE258 };
		opnToWrite();
		Cursor c = database_ob.query(openHelper_ob.TABLE_NAME2, cols, null,
				null, null, null, null);
		return c;
	}

	public Cursor queryName3() {
		String[] cols = { openHelper_ob.KEY_ID, openHelper_ob.SQUARE311,
				openHelper_ob.SQUARE312, openHelper_ob.SQUARE313,
				openHelper_ob.SQUARE314, openHelper_ob.SQUARE315,
				openHelper_ob.SQUARE316, openHelper_ob.SQUARE317,
				openHelper_ob.SQUARE318, openHelper_ob.SQUARE321,
				openHelper_ob.SQUARE322, openHelper_ob.SQUARE323,
				openHelper_ob.SQUARE324, openHelper_ob.SQUARE325,
				openHelper_ob.SQUARE326, openHelper_ob.SQUARE327,
				openHelper_ob.SQUARE328, openHelper_ob.SQUARE331,
				openHelper_ob.SQUARE332, openHelper_ob.SQUARE333,
				openHelper_ob.SQUARE334, openHelper_ob.SQUARE335,
				openHelper_ob.SQUARE336, openHelper_ob.SQUARE337,
				openHelper_ob.SQUARE338, openHelper_ob.SQUARE341,
				openHelper_ob.SQUARE342, openHelper_ob.SQUARE343,
				openHelper_ob.SQUARE344, openHelper_ob.SQUARE345,
				openHelper_ob.SQUARE346, openHelper_ob.SQUARE347,
				openHelper_ob.SQUARE348, openHelper_ob.SQUARE351,
				openHelper_ob.SQUARE352, openHelper_ob.SQUARE353,
				openHelper_ob.SQUARE354, openHelper_ob.SQUARE355,
				openHelper_ob.SQUARE356, openHelper_ob.SQUARE357,
				openHelper_ob.SQUARE358 };
		opnToWrite();
		Cursor c = database_ob.query(openHelper_ob.TABLE_NAME3, cols, null,
				null, null, null, null);
		return c;
	}

	public Cursor queryName4() {
		String[] cols = { openHelper_ob.KEY_ID, openHelper_ob.SQUARE411,
				openHelper_ob.SQUARE412, openHelper_ob.SQUARE413,
				openHelper_ob.SQUARE414, openHelper_ob.SQUARE415,
				openHelper_ob.SQUARE416, openHelper_ob.SQUARE417,
				openHelper_ob.SQUARE418, openHelper_ob.SQUARE421,
				openHelper_ob.SQUARE422, openHelper_ob.SQUARE423,
				openHelper_ob.SQUARE424, openHelper_ob.SQUARE425,
				openHelper_ob.SQUARE426, openHelper_ob.SQUARE427,
				openHelper_ob.SQUARE428, openHelper_ob.SQUARE431,
				openHelper_ob.SQUARE432, openHelper_ob.SQUARE433,
				openHelper_ob.SQUARE434, openHelper_ob.SQUARE435,
				openHelper_ob.SQUARE436, openHelper_ob.SQUARE437,
				openHelper_ob.SQUARE438, openHelper_ob.SQUARE441,
				openHelper_ob.SQUARE442, openHelper_ob.SQUARE443,
				openHelper_ob.SQUARE444, openHelper_ob.SQUARE445,
				openHelper_ob.SQUARE446, openHelper_ob.SQUARE447,
				openHelper_ob.SQUARE448, openHelper_ob.SQUARE451,
				openHelper_ob.SQUARE452, openHelper_ob.SQUARE453,
				openHelper_ob.SQUARE454, openHelper_ob.SQUARE455,
				openHelper_ob.SQUARE456, openHelper_ob.SQUARE457,
				openHelper_ob.SQUARE458 };
		opnToWrite();
		Cursor c = database_ob.query(openHelper_ob.TABLE_NAME4, cols, null,
				null, null, null, null);
		return c;
	}

	public Cursor queryName5() {
		String[] cols = { openHelper_ob.KEY_ID, openHelper_ob.SQUARE511,
				openHelper_ob.SQUARE512, openHelper_ob.SQUARE513,
				openHelper_ob.SQUARE514, openHelper_ob.SQUARE515,
				openHelper_ob.SQUARE516, openHelper_ob.SQUARE517,
				openHelper_ob.SQUARE518, openHelper_ob.SQUARE521,
				openHelper_ob.SQUARE522, openHelper_ob.SQUARE523,
				openHelper_ob.SQUARE524, openHelper_ob.SQUARE525,
				openHelper_ob.SQUARE526, openHelper_ob.SQUARE527,
				openHelper_ob.SQUARE528, openHelper_ob.SQUARE531,
				openHelper_ob.SQUARE532, openHelper_ob.SQUARE533,
				openHelper_ob.SQUARE534, openHelper_ob.SQUARE535,
				openHelper_ob.SQUARE536, openHelper_ob.SQUARE537,
				openHelper_ob.SQUARE538, openHelper_ob.SQUARE541,
				openHelper_ob.SQUARE542, openHelper_ob.SQUARE543,
				openHelper_ob.SQUARE544, openHelper_ob.SQUARE545,
				openHelper_ob.SQUARE546, openHelper_ob.SQUARE547,
				openHelper_ob.SQUARE548, openHelper_ob.SQUARE551,
				openHelper_ob.SQUARE552, openHelper_ob.SQUARE553,
				openHelper_ob.SQUARE554, openHelper_ob.SQUARE555,
				openHelper_ob.SQUARE556, openHelper_ob.SQUARE557,
				openHelper_ob.SQUARE558 };
		opnToWrite();
		Cursor c = database_ob.query(openHelper_ob.TABLE_NAME5, cols, null,
				null, null, null, null);
		return c;
	}

	public Cursor queryName6() {
		String[] cols = { openHelper_ob.KEY_ID, openHelper_ob.SQUARE611,
				openHelper_ob.SQUARE612, openHelper_ob.SQUARE613,
				openHelper_ob.SQUARE614, openHelper_ob.SQUARE615,
				openHelper_ob.SQUARE616, openHelper_ob.SQUARE617,
				openHelper_ob.SQUARE618, openHelper_ob.SQUARE621,
				openHelper_ob.SQUARE622, openHelper_ob.SQUARE623,
				openHelper_ob.SQUARE624, openHelper_ob.SQUARE625,
				openHelper_ob.SQUARE626, openHelper_ob.SQUARE627,
				openHelper_ob.SQUARE628, openHelper_ob.SQUARE631,
				openHelper_ob.SQUARE632, openHelper_ob.SQUARE633,
				openHelper_ob.SQUARE634, openHelper_ob.SQUARE635,
				openHelper_ob.SQUARE636, openHelper_ob.SQUARE637,
				openHelper_ob.SQUARE638, openHelper_ob.SQUARE641,
				openHelper_ob.SQUARE642, openHelper_ob.SQUARE643,
				openHelper_ob.SQUARE644, openHelper_ob.SQUARE645,
				openHelper_ob.SQUARE646, openHelper_ob.SQUARE647,
				openHelper_ob.SQUARE648, openHelper_ob.SQUARE651,
				openHelper_ob.SQUARE652, openHelper_ob.SQUARE653,
				openHelper_ob.SQUARE654, openHelper_ob.SQUARE655,
				openHelper_ob.SQUARE656, openHelper_ob.SQUARE657,
				openHelper_ob.SQUARE658 };
		opnToWrite();
		Cursor c = database_ob.query(openHelper_ob.TABLE_NAME6, cols, null,
				null, null, null, null);
		return c;
	}

	public Cursor queryName7() {
		String[] cols = { openHelper_ob.KEY_ID, openHelper_ob.SQUARE711,
				openHelper_ob.SQUARE712, openHelper_ob.SQUARE713,
				openHelper_ob.SQUARE714, openHelper_ob.SQUARE715,
				openHelper_ob.SQUARE716, openHelper_ob.SQUARE717,
				openHelper_ob.SQUARE718, openHelper_ob.SQUARE721,
				openHelper_ob.SQUARE722, openHelper_ob.SQUARE723,
				openHelper_ob.SQUARE724, openHelper_ob.SQUARE725,
				openHelper_ob.SQUARE726, openHelper_ob.SQUARE727,
				openHelper_ob.SQUARE728, openHelper_ob.SQUARE731,
				openHelper_ob.SQUARE732, openHelper_ob.SQUARE733,
				openHelper_ob.SQUARE734, openHelper_ob.SQUARE735,
				openHelper_ob.SQUARE736, openHelper_ob.SQUARE737,
				openHelper_ob.SQUARE738, openHelper_ob.SQUARE741,
				openHelper_ob.SQUARE742, openHelper_ob.SQUARE743,
				openHelper_ob.SQUARE744, openHelper_ob.SQUARE745,
				openHelper_ob.SQUARE746, openHelper_ob.SQUARE747,
				openHelper_ob.SQUARE748, openHelper_ob.SQUARE751,
				openHelper_ob.SQUARE752, openHelper_ob.SQUARE753,
				openHelper_ob.SQUARE754, openHelper_ob.SQUARE755,
				openHelper_ob.SQUARE756, openHelper_ob.SQUARE757,
				openHelper_ob.SQUARE758 };
		opnToWrite();
		Cursor c = database_ob.query(openHelper_ob.TABLE_NAME7, cols, null,
				null, null, null, null);
		return c;
	}
	
	public Cursor queryName8() {
		String[] cols = { openHelper_ob.KEY_ID, openHelper_ob.SQUARE811,
				openHelper_ob.SQUARE812, openHelper_ob.SQUARE813,
				openHelper_ob.SQUARE814, openHelper_ob.SQUARE815,
				openHelper_ob.SQUARE816, openHelper_ob.SQUARE817,
				openHelper_ob.SQUARE818, openHelper_ob.SQUARE821,
				openHelper_ob.SQUARE822, openHelper_ob.SQUARE823,
				openHelper_ob.SQUARE824, openHelper_ob.SQUARE825,
				openHelper_ob.SQUARE826, openHelper_ob.SQUARE827,
				openHelper_ob.SQUARE828, openHelper_ob.SQUARE831,
				openHelper_ob.SQUARE832, openHelper_ob.SQUARE833,
				openHelper_ob.SQUARE834, openHelper_ob.SQUARE835,
				openHelper_ob.SQUARE836, openHelper_ob.SQUARE837,
				openHelper_ob.SQUARE838, openHelper_ob.SQUARE841,
				openHelper_ob.SQUARE842, openHelper_ob.SQUARE843,
				openHelper_ob.SQUARE844, openHelper_ob.SQUARE845,
				openHelper_ob.SQUARE846, openHelper_ob.SQUARE847,
				openHelper_ob.SQUARE848, openHelper_ob.SQUARE851,
				openHelper_ob.SQUARE852, openHelper_ob.SQUARE853,
				openHelper_ob.SQUARE854, openHelper_ob.SQUARE855,
				openHelper_ob.SQUARE856, openHelper_ob.SQUARE857,
				openHelper_ob.SQUARE858 };
		opnToWrite();
		Cursor c = database_ob.query(openHelper_ob.TABLE_NAME8, cols, null,
				null, null, null, null);
		return c;
	}

	public Cursor queryAll1(int nameId) {
		Log.e("$$$", "queryAll1");
		String[] cols = { openHelper_ob.KEY_ID, openHelper_ob.SQUARE111,
				openHelper_ob.SQUARE112, openHelper_ob.SQUARE113,
				openHelper_ob.SQUARE114, openHelper_ob.SQUARE115,
				openHelper_ob.SQUARE116, openHelper_ob.SQUARE117,
				openHelper_ob.SQUARE118, openHelper_ob.SQUARE121,
				openHelper_ob.SQUARE122, openHelper_ob.SQUARE123,
				openHelper_ob.SQUARE124, openHelper_ob.SQUARE125,
				openHelper_ob.SQUARE126, openHelper_ob.SQUARE127,
				openHelper_ob.SQUARE128, openHelper_ob.SQUARE131,
				openHelper_ob.SQUARE132, openHelper_ob.SQUARE133,
				openHelper_ob.SQUARE134, openHelper_ob.SQUARE135,
				openHelper_ob.SQUARE136, openHelper_ob.SQUARE137,
				openHelper_ob.SQUARE138, openHelper_ob.SQUARE141,
				openHelper_ob.SQUARE142, openHelper_ob.SQUARE143,
				openHelper_ob.SQUARE144, openHelper_ob.SQUARE145,
				openHelper_ob.SQUARE146, openHelper_ob.SQUARE147,
				openHelper_ob.SQUARE148, openHelper_ob.SQUARE151,
				openHelper_ob.SQUARE152, openHelper_ob.SQUARE153,
				openHelper_ob.SQUARE154, openHelper_ob.SQUARE155,
				openHelper_ob.SQUARE156, openHelper_ob.SQUARE157,
				openHelper_ob.SQUARE158 };
		opnToWrite();
		Cursor c = database_ob.query(openHelper_ob.TABLE_NAME1, cols,
				openHelper_ob.KEY_ID + "=" + nameId, null, null, null, null);
		return c;
	}

	public Cursor queryAll2(int nameId) {
		String[] cols = { openHelper_ob.KEY_ID, openHelper_ob.SQUARE211,
				openHelper_ob.SQUARE212, openHelper_ob.SQUARE213,
				openHelper_ob.SQUARE214, openHelper_ob.SQUARE215,
				openHelper_ob.SQUARE216, openHelper_ob.SQUARE217,
				openHelper_ob.SQUARE218, openHelper_ob.SQUARE221,
				openHelper_ob.SQUARE222, openHelper_ob.SQUARE223,
				openHelper_ob.SQUARE224, openHelper_ob.SQUARE225,
				openHelper_ob.SQUARE226, openHelper_ob.SQUARE227,
				openHelper_ob.SQUARE228, openHelper_ob.SQUARE231,
				openHelper_ob.SQUARE232, openHelper_ob.SQUARE233,
				openHelper_ob.SQUARE234, openHelper_ob.SQUARE235,
				openHelper_ob.SQUARE236, openHelper_ob.SQUARE237,
				openHelper_ob.SQUARE238, openHelper_ob.SQUARE241,
				openHelper_ob.SQUARE242, openHelper_ob.SQUARE243,
				openHelper_ob.SQUARE244, openHelper_ob.SQUARE245,
				openHelper_ob.SQUARE246, openHelper_ob.SQUARE247,
				openHelper_ob.SQUARE248, openHelper_ob.SQUARE251,
				openHelper_ob.SQUARE252, openHelper_ob.SQUARE253,
				openHelper_ob.SQUARE254, openHelper_ob.SQUARE255,
				openHelper_ob.SQUARE256, openHelper_ob.SQUARE257,
				openHelper_ob.SQUARE258 };
		opnToWrite();
		Cursor c = database_ob.query(openHelper_ob.TABLE_NAME2, cols,
				openHelper_ob.KEY_ID + "=" + nameId, null, null, null, null);
		return c;
	}

	public Cursor queryAll3(int nameId) {
		String[] cols = { openHelper_ob.KEY_ID, openHelper_ob.SQUARE311,
				openHelper_ob.SQUARE312, openHelper_ob.SQUARE313,
				openHelper_ob.SQUARE314, openHelper_ob.SQUARE315,
				openHelper_ob.SQUARE316, openHelper_ob.SQUARE317,
				openHelper_ob.SQUARE318, openHelper_ob.SQUARE321,
				openHelper_ob.SQUARE322, openHelper_ob.SQUARE323,
				openHelper_ob.SQUARE324, openHelper_ob.SQUARE325,
				openHelper_ob.SQUARE326, openHelper_ob.SQUARE327,
				openHelper_ob.SQUARE328, openHelper_ob.SQUARE331,
				openHelper_ob.SQUARE332, openHelper_ob.SQUARE333,
				openHelper_ob.SQUARE334, openHelper_ob.SQUARE335,
				openHelper_ob.SQUARE336, openHelper_ob.SQUARE337,
				openHelper_ob.SQUARE338, openHelper_ob.SQUARE341,
				openHelper_ob.SQUARE342, openHelper_ob.SQUARE343,
				openHelper_ob.SQUARE344, openHelper_ob.SQUARE345,
				openHelper_ob.SQUARE346, openHelper_ob.SQUARE347,
				openHelper_ob.SQUARE348, openHelper_ob.SQUARE351,
				openHelper_ob.SQUARE352, openHelper_ob.SQUARE353,
				openHelper_ob.SQUARE354, openHelper_ob.SQUARE355,
				openHelper_ob.SQUARE356, openHelper_ob.SQUARE357,
				openHelper_ob.SQUARE358 };
		opnToWrite();
		Cursor c = database_ob.query(openHelper_ob.TABLE_NAME3, cols,
				openHelper_ob.KEY_ID + "=" + nameId, null, null, null, null);
		return c;
	}

	public Cursor queryAll4(int nameId) {
		String[] cols = { openHelper_ob.KEY_ID, openHelper_ob.SQUARE411,
				openHelper_ob.SQUARE412, openHelper_ob.SQUARE413,
				openHelper_ob.SQUARE414, openHelper_ob.SQUARE415,
				openHelper_ob.SQUARE416, openHelper_ob.SQUARE417,
				openHelper_ob.SQUARE418, openHelper_ob.SQUARE421,
				openHelper_ob.SQUARE422, openHelper_ob.SQUARE423,
				openHelper_ob.SQUARE424, openHelper_ob.SQUARE425,
				openHelper_ob.SQUARE426, openHelper_ob.SQUARE427,
				openHelper_ob.SQUARE428, openHelper_ob.SQUARE431,
				openHelper_ob.SQUARE432, openHelper_ob.SQUARE433,
				openHelper_ob.SQUARE434, openHelper_ob.SQUARE435,
				openHelper_ob.SQUARE436, openHelper_ob.SQUARE437,
				openHelper_ob.SQUARE438, openHelper_ob.SQUARE441,
				openHelper_ob.SQUARE442, openHelper_ob.SQUARE443,
				openHelper_ob.SQUARE444, openHelper_ob.SQUARE445,
				openHelper_ob.SQUARE446, openHelper_ob.SQUARE447,
				openHelper_ob.SQUARE448, openHelper_ob.SQUARE451,
				openHelper_ob.SQUARE452, openHelper_ob.SQUARE453,
				openHelper_ob.SQUARE454, openHelper_ob.SQUARE455,
				openHelper_ob.SQUARE456, openHelper_ob.SQUARE457,
				openHelper_ob.SQUARE458 };
		opnToWrite();
		Cursor c = database_ob.query(openHelper_ob.TABLE_NAME4, cols,
				openHelper_ob.KEY_ID + "=" + nameId, null, null, null, null);
		return c;
	}

	public Cursor queryAll5(int nameId) {
		String[] cols = { openHelper_ob.KEY_ID, openHelper_ob.SQUARE511,
				openHelper_ob.SQUARE512, openHelper_ob.SQUARE513,
				openHelper_ob.SQUARE514, openHelper_ob.SQUARE515,
				openHelper_ob.SQUARE516, openHelper_ob.SQUARE517,
				openHelper_ob.SQUARE518, openHelper_ob.SQUARE521,
				openHelper_ob.SQUARE522, openHelper_ob.SQUARE523,
				openHelper_ob.SQUARE524, openHelper_ob.SQUARE525,
				openHelper_ob.SQUARE526, openHelper_ob.SQUARE527,
				openHelper_ob.SQUARE528, openHelper_ob.SQUARE531,
				openHelper_ob.SQUARE532, openHelper_ob.SQUARE533,
				openHelper_ob.SQUARE534, openHelper_ob.SQUARE535,
				openHelper_ob.SQUARE536, openHelper_ob.SQUARE537,
				openHelper_ob.SQUARE538, openHelper_ob.SQUARE541,
				openHelper_ob.SQUARE542, openHelper_ob.SQUARE543,
				openHelper_ob.SQUARE544, openHelper_ob.SQUARE545,
				openHelper_ob.SQUARE546, openHelper_ob.SQUARE547,
				openHelper_ob.SQUARE548, openHelper_ob.SQUARE551,
				openHelper_ob.SQUARE552, openHelper_ob.SQUARE553,
				openHelper_ob.SQUARE554, openHelper_ob.SQUARE555,
				openHelper_ob.SQUARE556, openHelper_ob.SQUARE557,
				openHelper_ob.SQUARE558 };
		opnToWrite();
		Cursor c = database_ob.query(openHelper_ob.TABLE_NAME5, cols,
				openHelper_ob.KEY_ID + "=" + nameId, null, null, null, null);
		return c;
	}

	public Cursor queryAll6(int nameId) {
		String[] cols = { openHelper_ob.KEY_ID, openHelper_ob.SQUARE611,
				openHelper_ob.SQUARE612, openHelper_ob.SQUARE613,
				openHelper_ob.SQUARE614, openHelper_ob.SQUARE615,
				openHelper_ob.SQUARE616, openHelper_ob.SQUARE617,
				openHelper_ob.SQUARE618, openHelper_ob.SQUARE621,
				openHelper_ob.SQUARE622, openHelper_ob.SQUARE623,
				openHelper_ob.SQUARE624, openHelper_ob.SQUARE625,
				openHelper_ob.SQUARE626, openHelper_ob.SQUARE627,
				openHelper_ob.SQUARE628, openHelper_ob.SQUARE631,
				openHelper_ob.SQUARE632, openHelper_ob.SQUARE633,
				openHelper_ob.SQUARE634, openHelper_ob.SQUARE635,
				openHelper_ob.SQUARE636, openHelper_ob.SQUARE637,
				openHelper_ob.SQUARE638, openHelper_ob.SQUARE641,
				openHelper_ob.SQUARE642, openHelper_ob.SQUARE643,
				openHelper_ob.SQUARE644, openHelper_ob.SQUARE645,
				openHelper_ob.SQUARE646, openHelper_ob.SQUARE647,
				openHelper_ob.SQUARE648, openHelper_ob.SQUARE651,
				openHelper_ob.SQUARE652, openHelper_ob.SQUARE653,
				openHelper_ob.SQUARE654, openHelper_ob.SQUARE655,
				openHelper_ob.SQUARE656, openHelper_ob.SQUARE657,
				openHelper_ob.SQUARE658 };
		opnToWrite();
		Cursor c = database_ob.query(openHelper_ob.TABLE_NAME6, cols,
				openHelper_ob.KEY_ID + "=" + nameId, null, null, null, null);
		return c;
	}

	public Cursor queryAll7(int nameId) {
		String[] cols = { openHelper_ob.KEY_ID, openHelper_ob.SQUARE711,
				openHelper_ob.SQUARE712, openHelper_ob.SQUARE713,
				openHelper_ob.SQUARE714, openHelper_ob.SQUARE715,
				openHelper_ob.SQUARE716, openHelper_ob.SQUARE717,
				openHelper_ob.SQUARE718, openHelper_ob.SQUARE721,
				openHelper_ob.SQUARE722, openHelper_ob.SQUARE723,
				openHelper_ob.SQUARE724, openHelper_ob.SQUARE725,
				openHelper_ob.SQUARE726, openHelper_ob.SQUARE727,
				openHelper_ob.SQUARE728, openHelper_ob.SQUARE731,
				openHelper_ob.SQUARE732, openHelper_ob.SQUARE733,
				openHelper_ob.SQUARE734, openHelper_ob.SQUARE735,
				openHelper_ob.SQUARE736, openHelper_ob.SQUARE737,
				openHelper_ob.SQUARE738, openHelper_ob.SQUARE741,
				openHelper_ob.SQUARE742, openHelper_ob.SQUARE743,
				openHelper_ob.SQUARE744, openHelper_ob.SQUARE745,
				openHelper_ob.SQUARE746, openHelper_ob.SQUARE747,
				openHelper_ob.SQUARE748, openHelper_ob.SQUARE751,
				openHelper_ob.SQUARE752, openHelper_ob.SQUARE753,
				openHelper_ob.SQUARE754, openHelper_ob.SQUARE755,
				openHelper_ob.SQUARE756, openHelper_ob.SQUARE757,
				openHelper_ob.SQUARE758 };
		opnToWrite();
		Cursor c = database_ob.query(openHelper_ob.TABLE_NAME7, cols,
				openHelper_ob.KEY_ID + "=" + nameId, null, null, null, null);
		return c;
	}
	
	public Cursor queryAll8(int nameId) {
		String[] cols = { openHelper_ob.KEY_ID, openHelper_ob.SQUARE811,
				openHelper_ob.SQUARE812, openHelper_ob.SQUARE813,
				openHelper_ob.SQUARE814, openHelper_ob.SQUARE815,
				openHelper_ob.SQUARE816, openHelper_ob.SQUARE817,
				openHelper_ob.SQUARE818, openHelper_ob.SQUARE821,
				openHelper_ob.SQUARE822, openHelper_ob.SQUARE823,
				openHelper_ob.SQUARE824, openHelper_ob.SQUARE825,
				openHelper_ob.SQUARE826, openHelper_ob.SQUARE827,
				openHelper_ob.SQUARE828, openHelper_ob.SQUARE831,
				openHelper_ob.SQUARE832, openHelper_ob.SQUARE833,
				openHelper_ob.SQUARE834, openHelper_ob.SQUARE835,
				openHelper_ob.SQUARE836, openHelper_ob.SQUARE837,
				openHelper_ob.SQUARE838, openHelper_ob.SQUARE841,
				openHelper_ob.SQUARE842, openHelper_ob.SQUARE843,
				openHelper_ob.SQUARE844, openHelper_ob.SQUARE845,
				openHelper_ob.SQUARE846, openHelper_ob.SQUARE847,
				openHelper_ob.SQUARE848, openHelper_ob.SQUARE851,
				openHelper_ob.SQUARE852, openHelper_ob.SQUARE853,
				openHelper_ob.SQUARE854, openHelper_ob.SQUARE855,
				openHelper_ob.SQUARE856, openHelper_ob.SQUARE857,
				openHelper_ob.SQUARE858 };
		opnToWrite();
		Cursor c = database_ob.query(openHelper_ob.TABLE_NAME8, cols,
				openHelper_ob.KEY_ID + "=" + nameId, null, null, null, null);
		return c;
	}

	public long updateDetail1(int rowId, String square111, String square112,
			String square113, String square114, String square115,
			String square116, String square117, String square118,
			String square121, String square122, String square123,
			String square124, String square125, String square126,
			String square127, String square128, String square131,
			String square132, String square133, String square134,
			String square135, String square136, String square137,
			String square138, String square141, String square142,
			String square143, String square144, String square145,
			String square146, String square147, String square148,
			String square151, String square152, String square153,
			String square154, String square155, String square156,
			String square157, String square158) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(openHelper_ob.SQUARE111, square111);
		contentValues.put(openHelper_ob.SQUARE112, square112);
		contentValues.put(openHelper_ob.SQUARE113, square113);
		contentValues.put(openHelper_ob.SQUARE114, square114);
		contentValues.put(openHelper_ob.SQUARE115, square115);
		contentValues.put(openHelper_ob.SQUARE116, square116);
		contentValues.put(openHelper_ob.SQUARE117, square117);
		contentValues.put(openHelper_ob.SQUARE118, square118);

		contentValues.put(openHelper_ob.SQUARE121, square121);
		contentValues.put(openHelper_ob.SQUARE122, square122);
		contentValues.put(openHelper_ob.SQUARE123, square123);
		contentValues.put(openHelper_ob.SQUARE124, square124);
		contentValues.put(openHelper_ob.SQUARE125, square125);
		contentValues.put(openHelper_ob.SQUARE126, square126);
		contentValues.put(openHelper_ob.SQUARE127, square127);
		contentValues.put(openHelper_ob.SQUARE128, square128);

		contentValues.put(openHelper_ob.SQUARE131, square131);
		contentValues.put(openHelper_ob.SQUARE132, square132);
		contentValues.put(openHelper_ob.SQUARE133, square133);
		contentValues.put(openHelper_ob.SQUARE134, square134);
		contentValues.put(openHelper_ob.SQUARE135, square135);
		contentValues.put(openHelper_ob.SQUARE136, square136);
		contentValues.put(openHelper_ob.SQUARE137, square137);
		contentValues.put(openHelper_ob.SQUARE138, square138);

		contentValues.put(openHelper_ob.SQUARE141, square141);
		contentValues.put(openHelper_ob.SQUARE142, square142);
		contentValues.put(openHelper_ob.SQUARE143, square143);
		contentValues.put(openHelper_ob.SQUARE144, square144);
		contentValues.put(openHelper_ob.SQUARE145, square145);
		contentValues.put(openHelper_ob.SQUARE146, square146);
		contentValues.put(openHelper_ob.SQUARE147, square147);
		contentValues.put(openHelper_ob.SQUARE148, square148);

		contentValues.put(openHelper_ob.SQUARE151, square151);
		contentValues.put(openHelper_ob.SQUARE152, square152);
		contentValues.put(openHelper_ob.SQUARE153, square153);
		contentValues.put(openHelper_ob.SQUARE154, square154);
		contentValues.put(openHelper_ob.SQUARE155, square155);
		contentValues.put(openHelper_ob.SQUARE156, square156);
		contentValues.put(openHelper_ob.SQUARE157, square157);
		contentValues.put(openHelper_ob.SQUARE158, square158);
		opnToWrite();
		long val = database_ob.insert(openHelper_ob.TABLE_NAME1, null,
				contentValues);
		Close();
		return val;

	}

	public long updateDetail2(int rowId, String square211, String square212,
			String square213, String square214, String square215,
			String square216, String square217, String square218,
			String square221, String square222, String square223,
			String square224, String square225, String square226,
			String square227, String square228, String square231,
			String square232, String square233, String square234,
			String square235, String square236, String square237,
			String square238, String square241, String square242,
			String square243, String square244, String square245,
			String square246, String square247, String square248,
			String square251, String square252, String square253,
			String square254, String square255, String square256,
			String square257, String square258) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(openHelper_ob.SQUARE211, square211);
		contentValues.put(openHelper_ob.SQUARE212, square212);
		contentValues.put(openHelper_ob.SQUARE213, square213);
		contentValues.put(openHelper_ob.SQUARE214, square214);
		contentValues.put(openHelper_ob.SQUARE215, square215);
		contentValues.put(openHelper_ob.SQUARE216, square216);
		contentValues.put(openHelper_ob.SQUARE217, square217);
		contentValues.put(openHelper_ob.SQUARE218, square218);

		contentValues.put(openHelper_ob.SQUARE221, square221);
		contentValues.put(openHelper_ob.SQUARE222, square222);
		contentValues.put(openHelper_ob.SQUARE223, square223);
		contentValues.put(openHelper_ob.SQUARE224, square224);
		contentValues.put(openHelper_ob.SQUARE225, square225);
		contentValues.put(openHelper_ob.SQUARE226, square226);
		contentValues.put(openHelper_ob.SQUARE227, square227);
		contentValues.put(openHelper_ob.SQUARE228, square228);

		contentValues.put(openHelper_ob.SQUARE231, square231);
		contentValues.put(openHelper_ob.SQUARE232, square232);
		contentValues.put(openHelper_ob.SQUARE233, square233);
		contentValues.put(openHelper_ob.SQUARE234, square234);
		contentValues.put(openHelper_ob.SQUARE235, square235);
		contentValues.put(openHelper_ob.SQUARE236, square236);
		contentValues.put(openHelper_ob.SQUARE237, square237);
		contentValues.put(openHelper_ob.SQUARE238, square238);

		contentValues.put(openHelper_ob.SQUARE241, square241);
		contentValues.put(openHelper_ob.SQUARE242, square242);
		contentValues.put(openHelper_ob.SQUARE243, square243);
		contentValues.put(openHelper_ob.SQUARE244, square244);
		contentValues.put(openHelper_ob.SQUARE245, square245);
		contentValues.put(openHelper_ob.SQUARE246, square246);
		contentValues.put(openHelper_ob.SQUARE247, square247);
		contentValues.put(openHelper_ob.SQUARE248, square248);

		contentValues.put(openHelper_ob.SQUARE251, square251);
		contentValues.put(openHelper_ob.SQUARE252, square252);
		contentValues.put(openHelper_ob.SQUARE253, square253);
		contentValues.put(openHelper_ob.SQUARE254, square254);
		contentValues.put(openHelper_ob.SQUARE255, square255);
		contentValues.put(openHelper_ob.SQUARE256, square256);
		contentValues.put(openHelper_ob.SQUARE257, square257);
		contentValues.put(openHelper_ob.SQUARE258, square258);
		opnToWrite();
		long val = database_ob.insert(openHelper_ob.TABLE_NAME2, null,
				contentValues);
		Close();
		return val;

	}

	public long updateDetail3(int rowId, String square311, String square312,
			String square313, String square314, String square315,
			String square316, String square317, String square318,
			String square321, String square322, String square323,
			String square324, String square325, String square326,
			String square327, String square328, String square331,
			String square332, String square333, String square334,
			String square335, String square336, String square337,
			String square338, String square341, String square342,
			String square343, String square344, String square345,
			String square346, String square347, String square348,
			String square351, String square352, String square353,
			String square354, String square355, String square356,
			String square357, String square358) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(openHelper_ob.SQUARE311, square311);
		contentValues.put(openHelper_ob.SQUARE312, square312);
		contentValues.put(openHelper_ob.SQUARE313, square313);
		contentValues.put(openHelper_ob.SQUARE314, square314);
		contentValues.put(openHelper_ob.SQUARE315, square315);
		contentValues.put(openHelper_ob.SQUARE316, square316);
		contentValues.put(openHelper_ob.SQUARE317, square317);
		contentValues.put(openHelper_ob.SQUARE318, square318);

		contentValues.put(openHelper_ob.SQUARE321, square321);
		contentValues.put(openHelper_ob.SQUARE322, square322);
		contentValues.put(openHelper_ob.SQUARE323, square323);
		contentValues.put(openHelper_ob.SQUARE324, square324);
		contentValues.put(openHelper_ob.SQUARE325, square325);
		contentValues.put(openHelper_ob.SQUARE326, square326);
		contentValues.put(openHelper_ob.SQUARE327, square327);
		contentValues.put(openHelper_ob.SQUARE328, square328);

		contentValues.put(openHelper_ob.SQUARE331, square331);
		contentValues.put(openHelper_ob.SQUARE332, square332);
		contentValues.put(openHelper_ob.SQUARE333, square333);
		contentValues.put(openHelper_ob.SQUARE334, square334);
		contentValues.put(openHelper_ob.SQUARE335, square335);
		contentValues.put(openHelper_ob.SQUARE336, square336);
		contentValues.put(openHelper_ob.SQUARE337, square337);
		contentValues.put(openHelper_ob.SQUARE338, square338);

		contentValues.put(openHelper_ob.SQUARE341, square341);
		contentValues.put(openHelper_ob.SQUARE342, square342);
		contentValues.put(openHelper_ob.SQUARE343, square343);
		contentValues.put(openHelper_ob.SQUARE344, square344);
		contentValues.put(openHelper_ob.SQUARE345, square345);
		contentValues.put(openHelper_ob.SQUARE346, square346);
		contentValues.put(openHelper_ob.SQUARE347, square347);
		contentValues.put(openHelper_ob.SQUARE348, square348);

		contentValues.put(openHelper_ob.SQUARE351, square351);
		contentValues.put(openHelper_ob.SQUARE352, square352);
		contentValues.put(openHelper_ob.SQUARE353, square353);
		contentValues.put(openHelper_ob.SQUARE354, square354);
		contentValues.put(openHelper_ob.SQUARE355, square355);
		contentValues.put(openHelper_ob.SQUARE356, square356);
		contentValues.put(openHelper_ob.SQUARE357, square357);
		contentValues.put(openHelper_ob.SQUARE358, square358);
		opnToWrite();
		long val = database_ob.insert(openHelper_ob.TABLE_NAME3, null,
				contentValues);
		Close();
		return val;

	}

	public long updateDetail4(int rowId, String square411, String square412,
			String square413, String square414, String square415,
			String square416, String square417, String square418,
			String square421, String square422, String square423,
			String square424, String square425, String square426,
			String square427, String square428, String square431,
			String square432, String square433, String square434,
			String square435, String square436, String square437,
			String square438, String square441, String square442,
			String square443, String square444, String square445,
			String square446, String square447, String square448,
			String square451, String square452, String square453,
			String square454, String square455, String square456,
			String square457, String square458) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(openHelper_ob.SQUARE411, square411);
		contentValues.put(openHelper_ob.SQUARE412, square412);
		contentValues.put(openHelper_ob.SQUARE413, square413);
		contentValues.put(openHelper_ob.SQUARE414, square414);
		contentValues.put(openHelper_ob.SQUARE415, square415);
		contentValues.put(openHelper_ob.SQUARE416, square416);
		contentValues.put(openHelper_ob.SQUARE417, square417);
		contentValues.put(openHelper_ob.SQUARE418, square418);

		contentValues.put(openHelper_ob.SQUARE421, square421);
		contentValues.put(openHelper_ob.SQUARE422, square422);
		contentValues.put(openHelper_ob.SQUARE423, square423);
		contentValues.put(openHelper_ob.SQUARE424, square424);
		contentValues.put(openHelper_ob.SQUARE425, square425);
		contentValues.put(openHelper_ob.SQUARE426, square426);
		contentValues.put(openHelper_ob.SQUARE427, square427);
		contentValues.put(openHelper_ob.SQUARE428, square428);

		contentValues.put(openHelper_ob.SQUARE431, square431);
		contentValues.put(openHelper_ob.SQUARE432, square432);
		contentValues.put(openHelper_ob.SQUARE433, square433);
		contentValues.put(openHelper_ob.SQUARE434, square434);
		contentValues.put(openHelper_ob.SQUARE435, square435);
		contentValues.put(openHelper_ob.SQUARE436, square436);
		contentValues.put(openHelper_ob.SQUARE437, square437);
		contentValues.put(openHelper_ob.SQUARE438, square438);

		contentValues.put(openHelper_ob.SQUARE441, square441);
		contentValues.put(openHelper_ob.SQUARE442, square442);
		contentValues.put(openHelper_ob.SQUARE443, square443);
		contentValues.put(openHelper_ob.SQUARE444, square444);
		contentValues.put(openHelper_ob.SQUARE445, square445);
		contentValues.put(openHelper_ob.SQUARE446, square446);
		contentValues.put(openHelper_ob.SQUARE447, square447);
		contentValues.put(openHelper_ob.SQUARE448, square448);

		contentValues.put(openHelper_ob.SQUARE451, square451);
		contentValues.put(openHelper_ob.SQUARE452, square452);
		contentValues.put(openHelper_ob.SQUARE453, square453);
		contentValues.put(openHelper_ob.SQUARE454, square454);
		contentValues.put(openHelper_ob.SQUARE455, square455);
		contentValues.put(openHelper_ob.SQUARE456, square456);
		contentValues.put(openHelper_ob.SQUARE457, square457);
		contentValues.put(openHelper_ob.SQUARE458, square458);
		opnToWrite();
		long val = database_ob.insert(openHelper_ob.TABLE_NAME4, null,
				contentValues);
		Close();
		return val;

	}

	public long updateDetail5(int rowId, String square511, String square512,
			String square513, String square514, String square515,
			String square516, String square517, String square518,
			String square521, String square522, String square523,
			String square524, String square525, String square526,
			String square527, String square528, String square531,
			String square532, String square533, String square534,
			String square535, String square536, String square537,
			String square538, String square541, String square542,
			String square543, String square544, String square545,
			String square546, String square547, String square548,
			String square551, String square552, String square553,
			String square554, String square555, String square556,
			String square557, String square558) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(openHelper_ob.SQUARE511, square511);
		contentValues.put(openHelper_ob.SQUARE512, square512);
		contentValues.put(openHelper_ob.SQUARE513, square513);
		contentValues.put(openHelper_ob.SQUARE514, square514);
		contentValues.put(openHelper_ob.SQUARE515, square515);
		contentValues.put(openHelper_ob.SQUARE516, square516);
		contentValues.put(openHelper_ob.SQUARE517, square517);
		contentValues.put(openHelper_ob.SQUARE518, square518);

		contentValues.put(openHelper_ob.SQUARE521, square521);
		contentValues.put(openHelper_ob.SQUARE522, square522);
		contentValues.put(openHelper_ob.SQUARE523, square523);
		contentValues.put(openHelper_ob.SQUARE524, square524);
		contentValues.put(openHelper_ob.SQUARE525, square525);
		contentValues.put(openHelper_ob.SQUARE526, square526);
		contentValues.put(openHelper_ob.SQUARE527, square527);
		contentValues.put(openHelper_ob.SQUARE528, square528);

		contentValues.put(openHelper_ob.SQUARE531, square531);
		contentValues.put(openHelper_ob.SQUARE532, square532);
		contentValues.put(openHelper_ob.SQUARE533, square533);
		contentValues.put(openHelper_ob.SQUARE534, square534);
		contentValues.put(openHelper_ob.SQUARE535, square535);
		contentValues.put(openHelper_ob.SQUARE536, square536);
		contentValues.put(openHelper_ob.SQUARE537, square537);
		contentValues.put(openHelper_ob.SQUARE538, square538);

		contentValues.put(openHelper_ob.SQUARE541, square541);
		contentValues.put(openHelper_ob.SQUARE542, square542);
		contentValues.put(openHelper_ob.SQUARE543, square543);
		contentValues.put(openHelper_ob.SQUARE544, square544);
		contentValues.put(openHelper_ob.SQUARE545, square545);
		contentValues.put(openHelper_ob.SQUARE546, square546);
		contentValues.put(openHelper_ob.SQUARE547, square547);
		contentValues.put(openHelper_ob.SQUARE548, square548);

		contentValues.put(openHelper_ob.SQUARE551, square551);
		contentValues.put(openHelper_ob.SQUARE552, square552);
		contentValues.put(openHelper_ob.SQUARE553, square553);
		contentValues.put(openHelper_ob.SQUARE554, square554);
		contentValues.put(openHelper_ob.SQUARE555, square555);
		contentValues.put(openHelper_ob.SQUARE556, square556);
		contentValues.put(openHelper_ob.SQUARE557, square557);
		contentValues.put(openHelper_ob.SQUARE558, square558);
		opnToWrite();
		long val = database_ob.insert(openHelper_ob.TABLE_NAME5, null,
				contentValues);
		Close();
		return val;

	}

	public long updateDetail6(int rowId, String square611, String square612,
			String square613, String square614, String square615,
			String square616, String square617, String square618,
			String square621, String square622, String square623,
			String square624, String square625, String square626,
			String square627, String square628, String square631,
			String square632, String square633, String square634,
			String square635, String square636, String square637,
			String square638, String square641, String square642,
			String square643, String square644, String square645,
			String square646, String square647, String square648,
			String square651, String square652, String square653,
			String square654, String square655, String square656,
			String square657, String square658) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(openHelper_ob.SQUARE611, square611);
		contentValues.put(openHelper_ob.SQUARE612, square612);
		contentValues.put(openHelper_ob.SQUARE613, square613);
		contentValues.put(openHelper_ob.SQUARE614, square614);
		contentValues.put(openHelper_ob.SQUARE615, square615);
		contentValues.put(openHelper_ob.SQUARE616, square616);
		contentValues.put(openHelper_ob.SQUARE617, square617);
		contentValues.put(openHelper_ob.SQUARE618, square618);

		contentValues.put(openHelper_ob.SQUARE621, square621);
		contentValues.put(openHelper_ob.SQUARE622, square622);
		contentValues.put(openHelper_ob.SQUARE623, square623);
		contentValues.put(openHelper_ob.SQUARE624, square624);
		contentValues.put(openHelper_ob.SQUARE625, square625);
		contentValues.put(openHelper_ob.SQUARE626, square626);
		contentValues.put(openHelper_ob.SQUARE627, square627);
		contentValues.put(openHelper_ob.SQUARE628, square628);

		contentValues.put(openHelper_ob.SQUARE631, square631);
		contentValues.put(openHelper_ob.SQUARE632, square632);
		contentValues.put(openHelper_ob.SQUARE633, square633);
		contentValues.put(openHelper_ob.SQUARE634, square634);
		contentValues.put(openHelper_ob.SQUARE635, square635);
		contentValues.put(openHelper_ob.SQUARE636, square636);
		contentValues.put(openHelper_ob.SQUARE637, square637);
		contentValues.put(openHelper_ob.SQUARE638, square638);

		contentValues.put(openHelper_ob.SQUARE641, square641);
		contentValues.put(openHelper_ob.SQUARE642, square642);
		contentValues.put(openHelper_ob.SQUARE643, square643);
		contentValues.put(openHelper_ob.SQUARE644, square644);
		contentValues.put(openHelper_ob.SQUARE645, square645);
		contentValues.put(openHelper_ob.SQUARE646, square646);
		contentValues.put(openHelper_ob.SQUARE647, square647);
		contentValues.put(openHelper_ob.SQUARE648, square648);

		contentValues.put(openHelper_ob.SQUARE651, square651);
		contentValues.put(openHelper_ob.SQUARE652, square652);
		contentValues.put(openHelper_ob.SQUARE653, square653);
		contentValues.put(openHelper_ob.SQUARE654, square654);
		contentValues.put(openHelper_ob.SQUARE655, square655);
		contentValues.put(openHelper_ob.SQUARE656, square656);
		contentValues.put(openHelper_ob.SQUARE657, square657);
		contentValues.put(openHelper_ob.SQUARE658, square658);
		opnToWrite();
		long val = database_ob.insert(openHelper_ob.TABLE_NAME6, null,
				contentValues);
		Close();
		return val;

	}

	public long updateDetail7(int rowId, String square711, String square712,
			String square713, String square714, String square715,
			String square716, String square717, String square718,
			String square721, String square722, String square723,
			String square724, String square725, String square726,
			String square727, String square728, String square731,
			String square732, String square733, String square734,
			String square735, String square736, String square737,
			String square738, String square741, String square742,
			String square743, String square744, String square745,
			String square746, String square747, String square748,
			String square751, String square752, String square753,
			String square754, String square755, String square756,
			String square757, String square758) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(openHelper_ob.SQUARE711, square711);
		contentValues.put(openHelper_ob.SQUARE712, square712);
		contentValues.put(openHelper_ob.SQUARE713, square713);
		contentValues.put(openHelper_ob.SQUARE714, square714);
		contentValues.put(openHelper_ob.SQUARE715, square715);
		contentValues.put(openHelper_ob.SQUARE716, square716);
		contentValues.put(openHelper_ob.SQUARE717, square717);
		contentValues.put(openHelper_ob.SQUARE718, square718);

		contentValues.put(openHelper_ob.SQUARE721, square721);
		contentValues.put(openHelper_ob.SQUARE722, square722);
		contentValues.put(openHelper_ob.SQUARE723, square723);
		contentValues.put(openHelper_ob.SQUARE724, square724);
		contentValues.put(openHelper_ob.SQUARE725, square725);
		contentValues.put(openHelper_ob.SQUARE726, square726);
		contentValues.put(openHelper_ob.SQUARE727, square727);
		contentValues.put(openHelper_ob.SQUARE728, square728);

		contentValues.put(openHelper_ob.SQUARE731, square731);
		contentValues.put(openHelper_ob.SQUARE732, square732);
		contentValues.put(openHelper_ob.SQUARE733, square733);
		contentValues.put(openHelper_ob.SQUARE734, square734);
		contentValues.put(openHelper_ob.SQUARE735, square735);
		contentValues.put(openHelper_ob.SQUARE736, square736);
		contentValues.put(openHelper_ob.SQUARE737, square737);
		contentValues.put(openHelper_ob.SQUARE738, square738);

		contentValues.put(openHelper_ob.SQUARE741, square741);
		contentValues.put(openHelper_ob.SQUARE742, square742);
		contentValues.put(openHelper_ob.SQUARE743, square743);
		contentValues.put(openHelper_ob.SQUARE744, square744);
		contentValues.put(openHelper_ob.SQUARE745, square745);
		contentValues.put(openHelper_ob.SQUARE746, square746);
		contentValues.put(openHelper_ob.SQUARE747, square747);
		contentValues.put(openHelper_ob.SQUARE748, square748);

		contentValues.put(openHelper_ob.SQUARE751, square751);
		contentValues.put(openHelper_ob.SQUARE752, square752);
		contentValues.put(openHelper_ob.SQUARE753, square753);
		contentValues.put(openHelper_ob.SQUARE754, square754);
		contentValues.put(openHelper_ob.SQUARE755, square755);
		contentValues.put(openHelper_ob.SQUARE756, square756);
		contentValues.put(openHelper_ob.SQUARE757, square757);
		contentValues.put(openHelper_ob.SQUARE758, square758);
		opnToWrite();
		long val = database_ob.insert(openHelper_ob.TABLE_NAME7, null,
				contentValues);
		Close();
		return val;

	}
	
	public long updateDetail8(int rowId, String square811, String square812,
			String square813, String square814, String square815,
			String square816, String square817, String square818,
			String square821, String square822, String square823,
			String square824, String square825, String square826,
			String square827, String square828, String square831,
			String square832, String square833, String square834,
			String square835, String square836, String square837,
			String square838, String square841, String square842,
			String square843, String square844, String square845,
			String square846, String square847, String square848,
			String square851, String square852, String square853,
			String square854, String square855, String square856,
			String square857, String square858) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(openHelper_ob.SQUARE811, square811);
		contentValues.put(openHelper_ob.SQUARE812, square812);
		contentValues.put(openHelper_ob.SQUARE813, square813);
		contentValues.put(openHelper_ob.SQUARE814, square814);
		contentValues.put(openHelper_ob.SQUARE815, square815);
		contentValues.put(openHelper_ob.SQUARE816, square816);
		contentValues.put(openHelper_ob.SQUARE817, square817);
		contentValues.put(openHelper_ob.SQUARE818, square818);

		contentValues.put(openHelper_ob.SQUARE821, square821);
		contentValues.put(openHelper_ob.SQUARE822, square822);
		contentValues.put(openHelper_ob.SQUARE823, square823);
		contentValues.put(openHelper_ob.SQUARE824, square824);
		contentValues.put(openHelper_ob.SQUARE825, square825);
		contentValues.put(openHelper_ob.SQUARE826, square826);
		contentValues.put(openHelper_ob.SQUARE827, square827);
		contentValues.put(openHelper_ob.SQUARE828, square828);

		contentValues.put(openHelper_ob.SQUARE831, square831);
		contentValues.put(openHelper_ob.SQUARE832, square832);
		contentValues.put(openHelper_ob.SQUARE833, square833);
		contentValues.put(openHelper_ob.SQUARE834, square834);
		contentValues.put(openHelper_ob.SQUARE835, square835);
		contentValues.put(openHelper_ob.SQUARE836, square836);
		contentValues.put(openHelper_ob.SQUARE837, square837);
		contentValues.put(openHelper_ob.SQUARE838, square838);

		contentValues.put(openHelper_ob.SQUARE841, square841);
		contentValues.put(openHelper_ob.SQUARE842, square842);
		contentValues.put(openHelper_ob.SQUARE843, square843);
		contentValues.put(openHelper_ob.SQUARE844, square844);
		contentValues.put(openHelper_ob.SQUARE845, square845);
		contentValues.put(openHelper_ob.SQUARE846, square846);
		contentValues.put(openHelper_ob.SQUARE847, square847);
		contentValues.put(openHelper_ob.SQUARE848, square848);

		contentValues.put(openHelper_ob.SQUARE851, square851);
		contentValues.put(openHelper_ob.SQUARE852, square852);
		contentValues.put(openHelper_ob.SQUARE853, square853);
		contentValues.put(openHelper_ob.SQUARE854, square854);
		contentValues.put(openHelper_ob.SQUARE855, square855);
		contentValues.put(openHelper_ob.SQUARE856, square856);
		contentValues.put(openHelper_ob.SQUARE857, square857);
		contentValues.put(openHelper_ob.SQUARE858, square858);
		opnToWrite();
		long val = database_ob.insert(openHelper_ob.TABLE_NAME8, null,
				contentValues);
		Close();
		return val;

	}

	public int deletOneRecord1(int rowId) {
		// TODO Auto-generated method stub
		Log.e("$$$", "deletOneRecord1");
		opnToWrite();
		int val = database_ob.delete(openHelper_ob.TABLE_NAME1,
				openHelper_ob.KEY_ID + "=" + rowId, null);
		System.out.println("DELETE" + rowId);
		Close();
		System.out.println("VAL" + val);
		return val;
	}

	public int deletOneRecord2(int rowId) {
		// TODO Auto-generated method stub
		opnToWrite();
		int val = database_ob.delete(openHelper_ob.TABLE_NAME2,
				openHelper_ob.KEY_ID + "=" + rowId, null);
		Close();
		return val;
	}

	public int deletOneRecord3(int rowId) {
		// TODO Auto-generated method stub
		opnToWrite();
		int val = database_ob.delete(openHelper_ob.TABLE_NAME3,
				openHelper_ob.KEY_ID + "=" + rowId, null);
		Close();
		return val;
	}

	public int deletOneRecord4(int rowId) {
		// TODO Auto-generated method stub
		opnToWrite();
		int val = database_ob.delete(openHelper_ob.TABLE_NAME4,
				openHelper_ob.KEY_ID + "=" + rowId, null);
		Close();
		return val;
	}

	public int deletOneRecord5(int rowId) {
		// TODO Auto-generated method stub
		opnToWrite();
		int val = database_ob.delete(openHelper_ob.TABLE_NAME5,
				openHelper_ob.KEY_ID + "=" + rowId, null);
		Close();
		return val;
	}

	public int deletOneRecord6(int rowId) {
		// TODO Auto-generated method stub
		opnToWrite();
		int val = database_ob.delete(openHelper_ob.TABLE_NAME6,
				openHelper_ob.KEY_ID + "=" + rowId, null);
		Close();
		return val;
	}

	public int deletOneRecord7(int rowId) {
		// TODO Auto-generated method stub
		opnToWrite();
		int val = database_ob.delete(openHelper_ob.TABLE_NAME7,
				openHelper_ob.KEY_ID + "=" + rowId, null);
		Close();
		return val;
	}
	
	public int deletOneRecord8(int rowId) {
		// TODO Auto-generated method stub
		opnToWrite();
		int val = database_ob.delete(openHelper_ob.TABLE_NAME8,
				openHelper_ob.KEY_ID + "=" + rowId, null);
		Close();
		return val;
	}
}