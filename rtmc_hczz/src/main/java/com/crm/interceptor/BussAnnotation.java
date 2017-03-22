package com.crm.interceptor;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;  
import java.lang.annotation.RetentionPolicy;  
 
/**
 * 
 * BussAnnotation:日志相关操作信息业务逻辑接口
 *
 * @author yumaochun
 * @date  2016年7月12日
 * @version  jdk1.8
 *
 */
@Retention(RetentionPolicy.RUNTIME) 
@Target({ElementType.METHOD}) 
public @interface BussAnnotation {

    //模块名  
    String moduleName();  
    //操作内容  
    String option();  

}
