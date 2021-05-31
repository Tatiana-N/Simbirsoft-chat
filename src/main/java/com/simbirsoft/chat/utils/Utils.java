package com.simbirsoft.chat.utils;

import java.util.List;

public class Utils {
	public static <T> StringBuilder getStringFromList(List<T> list) {
		StringBuilder stringBuilder = new StringBuilder();
		for (T t : list) {
			stringBuilder.append(t.toString());
			stringBuilder.append("\n");
		}
		return stringBuilder;
	}
}
