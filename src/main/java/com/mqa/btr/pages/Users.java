package com.mqa.btr.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mqa.btr.base.BaseTest;

public class Users extends BaseTest {

	@FindBy(xpath ="//ion-label[text()=' Call Handlers ']")
	public WebElement callhand_link;
	
	//Initializing the Page Objects:
	public Users(){
		PageFactory.initElements(driver, this);
	}

	public void create_User() {
		
	}

}
