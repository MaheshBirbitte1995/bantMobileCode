package com.mqa.btr.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mqa.btr.base.BaseTest;

public class CallHandler extends BaseTest {

	@FindBy(xpath ="//ion-label[text()=' Call Handlers ']")
	public WebElement callhand_link;

	@FindBy(xpath ="//div[@class='col pl-0 pr-0']//ul//li[2]//ion-button")
	public WebElement callhand_Add_btn;
	
	@FindBy(xpath ="//input[@placeholder='Name']")
	public WebElement name;
	
	@FindBy(xpath ="//div[@class='ion-padding-top']//ion-button[text()='Save ']")
	public WebElement save_btn;
	
	@FindBy(xpath ="(//div[@class='gridview-card']//div[2]//h5)[1]")
	public WebElement created_callhand_on_datalist;
	
	
	
	public String random_callhand_name=null;
	//Initializing the Page Objects:
	public CallHandler(){
		PageFactory.initElements(driver, this);
	}


		public void callHnadler_dnd_save() throws InterruptedException {
			ScrollIntoView(callhand_link);
			Thread.sleep(4000);
			callhand_link.click();
			Thread.sleep(7000);
			ElementtobeClickable(callhand_Add_btn);  //callhand_Add_btn.click();
			Thread.sleep(2000);
			random_callhand_name=RandomStringUtils.randomAlphabetic(3, 5);
			name.sendKeys("callhandAuto"+random_callhand_name.trim());
			Thread.sleep(2000);
			save_btn.click();
			Thread.sleep(5000);
		}
}
