package com.chnMicro.MFExchange.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;

public class DateUtil {
	/**
	 * 获取现在的时间	yyyy-MM-dd
	 */
	@SuppressLint("SimpleDateFormat")
	public static String getNowDate() {
		Date date = new Date();
		String time = "";
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			time = format.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return time;
	}
	
	/**
	 * 
	 */
	@SuppressLint("SimpleDateFormat")
	public static String getNowDateToSecond() {
		Date date = new Date();
		String time = "";
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			time = format.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return time;
	}

	public static String format(Date date, String pattern) {
		String time = "";
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(pattern);
			time = formatter.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return time;
	}

	public static String format(long date, String pattern) {
		String time = "";
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(pattern);
			time = formatter.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return time;
	}
	
}
