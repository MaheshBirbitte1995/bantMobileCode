package com.mqa.testcases;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mqa.btr.base.BaseTest;
import com.mqa.btr.pages.Greetings;
import com.mqa.btr.pages.Inbox;
import com.mqa.btr.pages.Login;
import com.mqa.btr.pages.Menus;

public class MenusTest extends BaseTest {

    Login login;
	Inbox msg_inbox;
	Menus menus;
	
	@BeforeMethod
	public void initcap() throws InterruptedException, IOException {
         BaseTest.init();
         login=new Login();
		 msg_inbox=new Inbox();
		 menus=new Menus();
		 login.dologin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void Verify_create_Menus() throws InterruptedException, IOException, AWTException {
		msg_inbox.Clickon_Menu_Icon();
		menus.CreateMenu(); //created_menu_on_datalist
		
		Assert.assertEquals("AppiumAutoMenu"+menus.random_menu_name.trim(),menus.created_menu_on_datalist.getText().trim(),"Verification failed for created Menus..!!");
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
