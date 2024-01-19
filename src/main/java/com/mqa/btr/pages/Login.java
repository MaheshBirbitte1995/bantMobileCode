package com.mqa.btr.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mqa.btr.base.BaseTest;

public class Login extends BaseTest {

	
	//Page Factory - OR:
			@FindBy(xpath ="//input[@id='username']")
			WebElement username;
			
			
			@FindBy(xpath ="//input[@id='password']")
			WebElement password;
			
			@FindBy(xpath ="//*[contains(text(),' Login ')]")
			WebElement login_btn;
			
			@FindBy(xpath ="//*[@class='md button in-toolbar ion-activatable ion-focusable hydrated']")
			WebElement Menu_icon;
			
			
			@FindBy(xpath ="//ion-title[text()=' Inbox ']")
			public WebElement Inbox_header_label;
			//Initializing the Page Objects:
			public Login(){
				PageFactory.initElements(driver, this);
			}
			
			public void dologin(String Uname,String Pwd) {
				username.sendKeys(Uname);
				password.sendKeys(Pwd);
				login_btn.click();
				String xpath="(//ion-label//span[1])[1]";  // //ion-title[text()=' Inbox ']
				Explicitwait(xpath);
			//	Fluentwait(driver, xpath);
					
			}
			
		/*	public void WaitForwebElement() {
				WebDriverWait wait = new WebDriverWait(driver, 100);
				WebElement element = wait.until(
				        ExpectedConditions.visibilityOfElementLocated(By.xpath("//ion-title[text()=' Inbox ']")));
			}
			*/
						
}
