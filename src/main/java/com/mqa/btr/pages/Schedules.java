package com.mqa.btr.pages;

import java.awt.RenderingHints.Key;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mqa.btr.base.BaseTest;

public class Schedules extends BaseTest {

	public String random_schedule_name=null;
	
	@FindBy(xpath ="//ion-label[text()=' Schedules ']")
	public WebElement schedule_link;

	@FindBy(xpath ="//div[@class='ion-page']//input[@name='ion-input-1']")
	public WebElement schedule_name;
	
	@FindBy(xpath ="//div[@class='ion-padding-top']//ion-button[text()='Save ']")
	public WebElement schedule_save_btn;
	
	@FindBy(xpath ="//div//ion-select")
	public List<WebElement> schedule_timezoe;

	@FindBy(xpath ="//div[@class=\"col pl-0 pr-0\"]//ul//li[2]//ion-button")
	public WebElement sc_add_btn;
	@FindBy(xpath ="//input[@name=\"ion-input-1\"]")
	public WebElement sc_name;
	@FindBy(xpath ="//div[@class=\"ion-padding-top\"]//ion-button[1]")
	public WebElement save_btn;
	
	@FindBy(xpath ="//textarea[contains(@name,\"ion-textarea\")]")
	public WebElement description;


	@FindBy(xpath ="(//div[@class='gridview-card'])[1]//div[@class='card-content']/h5") 
	public WebElement created_schedule_on_datalist;	
	
	//Initializing the Page Objects:
		public Schedules(){
			PageFactory.initElements(driver, this);
		}


public void createSchedule() throws InterruptedException {
			Thread.sleep(5000);
			schedule_link.click();
			Thread.sleep(7000);
			ElementtobeClickable(sc_add_btn); // sc_add_btn.click();
			Thread.sleep(3000);
			// sc_add_btn, sc_name, save_btn
			random_schedule_name=RandomStringUtils.randomAlphabetic(4, 7);
			Thread.sleep(1000);
			sc_name.sendKeys("AppiumAutom"+random_schedule_name);
			Thread.sleep(2000);
			sc_name.sendKeys(Keys.TAB);
			Thread.sleep(1000);
			description.sendKeys(Keys.TAB);
			Thread.sleep(2000);
	     	ScrollIntoView(save_btn);
	     	Thread.sleep(2000);
	     	save_btn.click();
	     	Thread.sleep(7000);
		
		}
		
		
}
