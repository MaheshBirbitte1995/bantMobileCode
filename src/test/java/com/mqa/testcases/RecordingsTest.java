package com.mqa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mqa.btr.base.BaseTest;
import com.mqa.btr.pages.CallHistory;
import com.mqa.btr.pages.Inbox;
import com.mqa.btr.pages.Recordings;

public class RecordingsTest extends BaseTest  {
	Recordings recording;
	Inbox msg_inbox;
	@BeforeClass
	public void initcap() throws InterruptedException, IOException {
		msg_inbox=new Inbox();
		recording=new Recordings();
		
	}

	@Test(priority = 1)
	public void VerifyRecordings() throws InterruptedException, IOException {
		System.out.println("VerifyRecordings started..!!");
		msg_inbox.Clickon_Menu_Icon();
		Thread.sleep(7000);
		recording.clickRecordigsMenuLink();
		Thread.sleep(7000);
		Assert.assertEquals(recording.Records_label(), "Recordings", "Recordings Header label not found..!!");
		
		//System.out.println("Done.. Voicemails srnshot..!!");
	}
	@AfterMethod //AfterMethod annotation - This method executes after every test execution
	public void screenShot(ITestResult result) throws IOException{
	
		if(ITestResult.SUCCESS==result.getStatus()){
			Takesscrnsht(driver,BaseTest.theDir+"\\Recordings.jpg");
			System.out.println("Recordings passed....!!!");
		}
		
  //using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
	if(ITestResult.FAILURE==result.getStatus()){
	try{
		Takesscrnsht(driver,BaseTest.failed_scrnshots_Dir+"\\Recordings.jpg");
		
		System.out.println("Recordings failed....!!!");
	    }
			catch (Exception e){
			    System.out.println("Exception while taking screenshot "+e.getMessage());
			    }
	}
}
	
	
}
