package com.toh.carection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends ActionBarActivity {

	// Button sumAll, refresh;
	Context context = this;

	// ListView list;
	NavListAdapter adapter;
	String[] title;
	String[] subtitle;
	// int[] icon;

	// first square
	Button fb1, fb2, fb3, fb4, fb5, fb6, fb7, fb8;
	Button sb1, sb2, sb3, sb4, sb5, sb6, sb7, sb8;
	Button tb1, tb2, tb3, tb4, tb5, tb6, tb7, tb8;
	Button fob1, fob2, fob3, fob4, fob5, fob6, fob7, fob8;
	Button fib1, fib2, fib3, fib4, fib5, fib6, fib7, fib8;
	Button sib1, sib2, sib3, sib4, sib5, sib6, sib7, sib8;
	Button seb1, seb2, seb3, seb4, seb5, seb6, seb7, seb8;
	Button eb1, eb2, eb3, eb4, eb5, eb6, eb7, eb8;

	// second square
	Button s2fb1, s2fb2, s2fb3, s2fb4, s2fb5, s2fb6, s2fb7, s2fb8;
	Button s2sb1, s2sb2, s2sb3, s2sb4, s2sb5, s2sb6, s2sb7, s2sb8;
	Button s2tb1, s2tb2, s2tb3, s2tb4, s2tb5, s2tb6, s2tb7, s2tb8;
	Button s2fob1, s2fob2, s2fob3, s2fob4, s2fob5, s2fob6, s2fob7, s2fob8;
	Button s2fib1, s2fib2, s2fib3, s2fib4, s2fib5, s2fib6, s2fib7, s2fib8;
	Button s2sib1, s2sib2, s2sib3, s2sib4, s2sib5, s2sib6, s2sib7, s2sib8;
	Button s2seb1, s2seb2, s2seb3, s2seb4, s2seb5, s2seb6, s2seb7, s2seb8;
	Button s2eb1, s2eb2, s2eb3, s2eb4, s2eb5, s2eb6, s2eb7, s2eb8;

	// 3rd square
	Button s3fb1, s3fb2, s3fb3, s3fb4, s3fb5, s3fb6, s3fb7, s3fb8;
	Button s3sb1, s3sb2, s3sb3, s3sb4, s3sb5, s3sb6, s3sb7, s3sb8;
	Button s3tb1, s3tb2, s3tb3, s3tb4, s3tb5, s3tb6, s3tb7, s3tb8;
	Button s3fob1, s3fob2, s3fob3, s3fob4, s3fob5, s3fob6, s3fob7, s3fob8;
	Button s3fib1, s3fib2, s3fib3, s3fib4, s3fib5, s3fib6, s3fib7, s3fib8;
	Button s3sib1, s3sib2, s3sib3, s3sib4, s3sib5, s3sib6, s3sib7, s3sib8;
	Button s3seb1, s3seb2, s3seb3, s3seb4, s3seb5, s3seb6, s3seb7, s3seb8;
	Button s3eb1, s3eb2, s3eb3, s3eb4, s3eb5, s3eb6, s3eb7, s3eb8;

	// 4th square
	Button s4fb1, s4fb2, s4fb3, s4fb4, s4fb5, s4fb6, s4fb7, s4fb8;
	Button s4sb1, s4sb2, s4sb3, s4sb4, s4sb5, s4sb6, s4sb7, s4sb8;
	Button s4tb1, s4tb2, s4tb3, s4tb4, s4tb5, s4tb6, s4tb7, s4tb8;
	Button s4fob1, s4fob2, s4fob3, s4fob4, s4fob5, s4fob6, s4fob7, s4fob8;
	Button s4fib1, s4fib2, s4fib3, s4fib4, s4fib5, s4fib6, s4fib7, s4fib8;
	Button s4sib1, s4sib2, s4sib3, s4sib4, s4sib5, s4sib6, s4sib7, s4sib8;
	Button s4seb1, s4seb2, s4seb3, s4seb4, s4seb5, s4seb6, s4seb7, s4seb8;
	Button s4eb1, s4eb2, s4eb3, s4eb4, s4eb5, s4eb6, s4eb7, s4eb8;

	// 5th square
	Button s5fb1, s5fb2, s5fb3, s5fb4, s5fb5, s5fb6, s5fb7, s5fb8;
	Button s5sb1, s5sb2, s5sb3, s5sb4, s5sb5, s5sb6, s5sb7, s5sb8;
	Button s5tb1, s5tb2, s5tb3, s5tb4, s5tb5, s5tb6, s5tb7, s5tb8;
	Button s5fob1, s5fob2, s5fob3, s5fob4, s5fob5, s5fob6, s5fob7, s5fob8;
	Button s5fib1, s5fib2, s5fib3, s5fib4, s5fib5, s5fib6, s5fib7, s5fib8;
	Button s5sib1, s5sib2, s5sib3, s5sib4, s5sib5, s5sib6, s5sib7, s5sib8;
	Button s5seb1, s5seb2, s5seb3, s5seb4, s5seb5, s5seb6, s5seb7, s5seb8;
	Button s5eb1, s5eb2, s5eb3, s5eb4, s5eb5, s5eb6, s5eb7, s5eb8;

	// // 6th square
	// Button s6fb1, s6fb2, s6fb3, s6fb4, s6fb5, s6fb6, s6fb7, s6fb8;
	// Button s6sb1, s6sb2, s6sb3, s6sb4, s6sb5, s6sb6, s6sb7, s6sb8;
	// Button s6tb1, s6tb2, s6tb3, s6tb4, s6tb5, s6tb6, s6tb7, s6tb8;
	// Button s6fob1, s6fob2, s6fob3, s6fob4, s6fob5, s6fob6, s6fob7, s6fob8;
	// Button s6fib1, s6fib2, s6fib3, s6fib4, s6fib5, s6fib6, s6fib7, s6fib8;
	// Button s6sib1, s6sib2, s6sib3, s6sib4, s6sib5, s6sib6, s6sib7, s6sib8;
	// Button s6seb1, s6seb2, s6seb3, s6seb4, s6seb5, s6seb6, s6seb7, s6seb8;
	// Button s6eb1, s6eb2, s6eb3, s6eb4, s26eb5, s6eb6, s6eb7, s6eb8;
	//
	// // 7th square
	// Button s7fb1, s7fb2, s7fb3, s7fb4, s7fb5, s7fb6, s7fb7, s7fb8;
	// Button s7sb1, s7sb2, s7sb3, s7sb4, s7sb5, s7sb6, s7sb7, s7sb8;
	// Button s7tb1, s7tb2, s7tb3, s7tb4, s7tb5, s7tb6, s7tb7, s7tb8;
	// Button s7fob1, s7fob2, s7fob3, s7fob4, s7fob5, s7fob6, s7fob7, s7fob8;
	// Button s7fib1, s7fib2, s7fib3, s7fib4, s7fib5, s7fib6, s7fib7, s7fib8;
	// Button s7sib1, s7sib2, s7sib3, s7sib4, s7sib5, s7sib6, s7sib7, s7sib8;
	// Button s7seb1, s7seb2, s7seb3, s7seb4, s7seb5, s7seb6, s7seb7, s7seb8;
	// Button s7eb1, s7eb2, s7eb3, s7eb4, s7eb5, s7eb6, s7eb7, s7eb8;
	//
	// // 8th square
	// Button s8fb1, s8fb2, s8fb3, s8fb4, s8fb5, s8fb6, s8fb7, s8fb8;
	// Button s8sb1, s8sb2, s8sb3, s8sb4, s8sb5, s8sb6, s8sb7, s8sb8;
	// Button s8tb1, s8tb2, s8tb3, s8tb4, s8tb5, s8tb6, s8tb7, s8tb8;
	// Button s8fob1, s8fob2, s8fob3, s8fob4, s8fob5, s8fob6, s8fob7, s8fob8;
	// Button s8fib1, s8fib2, s8fib3, s8fib4, s8fib5, s8fib6, s8fib7, s8fib8;
	// Button s8sib1, s8sib2, s8sib3, s8sib4, s8sib5, s8sib6, s8sib7, s8sib8;
	// Button s8seb1, s8seb2, s8seb3, s8seb4, s8seb5, s8seb6, s8seb7, s8seb8;
	// Button s8eb1, s8eb2, s8eb3, s8eb4, s8eb5, s8eb6, s8eb7, s8eb8;

	// sum variables
	int frs = 0, srs = 0, trs = 0, fors = 0, firs = 0, sirs = 0, sers = 0,
			ers = 0;
	int s2frs = 0, s2srs = 0, s2trs = 0, s2fors = 0, s2firs = 0, s2sirs = 0,
			s2sers = 0, s2ers = 0;
	int s3frs = 0, s3srs = 0, s3trs = 0, s3fors = 0, s3firs = 0, s3sirs = 0,
			s3sers = 0, s3ers = 0;
	int s4frs = 0, s4srs = 0, s4trs = 0, s4fors = 0, s4firs = 0, s4sirs = 0,
			s4sers = 0, s4ers = 0;
	int s5frs = 0, s5srs = 0, s5trs = 0, s5fors = 0, s5firs = 0, s5sirs = 0,
			s5sers = 0, s5ers = 0;

	// first square
	int fr1 = 0, fr2 = 0, fr3 = 0, fr4 = 0, fr5 = 0, fr6 = 0, fr7 = 0, fr8 = 0;
	int sr1 = 0, sr2 = 0, sr3 = 0, sr4 = 0, sr5 = 0, sr6 = 0, sr7 = 0, sr8 = 0;
	int tr1 = 0, tr2 = 0, tr3 = 0, tr4 = 0, tr5 = 0, tr6 = 0, tr7 = 0, tr8 = 0;
	int for1 = 0, for2 = 0, for3 = 0, for4 = 0, for5 = 0, for6 = 0, for7 = 0,
			for8 = 0;
	int fir1 = 0, fir2 = 0, fir3 = 0, fir4 = 0, fir5 = 0, fir6 = 0, fir7 = 0,
			fir8 = 0;
	int sir1 = 0, sir2 = 0, sir3 = 0, sir4 = 0, sir5 = 0, sir6 = 0, sir7 = 0,
			sir8 = 0;
	int ser1 = 0, ser2 = 0, ser3 = 0, ser4 = 0, ser5 = 0, ser6 = 0, ser7 = 0,
			ser8 = 0;
	int er1 = 0, er2 = 0, er3 = 0, er4 = 0, er5 = 0, er6 = 0, er7 = 0, er8 = 0;

	// second square
	int s2fr1 = 0, s2fr2 = 0, s2fr3 = 0, s2fr4 = 0, s2fr5 = 0, s2fr6 = 0,
			s2fr7 = 0, s2fr8 = 0;
	int s2sr1 = 0, s2sr2 = 0, s2sr3 = 0, s2sr4 = 0, s2sr5 = 0, s2sr6 = 0,
			s2sr7 = 0, s2sr8 = 0;
	int s2tr1 = 0, s2tr2 = 0, s2tr3 = 0, s2tr4 = 0, s2tr5 = 0, s2tr6 = 0,
			s2tr7 = 0, s2tr8 = 0;
	int s2for1 = 0, s2for2 = 0, s2for3 = 0, s2for4 = 0, s2for5 = 0, s2for6 = 0,
			s2for7 = 0, s2for8 = 0;
	int s2fir1 = 0, s2fir2 = 0, s2fir3 = 0, s2fir4 = 0, s2fir5 = 0, s2fir6 = 0,
			s2fir7 = 0, s2fir8 = 0;
	int s2sir1 = 0, s2sir2 = 0, s2sir3 = 0, s2sir4 = 0, s2sir5 = 0, s2sir6 = 0,
			s2sir7 = 0, s2sir8 = 0;
	int s2ser1 = 0, s2ser2 = 0, s2ser3 = 0, s2ser4 = 0, s2ser5 = 0, s2ser6 = 0,
			s2ser7 = 0, s2ser8 = 0;
	int s2er1 = 0, s2er2 = 0, s2er3 = 0, s2er4 = 0, s2er5 = 0, s2er6 = 0,
			s2er7 = 0, s2er8 = 0;

	// third square
	int s3fr1 = 0, s3fr2 = 0, s3fr3 = 0, s3fr4 = 0, s3fr5 = 0, s3fr6 = 0,
			s3fr7 = 0, s3fr8 = 0;
	int s3sr1 = 0, s3sr2 = 0, s3sr3 = 0, s3sr4 = 0, s3sr5 = 0, s3sr6 = 0,
			s3sr7 = 0, s3sr8 = 0;
	int s3tr1 = 0, s3tr2 = 0, s3tr3 = 0, s3tr4 = 0, s3tr5 = 0, s3tr6 = 0,
			s3tr7 = 0, s3tr8 = 0;
	int s3for1 = 0, s3for2 = 0, s3for3 = 0, s3for4 = 0, s3for5 = 0, s3for6 = 0,
			s3for7 = 0, s3for8 = 0;
	int s3fir1 = 0, s3fir2 = 0, s3fir3 = 0, s3fir4 = 0, s3fir5 = 0, s3fir6 = 0,
			s3fir7 = 0, s3fir8 = 0;
	int s3sir1 = 0, s3sir2 = 0, s3sir3 = 0, s3sir4 = 0, s3sir5 = 0, s3sir6 = 0,
			s3sir7 = 0, s3sir8 = 0;
	int s3ser1 = 0, s3ser2 = 0, s3ser3 = 0, s3ser4 = 0, s3ser5 = 0, s3ser6 = 0,
			s3ser7 = 0, s3ser8 = 0;
	int s3er1 = 0, s3er2 = 0, s3er3 = 0, s3er4 = 0, s3er5 = 0, s3er6 = 0,
			s3er7 = 0, s3er8 = 0;

	// forth square
	int s4fr1 = 0, s4fr2 = 0, s4fr3 = 0, s4fr4 = 0, s4fr5 = 0, s4fr6 = 0,
			s4fr7 = 0, s4fr8 = 0;
	int s4sr1 = 0, s4sr2 = 0, s4sr3 = 0, s4sr4 = 0, s4sr5 = 0, s4sr6 = 0,
			s4sr7 = 0, s4sr8 = 0;
	int s4tr1 = 0, s4tr2 = 0, s4tr3 = 0, s4tr4 = 0, s4tr5 = 0, s4tr6 = 0,
			s4tr7 = 0, s4tr8 = 0;
	int s4for1 = 0, s4for2 = 0, s4for3 = 0, s4for4 = 0, s4for5 = 0, s4for6 = 0,
			s4for7 = 0, s4for8 = 0;
	int s4fir1 = 0, s4fir2 = 0, s4fir3 = 0, s4fir4 = 0, s4fir5 = 0, s4fir6 = 0,
			s4fir7 = 0, s4fir8 = 0;
	int s4sir1 = 0, s4sir2 = 0, s4sir3 = 0, s4sir4 = 0, s4sir5 = 0, s4sir6 = 0,
			s4sir7 = 0, s4sir8 = 0;
	int s4ser1 = 0, s4ser2 = 0, s4ser3 = 0, s4ser4 = 0, s4ser5 = 0, s4ser6 = 0,
			s4ser7 = 0, s4ser8 = 0;
	int s4er1 = 0, s4er2 = 0, s4er3 = 0, s4er4 = 0, s4er5 = 0, s4er6 = 0,
			s4er7 = 0, s4er8 = 0;

	// fifth square
	int s5fr1 = 0, s5fr2 = 0, s5fr3 = 0, s5fr4 = 0, s5fr5 = 0, s5fr6 = 0,
			s5fr7 = 0, s5fr8 = 0;
	int s5sr1 = 0, s5sr2 = 0, s5sr3 = 0, s5sr4 = 0, s5sr5 = 0, s5sr6 = 0,
			s5sr7 = 0, s5sr8 = 0;
	int s5tr1 = 0, s5tr2 = 0, s5tr3 = 0, s5tr4 = 0, s5tr5 = 0, s5tr6 = 0,
			s5tr7 = 0, s5tr8 = 0;
	int s5for1 = 0, s5for2 = 0, s5for3 = 0, s5for4 = 0, s5for5 = 0, s5for6 = 0,
			s5for7 = 0, s5for8 = 0;
	int s5fir1 = 0, s5fir2 = 0, s5fir3 = 0, s5fir4 = 0, s5fir5 = 0, s5fir6 = 0,
			s5fir7 = 0, s5fir8 = 0;
	int s5sir1 = 0, s5sir2 = 0, s5sir3 = 0, s5sir4 = 0, s5sir5 = 0, s5sir6 = 0,
			s5sir7 = 0, s5sir8 = 0;
	int s5ser1 = 0, s5ser2 = 0, s5ser3 = 0, s5ser4 = 0, s5ser5 = 0, s5ser6 = 0,
			s5ser7 = 0, s5ser8 = 0;
	int s5er1 = 0, s5er2 = 0, s5er3 = 0, s5er4 = 0, s5er5 = 0, s5er6 = 0,
			s5er7 = 0, s5er8 = 0;

	// sixth square
	// int s6fr1 = 0, s6fr2 = 0, s6fr3 = 0, s6fr4 = 0, s6fr5 = 0, s6fr6 = 0,
	// s6fr7 = 0, s6fr8 = 0;
	// int s6sr1 = 0, s6sr2 = 0, s6sr3 = 0, s6sr4 = 0, s6sr5 = 0, s6sr6 = 0,
	// s6sr7 = 0, s6sr8 = 0;
	// int s6tr1 = 0, s6tr2 = 0, s6tr3 = 0, s6tr4 = 0, s6tr5 = 0, s6tr6 = 0,
	// s6tr7 = 0, s6tr8 = 0;
	// int s6for1 = 0, s6for2 = 0, s6for3 = 0, s6for4 = 0, s6for5 = 0, s6for6 =
	// 0,
	// s6for7 = 0, s6for8 = 0;
	// int s6fir1 = 0, s6fir2 = 0, s6fir3 = 0, s6fir4 = 0, s6fir5 = 0, s6fir6 =
	// 0,
	// s6fir7 = 0, s6fir8 = 0;
	// int s6sir1 = 0, s6sir2 = 0, s6sir3 = 0, s6sir4 = 0, s6sir5 = 0, s6sir6 =
	// 0,
	// s6sir7 = 0, s6sir8 = 0;
	// int s6ser1 = 0, s6ser2 = 0, s6ser3 = 0, s6ser4 = 0, s6ser5 = 0, s6ser6 =
	// 0,
	// s6ser7 = 0, s6ser8 = 0;
	// int s6er1 = 0, s6er2 = 0, s6er3 = 0, s6er4 = 0, s6er5 = 0, s6er6 = 0,
	// s6er7 = 0, s6er8 = 0;

	HorizontalScrollView mHorizontalScroll;
	int[] square1, square2, square3, square4, square5;

	RegistrationAdapter adapter1;
	RegistrationOpenHelper helper1;

	// SharedPreferences sharedPrefs;
	//Boolean yourLocked;
	Cursor cursor;
	int allSum = 0, refresh = 0, del = 0, tog = 0;

	SharedPreferences sharedPrefs1, sharedPrefs2, sharedPrefs3, sharedPrefs4,
			sharedPrefs5, sharedPrefs6, sharedPrefs7, sharedPrefs8,
			sharedPrefs9, sharedPrefs10, sharedPrefs11, sharedPrefs12,
			sharedPrefs13, sharedPrefs14, sharedPrefs15, sharedPrefs16,
			sharedPrefs17, sharedPrefs18, sharedPrefs19, sharedPrefs20,
			sharedPrefs21, sharedPrefs22, sharedPrefs23, sharedPrefs24,
			sharedPrefs25, sharedPrefs26, sharedPrefs27, sharedPrefs28,
			sharedPrefs29, sharedPrefs30, sharedPrefs31, sharedPrefs32,
			sharedPrefs33, sharedPrefs34, sharedPrefs35, sharedPrefs36,
			sharedPrefs37, sharedPrefs38, sharedPrefs39, sharedPrefs40,
			sharedPrefs41, sharedPrefs42, sharedPrefs43, sharedPrefs44,
			sharedPrefs45, sharedPrefs46, sharedPrefs47, sharedPrefs48,
			sharedPrefs49, sharedPrefs50, sharedPrefs51, sharedPrefs52,
			sharedPrefs53, sharedPrefs54, sharedPrefs55, sharedPrefs56,
			sharedPrefs57, sharedPrefs58, sharedPrefs59, sharedPrefs60,
			sharedPrefs61, sharedPrefs62, sharedPrefs63, sharedPrefs64,
			sharedPrefs65, sharedPrefs66, sharedPrefs67, sharedPrefs68,
			sharedPrefs69, sharedPrefs70, sharedPrefs71, sharedPrefs72,
			sharedPrefs73, sharedPrefs74, sharedPrefs75, sharedPrefs76,
			sharedPrefs77, sharedPrefs78, sharedPrefs79, sharedPrefs80,
			sharedPrefs81, sharedPrefs82, sharedPrefs83, sharedPrefs84,
			sharedPrefs85, sharedPrefs86, sharedPrefs87, sharedPrefs88,
			sharedPrefs89, sharedPrefs90, sharedPrefs91, sharedPrefs92,
			sharedPrefs93, sharedPrefs94, sharedPrefs95, sharedPrefs96,
			sharedPrefs97, sharedPrefs98, sharedPrefs99, sharedPrefs100,
			sharedPrefs101, sharedPrefs102, sharedPrefs103, sharedPrefs104,
			sharedPrefs105, sharedPrefs106, sharedPrefs107, sharedPrefs108,
			sharedPrefs109, sharedPrefs110, sharedPrefs111, sharedPrefs112,
			sharedPrefs113, sharedPrefs114, sharedPrefs115, sharedPrefs116,
			sharedPrefs117, sharedPrefs118, sharedPrefs119, sharedPrefs120,
			sharedPrefs121, sharedPrefs122, sharedPrefs123, sharedPrefs124,
			sharedPrefs125, sharedPrefs126, sharedPrefs127, sharedPrefs128,
			sharedPrefs129, sharedPrefs130, sharedPrefs131, sharedPrefs132,
			sharedPrefs133, sharedPrefs134, sharedPrefs135, sharedPrefs136,
			sharedPrefs137, sharedPrefs138, sharedPrefs139, sharedPrefs140,
			sharedPrefs141, sharedPrefs142, sharedPrefs143, sharedPrefs144,
			sharedPrefs145, sharedPrefs146, sharedPrefs147, sharedPrefs148,
			sharedPrefs149, sharedPrefs150, sharedPrefs151, sharedPrefs152,
			sharedPrefs153, sharedPrefs154, sharedPrefs155, sharedPrefs156,
			sharedPrefs157, sharedPrefs158, sharedPrefs159, sharedPrefs160,
			sharedPrefs161, sharedPrefs162, sharedPrefs163, sharedPrefs164,
			sharedPrefs165, sharedPrefs166, sharedPrefs167, sharedPrefs168,
			sharedPrefs169, sharedPrefs170, sharedPrefs171, sharedPrefs172,
			sharedPrefs173, sharedPrefs174, sharedPrefs175, sharedPrefs176,
			sharedPrefs177, sharedPrefs178, sharedPrefs179, sharedPrefs180,
			sharedPrefs181, sharedPrefs182, sharedPrefs183, sharedPrefs184,
			sharedPrefs185, sharedPrefs186, sharedPrefs187, sharedPrefs188,
			sharedPrefs189, sharedPrefs190, sharedPrefs191, sharedPrefs192,
			sharedPrefs193, sharedPrefs194, sharedPrefs195, sharedPrefs196,
			sharedPrefs197, sharedPrefs198, sharedPrefs199, sharedPrefs200,
			sharedPrefs201, sharedPrefs202, sharedPrefs203, sharedPrefs204,
			sharedPrefs205, sharedPrefs206, sharedPrefs207, sharedPrefs208,
			sharedPrefs209, sharedPrefs210, sharedPrefs211, sharedPrefs212,
			sharedPrefs213, sharedPrefs214, sharedPrefs215, sharedPrefs216,
			sharedPrefs217, sharedPrefs218, sharedPrefs219, sharedPrefs220,
			sharedPrefs221, sharedPrefs222, sharedPrefs223, sharedPrefs224,
			sharedPrefs225, sharedPrefs226, sharedPrefs227, sharedPrefs228,
			sharedPrefs229, sharedPrefs230, sharedPrefs231, sharedPrefs232,
			sharedPrefs233, sharedPrefs234, sharedPrefs235, sharedPrefs236,
			sharedPrefs237, sharedPrefs238, sharedPrefs239, sharedPrefs240,
			sharedPrefs241, sharedPrefs242, sharedPrefs243, sharedPrefs244,
			sharedPrefs245, sharedPrefs246, sharedPrefs247, sharedPrefs248,
			sharedPrefs249, sharedPrefs250, sharedPrefs251, sharedPrefs252,
			sharedPrefs253, sharedPrefs254, sharedPrefs255, sharedPrefs256,
			sharedPrefs257, sharedPrefs258, sharedPrefs259, sharedPrefs260,
			sharedPrefs261, sharedPrefs262, sharedPrefs263, sharedPrefs264,
			sharedPrefs265, sharedPrefs266, sharedPrefs267, sharedPrefs268,
			sharedPrefs269, sharedPrefs270, sharedPrefs271, sharedPrefs272,
			sharedPrefs273, sharedPrefs274, sharedPrefs275, sharedPrefs276,
			sharedPrefs277, sharedPrefs278, sharedPrefs279, sharedPrefs280,
			sharedPrefs281, sharedPrefs282, sharedPrefs283, sharedPrefs284,
			sharedPrefs285, sharedPrefs286, sharedPrefs287, sharedPrefs288,
			sharedPrefs289, sharedPrefs290, sharedPrefs291, sharedPrefs292,
			sharedPrefs293, sharedPrefs294, sharedPrefs295, sharedPrefs296,
			sharedPrefs297, sharedPrefs298, sharedPrefs299, sharedPrefs300,
			sharedPrefs301, sharedPrefs302, sharedPrefs303, sharedPrefs304,
			sharedPrefs305, sharedPrefs306, sharedPrefs307, sharedPrefs308,
			sharedPrefs309, sharedPrefs310, sharedPrefs311, sharedPrefs312,
			sharedPrefs313, sharedPrefs314, sharedPrefs315, sharedPrefs316,
			sharedPrefs317, sharedPrefs318, sharedPrefs319, sharedPrefs320;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.firstactivity);

		// sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
		adapter1 = new RegistrationAdapter(this);

		SharedPreferences preferences2 = PreferenceManager
				.getDefaultSharedPreferences(this);
		refresh = preferences2.getInt("first1", 0);
		del = preferences2.getInt("first2", 0);
		tog = preferences2.getInt("tog", 0);
		allSum = preferences2.getInt("allSum1", 0);

		System.out.println("allSum1" + allSum);
		System.out.println("TOGACT" + tog);

		// Generate title
		title = new String[] { "주행모드", "주행모드", "주행모드", "주행모드", "주행모드", "주행모드",
				"주행모드", "주행모드" };

		// Generate subtitle
		subtitle = new String[] { "우깜빡이", "좌깜빡이", "브레이크", "후진", "비상등", "추가 1",
				"추가 2", "추가 3" };

		// Generate icon
		// icon = new int[] { R.drawable.action_about,
		// R.drawable.action_settings,
		// R.drawable.collections_cloud };

		// Pass results to NavListAdapter Class
		adapter = new NavListAdapter(this, title, subtitle);

		// Hide the ActionBar Title
		getActionBar().setDisplayShowTitleEnabled(true);

		// Create the Navigation List in your ActionBar
		getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

		// Listen to navigation list clicks
		OnNavigationListener navlistener = new OnNavigationListener() {

			@Override
			public boolean onNavigationItemSelected(int position, long itemId) {
				// FragmentTransaction ft = getSupportFragmentManager()
				// .beginTransaction();
				// Locate Position
				switch (position) {
				case 0:
					// try {
					// Intent i = new Intent(FirstActivity.this,
					// MainActivity.class);
					// startActivity(i);
					// } catch (ActivityNotFoundException e) {
					// e.printStackTrace();
					// }
					break;
				case 1:
					try {
						Intent i = new Intent(FirstActivity.this,
								MainActivity.class);
						overridePendingTransition(0, 0);
						i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
						finish();

						overridePendingTransition(0, 0);
						startActivity(i);
					} catch (ActivityNotFoundException e) {
						e.printStackTrace();
					}
					tog++;
					SharedPreferences preferences1 = PreferenceManager
							.getDefaultSharedPreferences(getApplicationContext());
					SharedPreferences.Editor editor = preferences1.edit();
					editor.putInt("tog", tog);
					editor.apply();
					System.out.println("TOG" + tog);
					break;
				case 2:
					try {
						Intent i1 = new Intent(FirstActivity.this,
								SecondActivity.class);
						overridePendingTransition(0, 0);
						i1.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
						finish();

						overridePendingTransition(0, 0);
						startActivity(i1);
					} catch (ActivityNotFoundException e) {
						e.printStackTrace();
					}
					tog++;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getApplicationContext());
					SharedPreferences.Editor editor2 = preferences2.edit();
					editor2.putInt("tog", tog);
					editor2.apply();
					System.out.println("TOG" + tog);
					break;
				case 3:
					try {
						Intent i2 = new Intent(FirstActivity.this,
								ThirdActivity.class);
						overridePendingTransition(0, 0);
						i2.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
						finish();

						overridePendingTransition(0, 0);
						startActivity(i2);
					} catch (ActivityNotFoundException e) {
						e.printStackTrace();
					}
					tog++;
					SharedPreferences preferences3 = PreferenceManager
							.getDefaultSharedPreferences(getApplicationContext());
					SharedPreferences.Editor editor3 = preferences3.edit();
					editor3.putInt("tog", tog);
					editor3.apply();
					System.out.println("TOG" + tog);
					break;
				case 4:
					try {
						Intent i3 = new Intent(FirstActivity.this,
								ForthActivity.class);
						overridePendingTransition(0, 0);
						i3.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
						finish();

						overridePendingTransition(0, 0);
						startActivity(i3);
					} catch (ActivityNotFoundException e) {
						e.printStackTrace();
					}
					tog++;
					SharedPreferences preferences4 = PreferenceManager
							.getDefaultSharedPreferences(getApplicationContext());
					SharedPreferences.Editor editor4 = preferences4.edit();
					editor4.putInt("tog", tog);
					editor4.apply();
					System.out.println("TOG" + tog);
					break;
				case 5:
					try {
						Intent i4 = new Intent(FirstActivity.this,
								FifthActivity.class);
						overridePendingTransition(0, 0);
						i4.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
						finish();

						overridePendingTransition(0, 0);
						startActivity(i4);
					} catch (ActivityNotFoundException e) {
						e.printStackTrace();
					}
					tog++;
					SharedPreferences preferences5 = PreferenceManager
							.getDefaultSharedPreferences(getApplicationContext());
					SharedPreferences.Editor editor5 = preferences5.edit();
					editor5.putInt("tog", tog);
					editor5.apply();
					System.out.println("TOG" + tog);
					break;
				case 6:
					try {
						Intent i5 = new Intent(FirstActivity.this,
								SixthActivity.class);
						overridePendingTransition(0, 0);
						i5.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
						finish();

						overridePendingTransition(0, 0);
						startActivity(i5);
					} catch (ActivityNotFoundException e) {
						e.printStackTrace();
					}
					tog++;
					SharedPreferences preferences6 = PreferenceManager
							.getDefaultSharedPreferences(getApplicationContext());
					SharedPreferences.Editor editor6 = preferences6.edit();
					editor6.putInt("tog", tog);
					editor6.apply();
					System.out.println("TOG" + tog);
					break;
				case 7:
					try {
						Intent i6 = new Intent(FirstActivity.this,
								SeventhActivity.class);
						overridePendingTransition(0, 0);
						i6.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
						finish();

						overridePendingTransition(0, 0);
						startActivity(i6);
					} catch (ActivityNotFoundException e) {
						e.printStackTrace();
					}
					tog++;
					SharedPreferences preferences7 = PreferenceManager
							.getDefaultSharedPreferences(getApplicationContext());
					SharedPreferences.Editor editor7 = preferences7.edit();
					editor7.putInt("tog", tog);
					editor7.apply();
					System.out.println("TOG" + tog);
					break;
				}
				// ft.commit();
				return false;
			}

		};
		// Set the NavListAdapter into the ActionBar Navigation
		getActionBar().setListNavigationCallbacks(adapter, navlistener);

		mHorizontalScroll = (HorizontalScrollView) findViewById(R.id.scroller);

		cursor = adapter1.queryName2();
		// cursor.moveToFirst();
		ArrayList<String> names = new ArrayList<String>();
		if (cursor != null) {
			if (cursor.moveToFirst()) {
				do {
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE211)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE212)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE213)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE214)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE215)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE216)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE217)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE218)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE221)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE222)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE223)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE224)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE225)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE226)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE227)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE228)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE231)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE232)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE233)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE234)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE235)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE236)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE237)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE238)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE241)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE242)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE243)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE244)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE245)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE246)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE247)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE248)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE251)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE252)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE253)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE254)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE255)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE256)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE257)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE258)));
				} while (cursor.moveToNext());
			}
		}

		List<Integer> newList = new ArrayList<Integer>(names.size());
		for (String myInt : names) {
			newList.add(Integer.valueOf(myInt));
		}

		int[] ret = new int[newList.size()];
		Iterator<Integer> iterator = newList.iterator();
		for (int i = 0; i < ret.length; i++) {
			ret[i] = iterator.next().intValue();
			System.out.println("square2" + ret[i]);
		}
		cursor.close();
		// cursor = adapter1.queryAll2(rowId);
		// if (cursor.moveToFirst()) {
		// rowId = cursor.getInt(cursor.getColumnIndex(helper1.KEY_ID2));
		// }

		// 1st
		// square------------------------------------------------------------------------------
		// ----------------------------------------------------------------------------------------
		sharedPrefs1 = PreferenceManager.getDefaultSharedPreferences(this);
		System.out.println("LOCK" + sharedPrefs1.getBoolean("s2locked1", true));
		fb1 = (Button) findViewById(R.id.button1);
		if (sharedPrefs1.getBoolean("s2locked1", true) == true) {
			fb1.setBackgroundResource(R.drawable.not_pressed);
			Log.e("###", "222");
		} else {
			fb1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				fb1.post(new Runnable() {
					@Override
					public void run() {
						fb1.performClick();
					}
				});
			}
		}
		fb1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {

				if (!isPressed) {
					fb1.setBackgroundResource(R.drawable.not_pressed);
					fr1 = 0;
					sharedPrefs1.edit().putBoolean("s2locked1", true).commit();
					System.out.println("lock to true");
					// System.out.println("true" + fr1);
					Log.e("###", "444");

				} else {
					fb1.setBackgroundResource(R.drawable.pressed);
					fr1 = 128;
					// System.out.println("false" + fr1);
					sharedPrefs1.edit().putBoolean("s2locked1", false).commit();
					System.out.println("lock to false");
					Log.e("###", "555");
				}
				isPressed = !isPressed;
			}
		});

		sharedPrefs2 = PreferenceManager.getDefaultSharedPreferences(this);
		fb2 = (Button) findViewById(R.id.button2);
		if (sharedPrefs2.getBoolean("s2locked2", true)) {
			fb2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			fb2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				fb2.post(new Runnable() {
					@Override
					public void run() {
						fb2.performClick();
					}
				});
			}
		}
		fb2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					fb2.setBackgroundResource(R.drawable.not_pressed);
					fr2 = 0;
					sharedPrefs2.edit().putBoolean("s2locked2", true).commit();
				} else {
					fb2.setBackgroundResource(R.drawable.pressed);
					fr2 = 64;
					sharedPrefs2.edit().putBoolean("s2locked2", false).commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs3 = PreferenceManager.getDefaultSharedPreferences(this);
		fb3 = (Button) findViewById(R.id.button3);
		if (sharedPrefs3.getBoolean("s2locked3", true)) {
			fb3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			fb3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				fb3.post(new Runnable() {
					@Override
					public void run() {
						fb3.performClick();
					}
				});
			}
		}
		fb3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					fb3.setBackgroundResource(R.drawable.not_pressed);
					fr3 = 0;
					sharedPrefs3.edit().putBoolean("s2locked3", true).commit();
				} else {
					fb3.setBackgroundResource(R.drawable.pressed);
					fr3 = 32;
					sharedPrefs3.edit().putBoolean("s2locked3", false).commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs4 = PreferenceManager.getDefaultSharedPreferences(this);
		fb4 = (Button) findViewById(R.id.button4);
		if (sharedPrefs4.getBoolean("s2locked4", true)) {
			fb4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			fb4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				fb4.post(new Runnable() {
					@Override
					public void run() {
						fb4.performClick();
					}
				});
			}
		}
		fb4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					fb4.setBackgroundResource(R.drawable.not_pressed);
					fr4 = 0;
					sharedPrefs4.edit().putBoolean("s2locked4", true).commit();
				} else {
					fb4.setBackgroundResource(R.drawable.pressed);
					fr4 = 16;
					sharedPrefs4.edit().putBoolean("s2locked4", false).commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs5 = PreferenceManager.getDefaultSharedPreferences(this);
		fb5 = (Button) findViewById(R.id.button5);
		if (sharedPrefs5.getBoolean("s2locked5", true)) {
			fb5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			fb5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				fb5.post(new Runnable() {
					@Override
					public void run() {
						fb5.performClick();
					}
				});
			}
		}
		fb5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					fb5.setBackgroundResource(R.drawable.not_pressed);
					fr5 = 0;
					sharedPrefs5.edit().putBoolean("s2locked5", true).commit();
				} else {
					fb5.setBackgroundResource(R.drawable.pressed);
					fr5 = 8;
					sharedPrefs5.edit().putBoolean("s2locked5", false).commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs6 = PreferenceManager.getDefaultSharedPreferences(this);
		fb6 = (Button) findViewById(R.id.button6);
		if (sharedPrefs6.getBoolean("s2locked6", true)) {
			fb6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			fb6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				fb6.post(new Runnable() {
					@Override
					public void run() {
						fb6.performClick();
					}
				});
			}
		}
		fb6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					fb6.setBackgroundResource(R.drawable.not_pressed);
					fr6 = 0;
					sharedPrefs6.edit().putBoolean("s2locked6", true).commit();
				} else {
					fb6.setBackgroundResource(R.drawable.pressed);
					fr6 = 4;
					sharedPrefs6.edit().putBoolean("s2locked6", false).commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs7 = PreferenceManager.getDefaultSharedPreferences(this);
		fb7 = (Button) findViewById(R.id.button7);
		if (sharedPrefs7.getBoolean("s2locked7", true)) {
			fb7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			fb7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				fb7.post(new Runnable() {
					@Override
					public void run() {
						fb7.performClick();
					}
				});
			}
		}
		fb7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					fb7.setBackgroundResource(R.drawable.not_pressed);
					fr7 = 0;
					sharedPrefs7.edit().putBoolean("s2locked7", true).commit();
				} else {
					fb7.setBackgroundResource(R.drawable.pressed);
					fr7 = 2;
					sharedPrefs7.edit().putBoolean("s2locked7", false).commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs8 = PreferenceManager.getDefaultSharedPreferences(this);
		fb8 = (Button) findViewById(R.id.button8);
		if (sharedPrefs8.getBoolean("s2locked8", true)) {
			fb8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			fb8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				fb8.post(new Runnable() {
					@Override
					public void run() {
						fb8.performClick();
					}
				});
			}
		}
		fb8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					fb8.setBackgroundResource(R.drawable.not_pressed);
					fr8 = 0;
					sharedPrefs8.edit().putBoolean("s2locked8", true).commit();
				} else {
					fb8.setBackgroundResource(R.drawable.pressed);
					fr8 = 1;
					sharedPrefs8.edit().putBoolean("s2locked8", false).commit();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------

		sharedPrefs9 = PreferenceManager.getDefaultSharedPreferences(this);
		sb1 = (Button) findViewById(R.id.sbutton1);
		if (sharedPrefs9.getBoolean("s2locked9", true)) {
			sb1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			sb1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				sb1.post(new Runnable() {
					@Override
					public void run() {
						sb1.performClick();
					}
				});
			}
		}
		sb1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					sb1.setBackgroundResource(R.drawable.not_pressed);
					sr1 = 0;
					sharedPrefs9.edit().putBoolean("s2locked9", true).commit();
				} else {
					sb1.setBackgroundResource(R.drawable.pressed);
					sr1 = 128;
					sharedPrefs9.edit().putBoolean("s2locked9", false).commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs10 = PreferenceManager.getDefaultSharedPreferences(this);
		sb2 = (Button) findViewById(R.id.sbutton2);
		if (sharedPrefs10.getBoolean("s2locked10", true)) {
			sb2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			sb2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				sb2.post(new Runnable() {
					@Override
					public void run() {
						sb2.performClick();
					}
				});
			}
		}
		sb2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					sb2.setBackgroundResource(R.drawable.not_pressed);
					sr2 = 0;
					sharedPrefs10.edit().putBoolean("s2locked10", true)
							.commit();
				} else {
					sb2.setBackgroundResource(R.drawable.pressed);
					sr2 = 64;
					sharedPrefs10.edit().putBoolean("s2locked10", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs11 = PreferenceManager.getDefaultSharedPreferences(this);
		sb3 = (Button) findViewById(R.id.sbutton3);
		if (sharedPrefs11.getBoolean("s2locked11", true)) {
			sb3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			sb3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				sb3.post(new Runnable() {
					@Override
					public void run() {
						sb3.performClick();
					}
				});
			}
		}
		sb3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					sb3.setBackgroundResource(R.drawable.not_pressed);
					sr3 = 0;
					sharedPrefs11.edit().putBoolean("s2locked11", true)
							.commit();
				} else {
					sb3.setBackgroundResource(R.drawable.pressed);
					sr3 = 32;
					sharedPrefs11.edit().putBoolean("s2locked11", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs12 = PreferenceManager.getDefaultSharedPreferences(this);
		sb4 = (Button) findViewById(R.id.sbutton4);
		if (sharedPrefs12.getBoolean("s2locked12", true)) {
			sb4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			sb4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				sb4.post(new Runnable() {
					@Override
					public void run() {
						sb4.performClick();
					}
				});
			}
		}
		sb4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					sb4.setBackgroundResource(R.drawable.not_pressed);
					sr4 = 0;
					sharedPrefs12.edit().putBoolean("s2locked12", true)
							.commit();
				} else {
					sb4.setBackgroundResource(R.drawable.pressed);
					sr4 = 16;
					sharedPrefs12.edit().putBoolean("s2locked12", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs13 = PreferenceManager.getDefaultSharedPreferences(this);
		sb5 = (Button) findViewById(R.id.sbutton5);
		if (sharedPrefs13.getBoolean("s2locked13", true)) {
			sb5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			sb5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				sb5.post(new Runnable() {
					@Override
					public void run() {
						sb5.performClick();
					}
				});
			}
		}
		sb5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					sb5.setBackgroundResource(R.drawable.not_pressed);
					sr5 = 0;
					sharedPrefs13.edit().putBoolean("s2locked13", true)
							.commit();
				} else {
					sb5.setBackgroundResource(R.drawable.pressed);
					sr5 = 8;
					sharedPrefs13.edit().putBoolean("s2locked13", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs14 = PreferenceManager.getDefaultSharedPreferences(this);
		sb6 = (Button) findViewById(R.id.sbutton6);
		if (sharedPrefs14.getBoolean("s2locked14", true)) {
			sb6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			sb6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				sb6.post(new Runnable() {
					@Override
					public void run() {
						sb6.performClick();
					}
				});
			}
		}
		sb6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					sb6.setBackgroundResource(R.drawable.not_pressed);
					sr6 = 0;
					sharedPrefs14.edit().putBoolean("s2locked14", true)
							.commit();
				} else {
					sb6.setBackgroundResource(R.drawable.pressed);
					sr6 = 4;
					sharedPrefs14.edit().putBoolean("s2locked14", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs15 = PreferenceManager.getDefaultSharedPreferences(this);
		sb7 = (Button) findViewById(R.id.sbutton7);
		if (sharedPrefs15.getBoolean("s2locked15", true)) {
			sb7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			sb7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				sb7.post(new Runnable() {
					@Override
					public void run() {
						sb7.performClick();
					}
				});
			}
		}
		sb7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					sb7.setBackgroundResource(R.drawable.not_pressed);
					sr7 = 0;
					sharedPrefs15.edit().putBoolean("s2locked15", true)
							.commit();
				} else {
					sb7.setBackgroundResource(R.drawable.pressed);
					sr7 = 2;
					sharedPrefs15.edit().putBoolean("s2locked15", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs16 = PreferenceManager.getDefaultSharedPreferences(this);
		sb8 = (Button) findViewById(R.id.sbutton8);
		if (sharedPrefs16.getBoolean("s2locked16", true)) {
			sb8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			sb8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				sb8.post(new Runnable() {
					@Override
					public void run() {
						sb8.performClick();
					}
				});
			}
		}
		sb8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					sb8.setBackgroundResource(R.drawable.not_pressed);
					sr8 = 0;
					sharedPrefs16.edit().putBoolean("s2locked16", true)
							.commit();
				} else {
					sb8.setBackgroundResource(R.drawable.pressed);
					sr8 = 1;
					sharedPrefs16.edit().putBoolean("s2locked16", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// ------------------------------------------------------------------------------------

		sharedPrefs17 = PreferenceManager.getDefaultSharedPreferences(this);
		tb1 = (Button) findViewById(R.id.tbutton1);
		if (sharedPrefs17.getBoolean("s2locked17", true)) {
			tb1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			tb1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				tb1.post(new Runnable() {
					@Override
					public void run() {
						tb1.performClick();
					}
				});
			}
		}
		tb1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					tb1.setBackgroundResource(R.drawable.not_pressed);
					tr1 = 0;
					sharedPrefs17.edit().putBoolean("s2locked17", true)
							.commit();
				} else {
					tb1.setBackgroundResource(R.drawable.pressed);
					tr1 = 128;
					sharedPrefs17.edit().putBoolean("s2locked17", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs18 = PreferenceManager.getDefaultSharedPreferences(this);
		tb2 = (Button) findViewById(R.id.tbutton2);
		if (sharedPrefs18.getBoolean("s2locked18", true)) {
			tb2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			tb2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				tb2.post(new Runnable() {
					@Override
					public void run() {
						tb2.performClick();
					}
				});
			}
		}
		tb2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					tb2.setBackgroundResource(R.drawable.not_pressed);
					tr2 = 0;
					sharedPrefs18.edit().putBoolean("s2locked18", true)
							.commit();
				} else {
					tb2.setBackgroundResource(R.drawable.pressed);
					tr2 = 64;
					sharedPrefs18.edit().putBoolean("s2locked18", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs19 = PreferenceManager.getDefaultSharedPreferences(this);
		tb3 = (Button) findViewById(R.id.tbutton3);
		if (sharedPrefs19.getBoolean("s2locked19", true)) {
			tb3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			tb3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				tb3.post(new Runnable() {
					@Override
					public void run() {
						tb3.performClick();
					}
				});
			}
		}
		tb3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					tb3.setBackgroundResource(R.drawable.not_pressed);
					tr3 = 0;
					sharedPrefs19.edit().putBoolean("s2locked19", true)
							.commit();
				} else {
					tb3.setBackgroundResource(R.drawable.pressed);
					tr3 = 32;
					sharedPrefs19.edit().putBoolean("s2locked19", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs20 = PreferenceManager.getDefaultSharedPreferences(this);
		tb4 = (Button) findViewById(R.id.tbutton4);
		if (sharedPrefs20.getBoolean("s2locked20", true)) {
			tb4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			tb4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				tb4.post(new Runnable() {
					@Override
					public void run() {
						tb4.performClick();
					}
				});
			}
		}
		tb4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					tb4.setBackgroundResource(R.drawable.not_pressed);
					tr4 = 0;
					sharedPrefs20.edit().putBoolean("s2locked20", true)
							.commit();
				} else {
					tb4.setBackgroundResource(R.drawable.pressed);
					tr4 = 16;
					sharedPrefs20.edit().putBoolean("s2locked20", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs21 = PreferenceManager.getDefaultSharedPreferences(this);
		tb5 = (Button) findViewById(R.id.tbutton5);
		if (sharedPrefs21.getBoolean("s2locked21", true)) {
			tb5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			tb5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				tb5.post(new Runnable() {
					@Override
					public void run() {
						tb5.performClick();
					}
				});
			}
		}
		tb5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					tb5.setBackgroundResource(R.drawable.not_pressed);
					tr5 = 0;
					sharedPrefs21.edit().putBoolean("s2locked21", true)
							.commit();
				} else {
					tb5.setBackgroundResource(R.drawable.pressed);
					tr5 = 8;
					sharedPrefs21.edit().putBoolean("s2locked21", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs22 = PreferenceManager.getDefaultSharedPreferences(this);
		tb6 = (Button) findViewById(R.id.tbutton6);
		if (sharedPrefs22.getBoolean("s2locked22", true)) {
			tb6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			tb6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				tb6.post(new Runnable() {
					@Override
					public void run() {
						tb6.performClick();
					}
				});
			}
		}
		tb6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					tb6.setBackgroundResource(R.drawable.not_pressed);
					tr6 = 0;
					sharedPrefs22.edit().putBoolean("s2locked22", true)
							.commit();
				} else {
					tb6.setBackgroundResource(R.drawable.pressed);
					tr6 = 4;
					sharedPrefs22.edit().putBoolean("s2locked22", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs23 = PreferenceManager.getDefaultSharedPreferences(this);
		tb7 = (Button) findViewById(R.id.tbutton7);
		if (sharedPrefs23.getBoolean("s2locked23", true)) {
			tb7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			tb7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				tb7.post(new Runnable() {
					@Override
					public void run() {
						tb7.performClick();
					}
				});
			}
		}
		tb7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					tb7.setBackgroundResource(R.drawable.not_pressed);
					tr7 = 0;
					sharedPrefs23.edit().putBoolean("s2locked23", true)
							.commit();
				} else {
					tb7.setBackgroundResource(R.drawable.pressed);
					tr7 = 2;
					sharedPrefs23.edit().putBoolean("s2locked23", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs24 = PreferenceManager.getDefaultSharedPreferences(this);
		tb8 = (Button) findViewById(R.id.tbutton8);
		if (sharedPrefs24.getBoolean("s2locked24", true)) {
			tb8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			tb8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				tb8.post(new Runnable() {
					@Override
					public void run() {
						tb8.performClick();
					}
				});
			}
		}
		tb8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					tb8.setBackgroundResource(R.drawable.not_pressed);
					tr8 = 0;
					sharedPrefs24.edit().putBoolean("s2locked24", true)
							.commit();
				} else {
					tb8.setBackgroundResource(R.drawable.pressed);
					tr8 = 1;
					sharedPrefs24.edit().putBoolean("s2locked24", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// ------------------------------------------------------------------------------------

		sharedPrefs25 = PreferenceManager.getDefaultSharedPreferences(this);
		fob1 = (Button) findViewById(R.id.fobutton1);
		if (sharedPrefs25.getBoolean("s2locked25", true)) {
			fob1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			fob1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				fob1.post(new Runnable() {
					@Override
					public void run() {
						fob1.performClick();
					}
				});
			}
		}
		fob1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					fob1.setBackgroundResource(R.drawable.not_pressed);
					for1 = 0;
					sharedPrefs25.edit().putBoolean("s2locked25", true)
							.commit();
				} else {
					fob1.setBackgroundResource(R.drawable.pressed);
					for1 = 128;
					sharedPrefs25.edit().putBoolean("s2locked25", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs26 = PreferenceManager.getDefaultSharedPreferences(this);
		fob2 = (Button) findViewById(R.id.fobutton2);
		if (sharedPrefs26.getBoolean("s2locked26", true)) {
			fob2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			fob2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				fob2.post(new Runnable() {
					@Override
					public void run() {
						fob2.performClick();
					}
				});
			}
		}
		fob2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					fob2.setBackgroundResource(R.drawable.not_pressed);
					for2 = 0;
					sharedPrefs26.edit().putBoolean("s2locked26", true)
							.commit();
				} else {
					fob2.setBackgroundResource(R.drawable.pressed);
					for2 = 64;
					sharedPrefs26.edit().putBoolean("s2locked26", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs27 = PreferenceManager.getDefaultSharedPreferences(this);
		fob3 = (Button) findViewById(R.id.fobutton3);
		if (sharedPrefs27.getBoolean("s2locked27", true)) {
			fob3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			fob3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				fob3.post(new Runnable() {
					@Override
					public void run() {
						fob3.performClick();
					}
				});
			}
		}
		fob3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					fob3.setBackgroundResource(R.drawable.not_pressed);
					for3 = 0;
					sharedPrefs27.edit().putBoolean("s2locked27", true)
							.commit();
				} else {
					fob3.setBackgroundResource(R.drawable.pressed);
					for3 = 32;
					sharedPrefs27.edit().putBoolean("s2locked27", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs28 = PreferenceManager.getDefaultSharedPreferences(this);
		fob4 = (Button) findViewById(R.id.fobutton4);
		if (sharedPrefs28.getBoolean("s2locked28", true)) {
			fob4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			fob4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				fob4.post(new Runnable() {
					@Override
					public void run() {
						fob4.performClick();
					}
				});
			}
		}
		fob4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					fob4.setBackgroundResource(R.drawable.not_pressed);
					for4 = 0;
					sharedPrefs28.edit().putBoolean("s2locked28", true)
							.commit();
				} else {
					fob4.setBackgroundResource(R.drawable.pressed);
					for4 = 16;
					sharedPrefs28.edit().putBoolean("s2locked28", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs29 = PreferenceManager.getDefaultSharedPreferences(this);
		fob5 = (Button) findViewById(R.id.fobutton5);
		if (sharedPrefs29.getBoolean("s2locked29", true)) {
			fob5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			fob5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				fob5.post(new Runnable() {
					@Override
					public void run() {
						fob5.performClick();
					}
				});
			}
		}
		fob5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					fob5.setBackgroundResource(R.drawable.not_pressed);
					for5 = 0;
					sharedPrefs29.edit().putBoolean("s2locked29", true)
							.commit();
				} else {
					fob5.setBackgroundResource(R.drawable.pressed);
					for5 = 8;
					sharedPrefs29.edit().putBoolean("s2locked29", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs30 = PreferenceManager.getDefaultSharedPreferences(this);
		fob6 = (Button) findViewById(R.id.fobutton6);
		if (sharedPrefs30.getBoolean("s2locked30", true)) {
			fob6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			fob6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				fob6.post(new Runnable() {
					@Override
					public void run() {
						fob6.performClick();
					}
				});
			}
		}
		fob6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					fob6.setBackgroundResource(R.drawable.not_pressed);
					for6 = 0;
					sharedPrefs30.edit().putBoolean("s2locked30", true)
							.commit();
				} else {
					fob6.setBackgroundResource(R.drawable.pressed);
					for6 = 4;
					sharedPrefs30.edit().putBoolean("s2locked30", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs31 = PreferenceManager.getDefaultSharedPreferences(this);
		fob7 = (Button) findViewById(R.id.fobutton7);
		if (sharedPrefs31.getBoolean("s2locked31", true)) {
			fob7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			fob7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				fob7.post(new Runnable() {
					@Override
					public void run() {
						fob7.performClick();
					}
				});
			}
		}
		fob7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					fob7.setBackgroundResource(R.drawable.not_pressed);
					for7 = 0;
					sharedPrefs31.edit().putBoolean("s2locked31", true)
							.commit();
				} else {
					fob7.setBackgroundResource(R.drawable.pressed);
					for7 = 2;
					sharedPrefs31.edit().putBoolean("s2locked31", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs32 = PreferenceManager.getDefaultSharedPreferences(this);
		fob8 = (Button) findViewById(R.id.fobutton8);
		if (sharedPrefs32.getBoolean("s2locked32", true)) {
			fob8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			fob8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				fob8.post(new Runnable() {
					@Override
					public void run() {
						fob8.performClick();
					}
				});
			}
		}
		fob8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					fob8.setBackgroundResource(R.drawable.not_pressed);
					for8 = 0;
					sharedPrefs32.edit().putBoolean("s2locked32", true)
							.commit();
				} else {
					fob8.setBackgroundResource(R.drawable.pressed);
					for8 = 1;
					sharedPrefs32.edit().putBoolean("s2locked32", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// ------------------------------------------------------------------------------------

		sharedPrefs33 = PreferenceManager.getDefaultSharedPreferences(this);
		fib1 = (Button) findViewById(R.id.fibutton1);
		if (sharedPrefs33.getBoolean("s2locked33", true)) {
			fib1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			fib1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				fib1.post(new Runnable() {
					@Override
					public void run() {
						fib1.performClick();
					}
				});
			}
		}
		fib1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					fib1.setBackgroundResource(R.drawable.not_pressed);
					fir1 = 0;
					sharedPrefs33.edit().putBoolean("s2locked33", true)
							.commit();
				} else {
					fib1.setBackgroundResource(R.drawable.pressed);
					fir1 = 128;
					sharedPrefs33.edit().putBoolean("s2locked33", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs34 = PreferenceManager.getDefaultSharedPreferences(this);
		fib2 = (Button) findViewById(R.id.fibutton2);
		if (sharedPrefs34.getBoolean("s2locked34", true)) {
			fib2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			fib2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				fib2.post(new Runnable() {
					@Override
					public void run() {
						fib2.performClick();
					}
				});
			}
		}
		fib2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					fib2.setBackgroundResource(R.drawable.not_pressed);
					fir2 = 0;
					sharedPrefs34.edit().putBoolean("s2locked34", true)
							.commit();
				} else {
					fib2.setBackgroundResource(R.drawable.pressed);
					fir2 = 64;
					sharedPrefs34.edit().putBoolean("s2locked34", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs35 = PreferenceManager.getDefaultSharedPreferences(this);
		fib3 = (Button) findViewById(R.id.fibutton3);
		if (sharedPrefs35.getBoolean("s2locked35", true)) {
			fib3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			fib3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				fib3.post(new Runnable() {
					@Override
					public void run() {
						fib3.performClick();
					}
				});
			}
		}
		fib3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					fib3.setBackgroundResource(R.drawable.not_pressed);
					fir3 = 0;
					sharedPrefs35.edit().putBoolean("s2locked35", true)
							.commit();
				} else {
					fib3.setBackgroundResource(R.drawable.pressed);
					fir3 = 32;
					sharedPrefs35.edit().putBoolean("s2locked35", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs36 = PreferenceManager.getDefaultSharedPreferences(this);
		fib4 = (Button) findViewById(R.id.fibutton4);
		if (sharedPrefs36.getBoolean("s2locked36", true)) {
			fib4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			fib4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				fib4.post(new Runnable() {
					@Override
					public void run() {
						fib4.performClick();
					}
				});
			}
		}
		fib4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					fib4.setBackgroundResource(R.drawable.not_pressed);
					fir4 = 0;
					sharedPrefs36.edit().putBoolean("s2locked36", true)
							.commit();
				} else {
					fib4.setBackgroundResource(R.drawable.pressed);
					fir4 = 16;
					sharedPrefs36.edit().putBoolean("s2locked36", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs37 = PreferenceManager.getDefaultSharedPreferences(this);
		fib5 = (Button) findViewById(R.id.fibutton5);
		if (sharedPrefs37.getBoolean("s2locked37", true)) {
			fib5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			fib5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				fib5.post(new Runnable() {
					@Override
					public void run() {
						fib5.performClick();
					}
				});
			}
		}
		fib5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					fib5.setBackgroundResource(R.drawable.not_pressed);
					fir5 = 0;
					sharedPrefs37.edit().putBoolean("s2locked37", true)
							.commit();
				} else {
					fib5.setBackgroundResource(R.drawable.pressed);
					fir5 = 8;
					sharedPrefs37.edit().putBoolean("s2locked37", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs38 = PreferenceManager.getDefaultSharedPreferences(this);
		fib6 = (Button) findViewById(R.id.fibutton6);
		if (sharedPrefs38.getBoolean("s2locked38", true)) {
			fib6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			fib6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				fib6.post(new Runnable() {
					@Override
					public void run() {
						fib6.performClick();
					}
				});
			}
		}
		fib6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					fib6.setBackgroundResource(R.drawable.not_pressed);
					fir6 = 0;
					sharedPrefs38.edit().putBoolean("s2locked38", true)
							.commit();
				} else {
					fib6.setBackgroundResource(R.drawable.pressed);
					fir6 = 4;
					sharedPrefs38.edit().putBoolean("s2locked38", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs39 = PreferenceManager.getDefaultSharedPreferences(this);
		fib7 = (Button) findViewById(R.id.fibutton7);
		if (sharedPrefs39.getBoolean("s2locked39", true)) {
			fib7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			fib7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				fib7.post(new Runnable() {
					@Override
					public void run() {
						fib7.performClick();
					}
				});
			}
		}
		fib7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					fib7.setBackgroundResource(R.drawable.not_pressed);
					fir7 = 0;
					sharedPrefs39.edit().putBoolean("s2locked39", true)
							.commit();
				} else {
					fib7.setBackgroundResource(R.drawable.pressed);
					fir7 = 2;
					sharedPrefs39.edit().putBoolean("s2locked39", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs40 = PreferenceManager.getDefaultSharedPreferences(this);
		fib8 = (Button) findViewById(R.id.fibutton8);
		if (sharedPrefs40.getBoolean("s2locked40", true)) {
			fib8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			fib8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				fib8.post(new Runnable() {
					@Override
					public void run() {
						fib8.performClick();
					}
				});
			}
		}
		fib8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					fib8.setBackgroundResource(R.drawable.not_pressed);
					fir8 = 0;
					sharedPrefs40.edit().putBoolean("s2locked40", true)
							.commit();
				} else {
					fib8.setBackgroundResource(R.drawable.pressed);
					fir8 = 1;
					sharedPrefs40.edit().putBoolean("s2locked40", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------

		sharedPrefs41 = PreferenceManager.getDefaultSharedPreferences(this);
		sib1 = (Button) findViewById(R.id.sibutton1);
		if (sharedPrefs41.getBoolean("s2locked41", true)) {
			sib1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			sib1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				sib1.post(new Runnable() {
					@Override
					public void run() {
						sib1.performClick();
					}
				});
			}
		}
		sib1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					sib1.setBackgroundResource(R.drawable.not_pressed);
					sir1 = 0;
					sharedPrefs41.edit().putBoolean("s2locked41", true)
							.commit();
				} else {
					sib1.setBackgroundResource(R.drawable.pressed);
					sir1 = 128;
					sharedPrefs41.edit().putBoolean("s2locked41", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs42 = PreferenceManager.getDefaultSharedPreferences(this);
		sib2 = (Button) findViewById(R.id.sibutton2);
		if (sharedPrefs42.getBoolean("s2locked42", true)) {
			sib2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			sib2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				sib2.post(new Runnable() {
					@Override
					public void run() {
						sib2.performClick();
					}
				});
			}
		}
		sib2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					sib2.setBackgroundResource(R.drawable.not_pressed);
					sir2 = 0;
					sharedPrefs42.edit().putBoolean("s2locked42", true)
							.commit();
				} else {
					sib2.setBackgroundResource(R.drawable.pressed);
					sir2 = 64;
					sharedPrefs42.edit().putBoolean("s2locked42", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs43 = PreferenceManager.getDefaultSharedPreferences(this);
		sib3 = (Button) findViewById(R.id.sibutton3);
		if (sharedPrefs43.getBoolean("s2locked43", true)) {
			sib3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			sib3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				sib3.post(new Runnable() {
					@Override
					public void run() {
						sib3.performClick();
					}
				});
			}
		}
		sib3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					sib3.setBackgroundResource(R.drawable.not_pressed);
					sir3 = 0;
					sharedPrefs43.edit().putBoolean("s2locked43", true)
							.commit();
				} else {
					sib3.setBackgroundResource(R.drawable.pressed);
					sir3 = 32;
					sharedPrefs43.edit().putBoolean("s2locked43", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs44 = PreferenceManager.getDefaultSharedPreferences(this);
		sib4 = (Button) findViewById(R.id.sibutton4);
		if (sharedPrefs44.getBoolean("s2locked44", true)) {
			sib4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			sib4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				sib4.post(new Runnable() {
					@Override
					public void run() {
						sib4.performClick();
					}
				});
			}
		}
		sib4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					sib4.setBackgroundResource(R.drawable.not_pressed);
					sir4 = 0;
					sharedPrefs44.edit().putBoolean("s2locked44", true)
							.commit();
				} else {
					sib4.setBackgroundResource(R.drawable.pressed);
					sir4 = 16;
					sharedPrefs44.edit().putBoolean("s2locked44", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs45 = PreferenceManager.getDefaultSharedPreferences(this);
		sib5 = (Button) findViewById(R.id.sibutton5);
		if (sharedPrefs45.getBoolean("s2locked45", true)) {
			sib5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			sib5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				sib5.post(new Runnable() {
					@Override
					public void run() {
						sib5.performClick();
					}
				});
			}
		}
		sib5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					sib5.setBackgroundResource(R.drawable.not_pressed);
					sir5 = 0;
					sharedPrefs45.edit().putBoolean("s2locked45", true)
							.commit();
				} else {
					sib5.setBackgroundResource(R.drawable.pressed);
					sir5 = 8;
					sharedPrefs45.edit().putBoolean("s2locked45", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs47 = PreferenceManager.getDefaultSharedPreferences(this);
		sib6 = (Button) findViewById(R.id.sibutton6);
		if (sharedPrefs47.getBoolean("s2locked46", true)) {
			sib6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			sib6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				sib6.post(new Runnable() {
					@Override
					public void run() {
						sib6.performClick();
					}
				});
			}
		}
		sib6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					sib6.setBackgroundResource(R.drawable.not_pressed);
					sir6 = 0;
					sharedPrefs47.edit().putBoolean("s2locked46", true)
							.commit();
				} else {
					sib6.setBackgroundResource(R.drawable.pressed);
					sir6 = 4;
					sharedPrefs47.edit().putBoolean("s2locked46", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs49 = PreferenceManager.getDefaultSharedPreferences(this);
		sib7 = (Button) findViewById(R.id.sibutton7);
		if (sharedPrefs49.getBoolean("s2locked47", true)) {
			sib7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			sib7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				sib7.post(new Runnable() {
					@Override
					public void run() {
						sib7.performClick();
					}
				});
			}
		}
		sib7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					sib7.setBackgroundResource(R.drawable.not_pressed);
					sir7 = 0;
					sharedPrefs49.edit().putBoolean("s2locked47", true)
							.commit();
				} else {
					sib7.setBackgroundResource(R.drawable.pressed);
					sir7 = 2;
					sharedPrefs49.edit().putBoolean("s2locked47", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs50 = PreferenceManager.getDefaultSharedPreferences(this);
		sib8 = (Button) findViewById(R.id.sibutton8);
		if (sharedPrefs50.getBoolean("s2locked48", true)) {
			sib8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			sib8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				sib8.post(new Runnable() {
					@Override
					public void run() {
						sib8.performClick();
					}
				});
			}
		}
		sib8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					sib8.setBackgroundResource(R.drawable.not_pressed);
					sir8 = 0;
					sharedPrefs50.edit().putBoolean("s2locked48", true)
							.commit();
				} else {
					sib8.setBackgroundResource(R.drawable.pressed);
					sir8 = 1;
					sharedPrefs50.edit().putBoolean("s2locked48", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------

		sharedPrefs51 = PreferenceManager.getDefaultSharedPreferences(this);
		seb1 = (Button) findViewById(R.id.sebutton1);
		if (sharedPrefs51.getBoolean("s2locked49", true)) {
			seb1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			seb1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				seb1.post(new Runnable() {
					@Override
					public void run() {
						seb1.performClick();
					}
				});
			}
		}
		seb1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					seb1.setBackgroundResource(R.drawable.not_pressed);
					ser1 = 0;
					sharedPrefs51.edit().putBoolean("s2locked49", true)
							.commit();
				} else {
					seb1.setBackgroundResource(R.drawable.pressed);
					ser1 = 128;
					sharedPrefs51.edit().putBoolean("s2locked49", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs52 = PreferenceManager.getDefaultSharedPreferences(this);
		seb2 = (Button) findViewById(R.id.sebutton2);
		if (sharedPrefs52.getBoolean("s2locked50", true)) {
			seb2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			seb2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				seb2.post(new Runnable() {
					@Override
					public void run() {
						seb2.performClick();
					}
				});
			}
		}
		seb2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					seb2.setBackgroundResource(R.drawable.not_pressed);
					ser2 = 0;
					sharedPrefs52.edit().putBoolean("s2locked50", true)
							.commit();
				} else {
					seb2.setBackgroundResource(R.drawable.pressed);
					ser2 = 64;
					sharedPrefs52.edit().putBoolean("s2locked50", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs53 = PreferenceManager.getDefaultSharedPreferences(this);
		seb3 = (Button) findViewById(R.id.sebutton3);
		if (sharedPrefs53.getBoolean("s2locked51", true)) {
			seb3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			seb3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				seb3.post(new Runnable() {
					@Override
					public void run() {
						seb3.performClick();
					}
				});
			}
		}
		seb3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					seb3.setBackgroundResource(R.drawable.not_pressed);
					ser3 = 0;
					sharedPrefs53.edit().putBoolean("s2locked51", true)
							.commit();
				} else {
					seb3.setBackgroundResource(R.drawable.pressed);
					ser3 = 32;
					sharedPrefs53.edit().putBoolean("s2locked51", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs54 = PreferenceManager.getDefaultSharedPreferences(this);
		seb4 = (Button) findViewById(R.id.sebutton4);
		if (sharedPrefs54.getBoolean("s2locked52", true)) {
			seb4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			seb4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				seb4.post(new Runnable() {
					@Override
					public void run() {
						seb4.performClick();
					}
				});
			}
		}
		seb4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					seb4.setBackgroundResource(R.drawable.not_pressed);
					ser4 = 0;
					sharedPrefs54.edit().putBoolean("s2locked52", true)
							.commit();
				} else {
					seb4.setBackgroundResource(R.drawable.pressed);
					ser4 = 16;
					sharedPrefs54.edit().putBoolean("s2locked52", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs55 = PreferenceManager.getDefaultSharedPreferences(this);
		seb5 = (Button) findViewById(R.id.sebutton5);
		if (sharedPrefs55.getBoolean("s2locked53", true)) {
			seb5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			seb5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				seb5.post(new Runnable() {
					@Override
					public void run() {
						seb5.performClick();
					}
				});
			}
		}
		seb5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					seb5.setBackgroundResource(R.drawable.not_pressed);
					ser5 = 0;
					sharedPrefs55.edit().putBoolean("s2locked53", true)
							.commit();
				} else {
					seb5.setBackgroundResource(R.drawable.pressed);
					ser5 = 8;
					sharedPrefs55.edit().putBoolean("s2locked53", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs56 = PreferenceManager.getDefaultSharedPreferences(this);
		seb6 = (Button) findViewById(R.id.sebutton6);
		if (sharedPrefs56.getBoolean("s2locked54", true)) {
			seb6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			seb6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				seb6.post(new Runnable() {
					@Override
					public void run() {
						seb6.performClick();
					}
				});
			}
		}
		seb6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					seb6.setBackgroundResource(R.drawable.not_pressed);
					ser6 = 0;
					sharedPrefs56.edit().putBoolean("s2locked54", true)
							.commit();
				} else {
					seb6.setBackgroundResource(R.drawable.pressed);
					ser6 = 4;
					sharedPrefs56.edit().putBoolean("s2locked54", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs57 = PreferenceManager.getDefaultSharedPreferences(this);
		seb7 = (Button) findViewById(R.id.sebutton7);
		if (sharedPrefs57.getBoolean("s2locked55", true)) {
			seb7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			seb7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				seb7.post(new Runnable() {
					@Override
					public void run() {
						seb7.performClick();
					}
				});
			}
		}
		seb7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					seb7.setBackgroundResource(R.drawable.not_pressed);
					ser7 = 0;
					sharedPrefs57.edit().putBoolean("s2locked55", true)
							.commit();
				} else {
					seb7.setBackgroundResource(R.drawable.pressed);
					ser7 = 2;
					sharedPrefs57.edit().putBoolean("s2locked55", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs58 = PreferenceManager.getDefaultSharedPreferences(this);
		seb8 = (Button) findViewById(R.id.sebutton8);
		if (sharedPrefs58.getBoolean("s2locked56", true)) {
			seb8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			seb8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				seb8.post(new Runnable() {
					@Override
					public void run() {
						seb8.performClick();
					}
				});
			}
		}
		seb8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					seb8.setBackgroundResource(R.drawable.not_pressed);
					ser8 = 0;
					sharedPrefs58.edit().putBoolean("s2locked56", true)
							.commit();
				} else {
					seb8.setBackgroundResource(R.drawable.pressed);
					ser8 = 1;
					sharedPrefs58.edit().putBoolean("s2locked56", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------

		sharedPrefs59 = PreferenceManager.getDefaultSharedPreferences(this);
		eb1 = (Button) findViewById(R.id.ebutton1);
		if (sharedPrefs59.getBoolean("s2locked57", true)) {
			eb1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			eb1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				eb1.post(new Runnable() {
					@Override
					public void run() {
						eb1.performClick();
					}
				});
			}
		}
		eb1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					eb1.setBackgroundResource(R.drawable.not_pressed);
					er1 = 0;
					sharedPrefs59.edit().putBoolean("s2locked57", true)
							.commit();
				} else {
					eb1.setBackgroundResource(R.drawable.pressed);
					er1 = 128;
					sharedPrefs59.edit().putBoolean("s2locked57", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs60 = PreferenceManager.getDefaultSharedPreferences(this);
		eb2 = (Button) findViewById(R.id.ebutton2);
		if (sharedPrefs60.getBoolean("s2locked58", true)) {
			eb2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			eb2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				eb2.post(new Runnable() {
					@Override
					public void run() {
						eb2.performClick();
					}
				});
			}
		}
		eb2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					eb2.setBackgroundResource(R.drawable.not_pressed);
					er2 = 0;
					sharedPrefs60.edit().putBoolean("s2locked58", true)
							.commit();
				} else {
					eb2.setBackgroundResource(R.drawable.pressed);
					er2 = 64;
					sharedPrefs60.edit().putBoolean("s2locked58", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs61 = PreferenceManager.getDefaultSharedPreferences(this);
		eb3 = (Button) findViewById(R.id.ebutton3);
		if (sharedPrefs61.getBoolean("s2locked59", true)) {
			eb3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			eb3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				eb3.post(new Runnable() {
					@Override
					public void run() {
						eb3.performClick();
					}
				});
			}
		}
		eb3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					eb3.setBackgroundResource(R.drawable.not_pressed);
					er3 = 0;
					sharedPrefs61.edit().putBoolean("s2locked59", true)
							.commit();
				} else {
					eb3.setBackgroundResource(R.drawable.pressed);
					er3 = 32;
					sharedPrefs61.edit().putBoolean("s2locked59", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs62 = PreferenceManager.getDefaultSharedPreferences(this);
		eb4 = (Button) findViewById(R.id.ebutton4);
		if (sharedPrefs62.getBoolean("s2locked60", true)) {
			eb4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			eb4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				eb4.post(new Runnable() {
					@Override
					public void run() {
						eb4.performClick();
					}
				});
			}
		}
		eb4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					eb4.setBackgroundResource(R.drawable.not_pressed);
					er4 = 0;
					sharedPrefs62.edit().putBoolean("s2locked60", true)
							.commit();
				} else {
					eb4.setBackgroundResource(R.drawable.pressed);
					er4 = 16;
					sharedPrefs62.edit().putBoolean("s2locked60", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs63 = PreferenceManager.getDefaultSharedPreferences(this);
		eb5 = (Button) findViewById(R.id.ebutton5);
		if (sharedPrefs63.getBoolean("s2locked61", true)) {
			eb5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			eb5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				eb5.post(new Runnable() {
					@Override
					public void run() {
						eb5.performClick();
					}
				});
			}
		}
		eb5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					eb5.setBackgroundResource(R.drawable.not_pressed);
					er5 = 0;
					sharedPrefs63.edit().putBoolean("s2locked61", true)
							.commit();
				} else {
					eb5.setBackgroundResource(R.drawable.pressed);
					er5 = 8;
					sharedPrefs63.edit().putBoolean("s2locked61", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs64 = PreferenceManager.getDefaultSharedPreferences(this);
		eb6 = (Button) findViewById(R.id.ebutton6);
		if (sharedPrefs64.getBoolean("s2locked62", true)) {
			eb6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			eb6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				eb6.post(new Runnable() {
					@Override
					public void run() {
						eb6.performClick();
					}
				});
			}
		}
		eb6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					eb6.setBackgroundResource(R.drawable.not_pressed);
					er6 = 0;
					sharedPrefs64.edit().putBoolean("s2locked62", true)
							.commit();
				} else {
					eb6.setBackgroundResource(R.drawable.pressed);
					er6 = 4;
					sharedPrefs64.edit().putBoolean("s2locked62", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs65 = PreferenceManager.getDefaultSharedPreferences(this);
		eb7 = (Button) findViewById(R.id.ebutton7);
		if (sharedPrefs65.getBoolean("s2locked63", true)) {
			eb7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			eb7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				eb7.post(new Runnable() {
					@Override
					public void run() {
						eb7.performClick();
					}
				});
			}
		}
		eb7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					eb7.setBackgroundResource(R.drawable.not_pressed);
					er7 = 0;
					sharedPrefs65.edit().putBoolean("s2locked63", true)
							.commit();
				} else {
					eb7.setBackgroundResource(R.drawable.pressed);
					er7 = 2;
					sharedPrefs65.edit().putBoolean("s2locked63", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs66 = PreferenceManager.getDefaultSharedPreferences(this);
		eb8 = (Button) findViewById(R.id.ebutton8);
		if (sharedPrefs66.getBoolean("s2locked64", true)) {
			eb8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			eb8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				eb8.post(new Runnable() {
					@Override
					public void run() {
						eb8.performClick();
					}
				});
			}
		}
		eb8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					eb8.setBackgroundResource(R.drawable.not_pressed);
					er8 = 0;
					sharedPrefs66.edit().putBoolean("s2locked64", true)
							.commit();
				} else {
					eb8.setBackgroundResource(R.drawable.pressed);
					er8 = 1;
					sharedPrefs66.edit().putBoolean("s2locked64", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// 2st
		// square------------------------------------------------------------------------------
		// ----------------------------------------------------------------------------------------
		sharedPrefs46 = PreferenceManager.getDefaultSharedPreferences(this);
		s2fb1 = (Button) findViewById(R.id.s2button1);
		if (sharedPrefs46.getBoolean("s2locked65", true)) {
			s2fb1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2fb1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2fb1.post(new Runnable() {
					@Override
					public void run() {
						s2fb1.performClick();
					}
				});
			}
		}
		s2fb1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {

				if (!isPressed) {
					s2fb1.setBackgroundResource(R.drawable.not_pressed);
					s2fr1 = 0;
					sharedPrefs46.edit().putBoolean("s2locked65", true)
							.commit();
					System.out.println("lock to true");

				} else {
					s2fb1.setBackgroundResource(R.drawable.pressed);
					s2fr1 = 128;
					// fb1.setSelected(true);
					// fb1.setPressed(true);
					sharedPrefs46.edit().putBoolean("s2locked65", false)
							.commit();
					System.out.println("lock to false");
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs48 = PreferenceManager.getDefaultSharedPreferences(this);
		s2fb2 = (Button) findViewById(R.id.s2button2);
		if (sharedPrefs48.getBoolean("s2locked66", true)) {
			s2fb2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2fb2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2fb2.post(new Runnable() {
					@Override
					public void run() {
						s2fb2.performClick();
					}
				});
			}
		}
		s2fb2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2fb2.setBackgroundResource(R.drawable.not_pressed);
					s2fr2 = 0;
					sharedPrefs48.edit().putBoolean("s2locked66", true)
							.commit();
				} else {
					s2fb2.setBackgroundResource(R.drawable.pressed);
					s2fr2 = 64;
					sharedPrefs48.edit().putBoolean("s2locked66", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs67 = PreferenceManager.getDefaultSharedPreferences(this);
		s2fb3 = (Button) findViewById(R.id.s2button3);
		if (sharedPrefs67.getBoolean("s2locked67", true)) {
			s2fb3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2fb3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2fb3.post(new Runnable() {
					@Override
					public void run() {
						s2fb3.performClick();
					}
				});
			}
		}
		s2fb3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2fb3.setBackgroundResource(R.drawable.not_pressed);
					s2fr3 = 0;
					sharedPrefs67.edit().putBoolean("s2locked67", true)
							.commit();
				} else {
					s2fb3.setBackgroundResource(R.drawable.pressed);
					s2fr3 = 32;
					sharedPrefs67.edit().putBoolean("s2locked67", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs68 = PreferenceManager.getDefaultSharedPreferences(this);
		s2fb4 = (Button) findViewById(R.id.s2button4);
		if (sharedPrefs68.getBoolean("s2locked68", true)) {
			s2fb4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2fb4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2fb4.post(new Runnable() {
					@Override
					public void run() {
						s2fb4.performClick();
					}
				});
			}
		}
		s2fb4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2fb4.setBackgroundResource(R.drawable.not_pressed);
					s2fr4 = 0;
					sharedPrefs68.edit().putBoolean("s2locked68", true)
							.commit();
				} else {
					s2fb4.setBackgroundResource(R.drawable.pressed);
					s2fr4 = 16;
					sharedPrefs68.edit().putBoolean("s2locked68", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs69 = PreferenceManager.getDefaultSharedPreferences(this);
		s2fb5 = (Button) findViewById(R.id.s2button5);
		if (sharedPrefs69.getBoolean("s2locked69", true)) {
			s2fb5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2fb5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2fb5.post(new Runnable() {
					@Override
					public void run() {
						s2fb5.performClick();
					}
				});
			}
		}
		s2fb5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2fb5.setBackgroundResource(R.drawable.not_pressed);
					s2fr5 = 0;
					sharedPrefs69.edit().putBoolean("s2locked69", true)
							.commit();
				} else {
					s2fb5.setBackgroundResource(R.drawable.pressed);
					s2fr5 = 8;
					sharedPrefs69.edit().putBoolean("s2locked69", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs70 = PreferenceManager.getDefaultSharedPreferences(this);
		s2fb6 = (Button) findViewById(R.id.s2button6);
		if (sharedPrefs70.getBoolean("s2locked70", true)) {
			s2fb6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2fb6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2fb6.post(new Runnable() {
					@Override
					public void run() {
						s2fb6.performClick();
					}
				});
			}
		}
		s2fb6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2fb6.setBackgroundResource(R.drawable.not_pressed);
					s2fr6 = 0;
					sharedPrefs70.edit().putBoolean("s2locked70", true)
							.commit();
				} else {
					s2fb6.setBackgroundResource(R.drawable.pressed);
					s2fr6 = 4;
					sharedPrefs70.edit().putBoolean("s2locked70", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs71 = PreferenceManager.getDefaultSharedPreferences(this);
		s2fb7 = (Button) findViewById(R.id.s2button7);
		if (sharedPrefs71.getBoolean("s2locked71", true)) {
			s2fb7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2fb7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2fb7.post(new Runnable() {
					@Override
					public void run() {
						s2fb7.performClick();
					}
				});
			}
		}
		s2fb7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2fb7.setBackgroundResource(R.drawable.not_pressed);
					s2fr7 = 0;
					sharedPrefs71.edit().putBoolean("s2locked71", true)
							.commit();
				} else {
					s2fb7.setBackgroundResource(R.drawable.pressed);
					s2fr7 = 2;
					sharedPrefs71.edit().putBoolean("s2locked71", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs72 = PreferenceManager.getDefaultSharedPreferences(this);
		s2fb8 = (Button) findViewById(R.id.s2button8);
		if (sharedPrefs72.getBoolean("s2locked72", true)) {
			s2fb8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2fb8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2fb8.post(new Runnable() {
					@Override
					public void run() {
						s2fb8.performClick();
					}
				});
			}
		}
		s2fb8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2fb8.setBackgroundResource(R.drawable.not_pressed);
					s2fr8 = 0;
					sharedPrefs72.edit().putBoolean("s2locked72", true)
							.commit();
				} else {
					s2fb8.setBackgroundResource(R.drawable.pressed);
					s2fr8 = 1;
					sharedPrefs72.edit().putBoolean("s2locked72", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------

		sharedPrefs73 = PreferenceManager.getDefaultSharedPreferences(this);
		s2sb1 = (Button) findViewById(R.id.s2sbutton1);
		if (sharedPrefs73.getBoolean("s2locked73", true)) {
			s2sb1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2sb1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2sb1.post(new Runnable() {
					@Override
					public void run() {
						s2sb1.performClick();
					}
				});
			}
		}
		s2sb1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2sb1.setBackgroundResource(R.drawable.not_pressed);
					s2sr1 = 0;
					sharedPrefs73.edit().putBoolean("s2locked73", true)
							.commit();
				} else {
					s2sb1.setBackgroundResource(R.drawable.pressed);
					s2sr1 = 128;
					sharedPrefs73.edit().putBoolean("s2locked73", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs74 = PreferenceManager.getDefaultSharedPreferences(this);
		s2sb2 = (Button) findViewById(R.id.s2sbutton2);
		if (sharedPrefs74.getBoolean("s2locked74", true)) {
			s2sb2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2sb2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2sb2.post(new Runnable() {
					@Override
					public void run() {
						s2sb2.performClick();
					}
				});
			}
		}
		s2sb2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2sb2.setBackgroundResource(R.drawable.not_pressed);
					s2sr2 = 0;
					sharedPrefs74.edit().putBoolean("s2locked74", true)
							.commit();
				} else {
					s2sb2.setBackgroundResource(R.drawable.pressed);
					s2sr2 = 64;
					sharedPrefs74.edit().putBoolean("s2locked74", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs75 = PreferenceManager.getDefaultSharedPreferences(this);
		s2sb3 = (Button) findViewById(R.id.s2sbutton3);
		if (sharedPrefs75.getBoolean("s2locked75", true)) {
			s2sb3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2sb3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2sb3.post(new Runnable() {
					@Override
					public void run() {
						s2sb3.performClick();
					}
				});
			}
		}
		s2sb3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2sb3.setBackgroundResource(R.drawable.not_pressed);
					s2sr3 = 0;
					sharedPrefs75.edit().putBoolean("s2locked75", true)
							.commit();
				} else {
					s2sb3.setBackgroundResource(R.drawable.pressed);
					s2sr3 = 32;
					sharedPrefs75.edit().putBoolean("s2locked75", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs76 = PreferenceManager.getDefaultSharedPreferences(this);
		s2sb4 = (Button) findViewById(R.id.s2sbutton4);
		if (sharedPrefs76.getBoolean("s2locked76", true)) {
			s2sb4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2sb4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2sb4.post(new Runnable() {
					@Override
					public void run() {
						s2sb4.performClick();
					}
				});
			}
		}
		s2sb4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2sb4.setBackgroundResource(R.drawable.not_pressed);
					s2sr4 = 0;
					sharedPrefs76.edit().putBoolean("s2locked76", true)
							.commit();
				} else {
					s2sb4.setBackgroundResource(R.drawable.pressed);
					s2sr4 = 16;
					sharedPrefs76.edit().putBoolean("s2locked76", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs77 = PreferenceManager.getDefaultSharedPreferences(this);
		s2sb5 = (Button) findViewById(R.id.s2sbutton5);
		if (sharedPrefs77.getBoolean("s2locked77", true)) {
			s2sb5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2sb5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2sb5.post(new Runnable() {
					@Override
					public void run() {
						s2sb5.performClick();
					}
				});
			}
		}
		s2sb5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2sb5.setBackgroundResource(R.drawable.not_pressed);
					s2sr5 = 0;
					sharedPrefs77.edit().putBoolean("s2locked77", true)
							.commit();
				} else {
					s2sb5.setBackgroundResource(R.drawable.pressed);
					s2sr5 = 8;
					sharedPrefs77.edit().putBoolean("s2locked77", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs78 = PreferenceManager.getDefaultSharedPreferences(this);
		s2sb6 = (Button) findViewById(R.id.s2sbutton6);
		if (sharedPrefs78.getBoolean("s2locked78", true)) {
			s2sb6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2sb6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2sb6.post(new Runnable() {
					@Override
					public void run() {
						s2sb6.performClick();
					}
				});
			}
		}
		s2sb6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2sb6.setBackgroundResource(R.drawable.not_pressed);
					s2sr6 = 0;
					sharedPrefs78.edit().putBoolean("s2locked78", true)
							.commit();
				} else {
					s2sb6.setBackgroundResource(R.drawable.pressed);
					s2sr6 = 4;
					sharedPrefs78.edit().putBoolean("s2locked78", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs79 = PreferenceManager.getDefaultSharedPreferences(this);
		s2sb7 = (Button) findViewById(R.id.s2sbutton7);
		if (sharedPrefs79.getBoolean("s2locked79", true)) {
			s2sb7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2sb7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2sb7.post(new Runnable() {
					@Override
					public void run() {
						s2sb7.performClick();
					}
				});
			}
		}
		s2sb7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2sb7.setBackgroundResource(R.drawable.not_pressed);
					s2sr7 = 0;
					sharedPrefs79.edit().putBoolean("s2locked79", true)
							.commit();
				} else {
					s2sb7.setBackgroundResource(R.drawable.pressed);
					s2sr7 = 2;
					sharedPrefs79.edit().putBoolean("s2locked79", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs80 = PreferenceManager.getDefaultSharedPreferences(this);
		s2sb8 = (Button) findViewById(R.id.s2sbutton8);
		if (sharedPrefs80.getBoolean("s2locked80", true)) {
			s2sb8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2sb8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2sb8.post(new Runnable() {
					@Override
					public void run() {
						s2sb8.performClick();
					}
				});
			}
		}
		s2sb8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2sb8.setBackgroundResource(R.drawable.not_pressed);
					s2sr8 = 0;
					sharedPrefs80.edit().putBoolean("s2locked80", true)
							.commit();
				} else {
					s2sb8.setBackgroundResource(R.drawable.pressed);
					s2sr8 = 1;
					sharedPrefs80.edit().putBoolean("s2locked80", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// ------------------------------------------------------------------------------------

		sharedPrefs81 = PreferenceManager.getDefaultSharedPreferences(this);
		s2tb1 = (Button) findViewById(R.id.s2tbutton1);
		if (sharedPrefs81.getBoolean("s2locked81", true)) {
			s2tb1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2tb1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2tb1.post(new Runnable() {
					@Override
					public void run() {
						s2tb1.performClick();
					}
				});
			}
		}
		s2tb1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2tb1.setBackgroundResource(R.drawable.not_pressed);
					s2tr1 = 0;
					sharedPrefs81.edit().putBoolean("s2locked81", true)
							.commit();
				} else {
					s2tb1.setBackgroundResource(R.drawable.pressed);
					s2tr1 = 128;
					sharedPrefs81.edit().putBoolean("s2locked81", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs82 = PreferenceManager.getDefaultSharedPreferences(this);
		s2tb2 = (Button) findViewById(R.id.s2tbutton2);
		if (sharedPrefs82.getBoolean("s2locked82", true)) {
			s2tb2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2tb2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2tb2.post(new Runnable() {
					@Override
					public void run() {
						s2tb2.performClick();
					}
				});
			}
		}
		s2tb2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2tb2.setBackgroundResource(R.drawable.not_pressed);
					s2tr2 = 0;
					sharedPrefs82.edit().putBoolean("s2locked82", true)
							.commit();
				} else {
					s2tb2.setBackgroundResource(R.drawable.pressed);
					s2tr2 = 64;
					sharedPrefs82.edit().putBoolean("s2locked82", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs83 = PreferenceManager.getDefaultSharedPreferences(this);
		s2tb3 = (Button) findViewById(R.id.s2tbutton3);
		if (sharedPrefs83.getBoolean("s2locked83", true)) {
			s2tb3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2tb3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2tb3.post(new Runnable() {
					@Override
					public void run() {
						s2tb3.performClick();
					}
				});
			}
		}
		s2tb3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2tb3.setBackgroundResource(R.drawable.not_pressed);
					s2tr3 = 0;
					sharedPrefs83.edit().putBoolean("s2locked83", true)
							.commit();
				} else {
					s2tb3.setBackgroundResource(R.drawable.pressed);
					s2tr3 = 32;
					sharedPrefs83.edit().putBoolean("s2locked83", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs84 = PreferenceManager.getDefaultSharedPreferences(this);
		s2tb4 = (Button) findViewById(R.id.s2tbutton4);
		if (sharedPrefs84.getBoolean("s2locked84", true)) {
			s2tb4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2tb4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2tb4.post(new Runnable() {
					@Override
					public void run() {
						s2tb4.performClick();
					}
				});
			}
		}
		s2tb4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2tb4.setBackgroundResource(R.drawable.not_pressed);
					s2tr4 = 0;
					sharedPrefs84.edit().putBoolean("s2locked84", true)
							.commit();
				} else {
					s2tb4.setBackgroundResource(R.drawable.pressed);
					s2tr4 = 16;
					sharedPrefs84.edit().putBoolean("s2locked84", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs85 = PreferenceManager.getDefaultSharedPreferences(this);
		s2tb5 = (Button) findViewById(R.id.s2tbutton5);
		if (sharedPrefs85.getBoolean("s2locked85", true)) {
			s2tb5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2tb5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2tb5.post(new Runnable() {
					@Override
					public void run() {
						s2tb5.performClick();
					}
				});
			}
		}
		s2tb5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2tb5.setBackgroundResource(R.drawable.not_pressed);
					s2tr5 = 0;
					sharedPrefs85.edit().putBoolean("s2locked85", true)
							.commit();
				} else {
					s2tb5.setBackgroundResource(R.drawable.pressed);
					s2tr5 = 8;
					sharedPrefs85.edit().putBoolean("s2locked85", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs86 = PreferenceManager.getDefaultSharedPreferences(this);
		s2tb6 = (Button) findViewById(R.id.s2tbutton6);
		if (sharedPrefs86.getBoolean("s2locked86", true)) {
			s2tb6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2tb6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2tb6.post(new Runnable() {
					@Override
					public void run() {
						s2tb6.performClick();
					}
				});
			}
		}
		s2tb6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2tb6.setBackgroundResource(R.drawable.not_pressed);
					s2tr6 = 0;
					sharedPrefs86.edit().putBoolean("s2locked86", true)
							.commit();
				} else {
					s2tb6.setBackgroundResource(R.drawable.pressed);
					s2tr6 = 4;
					sharedPrefs86.edit().putBoolean("s2locked86", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs87 = PreferenceManager.getDefaultSharedPreferences(this);
		s2tb7 = (Button) findViewById(R.id.s2tbutton7);
		if (sharedPrefs87.getBoolean("s2locked87", true)) {
			s2tb7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2tb7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2tb7.post(new Runnable() {
					@Override
					public void run() {
						s2tb7.performClick();
					}
				});
			}
		}
		s2tb7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2tb7.setBackgroundResource(R.drawable.not_pressed);
					s2tr7 = 0;
					sharedPrefs87.edit().putBoolean("s2locked87", true)
							.commit();
				} else {
					s2tb7.setBackgroundResource(R.drawable.pressed);
					s2tr7 = 2;
					sharedPrefs87.edit().putBoolean("s2locked87", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs88 = PreferenceManager.getDefaultSharedPreferences(this);
		s2tb8 = (Button) findViewById(R.id.s2tbutton8);
		if (sharedPrefs88.getBoolean("s2locked88", true)) {
			s2tb8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2tb8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2tb8.post(new Runnable() {
					@Override
					public void run() {
						s2tb8.performClick();
					}
				});
			}
		}
		s2tb8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2tb8.setBackgroundResource(R.drawable.not_pressed);
					s2tr8 = 0;
					sharedPrefs88.edit().putBoolean("s2locked88", true)
							.commit();
				} else {
					s2tb8.setBackgroundResource(R.drawable.pressed);
					s2tr8 = 1;
					sharedPrefs88.edit().putBoolean("s2locked88", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// ------------------------------------------------------------------------------------

		sharedPrefs89 = PreferenceManager.getDefaultSharedPreferences(this);
		s2fob1 = (Button) findViewById(R.id.s2fobutton1);
		if (sharedPrefs89.getBoolean("s2locked89", true)) {
			s2fob1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2fob1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2fob1.post(new Runnable() {
					@Override
					public void run() {
						s2fob1.performClick();
					}
				});
			}
		}
		s2fob1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2fob1.setBackgroundResource(R.drawable.not_pressed);
					s2for1 = 0;
					sharedPrefs89.edit().putBoolean("s2locked89", true)
							.commit();
				} else {
					s2fob1.setBackgroundResource(R.drawable.pressed);
					s2for1 = 128;
					sharedPrefs89.edit().putBoolean("s2locked89", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs90 = PreferenceManager.getDefaultSharedPreferences(this);
		s2fob2 = (Button) findViewById(R.id.s2fobutton2);
		if (sharedPrefs90.getBoolean("s2locked90", true)) {
			s2fob2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2fob2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2fob2.post(new Runnable() {
					@Override
					public void run() {
						s2fob2.performClick();
					}
				});
			}
		}
		s2fob2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2fob2.setBackgroundResource(R.drawable.not_pressed);
					s2for2 = 0;
					sharedPrefs90.edit().putBoolean("s2locked90", true)
							.commit();
				} else {
					s2fob2.setBackgroundResource(R.drawable.pressed);
					s2for2 = 64;
					sharedPrefs90.edit().putBoolean("s2locked90", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs91 = PreferenceManager.getDefaultSharedPreferences(this);
		s2fob3 = (Button) findViewById(R.id.s2fobutton3);
		if (sharedPrefs91.getBoolean("s2locked91", true)) {
			s2fob3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2fob3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2fob3.post(new Runnable() {
					@Override
					public void run() {
						s2fob3.performClick();
					}
				});
			}
		}
		s2fob3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2fob3.setBackgroundResource(R.drawable.not_pressed);
					s2for3 = 0;
					sharedPrefs91.edit().putBoolean("s2locked91", true)
							.commit();
				} else {
					s2fob3.setBackgroundResource(R.drawable.pressed);
					s2for3 = 32;
					sharedPrefs91.edit().putBoolean("s2locked91", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs92 = PreferenceManager.getDefaultSharedPreferences(this);
		s2fob4 = (Button) findViewById(R.id.s2fobutton4);
		if (sharedPrefs92.getBoolean("s2locked92", true)) {
			s2fob4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2fob4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2fob4.post(new Runnable() {
					@Override
					public void run() {
						s2fob4.performClick();
					}
				});
			}
		}
		s2fob4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2fob4.setBackgroundResource(R.drawable.not_pressed);
					s2for4 = 0;
					sharedPrefs92.edit().putBoolean("s2locked92", true)
							.commit();
				} else {
					s2fob4.setBackgroundResource(R.drawable.pressed);
					s2for4 = 16;
					sharedPrefs92.edit().putBoolean("s2locked92", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs93 = PreferenceManager.getDefaultSharedPreferences(this);
		s2fob5 = (Button) findViewById(R.id.s2fobutton5);
		if (sharedPrefs93.getBoolean("s2locked93", true)) {
			s2fob5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2fob5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2fob5.post(new Runnable() {
					@Override
					public void run() {
						s2fob5.performClick();
					}
				});
			}
		}
		s2fob5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2fob5.setBackgroundResource(R.drawable.not_pressed);
					s2for5 = 0;
					sharedPrefs93.edit().putBoolean("s2locked93", true)
							.commit();
				} else {
					s2fob5.setBackgroundResource(R.drawable.pressed);
					s2for5 = 8;
					sharedPrefs93.edit().putBoolean("s2locked93", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs94 = PreferenceManager.getDefaultSharedPreferences(this);
		s2fob6 = (Button) findViewById(R.id.s2fobutton6);
		if (sharedPrefs94.getBoolean("s2locked94", true)) {
			s2fob6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2fob6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2fob6.post(new Runnable() {
					@Override
					public void run() {
						s2fob6.performClick();
					}
				});
			}
		}
		s2fob6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2fob6.setBackgroundResource(R.drawable.not_pressed);
					s2for6 = 0;
					sharedPrefs94.edit().putBoolean("s2locked94", true)
							.commit();
				} else {
					s2fob6.setBackgroundResource(R.drawable.pressed);
					s2for6 = 4;
					sharedPrefs94.edit().putBoolean("s2locked94", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs95 = PreferenceManager.getDefaultSharedPreferences(this);
		s2fob7 = (Button) findViewById(R.id.s2fobutton7);
		if (sharedPrefs95.getBoolean("s2locked95", true)) {
			s2fob7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2fob7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2fob7.post(new Runnable() {
					@Override
					public void run() {
						s2fob7.performClick();
					}
				});
			}
		}
		s2fob7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2fob7.setBackgroundResource(R.drawable.not_pressed);
					s2for7 = 0;
					sharedPrefs95.edit().putBoolean("s2locked95", true)
							.commit();
				} else {
					s2fob7.setBackgroundResource(R.drawable.pressed);
					s2for7 = 2;
					sharedPrefs95.edit().putBoolean("s2locked95", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs96 = PreferenceManager.getDefaultSharedPreferences(this);
		s2fob8 = (Button) findViewById(R.id.s2fobutton8);
		if (sharedPrefs96.getBoolean("s2locked96", true)) {
			s2fob8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2fob8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2fob8.post(new Runnable() {
					@Override
					public void run() {
						s2fob8.performClick();
					}
				});
			}
		}
		s2fob8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2fob8.setBackgroundResource(R.drawable.not_pressed);
					s2for8 = 0;
					sharedPrefs96.edit().putBoolean("s2locked96", true)
							.commit();
				} else {
					s2fob8.setBackgroundResource(R.drawable.pressed);
					s2for8 = 1;
					sharedPrefs96.edit().putBoolean("s2locked96", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// ------------------------------------------------------------------------------------

		sharedPrefs97 = PreferenceManager.getDefaultSharedPreferences(this);
		s2fib1 = (Button) findViewById(R.id.s2fibutton1);
		if (sharedPrefs97.getBoolean("s2locked97", true)) {
			s2fib1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2fib1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2fib1.post(new Runnable() {
					@Override
					public void run() {
						s2fib1.performClick();
					}
				});
			}
		}
		s2fib1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2fib1.setBackgroundResource(R.drawable.not_pressed);
					s2fir1 = 0;
					sharedPrefs97.edit().putBoolean("s2locked97", true)
							.commit();
				} else {
					s2fib1.setBackgroundResource(R.drawable.pressed);
					s2fir1 = 128;
					sharedPrefs97.edit().putBoolean("s2locked97", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs98 = PreferenceManager.getDefaultSharedPreferences(this);
		s2fib2 = (Button) findViewById(R.id.s2fibutton2);
		if (sharedPrefs98.getBoolean("s2locked98", true)) {
			s2fib2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2fib2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2fib2.post(new Runnable() {
					@Override
					public void run() {
						s2fib2.performClick();
					}
				});
			}
		}
		s2fib2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2fib2.setBackgroundResource(R.drawable.not_pressed);
					s2fir2 = 0;
					sharedPrefs98.edit().putBoolean("s2locked98", true)
							.commit();
				} else {
					s2fib2.setBackgroundResource(R.drawable.pressed);
					s2fir2 = 64;
					sharedPrefs98.edit().putBoolean("s2locked98", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs99 = PreferenceManager.getDefaultSharedPreferences(this);
		s2fib3 = (Button) findViewById(R.id.s2fibutton3);
		if (sharedPrefs99.getBoolean("s2locked99", true)) {
			s2fib3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2fib3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2fib3.post(new Runnable() {
					@Override
					public void run() {
						s2fib3.performClick();
					}
				});
			}
		}
		s2fib3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2fib3.setBackgroundResource(R.drawable.not_pressed);
					s2fir3 = 0;
					sharedPrefs99.edit().putBoolean("s2locked99", true)
							.commit();
				} else {
					s2fib3.setBackgroundResource(R.drawable.pressed);
					s2fir3 = 32;
					sharedPrefs99.edit().putBoolean("s2locked99", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs100 = PreferenceManager.getDefaultSharedPreferences(this);
		s2fib4 = (Button) findViewById(R.id.s2fibutton4);
		if (sharedPrefs100.getBoolean("s2locked100", true)) {
			s2fib4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2fib4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2fib4.post(new Runnable() {
					@Override
					public void run() {
						s2fib4.performClick();
					}
				});
			}
		}
		s2fib4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2fib4.setBackgroundResource(R.drawable.not_pressed);
					s2fir4 = 0;
					sharedPrefs100.edit().putBoolean("s2locked100", true)
							.commit();
				} else {
					s2fib4.setBackgroundResource(R.drawable.pressed);
					s2fir4 = 16;
					sharedPrefs100.edit().putBoolean("s2locked100", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs101 = PreferenceManager.getDefaultSharedPreferences(this);
		s2fib5 = (Button) findViewById(R.id.s2fibutton5);
		if (sharedPrefs101.getBoolean("s2locked101", true)) {
			s2fib5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2fib5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2fib5.post(new Runnable() {
					@Override
					public void run() {
						s2fib5.performClick();
					}
				});
			}
		}
		s2fib5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2fib5.setBackgroundResource(R.drawable.not_pressed);
					s2fir5 = 0;
					sharedPrefs101.edit().putBoolean("s2locked101", true)
							.commit();
				} else {
					s2fib5.setBackgroundResource(R.drawable.pressed);
					s2fir5 = 8;
					sharedPrefs101.edit().putBoolean("s2locked101", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs102 = PreferenceManager.getDefaultSharedPreferences(this);
		s2fib6 = (Button) findViewById(R.id.s2fibutton6);
		if (sharedPrefs102.getBoolean("s2locked102", true)) {
			s2fib6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2fib6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2fib6.post(new Runnable() {
					@Override
					public void run() {
						s2fib6.performClick();
					}
				});
			}
		}
		s2fib6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2fib6.setBackgroundResource(R.drawable.not_pressed);
					s2fir6 = 0;
					sharedPrefs102.edit().putBoolean("s2locked102", true)
							.commit();
				} else {
					s2fib6.setBackgroundResource(R.drawable.pressed);
					s2fir6 = 4;
					sharedPrefs102.edit().putBoolean("s2locked102", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs103 = PreferenceManager.getDefaultSharedPreferences(this);
		s2fib7 = (Button) findViewById(R.id.s2fibutton7);
		if (sharedPrefs103.getBoolean("s2locked103", true)) {
			s2fib7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2fib7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2fib7.post(new Runnable() {
					@Override
					public void run() {
						s2fib7.performClick();
					}
				});
			}
		}
		s2fib7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2fib7.setBackgroundResource(R.drawable.not_pressed);
					s2fir7 = 0;
					sharedPrefs103.edit().putBoolean("s2locked103", true)
							.commit();
				} else {
					s2fib7.setBackgroundResource(R.drawable.pressed);
					s2fir7 = 2;
					sharedPrefs103.edit().putBoolean("s2locked103", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs104 = PreferenceManager.getDefaultSharedPreferences(this);
		s2fib8 = (Button) findViewById(R.id.s2fibutton8);
		if (sharedPrefs104.getBoolean("s2locked104", true)) {
			s2fib8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2fib8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2fib8.post(new Runnable() {
					@Override
					public void run() {
						s2fib8.performClick();
					}
				});
			}
		}
		s2fib8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2fib8.setBackgroundResource(R.drawable.not_pressed);
					s2fir8 = 0;
					sharedPrefs104.edit().putBoolean("s2locked104", true)
							.commit();
				} else {
					s2fib8.setBackgroundResource(R.drawable.pressed);
					s2fir8 = 1;
					sharedPrefs104.edit().putBoolean("s2locked104", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------

		sharedPrefs105 = PreferenceManager.getDefaultSharedPreferences(this);
		s2sib1 = (Button) findViewById(R.id.s2sibutton1);
		if (sharedPrefs105.getBoolean("s2locked105", true)) {
			s2sib1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2sib1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2sib1.post(new Runnable() {
					@Override
					public void run() {
						s2sib1.performClick();
					}
				});
			}
		}
		s2sib1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2sib1.setBackgroundResource(R.drawable.not_pressed);
					s2sir1 = 0;
					sharedPrefs105.edit().putBoolean("s2locked105", true)
							.commit();
				} else {
					s2sib1.setBackgroundResource(R.drawable.pressed);
					s2sir1 = 128;
					sharedPrefs105.edit().putBoolean("s2locked105", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs106 = PreferenceManager.getDefaultSharedPreferences(this);
		s2sib2 = (Button) findViewById(R.id.s2sibutton2);
		if (sharedPrefs106.getBoolean("s2locked106", true)) {
			s2sib2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2sib2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2sib2.post(new Runnable() {
					@Override
					public void run() {
						s2sib2.performClick();
					}
				});
			}
		}
		s2sib2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2sib2.setBackgroundResource(R.drawable.not_pressed);
					s2sir2 = 0;
					sharedPrefs106.edit().putBoolean("s2locked106", true)
							.commit();
				} else {
					s2sib2.setBackgroundResource(R.drawable.pressed);
					s2sir2 = 64;
					sharedPrefs106.edit().putBoolean("s2locked106", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs107 = PreferenceManager.getDefaultSharedPreferences(this);
		s2sib3 = (Button) findViewById(R.id.s2sibutton3);
		if (sharedPrefs107.getBoolean("s2locked107", true)) {
			s2sib3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2sib3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2sib3.post(new Runnable() {
					@Override
					public void run() {
						s2sib3.performClick();
					}
				});
			}
		}
		s2sib3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2sib3.setBackgroundResource(R.drawable.not_pressed);
					s2sir3 = 0;
					sharedPrefs107.edit().putBoolean("s2locked107", true)
							.commit();
				} else {
					s2sib3.setBackgroundResource(R.drawable.pressed);
					s2sir3 = 32;
					sharedPrefs107.edit().putBoolean("s2locked107", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs108 = PreferenceManager.getDefaultSharedPreferences(this);
		s2sib4 = (Button) findViewById(R.id.s2sibutton4);
		if (sharedPrefs108.getBoolean("s2locked108", true)) {
			s2sib4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2sib4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2sib4.post(new Runnable() {
					@Override
					public void run() {
						s2sib4.performClick();
					}
				});
			}
		}
		s2sib4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2sib4.setBackgroundResource(R.drawable.not_pressed);
					s2sir4 = 0;
					sharedPrefs108.edit().putBoolean("s2locked108", true)
							.commit();
				} else {
					s2sib4.setBackgroundResource(R.drawable.pressed);
					s2sir4 = 16;
					sharedPrefs108.edit().putBoolean("s2locked108", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs109 = PreferenceManager.getDefaultSharedPreferences(this);
		s2sib5 = (Button) findViewById(R.id.s2sibutton5);
		if (sharedPrefs109.getBoolean("s2locked109", true)) {
			s2sib5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2sib5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2sib5.post(new Runnable() {
					@Override
					public void run() {
						s2sib5.performClick();
					}
				});
			}
		}
		s2sib5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2sib5.setBackgroundResource(R.drawable.not_pressed);
					s2sir5 = 0;
					sharedPrefs109.edit().putBoolean("s2locked109", true)
							.commit();
				} else {
					s2sib5.setBackgroundResource(R.drawable.pressed);
					s2sir5 = 8;
					sharedPrefs109.edit().putBoolean("s2locked109", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs110 = PreferenceManager.getDefaultSharedPreferences(this);
		s2sib6 = (Button) findViewById(R.id.s2sibutton6);
		if (sharedPrefs110.getBoolean("s2locked110", true)) {
			s2sib6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2sib6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2sib6.post(new Runnable() {
					@Override
					public void run() {
						s2sib6.performClick();
					}
				});
			}
		}
		s2sib6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2sib6.setBackgroundResource(R.drawable.not_pressed);
					s2sir6 = 0;
					sharedPrefs110.edit().putBoolean("s2locked110", true)
							.commit();
				} else {
					s2sib6.setBackgroundResource(R.drawable.pressed);
					s2sir6 = 4;
					sharedPrefs110.edit().putBoolean("s2locked110", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs111 = PreferenceManager.getDefaultSharedPreferences(this);
		s2sib7 = (Button) findViewById(R.id.s2sibutton7);
		if (sharedPrefs111.getBoolean("s2locked111", true)) {
			s2sib7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2sib7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2sib7.post(new Runnable() {
					@Override
					public void run() {
						s2sib7.performClick();
					}
				});
			}
		}
		s2sib7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2sib7.setBackgroundResource(R.drawable.not_pressed);
					s2sir7 = 0;
					sharedPrefs111.edit().putBoolean("s2locked111", true)
							.commit();
				} else {
					s2sib7.setBackgroundResource(R.drawable.pressed);
					s2sir7 = 2;
					sharedPrefs111.edit().putBoolean("s2locked111", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs112 = PreferenceManager.getDefaultSharedPreferences(this);
		s2sib8 = (Button) findViewById(R.id.s2sibutton8);
		if (sharedPrefs112.getBoolean("s2locked112", true)) {
			s2sib8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2sib8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2sib8.post(new Runnable() {
					@Override
					public void run() {
						s2sib8.performClick();
					}
				});
			}
		}
		s2sib8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2sib8.setBackgroundResource(R.drawable.not_pressed);
					s2sir8 = 0;
					sharedPrefs112.edit().putBoolean("s2locked112", true)
							.commit();
				} else {
					s2sib8.setBackgroundResource(R.drawable.pressed);
					s2sir8 = 1;
					sharedPrefs112.edit().putBoolean("s2locked112", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------

		sharedPrefs113 = PreferenceManager.getDefaultSharedPreferences(this);
		s2seb1 = (Button) findViewById(R.id.s2sebutton1);
		if (sharedPrefs113.getBoolean("s2locked113", true)) {
			s2seb1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2seb1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2seb1.post(new Runnable() {
					@Override
					public void run() {
						s2seb1.performClick();
					}
				});
			}
		}
		s2seb1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2seb1.setBackgroundResource(R.drawable.not_pressed);
					s2ser1 = 0;
					sharedPrefs113.edit().putBoolean("s2locked113", true)
							.commit();
				} else {
					s2seb1.setBackgroundResource(R.drawable.pressed);
					s2ser1 = 128;
					sharedPrefs113.edit().putBoolean("s2locked113", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs114 = PreferenceManager.getDefaultSharedPreferences(this);
		s2seb2 = (Button) findViewById(R.id.s2sebutton2);
		if (sharedPrefs114.getBoolean("s2locked114", true)) {
			s2seb2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2seb2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2seb2.post(new Runnable() {
					@Override
					public void run() {
						s2seb2.performClick();
					}
				});
			}
		}
		s2seb2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2seb2.setBackgroundResource(R.drawable.not_pressed);
					s2ser2 = 0;
					sharedPrefs114.edit().putBoolean("s2locked114", true)
							.commit();
				} else {
					s2seb2.setBackgroundResource(R.drawable.pressed);
					s2ser2 = 64;
					sharedPrefs114.edit().putBoolean("s2locked114", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs115 = PreferenceManager.getDefaultSharedPreferences(this);
		s2seb3 = (Button) findViewById(R.id.s2sebutton3);
		if (sharedPrefs115.getBoolean("s2locked115", true)) {
			s2seb3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2seb3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2seb3.post(new Runnable() {
					@Override
					public void run() {
						s2seb3.performClick();
					}
				});
			}
		}
		s2seb3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2seb3.setBackgroundResource(R.drawable.not_pressed);
					s2ser3 = 0;
					sharedPrefs115.edit().putBoolean("s2locked115", true)
							.commit();
				} else {
					s2seb3.setBackgroundResource(R.drawable.pressed);
					s2ser3 = 32;
					sharedPrefs115.edit().putBoolean("s2locked115", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs116 = PreferenceManager.getDefaultSharedPreferences(this);
		s2seb4 = (Button) findViewById(R.id.s2sebutton4);
		if (sharedPrefs116.getBoolean("s2locked116", true)) {
			s2seb4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2seb4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2seb4.post(new Runnable() {
					@Override
					public void run() {
						s2seb4.performClick();
					}
				});
			}
		}
		s2seb4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2seb4.setBackgroundResource(R.drawable.not_pressed);
					s2ser4 = 0;
					sharedPrefs116.edit().putBoolean("s2locked116", true)
							.commit();
				} else {
					s2seb4.setBackgroundResource(R.drawable.pressed);
					s2ser4 = 16;
					sharedPrefs116.edit().putBoolean("s2locked116", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs117 = PreferenceManager.getDefaultSharedPreferences(this);
		s2seb5 = (Button) findViewById(R.id.s2sebutton5);
		if (sharedPrefs117.getBoolean("s2locked117", true)) {
			s2seb5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2seb5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2seb5.post(new Runnable() {
					@Override
					public void run() {
						s2seb5.performClick();
					}
				});
			}
		}
		s2seb5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2seb5.setBackgroundResource(R.drawable.not_pressed);
					s2ser5 = 0;
					sharedPrefs117.edit().putBoolean("s2locked117", true)
							.commit();
				} else {
					s2seb5.setBackgroundResource(R.drawable.pressed);
					s2ser5 = 8;
					sharedPrefs117.edit().putBoolean("s2locked117", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs118 = PreferenceManager.getDefaultSharedPreferences(this);
		s2seb6 = (Button) findViewById(R.id.s2sebutton6);
		if (sharedPrefs118.getBoolean("s2locked118", true)) {
			s2seb6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2seb6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2seb6.post(new Runnable() {
					@Override
					public void run() {
						s2seb6.performClick();
					}
				});
			}
		}
		s2seb6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2seb6.setBackgroundResource(R.drawable.not_pressed);
					s2ser6 = 0;
					sharedPrefs118.edit().putBoolean("s2locked118", true)
							.commit();
				} else {
					s2seb6.setBackgroundResource(R.drawable.pressed);
					s2ser6 = 4;
					sharedPrefs118.edit().putBoolean("s2locked118", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs119 = PreferenceManager.getDefaultSharedPreferences(this);
		s2seb7 = (Button) findViewById(R.id.s2sebutton7);
		if (sharedPrefs119.getBoolean("s2locked119", true)) {
			s2seb7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2seb7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2seb7.post(new Runnable() {
					@Override
					public void run() {
						s2seb7.performClick();
					}
				});
			}
		}
		s2seb7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2seb7.setBackgroundResource(R.drawable.not_pressed);
					s2ser7 = 0;
					sharedPrefs119.edit().putBoolean("s2locked119", true)
							.commit();
				} else {
					s2seb7.setBackgroundResource(R.drawable.pressed);
					s2ser7 = 2;
					sharedPrefs119.edit().putBoolean("s2locked119", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs120 = PreferenceManager.getDefaultSharedPreferences(this);
		s2seb8 = (Button) findViewById(R.id.s2sebutton8);
		if (sharedPrefs120.getBoolean("s2locked120", true)) {
			s2seb8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2seb8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2seb8.post(new Runnable() {
					@Override
					public void run() {
						s2seb8.performClick();
					}
				});
			}
		}
		s2seb8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2seb8.setBackgroundResource(R.drawable.not_pressed);
					s2ser8 = 0;
					sharedPrefs120.edit().putBoolean("s2locked120", true)
							.commit();
				} else {
					s2seb8.setBackgroundResource(R.drawable.pressed);
					s2ser8 = 1;
					sharedPrefs120.edit().putBoolean("s2locked120", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------

		sharedPrefs121 = PreferenceManager.getDefaultSharedPreferences(this);
		s2eb1 = (Button) findViewById(R.id.s2ebutton1);
		if (sharedPrefs121.getBoolean("s2locked121", true)) {
			s2eb1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2eb1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2eb1.post(new Runnable() {
					@Override
					public void run() {
						s2eb1.performClick();
					}
				});
			}
		}
		s2eb1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2eb1.setBackgroundResource(R.drawable.not_pressed);
					s2er1 = 0;
					sharedPrefs121.edit().putBoolean("s2locked121", true)
							.commit();
				} else {
					s2eb1.setBackgroundResource(R.drawable.pressed);
					s2er1 = 128;
					sharedPrefs121.edit().putBoolean("s2locked121", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs122 = PreferenceManager.getDefaultSharedPreferences(this);
		s2eb2 = (Button) findViewById(R.id.s2ebutton2);
		if (sharedPrefs122.getBoolean("s2locked122", true)) {
			s2eb2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2eb2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2eb2.post(new Runnable() {
					@Override
					public void run() {
						s2eb2.performClick();
					}
				});
			}
		}
		s2eb2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2eb2.setBackgroundResource(R.drawable.not_pressed);
					s2er2 = 0;
					sharedPrefs122.edit().putBoolean("s2locked122", true)
							.commit();
				} else {
					s2eb2.setBackgroundResource(R.drawable.pressed);
					s2er2 = 64;
					sharedPrefs122.edit().putBoolean("s2locked122", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs123 = PreferenceManager.getDefaultSharedPreferences(this);
		s2eb3 = (Button) findViewById(R.id.s2ebutton3);
		if (sharedPrefs123.getBoolean("s2locked123", true)) {
			s2eb3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2eb3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2eb3.post(new Runnable() {
					@Override
					public void run() {
						s2eb3.performClick();
					}
				});
			}
		}
		s2eb3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2eb3.setBackgroundResource(R.drawable.not_pressed);
					s2er3 = 0;
					sharedPrefs123.edit().putBoolean("s2locked123", true)
							.commit();
				} else {
					s2eb3.setBackgroundResource(R.drawable.pressed);
					s2er3 = 32;
					sharedPrefs123.edit().putBoolean("s2locked123", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs124 = PreferenceManager.getDefaultSharedPreferences(this);
		s2eb4 = (Button) findViewById(R.id.s2ebutton4);
		if (sharedPrefs124.getBoolean("s2locked124", true)) {
			s2eb4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2eb4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2eb4.post(new Runnable() {
					@Override
					public void run() {
						s2eb4.performClick();
					}
				});
			}
		}
		s2eb4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2eb4.setBackgroundResource(R.drawable.not_pressed);
					s2er4 = 0;
					sharedPrefs124.edit().putBoolean("s2locked124", true)
							.commit();
				} else {
					s2eb4.setBackgroundResource(R.drawable.pressed);
					s2er4 = 16;
					sharedPrefs124.edit().putBoolean("s2locked124", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs125 = PreferenceManager.getDefaultSharedPreferences(this);
		s2eb5 = (Button) findViewById(R.id.s2ebutton5);
		if (sharedPrefs125.getBoolean("s2locked125", true)) {
			s2eb5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2eb5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2eb5.post(new Runnable() {
					@Override
					public void run() {
						s2eb5.performClick();
					}
				});
			}
		}
		s2eb5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2eb5.setBackgroundResource(R.drawable.not_pressed);
					s2er5 = 0;
					sharedPrefs125.edit().putBoolean("s2locked125", true)
							.commit();
				} else {
					s2eb5.setBackgroundResource(R.drawable.pressed);
					s2er5 = 8;
					sharedPrefs125.edit().putBoolean("s2locked125", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs126 = PreferenceManager.getDefaultSharedPreferences(this);
		s2eb6 = (Button) findViewById(R.id.s2ebutton6);
		if (sharedPrefs126.getBoolean("s2locked126", true)) {
			s2eb6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2eb6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2eb6.post(new Runnable() {
					@Override
					public void run() {
						s2eb6.performClick();
					}
				});
			}
		}
		s2eb6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2eb6.setBackgroundResource(R.drawable.not_pressed);
					s2er6 = 0;
					sharedPrefs126.edit().putBoolean("s2locked126", true)
							.commit();
				} else {
					s2eb6.setBackgroundResource(R.drawable.pressed);
					s2er6 = 4;
					sharedPrefs126.edit().putBoolean("s2locked126", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs127 = PreferenceManager.getDefaultSharedPreferences(this);
		s2eb7 = (Button) findViewById(R.id.s2ebutton7);
		if (sharedPrefs127.getBoolean("s2locked127", true)) {
			s2eb7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2eb7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2eb7.post(new Runnable() {
					@Override
					public void run() {
						s2eb7.performClick();
					}
				});
			}
		}
		s2eb7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2eb7.setBackgroundResource(R.drawable.not_pressed);
					s2er7 = 0;
					sharedPrefs127.edit().putBoolean("s2locked127", true)
							.commit();
				} else {
					s2eb7.setBackgroundResource(R.drawable.pressed);
					s2er7 = 2;
					sharedPrefs127.edit().putBoolean("s2locked127", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs128 = PreferenceManager.getDefaultSharedPreferences(this);
		s2eb8 = (Button) findViewById(R.id.s2ebutton8);
		if (sharedPrefs128.getBoolean("s2locked128", true)) {
			s2eb8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s2eb8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s2eb8.post(new Runnable() {
					@Override
					public void run() {
						s2eb8.performClick();
					}
				});
			}
		}
		s2eb8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s2eb8.setBackgroundResource(R.drawable.not_pressed);
					s2er8 = 0;
					sharedPrefs128.edit().putBoolean("s2locked128", true)
							.commit();
				} else {
					s2eb8.setBackgroundResource(R.drawable.pressed);
					s2er8 = 1;
					sharedPrefs128.edit().putBoolean("s2locked128", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// 3st
		// square------------------------------------------------------------------------------
		// ----------------------------------------------------------------------------------------
		sharedPrefs129 = PreferenceManager.getDefaultSharedPreferences(this);
		s3fb1 = (Button) findViewById(R.id.s3button1);
		if (sharedPrefs129.getBoolean("s2locked129", true)) {
			s3fb1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3fb1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3fb1.post(new Runnable() {
					@Override
					public void run() {
						s3fb1.performClick();
					}
				});
			}
		}
		s3fb1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {

				if (!isPressed) {
					s3fb1.setBackgroundResource(R.drawable.not_pressed);
					s3fr1 = 0;
					sharedPrefs129.edit().putBoolean("s2locked129", true)
							.commit();
					System.out.println("lock to true");

				} else {
					s3fb1.setBackgroundResource(R.drawable.pressed);
					s3fr1 = 128;
					// fb1.setSelected(true);
					// fb1.setPressed(true);
					sharedPrefs129.edit().putBoolean("s2locked129", false)
							.commit();
					System.out.println("lock to false");
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs130 = PreferenceManager.getDefaultSharedPreferences(this);
		s3fb2 = (Button) findViewById(R.id.s3button2);
		if (sharedPrefs130.getBoolean("s2locked130", true)) {
			s3fb2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3fb2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3fb2.post(new Runnable() {
					@Override
					public void run() {
						s3fb2.performClick();
					}
				});
			}
		}
		s3fb2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3fb2.setBackgroundResource(R.drawable.not_pressed);
					s3fr2 = 0;
					sharedPrefs130.edit().putBoolean("s2locked130", true)
							.commit();
				} else {
					s3fb2.setBackgroundResource(R.drawable.pressed);
					s3fr2 = 64;
					sharedPrefs130.edit().putBoolean("s2locked130", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs131 = PreferenceManager.getDefaultSharedPreferences(this);
		s3fb3 = (Button) findViewById(R.id.s3button3);
		if (sharedPrefs131.getBoolean("s2locked131", true)) {
			s3fb3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3fb3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3fb3.post(new Runnable() {
					@Override
					public void run() {
						s3fb3.performClick();
					}
				});
			}
		}
		s3fb3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3fb3.setBackgroundResource(R.drawable.not_pressed);
					s3fr3 = 0;
					sharedPrefs131.edit().putBoolean("s2locked131", true)
							.commit();
				} else {
					s3fb3.setBackgroundResource(R.drawable.pressed);
					s3fr3 = 32;
					sharedPrefs131.edit().putBoolean("s2locked131", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs132 = PreferenceManager.getDefaultSharedPreferences(this);
		s3fb4 = (Button) findViewById(R.id.s3button4);
		if (sharedPrefs132.getBoolean("s2locked132", true)) {
			s3fb4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3fb4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3fb4.post(new Runnable() {
					@Override
					public void run() {
						s3fb4.performClick();
					}
				});
			}
		}
		s3fb4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3fb4.setBackgroundResource(R.drawable.not_pressed);
					s3fr4 = 0;
					sharedPrefs132.edit().putBoolean("s2locked132", true)
							.commit();
				} else {
					s3fb4.setBackgroundResource(R.drawable.pressed);
					s3fr4 = 16;
					sharedPrefs132.edit().putBoolean("s2locked132", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs133 = PreferenceManager.getDefaultSharedPreferences(this);
		s3fb5 = (Button) findViewById(R.id.s3button5);
		if (sharedPrefs133.getBoolean("s2locked133", true)) {
			s3fb5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3fb5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3fb5.post(new Runnable() {
					@Override
					public void run() {
						s3fb5.performClick();
					}
				});
			}
		}
		s3fb5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3fb5.setBackgroundResource(R.drawable.not_pressed);
					s3fr5 = 0;
					sharedPrefs133.edit().putBoolean("s2locked133", true)
							.commit();
				} else {
					s3fb5.setBackgroundResource(R.drawable.pressed);
					s3fr5 = 8;
					sharedPrefs133.edit().putBoolean("s2locked133", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs134 = PreferenceManager.getDefaultSharedPreferences(this);
		s3fb6 = (Button) findViewById(R.id.s3button6);
		if (sharedPrefs134.getBoolean("s2locked134", true)) {
			s3fb6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3fb6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3fb6.post(new Runnable() {
					@Override
					public void run() {
						s3fb6.performClick();
					}
				});
			}
		}
		s3fb6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3fb6.setBackgroundResource(R.drawable.not_pressed);
					s3fr6 = 0;
					sharedPrefs134.edit().putBoolean("s2locked134", true)
							.commit();
				} else {
					s3fb6.setBackgroundResource(R.drawable.pressed);
					s3fr6 = 4;
					sharedPrefs134.edit().putBoolean("s2locked134", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs135 = PreferenceManager.getDefaultSharedPreferences(this);
		s3fb7 = (Button) findViewById(R.id.s3button7);
		if (sharedPrefs135.getBoolean("s2locked135", true)) {
			s3fb7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3fb7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3fb7.post(new Runnable() {
					@Override
					public void run() {
						s3fb7.performClick();
					}
				});
			}
		}
		s3fb7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3fb7.setBackgroundResource(R.drawable.not_pressed);
					s3fr7 = 0;
					sharedPrefs135.edit().putBoolean("s2locked135", true)
							.commit();
				} else {
					s3fb7.setBackgroundResource(R.drawable.pressed);
					s3fr7 = 2;
					sharedPrefs135.edit().putBoolean("s2locked135", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs136 = PreferenceManager.getDefaultSharedPreferences(this);
		s3fb8 = (Button) findViewById(R.id.s3button8);
		if (sharedPrefs136.getBoolean("s2locked136", true)) {
			s3fb8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3fb8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3fb8.post(new Runnable() {
					@Override
					public void run() {
						s3fb8.performClick();
					}
				});
			}
		}
		s3fb8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3fb8.setBackgroundResource(R.drawable.not_pressed);
					s3fr8 = 0;
					sharedPrefs136.edit().putBoolean("s2locked136", true)
							.commit();
				} else {
					s3fb8.setBackgroundResource(R.drawable.pressed);
					s3fr8 = 1;
					sharedPrefs136.edit().putBoolean("s2locked136", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------

		sharedPrefs137 = PreferenceManager.getDefaultSharedPreferences(this);
		s3sb1 = (Button) findViewById(R.id.s3sbutton1);
		if (sharedPrefs137.getBoolean("s2locked137", true)) {
			s3sb1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3sb1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3sb1.post(new Runnable() {
					@Override
					public void run() {
						s3sb1.performClick();
					}
				});
			}
		}
		s3sb1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3sb1.setBackgroundResource(R.drawable.not_pressed);
					s3sr1 = 0;
					sharedPrefs137.edit().putBoolean("s2locked137", true)
							.commit();
				} else {
					s3sb1.setBackgroundResource(R.drawable.pressed);
					s3sr1 = 128;
					sharedPrefs137.edit().putBoolean("s2locked137", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs138 = PreferenceManager.getDefaultSharedPreferences(this);
		s3sb2 = (Button) findViewById(R.id.s3sbutton2);
		if (sharedPrefs138.getBoolean("s2locked138", true)) {
			s3sb2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3sb2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3sb2.post(new Runnable() {
					@Override
					public void run() {
						s3sb2.performClick();
					}
				});
			}
		}
		s3sb2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3sb2.setBackgroundResource(R.drawable.not_pressed);
					s3sr2 = 0;
					sharedPrefs138.edit().putBoolean("s2locked138", true)
							.commit();
				} else {
					s3sb2.setBackgroundResource(R.drawable.pressed);
					s3sr2 = 64;
					sharedPrefs138.edit().putBoolean("s2locked138", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs139 = PreferenceManager.getDefaultSharedPreferences(this);
		s3sb3 = (Button) findViewById(R.id.s3sbutton3);
		if (sharedPrefs139.getBoolean("s2locked139", true)) {
			s3sb3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3sb3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3sb3.post(new Runnable() {
					@Override
					public void run() {
						s3sb3.performClick();
					}
				});
			}
		}
		s3sb3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3sb3.setBackgroundResource(R.drawable.not_pressed);
					s3sr3 = 0;
					sharedPrefs139.edit().putBoolean("s2locked139", true)
							.commit();
				} else {
					s3sb3.setBackgroundResource(R.drawable.pressed);
					s3sr3 = 32;
					sharedPrefs139.edit().putBoolean("s2locked139", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs140 = PreferenceManager.getDefaultSharedPreferences(this);
		s3sb4 = (Button) findViewById(R.id.s3sbutton4);
		if (sharedPrefs140.getBoolean("s2locked140", true)) {
			s3sb4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3sb4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3sb4.post(new Runnable() {
					@Override
					public void run() {
						s3sb4.performClick();
					}
				});
			}
		}
		s3sb4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3sb4.setBackgroundResource(R.drawable.not_pressed);
					s3sr4 = 0;
					sharedPrefs140.edit().putBoolean("s2locked140", true)
							.commit();
				} else {
					s3sb4.setBackgroundResource(R.drawable.pressed);
					s3sr4 = 16;
					sharedPrefs140.edit().putBoolean("s2locked140", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs141 = PreferenceManager.getDefaultSharedPreferences(this);
		s3sb5 = (Button) findViewById(R.id.s3sbutton5);
		if (sharedPrefs141.getBoolean("s2locked141", true)) {
			s3sb5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3sb5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3sb5.post(new Runnable() {
					@Override
					public void run() {
						s3sb5.performClick();
					}
				});
			}
		}
		s3sb5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3sb5.setBackgroundResource(R.drawable.not_pressed);
					s3sr5 = 0;
					sharedPrefs141.edit().putBoolean("s2locked141", true)
							.commit();
				} else {
					s3sb5.setBackgroundResource(R.drawable.pressed);
					s3sr5 = 8;
					sharedPrefs141.edit().putBoolean("s2locked141", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs142 = PreferenceManager.getDefaultSharedPreferences(this);
		s3sb6 = (Button) findViewById(R.id.s3sbutton6);
		if (sharedPrefs142.getBoolean("s2locked142", true)) {
			s3sb6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3sb6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3sb6.post(new Runnable() {
					@Override
					public void run() {
						s3sb6.performClick();
					}
				});
			}
		}
		s3sb6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3sb6.setBackgroundResource(R.drawable.not_pressed);
					s3sr6 = 0;
					sharedPrefs142.edit().putBoolean("s2locked142", true)
							.commit();
				} else {
					s3sb6.setBackgroundResource(R.drawable.pressed);
					s3sr6 = 4;
					sharedPrefs142.edit().putBoolean("s2locked142", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs143 = PreferenceManager.getDefaultSharedPreferences(this);
		s3sb7 = (Button) findViewById(R.id.s3sbutton7);
		if (sharedPrefs143.getBoolean("s2locked143", true)) {
			s3sb7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3sb7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3sb7.post(new Runnable() {
					@Override
					public void run() {
						s3sb7.performClick();
					}
				});
			}
		}
		s3sb7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3sb7.setBackgroundResource(R.drawable.not_pressed);
					s3sr7 = 0;
					sharedPrefs143.edit().putBoolean("s2locked143", true)
							.commit();
				} else {
					s3sb7.setBackgroundResource(R.drawable.pressed);
					s3sr7 = 2;
					sharedPrefs143.edit().putBoolean("s2locked143", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs144 = PreferenceManager.getDefaultSharedPreferences(this);
		s3sb8 = (Button) findViewById(R.id.s3sbutton8);
		if (sharedPrefs144.getBoolean("s2locked144", true)) {
			s3sb8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3sb8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3sb8.post(new Runnable() {
					@Override
					public void run() {
						s3sb8.performClick();
					}
				});
			}
		}
		s3sb8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3sb8.setBackgroundResource(R.drawable.not_pressed);
					s3sr8 = 0;
					sharedPrefs144.edit().putBoolean("s2locked144", true)
							.commit();
				} else {
					s3sb8.setBackgroundResource(R.drawable.pressed);
					s3sr8 = 1;
					sharedPrefs144.edit().putBoolean("s2locked144", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// ------------------------------------------------------------------------------------

		sharedPrefs145 = PreferenceManager.getDefaultSharedPreferences(this);
		s3tb1 = (Button) findViewById(R.id.s3tbutton1);
		if (sharedPrefs145.getBoolean("s2locked145", true)) {
			s3tb1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3tb1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3tb1.post(new Runnable() {
					@Override
					public void run() {
						s3tb1.performClick();
					}
				});
			}
		}
		s3tb1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3tb1.setBackgroundResource(R.drawable.not_pressed);
					s3tr1 = 0;
					sharedPrefs145.edit().putBoolean("s2locked145", true)
							.commit();
				} else {
					s3tb1.setBackgroundResource(R.drawable.pressed);
					s3tr1 = 128;
					sharedPrefs145.edit().putBoolean("s2locked145", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs146 = PreferenceManager.getDefaultSharedPreferences(this);
		s3tb2 = (Button) findViewById(R.id.s3tbutton2);
		if (sharedPrefs146.getBoolean("s2locked146", true)) {
			s3tb2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3tb2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3tb2.post(new Runnable() {
					@Override
					public void run() {
						s3tb2.performClick();
					}
				});
			}
		}
		s3tb2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3tb2.setBackgroundResource(R.drawable.not_pressed);
					s3tr2 = 0;
					sharedPrefs146.edit().putBoolean("s2locked146", true)
							.commit();
				} else {
					s3tb2.setBackgroundResource(R.drawable.pressed);
					s3tr2 = 64;
					sharedPrefs146.edit().putBoolean("s2locked146", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs147 = PreferenceManager.getDefaultSharedPreferences(this);
		s3tb3 = (Button) findViewById(R.id.s3tbutton3);
		if (sharedPrefs147.getBoolean("s2locked147", true)) {
			s3tb3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3tb3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3tb3.post(new Runnable() {
					@Override
					public void run() {
						s3tb3.performClick();
					}
				});
			}
		}
		s3tb3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3tb3.setBackgroundResource(R.drawable.not_pressed);
					s3tr3 = 0;
					sharedPrefs147.edit().putBoolean("s2locked147", true)
							.commit();
				} else {
					s3tb3.setBackgroundResource(R.drawable.pressed);
					s3tr3 = 32;
					sharedPrefs147.edit().putBoolean("s2locked147", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs148 = PreferenceManager.getDefaultSharedPreferences(this);
		s3tb4 = (Button) findViewById(R.id.s3tbutton4);
		if (sharedPrefs148.getBoolean("s2locked148", true)) {
			s3tb4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3tb4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3tb4.post(new Runnable() {
					@Override
					public void run() {
						s3tb4.performClick();
					}
				});
			}
		}
		s3tb4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3tb4.setBackgroundResource(R.drawable.not_pressed);
					s3tr4 = 0;
					sharedPrefs148.edit().putBoolean("s2locked148", true)
							.commit();
				} else {
					s3tb4.setBackgroundResource(R.drawable.pressed);
					s3tr4 = 16;
					sharedPrefs148.edit().putBoolean("s2locked148", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs149 = PreferenceManager.getDefaultSharedPreferences(this);
		s3tb5 = (Button) findViewById(R.id.s3tbutton5);
		if (sharedPrefs149.getBoolean("s2locked149", true)) {
			s3tb5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3tb5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3tb5.post(new Runnable() {
					@Override
					public void run() {
						s3tb5.performClick();
					}
				});
			}
		}
		s3tb5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3tb5.setBackgroundResource(R.drawable.not_pressed);
					s3tr5 = 0;
					sharedPrefs149.edit().putBoolean("s2locked149", true)
							.commit();
				} else {
					s3tb5.setBackgroundResource(R.drawable.pressed);
					s3tr5 = 8;
					sharedPrefs149.edit().putBoolean("s2locked149", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs150 = PreferenceManager.getDefaultSharedPreferences(this);
		s3tb6 = (Button) findViewById(R.id.s3tbutton6);
		if (sharedPrefs150.getBoolean("s2locked150", true)) {
			s3tb6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3tb6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3tb6.post(new Runnable() {
					@Override
					public void run() {
						s3tb6.performClick();
					}
				});
			}
		}
		s3tb6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3tb6.setBackgroundResource(R.drawable.not_pressed);
					s3tr6 = 0;
					sharedPrefs150.edit().putBoolean("s2locked150", true)
							.commit();
				} else {
					s3tb6.setBackgroundResource(R.drawable.pressed);
					s3tr6 = 4;
					sharedPrefs150.edit().putBoolean("s2locked150", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs151 = PreferenceManager.getDefaultSharedPreferences(this);
		s3tb7 = (Button) findViewById(R.id.s3tbutton7);
		if (sharedPrefs151.getBoolean("s2locked151", true)) {
			s3tb7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3tb7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3tb7.post(new Runnable() {
					@Override
					public void run() {
						s3tb7.performClick();
					}
				});
			}
		}
		s3tb7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3tb7.setBackgroundResource(R.drawable.not_pressed);
					s3tr7 = 0;
					sharedPrefs151.edit().putBoolean("s2locked151", true)
							.commit();
				} else {
					s3tb7.setBackgroundResource(R.drawable.pressed);
					s3tr7 = 2;
					sharedPrefs151.edit().putBoolean("s2locked151", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs152 = PreferenceManager.getDefaultSharedPreferences(this);
		s3tb8 = (Button) findViewById(R.id.s3tbutton8);
		if (sharedPrefs152.getBoolean("s2locked152", true)) {
			s3tb8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3tb8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3tb8.post(new Runnable() {
					@Override
					public void run() {
						s3tb8.performClick();
					}
				});
			}
		}
		s3tb8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3tb8.setBackgroundResource(R.drawable.not_pressed);
					s3tr8 = 0;
					sharedPrefs152.edit().putBoolean("s2locked152", true)
							.commit();
				} else {
					s3tb8.setBackgroundResource(R.drawable.pressed);
					s3tr8 = 1;
					sharedPrefs152.edit().putBoolean("s2locked152", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// ------------------------------------------------------------------------------------

		sharedPrefs153 = PreferenceManager.getDefaultSharedPreferences(this);
		s3fob1 = (Button) findViewById(R.id.s3fobutton1);
		if (sharedPrefs153.getBoolean("s2locked153", true)) {
			s3fob1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3fob1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3fob1.post(new Runnable() {
					@Override
					public void run() {
						s3fob1.performClick();
					}
				});
			}
		}
		s3fob1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3fob1.setBackgroundResource(R.drawable.not_pressed);
					s3for1 = 0;
					sharedPrefs153.edit().putBoolean("s2locked153", true)
							.commit();
				} else {
					s3fob1.setBackgroundResource(R.drawable.pressed);
					s3for1 = 128;
					sharedPrefs153.edit().putBoolean("s2locked153", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs154 = PreferenceManager.getDefaultSharedPreferences(this);
		s3fob2 = (Button) findViewById(R.id.s3fobutton2);
		if (sharedPrefs154.getBoolean("s2locked154", true)) {
			s3fob2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3fob2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3fob2.post(new Runnable() {
					@Override
					public void run() {
						s3fob2.performClick();
					}
				});
			}
		}
		s3fob2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3fob2.setBackgroundResource(R.drawable.not_pressed);
					s3for2 = 0;
					sharedPrefs154.edit().putBoolean("s2locked154", true)
							.commit();
				} else {
					s3fob2.setBackgroundResource(R.drawable.pressed);
					s3for2 = 64;
					sharedPrefs154.edit().putBoolean("s2locked154", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs155 = PreferenceManager.getDefaultSharedPreferences(this);
		s3fob3 = (Button) findViewById(R.id.s3fobutton3);
		if (sharedPrefs155.getBoolean("s2locked155", true)) {
			s3fob3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3fob3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3fob3.post(new Runnable() {
					@Override
					public void run() {
						s3fob3.performClick();
					}
				});
			}
		}
		s3fob3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3fob3.setBackgroundResource(R.drawable.not_pressed);
					s3for3 = 0;
					sharedPrefs155.edit().putBoolean("s2locked155", true)
							.commit();
				} else {
					s3fob3.setBackgroundResource(R.drawable.pressed);
					s3for3 = 32;
					sharedPrefs155.edit().putBoolean("s2locked155", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs156 = PreferenceManager.getDefaultSharedPreferences(this);
		s3fob4 = (Button) findViewById(R.id.s3fobutton4);
		if (sharedPrefs156.getBoolean("s2locked156", true)) {
			s3fob4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3fob4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3fob4.post(new Runnable() {
					@Override
					public void run() {
						s3fob4.performClick();
					}
				});
			}
		}
		s3fob4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3fob4.setBackgroundResource(R.drawable.not_pressed);
					s3for4 = 0;
					sharedPrefs156.edit().putBoolean("s2locked156", true)
							.commit();
				} else {
					s3fob4.setBackgroundResource(R.drawable.pressed);
					s3for4 = 16;
					sharedPrefs156.edit().putBoolean("s2locked156", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs157 = PreferenceManager.getDefaultSharedPreferences(this);
		s3fob5 = (Button) findViewById(R.id.s3fobutton5);
		if (sharedPrefs157.getBoolean("s2locked157", true)) {
			s3fob5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3fob5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3fob5.post(new Runnable() {
					@Override
					public void run() {
						s3fob5.performClick();
					}
				});
			}
		}
		s3fob5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3fob5.setBackgroundResource(R.drawable.not_pressed);
					s3for5 = 0;
					sharedPrefs157.edit().putBoolean("s2locked157", true)
							.commit();
				} else {
					s3fob5.setBackgroundResource(R.drawable.pressed);
					s3for5 = 8;
					sharedPrefs157.edit().putBoolean("s2locked157", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs158 = PreferenceManager.getDefaultSharedPreferences(this);
		s3fob6 = (Button) findViewById(R.id.s3fobutton6);
		if (sharedPrefs158.getBoolean("s2locked158", true)) {
			s3fob6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3fob6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3fob6.post(new Runnable() {
					@Override
					public void run() {
						s3fob6.performClick();
					}
				});
			}
		}
		s3fob6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3fob6.setBackgroundResource(R.drawable.not_pressed);
					s3for6 = 0;
					sharedPrefs158.edit().putBoolean("s2locked158", true)
							.commit();
				} else {
					s3fob6.setBackgroundResource(R.drawable.pressed);
					s3for6 = 4;
					sharedPrefs158.edit().putBoolean("s2locked158", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs159 = PreferenceManager.getDefaultSharedPreferences(this);
		s3fob7 = (Button) findViewById(R.id.s3fobutton7);
		if (sharedPrefs159.getBoolean("s2locked159", true)) {
			s3fob7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3fob7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3fob7.post(new Runnable() {
					@Override
					public void run() {
						s3fob7.performClick();
					}
				});
			}
		}
		s3fob7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3fob7.setBackgroundResource(R.drawable.not_pressed);
					s3for7 = 0;
					sharedPrefs159.edit().putBoolean("s2locked159", true)
							.commit();
				} else {
					s3fob7.setBackgroundResource(R.drawable.pressed);
					s3for7 = 2;
					sharedPrefs159.edit().putBoolean("s2locked159", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs160 = PreferenceManager.getDefaultSharedPreferences(this);
		s3fob8 = (Button) findViewById(R.id.s3fobutton8);
		if (sharedPrefs160.getBoolean("s2locked160", true)) {
			s3fob8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3fob8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3fob8.post(new Runnable() {
					@Override
					public void run() {
						s3fob8.performClick();
					}
				});
			}
		}
		s3fob8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3fob8.setBackgroundResource(R.drawable.not_pressed);
					s3for8 = 0;
					sharedPrefs160.edit().putBoolean("s2locked160", true)
							.commit();
				} else {
					s3fob8.setBackgroundResource(R.drawable.pressed);
					s3for8 = 1;
					sharedPrefs160.edit().putBoolean("s2locked160", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// ------------------------------------------------------------------------------------

		sharedPrefs161 = PreferenceManager.getDefaultSharedPreferences(this);
		s3fib1 = (Button) findViewById(R.id.s3fibutton1);
		if (sharedPrefs161.getBoolean("s2locked161", true)) {
			s3fib1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3fib1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3fib1.post(new Runnable() {
					@Override
					public void run() {
						s3fib1.performClick();
					}
				});
			}
		}
		s3fib1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3fib1.setBackgroundResource(R.drawable.not_pressed);
					s3fir1 = 0;
					sharedPrefs161.edit().putBoolean("s2locked161", true)
							.commit();
				} else {
					s3fib1.setBackgroundResource(R.drawable.pressed);
					s3fir1 = 128;
					sharedPrefs161.edit().putBoolean("s2locked161", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs162 = PreferenceManager.getDefaultSharedPreferences(this);
		s3fib2 = (Button) findViewById(R.id.s3fibutton2);
		if (sharedPrefs162.getBoolean("s2locked162", true)) {
			s3fib2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3fib2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3fib2.post(new Runnable() {
					@Override
					public void run() {
						s3fib2.performClick();
					}
				});
			}
		}
		s3fib2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3fib2.setBackgroundResource(R.drawable.not_pressed);
					s3fir2 = 0;
					sharedPrefs162.edit().putBoolean("s2locked162", true)
							.commit();
				} else {
					s3fib2.setBackgroundResource(R.drawable.pressed);
					s3fir2 = 64;
					sharedPrefs162.edit().putBoolean("s2locked162", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs163 = PreferenceManager.getDefaultSharedPreferences(this);
		s3fib3 = (Button) findViewById(R.id.s3fibutton3);
		if (sharedPrefs163.getBoolean("s2locked163", true)) {
			s3fib3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3fib3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3fib3.post(new Runnable() {
					@Override
					public void run() {
						s3fib3.performClick();
					}
				});
			}
		}
		s3fib3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3fib3.setBackgroundResource(R.drawable.not_pressed);
					s3fir3 = 0;
					sharedPrefs163.edit().putBoolean("s2locked163", true)
							.commit();
				} else {
					s3fib3.setBackgroundResource(R.drawable.pressed);
					s3fir3 = 32;
					sharedPrefs163.edit().putBoolean("s2locked163", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs164 = PreferenceManager.getDefaultSharedPreferences(this);
		s3fib4 = (Button) findViewById(R.id.s3fibutton4);
		if (sharedPrefs164.getBoolean("s2locked164", true)) {
			s3fib4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3fib4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3fib4.post(new Runnable() {
					@Override
					public void run() {
						s3fib4.performClick();
					}
				});
			}
		}
		s3fib4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3fib4.setBackgroundResource(R.drawable.not_pressed);
					s3fir4 = 0;
					sharedPrefs164.edit().putBoolean("s2locked164", true)
							.commit();
				} else {
					s3fib4.setBackgroundResource(R.drawable.pressed);
					s3fir4 = 16;
					sharedPrefs164.edit().putBoolean("s2locked164", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs165 = PreferenceManager.getDefaultSharedPreferences(this);
		s3fib5 = (Button) findViewById(R.id.s3fibutton5);
		if (sharedPrefs165.getBoolean("s2locked165", true)) {
			s3fib5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3fib5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3fib5.post(new Runnable() {
					@Override
					public void run() {
						s3fib5.performClick();
					}
				});
			}
		}
		s3fib5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3fib5.setBackgroundResource(R.drawable.not_pressed);
					s3fir5 = 0;
					sharedPrefs165.edit().putBoolean("s2locked165", true)
							.commit();
				} else {
					s3fib5.setBackgroundResource(R.drawable.pressed);
					s3fir5 = 8;
					sharedPrefs165.edit().putBoolean("s2locked165", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs166 = PreferenceManager.getDefaultSharedPreferences(this);
		s3fib6 = (Button) findViewById(R.id.s3fibutton6);
		if (sharedPrefs166.getBoolean("s2locked166", true)) {
			s3fib6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3fib6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3fib6.post(new Runnable() {
					@Override
					public void run() {
						s3fib6.performClick();
					}
				});
			}
		}
		s3fib6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3fib6.setBackgroundResource(R.drawable.not_pressed);
					s3fir6 = 0;
					sharedPrefs166.edit().putBoolean("s2locked166", true)
							.commit();
				} else {
					s3fib6.setBackgroundResource(R.drawable.pressed);
					s3fir6 = 4;
					sharedPrefs166.edit().putBoolean("s2locked166", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs167 = PreferenceManager.getDefaultSharedPreferences(this);
		s3fib7 = (Button) findViewById(R.id.s3fibutton7);
		if (sharedPrefs167.getBoolean("s2locked167", true)) {
			s3fib7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3fib7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3fib7.post(new Runnable() {
					@Override
					public void run() {
						s3fib7.performClick();
					}
				});
			}
		}
		s3fib7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3fib7.setBackgroundResource(R.drawable.not_pressed);
					s3fir7 = 0;
					sharedPrefs167.edit().putBoolean("s2locked167", true)
							.commit();
				} else {
					s3fib7.setBackgroundResource(R.drawable.pressed);
					s3fir7 = 2;
					sharedPrefs167.edit().putBoolean("s2locked167", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs168 = PreferenceManager.getDefaultSharedPreferences(this);
		s3fib8 = (Button) findViewById(R.id.s3fibutton8);
		if (sharedPrefs168.getBoolean("s2locked168", true)) {
			s3fib8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3fib8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3fib8.post(new Runnable() {
					@Override
					public void run() {
						s3fib8.performClick();
					}
				});
			}
		}
		s3fib8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3fib8.setBackgroundResource(R.drawable.not_pressed);
					s3fir8 = 0;
					sharedPrefs168.edit().putBoolean("s2locked168", true)
							.commit();
				} else {
					s3fib8.setBackgroundResource(R.drawable.pressed);
					s3fir8 = 1;
					sharedPrefs168.edit().putBoolean("s2locked168", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------

		sharedPrefs169 = PreferenceManager.getDefaultSharedPreferences(this);
		s3sib1 = (Button) findViewById(R.id.s3sibutton1);
		if (sharedPrefs169.getBoolean("s2locked169", true)) {
			s3sib1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3sib1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3sib1.post(new Runnable() {
					@Override
					public void run() {
						s3sib1.performClick();
					}
				});
			}
		}
		s3sib1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3sib1.setBackgroundResource(R.drawable.not_pressed);
					s3sir1 = 0;
					sharedPrefs169.edit().putBoolean("s2locked169", true)
							.commit();
				} else {
					s3sib1.setBackgroundResource(R.drawable.pressed);
					s3sir1 = 128;
					sharedPrefs169.edit().putBoolean("s2locked169", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs170 = PreferenceManager.getDefaultSharedPreferences(this);
		s3sib2 = (Button) findViewById(R.id.s3sibutton2);
		if (sharedPrefs170.getBoolean("s2locked170", true)) {
			s3sib2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3sib2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3sib2.post(new Runnable() {
					@Override
					public void run() {
						s3sib2.performClick();
					}
				});
			}
		}
		s3sib2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3sib2.setBackgroundResource(R.drawable.not_pressed);
					s3sir2 = 0;
					sharedPrefs170.edit().putBoolean("s2locked170", true)
							.commit();
				} else {
					s3sib2.setBackgroundResource(R.drawable.pressed);
					s3sir2 = 64;
					sharedPrefs170.edit().putBoolean("s2locked170", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs171 = PreferenceManager.getDefaultSharedPreferences(this);
		s3sib3 = (Button) findViewById(R.id.s3sibutton3);
		if (sharedPrefs171.getBoolean("s2locked171", true)) {
			s3sib3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3sib3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3sib3.post(new Runnable() {
					@Override
					public void run() {
						s3sib3.performClick();
					}
				});
			}
		}
		s3sib3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3sib3.setBackgroundResource(R.drawable.not_pressed);
					s3sir3 = 0;
					sharedPrefs171.edit().putBoolean("s2locked171", true)
							.commit();
				} else {
					s3sib3.setBackgroundResource(R.drawable.pressed);
					s3sir3 = 32;
					sharedPrefs171.edit().putBoolean("s2locked171", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs172 = PreferenceManager.getDefaultSharedPreferences(this);
		s3sib4 = (Button) findViewById(R.id.s3sibutton4);
		if (sharedPrefs172.getBoolean("s2locked172", true)) {
			s3sib4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3sib4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3sib4.post(new Runnable() {
					@Override
					public void run() {
						s3sib4.performClick();
					}
				});
			}
		}
		s3sib4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3sib4.setBackgroundResource(R.drawable.not_pressed);
					s3sir4 = 0;
					sharedPrefs172.edit().putBoolean("s2locked172", true)
							.commit();
				} else {
					s3sib4.setBackgroundResource(R.drawable.pressed);
					s3sir4 = 16;
					sharedPrefs172.edit().putBoolean("s2locked172", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs173 = PreferenceManager.getDefaultSharedPreferences(this);
		s3sib5 = (Button) findViewById(R.id.s3sibutton5);
		if (sharedPrefs173.getBoolean("s2locked173", true)) {
			s3sib5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3sib5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3sib5.post(new Runnable() {
					@Override
					public void run() {
						s3sib5.performClick();
					}
				});
			}
		}
		s3sib5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3sib5.setBackgroundResource(R.drawable.not_pressed);
					s3sir5 = 0;
					sharedPrefs173.edit().putBoolean("s2locked173", true)
							.commit();
				} else {
					s3sib5.setBackgroundResource(R.drawable.pressed);
					s3sir5 = 8;
					sharedPrefs173.edit().putBoolean("s2locked173", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs174 = PreferenceManager.getDefaultSharedPreferences(this);
		s3sib6 = (Button) findViewById(R.id.s3sibutton6);
		if (sharedPrefs174.getBoolean("s2locked174", true)) {
			s3sib6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3sib6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3sib6.post(new Runnable() {
					@Override
					public void run() {
						s3sib6.performClick();
					}
				});
			}
		}
		s3sib6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3sib6.setBackgroundResource(R.drawable.not_pressed);
					s3sir6 = 0;
					sharedPrefs174.edit().putBoolean("s2locked174", true)
							.commit();
				} else {
					s3sib6.setBackgroundResource(R.drawable.pressed);
					s3sir6 = 4;
					sharedPrefs174.edit().putBoolean("s2locked174", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs175 = PreferenceManager.getDefaultSharedPreferences(this);
		s3sib7 = (Button) findViewById(R.id.s3sibutton7);
		if (sharedPrefs175.getBoolean("s2locked175", true)) {
			s3sib7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3sib7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3sib7.post(new Runnable() {
					@Override
					public void run() {
						s3sib7.performClick();
					}
				});
			}
		}
		s3sib7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3sib7.setBackgroundResource(R.drawable.not_pressed);
					s3sir7 = 0;
					sharedPrefs175.edit().putBoolean("s2locked175", true)
							.commit();
				} else {
					s3sib7.setBackgroundResource(R.drawable.pressed);
					s3sir7 = 2;
					sharedPrefs175.edit().putBoolean("s2locked175", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs176 = PreferenceManager.getDefaultSharedPreferences(this);
		s3sib8 = (Button) findViewById(R.id.s3sibutton8);
		if (sharedPrefs176.getBoolean("s2locked176", true)) {
			s3sib8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3sib8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3sib8.post(new Runnable() {
					@Override
					public void run() {
						s3sib8.performClick();
					}
				});
			}
		}
		s3sib8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3sib8.setBackgroundResource(R.drawable.not_pressed);
					s3sir8 = 0;
					sharedPrefs176.edit().putBoolean("s2locked176", true)
							.commit();
				} else {
					s3sib8.setBackgroundResource(R.drawable.pressed);
					s3sir8 = 1;
					sharedPrefs176.edit().putBoolean("s2locked176", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------

		sharedPrefs177 = PreferenceManager.getDefaultSharedPreferences(this);
		s3seb1 = (Button) findViewById(R.id.s3sebutton1);
		if (sharedPrefs177.getBoolean("s2locked177", true)) {
			s3seb1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3seb1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3seb1.post(new Runnable() {
					@Override
					public void run() {
						s3seb1.performClick();
					}
				});
			}
		}
		s3seb1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3seb1.setBackgroundResource(R.drawable.not_pressed);
					s3ser1 = 0;
					sharedPrefs177.edit().putBoolean("s2locked177", true)
							.commit();
				} else {
					s3seb1.setBackgroundResource(R.drawable.pressed);
					s3ser1 = 128;
					sharedPrefs177.edit().putBoolean("s2locked177", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs178 = PreferenceManager.getDefaultSharedPreferences(this);
		s3seb2 = (Button) findViewById(R.id.s3sebutton2);
		if (sharedPrefs178.getBoolean("s2locked178", true)) {
			s3seb2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3seb2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3seb2.post(new Runnable() {
					@Override
					public void run() {
						s3seb2.performClick();
					}
				});
			}
		}
		s3seb2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3seb2.setBackgroundResource(R.drawable.not_pressed);
					s3ser2 = 0;
					sharedPrefs178.edit().putBoolean("s2locked178", true)
							.commit();
				} else {
					s3seb2.setBackgroundResource(R.drawable.pressed);
					s3ser2 = 64;
					sharedPrefs178.edit().putBoolean("s2locked178", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs179 = PreferenceManager.getDefaultSharedPreferences(this);
		s3seb3 = (Button) findViewById(R.id.s3sebutton3);
		if (sharedPrefs179.getBoolean("s2locked179", true)) {
			s3seb3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3seb3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3seb3.post(new Runnable() {
					@Override
					public void run() {
						s3seb3.performClick();
					}
				});
			}
		}
		s3seb3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3seb3.setBackgroundResource(R.drawable.not_pressed);
					s3ser3 = 0;
					sharedPrefs179.edit().putBoolean("s2locked179", true)
							.commit();
				} else {
					s3seb3.setBackgroundResource(R.drawable.pressed);
					s3ser3 = 32;
					sharedPrefs179.edit().putBoolean("s2locked179", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs180 = PreferenceManager.getDefaultSharedPreferences(this);
		s3seb4 = (Button) findViewById(R.id.s3sebutton4);
		if (sharedPrefs180.getBoolean("s2locked180", true)) {
			s3seb4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3seb4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3seb4.post(new Runnable() {
					@Override
					public void run() {
						s3seb4.performClick();
					}
				});
			}
		}
		s3seb4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3seb4.setBackgroundResource(R.drawable.not_pressed);
					s3ser4 = 0;
					sharedPrefs180.edit().putBoolean("s2locked180", true)
							.commit();
				} else {
					s3seb4.setBackgroundResource(R.drawable.pressed);
					s3ser4 = 16;
					sharedPrefs180.edit().putBoolean("s2locked180", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs181 = PreferenceManager.getDefaultSharedPreferences(this);
		s3seb5 = (Button) findViewById(R.id.s3sebutton5);
		if (sharedPrefs181.getBoolean("s2locked181", true)) {
			s3seb5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3seb5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3seb5.post(new Runnable() {
					@Override
					public void run() {
						s3seb5.performClick();
					}
				});
			}
		}
		s3seb5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3seb5.setBackgroundResource(R.drawable.not_pressed);
					s3ser5 = 0;
					sharedPrefs181.edit().putBoolean("s2locked181", true)
							.commit();
				} else {
					s3seb5.setBackgroundResource(R.drawable.pressed);
					s3ser5 = 8;
					sharedPrefs181.edit().putBoolean("s2locked181", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs182 = PreferenceManager.getDefaultSharedPreferences(this);
		s3seb6 = (Button) findViewById(R.id.s3sebutton6);
		if (sharedPrefs182.getBoolean("s2locked182", true)) {
			s3seb6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3seb6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3seb6.post(new Runnable() {
					@Override
					public void run() {
						s3seb6.performClick();
					}
				});
			}
		}
		s3seb6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3seb6.setBackgroundResource(R.drawable.not_pressed);
					s3ser6 = 0;
					sharedPrefs182.edit().putBoolean("s2locked182", true)
							.commit();
				} else {
					s3seb6.setBackgroundResource(R.drawable.pressed);
					s3ser6 = 4;
					sharedPrefs182.edit().putBoolean("s2locked182", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs183 = PreferenceManager.getDefaultSharedPreferences(this);
		s3seb7 = (Button) findViewById(R.id.s3sebutton7);
		if (sharedPrefs183.getBoolean("s2locked183", true)) {
			s3seb7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3seb7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3seb7.post(new Runnable() {
					@Override
					public void run() {
						s3seb7.performClick();
					}
				});
			}
		}
		s3seb7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3seb7.setBackgroundResource(R.drawable.not_pressed);
					s3ser7 = 0;
					sharedPrefs183.edit().putBoolean("s2locked183", true)
							.commit();
				} else {
					s3seb7.setBackgroundResource(R.drawable.pressed);
					s3ser7 = 2;
					sharedPrefs183.edit().putBoolean("s2locked183", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs184 = PreferenceManager.getDefaultSharedPreferences(this);
		s3seb8 = (Button) findViewById(R.id.s3sebutton8);
		if (sharedPrefs184.getBoolean("s2locked184", true)) {
			s3seb8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3seb8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3seb8.post(new Runnable() {
					@Override
					public void run() {
						s3seb8.performClick();
					}
				});
			}
		}
		s3seb8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3seb8.setBackgroundResource(R.drawable.not_pressed);
					s3ser8 = 0;
					sharedPrefs184.edit().putBoolean("s2locked184", true)
							.commit();
				} else {
					s3seb8.setBackgroundResource(R.drawable.pressed);
					s3ser8 = 1;
					sharedPrefs184.edit().putBoolean("s2locked184", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------

		sharedPrefs185 = PreferenceManager.getDefaultSharedPreferences(this);
		s3eb1 = (Button) findViewById(R.id.s3ebutton1);
		if (sharedPrefs185.getBoolean("s2locked185", true)) {
			s3eb1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3eb1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3eb1.post(new Runnable() {
					@Override
					public void run() {
						s3eb1.performClick();
					}
				});
			}
		}
		s3eb1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3eb1.setBackgroundResource(R.drawable.not_pressed);
					s3er1 = 0;
					sharedPrefs185.edit().putBoolean("s2locked185", true)
							.commit();
				} else {
					s3eb1.setBackgroundResource(R.drawable.pressed);
					s3er1 = 128;
					sharedPrefs185.edit().putBoolean("s2locked185", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs186 = PreferenceManager.getDefaultSharedPreferences(this);
		s3eb2 = (Button) findViewById(R.id.s3ebutton2);
		if (sharedPrefs186.getBoolean("s2locked186", true)) {
			s3eb2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3eb2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3eb2.post(new Runnable() {
					@Override
					public void run() {
						s3eb2.performClick();
					}
				});
			}
		}
		s3eb2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3eb2.setBackgroundResource(R.drawable.not_pressed);
					s3er2 = 0;
					sharedPrefs186.edit().putBoolean("s2locked186", true)
							.commit();
				} else {
					s3eb2.setBackgroundResource(R.drawable.pressed);
					s3er2 = 64;
					sharedPrefs186.edit().putBoolean("s2locked186", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs187 = PreferenceManager.getDefaultSharedPreferences(this);
		s3eb3 = (Button) findViewById(R.id.s3ebutton3);
		if (sharedPrefs187.getBoolean("s2locked187", true)) {
			s3eb3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3eb3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3eb3.post(new Runnable() {
					@Override
					public void run() {
						s3eb3.performClick();
					}
				});
			}
		}
		s3eb3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3eb3.setBackgroundResource(R.drawable.not_pressed);
					s3er3 = 0;
					sharedPrefs187.edit().putBoolean("s2locked187", true)
							.commit();
				} else {
					s3eb3.setBackgroundResource(R.drawable.pressed);
					s3er3 = 32;
					sharedPrefs187.edit().putBoolean("s2locked187", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs188 = PreferenceManager.getDefaultSharedPreferences(this);
		s3eb4 = (Button) findViewById(R.id.s3ebutton4);
		if (sharedPrefs188.getBoolean("s2locked188", true)) {
			s3eb4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3eb4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3eb4.post(new Runnable() {
					@Override
					public void run() {
						s3eb4.performClick();
					}
				});
			}
		}
		s3eb4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3eb4.setBackgroundResource(R.drawable.not_pressed);
					s3er4 = 0;
					sharedPrefs188.edit().putBoolean("s2locked188", true)
							.commit();
				} else {
					s3eb4.setBackgroundResource(R.drawable.pressed);
					s3er4 = 16;
					sharedPrefs188.edit().putBoolean("s2locked188", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs189 = PreferenceManager.getDefaultSharedPreferences(this);
		s3eb5 = (Button) findViewById(R.id.s3ebutton5);
		if (sharedPrefs189.getBoolean("s2locked189", true)) {
			s3eb5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3eb5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3eb5.post(new Runnable() {
					@Override
					public void run() {
						s3eb5.performClick();
					}
				});
			}
		}
		s3eb5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3eb5.setBackgroundResource(R.drawable.not_pressed);
					s3er5 = 0;
					sharedPrefs189.edit().putBoolean("s2locked189", true)
							.commit();
				} else {
					s3eb5.setBackgroundResource(R.drawable.pressed);
					s3er5 = 8;
					sharedPrefs189.edit().putBoolean("s2locked189", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs190 = PreferenceManager.getDefaultSharedPreferences(this);
		s3eb6 = (Button) findViewById(R.id.s3ebutton6);
		if (sharedPrefs190.getBoolean("s2locked190", true)) {
			s3eb6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3eb6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3eb6.post(new Runnable() {
					@Override
					public void run() {
						s3eb6.performClick();
					}
				});
			}
		}
		s3eb6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3eb6.setBackgroundResource(R.drawable.not_pressed);
					s3er6 = 0;
					sharedPrefs190.edit().putBoolean("s2locked190", true)
							.commit();
				} else {
					s3eb6.setBackgroundResource(R.drawable.pressed);
					s3er6 = 4;
					sharedPrefs190.edit().putBoolean("s2locked190", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs191 = PreferenceManager.getDefaultSharedPreferences(this);
		s3eb7 = (Button) findViewById(R.id.s3ebutton7);
		if (sharedPrefs191.getBoolean("s2locked191", true)) {
			s3eb7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3eb7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3eb7.post(new Runnable() {
					@Override
					public void run() {
						s3eb7.performClick();
					}
				});
			}
		}
		s3eb7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3eb7.setBackgroundResource(R.drawable.not_pressed);
					s3er7 = 0;
					sharedPrefs191.edit().putBoolean("s2locked191", true)
							.commit();
				} else {
					s3eb7.setBackgroundResource(R.drawable.pressed);
					s3er7 = 2;
					sharedPrefs191.edit().putBoolean("s2locked191", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs192 = PreferenceManager.getDefaultSharedPreferences(this);
		s3eb8 = (Button) findViewById(R.id.s3ebutton8);
		if (sharedPrefs192.getBoolean("s2locked192", true)) {
			s3eb8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s3eb8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s3eb8.post(new Runnable() {
					@Override
					public void run() {
						s3eb8.performClick();
					}
				});
			}
		}
		s3eb8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s3eb8.setBackgroundResource(R.drawable.not_pressed);
					s3er8 = 0;
					sharedPrefs192.edit().putBoolean("s2locked192", true)
							.commit();
				} else {
					s3eb8.setBackgroundResource(R.drawable.pressed);
					s3er8 = 1;
					sharedPrefs192.edit().putBoolean("s2locked192", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// 4st
		// square------------------------------------------------------------------------------
		// ----------------------------------------------------------------------------------------
		sharedPrefs193 = PreferenceManager.getDefaultSharedPreferences(this);
		s4fb1 = (Button) findViewById(R.id.s4button1);
		if (sharedPrefs193.getBoolean("s2locked193", true)) {
			s4fb1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4fb1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4fb1.post(new Runnable() {
					@Override
					public void run() {
						s4fb1.performClick();
					}
				});
			}
		}
		s4fb1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {

				if (!isPressed) {
					s4fb1.setBackgroundResource(R.drawable.not_pressed);
					s4fr1 = 0;
					sharedPrefs193.edit().putBoolean("s2locked193", true)
							.commit();
					System.out.println("lock to true");

				} else {
					s4fb1.setBackgroundResource(R.drawable.pressed);
					s4fr1 = 128;
					// fb1.setSelected(true);
					// fb1.setPressed(true);
					sharedPrefs193.edit().putBoolean("s2locked193", false)
							.commit();
					System.out.println("lock to false");
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs194 = PreferenceManager.getDefaultSharedPreferences(this);
		s4fb2 = (Button) findViewById(R.id.s4button2);
		if (sharedPrefs194.getBoolean("s2locked194", true)) {
			s4fb2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4fb2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4fb2.post(new Runnable() {
					@Override
					public void run() {
						s4fb2.performClick();
					}
				});
			}
		}
		s4fb2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4fb2.setBackgroundResource(R.drawable.not_pressed);
					s4fr2 = 0;
					sharedPrefs194.edit().putBoolean("s2locked194", true)
							.commit();
				} else {
					s4fb2.setBackgroundResource(R.drawable.pressed);
					s4fr2 = 64;
					sharedPrefs194.edit().putBoolean("s2locked194", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs195 = PreferenceManager.getDefaultSharedPreferences(this);
		s4fb3 = (Button) findViewById(R.id.s4button3);
		if (sharedPrefs195.getBoolean("s2locked195", true)) {
			s4fb3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4fb3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4fb3.post(new Runnable() {
					@Override
					public void run() {
						s4fb3.performClick();
					}
				});
			}
		}
		s4fb3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4fb3.setBackgroundResource(R.drawable.not_pressed);
					s4fr3 = 0;
					sharedPrefs195.edit().putBoolean("s2locked195", true)
							.commit();
				} else {
					s4fb3.setBackgroundResource(R.drawable.pressed);
					s4fr3 = 32;
					sharedPrefs195.edit().putBoolean("s2locked195", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs196 = PreferenceManager.getDefaultSharedPreferences(this);
		s4fb4 = (Button) findViewById(R.id.s4button4);
		if (sharedPrefs196.getBoolean("s2locked196", true)) {
			s4fb4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4fb4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4fb4.post(new Runnable() {
					@Override
					public void run() {
						s4fb4.performClick();
					}
				});
			}
		}
		s4fb4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4fb4.setBackgroundResource(R.drawable.not_pressed);
					s4fr4 = 0;
					sharedPrefs196.edit().putBoolean("s2locked196", true)
							.commit();
				} else {
					s4fb4.setBackgroundResource(R.drawable.pressed);
					s4fr4 = 16;
					sharedPrefs196.edit().putBoolean("s2locked196", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs197 = PreferenceManager.getDefaultSharedPreferences(this);
		s4fb5 = (Button) findViewById(R.id.s4button5);
		if (sharedPrefs197.getBoolean("s2locked197", true)) {
			s4fb5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4fb5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4fb5.post(new Runnable() {
					@Override
					public void run() {
						s4fb5.performClick();
					}
				});
			}
		}
		s4fb5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4fb5.setBackgroundResource(R.drawable.not_pressed);
					s4fr5 = 0;
					sharedPrefs197.edit().putBoolean("s2locked197", true)
							.commit();
				} else {
					s4fb5.setBackgroundResource(R.drawable.pressed);
					s4fr5 = 8;
					sharedPrefs197.edit().putBoolean("s2locked197", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs198 = PreferenceManager.getDefaultSharedPreferences(this);
		s4fb6 = (Button) findViewById(R.id.s4button6);
		if (sharedPrefs198.getBoolean("s2locked198", true)) {
			s4fb6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4fb6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4fb6.post(new Runnable() {
					@Override
					public void run() {
						s4fb6.performClick();
					}
				});
			}
		}
		s4fb6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4fb6.setBackgroundResource(R.drawable.not_pressed);
					s4fr6 = 0;
					sharedPrefs198.edit().putBoolean("s2locked198", true)
							.commit();
				} else {
					s4fb6.setBackgroundResource(R.drawable.pressed);
					s4fr6 = 4;
					sharedPrefs198.edit().putBoolean("s2locked198", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs199 = PreferenceManager.getDefaultSharedPreferences(this);
		s4fb7 = (Button) findViewById(R.id.s4button7);
		if (sharedPrefs199.getBoolean("s2locked199", true)) {
			s4fb7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4fb7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4fb7.post(new Runnable() {
					@Override
					public void run() {
						s4fb7.performClick();
					}
				});
			}
		}
		s4fb7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4fb7.setBackgroundResource(R.drawable.not_pressed);
					s4fr7 = 0;
					sharedPrefs199.edit().putBoolean("s2locked199", true)
							.commit();
				} else {
					s4fb7.setBackgroundResource(R.drawable.pressed);
					s4fr7 = 2;
					sharedPrefs199.edit().putBoolean("s2locked199", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs200 = PreferenceManager.getDefaultSharedPreferences(this);
		s4fb8 = (Button) findViewById(R.id.s4button8);
		if (sharedPrefs200.getBoolean("s2locked200", true)) {
			s4fb8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4fb8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4fb8.post(new Runnable() {
					@Override
					public void run() {
						s4fb8.performClick();
					}
				});
			}
		}
		s4fb8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4fb8.setBackgroundResource(R.drawable.not_pressed);
					s4fr8 = 0;
					sharedPrefs200.edit().putBoolean("s2locked200", true)
							.commit();
				} else {
					s4fb8.setBackgroundResource(R.drawable.pressed);
					s4fr8 = 1;
					sharedPrefs200.edit().putBoolean("s2locked200", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------

		sharedPrefs201 = PreferenceManager.getDefaultSharedPreferences(this);
		s4sb1 = (Button) findViewById(R.id.s4sbutton1);
		if (sharedPrefs201.getBoolean("s2locked201", true)) {
			s4sb1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4sb1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4sb1.post(new Runnable() {
					@Override
					public void run() {
						s4sb1.performClick();
					}
				});
			}
		}
		s4sb1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4sb1.setBackgroundResource(R.drawable.not_pressed);
					s4sr1 = 0;
					sharedPrefs201.edit().putBoolean("s2locked201", true)
							.commit();
				} else {
					s4sb1.setBackgroundResource(R.drawable.pressed);
					s4sr1 = 128;
					sharedPrefs201.edit().putBoolean("s2locked201", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs202 = PreferenceManager.getDefaultSharedPreferences(this);
		s4sb2 = (Button) findViewById(R.id.s4sbutton2);
		if (sharedPrefs202.getBoolean("s2locked202", true)) {
			s4sb2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4sb2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4sb2.post(new Runnable() {
					@Override
					public void run() {
						s4sb2.performClick();
					}
				});
			}
		}
		s4sb2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4sb2.setBackgroundResource(R.drawable.not_pressed);
					s4sr2 = 0;
					sharedPrefs202.edit().putBoolean("s2locked202", true)
							.commit();
				} else {
					s4sb2.setBackgroundResource(R.drawable.pressed);
					s4sr2 = 64;
					sharedPrefs202.edit().putBoolean("s2locked202", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs203 = PreferenceManager.getDefaultSharedPreferences(this);
		s4sb3 = (Button) findViewById(R.id.s4sbutton3);
		if (sharedPrefs203.getBoolean("s2locked203", true)) {
			s4sb3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4sb3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4sb3.post(new Runnable() {
					@Override
					public void run() {
						s4sb3.performClick();
					}
				});
			}
		}
		s4sb3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4sb3.setBackgroundResource(R.drawable.not_pressed);
					s4sr3 = 0;
					sharedPrefs203.edit().putBoolean("s2locked203", true)
							.commit();
				} else {
					s4sb3.setBackgroundResource(R.drawable.pressed);
					s4sr3 = 32;
					sharedPrefs203.edit().putBoolean("s2locked203", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs204 = PreferenceManager.getDefaultSharedPreferences(this);
		s4sb4 = (Button) findViewById(R.id.s4sbutton4);
		if (sharedPrefs204.getBoolean("s2locked204", true)) {
			s4sb4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4sb4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4sb4.post(new Runnable() {
					@Override
					public void run() {
						s4sb4.performClick();
					}
				});
			}
		}
		s4sb4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4sb4.setBackgroundResource(R.drawable.not_pressed);
					s4sr4 = 0;
					sharedPrefs204.edit().putBoolean("s2locked204", true)
							.commit();
				} else {
					s4sb4.setBackgroundResource(R.drawable.pressed);
					s4sr4 = 16;
					sharedPrefs204.edit().putBoolean("s2locked204", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs205 = PreferenceManager.getDefaultSharedPreferences(this);
		s4sb5 = (Button) findViewById(R.id.s4sbutton5);
		if (sharedPrefs205.getBoolean("s2locked205", true)) {
			s4sb5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4sb5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4sb5.post(new Runnable() {
					@Override
					public void run() {
						s4sb5.performClick();
					}
				});
			}
		}
		s4sb5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4sb5.setBackgroundResource(R.drawable.not_pressed);
					s4sr5 = 0;
					sharedPrefs205.edit().putBoolean("s2locked205", true)
							.commit();
				} else {
					s4sb5.setBackgroundResource(R.drawable.pressed);
					s4sr5 = 8;
					sharedPrefs205.edit().putBoolean("s2locked205", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs206 = PreferenceManager.getDefaultSharedPreferences(this);
		s4sb6 = (Button) findViewById(R.id.s4sbutton6);
		if (sharedPrefs206.getBoolean("s2locked206", true)) {
			s4sb6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4sb6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4sb6.post(new Runnable() {
					@Override
					public void run() {
						s4sb6.performClick();
					}
				});
			}
		}
		s4sb6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4sb6.setBackgroundResource(R.drawable.not_pressed);
					s4sr6 = 0;
					sharedPrefs206.edit().putBoolean("s2locked206", true)
							.commit();
				} else {
					s4sb6.setBackgroundResource(R.drawable.pressed);
					s4sr6 = 4;
					sharedPrefs206.edit().putBoolean("s2locked206", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs207 = PreferenceManager.getDefaultSharedPreferences(this);
		s4sb7 = (Button) findViewById(R.id.s4sbutton7);
		if (sharedPrefs207.getBoolean("s2locked207", true)) {
			s4sb7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4sb7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4sb7.post(new Runnable() {
					@Override
					public void run() {
						s4sb7.performClick();
					}
				});
			}
		}
		s4sb7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4sb7.setBackgroundResource(R.drawable.not_pressed);
					s4sr7 = 0;
					sharedPrefs207.edit().putBoolean("s2locked207", true)
							.commit();
				} else {
					s4sb7.setBackgroundResource(R.drawable.pressed);
					s4sr7 = 2;
					sharedPrefs207.edit().putBoolean("s2locked207", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs208 = PreferenceManager.getDefaultSharedPreferences(this);
		s4sb8 = (Button) findViewById(R.id.s4sbutton8);
		if (sharedPrefs208.getBoolean("s2locked208", true)) {
			s4sb8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4sb8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4sb8.post(new Runnable() {
					@Override
					public void run() {
						s4sb8.performClick();
					}
				});
			}
		}
		s4sb8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4sb8.setBackgroundResource(R.drawable.not_pressed);
					s4sr8 = 0;
					sharedPrefs208.edit().putBoolean("s2locked208", true)
							.commit();
				} else {
					s4sb8.setBackgroundResource(R.drawable.pressed);
					s4sr8 = 1;
					sharedPrefs208.edit().putBoolean("s2locked208", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// ------------------------------------------------------------------------------------

		sharedPrefs209 = PreferenceManager.getDefaultSharedPreferences(this);
		s4tb1 = (Button) findViewById(R.id.s4tbutton1);
		if (sharedPrefs209.getBoolean("s2locked209", true)) {
			s4tb1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4tb1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4tb1.post(new Runnable() {
					@Override
					public void run() {
						s4tb1.performClick();
					}
				});
			}
		}
		s4tb1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4tb1.setBackgroundResource(R.drawable.not_pressed);
					s4tr1 = 0;
					sharedPrefs209.edit().putBoolean("s2locked209", true)
							.commit();
				} else {
					s4tb1.setBackgroundResource(R.drawable.pressed);
					s4tr1 = 128;
					sharedPrefs209.edit().putBoolean("s2locked209", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs210 = PreferenceManager.getDefaultSharedPreferences(this);
		s4tb2 = (Button) findViewById(R.id.s4tbutton2);
		if (sharedPrefs210.getBoolean("s2locked210", true)) {
			s4tb2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4tb2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4tb2.post(new Runnable() {
					@Override
					public void run() {
						s4tb2.performClick();
					}
				});
			}
		}
		s4tb2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4tb2.setBackgroundResource(R.drawable.not_pressed);
					s4tr2 = 0;
					sharedPrefs210.edit().putBoolean("s2locked210", true)
							.commit();
				} else {
					s4tb2.setBackgroundResource(R.drawable.pressed);
					s4tr2 = 64;
					sharedPrefs210.edit().putBoolean("s2locked210", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs211 = PreferenceManager.getDefaultSharedPreferences(this);
		s4tb3 = (Button) findViewById(R.id.s4tbutton3);
		if (sharedPrefs211.getBoolean("s2locked211", true)) {
			s4tb3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4tb3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4tb3.post(new Runnable() {
					@Override
					public void run() {
						s4tb3.performClick();
					}
				});
			}
		}
		s4tb3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4tb3.setBackgroundResource(R.drawable.not_pressed);
					s4tr3 = 0;
					sharedPrefs211.edit().putBoolean("s2locked211", true)
							.commit();
				} else {
					s4tb3.setBackgroundResource(R.drawable.pressed);
					s4tr3 = 32;
					sharedPrefs211.edit().putBoolean("s2locked211", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs212 = PreferenceManager.getDefaultSharedPreferences(this);
		s4tb4 = (Button) findViewById(R.id.s4tbutton4);
		if (sharedPrefs212.getBoolean("s2locked212", true)) {
			s4tb4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4tb4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4tb4.post(new Runnable() {
					@Override
					public void run() {
						s4tb4.performClick();
					}
				});
			}
		}
		s4tb4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4tb4.setBackgroundResource(R.drawable.not_pressed);
					s4tr4 = 0;
					sharedPrefs212.edit().putBoolean("s2locked212", true)
							.commit();
				} else {
					s4tb4.setBackgroundResource(R.drawable.pressed);
					s4tr4 = 16;
					sharedPrefs212.edit().putBoolean("s2locked212", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs213 = PreferenceManager.getDefaultSharedPreferences(this);
		s4tb5 = (Button) findViewById(R.id.s4tbutton5);
		if (sharedPrefs213.getBoolean("s2locked213", true)) {
			s4tb5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4tb5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4tb5.post(new Runnable() {
					@Override
					public void run() {
						s4tb5.performClick();
					}
				});
			}
		}
		s4tb5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4tb5.setBackgroundResource(R.drawable.not_pressed);
					s4tr5 = 0;
					sharedPrefs213.edit().putBoolean("s2locked213", true)
							.commit();
				} else {
					s4tb5.setBackgroundResource(R.drawable.pressed);
					s4tr5 = 8;
					sharedPrefs213.edit().putBoolean("s2locked213", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs214 = PreferenceManager.getDefaultSharedPreferences(this);
		s4tb6 = (Button) findViewById(R.id.s4tbutton6);
		if (sharedPrefs214.getBoolean("s2locked214", true)) {
			s4tb6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4tb6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4tb6.post(new Runnable() {
					@Override
					public void run() {
						s4tb6.performClick();
					}
				});
			}
		}
		s4tb6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4tb6.setBackgroundResource(R.drawable.not_pressed);
					s4tr6 = 0;
					sharedPrefs214.edit().putBoolean("s2locked214", true)
							.commit();
				} else {
					s4tb6.setBackgroundResource(R.drawable.pressed);
					s4tr6 = 4;
					sharedPrefs214.edit().putBoolean("s2locked214", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs215 = PreferenceManager.getDefaultSharedPreferences(this);
		s4tb7 = (Button) findViewById(R.id.s4tbutton7);
		if (sharedPrefs215.getBoolean("s2locked215", true)) {
			s4tb7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4tb7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4tb7.post(new Runnable() {
					@Override
					public void run() {
						s4tb7.performClick();
					}
				});
			}
		}
		s4tb7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4tb7.setBackgroundResource(R.drawable.not_pressed);
					s4tr7 = 0;
					sharedPrefs215.edit().putBoolean("s2locked215", true)
							.commit();
				} else {
					s4tb7.setBackgroundResource(R.drawable.pressed);
					s4tr7 = 2;
					sharedPrefs215.edit().putBoolean("s2locked215", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs216 = PreferenceManager.getDefaultSharedPreferences(this);
		s4tb8 = (Button) findViewById(R.id.s4tbutton8);
		if (sharedPrefs216.getBoolean("s2locked216", true)) {
			s4tb8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4tb8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4tb8.post(new Runnable() {
					@Override
					public void run() {
						s4tb8.performClick();
					}
				});
			}
		}
		s4tb8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4tb8.setBackgroundResource(R.drawable.not_pressed);
					s4tr8 = 0;
					sharedPrefs216.edit().putBoolean("s2locked216", true)
							.commit();
				} else {
					s4tb8.setBackgroundResource(R.drawable.pressed);
					s4tr8 = 1;
					sharedPrefs216.edit().putBoolean("s2locked216", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// ------------------------------------------------------------------------------------

		sharedPrefs217 = PreferenceManager.getDefaultSharedPreferences(this);
		s4fob1 = (Button) findViewById(R.id.s4fobutton1);
		if (sharedPrefs217.getBoolean("s2locked217", true)) {
			s4fob1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4fob1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4fob1.post(new Runnable() {
					@Override
					public void run() {
						s4fob1.performClick();
					}
				});
			}
		}
		s4fob1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4fob1.setBackgroundResource(R.drawable.not_pressed);
					s4for1 = 0;
					sharedPrefs217.edit().putBoolean("s2locked217", true)
							.commit();
				} else {
					s4fob1.setBackgroundResource(R.drawable.pressed);
					s4for1 = 128;
					sharedPrefs217.edit().putBoolean("s2locked217", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs218 = PreferenceManager.getDefaultSharedPreferences(this);
		s4fob2 = (Button) findViewById(R.id.s4fobutton2);
		if (sharedPrefs218.getBoolean("s2locked218", true)) {
			s4fob2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4fob2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4fob2.post(new Runnable() {
					@Override
					public void run() {
						s4fob2.performClick();
					}
				});
			}
		}
		s4fob2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4fob2.setBackgroundResource(R.drawable.not_pressed);
					s4for2 = 0;
					sharedPrefs218.edit().putBoolean("s2locked218", true)
							.commit();
				} else {
					s4fob2.setBackgroundResource(R.drawable.pressed);
					s4for2 = 64;
					sharedPrefs218.edit().putBoolean("s2locked218", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs219 = PreferenceManager.getDefaultSharedPreferences(this);
		s4fob3 = (Button) findViewById(R.id.s4fobutton3);
		if (sharedPrefs219.getBoolean("s2locked219", true)) {
			s4fob3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4fob3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4fob3.post(new Runnable() {
					@Override
					public void run() {
						s4fob3.performClick();
					}
				});
			}
		}
		s4fob3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4fob3.setBackgroundResource(R.drawable.not_pressed);
					s4for3 = 0;
					sharedPrefs219.edit().putBoolean("s2locked219", true)
							.commit();
				} else {
					s4fob3.setBackgroundResource(R.drawable.pressed);
					s4for3 = 32;
					sharedPrefs219.edit().putBoolean("s2locked219", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs220 = PreferenceManager.getDefaultSharedPreferences(this);
		s4fob4 = (Button) findViewById(R.id.s4fobutton4);
		if (sharedPrefs220.getBoolean("s2locked220", true)) {
			s4fob4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4fob4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4fob4.post(new Runnable() {
					@Override
					public void run() {
						s4fob4.performClick();
					}
				});
			}
		}
		s4fob4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4fob4.setBackgroundResource(R.drawable.not_pressed);
					s4for4 = 0;
					sharedPrefs220.edit().putBoolean("s2locked220", true)
							.commit();
				} else {
					s4fob4.setBackgroundResource(R.drawable.pressed);
					s4for4 = 16;
					sharedPrefs220.edit().putBoolean("s2locked220", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs221 = PreferenceManager.getDefaultSharedPreferences(this);
		s4fob5 = (Button) findViewById(R.id.s4fobutton5);
		if (sharedPrefs221.getBoolean("s2locked221", true)) {
			s4fob5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4fob5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4fob5.post(new Runnable() {
					@Override
					public void run() {
						s4fob5.performClick();
					}
				});
			}
		}
		s4fob5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4fob5.setBackgroundResource(R.drawable.not_pressed);
					s4for5 = 0;
					sharedPrefs221.edit().putBoolean("s2locked221", true)
							.commit();
				} else {
					s4fob5.setBackgroundResource(R.drawable.pressed);
					s4for5 = 8;
					sharedPrefs221.edit().putBoolean("s2locked221", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs222 = PreferenceManager.getDefaultSharedPreferences(this);
		s4fob6 = (Button) findViewById(R.id.s4fobutton6);
		if (sharedPrefs222.getBoolean("s2locked222", true)) {
			s4fob6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4fob6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4fob6.post(new Runnable() {
					@Override
					public void run() {
						s4fob6.performClick();
					}
				});
			}
		}
		s4fob6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4fob6.setBackgroundResource(R.drawable.not_pressed);
					s4for6 = 0;
					sharedPrefs222.edit().putBoolean("s2locked222", true)
							.commit();
				} else {
					s4fob6.setBackgroundResource(R.drawable.pressed);
					s4for6 = 4;
					sharedPrefs222.edit().putBoolean("s2locked222", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs223 = PreferenceManager.getDefaultSharedPreferences(this);
		s4fob7 = (Button) findViewById(R.id.s4fobutton7);
		if (sharedPrefs223.getBoolean("s2locked223", true)) {
			s4fob7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4fob7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4fob7.post(new Runnable() {
					@Override
					public void run() {
						s4fob7.performClick();
					}
				});
			}
		}
		s4fob7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4fob7.setBackgroundResource(R.drawable.not_pressed);
					s4for7 = 0;
					sharedPrefs223.edit().putBoolean("s2locked223", true)
							.commit();
				} else {
					s4fob7.setBackgroundResource(R.drawable.pressed);
					s4for7 = 2;
					sharedPrefs223.edit().putBoolean("s2locked223", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs224 = PreferenceManager.getDefaultSharedPreferences(this);
		s4fob8 = (Button) findViewById(R.id.s4fobutton8);
		if (sharedPrefs224.getBoolean("s2locked224", true)) {
			s4fob8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4fob8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4fob8.post(new Runnable() {
					@Override
					public void run() {
						s4fob8.performClick();
					}
				});
			}
		}
		s4fob8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4fob8.setBackgroundResource(R.drawable.not_pressed);
					s4for8 = 0;
					sharedPrefs224.edit().putBoolean("s2locked224", true)
							.commit();
				} else {
					s4fob8.setBackgroundResource(R.drawable.pressed);
					s4for8 = 1;
					sharedPrefs224.edit().putBoolean("s2locked224", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// ------------------------------------------------------------------------------------

		sharedPrefs225 = PreferenceManager.getDefaultSharedPreferences(this);
		s4fib1 = (Button) findViewById(R.id.s4fibutton1);
		if (sharedPrefs225.getBoolean("s2locked225", true)) {
			s4fib1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4fib1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4fib1.post(new Runnable() {
					@Override
					public void run() {
						s4fib1.performClick();
					}
				});
			}
		}
		s4fib1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4fib1.setBackgroundResource(R.drawable.not_pressed);
					s4fir1 = 0;
					sharedPrefs225.edit().putBoolean("s2locked225", true)
							.commit();
				} else {
					s4fib1.setBackgroundResource(R.drawable.pressed);
					s4fir1 = 128;
					sharedPrefs225.edit().putBoolean("s2locked225", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs226 = PreferenceManager.getDefaultSharedPreferences(this);
		s4fib2 = (Button) findViewById(R.id.s4fibutton2);
		if (sharedPrefs226.getBoolean("s2locked226", true)) {
			s4fib2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4fib2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4fib2.post(new Runnable() {
					@Override
					public void run() {
						s4fib2.performClick();
					}
				});
			}
		}
		s4fib2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4fib2.setBackgroundResource(R.drawable.not_pressed);
					s4fir2 = 0;
					sharedPrefs226.edit().putBoolean("s2locked226", true)
							.commit();
				} else {
					s4fib2.setBackgroundResource(R.drawable.pressed);
					s4fir2 = 64;
					sharedPrefs226.edit().putBoolean("s2locked226", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs227 = PreferenceManager.getDefaultSharedPreferences(this);
		s4fib3 = (Button) findViewById(R.id.s4fibutton3);
		if (sharedPrefs227.getBoolean("s2locked227", true)) {
			s4fib3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4fib3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4fib3.post(new Runnable() {
					@Override
					public void run() {
						s4fib3.performClick();
					}
				});
			}
		}
		s4fib3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4fib3.setBackgroundResource(R.drawable.not_pressed);
					s4fir3 = 0;
					sharedPrefs227.edit().putBoolean("s2locked227", true)
							.commit();
				} else {
					s4fib3.setBackgroundResource(R.drawable.pressed);
					s4fir3 = 32;
					sharedPrefs227.edit().putBoolean("s2locked227", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs228 = PreferenceManager.getDefaultSharedPreferences(this);
		s4fib4 = (Button) findViewById(R.id.s4fibutton4);
		if (sharedPrefs228.getBoolean("s2locked228", true)) {
			s4fib4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4fib4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4fib4.post(new Runnable() {
					@Override
					public void run() {
						s4fib4.performClick();
					}
				});
			}
		}
		s4fib4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4fib4.setBackgroundResource(R.drawable.not_pressed);
					s4fir4 = 0;
					sharedPrefs228.edit().putBoolean("s2locked228", true)
							.commit();
				} else {
					s4fib4.setBackgroundResource(R.drawable.pressed);
					s4fir4 = 16;
					sharedPrefs228.edit().putBoolean("s2locked228", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs229 = PreferenceManager.getDefaultSharedPreferences(this);
		s4fib5 = (Button) findViewById(R.id.s4fibutton5);
		if (sharedPrefs229.getBoolean("s2locked229", true)) {
			s4fib5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4fib5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4fib5.post(new Runnable() {
					@Override
					public void run() {
						s4fib5.performClick();
					}
				});
			}
		}
		s4fib5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4fib5.setBackgroundResource(R.drawable.not_pressed);
					s4fir5 = 0;
					sharedPrefs229.edit().putBoolean("s2locked229", true)
							.commit();
				} else {
					s4fib5.setBackgroundResource(R.drawable.pressed);
					s4fir5 = 8;
					sharedPrefs229.edit().putBoolean("s2locked229", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs230 = PreferenceManager.getDefaultSharedPreferences(this);
		s4fib6 = (Button) findViewById(R.id.s4fibutton6);
		if (sharedPrefs230.getBoolean("s2locked230", true)) {
			s4fib6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4fib6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4fib6.post(new Runnable() {
					@Override
					public void run() {
						s4fib6.performClick();
					}
				});
			}
		}
		s4fib6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4fib6.setBackgroundResource(R.drawable.not_pressed);
					s4fir6 = 0;
					sharedPrefs230.edit().putBoolean("s2locked230", true)
							.commit();
				} else {
					s4fib6.setBackgroundResource(R.drawable.pressed);
					s4fir6 = 4;
					sharedPrefs230.edit().putBoolean("s2locked230", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs231 = PreferenceManager.getDefaultSharedPreferences(this);
		s4fib7 = (Button) findViewById(R.id.s4fibutton7);
		if (sharedPrefs231.getBoolean("s2locked231", true)) {
			s4fib7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4fib7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4fib7.post(new Runnable() {
					@Override
					public void run() {
						s4fib7.performClick();
					}
				});
			}
		}
		s4fib7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4fib7.setBackgroundResource(R.drawable.not_pressed);
					s4fir7 = 0;
					sharedPrefs231.edit().putBoolean("s2locked231", true)
							.commit();
				} else {
					s4fib7.setBackgroundResource(R.drawable.pressed);
					s4fir7 = 2;
					sharedPrefs231.edit().putBoolean("s2locked231", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs232 = PreferenceManager.getDefaultSharedPreferences(this);
		s4fib8 = (Button) findViewById(R.id.s4fibutton8);
		if (sharedPrefs232.getBoolean("s2locked232", true)) {
			s4fib8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4fib8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4fib8.post(new Runnable() {
					@Override
					public void run() {
						s4fib8.performClick();
					}
				});
			}
		}
		s4fib8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4fib8.setBackgroundResource(R.drawable.not_pressed);
					s4fir8 = 0;
					sharedPrefs232.edit().putBoolean("s2locked232", true)
							.commit();
				} else {
					s4fib8.setBackgroundResource(R.drawable.pressed);
					s4fir8 = 1;
					sharedPrefs232.edit().putBoolean("s2locked232", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------

		sharedPrefs233 = PreferenceManager.getDefaultSharedPreferences(this);
		s4sib1 = (Button) findViewById(R.id.s4sibutton1);
		if (sharedPrefs233.getBoolean("s2locked233", true)) {
			s4sib1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4sib1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4sib1.post(new Runnable() {
					@Override
					public void run() {
						s4sib1.performClick();
					}
				});
			}
		}
		s4sib1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4sib1.setBackgroundResource(R.drawable.not_pressed);
					s4sir1 = 0;
					sharedPrefs233.edit().putBoolean("s2locked233", true)
							.commit();
				} else {
					s4sib1.setBackgroundResource(R.drawable.pressed);
					s4sir1 = 128;
					sharedPrefs233.edit().putBoolean("s2locked233", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs234 = PreferenceManager.getDefaultSharedPreferences(this);
		s4sib2 = (Button) findViewById(R.id.s4sibutton2);
		if (sharedPrefs234.getBoolean("s2locked234", true)) {
			s4sib2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4sib2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4sib2.post(new Runnable() {
					@Override
					public void run() {
						s4sib2.performClick();
					}
				});
			}
		}
		s4sib2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4sib2.setBackgroundResource(R.drawable.not_pressed);
					s4sir2 = 0;
					sharedPrefs234.edit().putBoolean("s2locked234", true)
							.commit();
				} else {
					s4sib2.setBackgroundResource(R.drawable.pressed);
					s4sir2 = 64;
					sharedPrefs234.edit().putBoolean("s2locked234", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs235 = PreferenceManager.getDefaultSharedPreferences(this);
		s4sib3 = (Button) findViewById(R.id.s4sibutton3);
		if (sharedPrefs235.getBoolean("s2locked235", true)) {
			s4sib3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4sib3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4sib3.post(new Runnable() {
					@Override
					public void run() {
						s4sib3.performClick();
					}
				});
			}
		}
		s4sib3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4sib3.setBackgroundResource(R.drawable.not_pressed);
					s4sir3 = 0;
					sharedPrefs235.edit().putBoolean("s2locked235", true)
							.commit();
				} else {
					s4sib3.setBackgroundResource(R.drawable.pressed);
					s4sir3 = 32;
					sharedPrefs235.edit().putBoolean("s2locked235", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs236 = PreferenceManager.getDefaultSharedPreferences(this);
		s4sib4 = (Button) findViewById(R.id.s4sibutton4);
		if (sharedPrefs236.getBoolean("s2locked236", true)) {
			s4sib4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4sib4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4sib4.post(new Runnable() {
					@Override
					public void run() {
						s4sib4.performClick();
					}
				});
			}
		}
		s4sib4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4sib4.setBackgroundResource(R.drawable.not_pressed);
					s4sir4 = 0;
					sharedPrefs236.edit().putBoolean("s2locked236", true)
							.commit();
				} else {
					s4sib4.setBackgroundResource(R.drawable.pressed);
					s4sir4 = 16;
					sharedPrefs236.edit().putBoolean("s2locked236", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs237 = PreferenceManager.getDefaultSharedPreferences(this);
		s4sib5 = (Button) findViewById(R.id.s4sibutton5);
		if (sharedPrefs237.getBoolean("s2locked237", true)) {
			s4sib5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4sib5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4sib5.post(new Runnable() {
					@Override
					public void run() {
						s4sib5.performClick();
					}
				});
			}
		}
		s4sib5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4sib5.setBackgroundResource(R.drawable.not_pressed);
					s4sir5 = 0;
					sharedPrefs237.edit().putBoolean("s2locked237", true)
							.commit();
				} else {
					s4sib5.setBackgroundResource(R.drawable.pressed);
					s4sir5 = 8;
					sharedPrefs237.edit().putBoolean("s2locked237", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs238 = PreferenceManager.getDefaultSharedPreferences(this);
		s4sib6 = (Button) findViewById(R.id.s4sibutton6);
		if (sharedPrefs238.getBoolean("s2locked238", true)) {
			s4sib6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4sib6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4sib6.post(new Runnable() {
					@Override
					public void run() {
						s4sib6.performClick();
					}
				});
			}
		}
		s4sib6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4sib6.setBackgroundResource(R.drawable.not_pressed);
					s4sir6 = 0;
					sharedPrefs238.edit().putBoolean("s2locked238", true)
							.commit();
				} else {
					s4sib6.setBackgroundResource(R.drawable.pressed);
					s4sir6 = 4;
					sharedPrefs238.edit().putBoolean("s2locked238", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs239 = PreferenceManager.getDefaultSharedPreferences(this);
		s4sib7 = (Button) findViewById(R.id.s4sibutton7);
		if (sharedPrefs239.getBoolean("s2locked239", true)) {
			s4sib7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4sib7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4sib7.post(new Runnable() {
					@Override
					public void run() {
						s4sib7.performClick();
					}
				});
			}
		}
		s4sib7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4sib7.setBackgroundResource(R.drawable.not_pressed);
					s4sir7 = 0;
					sharedPrefs239.edit().putBoolean("s2locked239", true)
							.commit();
				} else {
					s4sib7.setBackgroundResource(R.drawable.pressed);
					s4sir7 = 2;
					sharedPrefs239.edit().putBoolean("s2locked239", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs240 = PreferenceManager.getDefaultSharedPreferences(this);
		s4sib8 = (Button) findViewById(R.id.s4sibutton8);
		if (sharedPrefs240.getBoolean("s2locked240", true)) {
			s4sib8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4sib8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4sib8.post(new Runnable() {
					@Override
					public void run() {
						s4sib8.performClick();
					}
				});
			}
		}
		s4sib8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4sib8.setBackgroundResource(R.drawable.not_pressed);
					s4sir8 = 0;
					sharedPrefs240.edit().putBoolean("s2locked240", true)
							.commit();
				} else {
					s4sib8.setBackgroundResource(R.drawable.pressed);
					s4sir8 = 1;
					sharedPrefs240.edit().putBoolean("s2locked240", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------

		sharedPrefs241 = PreferenceManager.getDefaultSharedPreferences(this);
		s4seb1 = (Button) findViewById(R.id.s4sebutton1);
		if (sharedPrefs241.getBoolean("s2locked241", true)) {
			s4seb1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4seb1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4seb1.post(new Runnable() {
					@Override
					public void run() {
						s4seb1.performClick();
					}
				});
			}
		}
		s4seb1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4seb1.setBackgroundResource(R.drawable.not_pressed);
					s4ser1 = 0;
					sharedPrefs241.edit().putBoolean("s2locked241", true)
							.commit();
				} else {
					s4seb1.setBackgroundResource(R.drawable.pressed);
					s4ser1 = 128;
					sharedPrefs241.edit().putBoolean("s2locked241", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs242 = PreferenceManager.getDefaultSharedPreferences(this);
		s4seb2 = (Button) findViewById(R.id.s4sebutton2);
		if (sharedPrefs242.getBoolean("s2locked242", true)) {
			s4seb2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4seb2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4seb2.post(new Runnable() {
					@Override
					public void run() {
						s4seb2.performClick();
					}
				});
			}
		}
		s4seb2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4seb2.setBackgroundResource(R.drawable.not_pressed);
					s4ser2 = 0;
					sharedPrefs242.edit().putBoolean("s2locked242", true)
							.commit();
				} else {
					s4seb2.setBackgroundResource(R.drawable.pressed);
					s4ser2 = 64;
					sharedPrefs242.edit().putBoolean("s2locked242", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs243 = PreferenceManager.getDefaultSharedPreferences(this);
		s4seb3 = (Button) findViewById(R.id.s4sebutton3);
		if (sharedPrefs243.getBoolean("s2locked243", true)) {
			s4seb3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4seb3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4seb3.post(new Runnable() {
					@Override
					public void run() {
						s4seb3.performClick();
					}
				});
			}
		}
		s4seb3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4seb3.setBackgroundResource(R.drawable.not_pressed);
					s4ser3 = 0;
					sharedPrefs243.edit().putBoolean("s2locked243", true)
							.commit();
				} else {
					s4seb3.setBackgroundResource(R.drawable.pressed);
					s4ser3 = 32;
					sharedPrefs243.edit().putBoolean("s2locked243", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs244 = PreferenceManager.getDefaultSharedPreferences(this);
		s4seb4 = (Button) findViewById(R.id.s4sebutton4);
		if (sharedPrefs244.getBoolean("s2locked244", true)) {
			s4seb4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4seb4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4seb4.post(new Runnable() {
					@Override
					public void run() {
						s4seb4.performClick();
					}
				});
			}
		}
		s4seb4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4seb4.setBackgroundResource(R.drawable.not_pressed);
					s4ser4 = 0;
					sharedPrefs244.edit().putBoolean("s2locked244", true)
							.commit();
				} else {
					s4seb4.setBackgroundResource(R.drawable.pressed);
					s4ser4 = 16;
					sharedPrefs244.edit().putBoolean("s2locked244", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs245 = PreferenceManager.getDefaultSharedPreferences(this);
		s4seb5 = (Button) findViewById(R.id.s4sebutton5);
		if (sharedPrefs245.getBoolean("s2locked245", true)) {
			s4seb5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4seb5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4seb5.post(new Runnable() {
					@Override
					public void run() {
						s4seb5.performClick();
					}
				});
			}
		}
		s4seb5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4seb5.setBackgroundResource(R.drawable.not_pressed);
					s4ser5 = 0;
					sharedPrefs245.edit().putBoolean("s2locked245", true)
							.commit();
				} else {
					s4seb5.setBackgroundResource(R.drawable.pressed);
					s4ser5 = 8;
					sharedPrefs245.edit().putBoolean("s2locked245", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs246 = PreferenceManager.getDefaultSharedPreferences(this);
		s4seb6 = (Button) findViewById(R.id.s4sebutton6);
		if (sharedPrefs246.getBoolean("s2locked246", true)) {
			s4seb6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4seb6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4seb6.post(new Runnable() {
					@Override
					public void run() {
						s4seb6.performClick();
					}
				});
			}
		}
		s4seb6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4seb6.setBackgroundResource(R.drawable.not_pressed);
					s4ser6 = 0;
					sharedPrefs246.edit().putBoolean("s2locked246", true)
							.commit();
				} else {
					s4seb6.setBackgroundResource(R.drawable.pressed);
					s4ser6 = 4;
					sharedPrefs246.edit().putBoolean("s2locked246", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs247 = PreferenceManager.getDefaultSharedPreferences(this);
		s4seb7 = (Button) findViewById(R.id.s4sebutton7);
		if (sharedPrefs247.getBoolean("s2locked247", true)) {
			s4seb7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4seb7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4seb7.post(new Runnable() {
					@Override
					public void run() {
						s4seb7.performClick();
					}
				});
			}
		}
		s4seb7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4seb7.setBackgroundResource(R.drawable.not_pressed);
					s4ser7 = 0;
					sharedPrefs247.edit().putBoolean("s2locked247", true)
							.commit();
				} else {
					s4seb7.setBackgroundResource(R.drawable.pressed);
					s4ser7 = 2;
					sharedPrefs247.edit().putBoolean("s2locked247", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs248 = PreferenceManager.getDefaultSharedPreferences(this);
		s4seb8 = (Button) findViewById(R.id.s4sebutton8);
		if (sharedPrefs248.getBoolean("s2locked248", true)) {
			s4seb8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4seb8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4seb8.post(new Runnable() {
					@Override
					public void run() {
						s4seb8.performClick();
					}
				});
			}
		}
		s4seb8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4seb8.setBackgroundResource(R.drawable.not_pressed);
					s4ser8 = 0;
					sharedPrefs248.edit().putBoolean("s2locked248", true)
							.commit();
				} else {
					s4seb8.setBackgroundResource(R.drawable.pressed);
					s4ser8 = 1;
					sharedPrefs248.edit().putBoolean("s2locked248", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------

		sharedPrefs249 = PreferenceManager.getDefaultSharedPreferences(this);
		s4eb1 = (Button) findViewById(R.id.s4ebutton1);
		if (sharedPrefs249.getBoolean("s2locked249", true)) {
			s4eb1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4eb1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4eb1.post(new Runnable() {
					@Override
					public void run() {
						s4eb1.performClick();
					}
				});
			}
		}
		s4eb1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4eb1.setBackgroundResource(R.drawable.not_pressed);
					s4er1 = 0;
					sharedPrefs249.edit().putBoolean("s2locked249", true)
							.commit();
				} else {
					s4eb1.setBackgroundResource(R.drawable.pressed);
					s4er1 = 128;
					sharedPrefs249.edit().putBoolean("s2locked249", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs250 = PreferenceManager.getDefaultSharedPreferences(this);
		s4eb2 = (Button) findViewById(R.id.s4ebutton2);
		if (sharedPrefs250.getBoolean("s2locked250", true)) {
			s4eb2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4eb2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4eb2.post(new Runnable() {
					@Override
					public void run() {
						s4eb2.performClick();
					}
				});
			}
		}
		s4eb2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4eb2.setBackgroundResource(R.drawable.not_pressed);
					s4er2 = 0;
					sharedPrefs250.edit().putBoolean("s2locked250", true)
							.commit();
				} else {
					s4eb2.setBackgroundResource(R.drawable.pressed);
					s4er2 = 64;
					sharedPrefs250.edit().putBoolean("s2locked250", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs251 = PreferenceManager.getDefaultSharedPreferences(this);
		s4eb3 = (Button) findViewById(R.id.s4ebutton3);
		if (sharedPrefs251.getBoolean("s2locked251", true)) {
			s4eb3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4eb3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4eb3.post(new Runnable() {
					@Override
					public void run() {
						s4eb3.performClick();
					}
				});
			}
		}
		s4eb3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4eb3.setBackgroundResource(R.drawable.not_pressed);
					s4er3 = 0;
					sharedPrefs251.edit().putBoolean("s2locked251", true)
							.commit();
				} else {
					s4eb3.setBackgroundResource(R.drawable.pressed);
					s4er3 = 32;
					sharedPrefs251.edit().putBoolean("s2locked251", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs252 = PreferenceManager.getDefaultSharedPreferences(this);
		s4eb4 = (Button) findViewById(R.id.s4ebutton4);
		if (sharedPrefs252.getBoolean("s2locked252", true)) {
			s4eb4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4eb4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4eb4.post(new Runnable() {
					@Override
					public void run() {
						s4eb4.performClick();
					}
				});
			}
		}
		s4eb4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4eb4.setBackgroundResource(R.drawable.not_pressed);
					s4er4 = 0;
					sharedPrefs252.edit().putBoolean("s2locked252", true)
							.commit();
				} else {
					s4eb4.setBackgroundResource(R.drawable.pressed);
					s4er4 = 16;
					sharedPrefs252.edit().putBoolean("s2locked252", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs253 = PreferenceManager.getDefaultSharedPreferences(this);
		s4eb5 = (Button) findViewById(R.id.s4ebutton5);
		if (sharedPrefs253.getBoolean("s2locked253", true)) {
			s4eb5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4eb5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4eb5.post(new Runnable() {
					@Override
					public void run() {
						s4eb5.performClick();
					}
				});
			}
		}
		s4eb5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4eb5.setBackgroundResource(R.drawable.not_pressed);
					s4er5 = 0;
					sharedPrefs253.edit().putBoolean("s2locked253", true)
							.commit();
				} else {
					s4eb5.setBackgroundResource(R.drawable.pressed);
					s4er5 = 8;
					sharedPrefs253.edit().putBoolean("s2locked253", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs254 = PreferenceManager.getDefaultSharedPreferences(this);
		s4eb6 = (Button) findViewById(R.id.s4ebutton6);
		if (sharedPrefs254.getBoolean("s2locked254", true)) {
			s4eb6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4eb6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4eb6.post(new Runnable() {
					@Override
					public void run() {
						s4eb6.performClick();
					}
				});
			}
		}
		s4eb6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4eb6.setBackgroundResource(R.drawable.not_pressed);
					s4er6 = 0;
					sharedPrefs254.edit().putBoolean("s2locked254", true)
							.commit();
				} else {
					s4eb6.setBackgroundResource(R.drawable.pressed);
					s4er6 = 4;
					sharedPrefs254.edit().putBoolean("s2locked254", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs255 = PreferenceManager.getDefaultSharedPreferences(this);
		s4eb7 = (Button) findViewById(R.id.s4ebutton7);
		if (sharedPrefs255.getBoolean("s2locked255", true)) {
			s4eb7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4eb7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4eb7.post(new Runnable() {
					@Override
					public void run() {
						s4eb7.performClick();
					}
				});
			}
		}
		s4eb7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4eb7.setBackgroundResource(R.drawable.not_pressed);
					s4er7 = 0;
					sharedPrefs255.edit().putBoolean("s2locked255", true)
							.commit();
				} else {
					s4eb7.setBackgroundResource(R.drawable.pressed);
					s4er7 = 2;
					sharedPrefs255.edit().putBoolean("s2locked255", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs256 = PreferenceManager.getDefaultSharedPreferences(this);
		s4eb8 = (Button) findViewById(R.id.s4ebutton8);
		if (sharedPrefs256.getBoolean("s2locked256", true)) {
			s4eb8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s4eb8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s4eb8.post(new Runnable() {
					@Override
					public void run() {
						s4eb8.performClick();
					}
				});
			}
		}
		s4eb8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s4eb8.setBackgroundResource(R.drawable.not_pressed);
					s4er8 = 0;
					sharedPrefs256.edit().putBoolean("s2locked256", true)
							.commit();
				} else {
					s4eb8.setBackgroundResource(R.drawable.pressed);
					s4er8 = 1;
					sharedPrefs256.edit().putBoolean("s2locked256", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// 5st
		// square------------------------------------------------------------------------------
		// ----------------------------------------------------------------------------------------
		sharedPrefs257 = PreferenceManager.getDefaultSharedPreferences(this);
		s5fb1 = (Button) findViewById(R.id.s5button1);
		if (sharedPrefs257.getBoolean("s2locked257", true)) {
			s5fb1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5fb1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5fb1.post(new Runnable() {
					@Override
					public void run() {
						s5fb1.performClick();
					}
				});
			}
		}
		s5fb1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {

				if (!isPressed) {
					s5fb1.setBackgroundResource(R.drawable.not_pressed);
					s5fr1 = 0;
					sharedPrefs257.edit().putBoolean("s2locked257", true)
							.commit();
					System.out.println("lock to true");

				} else {
					s5fb1.setBackgroundResource(R.drawable.pressed);
					s5fr1 = 128;
					// fb1.setSelected(true);
					// fb1.setPressed(true);
					sharedPrefs257.edit().putBoolean("s2locked257", false)
							.commit();
					System.out.println("lock to false");
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs258 = PreferenceManager.getDefaultSharedPreferences(this);
		s5fb2 = (Button) findViewById(R.id.s5button2);
		if (sharedPrefs258.getBoolean("s2locked258", true)) {
			s5fb2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5fb2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5fb2.post(new Runnable() {
					@Override
					public void run() {
						s5fb2.performClick();
					}
				});
			}
		}
		s5fb2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5fb2.setBackgroundResource(R.drawable.not_pressed);
					s5fr2 = 0;
					sharedPrefs258.edit().putBoolean("s2locked258", true)
							.commit();
				} else {
					s5fb2.setBackgroundResource(R.drawable.pressed);
					s5fr2 = 64;
					sharedPrefs258.edit().putBoolean("s2locked258", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs259 = PreferenceManager.getDefaultSharedPreferences(this);
		s5fb3 = (Button) findViewById(R.id.s5button3);
		if (sharedPrefs259.getBoolean("s2locked259", true)) {
			s5fb3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5fb3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5fb3.post(new Runnable() {
					@Override
					public void run() {
						s5fb3.performClick();
					}
				});
			}
		}
		s5fb3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5fb3.setBackgroundResource(R.drawable.not_pressed);
					s5fr3 = 0;
					sharedPrefs259.edit().putBoolean("s2locked259", true)
							.commit();
				} else {
					s5fb3.setBackgroundResource(R.drawable.pressed);
					s5fr3 = 32;
					sharedPrefs259.edit().putBoolean("s2locked259", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs260 = PreferenceManager.getDefaultSharedPreferences(this);
		s5fb4 = (Button) findViewById(R.id.s5button4);
		if (sharedPrefs260.getBoolean("s2locked260", true)) {
			s5fb4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5fb4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5fb4.post(new Runnable() {
					@Override
					public void run() {
						s5fb4.performClick();
					}
				});
			}
		}
		s5fb4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5fb4.setBackgroundResource(R.drawable.not_pressed);
					s5fr4 = 0;
					sharedPrefs260.edit().putBoolean("s2locked260", true)
							.commit();
				} else {
					s5fb4.setBackgroundResource(R.drawable.pressed);
					s5fr4 = 16;
					sharedPrefs260.edit().putBoolean("s2locked260", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs261 = PreferenceManager.getDefaultSharedPreferences(this);
		s5fb5 = (Button) findViewById(R.id.s5button5);
		if (sharedPrefs261.getBoolean("s2locked261", true)) {
			s5fb5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5fb5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5fb5.post(new Runnable() {
					@Override
					public void run() {
						s5fb5.performClick();
					}
				});
			}
		}
		s5fb5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5fb5.setBackgroundResource(R.drawable.not_pressed);
					s5fr5 = 0;
					sharedPrefs261.edit().putBoolean("s2locked261", true)
							.commit();
				} else {
					s5fb5.setBackgroundResource(R.drawable.pressed);
					s5fr5 = 8;
					sharedPrefs261.edit().putBoolean("s2locked261", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs262 = PreferenceManager.getDefaultSharedPreferences(this);
		s5fb6 = (Button) findViewById(R.id.s5button6);
		if (sharedPrefs262.getBoolean("s2locked262", true)) {
			s5fb6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5fb6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5fb6.post(new Runnable() {
					@Override
					public void run() {
						s5fb6.performClick();
					}
				});
			}
		}
		s5fb6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5fb6.setBackgroundResource(R.drawable.not_pressed);
					s5fr6 = 0;
					sharedPrefs262.edit().putBoolean("s2locked262", true)
							.commit();
				} else {
					s5fb6.setBackgroundResource(R.drawable.pressed);
					s5fr6 = 4;
					sharedPrefs262.edit().putBoolean("s2locked262", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs263 = PreferenceManager.getDefaultSharedPreferences(this);
		s5fb7 = (Button) findViewById(R.id.s5button7);
		if (sharedPrefs263.getBoolean("s2locked263", true)) {
			s5fb7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5fb7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5fb7.post(new Runnable() {
					@Override
					public void run() {
						s5fb7.performClick();
					}
				});
			}
		}
		s5fb7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5fb7.setBackgroundResource(R.drawable.not_pressed);
					s5fr7 = 0;
					sharedPrefs263.edit().putBoolean("s2locked263", true)
							.commit();
				} else {
					s5fb7.setBackgroundResource(R.drawable.pressed);
					s5fr7 = 2;
					sharedPrefs263.edit().putBoolean("s2locked263", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs264 = PreferenceManager.getDefaultSharedPreferences(this);
		s5fb8 = (Button) findViewById(R.id.s5button8);
		if (sharedPrefs264.getBoolean("s2locked264", true)) {
			s5fb8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5fb8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5fb8.post(new Runnable() {
					@Override
					public void run() {
						s5fb8.performClick();
					}
				});
			}
		}
		s5fb8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5fb8.setBackgroundResource(R.drawable.not_pressed);
					s5fr8 = 0;
					sharedPrefs264.edit().putBoolean("s2locked264", true)
							.commit();
				} else {
					s5fb8.setBackgroundResource(R.drawable.pressed);
					s5fr8 = 1;
					sharedPrefs264.edit().putBoolean("s2locked264", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------

		sharedPrefs265 = PreferenceManager.getDefaultSharedPreferences(this);
		s5sb1 = (Button) findViewById(R.id.s5sbutton1);
		if (sharedPrefs265.getBoolean("s2locked265", true)) {
			s5sb1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5sb1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5sb1.post(new Runnable() {
					@Override
					public void run() {
						s5sb1.performClick();
					}
				});
			}
		}
		s5sb1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5sb1.setBackgroundResource(R.drawable.not_pressed);
					s5sr1 = 0;
					sharedPrefs265.edit().putBoolean("s2locked265", true)
							.commit();
				} else {
					s5sb1.setBackgroundResource(R.drawable.pressed);
					s5sr1 = 128;
					sharedPrefs265.edit().putBoolean("s2locked265", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs266 = PreferenceManager.getDefaultSharedPreferences(this);
		s5sb2 = (Button) findViewById(R.id.s5sbutton2);
		if (sharedPrefs266.getBoolean("s2locked266", true)) {
			s5sb2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5sb2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5sb2.post(new Runnable() {
					@Override
					public void run() {
						s5sb2.performClick();
					}
				});
			}
		}
		s5sb2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5sb2.setBackgroundResource(R.drawable.not_pressed);
					s5sr2 = 0;
					sharedPrefs266.edit().putBoolean("s2locked266", true)
							.commit();
				} else {
					s5sb2.setBackgroundResource(R.drawable.pressed);
					s5sr2 = 64;
					sharedPrefs266.edit().putBoolean("s2locked266", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs267 = PreferenceManager.getDefaultSharedPreferences(this);
		s5sb3 = (Button) findViewById(R.id.s5sbutton3);
		if (sharedPrefs267.getBoolean("s2locked267", true)) {
			s5sb3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5sb3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5sb3.post(new Runnable() {
					@Override
					public void run() {
						s5sb3.performClick();
					}
				});
			}
		}
		s5sb3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5sb3.setBackgroundResource(R.drawable.not_pressed);
					s5sr3 = 0;
					sharedPrefs267.edit().putBoolean("s2locked267", true)
							.commit();
				} else {
					s5sb3.setBackgroundResource(R.drawable.pressed);
					s5sr3 = 32;
					sharedPrefs267.edit().putBoolean("s2locked267", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs268 = PreferenceManager.getDefaultSharedPreferences(this);
		s5sb4 = (Button) findViewById(R.id.s5sbutton4);
		if (sharedPrefs268.getBoolean("s2locked268", true)) {
			s5sb4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5sb4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5sb4.post(new Runnable() {
					@Override
					public void run() {
						s5sb4.performClick();
					}
				});
			}
		}
		s5sb4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5sb4.setBackgroundResource(R.drawable.not_pressed);
					s5sr4 = 0;
					sharedPrefs268.edit().putBoolean("s2locked268", true)
							.commit();
				} else {
					s5sb4.setBackgroundResource(R.drawable.pressed);
					s5sr4 = 16;
					sharedPrefs268.edit().putBoolean("s2locked268", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs269 = PreferenceManager.getDefaultSharedPreferences(this);
		s5sb5 = (Button) findViewById(R.id.s5sbutton5);
		if (sharedPrefs269.getBoolean("s2locked269", true)) {
			s5sb5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5sb5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5sb5.post(new Runnable() {
					@Override
					public void run() {
						s5sb5.performClick();
					}
				});
			}
		}
		s5sb5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5sb5.setBackgroundResource(R.drawable.not_pressed);
					s5sr5 = 0;
					sharedPrefs269.edit().putBoolean("s2locked269", true)
							.commit();
				} else {
					s5sb5.setBackgroundResource(R.drawable.pressed);
					s5sr5 = 8;
					sharedPrefs269.edit().putBoolean("s2locked269", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs270 = PreferenceManager.getDefaultSharedPreferences(this);
		s5sb6 = (Button) findViewById(R.id.s5sbutton6);
		if (sharedPrefs270.getBoolean("s2locked270", true)) {
			s5sb6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5sb6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5sb6.post(new Runnable() {
					@Override
					public void run() {
						s5sb6.performClick();
					}
				});
			}
		}
		s5sb6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5sb6.setBackgroundResource(R.drawable.not_pressed);
					s5sr6 = 0;
					sharedPrefs270.edit().putBoolean("s2locked270", true)
							.commit();
				} else {
					s5sb6.setBackgroundResource(R.drawable.pressed);
					s5sr6 = 4;
					sharedPrefs270.edit().putBoolean("s2locked270", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs271 = PreferenceManager.getDefaultSharedPreferences(this);
		s5sb7 = (Button) findViewById(R.id.s5sbutton7);
		if (sharedPrefs271.getBoolean("s2locked271", true)) {
			s5sb7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5sb7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5sb7.post(new Runnable() {
					@Override
					public void run() {
						s5sb7.performClick();
					}
				});
			}
		}
		s5sb7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5sb7.setBackgroundResource(R.drawable.not_pressed);
					s5sr7 = 0;
					sharedPrefs271.edit().putBoolean("s2locked271", true)
							.commit();
				} else {
					s5sb7.setBackgroundResource(R.drawable.pressed);
					s5sr7 = 2;
					sharedPrefs271.edit().putBoolean("s2locked271", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs272 = PreferenceManager.getDefaultSharedPreferences(this);
		s5sb8 = (Button) findViewById(R.id.s5sbutton8);
		if (sharedPrefs272.getBoolean("s2locked272", true)) {
			s5sb8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5sb8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5sb8.post(new Runnable() {
					@Override
					public void run() {
						s5sb8.performClick();
					}
				});
			}
		}
		s5sb8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5sb8.setBackgroundResource(R.drawable.not_pressed);
					s5sr8 = 0;
					sharedPrefs272.edit().putBoolean("s2locked272", true)
							.commit();
				} else {
					s5sb8.setBackgroundResource(R.drawable.pressed);
					s5sr8 = 1;
					sharedPrefs272.edit().putBoolean("s2locked272", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// ------------------------------------------------------------------------------------

		sharedPrefs273 = PreferenceManager.getDefaultSharedPreferences(this);
		s5tb1 = (Button) findViewById(R.id.s5tbutton1);
		if (sharedPrefs273.getBoolean("s2locked273", true)) {
			s5tb1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5tb1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5tb1.post(new Runnable() {
					@Override
					public void run() {
						s5tb1.performClick();
					}
				});
			}
		}
		s5tb1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5tb1.setBackgroundResource(R.drawable.not_pressed);
					s5tr1 = 0;
					sharedPrefs273.edit().putBoolean("s2locked273", true)
							.commit();
				} else {
					s5tb1.setBackgroundResource(R.drawable.pressed);
					s5tr1 = 128;
					sharedPrefs273.edit().putBoolean("s2locked273", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs274 = PreferenceManager.getDefaultSharedPreferences(this);
		s5tb2 = (Button) findViewById(R.id.s5tbutton2);
		if (sharedPrefs274.getBoolean("s2locked274", true)) {
			s5tb2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5tb2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5tb2.post(new Runnable() {
					@Override
					public void run() {
						s5tb2.performClick();
					}
				});
			}
		}
		s5tb2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5tb2.setBackgroundResource(R.drawable.not_pressed);
					s5tr2 = 0;
					sharedPrefs274.edit().putBoolean("s2locked274", true)
							.commit();
				} else {
					s5tb2.setBackgroundResource(R.drawable.pressed);
					s5tr2 = 64;
					sharedPrefs274.edit().putBoolean("s2locked274", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs275 = PreferenceManager.getDefaultSharedPreferences(this);
		s5tb3 = (Button) findViewById(R.id.s5tbutton3);
		if (sharedPrefs275.getBoolean("s2locked275", true)) {
			s5tb3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5tb3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5tb3.post(new Runnable() {
					@Override
					public void run() {
						s5tb3.performClick();
					}
				});
			}
		}
		s5tb3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5tb3.setBackgroundResource(R.drawable.not_pressed);
					s5tr3 = 0;
					sharedPrefs275.edit().putBoolean("s2locked275", true)
							.commit();
				} else {
					s5tb3.setBackgroundResource(R.drawable.pressed);
					s5tr3 = 32;
					sharedPrefs275.edit().putBoolean("s2locked275", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs276 = PreferenceManager.getDefaultSharedPreferences(this);
		s5tb4 = (Button) findViewById(R.id.s5tbutton4);
		if (sharedPrefs276.getBoolean("s2locked276", true)) {
			s5tb4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5tb4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5tb4.post(new Runnable() {
					@Override
					public void run() {
						s5tb4.performClick();
					}
				});
			}
		}
		s5tb4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5tb4.setBackgroundResource(R.drawable.not_pressed);
					s5tr4 = 0;
					sharedPrefs276.edit().putBoolean("s2locked276", true)
							.commit();
				} else {
					s5tb4.setBackgroundResource(R.drawable.pressed);
					s5tr4 = 16;
					sharedPrefs276.edit().putBoolean("s2locked276", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs277 = PreferenceManager.getDefaultSharedPreferences(this);
		s5tb5 = (Button) findViewById(R.id.s5tbutton5);
		if (sharedPrefs277.getBoolean("s2locked277", true)) {
			s5tb5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5tb5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5tb5.post(new Runnable() {
					@Override
					public void run() {
						s5tb5.performClick();
					}
				});
			}
		}
		s5tb5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5tb5.setBackgroundResource(R.drawable.not_pressed);
					s5tr5 = 0;
					sharedPrefs277.edit().putBoolean("s2locked277", true)
							.commit();
				} else {
					s5tb5.setBackgroundResource(R.drawable.pressed);
					s5tr5 = 8;
					sharedPrefs277.edit().putBoolean("s2locked277", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs278 = PreferenceManager.getDefaultSharedPreferences(this);
		s5tb6 = (Button) findViewById(R.id.s5tbutton6);
		if (sharedPrefs278.getBoolean("s2locked278", true)) {
			s5tb6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5tb6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5tb6.post(new Runnable() {
					@Override
					public void run() {
						s5tb6.performClick();
					}
				});
			}
		}
		s5tb6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5tb6.setBackgroundResource(R.drawable.not_pressed);
					s5tr6 = 0;
					sharedPrefs278.edit().putBoolean("s2locked278", true)
							.commit();
				} else {
					s5tb6.setBackgroundResource(R.drawable.pressed);
					s5tr6 = 4;
					sharedPrefs278.edit().putBoolean("s2locked278", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs279 = PreferenceManager.getDefaultSharedPreferences(this);
		s5tb7 = (Button) findViewById(R.id.s5tbutton7);
		if (sharedPrefs279.getBoolean("s2locked279", true)) {
			s5tb7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5tb7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5tb7.post(new Runnable() {
					@Override
					public void run() {
						s5tb7.performClick();
					}
				});
			}
		}
		s5tb7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5tb7.setBackgroundResource(R.drawable.not_pressed);
					s5tr7 = 0;
					sharedPrefs279.edit().putBoolean("s2locked279", true)
							.commit();
				} else {
					s5tb7.setBackgroundResource(R.drawable.pressed);
					s5tr7 = 2;
					sharedPrefs279.edit().putBoolean("s2locked279", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs280 = PreferenceManager.getDefaultSharedPreferences(this);
		s5tb8 = (Button) findViewById(R.id.s5tbutton8);
		if (sharedPrefs280.getBoolean("s2locked280", true)) {
			s5tb8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5tb8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5tb8.post(new Runnable() {
					@Override
					public void run() {
						s5tb8.performClick();
					}
				});
			}
		}
		s5tb8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5tb8.setBackgroundResource(R.drawable.not_pressed);
					s5tr8 = 0;
					sharedPrefs280.edit().putBoolean("s2locked280", true)
							.commit();
				} else {
					s5tb8.setBackgroundResource(R.drawable.pressed);
					s5tr8 = 1;
					sharedPrefs280.edit().putBoolean("s2locked280", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// ------------------------------------------------------------------------------------

		sharedPrefs281 = PreferenceManager.getDefaultSharedPreferences(this);
		s5fob1 = (Button) findViewById(R.id.s5fobutton1);
		if (sharedPrefs281.getBoolean("s2locked281", true)) {
			s5fob1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5fob1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5fob1.post(new Runnable() {
					@Override
					public void run() {
						s5fob1.performClick();
					}
				});
			}
		}
		s5fob1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5fob1.setBackgroundResource(R.drawable.not_pressed);
					s5for1 = 0;
					sharedPrefs281.edit().putBoolean("s2locked281", true)
							.commit();
				} else {
					s5fob1.setBackgroundResource(R.drawable.pressed);
					s5for1 = 128;
					sharedPrefs281.edit().putBoolean("s2locked281", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs282 = PreferenceManager.getDefaultSharedPreferences(this);
		s5fob2 = (Button) findViewById(R.id.s5fobutton2);
		if (sharedPrefs282.getBoolean("s2locked282", true)) {
			s5fob2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5fob2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5fob2.post(new Runnable() {
					@Override
					public void run() {
						s5fob2.performClick();
					}
				});
			}
		}
		s5fob2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5fob2.setBackgroundResource(R.drawable.not_pressed);
					s5for2 = 0;
					sharedPrefs282.edit().putBoolean("s2locked282", true)
							.commit();
				} else {
					s5fob2.setBackgroundResource(R.drawable.pressed);
					s5for2 = 64;
					sharedPrefs282.edit().putBoolean("s2locked282", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs283 = PreferenceManager.getDefaultSharedPreferences(this);
		s5fob3 = (Button) findViewById(R.id.s5fobutton3);
		if (sharedPrefs283.getBoolean("s2locked283", true)) {
			s5fob3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5fob3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5fob3.post(new Runnable() {
					@Override
					public void run() {
						s5fob3.performClick();
					}
				});
			}
		}
		s5fob3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5fob3.setBackgroundResource(R.drawable.not_pressed);
					s5for3 = 0;
					sharedPrefs283.edit().putBoolean("s2locked283", true)
							.commit();
				} else {
					s5fob3.setBackgroundResource(R.drawable.pressed);
					s5for3 = 32;
					sharedPrefs283.edit().putBoolean("s2locked283", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs284 = PreferenceManager.getDefaultSharedPreferences(this);
		s5fob4 = (Button) findViewById(R.id.s5fobutton4);
		if (sharedPrefs284.getBoolean("s2locked284", true)) {
			s5fob4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5fob4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5fob4.post(new Runnable() {
					@Override
					public void run() {
						s5fob4.performClick();
					}
				});
			}
		}
		s5fob4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5fob4.setBackgroundResource(R.drawable.not_pressed);
					s5for4 = 0;
					sharedPrefs284.edit().putBoolean("s2locked284", true)
							.commit();
				} else {
					s5fob4.setBackgroundResource(R.drawable.pressed);
					s5for4 = 16;
					sharedPrefs284.edit().putBoolean("s2locked284", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs285 = PreferenceManager.getDefaultSharedPreferences(this);
		s5fob5 = (Button) findViewById(R.id.s5fobutton5);
		if (sharedPrefs285.getBoolean("s2locked285", true)) {
			s5fob5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5fob5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5fob5.post(new Runnable() {
					@Override
					public void run() {
						s5fob5.performClick();
					}
				});
			}
		}
		s5fob5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5fob5.setBackgroundResource(R.drawable.not_pressed);
					s5for5 = 0;
					sharedPrefs285.edit().putBoolean("s2locked285", true)
							.commit();
				} else {
					s5fob5.setBackgroundResource(R.drawable.pressed);
					for5 = 8;
					sharedPrefs285.edit().putBoolean("s2locked285", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs286 = PreferenceManager.getDefaultSharedPreferences(this);
		s5fob6 = (Button) findViewById(R.id.s5fobutton6);
		if (sharedPrefs286.getBoolean("s2locked286", true)) {
			s5fob6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5fob6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5fob6.post(new Runnable() {
					@Override
					public void run() {
						s5fob6.performClick();
					}
				});
			}
		}
		s5fob6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5fob6.setBackgroundResource(R.drawable.not_pressed);
					s5for6 = 0;
					sharedPrefs286.edit().putBoolean("s2locked286", true)
							.commit();
				} else {
					s5fob6.setBackgroundResource(R.drawable.pressed);
					s5for6 = 4;
					sharedPrefs286.edit().putBoolean("s2locked286", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs287 = PreferenceManager.getDefaultSharedPreferences(this);
		s5fob7 = (Button) findViewById(R.id.s5fobutton7);
		if (sharedPrefs287.getBoolean("s2locked287", true)) {
			s5fob7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5fob7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5fob7.post(new Runnable() {
					@Override
					public void run() {
						s5fob7.performClick();
					}
				});
			}
		}
		s5fob7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5fob7.setBackgroundResource(R.drawable.not_pressed);
					s5for7 = 0;
					sharedPrefs287.edit().putBoolean("s2locked287", true)
							.commit();
				} else {
					s5fob7.setBackgroundResource(R.drawable.pressed);
					s5for7 = 2;
					sharedPrefs287.edit().putBoolean("s2locked287", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs288 = PreferenceManager.getDefaultSharedPreferences(this);
		s5fob8 = (Button) findViewById(R.id.s5fobutton8);
		if (sharedPrefs288.getBoolean("s2locked288", true)) {
			s5fob8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5fob8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5fob8.post(new Runnable() {
					@Override
					public void run() {
						s5fob8.performClick();
					}
				});
			}
		}
		s5fob8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5fob8.setBackgroundResource(R.drawable.not_pressed);
					s5for8 = 0;
					sharedPrefs288.edit().putBoolean("s2locked288", true)
							.commit();
				} else {
					s5fob8.setBackgroundResource(R.drawable.pressed);
					s5for8 = 1;
					sharedPrefs288.edit().putBoolean("s2locked288", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// ------------------------------------------------------------------------------------

		sharedPrefs289 = PreferenceManager.getDefaultSharedPreferences(this);
		s5fib1 = (Button) findViewById(R.id.s5fibutton1);
		if (sharedPrefs289.getBoolean("s2locked289", true)) {
			s5fib1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5fib1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5fib1.post(new Runnable() {
					@Override
					public void run() {
						s5fib1.performClick();
					}
				});
			}
		}
		s5fib1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5fib1.setBackgroundResource(R.drawable.not_pressed);
					s5fir1 = 0;
					sharedPrefs289.edit().putBoolean("s2locked289", true)
							.commit();
				} else {
					s5fib1.setBackgroundResource(R.drawable.pressed);
					s5fir1 = 128;
					sharedPrefs289.edit().putBoolean("s2locked289", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs290 = PreferenceManager.getDefaultSharedPreferences(this);
		s5fib2 = (Button) findViewById(R.id.s5fibutton2);
		if (sharedPrefs290.getBoolean("s2locked290", true)) {
			s5fib2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5fib2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5fib2.post(new Runnable() {
					@Override
					public void run() {
						s5fib2.performClick();
					}
				});
			}
		}
		s5fib2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5fib2.setBackgroundResource(R.drawable.not_pressed);
					s5fir2 = 0;
					sharedPrefs290.edit().putBoolean("s2locked290", true)
							.commit();
				} else {
					s5fib2.setBackgroundResource(R.drawable.pressed);
					s5fir2 = 64;
					sharedPrefs290.edit().putBoolean("s2locked290", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs291 = PreferenceManager.getDefaultSharedPreferences(this);
		s5fib3 = (Button) findViewById(R.id.s5fibutton3);
		if (sharedPrefs291.getBoolean("s2locked291", true)) {
			s5fib3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5fib3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5fib3.post(new Runnable() {
					@Override
					public void run() {
						s5fib3.performClick();
					}
				});
			}
		}
		s5fib3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5fib3.setBackgroundResource(R.drawable.not_pressed);
					s5fir3 = 0;
					sharedPrefs291.edit().putBoolean("s2locked291", true)
							.commit();
				} else {
					s5fib3.setBackgroundResource(R.drawable.pressed);
					s5fir3 = 32;
					sharedPrefs291.edit().putBoolean("s2locked291", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs292 = PreferenceManager.getDefaultSharedPreferences(this);
		s5fib4 = (Button) findViewById(R.id.s5fibutton4);
		if (sharedPrefs292.getBoolean("s2locked292", true)) {
			s5fib4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5fib4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5fib4.post(new Runnable() {
					@Override
					public void run() {
						s5fib4.performClick();
					}
				});
			}
		}
		s5fib4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5fib4.setBackgroundResource(R.drawable.not_pressed);
					s5fir4 = 0;
					sharedPrefs292.edit().putBoolean("s2locked292", true)
							.commit();
				} else {
					s5fib4.setBackgroundResource(R.drawable.pressed);
					s5fir4 = 16;
					sharedPrefs292.edit().putBoolean("s2locked292", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs293 = PreferenceManager.getDefaultSharedPreferences(this);
		s5fib5 = (Button) findViewById(R.id.s5fibutton5);
		if (sharedPrefs293.getBoolean("s2locked293", true)) {
			s5fib5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5fib5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5fib5.post(new Runnable() {
					@Override
					public void run() {
						s5fib5.performClick();
					}
				});
			}
		}
		s5fib5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5fib5.setBackgroundResource(R.drawable.not_pressed);
					s5fir5 = 0;
					sharedPrefs293.edit().putBoolean("s2locked293", true)
							.commit();
				} else {
					s5fib5.setBackgroundResource(R.drawable.pressed);
					s5fir5 = 8;
					sharedPrefs293.edit().putBoolean("s2locked293", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs294 = PreferenceManager.getDefaultSharedPreferences(this);
		s5fib6 = (Button) findViewById(R.id.s5fibutton6);
		if (sharedPrefs294.getBoolean("s2locked294", true)) {
			s5fib6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5fib6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5fib6.post(new Runnable() {
					@Override
					public void run() {
						s5fib6.performClick();
					}
				});
			}
		}
		s5fib6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5fib6.setBackgroundResource(R.drawable.not_pressed);
					s5fir6 = 0;
					sharedPrefs294.edit().putBoolean("s2locked294", true)
							.commit();
				} else {
					s5fib6.setBackgroundResource(R.drawable.pressed);
					s5fir6 = 4;
					sharedPrefs294.edit().putBoolean("s2locked294", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs295 = PreferenceManager.getDefaultSharedPreferences(this);
		s5fib7 = (Button) findViewById(R.id.s5fibutton7);
		if (sharedPrefs295.getBoolean("s2locked295", true)) {
			s5fib7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5fib7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5fib7.post(new Runnable() {
					@Override
					public void run() {
						s5fib7.performClick();
					}
				});
			}
		}
		s5fib7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5fib7.setBackgroundResource(R.drawable.not_pressed);
					s5fir7 = 0;
					sharedPrefs295.edit().putBoolean("s2locked295", true)
							.commit();
				} else {
					s5fib7.setBackgroundResource(R.drawable.pressed);
					s5fir7 = 2;
					sharedPrefs295.edit().putBoolean("s2locked295", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs296 = PreferenceManager.getDefaultSharedPreferences(this);
		s5fib8 = (Button) findViewById(R.id.s5fibutton8);
		if (sharedPrefs296.getBoolean("s2locked296", true)) {
			s5fib8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5fib8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5fib8.post(new Runnable() {
					@Override
					public void run() {
						s5fib8.performClick();
					}
				});
			}
		}
		s5fib8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5fib8.setBackgroundResource(R.drawable.not_pressed);
					s5fir8 = 0;
					sharedPrefs296.edit().putBoolean("s2locked296", true)
							.commit();
				} else {
					s5fib8.setBackgroundResource(R.drawable.pressed);
					s5fir8 = 1;
					sharedPrefs296.edit().putBoolean("s2locked296", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------

		sharedPrefs297 = PreferenceManager.getDefaultSharedPreferences(this);
		s5sib1 = (Button) findViewById(R.id.s5sibutton1);
		if (sharedPrefs297.getBoolean("s2locked297", true)) {
			s5sib1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5sib1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5sib1.post(new Runnable() {
					@Override
					public void run() {
						s5sib1.performClick();
					}
				});
			}
		}
		s5sib1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5sib1.setBackgroundResource(R.drawable.not_pressed);
					s5sir1 = 0;
					sharedPrefs297.edit().putBoolean("s2locked297", true)
							.commit();
				} else {
					s5sib1.setBackgroundResource(R.drawable.pressed);
					s5sir1 = 128;
					sharedPrefs297.edit().putBoolean("s2locked297", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs298 = PreferenceManager.getDefaultSharedPreferences(this);
		s5sib2 = (Button) findViewById(R.id.s5sibutton2);
		if (sharedPrefs298.getBoolean("s2locked298", true)) {
			s5sib2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5sib2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5sib2.post(new Runnable() {
					@Override
					public void run() {
						s5sib2.performClick();
					}
				});
			}
		}
		s5sib2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5sib2.setBackgroundResource(R.drawable.not_pressed);
					s5sir2 = 0;
					sharedPrefs298.edit().putBoolean("s2locked298", true)
							.commit();
				} else {
					s5sib2.setBackgroundResource(R.drawable.pressed);
					s5sir2 = 64;
					sharedPrefs298.edit().putBoolean("s2locked298", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs299 = PreferenceManager.getDefaultSharedPreferences(this);
		s5sib3 = (Button) findViewById(R.id.s5sibutton3);
		if (sharedPrefs299.getBoolean("s2locked299", true)) {
			s5sib3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5sib3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5sib3.post(new Runnable() {
					@Override
					public void run() {
						s5sib3.performClick();
					}
				});
			}
		}
		s5sib3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5sib3.setBackgroundResource(R.drawable.not_pressed);
					s5sir3 = 0;
					sharedPrefs299.edit().putBoolean("s2locked299", true)
							.commit();
				} else {
					s5sib3.setBackgroundResource(R.drawable.pressed);
					s5sir3 = 32;
					sharedPrefs299.edit().putBoolean("s2locked299", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs300 = PreferenceManager.getDefaultSharedPreferences(this);
		s5sib4 = (Button) findViewById(R.id.s5sibutton4);
		if (sharedPrefs300.getBoolean("s2locked300", true)) {
			s5sib4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5sib4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5sib4.post(new Runnable() {
					@Override
					public void run() {
						s5sib4.performClick();
					}
				});
			}
		}
		s5sib4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5sib4.setBackgroundResource(R.drawable.not_pressed);
					s5sir4 = 0;
					sharedPrefs300.edit().putBoolean("s2locked300", true)
							.commit();
				} else {
					s5sib4.setBackgroundResource(R.drawable.pressed);
					s5sir4 = 16;
					sharedPrefs300.edit().putBoolean("s2locked300", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs301 = PreferenceManager.getDefaultSharedPreferences(this);
		s5sib5 = (Button) findViewById(R.id.s5sibutton5);
		if (sharedPrefs301.getBoolean("s2locked301", true)) {
			s5sib5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5sib5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5sib5.post(new Runnable() {
					@Override
					public void run() {
						s5sib5.performClick();
					}
				});
			}
		}
		s5sib5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5sib5.setBackgroundResource(R.drawable.not_pressed);
					s5sir5 = 0;
					sharedPrefs301.edit().putBoolean("s2locked301", true)
							.commit();
				} else {
					s5sib5.setBackgroundResource(R.drawable.pressed);
					s5sir5 = 8;
					sharedPrefs301.edit().putBoolean("s2locked301", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs302 = PreferenceManager.getDefaultSharedPreferences(this);
		s5sib6 = (Button) findViewById(R.id.s5sibutton6);
		if (sharedPrefs302.getBoolean("s2locked302", true)) {
			s5sib6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5sib6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5sib6.post(new Runnable() {
					@Override
					public void run() {
						s5sib6.performClick();
					}
				});
			}
		}
		s5sib6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5sib6.setBackgroundResource(R.drawable.not_pressed);
					s5sir6 = 0;
					sharedPrefs302.edit().putBoolean("s2locked302", true)
							.commit();
				} else {
					s5sib6.setBackgroundResource(R.drawable.pressed);
					s5sir6 = 4;
					sharedPrefs302.edit().putBoolean("s2locked302", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs303 = PreferenceManager.getDefaultSharedPreferences(this);
		s5sib7 = (Button) findViewById(R.id.s5sibutton7);
		if (sharedPrefs303.getBoolean("s2locked303", true)) {
			s5sib7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5sib7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5sib7.post(new Runnable() {
					@Override
					public void run() {
						s5sib7.performClick();
					}
				});
			}
		}
		s5sib7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5sib7.setBackgroundResource(R.drawable.not_pressed);
					s5sir7 = 0;
					sharedPrefs303.edit().putBoolean("s2locked303", true)
							.commit();
				} else {
					s5sib7.setBackgroundResource(R.drawable.pressed);
					s5sir7 = 2;
					sharedPrefs303.edit().putBoolean("s2locked303", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs304 = PreferenceManager.getDefaultSharedPreferences(this);
		s5sib8 = (Button) findViewById(R.id.s5sibutton8);
		if (sharedPrefs304.getBoolean("s2locked304", true)) {
			s5sib8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5sib8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5sib8.post(new Runnable() {
					@Override
					public void run() {
						s5sib8.performClick();
					}
				});
			}
		}
		s5sib8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5sib8.setBackgroundResource(R.drawable.not_pressed);
					s5sir8 = 0;
					sharedPrefs304.edit().putBoolean("s2locked304", true)
							.commit();
				} else {
					s5sib8.setBackgroundResource(R.drawable.pressed);
					s5sir8 = 1;
					sharedPrefs304.edit().putBoolean("s2locked304", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------

		sharedPrefs305 = PreferenceManager.getDefaultSharedPreferences(this);
		s5seb1 = (Button) findViewById(R.id.s5sebutton1);
		if (sharedPrefs305.getBoolean("s2locked305", true)) {
			s5seb1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5seb1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5seb1.post(new Runnable() {
					@Override
					public void run() {
						s5seb1.performClick();
					}
				});
			}
		}
		s5seb1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5seb1.setBackgroundResource(R.drawable.not_pressed);
					s5ser1 = 0;
					sharedPrefs305.edit().putBoolean("s2locked305", true)
							.commit();
				} else {
					s5seb1.setBackgroundResource(R.drawable.pressed);
					s5ser1 = 128;
					sharedPrefs305.edit().putBoolean("s2locked305", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs306 = PreferenceManager.getDefaultSharedPreferences(this);
		s5seb2 = (Button) findViewById(R.id.s5sebutton2);
		if (sharedPrefs306.getBoolean("s2locked306", true)) {
			s5seb2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5seb2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5seb2.post(new Runnable() {
					@Override
					public void run() {
						s5seb2.performClick();
					}
				});
			}
		}
		s5seb2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5seb2.setBackgroundResource(R.drawable.not_pressed);
					s5ser2 = 0;
					sharedPrefs306.edit().putBoolean("s2locked306", true)
							.commit();
				} else {
					s5seb2.setBackgroundResource(R.drawable.pressed);
					s5ser2 = 64;
					sharedPrefs306.edit().putBoolean("s2locked306", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs307 = PreferenceManager.getDefaultSharedPreferences(this);
		s5seb3 = (Button) findViewById(R.id.s5sebutton3);
		if (sharedPrefs307.getBoolean("s2locked307", true)) {
			s5seb3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5seb3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5seb3.post(new Runnable() {
					@Override
					public void run() {
						s5seb3.performClick();
					}
				});
			}
		}
		s5seb3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5seb3.setBackgroundResource(R.drawable.not_pressed);
					s5ser3 = 0;
					sharedPrefs307.edit().putBoolean("s2locked307", true)
							.commit();
				} else {
					s5seb3.setBackgroundResource(R.drawable.pressed);
					s5ser3 = 32;
					sharedPrefs307.edit().putBoolean("s2locked307", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs308 = PreferenceManager.getDefaultSharedPreferences(this);
		s5seb4 = (Button) findViewById(R.id.s5sebutton4);
		if (sharedPrefs308.getBoolean("s2locked308", true)) {
			s5seb4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5seb4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5seb4.post(new Runnable() {
					@Override
					public void run() {
						s5seb4.performClick();
					}
				});
			}
		}
		s5seb4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5seb4.setBackgroundResource(R.drawable.not_pressed);
					s5ser4 = 0;
					sharedPrefs308.edit().putBoolean("s2locked308", true)
							.commit();
				} else {
					s5seb4.setBackgroundResource(R.drawable.pressed);
					s5ser4 = 16;
					sharedPrefs308.edit().putBoolean("s2locked308", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs309 = PreferenceManager.getDefaultSharedPreferences(this);
		s5seb5 = (Button) findViewById(R.id.s5sebutton5);
		if (sharedPrefs309.getBoolean("s2locked309", true)) {
			s5seb5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5seb5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5seb5.post(new Runnable() {
					@Override
					public void run() {
						s5seb5.performClick();
					}
				});
			}
		}
		s5seb5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5seb5.setBackgroundResource(R.drawable.not_pressed);
					s5ser5 = 0;
					sharedPrefs309.edit().putBoolean("s2locked309", true)
							.commit();
				} else {
					s5seb5.setBackgroundResource(R.drawable.pressed);
					s5ser5 = 8;
					sharedPrefs309.edit().putBoolean("s2locked309", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs310 = PreferenceManager.getDefaultSharedPreferences(this);
		s5seb6 = (Button) findViewById(R.id.s5sebutton6);
		if (sharedPrefs310.getBoolean("s2locked310", true)) {
			s5seb6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5seb6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5seb6.post(new Runnable() {
					@Override
					public void run() {
						s5seb6.performClick();
					}
				});
			}
		}
		s5seb6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5seb6.setBackgroundResource(R.drawable.not_pressed);
					s5ser6 = 0;
					sharedPrefs310.edit().putBoolean("s2locked310", true)
							.commit();
				} else {
					s5seb6.setBackgroundResource(R.drawable.pressed);
					s5ser6 = 4;
					sharedPrefs310.edit().putBoolean("s2locked310", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs311 = PreferenceManager.getDefaultSharedPreferences(this);
		s5seb7 = (Button) findViewById(R.id.s5sebutton7);
		if (sharedPrefs311.getBoolean("s2locked311", true)) {
			s5seb7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5seb7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5seb7.post(new Runnable() {
					@Override
					public void run() {
						s5seb7.performClick();
					}
				});
			}
		}
		s5seb7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5seb7.setBackgroundResource(R.drawable.not_pressed);
					s5ser7 = 0;
					sharedPrefs311.edit().putBoolean("s2locked311", true)
							.commit();
				} else {
					s5seb7.setBackgroundResource(R.drawable.pressed);
					s5ser7 = 2;
					sharedPrefs311.edit().putBoolean("s2locked311", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs312 = PreferenceManager.getDefaultSharedPreferences(this);
		s5seb8 = (Button) findViewById(R.id.s5sebutton8);
		if (sharedPrefs312.getBoolean("s2locked312", true)) {
			s5seb8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5seb8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5seb8.post(new Runnable() {
					@Override
					public void run() {
						s5seb8.performClick();
					}
				});
			}
		}
		s5seb8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5seb8.setBackgroundResource(R.drawable.not_pressed);
					s5ser8 = 0;
					sharedPrefs312.edit().putBoolean("s2locked312", true)
							.commit();
				} else {
					s5seb8.setBackgroundResource(R.drawable.pressed);
					s5ser8 = 1;
					sharedPrefs312.edit().putBoolean("s2locked312", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------

		sharedPrefs313 = PreferenceManager.getDefaultSharedPreferences(this);
		s5eb1 = (Button) findViewById(R.id.s5ebutton1);
		if (sharedPrefs313.getBoolean("s2locked313", true)) {
			s5eb1.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5eb1.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5eb1.post(new Runnable() {
					@Override
					public void run() {
						s5eb1.performClick();
					}
				});
			}
		}
		s5eb1.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5eb1.setBackgroundResource(R.drawable.not_pressed);
					s5er1 = 0;
					sharedPrefs313.edit().putBoolean("s2locked313", true)
							.commit();
				} else {
					s5eb1.setBackgroundResource(R.drawable.pressed);
					s5er1 = 128;
					sharedPrefs313.edit().putBoolean("s2locked313", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs314 = PreferenceManager.getDefaultSharedPreferences(this);
		s5eb2 = (Button) findViewById(R.id.s5ebutton2);
		if (sharedPrefs314.getBoolean("s2locked314", true)) {
			s5eb2.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5eb2.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5eb2.post(new Runnable() {
					@Override
					public void run() {
						s5eb2.performClick();
					}
				});
			}
		}
		s5eb2.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5eb2.setBackgroundResource(R.drawable.not_pressed);
					s5er2 = 0;
					sharedPrefs314.edit().putBoolean("s2locked314", true)
							.commit();
				} else {
					s5eb2.setBackgroundResource(R.drawable.pressed);
					s5er2 = 64;
					sharedPrefs314.edit().putBoolean("s2locked314", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs315 = PreferenceManager.getDefaultSharedPreferences(this);
		s5eb3 = (Button) findViewById(R.id.s5ebutton3);
		if (sharedPrefs315.getBoolean("s2locked315", true)) {
			s5eb3.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5eb3.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5eb3.post(new Runnable() {
					@Override
					public void run() {
						s5eb3.performClick();
					}
				});
			}
		}
		s5eb3.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5eb3.setBackgroundResource(R.drawable.not_pressed);
					s5er3 = 0;
					sharedPrefs315.edit().putBoolean("s2locked315", true)
							.commit();
				} else {
					s5eb3.setBackgroundResource(R.drawable.pressed);
					s5er3 = 32;
					sharedPrefs315.edit().putBoolean("s2locked315", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs316 = PreferenceManager.getDefaultSharedPreferences(this);
		s5eb4 = (Button) findViewById(R.id.s5ebutton4);
		if (sharedPrefs316.getBoolean("s2locked316", true)) {
			s5eb4.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5eb4.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5eb4.post(new Runnable() {
					@Override
					public void run() {
						s5eb4.performClick();
					}
				});
			}
		}
		s5eb4.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5eb4.setBackgroundResource(R.drawable.not_pressed);
					s5er4 = 0;
					sharedPrefs316.edit().putBoolean("s2locked316", true)
							.commit();
				} else {
					s5eb4.setBackgroundResource(R.drawable.pressed);
					s5er4 = 16;
					sharedPrefs316.edit().putBoolean("s2locked316", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs317 = PreferenceManager.getDefaultSharedPreferences(this);
		s5eb5 = (Button) findViewById(R.id.s5ebutton5);
		if (sharedPrefs317.getBoolean("s2locked317", true)) {
			s5eb5.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5eb5.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5eb5.post(new Runnable() {
					@Override
					public void run() {
						s5eb5.performClick();
					}
				});
			}
		}
		s5eb5.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5eb5.setBackgroundResource(R.drawable.not_pressed);
					s5er5 = 0;
					sharedPrefs317.edit().putBoolean("s2locked317", true)
							.commit();
				} else {
					s5eb5.setBackgroundResource(R.drawable.pressed);
					s5er5 = 8;
					sharedPrefs317.edit().putBoolean("s2locked317", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs318 = PreferenceManager.getDefaultSharedPreferences(this);
		s5eb6 = (Button) findViewById(R.id.s5ebutton6);
		if (sharedPrefs318.getBoolean("s2locked318", true)) {
			s5eb6.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5eb6.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5eb6.post(new Runnable() {
					@Override
					public void run() {
						s5eb6.performClick();
					}
				});
			}
		}
		s5eb6.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5eb6.setBackgroundResource(R.drawable.not_pressed);
					s5er6 = 0;
					sharedPrefs318.edit().putBoolean("s2locked318", true)
							.commit();
				} else {
					s5eb6.setBackgroundResource(R.drawable.pressed);
					s5er6 = 4;
					sharedPrefs318.edit().putBoolean("s2locked318", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs319 = PreferenceManager.getDefaultSharedPreferences(this);
		s5eb7 = (Button) findViewById(R.id.s5ebutton7);
		if (sharedPrefs319.getBoolean("s2locked319", true)) {
			s5eb7.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5eb7.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5eb7.post(new Runnable() {
					@Override
					public void run() {
						s5eb7.performClick();
					}
				});
			}
		}
		s5eb7.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5eb7.setBackgroundResource(R.drawable.not_pressed);
					s5er7 = 0;
					sharedPrefs319.edit().putBoolean("s2locked319", true)
							.commit();
				} else {
					s5eb7.setBackgroundResource(R.drawable.pressed);
					s5er7 = 2;
					sharedPrefs319.edit().putBoolean("s2locked319", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		sharedPrefs320 = PreferenceManager.getDefaultSharedPreferences(this);
		s5eb8 = (Button) findViewById(R.id.s5ebutton8);
		if (sharedPrefs320.getBoolean("s2locked320", true)) {
			s5eb8.setBackgroundResource(R.drawable.not_pressed);
		} else {
			s5eb8.setBackgroundResource(R.drawable.pressed);
			if (tog > 0) {
				s5eb8.post(new Runnable() {
					@Override
					public void run() {
						s5eb8.performClick();
					}
				});
			}
		}
		s5eb8.setOnClickListener(new OnClickListener() {
			boolean isPressed = true;

			@Override
			public void onClick(View v) {
				if (!isPressed) {
					s5eb8.setBackgroundResource(R.drawable.not_pressed);
					s5er8 = 0;
					sharedPrefs320.edit().putBoolean("s2locked320", true)
							.commit();
				} else {
					s5eb8.setBackgroundResource(R.drawable.pressed);
					s5er8 = 1;
					sharedPrefs320.edit().putBoolean("s2locked320", false)
							.commit();
				}
				isPressed = !isPressed;
			}
		});
		
		Toast.makeText(getApplicationContext(),
				String.valueOf(allSum), Toast.LENGTH_SHORT).show();
		System.out.println("insideActallSum1" + allSum);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		if (id == R.id.store) {
			String store = String.valueOf(allSum);
			Log.e("allSumStore1",store);
			
			//1st square
			frs = fr1 + fr2 + fr3 + fr4 + fr5 + fr6 + fr7 + fr8;
			srs = sr1 + sr2 + sr3 + sr4 + sr5 + sr6 + sr7 + sr8;
			trs = tr1 + tr2 + tr3 + tr4 + tr5 + tr6 + tr7 + tr8;
			fors = for1 + for2 + for3 + for4 + for5 + for6 + for7 + for8;
			firs = fir1 + fir2 + fir3 + fir4 + fir5 + fir6 + fir7 + fir8;
			sirs = sir1 + sir2 + sir3 + sir4 + sir5 + sir6 + sir7 + sir8;
			sers = ser1 + ser2 + ser3 + ser4 + ser5 + ser6 + ser7 + ser8;
			ers = er1 + er2 + er3 + er4 + er5 + er6 + er7 + er8;

			// 2nd square
			s2frs = s2fr1 + s2fr2 + s2fr3 + s2fr4 + s2fr5 + s2fr6 + s2fr7
					+ s2fr8;
			s2srs = s2sr1 + s2sr2 + s2sr3 + s2sr4 + sr5 + s2sr6 + s2sr7 + s2sr8;
			s2trs = s2tr1 + s2tr2 + s2tr3 + s2tr4 + s2tr5 + s2tr6 + s2tr7
					+ s2tr8;
			s2fors = s2for1 + s2for2 + s2for3 + s2for4 + s2for5 + s2for6
					+ s2for7 + s2for8;
			s2firs = s2fir1 + s2fir2 + s2fir3 + s2fir4 + s2fir5 + s2fir6
					+ s2fir7 + s2fir8;
			s2sirs = s2sir1 + s2sir2 + s2sir3 + s2sir4 + s2sir5 + s2sir6
					+ s2sir7 + s2sir8;
			s2sers = s2ser1 + s2ser2 + s2ser3 + s2ser4 + s2ser5 + s2ser6
					+ s2ser7 + s2ser8;
			s2ers = s2er1 + s2er2 + s2er3 + s2er4 + s2er5 + s2er6 + s2er7
					+ s2er8;

			// 3rd square
			s3frs = s3fr1 + s3fr2 + s3fr3 + s3fr4 + s3fr5 + s3fr6 + s3fr7
					+ s3fr8;
			s3srs = s3sr1 + s3sr2 + s3sr3 + s3sr4 + s3sr5 + s3sr6 + s3sr7
					+ s3sr8;
			s3trs = s3tr1 + s3tr2 + s3tr3 + s3tr4 + s3tr5 + s3tr6 + s3tr7
					+ s3tr8;
			s3fors = s3for1 + s3for2 + s3for3 + s3for4 + s3for5 + s3for6
					+ s3for7 + s3for8;
			s3firs = s3fir1 + s3fir2 + s3fir3 + s3fir4 + s3fir5 + s3fir6
					+ s3fir7 + s3fir8;
			s3sirs = s3sir1 + s3sir2 + s3sir3 + s3sir4 + s3sir5 + s3sir6
					+ s3sir7 + s3sir8;
			s3sers = s3ser1 + s3ser2 + s3ser3 + s3ser4 + s3ser5 + s3ser6
					+ s3ser7 + s3ser8;
			s3ers = s3er1 + s3er2 + s3er3 + s3er4 + s3er5 + s3er6 + s3er7
					+ s3er8;

			// 4th square
			s4frs = s4fr1 + s4fr2 + s4fr3 + s4fr4 + s4fr5 + s4fr6 + s4fr7
					+ s4fr8;
			s4srs = s4sr1 + s4sr2 + s4sr3 + s4sr4 + s4sr5 + s4sr6 + s4sr7
					+ s4sr8;
			s4trs = s4tr1 + s4tr2 + s4tr3 + s4tr4 + s4tr5 + s4tr6 + s4tr7
					+ s4tr8;
			s4fors = s4for1 + s4for2 + s4for3 + s4for4 + s4for5 + s4for6
					+ s4for7 + s4for8;
			s4firs = s4fir1 + s4fir2 + s4fir3 + s4fir4 + s4fir5 + s4fir6
					+ s4fir7 + s4fir8;
			s4sirs = s4sir1 + s4sir2 + s4sir3 + s4sir4 + s4sir5 + s4sir6
					+ s4sir7 + s4sir8;
			s4sers = s4ser1 + s4ser2 + s4ser3 + s4ser4 + s4ser5 + s4ser6
					+ s4ser7 + s4ser8;
			s4ers = s4er1 + s4er2 + s4er3 + s4er4 + s4er5 + s4er6 + s4er7
					+ s4er8;

			// 5th square
			s5frs = s5fr1 + s5fr2 + s5fr3 + s5fr4 + s5fr5 + s5fr6 + s5fr7
					+ s5fr8;
			s5srs = s5sr1 + s5sr2 + s5sr3 + s5sr4 + s5sr5 + s5sr6 + s5sr7
					+ s5sr8;
			s5trs = s5tr1 + s5tr2 + s5tr3 + s5tr4 + s5tr5 + s5tr6 + s5tr7
					+ s5tr8;
			s5fors = s5for1 + s5for2 + s5for3 + s5for4 + s5for5 + s5for6
					+ s5for7 + s5for8;
			s5firs = s5fir1 + s5fir2 + s5fir3 + s5fir4 + s5fir5 + s5fir6
					+ s5fir7 + s5fir8;
			s5sirs = s5sir1 + s5sir2 + s5sir3 + s5sir4 + s5sir5 + s5sir6
					+ s5sir7 + s5sir8;
			s5sers = s5ser1 + s5ser2 + s5ser3 + s5ser4 + s5ser5 + s5ser6
					+ s5ser7 + s5ser8;
			s5ers = s5er1 + s5er2 + s5er3 + s5er4 + s5er5 + s5er6 + s5er7
					+ s5er8;

			square1 = new int[] { frs, srs, trs, fors, firs, sirs, sers, ers };
			square2 = new int[] { s2frs, s2srs, s2trs, s2fors, s2firs, s2sirs,
					s2sers, s2ers };
			square3 = new int[] { s3frs, s3srs, s3trs, s3fors, s3firs, s3sirs,
					s3sers, s3ers };
			square4 = new int[] { s4frs, s4srs, s4trs, s4fors, s4firs, s4sirs,
					s4sers, s4ers };
			square5 = new int[] { s5frs, s5srs, s5trs, s5fors, s5firs, s5sirs,
					s5sers, s5ers };

			allSum = frs + srs + trs + fors + firs + sirs + sers + ers + s2frs
					+ s2srs + s2trs + s2fors + s2firs + s2sirs + s2sers + s2ers
					+ s3frs + s3srs + s3trs + s3fors + s3firs + s3sirs + s3sers
					+ s3ers + s4frs + s4srs + s4trs + s4fors + s4firs + s4sirs
					+ s4sers + s4ers + s5frs + s5srs + s5trs + s5fors + s5firs
					+ s5sirs + s5sers + s5ers;

			if (refresh >= 1) {
				if (allSum == 0) {
					Toast.makeText(getApplicationContext(),
							"아무 버튼도 입력하지 않았습니다", Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(getApplicationContext(), "재입력되었습니다.",
							Toast.LENGTH_SHORT).show();

					adapter1.deletOneRecord2(del);
					Log.e("$$$", "REPstore");
					String strSquare1 = Integer.toString(frs);
					String strSquare2 = Integer.toString(srs);
					String strSquare3 = Integer.toString(trs);
					String strSquare4 = Integer.toString(fors);
					String strSquare5 = Integer.toString(firs);
					String strSquare6 = Integer.toString(sirs);
					String strSquare7 = Integer.toString(sers);
					String strSquare8 = Integer.toString(ers);

					String strSquare11 = Integer.toString(s2frs);
					String strSquare12 = Integer.toString(s2srs);
					String strSquare13 = Integer.toString(s2trs);
					String strSquare14 = Integer.toString(s2fors);
					String strSquare15 = Integer.toString(s2firs);
					String strSquare16 = Integer.toString(s2sirs);
					String strSquare17 = Integer.toString(s2sers);
					String strSquare18 = Integer.toString(s2ers);

					String strSquare21 = Integer.toString(s3frs);
					String strSquare22 = Integer.toString(s3srs);
					String strSquare23 = Integer.toString(s3trs);
					String strSquare24 = Integer.toString(s3fors);
					String strSquare25 = Integer.toString(s3firs);
					String strSquare26 = Integer.toString(s3sirs);
					String strSquare27 = Integer.toString(s3sers);
					String strSquare28 = Integer.toString(s3ers);

					String strSquare31 = Integer.toString(s4frs);
					String strSquare32 = Integer.toString(s4srs);
					String strSquare33 = Integer.toString(s4trs);
					String strSquare34 = Integer.toString(s4fors);
					String strSquare35 = Integer.toString(s4firs);
					String strSquare36 = Integer.toString(s4sirs);
					String strSquare37 = Integer.toString(s4sers);
					String strSquare38 = Integer.toString(s4ers);

					String strSquare41 = Integer.toString(s5frs);
					String strSquare42 = Integer.toString(s5srs);
					String strSquare43 = Integer.toString(s5trs);
					String strSquare44 = Integer.toString(s5fors);
					String strSquare45 = Integer.toString(s5firs);
					String strSquare46 = Integer.toString(s5sirs);
					String strSquare47 = Integer.toString(s5sers);
					String strSquare48 = Integer.toString(s5ers);
					long val = adapter1.insertDetails2(strSquare1, strSquare2,
							strSquare3, strSquare4, strSquare5, strSquare6,
							strSquare7, strSquare8, strSquare11, strSquare12,
							strSquare13, strSquare14, strSquare15, strSquare16,
							strSquare17, strSquare18, strSquare21, strSquare22,
							strSquare23, strSquare24, strSquare25, strSquare26,
							strSquare27, strSquare28, strSquare31, strSquare32,
							strSquare33, strSquare34, strSquare35, strSquare36,
							strSquare37, strSquare38, strSquare41, strSquare42,
							strSquare43, strSquare44, strSquare45, strSquare46,
							strSquare47, strSquare48);
					refresh++;
					del++;
					SharedPreferences preferences1 = PreferenceManager
							.getDefaultSharedPreferences(this);
					SharedPreferences.Editor editor = preferences1.edit();
					editor.putInt("first1", refresh);
					editor.putInt("first2", del);
					editor.putInt("allSum1", allSum);					
					editor.apply();
					System.out.println("REPrefresh" + refresh);
					System.out.println("REPdel" + del);
				}
			} else {
				if (allSum == 0) {
					Toast.makeText(getApplicationContext(),
							"아무 버튼도 입력하지 않았습니다", Toast.LENGTH_SHORT).show();

				} else {
					if (refresh == 0) {
						Toast.makeText(getApplicationContext(), "문구가 저장되었습니다.",
								Toast.LENGTH_SHORT).show();

						String strSquare1 = Integer.toString(frs);
						String strSquare2 = Integer.toString(srs);
						String strSquare3 = Integer.toString(trs);
						String strSquare4 = Integer.toString(fors);
						String strSquare5 = Integer.toString(firs);
						String strSquare6 = Integer.toString(sirs);
						String strSquare7 = Integer.toString(sers);
						String strSquare8 = Integer.toString(ers);

						String strSquare11 = Integer.toString(s2frs);
						String strSquare12 = Integer.toString(s2srs);
						String strSquare13 = Integer.toString(s2trs);
						String strSquare14 = Integer.toString(s2fors);
						String strSquare15 = Integer.toString(s2firs);
						String strSquare16 = Integer.toString(s2sirs);
						String strSquare17 = Integer.toString(s2sers);
						String strSquare18 = Integer.toString(s2ers);

						String strSquare21 = Integer.toString(s3frs);
						String strSquare22 = Integer.toString(s3srs);
						String strSquare23 = Integer.toString(s3trs);
						String strSquare24 = Integer.toString(s3fors);
						String strSquare25 = Integer.toString(s3firs);
						String strSquare26 = Integer.toString(s3sirs);
						String strSquare27 = Integer.toString(s3sers);
						String strSquare28 = Integer.toString(s3ers);

						String strSquare31 = Integer.toString(s4frs);
						String strSquare32 = Integer.toString(s4srs);
						String strSquare33 = Integer.toString(s4trs);
						String strSquare34 = Integer.toString(s4fors);
						String strSquare35 = Integer.toString(s4firs);
						String strSquare36 = Integer.toString(s4sirs);
						String strSquare37 = Integer.toString(s4sers);
						String strSquare38 = Integer.toString(s4ers);

						String strSquare41 = Integer.toString(s5frs);
						String strSquare42 = Integer.toString(s5srs);
						String strSquare43 = Integer.toString(s5trs);
						String strSquare44 = Integer.toString(s5fors);
						String strSquare45 = Integer.toString(s5firs);
						String strSquare46 = Integer.toString(s5sirs);
						String strSquare47 = Integer.toString(s5sers);
						String strSquare48 = Integer.toString(s5ers);
						long val = adapter1.insertDetails2(strSquare1,
								strSquare2, strSquare3, strSquare4, strSquare5,
								strSquare6, strSquare7, strSquare8,
								strSquare11, strSquare12, strSquare13,
								strSquare14, strSquare15, strSquare16,
								strSquare17, strSquare18, strSquare21,
								strSquare22, strSquare23, strSquare24,
								strSquare25, strSquare26, strSquare27,
								strSquare28, strSquare31, strSquare32,
								strSquare33, strSquare34, strSquare35,
								strSquare36, strSquare37, strSquare38,
								strSquare41, strSquare42, strSquare43,
								strSquare44, strSquare45, strSquare46,
								strSquare47, strSquare48);
						refresh++;
						del++;
						SharedPreferences preferences1 = PreferenceManager
								.getDefaultSharedPreferences(this);
						SharedPreferences.Editor editor = preferences1.edit();
						editor.putInt("first1", refresh);
						editor.putInt("first2", del);
						editor.putInt("allSum1", allSum);
						editor.apply();
					}
				}
			}
			return true;
		}

		if (id == R.id.reset) {
			String store = String.valueOf(allSum);
			Log.e("allSumReset1",store);

			if (refresh >= 1) {
				Toast.makeText(getApplicationContext(), "문구가 초기화되었습니다.",
						Toast.LENGTH_SHORT).show();
				adapter1.deletOneRecord2(del);

				refresh = 0;
				allSum = 0;
				SharedPreferences preferences2 = PreferenceManager
						.getDefaultSharedPreferences(this);
				SharedPreferences.Editor editor = preferences2.edit();
				editor.putInt("first1", refresh);
				editor.putInt("first2", del);
				editor.putInt("allSum1", allSum);
				editor.apply();

				Intent intent = getIntent();
				overridePendingTransition(0, 0);
				intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
				finish();

				overridePendingTransition(0, 0);
				startActivity(intent);

				sharedPrefs1.edit().putBoolean("s2locked1", true).commit();
				sharedPrefs2.edit().putBoolean("s2locked2", true).commit();
				sharedPrefs3.edit().putBoolean("s2locked3", true).commit();
				sharedPrefs4.edit().putBoolean("s2locked4", true).commit();
				sharedPrefs5.edit().putBoolean("s2locked5", true).commit();
				sharedPrefs6.edit().putBoolean("s2locked6", true).commit();
				sharedPrefs7.edit().putBoolean("s2locked7", true).commit();
				sharedPrefs8.edit().putBoolean("s2locked8", true).commit();
				sharedPrefs9.edit().putBoolean("s2locked9", true).commit();
				sharedPrefs10.edit().putBoolean("s2locked10", true).commit();
				sharedPrefs11.edit().putBoolean("s2locked11", true).commit();
				sharedPrefs12.edit().putBoolean("s2locked12", true).commit();
				sharedPrefs13.edit().putBoolean("s2locked13", true).commit();
				sharedPrefs14.edit().putBoolean("s2locked14", true).commit();
				sharedPrefs15.edit().putBoolean("s2locked15", true).commit();
				sharedPrefs16.edit().putBoolean("s2locked16", true).commit();
				sharedPrefs17.edit().putBoolean("s2locked17", true).commit();
				sharedPrefs18.edit().putBoolean("s2locked18", true).commit();
				sharedPrefs19.edit().putBoolean("s2locked19", true).commit();
				sharedPrefs20.edit().putBoolean("s2locked20", true).commit();
				sharedPrefs21.edit().putBoolean("s2locked21", true).commit();
				sharedPrefs22.edit().putBoolean("s2locked22", true).commit();
				sharedPrefs23.edit().putBoolean("s2locked23", true).commit();
				sharedPrefs24.edit().putBoolean("s2locked24", true).commit();
				sharedPrefs25.edit().putBoolean("s2locked25", true).commit();
				sharedPrefs26.edit().putBoolean("s2locked26", true).commit();
				sharedPrefs27.edit().putBoolean("s2locked27", true).commit();
				sharedPrefs28.edit().putBoolean("s2locked28", true).commit();
				sharedPrefs29.edit().putBoolean("s2locked29", true).commit();
				sharedPrefs30.edit().putBoolean("s2locked30", true).commit();
				sharedPrefs31.edit().putBoolean("s2locked31", true).commit();
				sharedPrefs32.edit().putBoolean("s2locked32", true).commit();
				sharedPrefs33.edit().putBoolean("s2locked33", true).commit();
				sharedPrefs34.edit().putBoolean("s2locked34", true).commit();
				sharedPrefs35.edit().putBoolean("s2locked35", true).commit();
				sharedPrefs36.edit().putBoolean("s2locked36", true).commit();
				sharedPrefs37.edit().putBoolean("s2locked37", true).commit();
				sharedPrefs38.edit().putBoolean("s2locked38", true).commit();
				sharedPrefs39.edit().putBoolean("s2locked39", true).commit();
				sharedPrefs40.edit().putBoolean("s2locked40", true).commit();
				sharedPrefs41.edit().putBoolean("s2locked41", true).commit();
				sharedPrefs42.edit().putBoolean("s2locked42", true).commit();
				sharedPrefs43.edit().putBoolean("s2locked43", true).commit();
				sharedPrefs44.edit().putBoolean("s2locked44", true).commit();
				sharedPrefs45.edit().putBoolean("s2locked45", true).commit();
				sharedPrefs46.edit().putBoolean("s2locked46", true).commit();
				sharedPrefs47.edit().putBoolean("s2locked47", true).commit();
				sharedPrefs48.edit().putBoolean("s2locked48", true).commit();
				sharedPrefs49.edit().putBoolean("s2locked49", true).commit();
				sharedPrefs50.edit().putBoolean("s2locked50", true).commit();
				sharedPrefs51.edit().putBoolean("s2locked51", true).commit();
				sharedPrefs52.edit().putBoolean("s2locked52", true).commit();
				sharedPrefs53.edit().putBoolean("s2locked53", true).commit();
				sharedPrefs54.edit().putBoolean("s2locked54", true).commit();
				sharedPrefs55.edit().putBoolean("s2locked55", true).commit();
				sharedPrefs56.edit().putBoolean("s2locked56", true).commit();
				sharedPrefs57.edit().putBoolean("s2locked57", true).commit();
				sharedPrefs58.edit().putBoolean("s2locked58", true).commit();
				sharedPrefs59.edit().putBoolean("s2locked59", true).commit();
				sharedPrefs60.edit().putBoolean("s2locked60", true).commit();
				sharedPrefs61.edit().putBoolean("s2locked61", true).commit();
				sharedPrefs62.edit().putBoolean("s2locked62", true).commit();
				sharedPrefs63.edit().putBoolean("s2locked63", true).commit();
				sharedPrefs64.edit().putBoolean("s2locked64", true).commit();
				sharedPrefs65.edit().putBoolean("s2locked65", true).commit();
				sharedPrefs66.edit().putBoolean("s2locked66", true).commit();
				sharedPrefs67.edit().putBoolean("s2locked67", true).commit();
				sharedPrefs68.edit().putBoolean("s2locked68", true).commit();
				sharedPrefs69.edit().putBoolean("s2locked69", true).commit();
				sharedPrefs70.edit().putBoolean("s2locked70", true).commit();
				sharedPrefs71.edit().putBoolean("s2locked71", true).commit();
				sharedPrefs72.edit().putBoolean("s2locked72", true).commit();
				sharedPrefs73.edit().putBoolean("s2locked73", true).commit();
				sharedPrefs74.edit().putBoolean("s2locked74", true).commit();
				sharedPrefs75.edit().putBoolean("s2locked75", true).commit();
				sharedPrefs76.edit().putBoolean("s2locked76", true).commit();
				sharedPrefs77.edit().putBoolean("s2locked77", true).commit();
				sharedPrefs78.edit().putBoolean("s2locked78", true).commit();
				sharedPrefs79.edit().putBoolean("s2locked79", true).commit();
				sharedPrefs80.edit().putBoolean("s2locked80", true).commit();
				sharedPrefs81.edit().putBoolean("s2locked81", true).commit();
				sharedPrefs82.edit().putBoolean("s2locked82", true).commit();
				sharedPrefs83.edit().putBoolean("s2locked83", true).commit();
				sharedPrefs84.edit().putBoolean("s2locked84", true).commit();
				sharedPrefs85.edit().putBoolean("s2locked85", true).commit();
				sharedPrefs86.edit().putBoolean("s2locked86", true).commit();
				sharedPrefs87.edit().putBoolean("s2locked87", true).commit();
				sharedPrefs88.edit().putBoolean("s2locked88", true).commit();
				sharedPrefs89.edit().putBoolean("s2locked89", true).commit();
				sharedPrefs90.edit().putBoolean("s2locked90", true).commit();
				sharedPrefs91.edit().putBoolean("s2locked91", true).commit();
				sharedPrefs92.edit().putBoolean("s2locked92", true).commit();
				sharedPrefs93.edit().putBoolean("s2locked93", true).commit();
				sharedPrefs94.edit().putBoolean("s2locked94", true).commit();
				sharedPrefs95.edit().putBoolean("s2locked95", true).commit();
				sharedPrefs96.edit().putBoolean("s2locked96", true).commit();
				sharedPrefs97.edit().putBoolean("s2locked97", true).commit();
				sharedPrefs98.edit().putBoolean("s2locked98", true).commit();
				sharedPrefs99.edit().putBoolean("s2locked99", true).commit();
				sharedPrefs100.edit().putBoolean("s2locked100", true).commit();

				sharedPrefs101.edit().putBoolean("s2locked101", true).commit();
				sharedPrefs102.edit().putBoolean("s2locked102", true).commit();
				sharedPrefs103.edit().putBoolean("s2locked103", true).commit();
				sharedPrefs104.edit().putBoolean("s2locked104", true).commit();
				sharedPrefs105.edit().putBoolean("s2locked105", true).commit();
				sharedPrefs106.edit().putBoolean("s2locked106", true).commit();
				sharedPrefs107.edit().putBoolean("s2locked107", true).commit();
				sharedPrefs108.edit().putBoolean("s2locked108", true).commit();
				sharedPrefs109.edit().putBoolean("s2locked109", true).commit();
				sharedPrefs110.edit().putBoolean("s2locked110", true).commit();
				sharedPrefs111.edit().putBoolean("s2locked111", true).commit();
				sharedPrefs112.edit().putBoolean("s2locked112", true).commit();
				sharedPrefs113.edit().putBoolean("s2locked113", true).commit();
				sharedPrefs114.edit().putBoolean("s2locked114", true).commit();
				sharedPrefs115.edit().putBoolean("s2locked115", true).commit();
				sharedPrefs116.edit().putBoolean("s2locked116", true).commit();
				sharedPrefs117.edit().putBoolean("s2locked117", true).commit();
				sharedPrefs118.edit().putBoolean("s2locked118", true).commit();
				sharedPrefs119.edit().putBoolean("s2locked119", true).commit();
				sharedPrefs120.edit().putBoolean("s2locked120", true).commit();
				sharedPrefs121.edit().putBoolean("s2locked121", true).commit();
				sharedPrefs122.edit().putBoolean("s2locked122", true).commit();
				sharedPrefs123.edit().putBoolean("s2locked123", true).commit();
				sharedPrefs124.edit().putBoolean("s2locked124", true).commit();
				sharedPrefs125.edit().putBoolean("s2locked125", true).commit();
				sharedPrefs126.edit().putBoolean("s2locked126", true).commit();
				sharedPrefs127.edit().putBoolean("s2locked127", true).commit();
				sharedPrefs128.edit().putBoolean("s2locked128", true).commit();
				sharedPrefs129.edit().putBoolean("s2locked129", true).commit();
				sharedPrefs130.edit().putBoolean("s2locked130", true).commit();
				sharedPrefs131.edit().putBoolean("s2locked131", true).commit();
				sharedPrefs132.edit().putBoolean("s2locked132", true).commit();
				sharedPrefs133.edit().putBoolean("s2locked133", true).commit();
				sharedPrefs134.edit().putBoolean("s2locked134", true).commit();
				sharedPrefs135.edit().putBoolean("s2locked135", true).commit();
				sharedPrefs136.edit().putBoolean("s2locked136", true).commit();
				sharedPrefs137.edit().putBoolean("s2locked137", true).commit();
				sharedPrefs138.edit().putBoolean("s2locked138", true).commit();
				sharedPrefs139.edit().putBoolean("s2locked139", true).commit();
				sharedPrefs140.edit().putBoolean("s2locked140", true).commit();
				sharedPrefs141.edit().putBoolean("s2locked141", true).commit();
				sharedPrefs142.edit().putBoolean("s2locked142", true).commit();
				sharedPrefs143.edit().putBoolean("s2locked143", true).commit();
				sharedPrefs144.edit().putBoolean("s2locked144", true).commit();
				sharedPrefs145.edit().putBoolean("s2locked145", true).commit();
				sharedPrefs146.edit().putBoolean("s2locked146", true).commit();
				sharedPrefs147.edit().putBoolean("s2locked147", true).commit();
				sharedPrefs148.edit().putBoolean("s2locked148", true).commit();
				sharedPrefs149.edit().putBoolean("s2locked149", true).commit();
				sharedPrefs150.edit().putBoolean("s2locked150", true).commit();
				sharedPrefs151.edit().putBoolean("s2locked151", true).commit();
				sharedPrefs152.edit().putBoolean("s2locked152", true).commit();
				sharedPrefs153.edit().putBoolean("s2locked153", true).commit();
				sharedPrefs154.edit().putBoolean("s2locked154", true).commit();
				sharedPrefs155.edit().putBoolean("s2locked155", true).commit();
				sharedPrefs156.edit().putBoolean("s2locked156", true).commit();
				sharedPrefs157.edit().putBoolean("s2locked157", true).commit();
				sharedPrefs158.edit().putBoolean("s2locked158", true).commit();
				sharedPrefs159.edit().putBoolean("s2locked159", true).commit();
				sharedPrefs160.edit().putBoolean("s2locked160", true).commit();
				sharedPrefs161.edit().putBoolean("s2locked161", true).commit();
				sharedPrefs162.edit().putBoolean("s2locked162", true).commit();
				sharedPrefs163.edit().putBoolean("s2locked163", true).commit();
				sharedPrefs164.edit().putBoolean("s2locked164", true).commit();
				sharedPrefs165.edit().putBoolean("s2locked165", true).commit();
				sharedPrefs166.edit().putBoolean("s2locked166", true).commit();
				sharedPrefs167.edit().putBoolean("s2locked167", true).commit();
				sharedPrefs168.edit().putBoolean("s2locked168", true).commit();
				sharedPrefs169.edit().putBoolean("s2locked169", true).commit();
				sharedPrefs170.edit().putBoolean("s2locked170", true).commit();
				sharedPrefs171.edit().putBoolean("s2locked171", true).commit();
				sharedPrefs172.edit().putBoolean("s2locked172", true).commit();
				sharedPrefs173.edit().putBoolean("s2locked173", true).commit();
				sharedPrefs174.edit().putBoolean("s2locked174", true).commit();
				sharedPrefs175.edit().putBoolean("s2locked175", true).commit();
				sharedPrefs176.edit().putBoolean("s2locked176", true).commit();
				sharedPrefs177.edit().putBoolean("s2locked177", true).commit();
				sharedPrefs178.edit().putBoolean("s2locked178", true).commit();
				sharedPrefs179.edit().putBoolean("s2locked179", true).commit();
				sharedPrefs180.edit().putBoolean("s2locked180", true).commit();
				sharedPrefs181.edit().putBoolean("s2locked181", true).commit();
				sharedPrefs182.edit().putBoolean("s2locked182", true).commit();
				sharedPrefs183.edit().putBoolean("s2locked183", true).commit();
				sharedPrefs184.edit().putBoolean("s2locked184", true).commit();
				sharedPrefs185.edit().putBoolean("s2locked185", true).commit();
				sharedPrefs186.edit().putBoolean("s2locked186", true).commit();
				sharedPrefs187.edit().putBoolean("s2locked187", true).commit();
				sharedPrefs188.edit().putBoolean("s2locked188", true).commit();
				sharedPrefs189.edit().putBoolean("s2locked189", true).commit();
				sharedPrefs190.edit().putBoolean("s2locked190", true).commit();
				sharedPrefs191.edit().putBoolean("s2locked191", true).commit();
				sharedPrefs192.edit().putBoolean("s2locked192", true).commit();
				sharedPrefs193.edit().putBoolean("s2locked193", true).commit();
				sharedPrefs194.edit().putBoolean("s2locked194", true).commit();
				sharedPrefs195.edit().putBoolean("s2locked195", true).commit();
				sharedPrefs196.edit().putBoolean("s2locked196", true).commit();
				sharedPrefs197.edit().putBoolean("s2locked197", true).commit();
				sharedPrefs198.edit().putBoolean("s2locked198", true).commit();
				sharedPrefs199.edit().putBoolean("s2locked199", true).commit();
				sharedPrefs200.edit().putBoolean("s2locked200", true).commit();

				sharedPrefs201.edit().putBoolean("s2locked201", true).commit();
				sharedPrefs202.edit().putBoolean("s2locked202", true).commit();
				sharedPrefs203.edit().putBoolean("s2locked203", true).commit();
				sharedPrefs204.edit().putBoolean("s2locked204", true).commit();
				sharedPrefs205.edit().putBoolean("s2locked205", true).commit();
				sharedPrefs206.edit().putBoolean("s2locked206", true).commit();
				sharedPrefs207.edit().putBoolean("s2locked207", true).commit();
				sharedPrefs208.edit().putBoolean("s2locked208", true).commit();
				sharedPrefs209.edit().putBoolean("s2locked209", true).commit();
				sharedPrefs210.edit().putBoolean("s2locked210", true).commit();
				sharedPrefs211.edit().putBoolean("s2locked211", true).commit();
				sharedPrefs212.edit().putBoolean("s2locked212", true).commit();
				sharedPrefs213.edit().putBoolean("s2locked213", true).commit();
				sharedPrefs214.edit().putBoolean("s2locked214", true).commit();
				sharedPrefs215.edit().putBoolean("s2locked215", true).commit();
				sharedPrefs216.edit().putBoolean("s2locked216", true).commit();
				sharedPrefs217.edit().putBoolean("s2locked217", true).commit();
				sharedPrefs218.edit().putBoolean("s2locked218", true).commit();
				sharedPrefs219.edit().putBoolean("s2locked219", true).commit();
				sharedPrefs220.edit().putBoolean("s2locked220", true).commit();
				sharedPrefs221.edit().putBoolean("s2locked221", true).commit();
				sharedPrefs222.edit().putBoolean("s2locked222", true).commit();
				sharedPrefs223.edit().putBoolean("s2locked223", true).commit();
				sharedPrefs224.edit().putBoolean("s2locked224", true).commit();
				sharedPrefs225.edit().putBoolean("s2locked225", true).commit();
				sharedPrefs226.edit().putBoolean("s2locked226", true).commit();
				sharedPrefs227.edit().putBoolean("s2locked227", true).commit();
				sharedPrefs228.edit().putBoolean("s2locked228", true).commit();
				sharedPrefs229.edit().putBoolean("s2locked229", true).commit();
				sharedPrefs230.edit().putBoolean("s2locked230", true).commit();
				sharedPrefs231.edit().putBoolean("s2locked231", true).commit();
				sharedPrefs232.edit().putBoolean("s2locked232", true).commit();
				sharedPrefs233.edit().putBoolean("s2locked233", true).commit();
				sharedPrefs234.edit().putBoolean("s2locked234", true).commit();
				sharedPrefs235.edit().putBoolean("s2locked235", true).commit();
				sharedPrefs236.edit().putBoolean("s2locked236", true).commit();
				sharedPrefs237.edit().putBoolean("s2locked237", true).commit();
				sharedPrefs238.edit().putBoolean("s2locked238", true).commit();
				sharedPrefs239.edit().putBoolean("s2locked239", true).commit();
				sharedPrefs240.edit().putBoolean("s2locked240", true).commit();
				sharedPrefs241.edit().putBoolean("s2locked241", true).commit();
				sharedPrefs242.edit().putBoolean("s2locked242", true).commit();
				sharedPrefs243.edit().putBoolean("s2locked243", true).commit();
				sharedPrefs244.edit().putBoolean("s2locked244", true).commit();
				sharedPrefs245.edit().putBoolean("s2locked245", true).commit();
				sharedPrefs246.edit().putBoolean("s2locked246", true).commit();
				sharedPrefs247.edit().putBoolean("s2locked247", true).commit();
				sharedPrefs248.edit().putBoolean("s2locked248", true).commit();
				sharedPrefs249.edit().putBoolean("s2locked249", true).commit();
				sharedPrefs250.edit().putBoolean("s2locked250", true).commit();
				sharedPrefs251.edit().putBoolean("s2locked251", true).commit();
				sharedPrefs252.edit().putBoolean("s2locked252", true).commit();
				sharedPrefs253.edit().putBoolean("s2locked253", true).commit();
				sharedPrefs254.edit().putBoolean("s2locked254", true).commit();
				sharedPrefs255.edit().putBoolean("s2locked255", true).commit();
				sharedPrefs256.edit().putBoolean("s2locked256", true).commit();
				sharedPrefs257.edit().putBoolean("s2locked257", true).commit();
				sharedPrefs258.edit().putBoolean("s2locked258", true).commit();
				sharedPrefs259.edit().putBoolean("s2locked259", true).commit();
				sharedPrefs260.edit().putBoolean("s2locked260", true).commit();
				sharedPrefs261.edit().putBoolean("s2locked261", true).commit();
				sharedPrefs262.edit().putBoolean("s2locked262", true).commit();
				sharedPrefs263.edit().putBoolean("s2locked263", true).commit();
				sharedPrefs264.edit().putBoolean("s2locked264", true).commit();
				sharedPrefs265.edit().putBoolean("s2locked265", true).commit();
				sharedPrefs266.edit().putBoolean("s2locked266", true).commit();
				sharedPrefs267.edit().putBoolean("s2locked267", true).commit();
				sharedPrefs268.edit().putBoolean("s2locked268", true).commit();
				sharedPrefs269.edit().putBoolean("s2locked269", true).commit();
				sharedPrefs270.edit().putBoolean("s2locked270", true).commit();
				sharedPrefs271.edit().putBoolean("s2locked271", true).commit();
				sharedPrefs272.edit().putBoolean("s2locked272", true).commit();
				sharedPrefs273.edit().putBoolean("s2locked273", true).commit();
				sharedPrefs274.edit().putBoolean("s2locked274", true).commit();
				sharedPrefs275.edit().putBoolean("s2locked275", true).commit();
				sharedPrefs276.edit().putBoolean("s2locked276", true).commit();
				sharedPrefs277.edit().putBoolean("s2locked277", true).commit();
				sharedPrefs278.edit().putBoolean("s2locked278", true).commit();
				sharedPrefs279.edit().putBoolean("s2locked279", true).commit();
				sharedPrefs280.edit().putBoolean("s2locked280", true).commit();
				sharedPrefs281.edit().putBoolean("s2locked281", true).commit();
				sharedPrefs282.edit().putBoolean("s2locked282", true).commit();
				sharedPrefs283.edit().putBoolean("s2locked283", true).commit();
				sharedPrefs284.edit().putBoolean("s2locked284", true).commit();
				sharedPrefs285.edit().putBoolean("s2locked285", true).commit();
				sharedPrefs286.edit().putBoolean("s2locked286", true).commit();
				sharedPrefs287.edit().putBoolean("s2locked287", true).commit();
				sharedPrefs288.edit().putBoolean("s2locked288", true).commit();
				sharedPrefs289.edit().putBoolean("s2locked289", true).commit();
				sharedPrefs290.edit().putBoolean("s2locked290", true).commit();
				sharedPrefs291.edit().putBoolean("s2locked291", true).commit();
				sharedPrefs292.edit().putBoolean("s2locked292", true).commit();
				sharedPrefs293.edit().putBoolean("s2locked293", true).commit();
				sharedPrefs294.edit().putBoolean("s2locked294", true).commit();
				sharedPrefs295.edit().putBoolean("s2locked295", true).commit();
				sharedPrefs296.edit().putBoolean("s2locked296", true).commit();
				sharedPrefs297.edit().putBoolean("s2locked297", true).commit();
				sharedPrefs298.edit().putBoolean("s2locked298", true).commit();
				sharedPrefs299.edit().putBoolean("s2locked299", true).commit();
				sharedPrefs300.edit().putBoolean("s2locked300", true).commit();

				sharedPrefs301.edit().putBoolean("s2locked301", true).commit();
				sharedPrefs302.edit().putBoolean("s2locked302", true).commit();
				sharedPrefs303.edit().putBoolean("s2locked303", true).commit();
				sharedPrefs304.edit().putBoolean("s2locked304", true).commit();
				sharedPrefs305.edit().putBoolean("s2locked305", true).commit();
				sharedPrefs306.edit().putBoolean("s2locked306", true).commit();
				sharedPrefs307.edit().putBoolean("s2locked307", true).commit();
				sharedPrefs308.edit().putBoolean("s2locked308", true).commit();
				sharedPrefs309.edit().putBoolean("s2locked309", true).commit();
				sharedPrefs310.edit().putBoolean("s2locked310", true).commit();
				sharedPrefs311.edit().putBoolean("s2locked311", true).commit();
				sharedPrefs312.edit().putBoolean("s2locked312", true).commit();
				sharedPrefs313.edit().putBoolean("s2locked313", true).commit();
				sharedPrefs314.edit().putBoolean("s2locked314", true).commit();
				sharedPrefs315.edit().putBoolean("s2locked315", true).commit();
				sharedPrefs316.edit().putBoolean("s2locked316", true).commit();
				sharedPrefs317.edit().putBoolean("s2locked317", true).commit();
				sharedPrefs318.edit().putBoolean("s2locked318", true).commit();
				sharedPrefs319.edit().putBoolean("s2locked319", true).commit();
				sharedPrefs320.edit().putBoolean("s2locked320", true).commit();
			} else {
				Toast.makeText(getApplicationContext(),
						"초기화할 문구가 없습니다. 다시 입력해주세요.", Toast.LENGTH_SHORT).show();
			}
			return true;
		}
		
		if (id == R.id.defaulte) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK)) {
			tog = 0;
			SharedPreferences preferences1 = PreferenceManager
					.getDefaultSharedPreferences(getApplicationContext());
			SharedPreferences.Editor editor = preferences1.edit();
			editor.putInt("tog", tog);
			// editor.putInt("main2", del);
			editor.apply();
			System.out.println("TOGDES" + tog);
		}
		return super.onKeyDown(keyCode, event);
	}

	public void onUserLeaveHint() { // this only executes when Home is selected.
		tog = 0;
		SharedPreferences preferences1 = PreferenceManager
				.getDefaultSharedPreferences(getApplicationContext());
		SharedPreferences.Editor editor = preferences1.edit();
		editor.putInt("tog", tog);
		// editor.putInt("main2", del);
		editor.apply();
		System.out.println("TOGDES1" + tog);
		super.onUserLeaveHint();
	}
}
