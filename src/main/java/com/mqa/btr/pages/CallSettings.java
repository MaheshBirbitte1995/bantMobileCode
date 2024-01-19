package com.mqa.btr.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mqa.btr.base.BaseTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.github.sukgu.support.ElementFieldDecorator;

public class CallSettings extends BaseTest {

	@FindBy(xpath ="//*[@class='md button in-toolbar ion-activatable ion-focusable hydrated']")
	public WebElement Menu_icon;
	
	@FindBy(xpath ="(//*[contains(text(),' Inbox ')])[1]")
	public WebElement Inbox_link;
	
	@FindBy(xpath ="//ion-label[text()=' Call Settings ']")
	public WebElement callStn_link;
	@FindBy(xpath ="//ion-title[text()=' Call Settings ']")
	public WebElement callStn_header_label;
	
	
	@FindBy(xpath ="//div[@class='grid-view']//div[@class='card-content']//h5")
	List<WebElement> call_Stns_list;
	
	@FindBy(xpath ="//div[@class='grid-view']//div[@class='card-content']/h5[contains(text(),'Ring My Phone')]")
	public WebElement Ring_my_phn;
	
	@FindBy(xpath ="//div[@class='grid-view']//div[@class='card-content']/h5[contains(text(),'Call Forward')]")
	public WebElement call_frwd;
	
	@FindBy(xpath ="//div[@class='grid-view']//div[@class='card-content']/h5[contains(text(),'Go To Voicemail')]")
	public WebElement go_to_voicemail;
	@FindBy(xpath ="//select[@id='play_greeting']")
	public WebElement voicemail_or_plygrtn_grtn_select;  
	
	@FindBy(xpath ="//div[@class='grid-view']//div[@class='card-content']/h5[contains(text(),'Go To Menu/IVR')]")
	public WebElement menu_ivr;
	@FindBy(xpath ="//select[@id='menu_list']")
	public WebElement menu_grtn_select;
	
	
	@FindBy(xpath ="//div[@class='grid-view']//div[@class='card-content']/h5[contains(text(),'DND/Disconnect')]")
	public WebElement dnddisconnect;
	
	@FindBy(xpath ="//div[@class='grid-view']//div[@class='card-content']/h5[contains(text(),'Play Greeting')]")
	public WebElement ply_grtn;
	
	@FindBy(xpath ="//div[@class='grid-view']//div[@class='card-content']/h5[contains(text(),'Schedule')]")
	public WebElement schedule;
	
	@FindBy(xpath ="(//ion-select)[2]")
	public WebElement click_on_sc_dropdwn;
	
	
	@FindBy(xpath ="//div[text()=\"Do Not Disturb \"]")
	public WebElement select_DND;
	
	@FindBy(xpath ="//div[@class='alert-wrapper ion-overlay-wrapper sc-ion-alert-md']//button[3]")
	public WebElement click_on_sc_name;
	
	
	@FindBy(xpath ="//div[@class='alert-wrapper ion-overlay-wrapper sc-ion-alert-md']//button//span[text()=\"OK\"]")
	public WebElement click_on_Ok_btn;

	@FindBy(xpath ="(//div[@class='alert-wrapper ion-overlay-wrapper sc-ion-alert-md']//button[1])[1]")
	public WebElement select_sc_name;
	

	@FindBy(xpath ="//div[@class='col-10']//ion-select")
	public WebElement click_on_scname;
	
	@FindBy(xpath ="(//div[@class='ion-padding']//ion-select)[1]")   
	public WebElement select_schedule_dropdown;
	
	@FindBy(xpath ="(//div[@class='ion-padding']//ion-select)[2]")
	public WebElement select_schedule_optn;
	
	@FindBy(xpath ="//div[@class='grid-view']//div[@class='card-content']/h5[contains(text(),'Call Queue')]")
	public WebElement call_queue;
	

	@FindBy(xpath ="//div[@class='grid-view']//div[@class='card-content']/h5[contains(text(),'Custom Call Setting')]")
	public WebElement cust_Call_Stn;
	
	@FindBy(xpath ="//div[@class='form-group']//button")
	public WebElement cust_Call_Stn_cancel_btn;  
	
	
	//div[@id='grid-view-container-1672919214073']//div[@class='card-content']/span/i[contains(@class,'true')] static
	
	@FindBy(xpath ="//div[contains(@id,'grid-view-container')]//div[@class='card-content']/span/i[contains(@class,'true')]")
	public WebElement check_mark;
	
	
	@FindBy(xpath ="//div[@class=\"form-group mt-3\"]//button[text()='Save']")
	public WebElement Save_btn;  //Save btn for Ringmy_phne,CallFrwrd,Scheudles,call queue
	
	
	@FindBy(xpath ="//div//ion-button[text()=\"Save \"]")
	public WebElement Save_btn_schdule;  //Save btn for Scheudles
	
	
	@FindBy(xpath ="(//div[@class='form-group'])[2]//button[1]")
	public WebElement savebtn;  //voicemail/IVR/PlayGreeting
	
	@FindBy(xpath ="//div[@class='form-group']//button[1]")
	public WebElement dnd_save_btn;  //DND Save btn
	
	//div[@class='ion-padding']//ion-segment-button//ion-label[text()='Call forward']
	//div[@class='ion-padding']/ion-segment/ion-segment-button[2]/ion-label[text()='Call forward']
	@FindBy(xpath ="//div[@class='ion-padding']/ion-segment/ion-segment-button[2]/ion-label[text()='Call forward']") 
	public WebElement ring_my_phn_call_frwd;
	
	@FindBy(xpath ="//ion-item-group//input")
	public WebElement ring_my_phn_call_frwd_entr_num;
	
	@FindBy(xpath ="//div[@class='ion-padding-top']//ion-input//input")
	public WebElement call_frwd_entr_num;
	
	@FindBy(xpath ="//div[@class='ion-padding-top']//ion-input//input")
	public WebElement select_extn;
	
	
	
	//Initializing the Page Objects:
	public CallSettings(){
PageFactory.initElements(driver, this);
		 /*this.driver = (AndroidDriver<AndroidElement>) driver;
	    	ElementFieldDecorator decorator = new ElementFieldDecorator(new DefaultElementLocatorFactory(driver));
	    	// need to use decorator if you want to use @FindElementBy in your PageFactory model.
	    	PageFactory.initElements(decorator, this);	
	*/
	}

	public void Save() {
		Save_btn.click();
	}
	public void select_Ringmyphn() throws InterruptedException {
		Ring_my_phn.click();
		Thread.sleep(4000);
		Save_btn.click();
		Thread.sleep(12000);
		//call_settings.WaitForwebElement(call_settings.check_mark.toString());
		
	}
	public void select_Ringmyphn_callFarwrd(String callFrwd_num) throws InterruptedException {
		Ring_my_phn.click();
		Thread.sleep(12000);
		ring_my_phn_call_frwd.click();
		Thread.sleep(5000);
		ring_my_phn_call_frwd_entr_num.clear();
		Thread.sleep(1000);
		ring_my_phn_call_frwd_entr_num.sendKeys(callFrwd_num);	
		Thread.sleep(5000);
		Save_btn.click();
	}
	
	public void select_CallFarwrd(String callFrwd_num) throws InterruptedException {
		call_frwd.click();
		Thread.sleep(7000);
		call_frwd_entr_num.clear();
		Thread.sleep(1000);
		call_frwd_entr_num.sendKeys(callFrwd_num);	
		Thread.sleep(5000);
		Save_btn.click();
	}
	
	public void select_exten() throws InterruptedException {
		call_frwd.click();
		Thread.sleep(7000);
		Select extn=new Select(select_extn);
		extn.selectByIndex(1);
		Thread.sleep(3000);
		Save_btn.click(); //Save btn for Ringmy_phne,CallFrwrd,Scheudles,call queue
		Thread.sleep(5000);
	}
	
	public void selectvoicemail() throws InterruptedException {
		go_to_voicemail.click();
		Thread.sleep(5000);
		Select grt_voice=new Select(voicemail_or_plygrtn_grtn_select);
		Thread.sleep(4000);
		List<WebElement>  lst = grt_voice.getOptions();
        int i=1;
        for(WebElement options: lst) {
        	if(i==2) {
        	grt_voice.selectByVisibleText(options.getText()); 
        	i=0;
        	break;
        	}
        	i++;
        }
		Thread.sleep(2000);
		savebtn.click();  //voicemail/IVR/PlayGreeting
		Thread.sleep(7000);
		
	}
	
	public void selectMenuIVR() throws InterruptedException {
		menu_ivr.click();
		Thread.sleep(5000);
		Select menu_ivr=new Select(menu_grtn_select);
	//	grt_voice.selectByValue("1679895924050773");  //  toXUGMzAutomationShr
		List<WebElement>  lst = menu_ivr.getOptions();
        int i=1;
        for(WebElement options: lst) {
        	if(i==2) {
        		menu_ivr.selectByVisibleText(options.getText()); 
        	i=0;
        	break;
        	}
        	i++;
        }
        
        Thread.sleep(3000);
		savebtn.click();
		Thread.sleep(9000);
		
	}
	public void DndDisconnet() throws InterruptedException {
		dnddisconnect.click();
		Thread.sleep(3000);
		dnd_save_btn.click();
		Thread.sleep(5000);
	}
	
	public void selectplayGrtn() throws InterruptedException {
		ply_grtn.click();
		Thread.sleep(5000);
		Select grt_voice=new Select(voicemail_or_plygrtn_grtn_select);
	//	grt_voice.selectByValue("1680067547807292"); // Invalid Key Shared001 grtn
		List<WebElement>  lst = grt_voice.getOptions();
        int i=1;
        for(WebElement options: lst) {
        	if(i==2) {
        	grt_voice.selectByVisibleText(options.getText()); 
        	i=0;
        	break;
        	}
        	i++;
        }
		
		
		Thread.sleep(3000);
		savebtn.click();
		Thread.sleep(7000);
	}
	
	public void selectSchedules() throws InterruptedException {
		schedule.click();
		Thread.sleep(5000); // select_schedule_dropdown,select_schedule_optn
		//Select grt_voice=new Select(select_schedule_dropdown);
		//grt_voice.selectByIndex(1);
		// click_on_sc_dropdwn, select_DND
		
		// click_on_sc_name, select_sc_name, click_on_Ok_btn
		click_on_scname.click();
		Thread.sleep(3000);
		select_sc_name.click();
		Thread.sleep(3000);
		click_on_Ok_btn.click();
		click_on_sc_dropdwn.click();
		Thread.sleep(3000);
		select_DND.click();
		click_on_Ok_btn.click();
		
	//	ScrollIntoView(Save_btn_schdule);
		Save_btn_schdule.click();  //Save btn for Scheudles
		Thread.sleep(8000);
		ScrollIntoView(schedule);
		Thread.sleep(2000);
		
	}
	public static void scroll_to_bottom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Scroll down till the bottom of the page
	//	js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}
	
	public void select_CallQueue() {
		call_queue.click();
        //welcom music dropdown
		//wait music dropdown
		//choose num dropdown
		
	}

	public void custcallStn() throws InterruptedException {
		cust_Call_Stn.click();
		Thread.sleep(3000);
		cust_Call_Stn_cancel_btn.click();
		Thread.sleep(2000);
	}
	
	
	
	public void clickonCallStnLink() {
		callStn_link.click();
	}
    
	public String CallStnHeaderlabel() {
		return callStn_header_label.getText().trim();
	}

		public int CallStnListCount() {
			return call_Stns_list.size();
		}

		public boolean checkmarkdispalyed() {
			return check_mark.isDisplayed();
			
		}
		public void WaitForwebElement(String xpath) {
			WebDriverWait wait = new WebDriverWait(driver, 100);
			
			WebElement element = wait.until(
			        ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		}

			public void saveRing_My_Phone(String xpath) {
				Ring_my_phn.click();
				WaitForwebElement(xpath);

			}
}
