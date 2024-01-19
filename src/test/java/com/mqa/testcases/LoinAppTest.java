package com.mqa.testcases;
import java.io.File;
import com.mqa.btr.pages.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.reporters.jq.TimesPanel;
import org.w3c.dom.xpath.XPathExpression;

import com.google.common.collect.ImmutableMap;
import com.mqa.btr.base.BaseTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;


public class LoinAppTest extends BaseTest  {
	Login login;
		@BeforeMethod
		public void initcap() throws InterruptedException, IOException {
			BaseTest.init();
			login=new Login();
			
		}

		@Test(priority = 1)
		public void Login() throws IOException, InterruptedException {
			System.out.println("Login started....!!!");
			login.dologin(prop.getProperty("username"), prop.getProperty("password"));
			//login.WaitForwebElement();
			
		    Assert.assertEquals("Inbox", login.Inbox_header_label.getText().trim(), "Login failed..!!");
			//Takesscrnsht(driver,BaseTest.theDir+"\\LoginScreen.jpg");
			
		}
		
		@AfterMethod //AfterMethod annotation - This method executes after every test execution
		public void screenShot(ITestResult result) throws IOException{
		
			if(ITestResult.SUCCESS==result.getStatus()){
				//Takesscrnsht(driver,BaseTest.theDir+"\\Login.jpg");
				System.out.println("Login passed....!!!");
			}
			
	  //using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
		if(ITestResult.FAILURE==result.getStatus()){
		try{
			//Takesscrnsht(driver,BaseTest.failed_scrnshots_Dir+"\\Login.jpg");
			System.out.println("Login failed....!!!");
		}catch (Exception e){
		System.out.println("Exception while taking screenshot "+e.getMessage());
		}
		}
		
		
		}
			
		@AfterMethod
		public void teardown() {
			driver.quit();
			//System.out.println("QUIT..!!");
		}
		
		
		
		}	



