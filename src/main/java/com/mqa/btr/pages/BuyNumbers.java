package com.mqa.btr.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mqa.btr.base.BaseTest;

public class BuyNumbers extends BaseTest {
	@FindBy(xpath ="//ion-item[@id=\"1665640829349\"]//ion-label")
	public WebElement num_search;
	
	//Initializing the Page Objects:
	public BuyNumbers(){
		PageFactory.initElements(driver, this);
	}


}
