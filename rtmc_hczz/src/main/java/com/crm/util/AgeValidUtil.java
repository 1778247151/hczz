package com.crm.util;

public class AgeValidUtil {
	
	
	public static void main(String[] args) {
		
		AgeValidUtil aa=new AgeValidUtil();
		
	}
	
	 public static boolean isUserAgeValid(String  UserInputAge){

		 
		    boolean isTrue = false;

		    try {
		    	   if(!UserInputAge.equals(null) && !UserInputAge.equals("")){

			            int ageInt = Integer.parseInt(UserInputAge);
			            if(ageInt < 60 && ageInt > 18){
			                isTrue = true;

			            }

			    }
			} catch (Exception e) {
				System.out.println("年龄异常"+e.getMessage());
			}
		 
		return isTrue;
		 
	 }
 

}
