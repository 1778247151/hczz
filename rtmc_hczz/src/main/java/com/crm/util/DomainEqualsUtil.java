/*package com.crm.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map; 
import org.apache.log4j.Logger;

import com.crm.pojo.GwDepartmentModel;
import com.crm.pojo.GwShopsLeaseModel;
*//**
 * 
 * 
 * DomainEqualsUtil:对象比较常用工具类
 *
 * @author  yumaochun
 * @date    2016年9月14日
 * @version jdk1.8
 *
 *//*
public class DomainEqualsUtil {
 
    *//**
     * 日志操作类
     *//*
    private static Logger logger = Logger.getLogger(DomainEqualsUtil.class);
 
    public DomainEqualsUtil() {
    
    }
 
    *//**
     * 
     * domainEquals:
     *    比较两个BEAN或MAP对象的值是否相等 
     *    如果是BEAN与MAP对象比较时MAP中的key值应与BEAN的属性值名称相同且字段数目要一致
     *
     * @author   yumaochun
     * @date     2016年9月14日
     *
     * @param source    比较的源对象
     * @param target    比较的目标对象
     * @return  返回：相等-true，不相等-false
     *//*
    public static boolean domainEquals(Object source, Object target) {
        if (source == null || target == null) {
            return false;
        }
        boolean rv = true;
        if (source instanceof Map) {
            rv = mapOfSrc(source, target, rv);
        } else {
            rv = classOfSrc(source, target, rv);
        }
        logger.info("两个对象比较的结果为： " + rv);
        return rv;
    }
 
    *//**
     * 
     * mapOfSrc:源目标为MAP类型时
     * 
     * @param source
     * @param target
     * @param rv
     * @return
     *//*
    private static boolean mapOfSrc(Object source, Object target, boolean rv) {
        HashMap<String, String> map = new HashMap<String, String>();
        map = (HashMap) source;
        for (String key : map.keySet()) {
            if (target instanceof Map) {
                HashMap<String, String> tarMap = new HashMap<String, String>();
                tarMap = (HashMap) target;
                if(tarMap.get(key)==null){
                    rv = false;
                    break;
                }
                if (!map.get(key).equals(tarMap.get(key))) {
                    rv = false;
                    break;
                }
            } else {
                String tarValue = getClassValue(target, key) == null ? "" : getClassValue(target, key).toString();
                if (!tarValue.equals(map.get(key))) {
                    rv = false;
                    break;
                }
            }
        }
        return rv;
    }
 
    *//**
     * 
     * classOfSrc:源目标为非MAP类型时
     * 
     * @param source
     * @param target
     * @param rv
     * @return
     *//*
    private static boolean classOfSrc(Object source, Object target, boolean rv) {
        Class<?> srcClass = source.getClass();
        Field[] fields = srcClass.getDeclaredFields();
        for (Field field : fields) {
            String nameKey = field.getName();
            if (target instanceof Map) {
                HashMap<String, String> tarMap = new HashMap<String, String>();
                tarMap = (HashMap) target;
                String srcValue = getClassValue(source, nameKey) == null ? "" : getClassValue(source, nameKey)
                        .toString();
                if(tarMap.get(nameKey)==null){
                    rv = false;
                    break;
                }
                if (!tarMap.get(nameKey).equals(srcValue)) {
                    rv = false;
                    break;
                }
            } else {
                String srcValue = getClassValue(source, nameKey) == null ? "" : getClassValue(source, nameKey)
                        .toString();
                String tarValue = getClassValue(target, nameKey) == null ? "" : getClassValue(target, nameKey)
                        .toString();
                if (!srcValue.equals(tarValue)) {
                    rv = false;
                    break;
                }
            }
        }
        return rv;
    }
 
    *//**
     * getClassValue:根据字段名称取值
     * 
     * @param obj
     * @param fieldName
     * @return
     *//*
    public static Object getClassValue(Object obj, String fieldName) {
        if (obj == null) {
            return null;
        }
        try {
            Class beanClass = obj.getClass();
            Method[] ms = beanClass.getMethods();
            for (int i = 0; i < ms.length; i++) {
                // 非get方法不取
                if (!ms[i].getName().startsWith("get")) {
                    continue;
                }
                Object objValue = null;
                try {
                    objValue = ms[i].invoke(obj, new Object[] {});
                } catch (Exception e) {
                     logger.info("反射取值出错：" + e.toString());
                    continue;
                }
                if (objValue == null) {
                    continue;
                }
                if (ms[i].getName().toUpperCase().equals(fieldName.toUpperCase())
                        || ms[i].getName().substring(3).toUpperCase().equals(fieldName.toUpperCase())) {
                    return objValue;
                } else if (fieldName.toUpperCase().equals("SID")
                        && (ms[i].getName().toUpperCase().equals("ID") || ms[i].getName().substring(3).toUpperCase()
                                .equals("ID"))) {
                    return objValue;
                }
            }
        } catch (Exception e) {
            // logger.info("取方法出错！" + e.toString());
        }
        return null;
    }
 
    public static void main(String args[]) {
    	GwDepartmentModel deparment=new GwDepartmentModel();
    	deparment.setId(28);
    	deparment.setCode("01");
    	deparment.setCnName("运营部");
    	deparment.setEnName("Operational Department");
    	deparment.setDescription("");
    	deparment.setCreateTime("2016-09-05 09:42:48");
    	deparment.setUpdateUserId(0);
    	deparment.setUpdateTime("2016-09-07 09:46:24");
    	deparment.setOrderNum(0);
    	deparment.setStatus(1);
    	
    	
    	
    	GwDepartmentModel deparment2=new GwDepartmentModel();
    	deparment2.setId(28);
    	deparment2.setCode("01");
    	deparment2.setCnName("运营部");
    	deparment2.setEnName("Operational Department");
    	deparment2.setDescription("");
    	deparment2.setCreateTime("2016-09-05 09:42:48");
    	deparment2.setUpdateUserId(0);
    	deparment2.setUpdateTime("2016-09-07 09:46:24");
    	deparment2.setOrderNum(0);
    	deparment2.setStatus(1);
//    	SaleGoods saleOne=new SaleGoods();
//    	saleOne.setPaymentMoney(new BigDecimal(0));
//    	saleOne.setPaymentTenderCode("ch");
//    	
//    	SaleGoods saleTwo=new SaleGoods();
//    	saleTwo.setPaymentMoney(new BigDecimal(0));
//    	saleTwo.setPaymentTenderCode("ch");
//    	
    	System.out.println("=="+domainEquals(deparment,deparment2));
    }
 
}

*/