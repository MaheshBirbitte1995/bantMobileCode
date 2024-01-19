package com.mqa.btr.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor.*;

import com.mqa.btr.base.BaseTest;


public class AppsLogo extends BaseTest{
	
	@FindBy(xpath ="//div[@id=\"apps-settings-icon\"]")
	public WebElement Apps_logo;
	
	@FindBy(xpath ="//ion-item[@id=\"1665640829349\"]//ion-label")
	public WebElement prd_settings;
	
	@FindBy(xpath ="//ion-item[@id=\"1665640829349\"]//ion-label")
	public WebElement switch_prod;
	
	@FindBy(xpath ="(//ion-buttons)[1]//ion-menu-button")
	public WebElement Prd_Stn_menu;
	
	//Initializing the Page Objects:
	public AppsLogo(){
		PageFactory.initElements(driver, this);
	}

	public void SelectProd_Stn() throws InterruptedException {
		Apps_logo.click();
		Thread.sleep(3000);
		prd_settings.click();
		//driver.close();
		Thread.sleep(6000);
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    /*driver.close();
	    driver.switchTo().window(tabs2.get(0)); */
	    Thread.sleep(3000);
	    Prd_Stn_menu.click();
	    Thread.sleep(5000);
	        
	  
		
	}

}
