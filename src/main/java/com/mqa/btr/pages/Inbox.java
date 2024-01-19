package com.mqa.btr.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mqa.btr.base.BaseTest;

import net.bytebuddy.utility.RandomString;

public class Inbox extends BaseTest {

	@FindBy(xpath ="//*[@class='md button in-toolbar ion-activatable ion-focusable hydrated']")
	WebElement Menu_icon;
	
	@FindBy(xpath ="(//*[contains(text(),' Inbox ')])[1]")
	WebElement Inbox_link;
	
	@FindBy(xpath ="//div[@id='new-button']//ion-button[text()=' New ']")
	WebElement New_btn;
	
	@FindBy(xpath ="//*[@id='1654690129414item']//*[text()='New Message']")
	WebElement selct_New_msg_popup;
	
	@FindBy(xpath ="//div[@class='searchbar-input-container sc-ion-searchbar-md']//input")
	WebElement to_num_field;
	
	@FindBy(xpath ="//div[contains(@id,'message')]")
	WebElement text_area;
	
	@FindBy(xpath ="//ion-label[text()='Send']")
	public WebElement send_btn;
	
	
	@FindBy(xpath ="//div[@class='num-dropdown']//*[@class='sc-ion-label-md-h sc-ion-label-md-s md hydrated']")
	WebElement controler_num;
	
	
	@FindBy(xpath ="//div[@class='searchbar-input-container sc-ion-searchbar-ios']//input")
	WebElement enter_controler_num;
	
	@FindBy(xpath ="(//*[@class='popover-viewport']//*[@class='sc-ion-label-md-h sc-ion-label-md-s md hydrated'])[5]")
	WebElement select_num_in_controler_popup;
	
	@FindBy(xpath ="(//div[@class='text-m'])[last()]")  
	public WebElement actual_sent_msg;
	
	
	@FindBy(xpath ="//ion-buttons//ion-menu-button")
	public WebElement bck_btn;
	
	@FindBy(xpath ="(//ion-buttons[@id='header-strip']//ion-badge)[2]")
	public WebElement activity_notify;

    @FindBy(xpath ="//app-activity[@class='popover-viewport']//h3")
	public WebElement activity_notify_num_tap;
	
  
    @FindBy(xpath ="//ion-label//h2")
	public WebElement select_num_tab;
  
    @FindBy(xpath ="//ion-button//ion-icon[@name='notifications-outline']")
  	public WebElement tap_on_Actvity;
  
    @FindBy(xpath ="//ion-label[@class='sc-ion-label-md-h sc-ion-label-md-s md hydrated']//h3")
  	public WebElement tap_on_num_frm_Actvity;  
    
    @FindBy(xpath ="//div/div/ion-list/ion-item/ion-label/span")
  	public WebElement receiver_num_in_datalist;  

    @FindBy(xpath ="//div/div/ion-list/ion-item/ion-label/p")
  	public WebElement receiver_msg_in_datalist;  
    
    @FindBy(xpath ="//h2[text()=\"(469) 225-9492\"]")
  	public WebElement header_to_num;  
    @FindBy(xpath ="(//div[@class=\"message-box m-out\"]//div[@class=\"text-m\"])[last()]")
  	public WebElement to_num_last_msg_inchat_convr;  
    
    public static String expected_msg=null;
	//Initializing the Page Objects:
	public Inbox(){
		PageFactory.initElements(driver, this);
	}
	
	public void Clickon_Menu_Icon() throws InterruptedException {
		Thread.sleep(5000);
		Menu_icon.click();
		Thread.sleep(5000);
		
	}
	public void select_Inbox_menu_link(){
		Inbox_link.click();
        }

	
	
	public void Sendmessage(String to_num) throws InterruptedException {
	
		New_btn.click();
		Thread.sleep(5000);
		selct_New_msg_popup.click();
		DateFormat formatter = new SimpleDateFormat("MMMdd_yy");
		String Today_date_Images = formatter.format(new Date());
		expected_msg="Sending Automation message (Act-To-Act) " + RandomString.make() + " from M-portal on "+Today_date_Images;
		to_num_field.sendKeys(to_num);
		Thread.sleep(4000);
		select_num_tab.click();
		text_area.sendKeys(expected_msg);
		Thread.sleep(4000);
		
		//send_btn.click();
		WebElement send_btn1=driver.findElement(By.xpath("//ion-label[text()='Send']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", send_btn1);
		
		Thread.sleep(20000);
		
	}
	
	public void selectnum_in_controller(String controler_number) throws InterruptedException {
		//controler_num,enter_controler_num,select_num_in_controler_popup
		controler_num.click();
		Thread.sleep(4000);
		enter_controler_num.sendKeys(controler_number);
		Thread.sleep(3000);
		select_num_in_controler_popup.click();
	
	}
	
	public void WaitForwebElement(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement element = wait.until(
		       ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			//	 ExpectedConditions.
	}
	
	public void WaitFor_backBtn_click() {   // (//ion-icon[@class='md hydrated'])[6]
		
		driver.findElement(By.xpath("//*[@class='ion-color ion-color-white md button button-clear in-toolbar button-has-icon-only ion-activatable ion-focusable hydrated']")).click();
		/*WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement element = wait.until(
		        ExpectedConditions.elementToBeClickable(By.xpath("(//ion-icon[@class='md hydrated'])[6]")));
		element.click();*/
		
		/*WebElement root1 = driver.findElement(By.xpath("(//ion-icon[@class='md hydrated'])[6]"));
	        WebElement shadow_root1 = expand_shadow_element(root1);
	        //System.out.println(shadow_root);
	        shadow_root1.findElement(By.xpath("//div//*[local-name() ='svg']/path")).click();
	      */

		
		
	}
	
	public static WebElement expand_shadow_element(WebElement element)
    {
        WebElement shadow_root = (WebElement)((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", element);
        return shadow_root;
    }
	
	
	
	public void VerifyActivity_notification() throws InterruptedException {
	    /*if(bck_btn.isDisplayed()) {
	    	WaitForbckclick();
	    	bck_btn.click();
	    	System.out.println("bck_btn is displayed..!!");
	    	
	    }else {
	    	System.out.println("bck_btn is NOT displayed..!!");
	    }*/
		Thread.sleep(3000);
		activity_notify.click();
		Thread.sleep(5000);
		activity_notify_num_tap.click();
		
		
	}

	public void click_on_Activity() throws InterruptedException {
		// TODO Auto-generated method stub
		activity_notify.click();
		Thread.sleep(5000);
		tap_on_num_frm_Actvity.click();
		Thread.sleep(9000);
	}

	public String Verifymsg_at_receiverside() {
		// TODO Auto-generated method stub
		String receiver_num=receiver_num_in_datalist.getText().replaceAll("[^a-zA-Z0-9]", "");
		String received_msg=receiver_msg_in_datalist.getText();
		
		return receiver_num+"_"+received_msg;
	
	}
}
