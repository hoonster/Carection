package com.toh.carection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.LogRecord;

import com.geemo.uart.driver.UART_DATA_Monitoring;
import com.geemo.uart.driver.UART_USB_DEVICE_Probe;
import com.geemo.uart.driver.UART_USB_Driver;

import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Instrumentation;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
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
import android.widget.CheckBox;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

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
	int allSum = 0, refresh = 0, del = 0, tog = 0;
	Cursor cursor;

	RegistrationAdapter adapter1;
	RegistrationOpenHelper helper1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		adapter1 = new RegistrationAdapter(this);

		SharedPreferences preferences2 = PreferenceManager
				.getDefaultSharedPreferences(this);
		refresh = preferences2.getInt("refresh", 0);
		del = preferences2.getInt("del", 0);
		tog = preferences2.getInt("tog", 0);
		allSum = preferences2.getInt("allSum", 0);
		// add = preferences2.getInt("add", 0);

		System.out.println("refresh" + refresh);
		System.out.println("del" + del);

		fr1 = preferences2.getInt("locked1", 0);
		fr2 = preferences2.getInt("locked2", 0);
		fr3 = preferences2.getInt("locked3", 0);
		fr4 = preferences2.getInt("locked4", 0);
		fr5 = preferences2.getInt("locked5", 0);
		fr6 = preferences2.getInt("locked6", 0);
		fr7 = preferences2.getInt("locked7", 0);
		fr8 = preferences2.getInt("locked8", 0);
		sr1 = preferences2.getInt("locked9", 0);
		sr2 = preferences2.getInt("locked10", 0);
		sr3 = preferences2.getInt("locked11", 0);
		sr4 = preferences2.getInt("locked12", 0);
		sr5 = preferences2.getInt("locked13", 0);
		sr6 = preferences2.getInt("locked14", 0);
		sr7 = preferences2.getInt("locked15", 0);
		sr8 = preferences2.getInt("locked16", 0);
		tr1 = preferences2.getInt("locked17", 0);
		tr2 = preferences2.getInt("locked18", 0);
		tr3 = preferences2.getInt("locked19", 0);
		tr4 = preferences2.getInt("locked20", 0);
		tr5 = preferences2.getInt("locked21", 0);
		tr6 = preferences2.getInt("locked22", 0);
		tr7 = preferences2.getInt("locked23", 0);
		tr8 = preferences2.getInt("locked24", 0);
		for1 = preferences2.getInt("locked25", 0);
		for2 = preferences2.getInt("locked26", 0);
		for3 = preferences2.getInt("locked27", 0);
		for4 = preferences2.getInt("locked28", 0);
		for5 = preferences2.getInt("locked29", 0);
		for6 = preferences2.getInt("locked30", 0);
		for7 = preferences2.getInt("locked31", 0);
		for8 = preferences2.getInt("locked32", 0);
		fir1 = preferences2.getInt("locked33", 0);
		fir2 = preferences2.getInt("locked34", 0);
		fir3 = preferences2.getInt("locked35", 0);
		fir4 = preferences2.getInt("locked36", 0);
		fir5 = preferences2.getInt("locked37", 0);
		fir6 = preferences2.getInt("locked38", 0);
		fir7 = preferences2.getInt("locked39", 0);
		fir8 = preferences2.getInt("locked40", 0);
		sir1 = preferences2.getInt("locked41", 0);
		sir2 = preferences2.getInt("locked42", 0);
		sir3 = preferences2.getInt("locked43", 0);
		sir4 = preferences2.getInt("locked44", 0);
		sir5 = preferences2.getInt("locked45", 0);
		sir6 = preferences2.getInt("locked46", 0);
		sir7 = preferences2.getInt("locked47", 0);
		sir8 = preferences2.getInt("locked48", 0);
		ser1 = preferences2.getInt("locked49", 0);
		ser2 = preferences2.getInt("locked50", 0);
		ser3 = preferences2.getInt("locked51", 0);
		ser4 = preferences2.getInt("locked52", 0);
		ser5 = preferences2.getInt("locked53", 0);
		ser6 = preferences2.getInt("locked54", 0);
		ser7 = preferences2.getInt("locked55", 0);
		ser8 = preferences2.getInt("locked56", 0);
		er1 = preferences2.getInt("locked57", 0);
		er2 = preferences2.getInt("locked58", 0);
		er3 = preferences2.getInt("locked59", 0);
		er4 = preferences2.getInt("locked60", 0);
		er5 = preferences2.getInt("locked61", 0);
		er6 = preferences2.getInt("locked62", 0);
		er7 = preferences2.getInt("locked63", 0);
		er8 = preferences2.getInt("locked64", 0);

		s2fr1 = preferences2.getInt("locked65", 0);
		s2fr2 = preferences2.getInt("locked66", 0);
		s2fr3 = preferences2.getInt("locked67", 0);
		s2fr4 = preferences2.getInt("locked68", 0);
		s2fr5 = preferences2.getInt("locked69", 0);
		s2fr6 = preferences2.getInt("locked70", 0);
		s2fr7 = preferences2.getInt("locked71", 0);
		s2fr8 = preferences2.getInt("locked72", 0);
		s2sr1 = preferences2.getInt("locked73", 0);
		s2sr2 = preferences2.getInt("locked74", 0);
		s2sr3 = preferences2.getInt("locked75", 0);
		s2sr4 = preferences2.getInt("locked76", 0);
		s2sr5 = preferences2.getInt("locked77", 0);
		s2sr6 = preferences2.getInt("locked78", 0);
		s2sr7 = preferences2.getInt("locked79", 0);
		s2sr8 = preferences2.getInt("locked80", 0);
		s2tr1 = preferences2.getInt("locked81", 0);
		s2tr2 = preferences2.getInt("locked82", 0);
		s2tr3 = preferences2.getInt("locked83", 0);
		s2tr4 = preferences2.getInt("locked84", 0);
		s2tr5 = preferences2.getInt("locked85", 0);
		s2tr6 = preferences2.getInt("locked86", 0);
		s2tr7 = preferences2.getInt("locked87", 0);
		s2tr8 = preferences2.getInt("locked88", 0);
		s2for1 = preferences2.getInt("locked89", 0);
		s2for2 = preferences2.getInt("locked90", 0);
		s2for3 = preferences2.getInt("locked91", 0);
		s2for4 = preferences2.getInt("locked92", 0);
		s2for5 = preferences2.getInt("locked93", 0);
		s2for6 = preferences2.getInt("locked94", 0);
		s2for7 = preferences2.getInt("locked95", 0);
		s2for8 = preferences2.getInt("locked96", 0);
		s2fir1 = preferences2.getInt("locked97", 0);
		s2fir2 = preferences2.getInt("locked98", 0);
		s2fir3 = preferences2.getInt("locked99", 0);
		s2fir4 = preferences2.getInt("locked100", 0);
		s2fir5 = preferences2.getInt("locked101", 0);
		s2fir6 = preferences2.getInt("locked102", 0);
		s2fir7 = preferences2.getInt("locked103", 0);
		s2fir8 = preferences2.getInt("locked104", 0);
		s2sir1 = preferences2.getInt("locked105", 0);
		s2sir2 = preferences2.getInt("locked106", 0);
		s2sir3 = preferences2.getInt("locked107", 0);
		s2sir4 = preferences2.getInt("locked108", 0);
		s2sir5 = preferences2.getInt("locked109", 0);
		s2sir6 = preferences2.getInt("locked110", 0);
		s2sir7 = preferences2.getInt("locked111", 0);
		s2sir8 = preferences2.getInt("locked112", 0);
		s2ser1 = preferences2.getInt("locked113", 0);
		s2ser2 = preferences2.getInt("locked114", 0);
		s2ser3 = preferences2.getInt("locked115", 0);
		s2ser4 = preferences2.getInt("locked116", 0);
		s2ser5 = preferences2.getInt("locked117", 0);
		s2ser6 = preferences2.getInt("locked118", 0);
		s2ser7 = preferences2.getInt("locked119", 0);
		s2ser8 = preferences2.getInt("locked120", 0);
		s2er1 = preferences2.getInt("locked121", 0);
		s2er2 = preferences2.getInt("locked122", 0);
		s2er3 = preferences2.getInt("locked123", 0);
		s2er4 = preferences2.getInt("locked124", 0);
		s2er5 = preferences2.getInt("locked125", 0);
		s2er6 = preferences2.getInt("locked126", 0);
		s2er7 = preferences2.getInt("locked127", 0);
		s2er8 = preferences2.getInt("locked128", 0);
		s3fr1 = preferences2.getInt("locked129", 0);
		s3fr2 = preferences2.getInt("locked130", 0);
		s3fr3 = preferences2.getInt("locked131", 0);
		s3fr4 = preferences2.getInt("locked132", 0);
		s3fr5 = preferences2.getInt("locked133", 0);
		s3fr6 = preferences2.getInt("locked134", 0);
		s3fr7 = preferences2.getInt("locked135", 0);
		s3fr8 = preferences2.getInt("locked136", 0);
		s3sr1 = preferences2.getInt("locked137", 0);
		s3sr2 = preferences2.getInt("locked138", 0);
		s3sr3 = preferences2.getInt("locked139", 0);
		s3sr4 = preferences2.getInt("locked140", 0);
		s3sr5 = preferences2.getInt("locked141", 0);
		s3sr6 = preferences2.getInt("locked142", 0);
		s3sr7 = preferences2.getInt("locked143", 0);
		s3sr8 = preferences2.getInt("locked144", 0);
		s3tr1 = preferences2.getInt("locked145", 0);
		s3tr2 = preferences2.getInt("locked146", 0);
		s3tr3 = preferences2.getInt("locked147", 0);
		s3tr4 = preferences2.getInt("locked148", 0);
		s3tr5 = preferences2.getInt("locked149", 0);
		s3tr6 = preferences2.getInt("locked150", 0);
		s3tr7 = preferences2.getInt("locked151", 0);
		s3tr8 = preferences2.getInt("locked152", 0);
		s3for1 = preferences2.getInt("locked153", 0);
		s3for2 = preferences2.getInt("locked154", 0);
		s3for3 = preferences2.getInt("locked155", 0);
		s3for4 = preferences2.getInt("locked156", 0);
		s3for5 = preferences2.getInt("locked157", 0);
		s3for6 = preferences2.getInt("locked158", 0);
		s3for7 = preferences2.getInt("locked159", 0);
		s3for8 = preferences2.getInt("locked160", 0);
		s3fir1 = preferences2.getInt("locked161", 0);
		s3fir2 = preferences2.getInt("locked162", 0);
		s3fir3 = preferences2.getInt("locked163", 0);
		s3fir4 = preferences2.getInt("locked164", 0);
		s3fir5 = preferences2.getInt("locked165", 0);
		s3fir6 = preferences2.getInt("locked166", 0);
		s3fir7 = preferences2.getInt("locked167", 0);
		s3fir8 = preferences2.getInt("locked168", 0);
		s3sir1 = preferences2.getInt("locked169", 0);
		s3sir2 = preferences2.getInt("locked170", 0);
		s3sir3 = preferences2.getInt("locked171", 0);
		s3sir4 = preferences2.getInt("locked172", 0);
		s3sir5 = preferences2.getInt("locked173", 0);
		s3sir6 = preferences2.getInt("locked174", 0);
		s3sir7 = preferences2.getInt("locked175", 0);
		s3sir8 = preferences2.getInt("locked176", 0);
		s3ser1 = preferences2.getInt("locked177", 0);
		s3ser2 = preferences2.getInt("locked178", 0);
		s3ser3 = preferences2.getInt("locked179", 0);
		s3ser4 = preferences2.getInt("locked180", 0);
		s3ser5 = preferences2.getInt("locked181", 0);
		s3ser6 = preferences2.getInt("locked182", 0);
		s3ser7 = preferences2.getInt("locked183", 0);
		s3ser8 = preferences2.getInt("locked184", 0);
		s3er1 = preferences2.getInt("locked185", 0);
		s3er2 = preferences2.getInt("locked186", 0);
		s3er3 = preferences2.getInt("locked187", 0);
		s3er4 = preferences2.getInt("locked188", 0);
		s3er5 = preferences2.getInt("locked189", 0);
		s3er6 = preferences2.getInt("locked190", 0);
		s3er7 = preferences2.getInt("locked191", 0);
		s3er8 = preferences2.getInt("locked192", 0);
		s4fr1 = preferences2.getInt("locked193", 0);
		s4fr2 = preferences2.getInt("locked194", 0);
		s4fr3 = preferences2.getInt("locked195", 0);
		s4fr4 = preferences2.getInt("locked196", 0);
		s4fr5 = preferences2.getInt("locked197", 0);
		s4fr6 = preferences2.getInt("locked198", 0);
		s4fr7 = preferences2.getInt("locked199", 0);
		s4fr8 = preferences2.getInt("locked200", 0);
		s4sr1 = preferences2.getInt("locked201", 0);
		s4sr2 = preferences2.getInt("locked202", 0);
		s4sr3 = preferences2.getInt("locked203", 0);
		s4sr4 = preferences2.getInt("locked204", 0);
		s4sr5 = preferences2.getInt("locked205", 0);
		s4sr6 = preferences2.getInt("locked206", 0);
		s4sr7 = preferences2.getInt("locked207", 0);
		s4sr8 = preferences2.getInt("locked208", 0);
		s4tr1 = preferences2.getInt("locked209", 0);
		s4tr2 = preferences2.getInt("locked210", 0);
		s4tr3 = preferences2.getInt("locked211", 0);
		s4tr4 = preferences2.getInt("locked212", 0);
		s4tr5 = preferences2.getInt("locked213", 0);
		s4tr6 = preferences2.getInt("locked214", 0);
		s4tr7 = preferences2.getInt("locked215", 0);
		s4tr8 = preferences2.getInt("locked216", 0);
		s4for1 = preferences2.getInt("locked217", 0);
		s4for2 = preferences2.getInt("locked218", 0);
		s4for3 = preferences2.getInt("locked219", 0);
		s4for4 = preferences2.getInt("locked220", 0);
		s4for5 = preferences2.getInt("locked221", 0);
		s4for6 = preferences2.getInt("locked222", 0);
		s4for7 = preferences2.getInt("locked223", 0);
		s4for8 = preferences2.getInt("locked224", 0);
		s4fir1 = preferences2.getInt("locked225", 0);
		s4fir2 = preferences2.getInt("locked226", 0);
		s4fir3 = preferences2.getInt("locked227", 0);
		s4fir4 = preferences2.getInt("locked228", 0);
		s4fir5 = preferences2.getInt("locked229", 0);
		s4fir6 = preferences2.getInt("locked230", 0);
		s4fir7 = preferences2.getInt("locked231", 0);
		s4fir8 = preferences2.getInt("locked232", 0);
		s4sir1 = preferences2.getInt("locked233", 0);
		s4sir2 = preferences2.getInt("locked234", 0);
		s4sir3 = preferences2.getInt("locked235", 0);
		s4sir4 = preferences2.getInt("locked236", 0);
		s4sir5 = preferences2.getInt("locked237", 0);
		s4sir6 = preferences2.getInt("locked238", 0);
		s4sir7 = preferences2.getInt("locked239", 0);
		s4sir8 = preferences2.getInt("locked240", 0);
		s4ser1 = preferences2.getInt("locked241", 0);
		s4ser2 = preferences2.getInt("locked242", 0);
		s4ser3 = preferences2.getInt("locked243", 0);
		s4ser4 = preferences2.getInt("locked244", 0);
		s4ser5 = preferences2.getInt("locked245", 0);
		s4ser6 = preferences2.getInt("locked246", 0);
		s4ser7 = preferences2.getInt("locked247", 0);
		s4ser8 = preferences2.getInt("locked248", 0);
		s4er1 = preferences2.getInt("locked249", 0);
		s4er2 = preferences2.getInt("locked250", 0);
		s4er3 = preferences2.getInt("locked251", 0);
		s4er4 = preferences2.getInt("locked252", 0);
		s4er5 = preferences2.getInt("locked253", 0);
		s4er6 = preferences2.getInt("locked254", 0);
		s4er7 = preferences2.getInt("locked255", 0);
		s4er8 = preferences2.getInt("locked256", 0);
		s5fr1 = preferences2.getInt("locked257", 0);
		s5fr2 = preferences2.getInt("locked258", 0);
		s5fr3 = preferences2.getInt("locked259", 0);
		s5fr4 = preferences2.getInt("locked260", 0);
		s5fr5 = preferences2.getInt("locked261", 0);
		s5fr6 = preferences2.getInt("locked262", 0);
		s5fr7 = preferences2.getInt("locked263", 0);
		s5fr8 = preferences2.getInt("locked264", 0);
		s5sr1 = preferences2.getInt("locked265", 0);
		s5sr2 = preferences2.getInt("locked266", 0);
		s5sr3 = preferences2.getInt("locked267", 0);
		s5sr4 = preferences2.getInt("locked268", 0);
		s5sr5 = preferences2.getInt("locked269", 0);
		s5sr6 = preferences2.getInt("locked270", 0);
		s5sr7 = preferences2.getInt("locked271", 0);
		s5sr8 = preferences2.getInt("locked272", 0);
		s5tr1 = preferences2.getInt("locked273", 0);
		s5tr2 = preferences2.getInt("locked274", 0);
		s5tr3 = preferences2.getInt("locked275", 0);
		s5tr4 = preferences2.getInt("locked276", 0);
		s5tr5 = preferences2.getInt("locked277", 0);
		s5tr6 = preferences2.getInt("locked278", 0);
		s5tr7 = preferences2.getInt("locked279", 0);
		s5tr8 = preferences2.getInt("locked280", 0);
		s5for1 = preferences2.getInt("locked281", 0);
		s5for2 = preferences2.getInt("locked282", 0);
		s5for3 = preferences2.getInt("locked283", 0);
		s5for4 = preferences2.getInt("locked284", 0);
		s5for5 = preferences2.getInt("locked285", 0);
		s5for6 = preferences2.getInt("locked286", 0);
		s5for7 = preferences2.getInt("locked287", 0);
		s5for8 = preferences2.getInt("locked288", 0);
		s5fir1 = preferences2.getInt("locked289", 0);
		s5fir2 = preferences2.getInt("locked290", 0);
		s5fir3 = preferences2.getInt("locked291", 0);
		s5fir4 = preferences2.getInt("locked292", 0);
		s5fir5 = preferences2.getInt("locked293", 0);
		s5fir6 = preferences2.getInt("locked294", 0);
		s5fir7 = preferences2.getInt("locked295", 0);
		s5fir8 = preferences2.getInt("locked296", 0);
		s5sir1 = preferences2.getInt("locked297", 0);
		s5sir2 = preferences2.getInt("locked298", 0);
		s5sir3 = preferences2.getInt("locked299", 0);
		s5sir4 = preferences2.getInt("locked300", 0);
		s5sir5 = preferences2.getInt("locked301", 0);
		s5sir6 = preferences2.getInt("locked302", 0);
		s5sir7 = preferences2.getInt("locked303", 0);
		s5sir8 = preferences2.getInt("locked304", 0);
		s5ser1 = preferences2.getInt("locked305", 0);
		s5ser2 = preferences2.getInt("locked306", 0);
		s5ser3 = preferences2.getInt("locked307", 0);
		s5ser4 = preferences2.getInt("locked308", 0);
		s5ser5 = preferences2.getInt("locked309", 0);
		s5ser6 = preferences2.getInt("locked310", 0);
		s5ser7 = preferences2.getInt("locked311", 0);
		s5ser8 = preferences2.getInt("locked312", 0);
		s5er1 = preferences2.getInt("locked313", 0);
		s5er2 = preferences2.getInt("locked314", 0);
		s5er3 = preferences2.getInt("locked315", 0);
		s5er4 = preferences2.getInt("locked316", 0);
		s5er5 = preferences2.getInt("locked317", 0);
		s5er6 = preferences2.getInt("locked318", 0);
		s5er7 = preferences2.getInt("locked319", 0);
		s5er8 = preferences2.getInt("locked320", 0);

		// Generate title
		title = new String[] { "주행모드", "주행모드", "주행모드", "주행모드", "주행모드", "주행모드",
				"주행모드", "주행모드" };

		// Generate subtitle
		subtitle = new String[] { "좌깜빡이", "우깜빡이", "브레이크", "후진", "비상등", "추가 1",
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
				switch (position) {
				case 0:
					// Intent i = new Intent(getApplicationContext(),
					// FirstActivity.class);
					// startActivity(i);
					break;
				case 1:
					try {
						Intent i1 = new Intent(MainActivity.this,
								FirstActivity.class);
						overridePendingTransition(0, 0);
						i1.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
						finish();

						overridePendingTransition(0, 0);
						startActivity(i1);
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
						Intent i2 = new Intent(MainActivity.this,
								SecondActivity.class);
						overridePendingTransition(0, 0);
						i2.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
						finish();

						overridePendingTransition(0, 0);
						startActivity(i2);
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
						Intent i3 = new Intent(MainActivity.this,
								ThirdActivity.class);
						overridePendingTransition(0, 0);
						i3.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
						finish();

						overridePendingTransition(0, 0);
						startActivity(i3);
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
						Intent i4 = new Intent(MainActivity.this,
								ForthActivity.class);
						overridePendingTransition(0, 0);
						i4.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
						finish();

						overridePendingTransition(0, 0);
						startActivity(i4);
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
						Intent i5 = new Intent(MainActivity.this,
								FifthActivity.class);
						overridePendingTransition(0, 0);
						i5.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
						finish();

						overridePendingTransition(0, 0);
						startActivity(i5);
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
						Intent i6 = new Intent(MainActivity.this,
								SixthActivity.class);
						overridePendingTransition(0, 0);
						i6.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
						finish();

						overridePendingTransition(0, 0);
						startActivity(i6);
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
						Intent i7 = new Intent(MainActivity.this,
								SeventhActivity.class);
						overridePendingTransition(0, 0);
						i7.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
						finish();

						overridePendingTransition(0, 0);
						startActivity(i7);
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
		cursor = adapter1.queryName1();
		// cursor.moveToFirst();
		ArrayList<String> names = new ArrayList<String>();
		if (cursor != null) {
			if (cursor.moveToFirst()) {
				do {
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE111)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE112)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE113)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE114)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE115)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE116)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE117)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE118)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE121)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE122)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE123)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE124)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE125)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE126)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE127)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE128)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE131)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE132)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE133)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE134)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE135)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE136)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE137)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE138)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE141)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE142)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE143)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE144)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE145)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE146)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE147)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE148)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE151)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE152)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE153)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE154)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE155)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE156)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE157)));
					names.add(cursor.getString(cursor
							.getColumnIndex(helper1.SQUARE158)));
					System.out.println("getCount" + cursor.getCount());
					System.out.println("getColumnIndex"
							+ cursor.getColumnIndex("_id"));
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
			System.out.println("square" + ret[i]);
		}

		cursor.close();

		// 1st
		// square------------------------------------------------------------------------------
		// ----------------------------------------------------------------------------------------
		fb1 = (Button) findViewById(R.id.button1);
		if (fr1 == 0) {
			fb1.setBackgroundResource(R.drawable.not_pressed);
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked1", fr1);
					editor.commit();

				} else {
					fb1.setBackgroundResource(R.drawable.pressed);
					fr1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked1", fr1);
					editor.commit();
				}
				isPressed = !isPressed;
			}
		});
		fb2 = (Button) findViewById(R.id.button2);
		if (fr2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked2", fr2);
					editor.apply();
				} else {
					fb2.setBackgroundResource(R.drawable.pressed);
					fr2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked2", fr2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		fb3 = (Button) findViewById(R.id.button3);
		if (fr3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked3", fr3);
					editor.apply();
				} else {
					fb3.setBackgroundResource(R.drawable.pressed);
					fr3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked3", fr3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		fb4 = (Button) findViewById(R.id.button4);
		if (fr4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked4", fr4);
					editor.apply();
				} else {
					fb4.setBackgroundResource(R.drawable.pressed);
					fr4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked4", fr4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		fb5 = (Button) findViewById(R.id.button5);
		if (fr5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked5", fr5);
					editor.apply();
				} else {
					fb5.setBackgroundResource(R.drawable.pressed);
					fr5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked5", fr5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		fb6 = (Button) findViewById(R.id.button6);
		if (fr6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked6", fr6);
					editor.apply();
				} else {
					fb6.setBackgroundResource(R.drawable.pressed);
					fr6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked6", fr6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		fb7 = (Button) findViewById(R.id.button7);
		if (fr7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked7", fr7);
					editor.apply();
				} else {
					fb7.setBackgroundResource(R.drawable.pressed);
					fr7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked7", fr7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		fb8 = (Button) findViewById(R.id.button8);
		if (fr8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked8", fr8);
					editor.apply();
				} else {
					fb8.setBackgroundResource(R.drawable.pressed);
					fr8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked8", fr8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------

		sb1 = (Button) findViewById(R.id.sbutton1);
		if (sr1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked9", sr1);
					editor.apply();
				} else {
					sb1.setBackgroundResource(R.drawable.pressed);
					sr1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked9", sr1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		sb2 = (Button) findViewById(R.id.sbutton2);
		if (sr2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked10", sr2);
					editor.apply();
				} else {
					sb2.setBackgroundResource(R.drawable.pressed);
					sr2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked10", sr2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		sb3 = (Button) findViewById(R.id.sbutton3);
		if (sr3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked11", sr3);
					editor.apply();
				} else {
					sb3.setBackgroundResource(R.drawable.pressed);
					sr3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked11", sr3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		sb4 = (Button) findViewById(R.id.sbutton4);
		if (sr4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked12", sr4);
					editor.apply();
				} else {
					sb4.setBackgroundResource(R.drawable.pressed);
					sr4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked12", sr4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		sb5 = (Button) findViewById(R.id.sbutton5);
		if (sr5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked13", sr5);
					editor.apply();
				} else {
					sb5.setBackgroundResource(R.drawable.pressed);
					sr5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked13", sr5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		sb6 = (Button) findViewById(R.id.sbutton6);
		if (sr6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked14", sr6);
					editor.apply();
				} else {
					sb6.setBackgroundResource(R.drawable.pressed);
					sr6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked14", sr6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		sb7 = (Button) findViewById(R.id.sbutton7);
		if (sr7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked15", sr7);
					editor.apply();
				} else {
					sb7.setBackgroundResource(R.drawable.pressed);
					sr7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked15", sr7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		sb8 = (Button) findViewById(R.id.sbutton8);
		if (sr8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked16", sr8);
					editor.apply();
				} else {
					sb8.setBackgroundResource(R.drawable.pressed);
					sr8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked16", sr8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// ------------------------------------------------------------------------------------

		tb1 = (Button) findViewById(R.id.tbutton1);
		if (tr1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked17", tr1);
					editor.apply();
				} else {
					tb1.setBackgroundResource(R.drawable.pressed);
					tr1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked17", tr1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		tb2 = (Button) findViewById(R.id.tbutton2);
		if (tr2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked18", tr2);
					editor.apply();
				} else {
					tb2.setBackgroundResource(R.drawable.pressed);
					tr2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked18", tr2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		tb3 = (Button) findViewById(R.id.tbutton3);
		if (tr3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked19", tr3);
					editor.apply();
				} else {
					tb3.setBackgroundResource(R.drawable.pressed);
					tr3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked19", tr3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		tb4 = (Button) findViewById(R.id.tbutton4);
		if (tr4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked20", tr4);
					editor.apply();
				} else {
					tb4.setBackgroundResource(R.drawable.pressed);
					tr4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked20", tr4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		tb5 = (Button) findViewById(R.id.tbutton5);
		if (tr5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked21", tr5);
					editor.apply();
				} else {
					tb5.setBackgroundResource(R.drawable.pressed);
					tr5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked21", tr5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		tb6 = (Button) findViewById(R.id.tbutton6);
		if (tr6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked22", tr6);
					editor.apply();
				} else {
					tb6.setBackgroundResource(R.drawable.pressed);
					tr6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked22", tr6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		tb7 = (Button) findViewById(R.id.tbutton7);
		if (tr7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked23", tr7);
					editor.apply();
				} else {
					tb7.setBackgroundResource(R.drawable.pressed);
					tr7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked23", tr7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		tb8 = (Button) findViewById(R.id.tbutton8);
		if (tr8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked24", tr8);
					editor.apply();
				} else {
					tb8.setBackgroundResource(R.drawable.pressed);
					tr8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked24", tr8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// ------------------------------------------------------------------------------------
		fob1 = (Button) findViewById(R.id.fobutton1);
		if (for1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked25", for1);
					editor.apply();
				} else {
					fob1.setBackgroundResource(R.drawable.pressed);
					for1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked25", for1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		fob2 = (Button) findViewById(R.id.fobutton2);
		if (for2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked26", for2);
					editor.apply();
				} else {
					fob2.setBackgroundResource(R.drawable.pressed);
					for2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked26", for2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		fob3 = (Button) findViewById(R.id.fobutton3);
		if (for3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked27", for3);
					editor.apply();
				} else {
					fob3.setBackgroundResource(R.drawable.pressed);
					for3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked27", for3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		fob4 = (Button) findViewById(R.id.fobutton4);
		if (for4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked28", for4);
					editor.apply();
				} else {
					fob4.setBackgroundResource(R.drawable.pressed);
					for4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked28", for4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		fob5 = (Button) findViewById(R.id.fobutton5);
		if (for5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked29", for5);
					editor.apply();
				} else {
					fob5.setBackgroundResource(R.drawable.pressed);
					for5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked29", for5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		fob6 = (Button) findViewById(R.id.fobutton6);
		if (for6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked30", for6);
					editor.apply();
				} else {
					fob6.setBackgroundResource(R.drawable.pressed);
					for6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked30", for6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		fob7 = (Button) findViewById(R.id.fobutton7);
		if (for7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked31", for7);
					editor.apply();
				} else {
					fob7.setBackgroundResource(R.drawable.pressed);
					for7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked31", for7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		fob8 = (Button) findViewById(R.id.fobutton8);
		if (for8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked32", for8);
					editor.apply();
				} else {
					fob8.setBackgroundResource(R.drawable.pressed);
					for8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked32", for8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// ------------------------------------------------------------------------------------
		fib1 = (Button) findViewById(R.id.fibutton1);
		if (fir1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked33", fir1);
					editor.apply();
				} else {
					fib1.setBackgroundResource(R.drawable.pressed);
					fir1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked33", fir1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		fib2 = (Button) findViewById(R.id.fibutton2);
		if (fir2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked34", fir2);
					editor.apply();
				} else {
					fib2.setBackgroundResource(R.drawable.pressed);
					fir2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked34", fir2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		fib3 = (Button) findViewById(R.id.fibutton3);
		if (fir3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked35", fir3);
					editor.apply();
				} else {
					fib3.setBackgroundResource(R.drawable.pressed);
					fir3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked35", fir3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		fib4 = (Button) findViewById(R.id.fibutton4);
		if (fir4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked36", fir4);
					editor.apply();
				} else {
					fib4.setBackgroundResource(R.drawable.pressed);
					fir4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked36", fir4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		fib5 = (Button) findViewById(R.id.fibutton5);
		if (fir5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked37", fir5);
					editor.apply();
				} else {
					fib5.setBackgroundResource(R.drawable.pressed);
					fir5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked37", fir5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		fib6 = (Button) findViewById(R.id.fibutton6);
		if (fir6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked38", fir6);
					editor.apply();
				} else {
					fib6.setBackgroundResource(R.drawable.pressed);
					fir6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked38", fir6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		fib7 = (Button) findViewById(R.id.fibutton7);
		if (fir7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked39", fir7);
					editor.apply();
				} else {
					fib7.setBackgroundResource(R.drawable.pressed);
					fir7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked39", fir7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		fib8 = (Button) findViewById(R.id.fibutton8);
		if (fir8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked40", fir8);
					editor.apply();
				} else {
					fib8.setBackgroundResource(R.drawable.pressed);
					fir8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked40", fir8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------
		sib1 = (Button) findViewById(R.id.sibutton1);
		if (sir1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked41", sir1);
					editor.apply();
				} else {
					sib1.setBackgroundResource(R.drawable.pressed);
					sir1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked41", sir1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		sib2 = (Button) findViewById(R.id.sibutton2);
		if (sir2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked42", sir2);
					editor.apply();
				} else {
					sib2.setBackgroundResource(R.drawable.pressed);
					sir2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked42", sir2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		sib3 = (Button) findViewById(R.id.sibutton3);
		if (sir3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked43", sir3);
					editor.apply();
				} else {
					sib3.setBackgroundResource(R.drawable.pressed);
					sir3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked43", sir3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		sib4 = (Button) findViewById(R.id.sibutton4);
		if (sir4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked44", sir4);
					editor.apply();
				} else {
					sib4.setBackgroundResource(R.drawable.pressed);
					sir4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked44", sir4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		sib5 = (Button) findViewById(R.id.sibutton5);
		if (sir5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked45", sir5);
					editor.apply();
				} else {
					sib5.setBackgroundResource(R.drawable.pressed);
					sir5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locke45", sir5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		sib6 = (Button) findViewById(R.id.sibutton6);
		if (sir6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked46", sir6);
					editor.apply();
				} else {
					sib6.setBackgroundResource(R.drawable.pressed);
					sir6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked46", sir6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		sib7 = (Button) findViewById(R.id.sibutton7);
		if (sir7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked47", sir7);
					editor.apply();
				} else {
					sib7.setBackgroundResource(R.drawable.pressed);
					sir7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked47", sir7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		sib8 = (Button) findViewById(R.id.sibutton8);
		if (sir8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked48", sir8);
					editor.apply();
				} else {
					sib8.setBackgroundResource(R.drawable.pressed);
					sir8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked48", sir8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------
		seb1 = (Button) findViewById(R.id.sebutton1);
		if (ser1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked49", ser1);
					editor.apply();
				} else {
					seb1.setBackgroundResource(R.drawable.pressed);
					ser1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked49", ser1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		seb2 = (Button) findViewById(R.id.sebutton2);
		if (ser2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked50", ser2);
					editor.apply();
				} else {
					seb2.setBackgroundResource(R.drawable.pressed);
					ser2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked50", ser2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		seb3 = (Button) findViewById(R.id.sebutton3);
		if (ser3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked51", ser3);
					editor.apply();
				} else {
					seb3.setBackgroundResource(R.drawable.pressed);
					ser3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked51", ser3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		seb4 = (Button) findViewById(R.id.sebutton4);
		if (ser4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked52", ser4);
					editor.apply();
				} else {
					seb4.setBackgroundResource(R.drawable.pressed);
					ser4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked52", ser4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		seb5 = (Button) findViewById(R.id.sebutton5);
		if (ser5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked53", ser5);
					editor.apply();
				} else {
					seb5.setBackgroundResource(R.drawable.pressed);
					ser5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked53", ser5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		seb6 = (Button) findViewById(R.id.sebutton6);
		if (ser6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked54", ser6);
					editor.apply();
				} else {
					seb6.setBackgroundResource(R.drawable.pressed);
					ser6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked54", ser6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		seb7 = (Button) findViewById(R.id.sebutton7);
		if (ser7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked55", ser7);
					editor.apply();
				} else {
					seb7.setBackgroundResource(R.drawable.pressed);
					ser7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked55", ser7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		seb8 = (Button) findViewById(R.id.sebutton8);
		if (ser8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked56", ser8);
					editor.apply();
				} else {
					seb8.setBackgroundResource(R.drawable.pressed);
					ser8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked56", ser8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------
		eb1 = (Button) findViewById(R.id.ebutton1);
		if (er1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked57", er1);
					editor.apply();
				} else {
					eb1.setBackgroundResource(R.drawable.pressed);
					er1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked57", er1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		eb2 = (Button) findViewById(R.id.ebutton2);
		if (er2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked58", er2);
					editor.apply();
				} else {
					eb2.setBackgroundResource(R.drawable.pressed);
					er2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked58", er2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		eb3 = (Button) findViewById(R.id.ebutton3);
		if (er3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked59", er3);
					editor.apply();
				} else {
					eb3.setBackgroundResource(R.drawable.pressed);
					er3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked59", er3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		eb4 = (Button) findViewById(R.id.ebutton4);
		if (er4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked60", er4);
					editor.apply();
				} else {
					eb4.setBackgroundResource(R.drawable.pressed);
					er4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked60", er4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		eb5 = (Button) findViewById(R.id.ebutton5);
		if (er5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked61", er5);
					editor.apply();
				} else {
					eb5.setBackgroundResource(R.drawable.pressed);
					er5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked61", er5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		eb6 = (Button) findViewById(R.id.ebutton6);
		if (er6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked62", er6);
					editor.apply();
				} else {
					eb6.setBackgroundResource(R.drawable.pressed);
					er6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked62", er6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		eb7 = (Button) findViewById(R.id.ebutton7);
		if (er7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked63", er7);
					editor.apply();
				} else {
					eb7.setBackgroundResource(R.drawable.pressed);
					er7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked63", er7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		eb8 = (Button) findViewById(R.id.ebutton8);
		if (er8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked64", er8);
					editor.apply();
				} else {
					eb8.setBackgroundResource(R.drawable.pressed);
					er8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked64", er8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// 2st
		// square------------------------------------------------------------------------------
		s2fb1 = (Button) findViewById(R.id.s2button1);
		if (s2fr1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked65", s2fr1);
					editor.apply();
				} else {
					s2fb1.setBackgroundResource(R.drawable.pressed);
					s2fr1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked65", s2fr1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2fb2 = (Button) findViewById(R.id.s2button2);
		if (s2fr2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked66", s2fr2);
					editor.apply();
				} else {
					s2fb2.setBackgroundResource(R.drawable.pressed);
					s2fr2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked66", s2fr2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2fb3 = (Button) findViewById(R.id.s2button3);
		if (s2fr3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked67", s2fr3);
					editor.apply();
				} else {
					s2fb3.setBackgroundResource(R.drawable.pressed);
					s2fr3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked67", s2fr3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2fb4 = (Button) findViewById(R.id.s2button4);
		if (s2fr4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked68", s2fr4);
					editor.apply();
				} else {
					s2fb4.setBackgroundResource(R.drawable.pressed);
					s2fr4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked68", s2fr4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2fb5 = (Button) findViewById(R.id.s2button5);
		if (s2fr5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked69", s2fr5);
					editor.apply();
				} else {
					s2fb5.setBackgroundResource(R.drawable.pressed);
					s2fr5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked69", s2fr5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2fb6 = (Button) findViewById(R.id.s2button6);
		if (s2fr6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked70", s2fr6);
					editor.apply();
				} else {
					s2fb6.setBackgroundResource(R.drawable.pressed);
					s2fr6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked70", s2fr6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2fb7 = (Button) findViewById(R.id.s2button7);
		if (s2fr7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked71", s2fr7);
					editor.apply();
				} else {
					s2fb7.setBackgroundResource(R.drawable.pressed);
					s2fr7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked71", s2fr7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2fb8 = (Button) findViewById(R.id.s2button8);
		if (s2fr8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked72", s2fr8);
					editor.apply();
				} else {
					s2fb8.setBackgroundResource(R.drawable.pressed);
					s2fr8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked72", s2fr8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------
		s2sb1 = (Button) findViewById(R.id.s2sbutton1);
		if (s2sr1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked73", s2sr1);
					editor.apply();
				} else {
					s2sb1.setBackgroundResource(R.drawable.pressed);
					s2sr1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked73", s2sr1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2sb2 = (Button) findViewById(R.id.s2sbutton2);
		if (s2sr2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked74", s2sr2);
					editor.apply();
				} else {
					s2sb2.setBackgroundResource(R.drawable.pressed);
					s2sr2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked74", s2sr2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2sb3 = (Button) findViewById(R.id.s2sbutton3);
		if (s2sr3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked75", s2sr3);
					editor.apply();
				} else {
					s2sb3.setBackgroundResource(R.drawable.pressed);
					s2sr3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked75", s2sr3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2sb4 = (Button) findViewById(R.id.s2sbutton4);
		if (s2sr4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked76", s2sr4);
					editor.apply();
				} else {
					s2sb4.setBackgroundResource(R.drawable.pressed);
					s2sr4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked76", s2sr4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2sb5 = (Button) findViewById(R.id.s2sbutton5);
		if (s2sr5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked77", s2sr5);
					editor.apply();
				} else {
					s2sb5.setBackgroundResource(R.drawable.pressed);
					s2sr5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked77", s2sr5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2sb6 = (Button) findViewById(R.id.s2sbutton6);
		if (s2sr6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked78", s2sr6);
					editor.apply();
				} else {
					s2sb6.setBackgroundResource(R.drawable.pressed);
					s2sr6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked78", s2sr6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2sb7 = (Button) findViewById(R.id.s2sbutton7);
		if (s2sr7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked79", s2sr7);
					editor.apply();
				} else {
					s2sb7.setBackgroundResource(R.drawable.pressed);
					s2sr7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked79", s2sr7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2sb8 = (Button) findViewById(R.id.s2sbutton8);
		if (s2sr8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked80", s2sr8);
					editor.apply();
				} else {
					s2sb8.setBackgroundResource(R.drawable.pressed);
					s2sr8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked80", s2sr8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// ------------------------------------------------------------------------------------
		s2tb1 = (Button) findViewById(R.id.s2tbutton1);
		if (s2tr1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked81", s2tr1);
					editor.apply();
				} else {
					s2tb1.setBackgroundResource(R.drawable.pressed);
					s2tr1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked81", s2tr1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2tb2 = (Button) findViewById(R.id.s2tbutton2);
		if (s2tr2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked82", s2tr2);
					editor.apply();
				} else {
					s2tb2.setBackgroundResource(R.drawable.pressed);
					s2tr2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked82", s2tr2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2tb3 = (Button) findViewById(R.id.s2tbutton3);
		if (s2tr3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked83", s2tr3);
					editor.apply();
				} else {
					s2tb3.setBackgroundResource(R.drawable.pressed);
					s2tr3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked83", s2tr3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2tb4 = (Button) findViewById(R.id.s2tbutton4);
		if (s2tr4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked84", s2tr4);
					editor.apply();
				} else {
					s2tb4.setBackgroundResource(R.drawable.pressed);
					s2tr4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked84", s2tr4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2tb5 = (Button) findViewById(R.id.s2tbutton5);
		if (s2tr5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked85", s2tr5);
					editor.apply();
				} else {
					s2tb5.setBackgroundResource(R.drawable.pressed);
					s2tr5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked85", s2tr5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2tb6 = (Button) findViewById(R.id.s2tbutton6);
		if (s2tr6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked86", s2tr6);
					editor.apply();
				} else {
					s2tb6.setBackgroundResource(R.drawable.pressed);
					s2tr6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked86", s2tr6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2tb7 = (Button) findViewById(R.id.s2tbutton7);
		if (s2tr7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked87", s2tr7);
					editor.apply();
				} else {
					s2tb7.setBackgroundResource(R.drawable.pressed);
					s2tr7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked87", s2tr7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2tb8 = (Button) findViewById(R.id.s2tbutton8);
		if (s2tr8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked88", s2tr8);
					editor.apply();
				} else {
					s2tb8.setBackgroundResource(R.drawable.pressed);
					s2tr8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked88", s2tr8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// ------------------------------------------------------------------------------------
		s2fob1 = (Button) findViewById(R.id.s2fobutton1);
		if (s2for1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked89", s2for1);
					editor.apply();
				} else {
					s2fob1.setBackgroundResource(R.drawable.pressed);
					s2for1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked89", s2for1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2fob2 = (Button) findViewById(R.id.s2fobutton2);
		if (s2for2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked90", s2for2);
					editor.apply();
				} else {
					s2fob2.setBackgroundResource(R.drawable.pressed);
					s2for2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked90", s2for2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2fob3 = (Button) findViewById(R.id.s2fobutton3);
		if (s2for3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked91", s2for3);
					editor.apply();
				} else {
					s2fob3.setBackgroundResource(R.drawable.pressed);
					s2for3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked91", s2for3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2fob4 = (Button) findViewById(R.id.s2fobutton4);
		if (s2for4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked92", s2for4);
					editor.apply();
				} else {
					s2fob4.setBackgroundResource(R.drawable.pressed);
					s2for4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked92", s2for4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2fob5 = (Button) findViewById(R.id.s2fobutton5);
		if (s2for5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked93", s2for5);
					editor.apply();
				} else {
					s2fob5.setBackgroundResource(R.drawable.pressed);
					s2for5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked93", s2for5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2fob6 = (Button) findViewById(R.id.s2fobutton6);
		if (s2for6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked94", s2for6);
					editor.apply();
				} else {
					s2fob6.setBackgroundResource(R.drawable.pressed);
					s2for6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked94", s2for6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2fob7 = (Button) findViewById(R.id.s2fobutton7);
		if (s2for7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked95", s2for7);
					editor.apply();
				} else {
					s2fob7.setBackgroundResource(R.drawable.pressed);
					s2for7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked95", s2for7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2fob8 = (Button) findViewById(R.id.s2fobutton8);
		if (s2for8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked96", s2for8);
					editor.apply();
				} else {
					s2fob8.setBackgroundResource(R.drawable.pressed);
					s2for8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked96", s2for8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// ------------------------------------------------------------------------------------
		s2fib1 = (Button) findViewById(R.id.s2fibutton1);
		if (s2fir1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked97", s2fir1);
					editor.apply();
				} else {
					s2fib1.setBackgroundResource(R.drawable.pressed);
					s2fir1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked97", s2fir1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2fib2 = (Button) findViewById(R.id.s2fibutton2);
		if (s2fir2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked98", s2fir2);
					editor.apply();
				} else {
					s2fib2.setBackgroundResource(R.drawable.pressed);
					s2fir2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked98", s2fir2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2fib3 = (Button) findViewById(R.id.s2fibutton3);
		if (s2fir3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked99", s2fir3);
					editor.apply();
				} else {
					s2fib3.setBackgroundResource(R.drawable.pressed);
					s2fir3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked99", s2fir3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2fib4 = (Button) findViewById(R.id.s2fibutton4);
		if (s2fir4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked100", s2fir4);
					editor.apply();
				} else {
					s2fib4.setBackgroundResource(R.drawable.pressed);
					s2fir4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked100", s2fir4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2fib5 = (Button) findViewById(R.id.s2fibutton5);
		if (s2fir5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked101", s2fir5);
					editor.apply();
				} else {
					s2fib5.setBackgroundResource(R.drawable.pressed);
					s2fir5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked101", s2fir5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2fib6 = (Button) findViewById(R.id.s2fibutton6);
		if (s2fir6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked102", s2fir6);
					editor.apply();
				} else {
					s2fib6.setBackgroundResource(R.drawable.pressed);
					s2fir6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked102", s2fir6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2fib7 = (Button) findViewById(R.id.s2fibutton7);
		if (s2fir7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked103", s2fir7);
					editor.apply();
				} else {
					s2fib7.setBackgroundResource(R.drawable.pressed);
					s2fir7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked103", s2fir7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2fib8 = (Button) findViewById(R.id.s2fibutton8);
		if (s2fir8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked104", s2fir8);
					editor.apply();
				} else {
					s2fib8.setBackgroundResource(R.drawable.pressed);
					s2fir8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked104", s2fir8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------
		s2sib1 = (Button) findViewById(R.id.s2sibutton1);
		if (s2sir1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked105", s2sir1);
					editor.apply();
				} else {
					s2sib1.setBackgroundResource(R.drawable.pressed);
					s2sir1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked105", s2sir1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2sib2 = (Button) findViewById(R.id.s2sibutton2);
		if (s2sir2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked106", s2sir2);
					editor.apply();
				} else {
					s2sib2.setBackgroundResource(R.drawable.pressed);
					s2sir2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked106", s2sir2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2sib3 = (Button) findViewById(R.id.s2sibutton3);
		if (s2sir3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked107", s2sir3);
					editor.apply();
				} else {
					s2sib3.setBackgroundResource(R.drawable.pressed);
					s2sir3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked107", s2sir3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2sib4 = (Button) findViewById(R.id.s2sibutton4);
		if (s2sir4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked108", s2sir4);
					editor.apply();
				} else {
					s2sib4.setBackgroundResource(R.drawable.pressed);
					s2sir4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked108", s2sir4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2sib5 = (Button) findViewById(R.id.s2sibutton5);
		if (s2sir5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked109", s2sir5);
					editor.apply();
				} else {
					s2sib5.setBackgroundResource(R.drawable.pressed);
					s2sir5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked109", s2sir5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2sib6 = (Button) findViewById(R.id.s2sibutton6);
		if (s2sir6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked110", s2sir6);
					editor.apply();
				} else {
					s2sib6.setBackgroundResource(R.drawable.pressed);
					s2sir6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked110", s2sir6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2sib7 = (Button) findViewById(R.id.s2sibutton7);
		if (s2sir7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked111", s2sir7);
					editor.apply();
				} else {
					s2sib7.setBackgroundResource(R.drawable.pressed);
					s2sir7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked111", s2sir7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2sib8 = (Button) findViewById(R.id.s2sibutton8);
		if (s2sir8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked112", s2sir8);
					editor.apply();
				} else {
					s2sib8.setBackgroundResource(R.drawable.pressed);
					s2sir8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked112", s2sir8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------
		s2seb1 = (Button) findViewById(R.id.s2sebutton1);
		if (s2ser1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked113", s2ser1);
					editor.apply();
				} else {
					s2seb1.setBackgroundResource(R.drawable.pressed);
					s2ser1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked113", s2ser1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2seb2 = (Button) findViewById(R.id.s2sebutton2);
		if (s2ser2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked114", s2ser2);
					editor.apply();
				} else {
					s2seb2.setBackgroundResource(R.drawable.pressed);
					s2ser2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked114", s2ser2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2seb3 = (Button) findViewById(R.id.s2sebutton3);
		if (s2ser3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked115", s2ser3);
					editor.apply();
				} else {
					s2seb3.setBackgroundResource(R.drawable.pressed);
					s2ser3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked115", s2ser3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2seb4 = (Button) findViewById(R.id.s2sebutton4);
		if (s2ser4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked116", s2ser4);
					editor.apply();
				} else {
					s2seb4.setBackgroundResource(R.drawable.pressed);
					s2ser4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked116", s2ser4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2seb5 = (Button) findViewById(R.id.s2sebutton5);
		if (s2ser5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked117", s2ser5);
					editor.apply();
				} else {
					s2seb5.setBackgroundResource(R.drawable.pressed);
					s2ser5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked117", s2ser5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2seb6 = (Button) findViewById(R.id.s2sebutton6);
		if (s2ser6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked118", s2ser6);
					editor.apply();
				} else {
					s2seb6.setBackgroundResource(R.drawable.pressed);
					s2ser6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked118", s2ser6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2seb7 = (Button) findViewById(R.id.s2sebutton7);
		if (s2ser7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked119", s2ser7);
					editor.apply();
				} else {
					s2seb7.setBackgroundResource(R.drawable.pressed);
					s2ser7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked119", s2ser7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2seb8 = (Button) findViewById(R.id.s2sebutton8);
		if (s2ser8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked120", s2ser8);
					editor.apply();
				} else {
					s2seb8.setBackgroundResource(R.drawable.pressed);
					s2ser8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked120", s2ser8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------
		s2eb1 = (Button) findViewById(R.id.s2ebutton1);
		if (s2er1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked121", s2er1);
					editor.apply();
				} else {
					s2eb1.setBackgroundResource(R.drawable.pressed);
					s2er1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked121", s2er1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2eb2 = (Button) findViewById(R.id.s2ebutton2);
		if (s2er2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked122", s2er2);
					editor.apply();
				} else {
					s2eb2.setBackgroundResource(R.drawable.pressed);
					s2er2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked122", s2er2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2eb3 = (Button) findViewById(R.id.s2ebutton3);
		if (s2er3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked123", s2er3);
					editor.apply();
				} else {
					s2eb3.setBackgroundResource(R.drawable.pressed);
					s2er3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked123", s2er3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2eb4 = (Button) findViewById(R.id.s2ebutton4);
		if (s2er4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked124", s2er4);
					editor.apply();
				} else {
					s2eb4.setBackgroundResource(R.drawable.pressed);
					s2er4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked124", s2er4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2eb5 = (Button) findViewById(R.id.s2ebutton5);
		if (s2er5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked125", s2er5);
					editor.apply();
				} else {
					s2eb5.setBackgroundResource(R.drawable.pressed);
					s2er5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked125", s2er5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2eb6 = (Button) findViewById(R.id.s2ebutton6);
		if (s2er6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked126", s2er6);
					editor.apply();
				} else {
					s2eb6.setBackgroundResource(R.drawable.pressed);
					s2er6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked126", s2er6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2eb7 = (Button) findViewById(R.id.s2ebutton7);
		if (s2er7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked127", s2er7);
					editor.apply();
				} else {
					s2eb7.setBackgroundResource(R.drawable.pressed);
					s2er7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked127", s2er7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s2eb8 = (Button) findViewById(R.id.s2ebutton8);
		if (s2er8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked128", s2er8);
					editor.apply();
				} else {
					s2eb8.setBackgroundResource(R.drawable.pressed);
					s2er8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked128", s2er8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// 3st
		// square------------------------------------------------------------------------------
		s3fb1 = (Button) findViewById(R.id.s3button1);
		if (s3fr1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked129", s3fr1);
					editor.apply();
				} else {
					s3fb1.setBackgroundResource(R.drawable.pressed);
					s3fr1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked129", s3fr1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3fb2 = (Button) findViewById(R.id.s3button2);
		if (s3fr2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked130", s3fr2);
					editor.apply();
				} else {
					s3fb2.setBackgroundResource(R.drawable.pressed);
					s3fr2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked130", s3fr2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3fb3 = (Button) findViewById(R.id.s3button3);
		if (s3fr3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked131", s3fr3);
					editor.apply();
				} else {
					s3fb3.setBackgroundResource(R.drawable.pressed);
					s3fr3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked131", s3fr3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3fb4 = (Button) findViewById(R.id.s3button4);
		if (s3fr4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked132", s3fr4);
					editor.apply();
				} else {
					s3fb4.setBackgroundResource(R.drawable.pressed);
					s3fr4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked132", s3fr4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3fb5 = (Button) findViewById(R.id.s3button5);
		if (s3fr5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked133", s3fr5);
					editor.apply();
				} else {
					s3fb5.setBackgroundResource(R.drawable.pressed);
					s3fr5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked133", s3fr5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3fb6 = (Button) findViewById(R.id.s3button6);
		if (s3fr6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked134", s3fr6);
					editor.apply();
				} else {
					s3fb6.setBackgroundResource(R.drawable.pressed);
					s3fr6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked134", s3fr6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3fb7 = (Button) findViewById(R.id.s3button7);
		if (s3fr7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked135", s3fr7);
					editor.apply();
				} else {
					s3fb7.setBackgroundResource(R.drawable.pressed);
					s3fr7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked135", s3fr7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3fb8 = (Button) findViewById(R.id.s3button8);
		if (s3fr8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked136", s3fr8);
					editor.apply();
				} else {
					s3fb8.setBackgroundResource(R.drawable.pressed);
					s3fr8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked136", s3fr8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------
		s3sb1 = (Button) findViewById(R.id.s3sbutton1);
		if (s3sr1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked137", s3sr1);
					editor.apply();
				} else {
					s3sb1.setBackgroundResource(R.drawable.pressed);
					s3sr1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked137", s3sr1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3sb2 = (Button) findViewById(R.id.s3sbutton2);
		if (s3sr2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked138", s3sr2);
					editor.apply();
				} else {
					s3sb2.setBackgroundResource(R.drawable.pressed);
					s3sr2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked138", s3sr2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3sb3 = (Button) findViewById(R.id.s3sbutton3);
		if (s3sr3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked139", s3sr3);
					editor.apply();
				} else {
					s3sb3.setBackgroundResource(R.drawable.pressed);
					s3sr3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked139", s3sr3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3sb4 = (Button) findViewById(R.id.s3sbutton4);
		if (s3sr4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked140", s3sr4);
					editor.apply();
				} else {
					s3sb4.setBackgroundResource(R.drawable.pressed);
					s3sr4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked140", s3sr4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3sb5 = (Button) findViewById(R.id.s3sbutton5);
		if (s3sr5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked141", s3sr5);
					editor.apply();
				} else {
					s3sb5.setBackgroundResource(R.drawable.pressed);
					s3sr5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked141", s3sr5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3sb6 = (Button) findViewById(R.id.s3sbutton6);
		if (s3sr6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked142", s3sr6);
					editor.apply();
				} else {
					s3sb6.setBackgroundResource(R.drawable.pressed);
					s3sr6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked142", s3sr6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3sb7 = (Button) findViewById(R.id.s3sbutton7);
		if (s3sr7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked143", s3sr7);
					editor.apply();
				} else {
					s3sb7.setBackgroundResource(R.drawable.pressed);
					s3sr7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked143", s3sr7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3sb8 = (Button) findViewById(R.id.s3sbutton8);
		if (s3sr8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked144", s3sr8);
					editor.apply();
				} else {
					s3sb8.setBackgroundResource(R.drawable.pressed);
					s3sr8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked144", s3sr8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// ------------------------------------------------------------------------------------
		s3tb1 = (Button) findViewById(R.id.s3tbutton1);
		if (s3tr1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked145", s3tr1);
					editor.apply();
				} else {
					s3tb1.setBackgroundResource(R.drawable.pressed);
					s3tr1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked145", s3tr1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3tb2 = (Button) findViewById(R.id.s3tbutton2);
		if (s3tr2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked146", s3tr2);
					editor.apply();
				} else {
					s3tb2.setBackgroundResource(R.drawable.pressed);
					s3tr2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked146", s3tr2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3tb3 = (Button) findViewById(R.id.s3tbutton3);
		if (s3tr3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked147", s3tr3);
					editor.apply();
				} else {
					s3tb3.setBackgroundResource(R.drawable.pressed);
					s3tr3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked147", s3tr3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3tb4 = (Button) findViewById(R.id.s3tbutton4);
		if (s3tr4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked148", s3tr4);
					editor.apply();
				} else {
					s3tb4.setBackgroundResource(R.drawable.pressed);
					s3tr4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked148", s3tr4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3tb5 = (Button) findViewById(R.id.s3tbutton5);
		if (s3tr5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked149", s3tr5);
					editor.apply();
				} else {
					s3tb5.setBackgroundResource(R.drawable.pressed);
					s3tr5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked149", s3tr5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3tb6 = (Button) findViewById(R.id.s3tbutton6);
		if (s3tr6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked150", s3tr6);
					editor.apply();
				} else {
					s3tb6.setBackgroundResource(R.drawable.pressed);
					s3tr6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked150", s3tr6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3tb7 = (Button) findViewById(R.id.s3tbutton7);
		if (s3tr7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked151", s3tr7);
					editor.apply();
				} else {
					s3tb7.setBackgroundResource(R.drawable.pressed);
					s3tr7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked151", s3tr7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3tb8 = (Button) findViewById(R.id.s3tbutton8);
		if (s3tr8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked152", s3tr8);
					editor.apply();
				} else {
					s3tb8.setBackgroundResource(R.drawable.pressed);
					s3tr8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked152", s3tr8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// ------------------------------------------------------------------------------------
		s3fob1 = (Button) findViewById(R.id.s3fobutton1);
		if (s3for1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked153", s3for1);
					editor.apply();
				} else {
					s3fob1.setBackgroundResource(R.drawable.pressed);
					s3for1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked153", s3for1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3fob2 = (Button) findViewById(R.id.s3fobutton2);
		if (s3for2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked154", s3for2);
					editor.apply();
				} else {
					s3fob2.setBackgroundResource(R.drawable.pressed);
					s3for2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked154", s3for2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3fob3 = (Button) findViewById(R.id.s3fobutton3);
		if (s3for3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked155", s3for3);
					editor.apply();
				} else {
					s3fob3.setBackgroundResource(R.drawable.pressed);
					s3for3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked155", s3for3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3fob4 = (Button) findViewById(R.id.s3fobutton4);
		if (s3for4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked156", s3for4);
					editor.apply();
				} else {
					s3fob4.setBackgroundResource(R.drawable.pressed);
					s3for4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked156", s3for4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3fob5 = (Button) findViewById(R.id.s3fobutton5);
		if (s3for5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked157", s3for5);
					editor.apply();
				} else {
					s3fob5.setBackgroundResource(R.drawable.pressed);
					s3for5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked157", s3for5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3fob6 = (Button) findViewById(R.id.s3fobutton6);
		if (s3for6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked158", s3for6);
					editor.apply();
				} else {
					s3fob6.setBackgroundResource(R.drawable.pressed);
					s3for6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked158", s3for6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3fob7 = (Button) findViewById(R.id.s3fobutton7);
		if (s3for7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked159", s3for7);
					editor.apply();
				} else {
					s3fob7.setBackgroundResource(R.drawable.pressed);
					s3for7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked159", s3for7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3fob8 = (Button) findViewById(R.id.s3fobutton8);
		if (s3for8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked160", s3for8);
					editor.apply();
				} else {
					s3fob8.setBackgroundResource(R.drawable.pressed);
					s3for8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked160", s3for8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// ------------------------------------------------------------------------------------
		s3fib1 = (Button) findViewById(R.id.s3fibutton1);
		if (s3fir1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked161", s3fir1);
					editor.apply();
				} else {
					s3fib1.setBackgroundResource(R.drawable.pressed);
					s3fir1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked161", s3fir1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3fib2 = (Button) findViewById(R.id.s3fibutton2);
		if (s3fir2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked162", s3fir2);
					editor.apply();
				} else {
					s3fib2.setBackgroundResource(R.drawable.pressed);
					s3fir2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked162", s3fir2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3fib3 = (Button) findViewById(R.id.s3fibutton3);
		if (s3fir3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked163", s3fir3);
					editor.apply();
				} else {
					s3fib3.setBackgroundResource(R.drawable.pressed);
					s3fir3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked163", s3fir3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3fib4 = (Button) findViewById(R.id.s3fibutton4);
		if (s3fir4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked164", s3fir4);
					editor.apply();
				} else {
					s3fib4.setBackgroundResource(R.drawable.pressed);
					s3fir4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked164", s3fir4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3fib5 = (Button) findViewById(R.id.s3fibutton5);
		if (s3fir5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked165", s3fir5);
					editor.apply();
				} else {
					s3fib5.setBackgroundResource(R.drawable.pressed);
					s3fir5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked165", s3fir5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3fib6 = (Button) findViewById(R.id.s3fibutton6);
		if (s3fir6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked166", s3fir6);
					editor.apply();
				} else {
					s3fib6.setBackgroundResource(R.drawable.pressed);
					s3fir6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked166", s3fir6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3fib7 = (Button) findViewById(R.id.s3fibutton7);
		if (s3fir7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked167", s3fir7);
					editor.apply();
				} else {
					s3fib7.setBackgroundResource(R.drawable.pressed);
					s3fir7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked167", s3fir7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3fib8 = (Button) findViewById(R.id.s3fibutton8);
		if (s3fir8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked168", s3fir8);
					editor.apply();
				} else {
					s3fib8.setBackgroundResource(R.drawable.pressed);
					s3fir8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked168", s3fir8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------
		s3sib1 = (Button) findViewById(R.id.s3sibutton1);
		if (s3sir1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked169", s3sir1);
					editor.apply();
				} else {
					s3sib1.setBackgroundResource(R.drawable.pressed);
					s3sir1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked169", s3sir1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3sib2 = (Button) findViewById(R.id.s3sibutton2);
		if (s3sir2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked170", s3sir2);
					editor.apply();
				} else {
					s3sib2.setBackgroundResource(R.drawable.pressed);
					s3sir2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked170", s3sir2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3sib3 = (Button) findViewById(R.id.s3sibutton3);
		if (s3sir3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked171", s3sir3);
					editor.apply();
				} else {
					s3sib3.setBackgroundResource(R.drawable.pressed);
					s3sir3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked171", s3sir3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3sib4 = (Button) findViewById(R.id.s3sibutton4);
		if (s3sir4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked172", s3sir4);
					editor.apply();
				} else {
					s3sib4.setBackgroundResource(R.drawable.pressed);
					s3sir4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked172", s3sir4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3sib5 = (Button) findViewById(R.id.s3sibutton5);
		if (s3sir5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked173", s3sir5);
					editor.apply();
				} else {
					s3sib5.setBackgroundResource(R.drawable.pressed);
					s3sir5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked173", s3sir5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3sib6 = (Button) findViewById(R.id.s3sibutton6);
		if (s3sir6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked174", s3sir6);
					editor.apply();
				} else {
					s3sib6.setBackgroundResource(R.drawable.pressed);
					s3sir6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked174", s3sir6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3sib7 = (Button) findViewById(R.id.s3sibutton7);
		if (s3sir7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked175", s3sir7);
					editor.apply();
				} else {
					s3sib7.setBackgroundResource(R.drawable.pressed);
					s3sir7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked175", s3sir7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3sib8 = (Button) findViewById(R.id.s3sibutton8);
		if (s3sir8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked176", s3sir8);
					editor.apply();
				} else {
					s3sib8.setBackgroundResource(R.drawable.pressed);
					s3sir8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked176", s3sir8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------
		s3seb1 = (Button) findViewById(R.id.s3sebutton1);
		if (s3ser1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked177", s3ser1);
					editor.apply();
				} else {
					s3seb1.setBackgroundResource(R.drawable.pressed);
					s3ser1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked177", s3ser1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3seb2 = (Button) findViewById(R.id.s3sebutton2);
		if (s3ser2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked178", s3ser2);
					editor.apply();
				} else {
					s3seb2.setBackgroundResource(R.drawable.pressed);
					s3ser2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked178", s3ser2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3seb3 = (Button) findViewById(R.id.s3sebutton3);
		if (s3ser3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked179", s3ser3);
					editor.apply();
				} else {
					s3seb3.setBackgroundResource(R.drawable.pressed);
					s3ser3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked179", s3ser3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3seb4 = (Button) findViewById(R.id.s3sebutton4);
		if (s3ser4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked180", s3ser4);
					editor.apply();
				} else {
					s3seb4.setBackgroundResource(R.drawable.pressed);
					s3ser4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked180", s3ser4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3seb5 = (Button) findViewById(R.id.s3sebutton5);
		if (s3ser5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked181", s3ser5);
					editor.apply();
				} else {
					s3seb5.setBackgroundResource(R.drawable.pressed);
					s3ser5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked181", s3ser5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3seb6 = (Button) findViewById(R.id.s3sebutton6);
		if (s3ser6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked182", s3ser6);
					editor.apply();
				} else {
					s3seb6.setBackgroundResource(R.drawable.pressed);
					s3ser6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked182", s3ser6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3seb7 = (Button) findViewById(R.id.s3sebutton7);
		if (s3ser7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked183", s3ser7);
					editor.apply();
				} else {
					s3seb7.setBackgroundResource(R.drawable.pressed);
					s3ser7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked183", s3ser7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3seb8 = (Button) findViewById(R.id.s3sebutton8);
		if (s3ser8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked184", s3ser8);
					editor.apply();
				} else {
					s3seb8.setBackgroundResource(R.drawable.pressed);
					s3ser8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked184", s3ser8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------
		s3eb1 = (Button) findViewById(R.id.s3ebutton1);
		if (s3er1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked185", s3er1);
					editor.apply();
				} else {
					s3eb1.setBackgroundResource(R.drawable.pressed);
					s3er1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked185", s3er1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3eb2 = (Button) findViewById(R.id.s3ebutton2);
		if (s3er2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked186", s3er2);
					editor.apply();
				} else {
					s3eb2.setBackgroundResource(R.drawable.pressed);
					s3er2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked186", s3er2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3eb3 = (Button) findViewById(R.id.s3ebutton3);
		if (s3er3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked187", s3er3);
					editor.apply();
				} else {
					s3eb3.setBackgroundResource(R.drawable.pressed);
					s3er3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked187", s3er3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3eb4 = (Button) findViewById(R.id.s3ebutton4);
		if (s3er4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked188", s3er4);
					editor.apply();
				} else {
					s3eb4.setBackgroundResource(R.drawable.pressed);
					s3er4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked188", s3er4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3eb5 = (Button) findViewById(R.id.s3ebutton5);
		if (s3er5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked189", s3er5);
					editor.apply();
				} else {
					s3eb5.setBackgroundResource(R.drawable.pressed);
					s3er5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked189", s3er5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3eb6 = (Button) findViewById(R.id.s3ebutton6);
		if (s3er6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked190", s3er6);
					editor.apply();
				} else {
					s3eb6.setBackgroundResource(R.drawable.pressed);
					s3er6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked190", s3er6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3eb7 = (Button) findViewById(R.id.s3ebutton7);
		if (s3er7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked191", s3er7);
					editor.apply();
				} else {
					s3eb7.setBackgroundResource(R.drawable.pressed);
					s3er7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked191", s3er7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s3eb8 = (Button) findViewById(R.id.s3ebutton8);
		if (s3er8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked192", s3er8);
					editor.apply();
				} else {
					s3eb8.setBackgroundResource(R.drawable.pressed);
					s3er8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked192", s3er8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// 4st
		// square------------------------------------------------------------------------------
		s4fb1 = (Button) findViewById(R.id.s4button1);
		if (s4fr1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked193", s4fr1);
					editor.apply();
				} else {
					s4fb1.setBackgroundResource(R.drawable.pressed);
					s4fr1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked193", s4fr1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4fb2 = (Button) findViewById(R.id.s4button2);
		if (s4fr2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked194", s4fr2);
					editor.apply();
				} else {
					s4fb2.setBackgroundResource(R.drawable.pressed);
					s4fr2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked194", s4fr2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4fb3 = (Button) findViewById(R.id.s4button3);
		if (s4fr3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked195", s4fr3);
					editor.apply();
				} else {
					s4fb3.setBackgroundResource(R.drawable.pressed);
					s4fr3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked195", s4fr3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4fb4 = (Button) findViewById(R.id.s4button4);
		if (s4fr4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked196", s4fr4);
					editor.apply();
				} else {
					s4fb4.setBackgroundResource(R.drawable.pressed);
					s4fr4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked196", s4fr4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4fb5 = (Button) findViewById(R.id.s4button5);
		if (s4fr5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked197", s4fr5);
					editor.apply();
				} else {
					s4fb5.setBackgroundResource(R.drawable.pressed);
					s4fr5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked197", s4fr5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4fb6 = (Button) findViewById(R.id.s4button6);
		if (s4fr6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked198", s4fr6);
					editor.apply();
				} else {
					s4fb6.setBackgroundResource(R.drawable.pressed);
					s4fr6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked198", s4fr6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4fb7 = (Button) findViewById(R.id.s4button7);
		if (s4fr7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked199", s4fr7);
					editor.apply();
				} else {
					s4fb7.setBackgroundResource(R.drawable.pressed);
					s4fr7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked199", s4fr7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4fb8 = (Button) findViewById(R.id.s4button8);
		if (s4fr8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked200", s4fr8);
					editor.apply();
				} else {
					s4fb8.setBackgroundResource(R.drawable.pressed);
					s4fr8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked200", s4fr8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------
		s4sb1 = (Button) findViewById(R.id.s4sbutton1);
		if (s4sr1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked201", s4sr1);
					editor.apply();
				} else {
					s4sb1.setBackgroundResource(R.drawable.pressed);
					s4sr1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked201", s4sr1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4sb2 = (Button) findViewById(R.id.s4sbutton2);
		if (s4sr2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked202", s4sr2);
					editor.apply();
				} else {
					s4sb2.setBackgroundResource(R.drawable.pressed);
					s4sr2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked202", s4sr2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4sb3 = (Button) findViewById(R.id.s4sbutton3);
		if (s4sr3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked203", s4sr3);
					editor.apply();
				} else {
					s4sb3.setBackgroundResource(R.drawable.pressed);
					s4sr3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked203", s4sr3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4sb4 = (Button) findViewById(R.id.s4sbutton4);
		if (s4sr4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked204", s4sr4);
					editor.apply();
				} else {
					s4sb4.setBackgroundResource(R.drawable.pressed);
					s4sr4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked204", s4sr4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4sb5 = (Button) findViewById(R.id.s4sbutton5);
		if (s4sr5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked205", s4sr5);
					editor.apply();
				} else {
					s4sb5.setBackgroundResource(R.drawable.pressed);
					s4sr5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked205", s4sr5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4sb6 = (Button) findViewById(R.id.s4sbutton6);
		if (s4sr6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked206", s4sr6);
					editor.apply();
				} else {
					s4sb6.setBackgroundResource(R.drawable.pressed);
					s4sr6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked206", s4sr6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4sb7 = (Button) findViewById(R.id.s4sbutton7);
		if (s4sr7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked207", s4sr7);
					editor.apply();
				} else {
					s4sb7.setBackgroundResource(R.drawable.pressed);
					s4sr7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked207", s4sr7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4sb8 = (Button) findViewById(R.id.s4sbutton8);
		if (s4sr8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked208", s4sr8);
					editor.apply();
				} else {
					s4sb8.setBackgroundResource(R.drawable.pressed);
					s4sr8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked208", s4sr8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// ------------------------------------------------------------------------------------
		s4tb1 = (Button) findViewById(R.id.s4tbutton1);
		if (s4tr1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked209", s4tr1);
					editor.apply();
				} else {
					s4tb1.setBackgroundResource(R.drawable.pressed);
					s4tr1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked209", s4tr1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4tb2 = (Button) findViewById(R.id.s4tbutton2);
		if (s4tr2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked210", s4tr2);
					editor.apply();
				} else {
					s4tb2.setBackgroundResource(R.drawable.pressed);
					s4tr2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked210", s4tr2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4tb3 = (Button) findViewById(R.id.s4tbutton3);
		if (s4tr3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked211", s4tr3);
					editor.apply();
				} else {
					s4tb3.setBackgroundResource(R.drawable.pressed);
					s4tr3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked211", s4tr3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4tb4 = (Button) findViewById(R.id.s4tbutton4);
		if (s4tr4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked212", s4tr4);
					editor.apply();
				} else {
					s4tb4.setBackgroundResource(R.drawable.pressed);
					s4tr4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked212", s4tr4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4tb5 = (Button) findViewById(R.id.s4tbutton5);
		if (s4tr5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked213", s4tr5);
					editor.apply();
				} else {
					s4tb5.setBackgroundResource(R.drawable.pressed);
					s4tr5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked213", s4tr5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4tb6 = (Button) findViewById(R.id.s4tbutton6);
		if (s4tr6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked214", s4tr6);
					editor.apply();
				} else {
					s4tb6.setBackgroundResource(R.drawable.pressed);
					s4tr6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked214", s4tr6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4tb7 = (Button) findViewById(R.id.s4tbutton7);
		if (s4tr7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked215", s4tr7);
					editor.apply();
				} else {
					s4tb7.setBackgroundResource(R.drawable.pressed);
					s4tr7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked215", s4tr7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4tb8 = (Button) findViewById(R.id.s4tbutton8);
		if (s4tr8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked216", s4tr8);
					editor.apply();
				} else {
					s4tb8.setBackgroundResource(R.drawable.pressed);
					s4tr8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked216", s4tr8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// ------------------------------------------------------------------------------------
		s4fob1 = (Button) findViewById(R.id.s4fobutton1);
		if (s4for1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked217", s4for1);
					editor.apply();
				} else {
					s4fob1.setBackgroundResource(R.drawable.pressed);
					s4for1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked217", s4for1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4fob2 = (Button) findViewById(R.id.s4fobutton2);
		if (s4for2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked218", s4for2);
					editor.apply();
				} else {
					s4fob2.setBackgroundResource(R.drawable.pressed);
					s4for2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked218", s4for2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4fob3 = (Button) findViewById(R.id.s4fobutton3);
		if (s4for3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked219", s4for3);
					editor.apply();
				} else {
					s4fob3.setBackgroundResource(R.drawable.pressed);
					s4for3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked219", s4for3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4fob4 = (Button) findViewById(R.id.s4fobutton4);
		if (s4for4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked220", s4for4);
					editor.apply();
				} else {
					s4fob4.setBackgroundResource(R.drawable.pressed);
					s4for4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked220", s4for4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4fob5 = (Button) findViewById(R.id.s4fobutton5);
		if (s4for5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked221", s4for5);
					editor.apply();
				} else {
					s4fob5.setBackgroundResource(R.drawable.pressed);
					s4for5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked221", s4for5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4fob6 = (Button) findViewById(R.id.s4fobutton6);
		if (s4for6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked222", s4for6);
					editor.apply();
				} else {
					s4fob6.setBackgroundResource(R.drawable.pressed);
					s4for6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked222", s4for6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4fob7 = (Button) findViewById(R.id.s4fobutton7);
		if (s4for7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked223", s4for7);
					editor.apply();
				} else {
					s4fob7.setBackgroundResource(R.drawable.pressed);
					s4for7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked223", s4for7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4fob8 = (Button) findViewById(R.id.s4fobutton8);
		if (s4for8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked224", s4for8);
					editor.apply();
				} else {
					s4fob8.setBackgroundResource(R.drawable.pressed);
					s4for8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked224", s4for8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// ------------------------------------------------------------------------------------
		s4fib1 = (Button) findViewById(R.id.s4fibutton1);
		if (s4fir1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked225", s4fir1);
					editor.apply();
				} else {
					s4fib1.setBackgroundResource(R.drawable.pressed);
					s4fir1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked225", s4fir1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4fib2 = (Button) findViewById(R.id.s4fibutton2);
		if (s4fir2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked226", s4fir2);
					editor.apply();
				} else {
					s4fib2.setBackgroundResource(R.drawable.pressed);
					s4fir2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked226", s4fir2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4fib3 = (Button) findViewById(R.id.s4fibutton3);
		if (s4fir3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked227", s4fir3);
					editor.apply();
				} else {
					s4fib3.setBackgroundResource(R.drawable.pressed);
					s4fir3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked227", s4fir3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4fib4 = (Button) findViewById(R.id.s4fibutton4);
		if (s4fir4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked228", s4fir4);
					editor.apply();
				} else {
					s4fib4.setBackgroundResource(R.drawable.pressed);
					s4fir4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked228", s4fir4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4fib5 = (Button) findViewById(R.id.s4fibutton5);
		if (s4fir5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked229", s4fir5);
					editor.apply();
				} else {
					s4fib5.setBackgroundResource(R.drawable.pressed);
					s4fir5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked229", s4fir5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4fib6 = (Button) findViewById(R.id.s4fibutton6);
		if (s4fir6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked230", s4fir6);
					editor.apply();
				} else {
					s4fib6.setBackgroundResource(R.drawable.pressed);
					s4fir6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked230", s4fir6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4fib7 = (Button) findViewById(R.id.s4fibutton7);
		if (s4fir7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked231", s4fir7);
					editor.apply();
				} else {
					s4fib7.setBackgroundResource(R.drawable.pressed);
					s4fir7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked231", s4fir7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4fib8 = (Button) findViewById(R.id.s4fibutton8);
		if (s4fir8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked232", s4fir8);
					editor.apply();
				} else {
					s4fib8.setBackgroundResource(R.drawable.pressed);
					s4fir8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked232", s4fir8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------
		s4sib1 = (Button) findViewById(R.id.s4sibutton1);
		if (s4sir1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked233", s4sir1);
					editor.apply();
				} else {
					s4sib1.setBackgroundResource(R.drawable.pressed);
					s4sir1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked233", s4sir1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4sib2 = (Button) findViewById(R.id.s4sibutton2);
		if (s4sir2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked234", s4sir2);
					editor.apply();
				} else {
					s4sib2.setBackgroundResource(R.drawable.pressed);
					s4sir2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked234", s4sir2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4sib3 = (Button) findViewById(R.id.s4sibutton3);
		if (s4sir3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked235", s4sir3);
					editor.apply();
				} else {
					s4sib3.setBackgroundResource(R.drawable.pressed);
					s4sir3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked235", s4sir3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4sib4 = (Button) findViewById(R.id.s4sibutton4);
		if (s4sir4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked236", s4sir4);
					editor.apply();
				} else {
					s4sib4.setBackgroundResource(R.drawable.pressed);
					s4sir4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked236", s4sir4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4sib5 = (Button) findViewById(R.id.s4sibutton5);
		if (s4sir5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked237", s4sir5);
					editor.apply();
				} else {
					s4sib5.setBackgroundResource(R.drawable.pressed);
					s4sir5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked237", s4sir5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4sib6 = (Button) findViewById(R.id.s4sibutton6);
		if (s4sir6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked238", s4sir6);
					editor.apply();
				} else {
					s4sib6.setBackgroundResource(R.drawable.pressed);
					s4sir6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked238", s4sir6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4sib7 = (Button) findViewById(R.id.s4sibutton7);
		if (s4sir7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked239", s4sir7);
					editor.apply();
				} else {
					s4sib7.setBackgroundResource(R.drawable.pressed);
					s4sir7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked239", s4sir7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4sib8 = (Button) findViewById(R.id.s4sibutton8);
		if (s4sir8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked240", s4sir8);
					editor.apply();
				} else {
					s4sib8.setBackgroundResource(R.drawable.pressed);
					s4sir8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked240", s4sir8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------
		s4seb1 = (Button) findViewById(R.id.s4sebutton1);
		if (s4ser1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked241", s4ser1);
					editor.apply();
				} else {
					s4seb1.setBackgroundResource(R.drawable.pressed);
					s4ser1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked241", s4ser1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4seb2 = (Button) findViewById(R.id.s4sebutton2);
		if (s4ser2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked242", s4ser2);
					editor.apply();
				} else {
					s4seb2.setBackgroundResource(R.drawable.pressed);
					s4ser2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked242", s4ser2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4seb3 = (Button) findViewById(R.id.s4sebutton3);
		if (s4ser3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked243", s4ser3);
					editor.apply();
				} else {
					s4seb3.setBackgroundResource(R.drawable.pressed);
					s4ser3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked243", s4ser3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4seb4 = (Button) findViewById(R.id.s4sebutton4);
		if (s4ser4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked244", s4ser4);
					editor.apply();
				} else {
					s4seb4.setBackgroundResource(R.drawable.pressed);
					s4ser4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked244", s4ser4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4seb5 = (Button) findViewById(R.id.s4sebutton5);
		if (s4ser5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked245", s4ser5);
					editor.apply();
				} else {
					s4seb5.setBackgroundResource(R.drawable.pressed);
					s4ser5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked245", s4ser5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4seb6 = (Button) findViewById(R.id.s4sebutton6);
		if (s4ser6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked246", s4ser6);
					editor.apply();
				} else {
					s4seb6.setBackgroundResource(R.drawable.pressed);
					s4ser6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked246", s4ser6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4seb7 = (Button) findViewById(R.id.s4sebutton7);
		if (s4ser7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked247", s4ser7);
					editor.apply();
				} else {
					s4seb7.setBackgroundResource(R.drawable.pressed);
					s4ser7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked247", s4ser7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4seb8 = (Button) findViewById(R.id.s4sebutton8);
		if (s4ser8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked248", s4ser8);
					editor.apply();
				} else {
					s4seb8.setBackgroundResource(R.drawable.pressed);
					s4ser8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked248", s4ser8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------
		s4eb1 = (Button) findViewById(R.id.s4ebutton1);
		if (s4er1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked249", s4er1);
					editor.apply();
				} else {
					s4eb1.setBackgroundResource(R.drawable.pressed);
					s4er1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked249", s4er1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4eb2 = (Button) findViewById(R.id.s4ebutton2);
		if (s4er2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked250", s4er2);
					editor.apply();
				} else {
					s4eb2.setBackgroundResource(R.drawable.pressed);
					s4er2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked250", s4er2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4eb3 = (Button) findViewById(R.id.s4ebutton3);
		if (s4er3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked251", s4er3);
					editor.apply();
				} else {
					s4eb3.setBackgroundResource(R.drawable.pressed);
					s4er3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked251", s4er3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4eb4 = (Button) findViewById(R.id.s4ebutton4);
		if (s4er4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked252", s4er4);
					editor.apply();
				} else {
					s4eb4.setBackgroundResource(R.drawable.pressed);
					s4er4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked252", s4er4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4eb5 = (Button) findViewById(R.id.s4ebutton5);
		if (s4er5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked253", s4er5);
					editor.apply();
				} else {
					s4eb5.setBackgroundResource(R.drawable.pressed);
					s4er5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked253", s4er5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4eb6 = (Button) findViewById(R.id.s4ebutton6);
		if (s4er6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked254", s4er6);
					editor.apply();
				} else {
					s4eb6.setBackgroundResource(R.drawable.pressed);
					s4er6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked254", s4er6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4eb7 = (Button) findViewById(R.id.s4ebutton7);
		if (s4er7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked255", s4er7);
					editor.apply();
				} else {
					s4eb7.setBackgroundResource(R.drawable.pressed);
					s4er7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked255", s4er7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s4eb8 = (Button) findViewById(R.id.s4ebutton8);
		if (s4er8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked256", s4er8);
					editor.apply();
				} else {
					s4eb8.setBackgroundResource(R.drawable.pressed);
					s4er8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked256", s4er8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// 5st
		// square------------------------------------------------------------------------------
		s5fb1 = (Button) findViewById(R.id.s5button1);
		if (s5fr1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked257", s5fr1);
					editor.apply();
				} else {
					s5fb1.setBackgroundResource(R.drawable.pressed);
					s5fr1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked257", s5fr1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5fb2 = (Button) findViewById(R.id.s5button2);
		if (s5fr2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked258", s5fr2);
					editor.apply();
				} else {
					s5fb2.setBackgroundResource(R.drawable.pressed);
					s5fr2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked258", s5fr2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5fb3 = (Button) findViewById(R.id.s5button3);
		if (s5fr3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked259", s5fr3);
					editor.apply();
				} else {
					s5fb3.setBackgroundResource(R.drawable.pressed);
					s5fr3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked259", s5fr3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5fb4 = (Button) findViewById(R.id.s5button4);
		if (s5fr4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked260", s5fr4);
					editor.apply();
				} else {
					s5fb4.setBackgroundResource(R.drawable.pressed);
					s5fr4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked260", s5fr4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5fb5 = (Button) findViewById(R.id.s5button5);
		if (s5fr5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked261", s5fr5);
					editor.apply();
				} else {
					s5fb5.setBackgroundResource(R.drawable.pressed);
					s5fr5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked261", s5fr5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5fb6 = (Button) findViewById(R.id.s5button6);
		if (s5fr6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked262", s5fr6);
					editor.apply();
				} else {
					s5fb6.setBackgroundResource(R.drawable.pressed);
					s5fr6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked262", s5fr6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5fb7 = (Button) findViewById(R.id.s5button7);
		if (s5fr7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked263", s5fr7);
					editor.apply();
				} else {
					s5fb7.setBackgroundResource(R.drawable.pressed);
					s5fr7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked263", s5fr7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5fb8 = (Button) findViewById(R.id.s5button8);
		if (s5fr8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked264", s5fr8);
					editor.apply();
				} else {
					s5fb8.setBackgroundResource(R.drawable.pressed);
					s5fr8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked264", s5fr8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------
		s5sb1 = (Button) findViewById(R.id.s5sbutton1);
		if (s5sr1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked265", s5sr1);
					editor.apply();
				} else {
					s5sb1.setBackgroundResource(R.drawable.pressed);
					s5sr1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked265", s5sr1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5sb2 = (Button) findViewById(R.id.s5sbutton2);
		if (s5sr2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked266", s5sr2);
					editor.apply();
				} else {
					s5sb2.setBackgroundResource(R.drawable.pressed);
					s5sr2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked266", s5sr2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5sb3 = (Button) findViewById(R.id.s5sbutton3);
		if (s5sr3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked267", s5sr3);
					editor.apply();
				} else {
					s5sb3.setBackgroundResource(R.drawable.pressed);
					s5sr3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked267", s5sr3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5sb4 = (Button) findViewById(R.id.s5sbutton4);
		if (s5sr4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked268", s5sr4);
					editor.apply();
				} else {
					s5sb4.setBackgroundResource(R.drawable.pressed);
					s5sr4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked268", s5sr4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5sb5 = (Button) findViewById(R.id.s5sbutton5);
		if (s5sr5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked269", s5sr5);
					editor.apply();
				} else {
					s5sb5.setBackgroundResource(R.drawable.pressed);
					s5sr5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked269", s5sr5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5sb6 = (Button) findViewById(R.id.s5sbutton6);
		if (s5sr6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked270", s5sr6);
					editor.apply();
				} else {
					s5sb6.setBackgroundResource(R.drawable.pressed);
					s5sr6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked270", s5sr6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5sb7 = (Button) findViewById(R.id.s5sbutton7);
		if (s5sr7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked271", s5sr7);
					editor.apply();
				} else {
					s5sb7.setBackgroundResource(R.drawable.pressed);
					s5sr7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked271", s5sr7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5sb8 = (Button) findViewById(R.id.s5sbutton8);
		if (s5sr8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked272", s5sr8);
					editor.apply();
				} else {
					s5sb8.setBackgroundResource(R.drawable.pressed);
					s5sr8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked272", s5sr8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// ------------------------------------------------------------------------------------
		s5tb1 = (Button) findViewById(R.id.s5tbutton1);
		if (s5tr1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked273", s5tr1);
					editor.apply();
				} else {
					s5tb1.setBackgroundResource(R.drawable.pressed);
					s5tr1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked273", s5tr1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5tb2 = (Button) findViewById(R.id.s5tbutton2);
		if (s5tr2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked274", s5tr2);
					editor.apply();
				} else {
					s5tb2.setBackgroundResource(R.drawable.pressed);
					s5tr2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked274", s5tr2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5tb3 = (Button) findViewById(R.id.s5tbutton3);
		if (s5tr3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked275", s5tr3);
					editor.apply();
				} else {
					s5tb3.setBackgroundResource(R.drawable.pressed);
					s5tr3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked275", s5tr3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5tb4 = (Button) findViewById(R.id.s5tbutton4);
		if (s5tr4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked276", s5tr4);
					editor.apply();
				} else {
					s5tb4.setBackgroundResource(R.drawable.pressed);
					s5tr4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked276", s5tr4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5tb5 = (Button) findViewById(R.id.s5tbutton5);
		if (s5tr5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked277", s5tr5);
					editor.apply();
				} else {
					s5tb5.setBackgroundResource(R.drawable.pressed);
					s5tr5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked277", s5tr5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5tb6 = (Button) findViewById(R.id.s5tbutton6);
		if (s5tr6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked278", s5tr6);
					editor.apply();
				} else {
					s5tb6.setBackgroundResource(R.drawable.pressed);
					s5tr6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked278", s5tr6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5tb7 = (Button) findViewById(R.id.s5tbutton7);
		if (s5tr7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked279", s5tr7);
					editor.apply();
				} else {
					s5tb7.setBackgroundResource(R.drawable.pressed);
					s5tr7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked279", s5tr7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5tb8 = (Button) findViewById(R.id.s5tbutton8);
		if (s5tr8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked280", s5tr8);
					editor.apply();
				} else {
					s5tb8.setBackgroundResource(R.drawable.pressed);
					s5tr8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked280", s5tr8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// ------------------------------------------------------------------------------------
		s5fob1 = (Button) findViewById(R.id.s5fobutton1);
		if (s5for1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked281", s5for1);
					editor.apply();
				} else {
					s5fob1.setBackgroundResource(R.drawable.pressed);
					s5for1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked281", s5for1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5fob2 = (Button) findViewById(R.id.s5fobutton2);
		if (s5for2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked282", s5for2);
					editor.apply();
				} else {
					s5fob2.setBackgroundResource(R.drawable.pressed);
					s5for2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked282", s5for2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5fob3 = (Button) findViewById(R.id.s5fobutton3);
		if (s5for3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked283", s5for3);
					editor.apply();
				} else {
					s5fob3.setBackgroundResource(R.drawable.pressed);
					s5for3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked283", s5for3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5fob4 = (Button) findViewById(R.id.s5fobutton4);
		if (s5for4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked284", s5for4);
					editor.apply();
				} else {
					s5fob4.setBackgroundResource(R.drawable.pressed);
					s5for4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked284", s5for4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5fob5 = (Button) findViewById(R.id.s5fobutton5);
		if (s5for5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked285", s5for5);
					editor.apply();
				} else {
					s5fob5.setBackgroundResource(R.drawable.pressed);
					for5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked285", s5for5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5fob6 = (Button) findViewById(R.id.s5fobutton6);
		if (s5for6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked286", s5for6);
					editor.apply();
				} else {
					s5fob6.setBackgroundResource(R.drawable.pressed);
					s5for6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked286", s5for6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5fob7 = (Button) findViewById(R.id.s5fobutton7);
		if (s5for7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked287", s5for7);
					editor.apply();
				} else {
					s5fob7.setBackgroundResource(R.drawable.pressed);
					s5for7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked287", s5for7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5fob8 = (Button) findViewById(R.id.s5fobutton8);
		if (s5for8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked288", s5for8);
					editor.apply();
				} else {
					s5fob8.setBackgroundResource(R.drawable.pressed);
					s5for8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked288", s5for8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// ------------------------------------------------------------------------------------
		s5fib1 = (Button) findViewById(R.id.s5fibutton1);
		if (s5fir1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked289", s5fir1);
					editor.apply();
				} else {
					s5fib1.setBackgroundResource(R.drawable.pressed);
					s5fir1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked289", s5fir1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5fib2 = (Button) findViewById(R.id.s5fibutton2);
		if (s5fir2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked290", s5fir2);
					editor.apply();
				} else {
					s5fib2.setBackgroundResource(R.drawable.pressed);
					s5fir2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked290", s5fir2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5fib3 = (Button) findViewById(R.id.s5fibutton3);
		if (s5fir3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked291", s5fir3);
					editor.apply();
				} else {
					s5fib3.setBackgroundResource(R.drawable.pressed);
					s5fir3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked291", s5fir3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5fib4 = (Button) findViewById(R.id.s5fibutton4);
		if (s5fir4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked292", s5fir4);
					editor.apply();
				} else {
					s5fib4.setBackgroundResource(R.drawable.pressed);
					s5fir4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked292", s5fir4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5fib5 = (Button) findViewById(R.id.s5fibutton5);
		if (s5fir5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked293", s5fir5);
					editor.apply();
				} else {
					s5fib5.setBackgroundResource(R.drawable.pressed);
					s5fir5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked293", s5fir5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5fib6 = (Button) findViewById(R.id.s5fibutton6);
		if (s5fir6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked294", s5fir6);
					editor.apply();
				} else {
					s5fib6.setBackgroundResource(R.drawable.pressed);
					s5fir6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked294", s5fir6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5fib7 = (Button) findViewById(R.id.s5fibutton7);
		if (s5fir7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked295", s5fir7);
					editor.apply();
				} else {
					s5fib7.setBackgroundResource(R.drawable.pressed);
					s5fir7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked295", s5fir7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5fib8 = (Button) findViewById(R.id.s5fibutton8);
		if (s5fir8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked296", s5fir8);
					editor.apply();
				} else {
					s5fib8.setBackgroundResource(R.drawable.pressed);
					s5fir8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked296", s5fir8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------
		s5sib1 = (Button) findViewById(R.id.s5sibutton1);
		if (s5sir1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked297", s5sir1);
					editor.apply();
				} else {
					s5sib1.setBackgroundResource(R.drawable.pressed);
					s5sir1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked297", s5sir1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5sib2 = (Button) findViewById(R.id.s5sibutton2);
		if (s5sir2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked298", s5sir2);
					editor.apply();
				} else {
					s5sib2.setBackgroundResource(R.drawable.pressed);
					s5sir2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked298", s5sir2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5sib3 = (Button) findViewById(R.id.s5sibutton3);
		if (s5sir3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked299", s5sir3);
					editor.apply();
				} else {
					s5sib3.setBackgroundResource(R.drawable.pressed);
					s5sir3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked299", s5sir3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5sib4 = (Button) findViewById(R.id.s5sibutton4);
		if (s5sir4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked300", s5sir4);
					editor.apply();
				} else {
					s5sib4.setBackgroundResource(R.drawable.pressed);
					s5sir4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked300", s5sir4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5sib5 = (Button) findViewById(R.id.s5sibutton5);
		if (s5sir5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked301", s5sir5);
					editor.apply();
				} else {
					s5sib5.setBackgroundResource(R.drawable.pressed);
					s5sir5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked301", s5sir5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5sib6 = (Button) findViewById(R.id.s5sibutton6);
		if (s5sir6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked302", s5sir6);
					editor.apply();
				} else {
					s5sib6.setBackgroundResource(R.drawable.pressed);
					s5sir6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked302", s5sir6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5sib7 = (Button) findViewById(R.id.s5sibutton7);
		if (s5sir7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked303", s5sir7);
					editor.apply();
				} else {
					s5sib7.setBackgroundResource(R.drawable.pressed);
					s5sir7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked303", s5sir7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5sib8 = (Button) findViewById(R.id.s5sibutton8);
		if (s5sir8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked304", s5sir8);
					editor.apply();
				} else {
					s5sib8.setBackgroundResource(R.drawable.pressed);
					s5sir8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked304", s5sir8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------
		s5seb1 = (Button) findViewById(R.id.s5sebutton1);
		if (s5ser1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked305", s5ser1);
					editor.apply();
				} else {
					s5seb1.setBackgroundResource(R.drawable.pressed);
					s5ser1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked305", s5ser1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5seb2 = (Button) findViewById(R.id.s5sebutton2);
		if (s5ser2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked306", s5ser2);
					editor.apply();
				} else {
					s5seb2.setBackgroundResource(R.drawable.pressed);
					s5ser2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked306", s5ser2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5seb3 = (Button) findViewById(R.id.s5sebutton3);
		if (s5ser3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked307", s5ser3);
					editor.apply();
				} else {
					s5seb3.setBackgroundResource(R.drawable.pressed);
					s5ser3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked307", s5ser3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5seb4 = (Button) findViewById(R.id.s5sebutton4);
		if (s5ser4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked308", s5ser4);
					editor.apply();
				} else {
					s5seb4.setBackgroundResource(R.drawable.pressed);
					s5ser4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked308", s5ser4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5seb5 = (Button) findViewById(R.id.s5sebutton5);
		if (s5ser5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked309", s5ser5);
					editor.apply();
				} else {
					s5seb5.setBackgroundResource(R.drawable.pressed);
					s5ser5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked309", s5ser5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5seb6 = (Button) findViewById(R.id.s5sebutton6);
		if (s5ser6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked310", s5ser6);
					editor.apply();
				} else {
					s5seb6.setBackgroundResource(R.drawable.pressed);
					s5ser6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked310", s5ser6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5seb7 = (Button) findViewById(R.id.s5sebutton7);
		if (s5ser7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked311", s5ser7);
					editor.apply();
				} else {
					s5seb7.setBackgroundResource(R.drawable.pressed);
					s5ser7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked311", s5ser7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5seb8 = (Button) findViewById(R.id.s5sebutton8);
		if (s5ser8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked312", s5ser8);
					editor.apply();
				} else {
					s5seb8.setBackgroundResource(R.drawable.pressed);
					s5ser8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked312", s5ser8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		// --------------------------------------------------------------------------------------
		s5eb1 = (Button) findViewById(R.id.s5ebutton1);
		if (s5er1 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked313", s5er1);
					editor.apply();
				} else {
					s5eb1.setBackgroundResource(R.drawable.pressed);
					s5er1 = 128;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked313", s5er1);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5eb2 = (Button) findViewById(R.id.s5ebutton2);
		if (s5er2 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked314", s5er2);
					editor.apply();
				} else {
					s5eb2.setBackgroundResource(R.drawable.pressed);
					s5er2 = 64;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked314", s5er2);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5eb3 = (Button) findViewById(R.id.s5ebutton3);
		if (s5er3 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked315", s5er3);
					editor.apply();
				} else {
					s5eb3.setBackgroundResource(R.drawable.pressed);
					s5er3 = 32;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked315", s5er3);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5eb4 = (Button) findViewById(R.id.s5ebutton4);
		if (s5er4 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked316", s5er4);
					editor.apply();
				} else {
					s5eb4.setBackgroundResource(R.drawable.pressed);
					s5er4 = 16;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked316", s5er4);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5eb5 = (Button) findViewById(R.id.s5ebutton5);
		if (s5er5 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked317", s5er5);
					editor.apply();
				} else {
					s5eb5.setBackgroundResource(R.drawable.pressed);
					s5er5 = 8;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked317", s5er5);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5eb6 = (Button) findViewById(R.id.s5ebutton6);
		if (s5er6 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked318", s5er6);
					editor.apply();
				} else {
					s5eb6.setBackgroundResource(R.drawable.pressed);
					s5er6 = 4;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked318", s5er6);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5eb7 = (Button) findViewById(R.id.s5ebutton7);
		if (s5er7 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked319", s5er7);
					editor.apply();
				} else {
					s5eb7.setBackgroundResource(R.drawable.pressed);
					s5er7 = 2;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked319", s5er7);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});
		s5eb8 = (Button) findViewById(R.id.s5ebutton8);
		if (s5er8 == 0) {
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
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked320", s5er8);
					editor.apply();
				} else {
					s5eb8.setBackgroundResource(R.drawable.pressed);
					s5er8 = 1;
					SharedPreferences preferences2 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor = preferences2.edit();
					editor.putInt("locked320", s5er8);
					editor.apply();
				}
				isPressed = !isPressed;
			}
		});

		Toast.makeText(getApplicationContext(), String.valueOf(allSum),
				Toast.LENGTH_SHORT).show();
		System.out.println("insideActallSum" + allSum);
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
			// 1st square
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

			allSum = frs + srs + trs + fors + firs + sirs + sers + ers + s2frs
					+ s2srs + s2trs + s2fors + s2firs + s2sirs + s2sers + s2ers
					+ s3frs + s3srs + s3trs + s3fors + s3firs + s3sirs + s3sers
					+ s3ers + s4frs + s4srs + s4trs + s4fors + s4firs + s4sirs
					+ s4sers + s4ers + s5frs + s5srs + s5trs + s5fors + s5firs
					+ s5sirs + s5sers + s5ers;

			if (refresh >= 1) {
				System.out.println("아무1" + allSum);
				if (allSum == 0) {
					Toast.makeText(getApplicationContext(),
							"아무 버튼도 입력하지 않았습니다", Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(getApplicationContext(), "재입력되었습니다.",
							Toast.LENGTH_SHORT).show();
					adapter1.deletOneRecord1(del);

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
					long val = adapter1.insertDetails1(strSquare1, strSquare2,
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
					tog = 0;
					SharedPreferences preferences1 = PreferenceManager
							.getDefaultSharedPreferences(this);
					SharedPreferences.Editor editor = preferences1.edit();
					editor.putInt("refresh", refresh);
					editor.putInt("del", del);
					editor.putInt("allSum", allSum);
					editor.putInt("tog", tog);
					editor.apply();
					System.out.println("REPrefresh" + refresh);
					System.out.println("REPdel" + del);
					System.out.println("STOREallSum" + allSum);
				}
			} else {
				if (allSum == 0) {
					System.out.println("아무2" + allSum);
					Toast.makeText(getApplicationContext(),
							"아무 버튼도 입력하지 않았습니다", Toast.LENGTH_SHORT).show();
				} else {
					if (refresh == 0) {
						Toast.makeText(getApplicationContext(), "문구가 저장되었습니다",
								Toast.LENGTH_SHORT).show();
						Log.e("$$$", "store");
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
						long val = adapter1.insertDetails1(strSquare1,
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
						tog = 0;
						SharedPreferences preferences1 = PreferenceManager
								.getDefaultSharedPreferences(this);
						SharedPreferences.Editor editor = preferences1.edit();
						editor.putInt("refresh", refresh);
						editor.putInt("del", del);
						editor.putInt("allSum", allSum);
						editor.putInt("tog", tog);
						editor.apply();
						System.out.println("SAVErefresh" + refresh);
						System.out.println("SAVEdel" + del);
						System.out.println("STOREallSum1" + allSum);
					}
				}
			}
			return true;
		}

		if (id == R.id.reset) {
			// 1st square
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

			allSum = frs + srs + trs + fors + firs + sirs + sers + ers + s2frs
					+ s2srs + s2trs + s2fors + s2firs + s2sirs + s2sers + s2ers
					+ s3frs + s3srs + s3trs + s3fors + s3firs + s3sirs + s3sers
					+ s3ers + s4frs + s4srs + s4trs + s4fors + s4firs + s4sirs
					+ s4sers + s4ers + s5frs + s5srs + s5trs + s5fors + s5firs
					+ s5sirs + s5sers + s5ers;

			System.out.println("RESETallSum" + allSum);
			if (allSum == 0) {
				Toast.makeText(getApplicationContext(), "지울 버튼이 없습니다",
						Toast.LENGTH_SHORT).show();
			} else {
				if (refresh == 0) {
					Toast.makeText(getApplicationContext(), "버튼이 지워졌습니다",
							Toast.LENGTH_SHORT).show();
					Intent intent = getIntent();
					overridePendingTransition(0, 0);
					intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
					finish();

					overridePendingTransition(0, 0);
					startActivity(intent);

					SharedPreferences preferences1 = PreferenceManager
							.getDefaultSharedPreferences(this);
					SharedPreferences.Editor editor = preferences1.edit();
					editor.putInt("locked1", 0);
					editor.putInt("locked2", 0);
					editor.putInt("locked3", 0);
					editor.putInt("locked4", 0);
					editor.putInt("locked5", 0);
					editor.putInt("locked6", 0);
					editor.putInt("locked7", 0);
					editor.putInt("locked8", 0);
					editor.putInt("locked9", 0);
					editor.putInt("locked10", 0);
					editor.putInt("locked11", 0);
					editor.putInt("locked12", 0);
					editor.putInt("locked13", 0);
					editor.putInt("locked14", 0);
					editor.putInt("locked15", 0);
					editor.putInt("locked16", 0);
					editor.putInt("locked17", 0);
					editor.putInt("locked18", 0);
					editor.putInt("locked19", 0);
					editor.putInt("locked20", 0);
					editor.putInt("locked21", 0);
					editor.putInt("locked22", 0);
					editor.putInt("locked23", 0);
					editor.putInt("locked24", 0);
					editor.putInt("locked25", 0);
					editor.putInt("locked26", 0);
					editor.putInt("locked27", 0);
					editor.putInt("locked28", 0);
					editor.putInt("locked29", 0);
					editor.putInt("locked30", 0);
					editor.putInt("locked31", 0);
					editor.putInt("locked32", 0);
					editor.putInt("locked33", 0);
					editor.putInt("locked34", 0);
					editor.putInt("locked35", 0);
					editor.putInt("locked36", 0);
					editor.putInt("locked37", 0);
					editor.putInt("locked38", 0);
					editor.putInt("locked39", 0);
					editor.putInt("locked40", 0);
					editor.putInt("locked41", 0);
					editor.putInt("locked42", 0);
					editor.putInt("locked43", 0);
					editor.putInt("locked44", 0);
					editor.putInt("locked45", 0);
					editor.putInt("locked46", 0);
					editor.putInt("locked47", 0);
					editor.putInt("locked48", 0);
					editor.putInt("locked49", 0);
					editor.putInt("locked50", 0);
					editor.putInt("locked51", 0);
					editor.putInt("locked52", 0);
					editor.putInt("locked53", 0);
					editor.putInt("locked54", 0);
					editor.putInt("locked55", 0);
					editor.putInt("locked56", 0);
					editor.putInt("locked57", 0);
					editor.putInt("locked58", 0);
					editor.putInt("locked59", 0);
					editor.putInt("locked60", 0);
					editor.putInt("locked61", 0);
					editor.putInt("locked62", 0);
					editor.putInt("locked63", 0);
					editor.putInt("locked64", 0);
					editor.putInt("locked65", 0);
					editor.putInt("locked66", 0);
					editor.putInt("locked67", 0);
					editor.putInt("locked68", 0);
					editor.putInt("locked69", 0);
					editor.putInt("locked70", 0);
					editor.putInt("locked71", 0);
					editor.putInt("locked72", 0);
					editor.putInt("locked73", 0);
					editor.putInt("locked74", 0);
					editor.putInt("locked75", 0);
					editor.putInt("locked76", 0);
					editor.putInt("locked77", 0);
					editor.putInt("locked78", 0);
					editor.putInt("locked79", 0);
					editor.putInt("locked80", 0);
					editor.putInt("locked81", 0);
					editor.putInt("locked82", 0);
					editor.putInt("locked83", 0);
					editor.putInt("locked84", 0);
					editor.putInt("locked85", 0);
					editor.putInt("locked86", 0);
					editor.putInt("locked87", 0);
					editor.putInt("locked88", 0);
					editor.putInt("locked89", 0);
					editor.putInt("locked90", 0);
					editor.putInt("locked91", 0);
					editor.putInt("locked92", 0);
					editor.putInt("locked93", 0);
					editor.putInt("locked94", 0);
					editor.putInt("locked95", 0);
					editor.putInt("locked96", 0);
					editor.putInt("locked97", 0);
					editor.putInt("locked98", 0);
					editor.putInt("locked99", 0);
					editor.putInt("locked100", 0);

					editor.putInt("locked101", 0);
					editor.putInt("locked102", 0);
					editor.putInt("locked103", 0);
					editor.putInt("locked104", 0);
					editor.putInt("locked105", 0);
					editor.putInt("locked106", 0);
					editor.putInt("locked107", 0);
					editor.putInt("locked108", 0);
					editor.putInt("locked109", 0);
					editor.putInt("locked110", 0);
					editor.putInt("locked111", 0);
					editor.putInt("locked112", 0);
					editor.putInt("locked113", 0);
					editor.putInt("locked114", 0);
					editor.putInt("locked115", 0);
					editor.putInt("locked116", 0);
					editor.putInt("locked117", 0);
					editor.putInt("locked118", 0);
					editor.putInt("locked119", 0);
					editor.putInt("locked120", 0);
					editor.putInt("locked121", 0);
					editor.putInt("locked122", 0);
					editor.putInt("locked123", 0);
					editor.putInt("locked124", 0);
					editor.putInt("locked125", 0);
					editor.putInt("locked126", 0);
					editor.putInt("locked127", 0);
					editor.putInt("locked128", 0);
					editor.putInt("locked129", 0);
					editor.putInt("locked130", 0);
					editor.putInt("locked131", 0);
					editor.putInt("locked132", 0);
					editor.putInt("locked133", 0);
					editor.putInt("locked134", 0);
					editor.putInt("locked135", 0);
					editor.putInt("locked136", 0);
					editor.putInt("locked137", 0);
					editor.putInt("locked138", 0);
					editor.putInt("locked139", 0);
					editor.putInt("locked140", 0);
					editor.putInt("locked141", 0);
					editor.putInt("locked142", 0);
					editor.putInt("locked143", 0);
					editor.putInt("locked144", 0);
					editor.putInt("locked145", 0);
					editor.putInt("locked146", 0);
					editor.putInt("locked147", 0);
					editor.putInt("locked148", 0);
					editor.putInt("locked149", 0);
					editor.putInt("locked150", 0);
					editor.putInt("locked151", 0);
					editor.putInt("locked152", 0);
					editor.putInt("locked153", 0);
					editor.putInt("locked154", 0);
					editor.putInt("locked155", 0);
					editor.putInt("locked156", 0);
					editor.putInt("locked157", 0);
					editor.putInt("locked158", 0);
					editor.putInt("locked159", 0);
					editor.putInt("locked160", 0);
					editor.putInt("locked161", 0);
					editor.putInt("locked162", 0);
					editor.putInt("locked163", 0);
					editor.putInt("locked164", 0);
					editor.putInt("locked165", 0);
					editor.putInt("locked166", 0);
					editor.putInt("locked167", 0);
					editor.putInt("locked168", 0);
					editor.putInt("locked169", 0);
					editor.putInt("locked170", 0);
					editor.putInt("locked171", 0);
					editor.putInt("locked172", 0);
					editor.putInt("locked173", 0);
					editor.putInt("locked174", 0);
					editor.putInt("locked175", 0);
					editor.putInt("locked176", 0);
					editor.putInt("locked177", 0);
					editor.putInt("locked178", 0);
					editor.putInt("locked179", 0);
					editor.putInt("locked180", 0);
					editor.putInt("locked181", 0);
					editor.putInt("locked182", 0);
					editor.putInt("locked183", 0);
					editor.putInt("locked184", 0);
					editor.putInt("locked185", 0);
					editor.putInt("locked186", 0);
					editor.putInt("locked187", 0);
					editor.putInt("locked188", 0);
					editor.putInt("locked189", 0);
					editor.putInt("locked190", 0);
					editor.putInt("locked191", 0);
					editor.putInt("locked192", 0);
					editor.putInt("locked193", 0);
					editor.putInt("locked194", 0);
					editor.putInt("locked195", 0);
					editor.putInt("locked196", 0);
					editor.putInt("locked197", 0);
					editor.putInt("locked198", 0);
					editor.putInt("locked199", 0);
					editor.putInt("locked200", 0);

					editor.putInt("locked201", 0);
					editor.putInt("locked202", 0);
					editor.putInt("locked203", 0);
					editor.putInt("locked204", 0);
					editor.putInt("locked205", 0);
					editor.putInt("locked206", 0);
					editor.putInt("locked207", 0);
					editor.putInt("locked208", 0);
					editor.putInt("locked209", 0);
					editor.putInt("locked210", 0);
					editor.putInt("locked211", 0);
					editor.putInt("locked212", 0);
					editor.putInt("locked213", 0);
					editor.putInt("locked214", 0);
					editor.putInt("locked215", 0);
					editor.putInt("locked216", 0);
					editor.putInt("locked217", 0);
					editor.putInt("locked218", 0);
					editor.putInt("locked219", 0);
					editor.putInt("locked220", 0);
					editor.putInt("locked221", 0);
					editor.putInt("locked222", 0);
					editor.putInt("locked223", 0);
					editor.putInt("locked224", 0);
					editor.putInt("locked225", 0);
					editor.putInt("locked226", 0);
					editor.putInt("locked227", 0);
					editor.putInt("locked228", 0);
					editor.putInt("locked229", 0);
					editor.putInt("locked230", 0);
					editor.putInt("locked231", 0);
					editor.putInt("locked232", 0);
					editor.putInt("locked233", 0);
					editor.putInt("locked234", 0);
					editor.putInt("locked235", 0);
					editor.putInt("locked236", 0);
					editor.putInt("locked237", 0);
					editor.putInt("locked238", 0);
					editor.putInt("locked239", 0);
					editor.putInt("locked240", 0);
					editor.putInt("locked241", 0);
					editor.putInt("locked242", 0);
					editor.putInt("locked243", 0);
					editor.putInt("locked244", 0);
					editor.putInt("locked245", 0);
					editor.putInt("locked246", 0);
					editor.putInt("locked247", 0);
					editor.putInt("locked248", 0);
					editor.putInt("locked249", 0);
					editor.putInt("locked250", 0);
					editor.putInt("locked251", 0);
					editor.putInt("locked252", 0);
					editor.putInt("locked253", 0);
					editor.putInt("locked254", 0);
					editor.putInt("locked255", 0);
					editor.putInt("locked256", 0);
					editor.putInt("locked257", 0);
					editor.putInt("locked258", 0);
					editor.putInt("locked259", 0);
					editor.putInt("locked260", 0);
					editor.putInt("locked261", 0);
					editor.putInt("locked262", 0);
					editor.putInt("locked263", 0);
					editor.putInt("locked264", 0);
					editor.putInt("locked265", 0);
					editor.putInt("locked266", 0);
					editor.putInt("locked267", 0);
					editor.putInt("locked268", 0);
					editor.putInt("locked269", 0);
					editor.putInt("locked270", 0);
					editor.putInt("locked271", 0);
					editor.putInt("locked272", 0);
					editor.putInt("locked273", 0);
					editor.putInt("locked274", 0);
					editor.putInt("locked275", 0);
					editor.putInt("locked276", 0);
					editor.putInt("locked277", 0);
					editor.putInt("locked278", 0);
					editor.putInt("locked279", 0);
					editor.putInt("locked280", 0);
					editor.putInt("locked281", 0);
					editor.putInt("locked282", 0);
					editor.putInt("locked283", 0);
					editor.putInt("locked284", 0);
					editor.putInt("locked285", 0);
					editor.putInt("locked286", 0);
					editor.putInt("locked287", 0);
					editor.putInt("locked288", 0);
					editor.putInt("locked289", 0);
					editor.putInt("locked290", 0);
					editor.putInt("locked291", 0);
					editor.putInt("locked292", 0);
					editor.putInt("locked293", 0);
					editor.putInt("locked294", 0);
					editor.putInt("locked295", 0);
					editor.putInt("locked296", 0);
					editor.putInt("locked297", 0);
					editor.putInt("locked298", 0);
					editor.putInt("locked299", 0);
					editor.putInt("locked300", 0);

					editor.putInt("locked301", 0);
					editor.putInt("locked302", 0);
					editor.putInt("locked303", 0);
					editor.putInt("locked304", 0);
					editor.putInt("locked305", 0);
					editor.putInt("locked306", 0);
					editor.putInt("locked307", 0);
					editor.putInt("locked308", 0);
					editor.putInt("locked309", 0);
					editor.putInt("locked310", 0);
					editor.putInt("locked311", 0);
					editor.putInt("locked312", 0);
					editor.putInt("locked313", 0);
					editor.putInt("locked314", 0);
					editor.putInt("locked315", 0);
					editor.putInt("locked316", 0);
					editor.putInt("locked317", 0);
					editor.putInt("locked318", 0);
					editor.putInt("locked319", 0);
					editor.putInt("locked320", 0);
					editor.apply();

					allSum = 0;
					tog = 0;
					SharedPreferences preferences22 = PreferenceManager
							.getDefaultSharedPreferences(getBaseContext());
					SharedPreferences.Editor editor1 = preferences22.edit();
					editor1.putInt("allSum", allSum);
					editor.putInt("tog", tog);
					editor1.apply();
				} else {
					if (refresh >= 1) {
						Toast.makeText(getApplicationContext(), "문구가 지워졌습니다",
								Toast.LENGTH_SHORT).show();
						adapter1.deletOneRecord1(del);

						SharedPreferences preferences1 = PreferenceManager
								.getDefaultSharedPreferences(this);
						SharedPreferences.Editor editor = preferences1.edit();
						editor.putInt("locked1", 0);
						editor.putInt("locked2", 0);
						editor.putInt("locked3", 0);
						editor.putInt("locked4", 0);
						editor.putInt("locked5", 0);
						editor.putInt("locked6", 0);
						editor.putInt("locked7", 0);
						editor.putInt("locked8", 0);
						editor.putInt("locked9", 0);
						editor.putInt("locked10", 0);
						editor.putInt("locked11", 0);
						editor.putInt("locked12", 0);
						editor.putInt("locked13", 0);
						editor.putInt("locked14", 0);
						editor.putInt("locked15", 0);
						editor.putInt("locked16", 0);
						editor.putInt("locked17", 0);
						editor.putInt("locked18", 0);
						editor.putInt("locked19", 0);
						editor.putInt("locked20", 0);
						editor.putInt("locked21", 0);
						editor.putInt("locked22", 0);
						editor.putInt("locked23", 0);
						editor.putInt("locked24", 0);
						editor.putInt("locked25", 0);
						editor.putInt("locked26", 0);
						editor.putInt("locked27", 0);
						editor.putInt("locked28", 0);
						editor.putInt("locked29", 0);
						editor.putInt("locked30", 0);
						editor.putInt("locked31", 0);
						editor.putInt("locked32", 0);
						editor.putInt("locked33", 0);
						editor.putInt("locked34", 0);
						editor.putInt("locked35", 0);
						editor.putInt("locked36", 0);
						editor.putInt("locked37", 0);
						editor.putInt("locked38", 0);
						editor.putInt("locked39", 0);
						editor.putInt("locked40", 0);
						editor.putInt("locked41", 0);
						editor.putInt("locked42", 0);
						editor.putInt("locked43", 0);
						editor.putInt("locked44", 0);
						editor.putInt("locked45", 0);
						editor.putInt("locked46", 0);
						editor.putInt("locked47", 0);
						editor.putInt("locked48", 0);
						editor.putInt("locked49", 0);
						editor.putInt("locked50", 0);
						editor.putInt("locked51", 0);
						editor.putInt("locked52", 0);
						editor.putInt("locked53", 0);
						editor.putInt("locked54", 0);
						editor.putInt("locked55", 0);
						editor.putInt("locked56", 0);
						editor.putInt("locked57", 0);
						editor.putInt("locked58", 0);
						editor.putInt("locked59", 0);
						editor.putInt("locked60", 0);
						editor.putInt("locked61", 0);
						editor.putInt("locked62", 0);
						editor.putInt("locked63", 0);
						editor.putInt("locked64", 0);
						editor.putInt("locked65", 0);
						editor.putInt("locked66", 0);
						editor.putInt("locked67", 0);
						editor.putInt("locked68", 0);
						editor.putInt("locked69", 0);
						editor.putInt("locked70", 0);
						editor.putInt("locked71", 0);
						editor.putInt("locked72", 0);
						editor.putInt("locked73", 0);
						editor.putInt("locked74", 0);
						editor.putInt("locked75", 0);
						editor.putInt("locked76", 0);
						editor.putInt("locked77", 0);
						editor.putInt("locked78", 0);
						editor.putInt("locked79", 0);
						editor.putInt("locked80", 0);
						editor.putInt("locked81", 0);
						editor.putInt("locked82", 0);
						editor.putInt("locked83", 0);
						editor.putInt("locked84", 0);
						editor.putInt("locked85", 0);
						editor.putInt("locked86", 0);
						editor.putInt("locked87", 0);
						editor.putInt("locked88", 0);
						editor.putInt("locked89", 0);
						editor.putInt("locked90", 0);
						editor.putInt("locked91", 0);
						editor.putInt("locked92", 0);
						editor.putInt("locked93", 0);
						editor.putInt("locked94", 0);
						editor.putInt("locked95", 0);
						editor.putInt("locked96", 0);
						editor.putInt("locked97", 0);
						editor.putInt("locked98", 0);
						editor.putInt("locked99", 0);
						editor.putInt("locked100", 0);

						editor.putInt("locked101", 0);
						editor.putInt("locked102", 0);
						editor.putInt("locked103", 0);
						editor.putInt("locked104", 0);
						editor.putInt("locked105", 0);
						editor.putInt("locked106", 0);
						editor.putInt("locked107", 0);
						editor.putInt("locked108", 0);
						editor.putInt("locked109", 0);
						editor.putInt("locked110", 0);
						editor.putInt("locked111", 0);
						editor.putInt("locked112", 0);
						editor.putInt("locked113", 0);
						editor.putInt("locked114", 0);
						editor.putInt("locked115", 0);
						editor.putInt("locked116", 0);
						editor.putInt("locked117", 0);
						editor.putInt("locked118", 0);
						editor.putInt("locked119", 0);
						editor.putInt("locked120", 0);
						editor.putInt("locked121", 0);
						editor.putInt("locked122", 0);
						editor.putInt("locked123", 0);
						editor.putInt("locked124", 0);
						editor.putInt("locked125", 0);
						editor.putInt("locked126", 0);
						editor.putInt("locked127", 0);
						editor.putInt("locked128", 0);
						editor.putInt("locked129", 0);
						editor.putInt("locked130", 0);
						editor.putInt("locked131", 0);
						editor.putInt("locked132", 0);
						editor.putInt("locked133", 0);
						editor.putInt("locked134", 0);
						editor.putInt("locked135", 0);
						editor.putInt("locked136", 0);
						editor.putInt("locked137", 0);
						editor.putInt("locked138", 0);
						editor.putInt("locked139", 0);
						editor.putInt("locked140", 0);
						editor.putInt("locked141", 0);
						editor.putInt("locked142", 0);
						editor.putInt("locked143", 0);
						editor.putInt("locked144", 0);
						editor.putInt("locked145", 0);
						editor.putInt("locked146", 0);
						editor.putInt("locked147", 0);
						editor.putInt("locked148", 0);
						editor.putInt("locked149", 0);
						editor.putInt("locked150", 0);
						editor.putInt("locked151", 0);
						editor.putInt("locked152", 0);
						editor.putInt("locked153", 0);
						editor.putInt("locked154", 0);
						editor.putInt("locked155", 0);
						editor.putInt("locked156", 0);
						editor.putInt("locked157", 0);
						editor.putInt("locked158", 0);
						editor.putInt("locked159", 0);
						editor.putInt("locked160", 0);
						editor.putInt("locked161", 0);
						editor.putInt("locked162", 0);
						editor.putInt("locked163", 0);
						editor.putInt("locked164", 0);
						editor.putInt("locked165", 0);
						editor.putInt("locked166", 0);
						editor.putInt("locked167", 0);
						editor.putInt("locked168", 0);
						editor.putInt("locked169", 0);
						editor.putInt("locked170", 0);
						editor.putInt("locked171", 0);
						editor.putInt("locked172", 0);
						editor.putInt("locked173", 0);
						editor.putInt("locked174", 0);
						editor.putInt("locked175", 0);
						editor.putInt("locked176", 0);
						editor.putInt("locked177", 0);
						editor.putInt("locked178", 0);
						editor.putInt("locked179", 0);
						editor.putInt("locked180", 0);
						editor.putInt("locked181", 0);
						editor.putInt("locked182", 0);
						editor.putInt("locked183", 0);
						editor.putInt("locked184", 0);
						editor.putInt("locked185", 0);
						editor.putInt("locked186", 0);
						editor.putInt("locked187", 0);
						editor.putInt("locked188", 0);
						editor.putInt("locked189", 0);
						editor.putInt("locked190", 0);
						editor.putInt("locked191", 0);
						editor.putInt("locked192", 0);
						editor.putInt("locked193", 0);
						editor.putInt("locked194", 0);
						editor.putInt("locked195", 0);
						editor.putInt("locked196", 0);
						editor.putInt("locked197", 0);
						editor.putInt("locked198", 0);
						editor.putInt("locked199", 0);
						editor.putInt("locked200", 0);

						editor.putInt("locked201", 0);
						editor.putInt("locked202", 0);
						editor.putInt("locked203", 0);
						editor.putInt("locked204", 0);
						editor.putInt("locked205", 0);
						editor.putInt("locked206", 0);
						editor.putInt("locked207", 0);
						editor.putInt("locked208", 0);
						editor.putInt("locked209", 0);
						editor.putInt("locked210", 0);
						editor.putInt("locked211", 0);
						editor.putInt("locked212", 0);
						editor.putInt("locked213", 0);
						editor.putInt("locked214", 0);
						editor.putInt("locked215", 0);
						editor.putInt("locked216", 0);
						editor.putInt("locked217", 0);
						editor.putInt("locked218", 0);
						editor.putInt("locked219", 0);
						editor.putInt("locked220", 0);
						editor.putInt("locked221", 0);
						editor.putInt("locked222", 0);
						editor.putInt("locked223", 0);
						editor.putInt("locked224", 0);
						editor.putInt("locked225", 0);
						editor.putInt("locked226", 0);
						editor.putInt("locked227", 0);
						editor.putInt("locked228", 0);
						editor.putInt("locked229", 0);
						editor.putInt("locked230", 0);
						editor.putInt("locked231", 0);
						editor.putInt("locked232", 0);
						editor.putInt("locked233", 0);
						editor.putInt("locked234", 0);
						editor.putInt("locked235", 0);
						editor.putInt("locked236", 0);
						editor.putInt("locked237", 0);
						editor.putInt("locked238", 0);
						editor.putInt("locked239", 0);
						editor.putInt("locked240", 0);
						editor.putInt("locked241", 0);
						editor.putInt("locked242", 0);
						editor.putInt("locked243", 0);
						editor.putInt("locked244", 0);
						editor.putInt("locked245", 0);
						editor.putInt("locked246", 0);
						editor.putInt("locked247", 0);
						editor.putInt("locked248", 0);
						editor.putInt("locked249", 0);
						editor.putInt("locked250", 0);
						editor.putInt("locked251", 0);
						editor.putInt("locked252", 0);
						editor.putInt("locked253", 0);
						editor.putInt("locked254", 0);
						editor.putInt("locked255", 0);
						editor.putInt("locked256", 0);
						editor.putInt("locked257", 0);
						editor.putInt("locked258", 0);
						editor.putInt("locked259", 0);
						editor.putInt("locked260", 0);
						editor.putInt("locked261", 0);
						editor.putInt("locked262", 0);
						editor.putInt("locked263", 0);
						editor.putInt("locked264", 0);
						editor.putInt("locked265", 0);
						editor.putInt("locked266", 0);
						editor.putInt("locked267", 0);
						editor.putInt("locked268", 0);
						editor.putInt("locked269", 0);
						editor.putInt("locked270", 0);
						editor.putInt("locked271", 0);
						editor.putInt("locked272", 0);
						editor.putInt("locked273", 0);
						editor.putInt("locked274", 0);
						editor.putInt("locked275", 0);
						editor.putInt("locked276", 0);
						editor.putInt("locked277", 0);
						editor.putInt("locked278", 0);
						editor.putInt("locked279", 0);
						editor.putInt("locked280", 0);
						editor.putInt("locked281", 0);
						editor.putInt("locked282", 0);
						editor.putInt("locked283", 0);
						editor.putInt("locked284", 0);
						editor.putInt("locked285", 0);
						editor.putInt("locked286", 0);
						editor.putInt("locked287", 0);
						editor.putInt("locked288", 0);
						editor.putInt("locked289", 0);
						editor.putInt("locked290", 0);
						editor.putInt("locked291", 0);
						editor.putInt("locked292", 0);
						editor.putInt("locked293", 0);
						editor.putInt("locked294", 0);
						editor.putInt("locked295", 0);
						editor.putInt("locked296", 0);
						editor.putInt("locked297", 0);
						editor.putInt("locked298", 0);
						editor.putInt("locked299", 0);
						editor.putInt("locked300", 0);

						editor.putInt("locked301", 0);
						editor.putInt("locked302", 0);
						editor.putInt("locked303", 0);
						editor.putInt("locked304", 0);
						editor.putInt("locked305", 0);
						editor.putInt("locked306", 0);
						editor.putInt("locked307", 0);
						editor.putInt("locked308", 0);
						editor.putInt("locked309", 0);
						editor.putInt("locked310", 0);
						editor.putInt("locked311", 0);
						editor.putInt("locked312", 0);
						editor.putInt("locked313", 0);
						editor.putInt("locked314", 0);
						editor.putInt("locked315", 0);
						editor.putInt("locked316", 0);
						editor.putInt("locked317", 0);
						editor.putInt("locked318", 0);
						editor.putInt("locked319", 0);
						editor.putInt("locked320", 0);
						editor.apply();

						refresh = 0;
						allSum = 0;
						tog = 0;
						SharedPreferences preferences2 = PreferenceManager
								.getDefaultSharedPreferences(getBaseContext());
						SharedPreferences.Editor editor1 = preferences2.edit();
						editor1.putInt("refresh", refresh);
						editor1.putInt("del", del);
						editor1.putInt("allSum", allSum);
						editor.putInt("tog", tog);
						editor1.apply();
						System.out.println("RESETdel" + del);

						Intent intent = getIntent();
						overridePendingTransition(0, 0);
						intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
						finish();

						overridePendingTransition(0, 0);
						startActivity(intent);

					} else {
						// Toast.makeText(getApplicationContext(),
						// "초기화할 문구가 없습니다. 다시 입력해주세요",
						// Toast.LENGTH_SHORT).show();
					}
				}
			}
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	// onReume 부에 UART DEVICE PROBE 추가
	@Override
	public void onResume() {
		super.onResume();
		System.out.println("allSumRes" + allSum);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		System.out.println("DESTrefresh" + refresh);
		System.out.println("DESTdel" + del);
		System.out.println("DESTallSum1" + allSum);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK)) {
			tog++;
			SharedPreferences preferences1 = PreferenceManager
					.getDefaultSharedPreferences(getApplicationContext());
			SharedPreferences.Editor editor = preferences1.edit();
			editor.putInt("tog", tog);
			editor.apply();
			System.out.println("onKeyDownallSum" + allSum);

		}
		return super.onKeyDown(keyCode, event);
	}

	public void onUserLeaveHint() { // this only executes when Home is selected.
		super.onUserLeaveHint();
		tog++;
		SharedPreferences preferences1 = PreferenceManager
				.getDefaultSharedPreferences(getApplicationContext());
		SharedPreferences.Editor editor = preferences1.edit();
		editor.putInt("tog", tog);
		editor.apply();
		System.out.println("onUserallSum" + allSum);
	}
}
