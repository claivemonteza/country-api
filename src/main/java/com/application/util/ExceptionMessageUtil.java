package com.application.util;

public class ExceptionMessageUtil {
	
	public static String getFormatedMessage(String message){
		return message.replace("dbo.", "");
	}

}
