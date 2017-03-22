package com.crm.interceptor;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.crm.common.AdminUser;
import com.crm.pojo.GwSysLoggerModel;
import com.crm.service.GwSysLoggerService;
import com.crm.util.DateUtil;
import com.crm.util.IPToolUtil;
import com.crm.util.JsonMapper;

/**
 * 
* @ClassName: LoggerAop
* @Description: 日志记录AOP实现 
* @author yumaochun
* @date 2016年6月13日 
*
 */
@Aspect
@Component  
public class LoggerAop {
    
    /**
     * 日志业务逻辑层实现
     */
    @Resource(name="gwSysLoggerServiceManage")
    private GwSysLoggerService sysLoggerServiceImpl;
    
    //日志
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String requestPath = null ; // 请求地址
    private String userName = null ; // 用户名
    private Map<?,?> inputParamMap = null ; // 传入参数
    private Map<String, Object> outputParamMap = null; // 存放输出结果
    private long startTimeMillis = 0; // 开始时间
    private long endTimeMillis = 0; // 结束时间

    /**
     * 
     * doBeforeInServiceLayer:方法调用前触发 
     *
     * @author yumaochun
     * @date 2016年6月16日
     * @param joinPoint
     */
    @Before("execution(* com.crm.controller..*.*(..))")
    public void doBeforeInServiceLayer(JoinPoint joinPoint) {
        startTimeMillis = System.currentTimeMillis(); // 记录方法开始执行的时间
    }
    /**
     * 
     * doAfterInServiceLayer:方法调用后触发 
     *  记录结束时间
     *
     * @author yumaochun
     * @date 2016年6月16日
     * @param joinPoint
     */
    @After("execution(* com.crm.controller..*.*(..))")
    public void doAfterInServiceLayer(JoinPoint joinPoint) {
        endTimeMillis = System.currentTimeMillis(); // 记录方法执行完成的时间
        this.printOptLog();
    }

    @Pointcut("execution(* com.crm.controller..*.*(..))")
    public void aopLogic(){
        
        
    }
    
    /**
     * 
     * doAround:环绕触发 
     *
     * @author yumaochun
     * @date 2016年6月16日
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around(value = "aopLogic()&& @annotation(annotation) &&args(object,..) ", argNames = "annotation,object")  
    public Object doAround(ProceedingJoinPoint pjp,BussAnnotation annotation, Object object) throws Throwable {
        
        //模块名称
        String moduleName=annotation.moduleName();
        //操作名称
        String option=annotation.option();
        //System.out.println("模块名称："+moduleName+",操作名称："+option);
        int operateUserId=0;
        String description=moduleName+"【"+option+"】";
        
        /**
         * 1.获取request信息
         * 2.根据request获取session
         * 3.从session中取出登录用户信息
         */
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes)ra;
        HttpServletRequest request = sra.getRequest();
        // 从session中获取用户信息
        AdminUser  adminUser= (AdminUser) request.getSession().getAttribute("adminUser");
        if(adminUser!=null){
            userName = adminUser.getUsername();
            operateUserId=adminUser.getUserId();
        }else{
            userName = "用户未登录" ;
        }
        
        GwSysLoggerModel loggerInfo=new GwSysLoggerModel();
        loggerInfo.setOperateUserId(operateUserId);//操作用户
        loggerInfo.setDescription(description);//操作内容
        loggerInfo.setStatus(1);//状态
        loggerInfo.setIp(IPToolUtil.getIp(request));//ip地址
        loggerInfo.setOperateTime(DateUtil.getCurrentDatetime("-"));//操作时间
        //插入日志信息
        sysLoggerServiceImpl.insert(loggerInfo);
        
        // 获取输入参数
        inputParamMap = request.getParameterMap();
        // 获取请求地址
        requestPath = request.getRequestURI();
        
        // 执行完方法的返回值：调用proceed()方法，就会触发切入点方法执行
        outputParamMap = new HashMap<String, Object>();
        
        Object result = pjp.proceed();// result的值就是被拦截方法的返回值
        outputParamMap.put("result", result);
        
        return result;
    }
    
    public void insertLoggerInfo(){
        
    }

    /**
     * 
     * printOptLog:输出日志 
     *
     * @author yumaochun
     * @date 2016年6月16日
     */
    private void printOptLog() {
        String optTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startTimeMillis);
        JsonMapper jsonmapper=JsonMapper.buildNonDefaultMapper();
        StringBuffer buffer=new StringBuffer();
        buffer.append("\n user："+userName);//操作人
        buffer.append("  url："+requestPath);//请求地址
        buffer.append("; op_time：" + optTime);//开始操作时间
        buffer.append("; pro_time：" + (endTimeMillis - startTimeMillis) + "ms ;");//花费时间
        buffer.append(" param："+jsonmapper.mapConvertJsonStr(inputParamMap)+";");//请求参数
        buffer.append("\n result："+jsonmapper.mapConvertJsonStr(outputParamMap));//返回结果
        logger.info(buffer.toString());
//        logger.info("\n user："+userName
//                +"  url："+requestPath+"; op_time：" + optTime + " pro_time：" + (endTimeMillis - startTimeMillis) + "ms ;"
//                +" param："+gson.toJson(inputParamMap)+";"+"\n result："+gson.toJson(outputParamMap));
    }
}

