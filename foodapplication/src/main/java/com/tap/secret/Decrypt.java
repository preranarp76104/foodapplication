package com.tap.secret;

import com.tap.secret.secret;

public class Decrypt {
     public static String decrypt(String str) {
    	 String newStr="";
    	 for(int i=0;i<str.length()-1;i++) {
    		 newStr=newStr+((char)(str.charAt(i)-secret.getkey()));
    	 }
    	 return newStr;
     }

	
}
