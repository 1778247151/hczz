/*package com.crm.thread;

import java.io.UnsupportedEncodingException;
import com.crm.pojo.GwSmsRecordModel;
import com.crm.util.SendMessageUtil;
*//**
 * 
 * SendMessageThread:发送短信线程
 *
 * @author  shengjinpeng
 * @date    2016年11月8日
 * @version jdk1.8
 *
 *//*
public class SendMessageThread implements Runnable{
	
	private GwSmsRecordModel gwSmsRecordModel;
	
	public SendMessageThread(GwSmsRecordModel gwSmsRecordModel) {
		this.gwSmsRecordModel = gwSmsRecordModel;
	}
	
	@Override
	public void run() {
		try {
			SendMessageUtil.sendSmsMessage(gwSmsRecordModel);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
*/