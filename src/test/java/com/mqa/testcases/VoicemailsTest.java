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

public class VoicemailsTest extends BaseTest  {
	Login login;
	Voicemail voicemail;
	Inbox msg_inbox;
	
	
	@BeforeMethod
	public void initcap() throws InterruptedException, IOException {
		BaseTest.init();
		login=new Login();
		 msg_inbox=new Inbox();
		voicemail=new Voicemail();
		login.dologin(prop.getProperty("username"), prop.getProperty("password"));
		// login.WaitForwebElement();
		
		
	}
	
	@Test(priority = 1)
	public void Voicemail() throws InterruptedException, IOException {
		msg_inbox.Clickon_Menu_Icon();
		voicemail.voicemail_menu_link();
		Thread.sleep(7000);
		Assert.assertEquals(voicemail.voicemail_header_label.getText().trim(), "Voicemails", "Voicemails Header label not found..!!");
		//Takesscrnsht(driver,BaseTest.theDir+"\\VoicemailGrid.jpg");
		
	}
	@AfterMethod //AfterMethod annotation - This method executes after every test execution
	public void screenShot(ITestResult result) throws IOException{
	
		if(ITestResult.SUCCESS==result.getStatus()){
			Takesscrnsht(driver,BaseTest.theDir+"\\Voicemails.jpg");
			System.out.println("Voicemails passed....!!!");
		}
		
  //using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
	if(ITestResult.FAILURE==result.getStatus()){
	try{
		Takesscrnsht(driver,BaseTest.failed_scrnshots_Dir+"\\Voicemails.jpg");
		
		System.out.println("Voicemails failed....!!!");
	    }
			catch (Exception e){
			    System.out.println("Exception while taking screenshot "+e.getMessage());
			    }
	}
	driver.quit();
}

}
