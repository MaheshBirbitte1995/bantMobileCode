package com.mqa.btr.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mqa.btr.base.BaseTest;

public class CallHistory extends BaseTest{


	@FindBy(xpath ="//*[@class='md button in-toolbar ion-activatable ion-focusable hydrated']")
	WebElement Menu_icon;
	
	@FindBy(xpath ="//*[contains(text(),' Call History ')]")
	WebElement Callhistory_link;  
	
	@FindBy(xpath ="//ion-title[text()=' Call History ']")
	public WebElement callhistry_header_label;
	
	//Initializing the Page Objects:
	public CallHistory(){
		PageFactory.initElements(driver, this);
	}
	
	public void CallHistry_Menulink() {
		Callhistory_link.click();
	}
	

}
