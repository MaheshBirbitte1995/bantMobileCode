package com.mqa.testcases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mqa.btr.base.BaseTest;
import com.mqa.btr.pages.AppsLogo;
import com.mqa.btr.pages.BuyNum;
import com.mqa.btr.pages.Greetings;
import com.mqa.btr.pages.Inbox;
import com.mqa.btr.pages.Login;

public class BuyNumbers extends BaseTest  {

	Login login;
	Inbox msg_inbox;
	Greetings greetings;
	AppsLogo appslogo;
	BuyNum numbers;
	
	@BeforeMethod
	public void initcap() throws InterruptedException, IOException {
         BaseTest.init();
         login=new Login();
		 msg_inbox=new Inbox();
		 appslogo=new AppsLogo();
		 numbers=new BuyNum();
		 login.dologin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void Verify_BuyNumbers() throws InterruptedException, IOException, AWTException {
		msg_inbox.Clickon_Menu_Icon();
		appslogo.SelectProd_Stn();
		

}
	
}