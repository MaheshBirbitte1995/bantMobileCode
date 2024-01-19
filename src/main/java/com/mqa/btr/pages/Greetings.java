package com.mqa.btr.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mqa.btr.base.BaseTest;

import io.appium.java_client.MobileElement;

public class Greetings extends BaseTest {

	public String random_grtn_name=null;
	
	@FindBy(xpath ="//ion-label[text()=' Greetings ']")
	public WebElement Grtn_link;
	
	
	@FindBy(xpath ="//ion-title[text()=' Greetings ']")
	public WebElement Grtn_header_label;
	
	@FindBy(xpath ="//ion-title[text()=' Greetings ']")
	public WebElement grtn2;
	
	// Grtn add(+) btn
	 @FindBy(xpath ="//div[@class='col pl-0 pr-0']//ul//li[2]/ion-button//i")
	public WebElement grtn_add_btn;
	// grtn name
	@FindBy(xpath ="//div[@class='m-page']//input[@id='recordName']")
	public WebElement grtn_name;
	
	//upload icon
	@FindBy(xpath ="//div[@class='align-self-center']/div/span/label")
	public WebElement grtn_upload_icon;
	
	//save btn
	@FindBy(xpath ="//div[@class='form-group']/button[1]") 
	public WebElement grtn_save_btn;
	
	
	// files xpath
		@FindBy(xpath ="//android.view.View[@content-desc=\"Files\"]") 
		public WebElement Files_icon;
		//public MobileElement element;
	
	//banterfile
		@FindBy(xpath ="//android.widget.TextView[contains(@text,'sample-6s')]") 
		public WebElement select_file;
	
		@FindBy(xpath ="(//div[@class='gridview-card'])[1]//div[@class='card-content']/h5") 
		public WebElement created_grtn_on_datalist;	
		
	//Initializing the Page Objects:
	public Greetings(){
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickonGreetingLink() throws InterruptedException {
		Grtn_link.click();
		Thread.sleep(4000);
		
	}
	
	public void SharedGrtnLink() throws InterruptedException {
		ScrollIntoView(Grtn_link);
		Thread.sleep(2000);
		Grtn_link.click();
		Thread.sleep(4000);
		
	}
	
	public void createGrtn() throws AWTException, InterruptedException, IOException {
		Thread.sleep(5000);   
		ElementtobeClickable(grtn_add_btn);  // grtn_add_btn.click();
		Thread.sleep(3000);
		//public String random_grtn_name=null;
		random_grtn_name=RandomStringUtils.randomAlphabetic(3, 7);
		grtn_name.sendKeys("AppiumAutom"+random_grtn_name);
		grtn_upload_icon.click();
		Thread.sleep(3000);
		
		//Switch to Native_App
        Set<String> contextNames = driver.getContextHandles();
        for (String strContextName : contextNames) {
            if (strContextName.contains("NATIVE_APP")) {
                driver.context("NATIVE_APP");
                break;
            }
        }
        Files_icon.click();
        Thread.sleep(4000);
        select_file.click();
        Thread.sleep(2000); 
        
        //Switch to Chrome browser
        Set<String> contextNames1 = driver.getContextHandles();
        for (String strContextName : contextNames1) {
            if (strContextName.contains("CHROMIUM")) {
                driver.context("CHROMIUM");
                break;
            }
        }
        
        grtn_save_btn.click();  //save btn
        Thread.sleep(8000);
    }
	
}

