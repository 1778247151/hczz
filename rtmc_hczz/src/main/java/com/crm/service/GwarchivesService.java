package com.crm.service;

import java.util.Map;

import com.crm.common.BasePageResultVo;
import com.crm.core.Services;
import com.crm.pojo.GwarchivesModel;

public interface GwarchivesService extends Services<GwarchivesModel> {
	
    int deleteByPrimaryKey(Integer id);

    int insert(GwarchivesModel record);

    int insertSelective(GwarchivesModel record);

    GwarchivesModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GwarchivesModel record);

    int updateByPrimaryKeyWithBLOBs(GwarchivesModel record);

    int updateByPrimaryKey(GwarchivesModel record);
	
    public BasePageResultVo selectPageListByAccount(Map<String, Object> params);

}
