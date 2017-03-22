package com.crm.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

import com.crm.common.MD5;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;


public class CommonUtil {

	protected static Logger logger = Logger.getLogger(CommonUtil.class);
	
	
	
	public static HttpSession getSeesion(HttpServletRequest request){
		return request.getSession();
	}
	
	public static void clearSeesion(HttpServletRequest request){
		request.getSession().invalidate();
	}
	
	public static boolean getAdminIsLogin(HttpServletRequest request){
		return getSeesion(request,"adminId")==null?false:true;
	}
	
	public static void setSeesionValue(HttpServletRequest request,String key,Object value){
		getSeesion(request).setAttribute(key, value);
	}
	
	public static void setSeesionValue(HttpServletRequest request,String key,String value){
		getSeesion(request).setAttribute(key, value);
	}
	
	public static String getSeesionAdminValue(HttpServletRequest request){
		return getSeesionValue(request,"adminId");
	}
	
	public static boolean isSuperAdmin(HttpServletRequest request){
		return getSeesionAdminValue(request).equalsIgnoreCase("superAdmin")?true:false;
	}
	
	public static Object getSeesion(HttpServletRequest request,String key){
		return getSeesion(request).getAttribute(key);
	}
	
	public static boolean exsitSeesionValue(HttpServletRequest request,String key){
		return getSeesion(request,key)==null?false:true;
	}
	
	public static String getSeesionValue(HttpServletRequest request,String key){
		return getSeesion(request).getAttribute(key).toString();
	}
	
	public static int getPageNum(int totalNum, int pageSize) {
		if (totalNum <= 0) {
			return 1;
		}
		if (totalNum % pageSize == 0) {
			return totalNum / pageSize;
		} else {
			return (totalNum / pageSize) + 1;
		}
	}
	
	public static String getJsonString(String jsonMode, String jsonstr) {
		StringBuffer strParam = new StringBuffer("{");
		if (jsonstr != null)
			strParam.append("\"success\":" + jsonMode + ",\"message\":\""+ jsonstr + "\"");
		else
			strParam.append("\"success\":" + jsonMode + "");
		strParam.append("}");
		return strParam.toString();
	}
	
	public static String getJsonString1(String jsonMode, String jsonstr,String searchStr) {
		StringBuffer strParam = new StringBuffer("{");
		if (jsonstr != null)
			strParam.append("\"success\":" + jsonMode + ",\"message\":\""+ jsonstr + "\",\"return\":\""+ searchStr +"\"");
		else
			strParam.append("\"success\":" + jsonMode + "");
		strParam.append("}");
		return strParam.toString();
	}
	
	public static String getJsonString2(String jsonMode, String jsonstr,String searchStr) {
		StringBuffer strParam = new StringBuffer("{");
		if (jsonstr != null)
			strParam.append("\"success\":" + jsonMode + ",\"message\":\""+ jsonstr + "\",\"returnMsg\":\""+ searchStr +"\"");
		else
			strParam.append("\"success\":" + jsonMode + "");
		strParam.append("}");
		return strParam.toString();
	}
	
	
	
	/**
	 * 将数据以html方式输出到页面
	 * @param String
	 */
	public static void outputHTMLData(String outputString,HttpServletResponse response){ 
		try
		{ 
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			response.setHeader("Cache-Control","no-cache");
			response.getWriter().println(outputString);
			response.getWriter().close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static String ajaxReturn(int status,String msg){
		return ajaxReturn(status, msg, null);
	}
	
	public static String ajaxReturn(int status,String msg,Object data){
		
		Map m = new HashMap();
		m.put("status", status);
		m.put("msg", msg);
		if(data != null){
			m.put("data", data);
		}
		
		JSONObject object = JSONObject.fromObject(m);
		return object.toString();
		
	}
	/**
	 * xheditor上传图片
	 * @param status
	 * @param msg
	 * @param data
	 * @return
	 */
	public static String ajaxReturnXheditorImg(String err,Object data){
		
		Map m = new HashMap();
		m.put("err", err);
		m.put("msg", data);
		
		JSONObject object = JSONObject.fromObject(m);
		return object.toString();
		
	}
	
	public static void outputAjaxJsonData(String outputString,HttpServletResponse response){ 
		try
		{ 
			response.setContentType("text/json");
			response.setCharacterEncoding("utf-8");
			response.setHeader("Cache-Control","no-cache");
			response.getWriter().println(outputString);
			response.getWriter().close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 将对象转化成json格式数据以ajax方式输出到页面
	 * @param Object
	 */
	public static void outputAjaxJsonData(boolean have,Map obj,HttpServletResponse response){
		String json = "";
		if (obj == null){
			json = "{success:false}";
			return;
		}
		else{			
			JSONObject object = JSONObject.fromObject(obj);
			try
			{
				json = object.toString();
				response.setContentType("text/json");
				response.setCharacterEncoding("utf-8");
				response.setHeader("Cache-Control","no-cache");
				response.getWriter().println(json);
				response.getWriter().close();
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
	
	/**
	 * 将对象转化成json格式数据以ajax方式输出到页面
	 * @param Object
	 */
	public static void outputAjaxJsonData(Object obj,HttpServletResponse response){
		String json = "";
		if (obj == null){
			json = "{success:false}";
			return;
		}
		else{			
			JSONArray jsonObject = JSONArray.fromObject(obj);
			try
			{
				json = jsonObject.toString();
				response.setContentType("text/json");
				response.setCharacterEncoding("utf-8");
				response.setHeader("Cache-Control","no-cache");
				response.getWriter().println(json);
				response.getWriter().close();
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
	
	public static boolean isImgFile(String ext) {
		if (ext == null) {
			return false;
		}
		if ("jpg".equals(ext)) {
			return true;
		}
		if ("jpeg".equals(ext)) {
			return true;
		}
		if ("gif".equals(ext)) {
			return true;
		}
		if ("bmp".equals(ext)) {
			return true;
		}
		if ("png".equals(ext)) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * 消息提示
	 * @param request
	 * @param response
	 */
	
	public static String alertMsg(String msg)
	{
		StringBuffer error = new StringBuffer();
		error.append("<script type=\"text/javascript\">$(function(){$.ligerDialog.error(\""+msg+"\");});</script>");
		return error.toString();
	}
	
	/**
	 * 生成4位随机数
	 * @return
	 */
	public static String getRandomGroupId()
	{
		String sRand = "";
		String[] beforeShuffle = new String[] {"1","2", "3", "4", "5", "6", "7",  
                "8", "9","0", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",  
                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",  
                "W", "X", "Y", "Z" };  
        List list = Arrays.asList(beforeShuffle);  
        Collections.shuffle(list);  
        StringBuilder sb = new StringBuilder();  
        for (int i = 0; i < list.size(); i++) {  
            sb.append(list.get(i));  
        }  
        String afterShuffle = sb.toString();  
        sRand = afterShuffle.substring(5, 9);  
		return sRand;
	}
	/**
	 * 
	 * getRandomInfo:获取验证码并存入session中
	 *
	 * @author yumaochun
	 * @date 2016年5月27日
	 * @return
	 */
	public static String getRandomInfo(HttpServletRequest request){
		String random=getRandomGroupId();
		// 将认证码存入SESSION
		request.getSession().setAttribute("rand", MD5.getMD5(random.toLowerCase()));
		return random;
	}
	
	public static void outputImage(HttpServletRequest request,HttpServletResponse response){ 
		try
		{ 
			//禁止缓存
			  response.setHeader("Pragma", "No-cache");
			  response.setHeader("Cache-Control", "No-cache");
			  response.setDateHeader("Expires", 0);
			  // 指定生成的响应是图片
			  response.setContentType("image/jpeg");

			// 在内存中创建图象
			int width = 60, height = 20;

			BufferedImage image = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);

			// 获取图形上下�?
			Graphics g = image.getGraphics();

			// 生成随机�?
			Random random = new Random();

			// 设定背景�?
			g.setColor(getRandColor(200, 250));
			g.fillRect(0, 0, width, height);

			// 设定字体
			g.setFont(new Font("Times New Roman", Font.PLAIN, 18));

			// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测�?
			g.setColor(getRandColor(160, 200));
			for (int i = 0; i < 155; i++) {
				int x = random.nextInt(width);
				int y = random.nextInt(height);
				int xl = random.nextInt(12);
				int yl = random.nextInt(12);
				g.drawLine(x, y, x + xl, y + yl);
			}

			//生成随机4位数，数字，字母
//			String Rand4 = getRandomGroupId();
			// 取随机产生的认证�?4位数�?
			String sRand = "";
			for (int i = 0; i < 4; i++) {
				String rand = String.valueOf(random.nextInt(10));
				//生成4位随机验证码，数字加字母
//				String rand = Rand4.substring(i,i+1);
				sRand += rand;
				// 将认证码显示到图象中
				g.setColor(new Color(20 + random.nextInt(110), 20 + random
						.nextInt(110), 20 + random.nextInt(110)));
				// 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生�?
	            g.drawString(rand, 13 * i + 6, 16);
			}

			// 将认证码存入SESSION
			request.getSession().setAttribute("rand", MD5.getMD5(sRand));
			// 图象生效
			g.dispose();
			//ImageIO.write(image, "JPEG", response.getOutputStream());
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(response.getOutputStream()); 
			encoder.encode(image);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/*
	* 给定范围获得随机颜色
	*/
	private static Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

	
	// 获得session中的userId
	public static int getSesseionUserId(HttpServletRequest request) {
		if (request.getSession().getAttribute("adminId") == null) {
			return 0;
		}
		try {
			int userId = Integer.parseInt(request.getSession().getAttribute(
					"adminId").toString());
			return userId;
		} catch (Exception e) {
			return 0;
		}

	}
	
	// 获得session中的oauth_token
	public static String getSesseionOauthToken(HttpServletRequest request) {
		if (request.getSession().getAttribute("oauth_token") == null) {
			System.err.println("oauth_token is null");
			return null;
		}
		System.out.println("oauth_token:"+request.getSession().getAttribute("oauth_token").toString());
		return request.getSession().getAttribute("oauth_token").toString();
	}
	
	// 获得session中的open_id
	public static String getSesseionOpenId(HttpServletRequest request) {
		if (request.getSession().getAttribute("openid") == null) {
			System.err.println("openid is null");
			return null;
		}
		System.out.println("openid:"+request.getSession().getAttribute("openid").toString());
		return request.getSession().getAttribute("openid").toString();
	}
	
	// 获得session中的oauth_token_secret
	public static String getSesseionOauthTokenSecret(HttpServletRequest request) {
		if (request.getSession().getAttribute("oauth_token_secret") == null) {
			System.err.println("oauth_token_secret is null");
			return null;
		}
		System.out.println("oauth_token_secret:"+request.getSession().getAttribute("oauth_token_secret").toString());
		return request.getSession().getAttribute("oauth_token_secret").toString();
	}

	// Parse page number
	public static Integer parsePageNum(String page) {
		int pageVar = CommonUtil.parseInt(page);
		pageVar = pageVar <= 0 ? 1 : pageVar;
		return pageVar;
	}

	// Parse Integer
	public static Integer parseInt(String s) {
		try {
			int i = Integer.parseInt(s);
			if (i < 0) {
				return 0;
			}
			return i;
		} catch (Exception e) {
			return 0;
		}
	}
	
	// 查询出Is Share的值，并保存在Map中
	public static void sotreIsShareInMap(Map<String, Object> map,HttpServletRequest request) {
		String cookieStrContent = "shareValue";
		String cont = getCookieVal(request, cookieStrContent);
		if (cont == null) {
			map.put("isShare", 1);
		} else {
			if("0".equals(cont)){
				map.put("isShare", 0);
			}else{
				map.put("isShare", 1);
			}
		}
	}


	public static String getCookieVal(HttpServletRequest request, String name) {

		Cookie[] cookies = request.getCookies();// 这样便可以获取一个cookie数组

		if (cookies == null) { // COOKIES为空的操作
			return null;
		}

		for (int i = 0; i < cookies.length; i++) { // 找到COOKIE进行的操作
			Cookie cookie = cookies[i];
			if (name.equals(cookie.getName())) {
				return cookie.getValue();
			}
		}

		return null;

	}

	public static boolean getCookie(String name, HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			return false;
		}
		for (Cookie cookie : cookies) {
			if (name.equals(cookie.getName())) {
				return true;
			}
		}
		return false;
	}
	
	public static String getUrlEncoding(String value)
	{
		String utf8Code = "";
		try {
			utf8Code =  URLDecoder.decode(value, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return utf8Code;
	}

	public static String prompt(String msg) {
		return "<script>jAlert(\"" + msg + "\", \"Alert Dialog\");</script>";
	}
}
