package com.mqa.btr.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mqa.btr.base.BaseTest;

public class Voicemail extends BaseTest {

	@FindBy(xpath ="//*[@class='md button in-toolbar ion-activatable ion-focusable hydrated']")
	WebElement Menu_icon;
	
	@FindBy(xpath ="//*[contains(text(),' Voicemails ')]")
	WebElement voicemail_link;
	
	
	@FindBy(xpath ="//ion-title[text()=' Voicemails ']")
	public WebElement voicemail_header_label;
	//Initializing the Page Objects:
	public Voicemail(){
		PageFactory.initElements(driver, this);
	}
	
	public void voicemail_menu_link() {
		voicemail_link.click();
	}

}
