package com.crm.bean;

import javax.mail.PasswordAuthentication;

/**
 * 
 * 
 * @author meishengjun
 *
 */
public class Email_Autherticatorbean {
	private String m_username = null;  
    private String m_userpass = null;  
  
    public void setUsername(String username) {  
        m_username = username;  
    }  
  
    public void setUserpass(String userpass) {  
        m_userpass = userpass;  
    }  
  
    public Email_Autherticatorbean(String username, String userpass) {  
        super();  
        setUsername(username);  
        setUserpass(userpass);  
  
    }  
  
    public PasswordAuthentication getPasswordAuthentication() {  
  
        return new PasswordAuthentication(m_username, m_userpass);  
    }  
}
