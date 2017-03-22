package com.crm.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
/**
 * 
 * 
 * CodeUtil:公共编号生成工具类
 *
 * @author  yumaochun
 * @date    2016年9月21日
 * @version jdk1.8
 *
 */
public class CodeUtil {
	
	/**
	 * （成都市）行政区域代码：510100
	 */
	private static String AREA_CODE="510100";

	
	public static void main(String[] args) {
		System.out.println(createCardCodePrefix());
	}
	/**
	 * 
	 * createVipCode:生成vipCode
	 *
	 * @author   yumaochun
	 * @date     2016年9月21日
	 *
	 * @return
	 */
	public static String createVipCode(){
		String vipCode="";
		int len = new Random().nextInt(10) + 6;
		//生成vipCode字符串
		vipCode=getRandomCode(len);
		return vipCode;
	}
	
	/**
	 * 
	 * getRandomCode:生成指定长度的随机字符串
	 *
	 * @author   yumaochun
	 * @date     2016年9月21日
	 *
	 * @param len          字符串长度
	 * @return
	 */
	public static String getRandomCode(int len)
	{
		String sRand = "";
		String[] beforeShuffle = new String[] {"1","2", "3", "4", "5", "6", "7",  
                "8", "9","0", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",  
                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",  
                "W", "X", "Y", "a" , "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
                 "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y"
                };  
        @SuppressWarnings("rawtypes")
		List list = Arrays.asList(beforeShuffle);  
        Collections.shuffle(list);  
        StringBuilder sb = new StringBuilder();  
        for (int i = 0; i < list.size(); i++) {  
            sb.append(list.get(i));  
        }  
        String afterShuffle = sb.toString();  
        sRand = afterShuffle.substring(5, 5+len);  
		return sRand;
	}
	/**
	 * 
	 * createCardCodePrefix:生成会员卡的前缀卡号
	 *     会员卡号格式：510100201609220001
	 *       行政区域代码+yyyyMMdd+当日开卡数（四位）
	 *
	 * @author   yumaochun
	 * @date     2016年9月22日
	 *
	 * @return
	 */
	public static String createCardCodePrefix(){
		
		String cardCodePrefix=AREA_CODE;//卡号行政区域号
		//年月日
		String yyyyMMdd=DateUtil.getCurrentDate("");
		//卡号前缀
		cardCodePrefix=cardCodePrefix+yyyyMMdd;
		return cardCodePrefix;
	}
	
	
}
