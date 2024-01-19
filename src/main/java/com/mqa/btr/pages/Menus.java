package com.mqa.btr.pages;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mqa.btr.base.BaseTest;

public class Menus  extends BaseTest {

	public String random_menus_name=null;
	
	@FindBy(xpath ="//*[text()=' Menus ']")
	public WebElement Menu_link;
	
	@FindBy(xpath ="(//ion-buttons)[1]//ion-menu-button")
	public WebElement Prd_stn_Menu_link;
	
	@FindBy(xpath ="//ion-title[text()=' Menus ']")
	public WebElement menu_header_label;
	
	// Grtn add(+) btn
		 @FindBy(xpath ="//div[@class='col pl-0 pr-0']//ul//li[2]//ion-button//i")
		public WebElement menu_add_btn;
		 
		
		 @FindBy(xpath ="//div[@class='col pl-0 pr-0']//ul//li[1]//ion-button")
			public WebElement menu_refresh_btn;
		 
		 // grtn name
		@FindBy(xpath ="//div[@class='m-page']//input[@id='menu_name']")
		public  WebElement menu_name;
		
        @FindBy(xpath ="//select[@id=\"welcome_message\"]")
		public WebElement welcome_msg;
		
		@FindBy(xpath ="//select[@id=\"invalid_entry\"]")
		public WebElement invalid_entry;
		
		@FindBy(xpath ="//select[@id=\"no_key_pressed\"]")
		public WebElement no_key_pressed;
		
		@FindBy(xpath ="//div[@class=\"form-group\"]//button[text()='Save']")
		public WebElement save_btn;
		
		@FindBy(xpath ="(//div[@class=\"card-content\"]//h5)[1]")
		public WebElement created_menu_on_datalist;
		
	
		public String random_menu_name=null;

		@FindBy(xpath ="//*[text()=\" Menus \"]")
		public WebElement shredMenu_link;	
	
		//Initializing the Page Objects:
		public Menus(){
			PageFactory.initElements(driver, this);
		}
		
		
		public void CreateMenu() throws InterruptedException {
			Thread.sleep(5000);
			Menu_link.click();
			Thread.sleep(8000);
			ElementtobeClickable(menu_add_btn); //menu_add_btn.click();
			Thread.sleep(3000);
			random_menu_name=RandomStringUtils.randomAlphabetic(3, 7);
			menu_name.sendKeys("AppiumAutoMenu"+random_menu_name.trim());
			Thread.sleep(2000);
			Select wel_come_Drpdwn=new Select(welcome_msg);
			//wel_come_Drpdwn.selectByValue("1680242144711886"); // Shared Greeting 090
			List<WebElement>  lst = wel_come_Drpdwn.getOptions();
	        int i=1;
	        for(WebElement options: lst) {
	        	if(i==2) {
	        		wel_come_Drpdwn.selectByVisibleText(options.getText()); 
	        	i=0;
	        	lst=null;
	        	break;
	        	}
	        	i++;
	        }
			
			Thread.sleep(2000);
			Select invalid_entry_Drpdwn=new Select(invalid_entry);
		//	invalid_entry_Drpdwn.selectByValue("1680242144711886"); // Shared Greeting 090
			
			 lst = invalid_entry_Drpdwn.getOptions();
	        for(WebElement options: lst) {
	        	if(i==2) {
	        		invalid_entry_Drpdwn.selectByVisibleText(options.getText()); 
	        	i=0;
	        	lst=null;
	        	break;
	        	}
	        	i++;
	        }
			
			
			Thread.sleep(2000);
			Select no_key_pressed_Drpdwn=new Select(no_key_pressed);
			//no_key_pressed_Drpdwn.selectByValue("1680241877947478"); // Shared Greeting 090

			 lst = no_key_pressed_Drpdwn.getOptions();
	        for(WebElement options: lst) {
	        	if(i==2) {
	        		no_key_pressed_Drpdwn.selectByVisibleText(options.getText()); 
	        	i=0;
	        	lst=null;
	        	break;
	        	}
	        	i++;
	        }
			Thread.sleep(2000);
			save_btn.click();
			Thread.sleep(7000);
		}
		
		public void create_SharedMenu() throws InterruptedException {
			ScrollIntoView(shredMenu_link);
		    Thread.sleep(3000);
			shredMenu_link.click();
			Thread.sleep(9000);
            ElementtobeClickable(menu_add_btn); // menu_add_btn.click();
			Thread.sleep(3000);
			random_menu_name=RandomStringUtils.randomAlphabetic(2, 4);
			menu_name.sendKeys("ApimShrdMenu"+random_menu_name.trim());
			Thread.sleep(2000);
			Select wel_come_Drpdwn=new Select(welcome_msg);
			//wel_come_Drpdwn.selectByValue("1680499027800839"); // Shared Greeting 090
			List<WebElement>  lst = wel_come_Drpdwn.getOptions();
	        int i=1;
	        for(WebElement options: lst) {
	        	if(i==2) {
	        		wel_come_Drpdwn.selectByVisibleText(options.getText()); 
	        	i=0;
	        	lst=null;
	        	break;
	        	}
	        	i++;
	        }
			
			
			
			Thread.sleep(2000);
			Select invalid_entry_Drpdwn=new Select(invalid_entry);
			//invalid_entry_Drpdwn.selectByValue("1680499027800839"); // Shared Greeting 090
			
			lst = invalid_entry_Drpdwn.getOptions();
	        for(WebElement options: lst) {
	        	if(i==2) {
	        		invalid_entry_Drpdwn.selectByVisibleText(options.getText()); 
	        	i=0;
	        	lst=null;
	        	break;
	        	}
	        	i++;
	        }
			
			
			Thread.sleep(2000);
			Select no_key_pressed_Drpdwn=new Select(no_key_pressed);
			//no_key_pressed_Drpdwn.selectByValue("1680499078598409"); // Shared Greeting 090
			 lst = no_key_pressed_Drpdwn.getOptions();
		        for(WebElement options: lst) {
		        	if(i==2) {
		        		no_key_pressed_Drpdwn.selectByVisibleText(options.getText()); 
		        	i=0;
		        	lst=null;
		        	break;
		        	}
		        	i++;
		        }
			
			Thread.sleep(2000);
	        ScrollIntoView(save_btn);
			Thread.sleep(5000);
			save_btn.click();
			Thread.sleep(8000);
		}
				

}
