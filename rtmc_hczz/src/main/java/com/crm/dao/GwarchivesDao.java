package com.crm.dao;

import java.util.Map;

import com.crm.common.BasePageResultVo;
import com.crm.core.DaoManager;
import com.crm.pojo.GwarchivesModel;

public interface GwarchivesDao extends DaoManager<GwarchivesModel> {
    int deleteByPrimaryKey(Integer id);

    int insert(GwarchivesModel record);

    int insertSelective(GwarchivesModel record);

    GwarchivesModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GwarchivesModel record);

    int updateByPrimaryKeyWithBLOBs(GwarchivesModel record);

    int updateByPrimaryKey(GwarchivesModel record);
    
    BasePageResultVo selectPageListByAccount(Map<String, Object> params);
}