package com.mqa.btr.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mqa.btr.base.BaseTest;

public class Recordings extends BaseTest {

	@FindBy(xpath ="//ion-label[text()=' Recordings ']")
	public WebElement record_menu_link;
	
	@FindBy(xpath ="//ion-title[text()=' Recordings ']")
	public WebElement Recrod_header_label;
	//Initializing the Page Objects:
	public Recordings(){
		PageFactory.initElements(driver, this);
	}
	
	public void clickRecordigsMenuLink() {
		record_menu_link.click();
	}
	
	public String Records_label() {
		return Recrod_header_label.getText().trim();
	}
}
