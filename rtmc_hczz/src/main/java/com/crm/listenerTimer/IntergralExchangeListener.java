/*package com.crm.listenerTimer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crm.enums.IntegralExchangeGoodsStatusEnum;
import com.crm.pojo.GwIntegralExchangeGoodsModel;
import com.crm.service.GwIntegralExchangeGoodsService;
import com.crm.util.DateUtil;
import com.crm.util.ToolSpring;

public class IntergralExchangeListener extends TimerTask{
	
	private Logger logger = LoggerFactory.getLogger(IntergralExchangeListener.class);
	
	GwIntegralExchangeGoodsService gwIntegralExchangeGoodsServiceImpl=(GwIntegralExchangeGoodsService)ToolSpring.getBean("gwIntegralExchangeGoodsServiceManage");
	@Override
	public void run() {
		try {
			Map<String, Object> param=new HashMap<>();
			param.put("status", IntegralExchangeGoodsStatusEnum.type_ENABLE.getValue());
			List<GwIntegralExchangeGoodsModel> gwIntegralExchangeGoodsList=gwIntegralExchangeGoodsServiceImpl.getAllListByCondition(param);
			for (GwIntegralExchangeGoodsModel model : gwIntegralExchangeGoodsList) {
				String startTime=model.getStartTime();
				String endTime=model.getEndTime();
				String nowTime = DateUtil.getTodayString();
				Map<String, Object> par = new HashMap<>();
				if (nowTime.compareTo(startTime) >= 0 && endTime.compareTo(nowTime) >= 0) {
					par.put("startStatus", IntegralExchangeGoodsStatusEnum.type_ENA.getValue());
					par.put("id", model.getId());
				}
				int number=0;
				if (par.get("id")!= null&&!"".equals(par.get("id"))) {
					//更新活动状态进行
					number= gwIntegralExchangeGoodsServiceImpl.updateIntegralExchangeGoodsById(par);
				}
				if (number > 0) {
					logger.info("----积分兑换活动状态改变为进行中-----");
				}
			}
			
			Map<String, Object> param2=new HashMap<>();
			param2.put("status", IntegralExchangeGoodsStatusEnum.type_ENA.getValue());
			List<GwIntegralExchangeGoodsModel> listIng=gwIntegralExchangeGoodsServiceImpl.getAllListByCondition(param2);
			for (GwIntegralExchangeGoodsModel model : listIng) {
				String endTime=model.getEndTime();
				String nowTime = DateUtil.getTodayString();
				Map<String, Object> par = new HashMap<>();
				if (endTime.compareTo(nowTime) < 0) {
					par.put("stopStatus", IntegralExchangeGoodsStatusEnum.type_EN.getValue());
					par.put("id", model.getId());
				}
				int number=0;
				if (par.get("id")!= null&&!"".equals(par.get("id"))) {
					//更新活动状态进行
					number= gwIntegralExchangeGoodsServiceImpl.updateIntegralExchangeGoodsById(par);
				}
				if (number > 0) {
					logger.info("----积分兑换活动状态改变为结束-----");
				}
			}
			
			
		} catch (Exception e) {
			logger.info("-------------定时更新积分兑换活动状态发生异常！-----------");
		}
		
	}

}
*/