package com.mqa.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;

import com.mqa.btr.base.BaseTest;
import com.mqa.btr.pages.Inbox;
import com.mqa.btr.pages.Login;
import com.mqa.btr.pages.Schedules;

public class EmergencyAddressTest extends BaseTest  {

	Login login;
	Inbox msg_inbox;
	Schedules schedule;
	
	@BeforeMethod
	public void initcap() throws InterruptedException, IOException {
         BaseTest.init();
         login=new Login();
		 msg_inbox=new Inbox();
		 schedule=new Schedules();
		 login.dologin(prop.getProperty("username"), prop.getProperty("password"));
	}


}
