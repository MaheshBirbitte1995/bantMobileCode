package com.mqa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.mqa.btr.base.BaseTest;

public class Testcasecheck {
	
	@Test(priority = 1)
	public void Test1() {
		Assert.assertTrue(false, "Test1 failed");
	}
	@Test(priority = 2)
	public void Test2() {
		Assert.assertTrue(true, "Test2 failed");
	}
	@Test(priority = 3)
	public void Test3() {
		Assert.assertTrue(false, "Test3 failed");
	}
	@AfterMethod //AfterMethod annotation - This method executes after every test execution
	public void screenShot(ITestResult result) throws IOException{
	
		if(ITestResult.SUCCESS==result.getStatus()){
			//Takesscrnsht(driver,BaseTest.theDir+"\\"+ result.getMethod().getMethodName() +".jpg");
			System.out.println("This method is:"+result.getMethod().getMethodName() +"is Pass..");
		}
		
  //using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
	if(ITestResult.FAILURE==result.getStatus()){
	try{
		//Takesscrnsht(driver,BaseTest.failed_scrnshots_Dir+"\\"+ result.getMethod().getMethodName() +".jpg");
		System.out.println("This method is:"+result.getMethod().getMethodName() +"is Fail..");
	    }
			catch (Exception e){
			    System.out.println("Exception while taking screenshot "+e.getMessage());
			    }
	}
}

	
	@AfterMethod
	public void teardown() {
		System.out.println("QUIT..!!");
	}
}
