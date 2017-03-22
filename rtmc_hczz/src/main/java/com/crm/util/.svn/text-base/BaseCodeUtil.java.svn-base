package com.crm.util;

import java.util.Date;
import java.util.Random;

/**
 * 
 * BaseCodeUtil:基础编号生成辅助工具
 *
 * @author yumaochun
 * @date  2016年4月7日
 * @version  jdk1.8
 *
 */
public class BaseCodeUtil {
	
	 
	/**
	 * 
	 * getSettlementCode:根据合同号和账期序号，生成费用代码单号
	 *
	 * @date 2016年4月7日
	 * @param code              合同号
	 * @param costCodeId        费用代码id
	 * @param index             序号
	 * @return   返回：费用代码单号
	 */
	public static String getSettlementCode(String code,int costCodeId,int index){
		//生成结算单号 =合同号+费用代码id（4位）+序号（4位）
		String settlementCode=code+getFourCode(costCodeId)+getFourCode(index);
		return settlementCode;
	}
	
	/**
	 * 
	 * getSettlementId:生成结算单号
	 *
	 * @date 2016年4月14日
	 * @param code            合同号
	 * @param accountPayable    账期
	 * @param settlementGroupCode   结算组别编号
	 * @return
	 */
	public static String getSettlementId(String code,String accountPayable,String settlementGroupCode){
		int settlementGroupId=Integer.parseInt(settlementGroupCode);//结算组别id
		String settlementId=""+code+getFourCode(settlementGroupId)+accountPayable;
		return settlementId;
	}
	
	public static void main(String[] args) {
		
		System.out.println(getFourCode(4));
	}
	/**
	 * 
	 * getFourCode:根据数字生成4位长度的数字字符串（补位）
	 *
	 * @date 2016年4月7日
	 * @param index      需要转换的数字
	 * @return  返回：返回四位数字（补位）
	 */
	public static String getFourCode(int index){
		
		return getFixedLengthStr(index,4);
	}
	/**
	 * 
	 * getFixedLengthStr:将数值，生成以0补位的指定长度的字符串
	 *
	 * @date 2016年4月7日
	 * @param num      需要转换的数值
	 * @param len      生成的字符串的长度
	 * @return   返回：生成补位的字符串
	 */
	public static String getFixedLengthStr(int num,int len){
		String replaceNum="0";//补位的字符
		String newNum=String.format("%"+replaceNum+len+"d", num);
		return newNum;
	}
	
	/**
	 * 获取通用的编号
	 * @param prefix 编号前缀   如拾物维护编号 为SW(大写)注:后面应加上四位递增数如SW201607050001
	 * @return
	 */
	public static String getBaseCode(String prefix){
		String code = "";
		//获取当前时间
		String nowTime = DateUtil.getCurrentDate("");
		code = prefix+nowTime;
		return code;
	}

	/**
	 * 得到n位长度的随机数
	 * @param n
	 * @return
	 */
	public static int getRandomNumber(int n){
		int temp = 0;
		int min = (int) Math.pow(10, n-1);
		int max = (int) Math.pow(10, n);
		Random rand = new Random();

		while(true){
		temp = rand.nextInt(max);
		if(temp >= min)
		break;
		}

		return temp;
	}

}
