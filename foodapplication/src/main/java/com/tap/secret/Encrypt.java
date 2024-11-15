package com.tap.secret;

import com.tap.secret.secret;

public class Encrypt {
     public static String encrypt(String str) {
    	 String newStr="";
    	 for(int i=0;i<str.length()-1;i++) {
    		 newStr=newStr+((char)(str.charAt(i)+secret.getkey()));
    	 }
    	 return newStr;
     }
}
