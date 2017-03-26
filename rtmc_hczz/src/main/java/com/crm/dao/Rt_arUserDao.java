package com.crm.dao;

import java.util.List;

import com.crm.core.DaoManager;
import com.crm.pojo.Rt_arUser;

public interface Rt_arUserDao extends DaoManager<Rt_arUser> {
    int deleteByPrimaryKey(Integer id);

    int insert(Rt_arUser record);

    int insertSelective(Rt_arUser record);

    Rt_arUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Rt_arUser record);

    int updateByPrimaryKey(Rt_arUser record);
    
    public Rt_arUser selectByUserId(int userid); 
    public List<Rt_arUser> selectByArchid(int archid); 
}