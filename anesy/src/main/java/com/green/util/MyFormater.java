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
	
	public static String formatText(String input, int length) {
		if (input == null) {
			return input;
		}
		
		if (input.length() < length) {
			return input + " ...";
		}
		
		return input.substring(0, length -1) + " ...";
	}
}
