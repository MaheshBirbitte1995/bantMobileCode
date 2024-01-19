package com.mqa.btr.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mqa.btr.base.BaseTest;

public class EmergencyAddress extends BaseTest {

	public String random_grtn_name=null;
	
	@FindBy(xpath ="//ion-label[text()=' Emergency Address ']")
	public WebElement Emergencyaddr_link;
	
	
	@FindBy(xpath ="//ion-title[text()=' Greetings ']")
	public WebElement Grtn_header_label;
	
	//Initializing the Page Objects:
		public EmergencyAddress(){
			PageFactory.initElements(driver, this);
		}
		
}
