package com.mqa.testcases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mqa.btr.base.BaseTest;
import com.mqa.btr.pages.AppsLogo;
import com.mqa.btr.pages.CallHandler;
import com.mqa.btr.pages.Inbox;
import com.mqa.btr.pages.Login;
import com.mqa.btr.pages.Menus;

public class CallHandlers extends BaseTest {

	Login login;
	Inbox msg_inbox;
	Menus menus;
	AppsLogo appslogo;
	CallHandler callhand;
	
	@BeforeMethod
	public void initcap() throws InterruptedException, IOException {
         BaseTest.init();
         login=new Login();
		 msg_inbox=new Inbox();
		 appslogo=new AppsLogo();
		 callhand=new CallHandler();
		 login.dologin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void Verify_create_CallHandlers() throws InterruptedException, IOException, AWTException {
		msg_inbox.Clickon_Menu_Icon();
		appslogo.SelectProd_Stn();
		callhand.callHnadler_dnd_save();  // (//div[@class='gridview-card']//div[2]//h5)[1]
		Assert.assertEquals("callhandAuto"+callhand.random_callhand_name.trim(),callhand.created_callhand_on_datalist.getText().trim(),"Verification failed for created callhandlers..!!");
	}
	
	@AfterMethod //AfterMethod annotation - This method executes after every test execution
	public void screenShot(ITestResult result) throws IOException{
		
		if(ITestResult.SUCCESS==result.getStatus()){
			Takesscrnsht(driver,BaseTest.theDir+"\\"+result.getMethod().getMethodName()+".jpg");
			System.out.println("Passed....!!! ie "+result.getMethod().getMethodName());
		}
		
  //using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
	if(ITestResult.FAILURE==result.getStatus()){
	try{
		Takesscrnsht(driver,BaseTest.failed_scrnshots_Dir+"\\"+result.getMethod().getMethodName()+".jpg");
		System.out.println("Failed....!!! ie "+result.getMethod().getMethodName());
	}catch (Exception e){
	System.out.println("Exception while taking screenshot "+e.getMessage());
	}
	}
	
	driver.quit();
	}

}

