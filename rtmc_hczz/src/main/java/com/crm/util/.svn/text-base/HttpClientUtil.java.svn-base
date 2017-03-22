package com.crm.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

@SuppressWarnings("deprecation")
public class HttpClientUtil {

	/**
	 * 通过url获取服务器接口中返回的数据，以post方式请求
	 * 
	 * @param url          url地址
	 * @param paramMap     传递的参数集合
	 * @return   String  返回返回接口返回的数据   
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String httpPost(String url,Map<String,Object> paramMap) throws ClientProtocolException, IOException{
		@SuppressWarnings("resource")
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpResponse response;
		HttpEntity entity;
		//以下是post方法
        HttpPost httpPost = new HttpPost(url);//一定要改成可以提交的地址,这里用百度代替
        List <NameValuePair> nvps = new ArrayList <NameValuePair>();

        if(paramMap!=null){
        	//循环遍历url请求参数，放入BasicNameValuePair中
        	@SuppressWarnings("rawtypes")
			Iterator iter = paramMap.entrySet().iterator();
        	while(iter.hasNext()){
        		Map.Entry entry = (Map.Entry) iter.next();
        		String key = (String) entry.getKey();
        		String val = (String) entry.getValue();
        		nvps.add(new BasicNameValuePair(key, val));
        	}
        }
        httpPost.setEntity((HttpEntity) new UrlEncodedFormEntity(nvps, Consts.UTF_8));
       // httpPost.addHeader(arg0);
       //httpPost.setParams(arg0);
        response = httpclient.execute(httpPost);
        entity = response.getEntity();
        String body = EntityUtils.toString(entity);
        System.out.println("http post methed: " + response.getStatusLine());//这个可以打印状态
        //中断请求,接下来可以开始另一段请求
        httpPost.abort();
        //释放请求.如果释放了相当于要清空session
        httpPost.releaseConnection();
		return body;
	}
	
	
	/**
	 * 以get 方式从服务器接口获取数据
	 * @param url              请求的url地址
	 * @param paramMap         需要传递的参数map集合
	 * @return   string        返回数据
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public static String httpGet(String url,Map<String,Object> paramMap) throws ClientProtocolException, IOException{
		@SuppressWarnings("resource")
		DefaultHttpClient httpclient = new DefaultHttpClient();
		//需要传递的参数
		String paramStrs="";
        if(paramMap!=null){
        	//循环遍历url请求参数，并拼装到字符串中
        	@SuppressWarnings("rawtypes")
			Iterator iter = paramMap.entrySet().iterator();
        	while(iter.hasNext()){
        		Map.Entry entry = (Map.Entry) iter.next();
        		String key = (String) entry.getKey();
        		String val = (String) entry.getValue();
        		paramStrs+=key+"="+val+"&";
        	}
        	if(paramStrs.length()>0){
        		paramStrs=paramStrs.substring(0, paramStrs.length()-1);
        	}
        	url+="?"+paramStrs;
        } 
        //System.out.println(url);
        HttpGet httpGet = new HttpGet(url);
      
        String body = "";
        HttpResponse response;
        HttpEntity entity;
        response = httpclient.execute(httpGet);
        entity = response.getEntity();
        body = EntityUtils.toString(entity);//这个就是页面源码了
        httpGet.abort();//中断请求,接下来可以开始另一段请求
        System.out.println(body);
		return body;
	}
	

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws ClientProtocolException, IOException {
    
    	
        Map<String,Object> map = new HashMap<String, Object>();
		
		
		map.put("DLX", "WEB_PAYMENTTENDER_LIST");
		String url = "http://localhost:8080/webapi1.do";
		httpPost(url, map);

	}
	/**
	 * 获取token
	 * 
	 * @return
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public static String getToken() throws ClientProtocolException, IOException{
		//公众号
		String appid="wxab279224bb20b188";
		//认证钥匙
		String secret="d40ad1e360f0fece7989eb66eb3d5019";
		//获取token的地址
		String url="https://api.weixin.qq.com/cgi-bin/token";
        Map<String, Object> paramMap=new HashMap<String, Object>();
        paramMap.put("grant_type", "client_credential");
		paramMap.put("appid", appid);
		paramMap.put("secret", secret);
		String tokenInfo=httpGet(url,paramMap);
		//System.out.println(tokenInfo);
		//Map<String,String> map=JsonUtil.getMap(tokenInfo);
		//String token=map.get("access_token");
		return tokenInfo;
	}
	
    public static String callWebService(String soapRequest, String serviceEpr, String contentType){
        
        PostMethod postMethod = new PostMethod(serviceEpr);
        //设置POST方法请求超时
        postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000);
        
        try {
            
            byte[] b = soapRequest.getBytes("utf-8");
            InputStream inputStream = new ByteArrayInputStream(b, 0, b.length);
            RequestEntity re = new InputStreamRequestEntity(inputStream, b.length, contentType);
            postMethod.setRequestEntity(re);
            
            HttpClient httpClient = new HttpClient();
            HttpConnectionManagerParams managerParams = httpClient.getHttpConnectionManager().getParams(); 
            // 设置连接超时时间(单位毫秒)
            managerParams.setConnectionTimeout(30000);
            // 设置读数据超时时间(单位毫秒)
            managerParams.setSoTimeout(600000); 
            int statusCode = httpClient.executeMethod(postMethod);
            if (statusCode != HttpStatus.SC_OK)  
                throw new IllegalStateException("调用webservice错误 : " + postMethod.getStatusLine()); 
            
            String soapRequestData =  postMethod.getResponseBodyAsString();
            System.out.println("===="+soapRequestData);
            inputStream.close();
            return soapRequestData;
        } catch (UnsupportedEncodingException e) {
            return "errorMessage : " + e.getMessage();
        } catch (HttpException e) {
            return "errorMessage : " + e.getMessage();
        } catch (IOException e) {
            return "errorMessage : " + e.getMessage();
        }finally{
             postMethod.releaseConnection(); 
        }
    }
    
    
}
