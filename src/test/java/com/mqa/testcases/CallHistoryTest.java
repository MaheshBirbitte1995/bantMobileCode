package com.mqa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mqa.btr.base.BaseTest;
import com.mqa.btr.pages.CallHistory;
import com.mqa.btr.pages.Inbox;
import com.mqa.btr.pages.Login;
import com.mqa.btr.pages.Voicemail;

public class CallHistoryTest  extends BaseTest  {
	CallHistory call_histry;
	Inbox msg_inbox;
	Login login;
	@BeforeMethod
	public void initcap() throws InterruptedException, IOException {
		BaseTest.init();
		login=new Login();
		msg_inbox=new Inbox();
		call_histry=new CallHistory();
		login.dologin(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}

	@Test(priority = 1)
	public void CallHistory() throws InterruptedException, IOException {
		System.out.println("callhistory started..!!");
		msg_inbox.Clickon_Menu_Icon();
		Thread.sleep(7000);
		call_histry.CallHistry_Menulink();
		Thread.sleep(7000);
		Assert.assertEquals(call_histry.callhistry_header_label.getText().trim(), "Call History", "CallHistory Header label not found..!!");
	}
	
	@AfterMethod //AfterMethod annotation - This method executes after every test execution
	public void screenShot(ITestResult result) throws IOException{
	
		if(ITestResult.SUCCESS==result.getStatus()){
			Takesscrnsht(driver,BaseTest.theDir+"\\CallHistory.jpg");
			System.out.println("CallHistory passed....!!!");
		}
		
  //using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
	if(ITestResult.FAILURE==result.getStatus()){
		try{
			Takesscrnsht(driver,BaseTest.failed_scrnshots_Dir+"\\CallHistory.jpg");
			System.out.println("CallHistory failed....!!!");
		    }
				catch (Exception e){
				    System.out.println("Exception while taking screenshot "+e.getMessage());
				    }
	}
	
	driver.quit();
}
	
	
	
	
	
	
	
	
}
