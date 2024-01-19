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
import com.mqa.btr.pages.CallSettings;
import com.mqa.btr.pages.Inbox;
import com.mqa.btr.pages.Login;

public class CallSettingsTest extends BaseTest {
	CallSettings call_settings;
	Inbox msg_inbox;
	Login login;
	
	@BeforeMethod
	public void initcap() throws InterruptedException, IOException {
		BaseTest.init();
		login=new Login();
		msg_inbox=new Inbox();
		call_settings=new CallSettings();
		login.dologin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	private void gotoCallSettings() throws InterruptedException {
		Thread.sleep(5000);
		msg_inbox.Clickon_Menu_Icon();
		Thread.sleep(4000);
		call_settings.clickonCallStnLink();
		//call_settings.WaitForwebElement(call_settings.callStn_header_label.toString());
		Thread.sleep(4000);
		
		
	}

	@Test(priority = 1)
	public void CallSettings_Ringmyphone() throws InterruptedException, IOException {
		gotoCallSettings();
	    Thread.sleep(4000);
		call_settings.select_Ringmyphn();
		Assert.assertTrue(call_settings.check_mark.isDisplayed(), "Ring My Phone Not saved..!!");

}
    @Test(priority =2)
	public void Call_Setting_CallForward() throws InterruptedException {
		gotoCallSettings();
		call_settings.select_CallFarwrd(prop.getProperty("CallFrwd_num"));
		Thread.sleep(4000);
		//call_settings.WaitForwebElement(call_settings.check_mark.toString());
		Assert.assertTrue(call_settings.check_mark.isDisplayed(), "CallForward Not saved..!!");

		
	}
    
    @Test(priority = 3)
	public void Call_Setting_Voicemails() throws InterruptedException {
		gotoCallSettings();
		call_settings.selectvoicemail();
		Assert.assertTrue(call_settings.check_mark.isDisplayed(), "CallForward Extension Not saved..!!");
}
	@Test(priority = 4)
	public void Call_Setting_selectIVR() throws InterruptedException {
		gotoCallSettings();
		call_settings.selectMenuIVR();
		Assert.assertTrue(call_settings.check_mark.isDisplayed(), "MenuIVR is Not saved..!!");
	}
	@Test(priority = 5)
	public void Call_Setting_selectDNDdisconnect() throws InterruptedException {
		gotoCallSettings();
		call_settings.DndDisconnet();
		Assert.assertTrue(call_settings.check_mark.isDisplayed(), "DND/Disconnect is Not saved..!!");
		
	}
	
	@Test(priority = 6)
	public void Call_Setting_selectPlayGreeting() throws InterruptedException {
		gotoCallSettings();
		call_settings.selectplayGrtn();
		Assert.assertTrue(call_settings.check_mark.isDisplayed(), "PlayGreeting is Not saved..!!");
	}
	
	@Test(priority =7)
	public void Call_Setting_selectschedule() throws InterruptedException {
		gotoCallSettings();
		call_settings.selectSchedules();
		
		Assert.assertTrue(call_settings.check_mark.isDisplayed(), "Schedule is Not saved..!!");
	}
	
	@AfterMethod //AfterMethod annotation - This method executes after every test execution
	public void screenShot(ITestResult result) throws IOException{
	
		if(ITestResult.SUCCESS==result.getStatus()){
			Takesscrnsht(driver,BaseTest.theDir+"\\"+ result.getMethod().getMethodName() +".jpg");
			System.out.println("This method is:"+result.getMethod().getMethodName() +"is Pass..");
			
		}
		
  //using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
	if(ITestResult.FAILURE==result.getStatus()){
	try{
		Takesscrnsht(driver,BaseTest.failed_scrnshots_Dir+"\\"+ result.getMethod().getMethodName() +".jpg");
		System.out.println("This method is:"+result.getMethod().getMethodName() +"is Fail..");
		
	    }
	      catch (Exception e){
			    System.out.println("Exception while taking screenshot "+e.getMessage());
			    }
	}
	
	driver.quit();
	
}
	
}