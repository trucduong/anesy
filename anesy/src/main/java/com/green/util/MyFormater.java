package com.green.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MyFormater {
	public static String currency(Object val) {
		return number(val);
	}

	public static String number(Object val) {
		NumberFormat numberFormatter = new DecimalFormat("#,###");
		String result = numberFormatter.format(val);
		return result;
	}
}
