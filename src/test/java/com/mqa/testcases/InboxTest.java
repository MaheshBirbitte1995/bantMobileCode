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

public class InboxTest extends BaseTest  {

	Login login;
	Inbox msg_inbox;
	
	@BeforeMethod
	public void initcap() throws InterruptedException, IOException {
         BaseTest.init();
         login=new Login();
		 msg_inbox=new Inbox();
		 login.dologin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void VerifySentMessage_WithInAct() throws InterruptedException, IOException {
	msg_inbox.Clickon_Menu_Icon();
	Thread.sleep(5000);
	msg_inbox.Sendmessage(prop.getProperty("Act_act_to_number"));
	Thread.sleep(3000);
	Assert.assertEquals(msg_inbox.actual_sent_msg.getText().trim(),msg_inbox.expected_msg.trim(), "Sent message Verification failed in chat conversation at sender side..!!");
	}
	
	
	/*
	@Test(priority = 1)
	public void VerifySentMessage_Act_To_Act() throws InterruptedException, IOException {
	msg_inbox.Clickon_Menu_Icon();
	Thread.sleep(5000);
	msg_inbox.Sendmessage(prop.getProperty("Act_act_to_number"));
	msg_inbox.WaitForwebElement();	
	Thread.sleep(6000);
		 Assert.assertEquals(msg_inbox.actual_sent_msg.getText().trim(),msg_inbox.expected_msg.trim(), "Act-Act Verification failed at Sender side in chat conversation..!!");
	driver.quit();
		 VerifyMessage_At_ReceiverAcct();
		String receivrmsg= msg_inbox.Verifymsg_at_receiverside();
		if(prop.getProperty("Act_act_to_number").equalsIgnoreCase(receivrmsg.split("_")[0])) {
			System.out.println("Act_act_to_number:"+prop.getProperty("Act_act_to_number") +"receivrmsg_to_Num"+receivrmsg.split("_")[0]);
			Assert.assertEquals(msg_inbox.actual_sent_msg.getText().trim(),msg_inbox.receiver_msg_in_datalist.getText().trim(),"Act-Act Verification failed at Receiver side in Datalist..!!");
		}
	
	}  */

	public void VerifyMessage_At_ReceiverAcct() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		BaseTest.init();
        login=new Login();
		 msg_inbox=new Inbox();
		 login.dologin(prop.getProperty("user2"), prop.getProperty("password"));   //Msg verifying at Receiver acct
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
