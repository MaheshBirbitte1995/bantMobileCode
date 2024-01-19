package com.mqa.btr.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mqa.btr.base.BaseTest;

public class UnSubscribedProd extends BaseTest {

	
	//Page Factory - OR:
			@FindBy(xpath ="//*[contains(text(),'Unsubscribed')]")
			WebElement Unsub_tab;
			
			@FindBy(xpath ="//div[@class='height100']//div//div//img")
			List<WebElement> Product_list;
			
			@FindBy(xpath ="//ion-segment-button[2]")
			WebElement banter_prod;
			//Initializing the Page Objects:
			public UnSubscribedProd(){
				PageFactory.initElements(driver, this);
			}
		
			
			public void selectUnsubscribedtab() {
				Unsub_tab.click();
			}

			public int VerifyProdList() {
				return Product_list.size();
			}
			
			
			public void WaitForwebElementtobeclickable() {
				WebDriverWait wait = new WebDriverWait(driver, 100);
				wait.until(ExpectedConditions.elementToBeClickable(banter_prod)).click();
				
			}
			
}
