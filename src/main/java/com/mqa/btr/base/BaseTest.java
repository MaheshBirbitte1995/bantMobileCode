package com.mqa.btr.base;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.reporters.jq.TimesPanel;
import org.w3c.dom.xpath.XPathExpression;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.events.api.general.AppiumWebDriverEventListener;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class BaseTest {

	public static AndroidDriver<AndroidElement> driver;
	public static AndroidDriver<MobileElement> app_driver;
	public static Properties prop;
	public static File theDir;  
	public static File failed_scrnshots_Dir;  //failed_scrnshots_Dir
	public static DesiredCapabilities caps;

	public BaseTest(){
		try {
			//DriverManager.drivers()
			prop = new Properties();
			//System.out.println("file::"+System.getProperty("user.dir")+ "\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\mqa\\btr\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void init() throws InterruptedException, IOException{
		//Set the Desired Capabilities for Android device
		caps = new DesiredCapabilities();

		if(prop.getProperty("path").equalsIgnoreCase("mportal")) {
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
			caps.setCapability(MobileCapabilityType.BROWSER_NAME, prop.getProperty("Browser")); // if mobile-Browser execution
			caps.setCapability(MobileCapabilityType.DEVICE_NAME,prop.getProperty("deviceName")); //caps.setCapability("deviceName", "Android Emulator");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty("Mobileversion"));
			caps.setCapability("adbExecTimeout", 50000);
			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,prop.getProperty("AutomationName"));
			caps.setCapability(MobileCapabilityType.NO_RESET, true);
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 50000); 

			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("androidKeepAppDataDir", true);
			caps.setCapability(ChromeOptions.CAPABILITY, options);

			caps.setCapability("chromedriverExecutable",prop.getProperty("chromedriver"));
			driver = new AndroidDriver<AndroidElement>(new URL(prop.getProperty("AppiumURL")), caps); //AppiumURL
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
		}else {
			caps.setCapability("automationName", prop.getProperty("AutomationName"));
			caps.setCapability("platformName", "Android");
			caps.setCapability("deviceName", prop.getProperty("deviceName"));
			//caps.setCapability("avd", "Pixel");
			caps.setCapability(MobileCapabilityType.NO_RESET, true);
			caps.setCapability("uiautomator2ServerLaunchTimeout", 20000);
			caps.setCapability("appPackage", "io.banter.apps"); //For windows command------> adb shell dumpsys window | find "mCurrentFocus"
			caps.setCapability("appActivity", "io.banter.apps.MainActivity"); //Add app activity name
			caps.setCapability("app", System.getProperty("user.dir") + "\\apps\\" + "base4.apk");  //base4.apk
			app_driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		}
		makedir();




	}


	public static void makedir() {
		// TODO Auto-generated method stub
		DateFormat formatter = new SimpleDateFormat("MMMdd_yy");
		String Today_date_Images = formatter.format(new Date());

		theDir = new File(prop.getProperty("ScreenshotPath")+"\\"+"Pass_"+Today_date_Images);
		failed_scrnshots_Dir = new File(prop.getProperty("ScreenshotPath")+"\\"+"Fail_"+Today_date_Images);
		if (!theDir.exists()){
			theDir.mkdirs();
		}

		if(!failed_scrnshots_Dir.exists()) {
			failed_scrnshots_Dir.mkdirs();
		}

	}

	public void ScrollIntoView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}

	public void Takesscrnsht(AndroidDriver<AndroidElement> driver2, String filepath) throws IOException {
		
		//Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot =((TakesScreenshot)driver2);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(filepath);
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);

	}

	public void Explicitwait(String xpath) {
		WebDriverWait expli_wait = new WebDriverWait(driver, 60);
		WebElement element = expli_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

	}

	public void ElementtobeClickable(WebElement xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 60); 
		wait.until(ExpectedConditions.elementToBeClickable(xpath)).click();

	}


	public void Fluentwait(AndroidDriver<AndroidElement> driver,String xpath) {
		Wait<AndroidDriver<AndroidElement>> flunet_wait = new FluentWait<AndroidDriver<AndroidElement>>(driver)
				.withTimeout(Duration.ofSeconds(70))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(Exception.class);

		AndroidElement clickseleniumlink = (AndroidElement) flunet_wait.until(new Function<AndroidDriver, WebElement>(){
			public WebElement apply(AndroidDriver driver ) {
				return driver.findElement(By.xpath(xpath));
			}
		});
	}


}	

