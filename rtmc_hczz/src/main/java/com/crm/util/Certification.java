package com.crm.util;

import java.security.Key;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.crm.common.MonState;

/**
 * 生成uuid,加密ticket返回字符串，给cookie用，解密cert
 *
 */
public class Certification {
	
	public static final String ALGORITHM = "RC4";  
	/**
	 * 随机生成一个通用标识
	 * @return
	 */
	public static String createKey(){
		return UUID.randomUUID().toString();
	}
	
	
	/**
	 * 对字符串进行解密
	 * @param str 需要解密的String值
	 * @return 返回一个已加密的字符串
	 */
	public static byte[] decryptBase64(byte[] str){
		byte[] dekey=null;
		try {
			dekey=Base64.decode(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dekey;
	}
	
	
	/** RC4
	    * 对字符串进行解密
	    * @param str
	    * @return
	    */
	   public static String dencryptCode(byte[] str)
	   {
		String ecodeStr ="";
		   try {
			   //ecodeStr= new String(decryptRc4(str,MonState.privateKey));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ecodeStr;
	   }
	/**
	 * 对字符串进行加密
	 * @param str 需要加密的String值
	 * @return 返回一个已加密的字符串
	 */
	public static byte[] encryptBase64(byte[] str){
		byte[] enkey=null;
		try {
			enkey=Base64.encode(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return enkey;
	}
	/**RC4
	 * 对字符串进行加密
	 * @param str
	 * @return
	 */
   public static byte[] encryptCode(String str)
   {
	   byte[] ecodeStr = null;
	   try {
		   ecodeStr= encryptRc4(str.getBytes(),MonState.privateKey);
	} catch (Exception e) {
	}
	return ecodeStr;
   }
   
   /** 
	* 转换密钥<br> 
	*  
	* @param key 
	* @return 
	* @throws Exception 
	*/  
	   private static Key toKey(byte[] key) throws Exception {  
	       //DESKeySpec dks = new DESKeySpec(key);  
	       //SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);  
	      // SecretKey secretKey = keyFactory.generateSecret(dks);  
	 
	    // 当使用其他对称加密算法时，如AES、Blowfish等算法时，用下述代码替换上述三行代码  
		   SecretKey secretKey = new SecretKeySpec(key, ALGORITHM);  
	 
	       return secretKey;  
	   } 
	   
	   
	   /** 
	    * 解密 
	    *  
	    * @param data 
	    * @param key 
	    * @return 
	    * @throws Exception 
	    */  
	   public static byte[] decryptRc4(byte[] data, String key) throws Exception {  
	       Key k = toKey(key.getBytes());  
	 
	       Cipher cipher = Cipher.getInstance(ALGORITHM);  
	       cipher.init(Cipher.DECRYPT_MODE, k);  
	 
	       return cipher.doFinal(data);  
	   }  
	 
	   /** 
	    * 加密 
	    *  
	    * @param data 
	    * @param key 
	    * @return 
	    * @throws Exception 
	    */  
	   public static byte[] encryptRc4(byte[] data, String key) throws Exception {  
	       Key k = toKey(key.getBytes());  
	       Cipher cipher = Cipher.getInstance(ALGORITHM);  
	       cipher.init(Cipher.ENCRYPT_MODE, k);  
	 
	       return cipher.doFinal(data);  
	   } 

//   /**
//    * 
//    * @param aInput
//    * @param aKey
//    * @return
//    */
//      
//public static String HloveyRC4(String aInput,String aKey) 
//{ 
//    int[] iS = new int[256]; 
//    byte[] iK = new byte[256]; 
//    
//    for (int i=0;i<256;i++) 
//        iS[i]=i; 
//        
//    int j = 1; 
//    
//    for (short i= 0;i<256;i++) 
//    { 
//        iK[i]=(byte)aKey.charAt((i % aKey.length())); 
//    } 
//    
//    j=0; 
//    
//    for (int i=0;i<255;i++) 
//    { 
//        j=(j+iS[i]+iK[i]) % 256; 
//        int temp = iS[i]; 
//        iS[i]=iS[j]; 
//        iS[j]=temp; 
//    } 
//
//
//    int i=0; 
//    j=0; 
//    char[] iInputChar = aInput.toCharArray(); 
//    char[] iOutputChar = new char[iInputChar.length]; 
//    for(short x = 0;x<iInputChar.length;x++) 
//    { 
//        i = (i+1) % 256; 
//        j = (j+iS[i]) % 256; 
//        int temp = iS[i]; 
//        iS[i]=iS[j]; 
//        iS[j]=temp; 
//        int t = (iS[i]+(iS[j] % 256)) % 256; 
//        int iY = iS[t]; 
//        char iCY = (char)iY; 
//        iOutputChar[x] =(char)( iInputChar[x] ^ iCY) ;    
//    } 
//    
//    return new String(iOutputChar); 
//            
//}
   
   public static void main(String[] args) throws Exception
    {
	   	//String inputStr = "admin";       
	       
	   // String str = encrypt(HloveyRC4(inputStr,MonState.privateKey));   
	        
	    //打印加密后的字符串       
	  //  System.out.println(str);     
	        
	    //打印解密后的字符串
	   //	System.out.println(encryptCode("龟儿子的"));
	    //System.out.println(dencryptCode("6b2F5YSt5a+x55m6"));   
//	   System.out.println(Base64.encode((new String("12345")).getBytes()));
		System.out.println(encrypt("wenhao"));
		//System.out.println(decrypt("tGLCkwB1F+yl"));
		//System.out.println(encryptMD5("aaa123"));
    }  
   /**加密
    * base64+RC4
    * @param str
    * @return
    */
   public static String encrypt(String str)
   {
	   return new String(encryptBase64(encryptCode(str)));
   }
   /**
    * 解密
    * base64+RC4
    * @param str
    * @return
    */
   public static String decrypt(String str)
   {
	   return new String(dencryptCode(decryptBase64(str.getBytes())));
   }

   /**加密
    * MD5
    * @param str
    * @return
    */
   public static String encryptMD5(String str)
   {
	   //MD5 md5 = new MD5();
	   //return md5.getMD5ofStr(str).toLowerCase();
	   return "";
   }
	
   public static String str2HexStr(String str) {  

       char[] chars = "0123456789ABCDEF".toCharArray();  

       StringBuilder sb = new StringBuilder("");

       byte[] bs = str.getBytes();  

       int bit;  

       for (int i = 0; i < bs.length; i++) {  

           bit = (bs[i] & 0x0f0) >> 4;  

           sb.append(chars[bit]);  

           bit = bs[i] & 0x0f;  

           sb.append(chars[bit]);  

       }  

       return sb.toString();  

   }

}
