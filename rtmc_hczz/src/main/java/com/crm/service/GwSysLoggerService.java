package com.crm.service;

import java.util.List;

import com.crm.core.Services;
import com.crm.pojo.GwSysLoggerModel;
/**
 * 
 * GwSysLoggerService:系统日志逻辑层接口
 *
 * @author xiangtao
 * @date  2016年6月20日
 * @version  jdk1.8
 *
 */
public interface GwSysLoggerService extends Services<GwSysLoggerModel>{

	/**
	 * 
	 * 批量添加日志记录
	 * @param list
	 * @return
	 */
	int insetSysLoggerBatch(List<GwSysLoggerModel> list);
	/**
	 * 
	 * batchDelete:批量删除
	 *
	 * @author hemingjun
	 * @date 2016年10月12日
	 * @param list
	 * @return
	 */
	public int batchDelete(List<Integer> list);
}
