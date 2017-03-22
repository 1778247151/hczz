package com.crm.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang.RandomStringUtils;

public class CharacterUtil {
	
	public static String randomString(int length)
	{
		return RandomStringUtils.randomAlphabetic(length);
	}

	public static List<String> getSplitedList(String str, String delim)
	{
		List<String> list = new ArrayList<String>();

		StringTokenizer st = new StringTokenizer(str, delim);

		while (st.hasMoreTokens())
		{
			list.add(st.nextToken());
		}
		return list;
	}

}
