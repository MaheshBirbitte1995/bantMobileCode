package com.mqa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mqa.btr.base.BaseTest;
import com.mqa.btr.pages.CallHistory;
import com.mqa.btr.pages.Inbox;
import com.mqa.btr.pages.Login;
import com.mqa.btr.pages.UnSubscribedProd;
import com.mqa.btr.pages.Voicemail;

public class VerifyUnsubscribedProductList extends BaseTest  {
	Login login;
	UnSubscribedProd Unsub_prod;
	
	
	@BeforeMethod
	public void initcap() throws InterruptedException, IOException {
		BaseTest.init();
		login=new Login();
		//login.dologin(prop.getProperty("username"), prop.getProperty("password"));
		Unsub_prod=new UnSubscribedProd();
		
	}
	@Test(priority = 1)
	public void doLogin() {
		login.dologin(prop.getProperty("user2"), prop.getProperty("password"));
	}
	
	
	
	@Test(priority = 2)
	public void ProductCount() throws IOException, InterruptedException {
		System.out.println("ProductCount started....!!!");
		Unsub_prod.WaitForwebElementtobeclickable();
		Thread.sleep(3000);
		Assert.assertEquals(6, Unsub_prod.VerifyProdList(), "Unsubscribed Products List should be : 6");
		Takesscrnsht(driver,BaseTest.theDir+"\\UnsubscribedProductsList.jpg");
		System.out.println("Done.....!!!");
	}

	public void verify_banter_Trial() {
		
	}
public void verify_banter_Pro() {
		
	}
public void verify_banter_Premium() {
	
}
}
