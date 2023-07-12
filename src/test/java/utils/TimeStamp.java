package utils;

import java.util.Date;

public class TimeStamp {
	
	public static String loginNameWithTimeStamp()

	{
		Date date = new Date();
		return "abhi-"+date.toString().replace(" ", "_").replace(":", "_");
	}
	
	public static String emailWithTimeStamp()

	{
		Date date = new Date();
		return "abhi-"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
	}
	
}
