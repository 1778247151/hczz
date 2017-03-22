package com.crm.util;

import org.apache.commons.dbcp.BasicDataSource;

public class BasicDataSourceUtil extends BasicDataSource{
	@Override
	public synchronized void setPassword(String password) {
		
		byte[] result = Base64.decode(password);
		String newPassword=new String(result);
		//System.out.println(newPassword);
		super.setPassword(newPassword);
	}

	
}
