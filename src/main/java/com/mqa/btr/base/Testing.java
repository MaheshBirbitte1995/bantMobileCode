package com.mqa.btr.base;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.bytebuddy.utility.RandomString;

public class Testing extends BaseTest{

 @FindBy(xpath ="//ion-title[text()=' Inbox ']")
		public static WebElement Inbox_header_label;

public static void main(String[] args) {
	//System.out.println(Inbox_header_label.sen);
/*
String num="(412) 365-5989";
String res=num.replaceAll("[^a-zA-Z0-9]", "");
System.out.println("res:"+RandomStringUtils.randomAlphabetic(4, 7));*/
	
	SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss a");
	format.setTimeZone(TimeZone.getTimeZone("CST"));  //CST  EST PST
 	System.out.println(format.format(new Date()));
 	
 	Calendar cal = Calendar.getInstance();
 	 cal.setTime(new Date());
 	 cal.add(Calendar.MINUTE, 10);



}
}


