package CheapTicketApp;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Cheap_Test {

	@SuppressWarnings({ "rawtypes" })
	AndroidDriver dvr;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test

	public void testAppium() throws MalformedURLException, InterruptedException {
		DesiredCapabilities capability = new DesiredCapabilities();

		capability.setCapability("deviceName", "Coolpad 3600l");
		capability.setCapability("deviceVersion", "6.0.1");
		capability.setCapability("devicePlatForm", "Android");

		File file = new File("C:\\Users\\Akram\\eclipse-workspace\\Appium\\apk\\cheapticket_appV2.8.apk");

		capability.setCapability("app",file.getAbsolutePath());
		dvr = new AndroidDriver(new URL("http://192.168.1.8:4723/wd/hub"), capability);
		//dvr = new AndroidDriver(new URL("http://192.168.0.102:4723/wd/hub"), capability);                                                                                  
		dvr.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		Thread.sleep(6000);

		// click search flight
		dvr.findElementByXPath("//android.widget.Button[@text='Search' and @index ='1']").click();
		//WebElement element=dvr.findElementById("com.cheapticket:id/searchBtn");
		//element.clear();
		
		// Select Flight
		Thread.sleep(12000);
		dvr.findElementByXPath("//android.widget.RelativeLayout[@index ='0']").click();
		Thread.sleep(9000);
		
		//  http://www.software-testing-tutorials-automation.com/2015/10/ui-automator-viewer-get-android-app.html
			
		// Continue Booking
		dvr.findElementById("com.cheapticket:id/continueBtn").click();
		Thread.sleep(1000);
		
		// Contact Details, email & password
		dvr.findElementById("com.cheapticket:id/edit_txt_emailId").sendKeys("akram@yopmail.com");
		dvr.findElementById("com.cheapticket:id/edit_txt_mobile").sendKeys("123456");
		
		// Submit contact details
		dvr.findElementById("com.cheapticket:id/btn_continue").click();
		
		// Continue Booking
		dvr.findElementById("com.cheapticket:id/continueBtn").click();
		Thread.sleep(2000);

		//Adults Details:
		// First Name
		dvr.findElementById("com.cheapticket:id/first_name").sendKeys("Akram");
		
		// Last Name
		dvr.findElementById("com.cheapticket:id/last_name").sendKeys("Khan");
		
		// Submit 
		dvr.findElementById("com.cheapticket:id/save_btn").click();
		Thread.sleep(8000);


	/*	List<WebElement> results = dvr.findElementsByClassName("android.widget.TextView");
		for (int i = 0; i < results.size(); i++) {
			CharSequence searchTerm = null;
			Assert.assertEquals(results.get(i).getText().contains(searchTerm), "Search result validation failed at instance [ + i + ].");
		}*/

		/*

		List<WebElement> button = dvr.findElementsByClassName("android.widget.TextView");
		System.out.println("Total Flights  On The Screen :" +button.size());
		for(int i=1; i<button.size(); i++) {
			System.out.println(button.get(i).getAttribute("text"));}

			List<WebElement> results = dvr.findElementsByClassName("android.widget.TextView");
    for (int i = 0; i < results.size(); i++) {
        Assert.assertTrue(results.get(i).getText().contains(searchTerm), "Search result validation failed at instance [ + i + ].");
    }
}




		 *//*
		Thread.sleep(9000);
		WebElement msg=(WebElement) dvr.findElementsByClassName("android.widget.TextView");
		String text=msg.getText();
		String[] expectedText = { "ONEWAY","ROUND TRIP","From:","To:","Depart On:","Adults","1","Children","0","Infants","0","Class","Economy"};
		Assert.assertEquals(text,expectedText);



// Assert.assertEqual(Actual message, Expected Message);   Assert.assertTrue(Expected Message.isDisplayed);

		//public void swipe()
		Thread.sleep(8000);
		System.out.println(dvr.manage().window().getSize().getWidth());
		System.out.println(dvr.manage().window().getSize().getHeight());
		int screenWidth = dvr.manage().window().getSize().getWidth();
		int screenHeight= dvr.manage().window().getSize().getHeight();

		//swipe Right
		int startx = screenWidth*6/7;
		int endx = screenWidth/7;
		int starty = screenHeight/2;  
		int endy =  screenHeight/2;
		new TouchAction(dvr).press(startx, starty).waitAction().moveTo(endx, endy).release().perform();

		// swipe Left
		Thread.sleep(5000);
		startx = screenWidth/7;
		endx = screenWidth*6/7;
		starty = screenHeight/2;  
		endy =  screenHeight/2;
		new TouchAction(dvr).press(startx, starty).waitAction().moveTo(endx, endy).release().perform();
// swipe Down
		Thread.sleep(5000);
		dvr.findElementById("com.cheapticket:id/searchBtn").click();
		Thread.sleep(10000);
		startx = screenWidth/2;
		endx = screenWidth/2;
		starty = screenHeight*6/7;  
		endy =  screenHeight/7;

		for(int i=1; i<4; i++) {
			for(int j=1; j<=i; j++) {
				Thread.sleep(3000);
				new TouchAction(dvr).press(startx, starty).waitAction().moveTo(endx, endy).release().perform();
			}
		}
		Thread.sleep(2000);
		List <WebElement> btn= dvr.findElementsById("com.cheapticket:id/flightPrice");

		System.out.println("Total Flights: " +btn.size());
		for(int i=0; i<btn.size(); i++){
			System.out.println(btn.get(i).getText());
		}



		  */


		/*
		List<WebElement> button = dvr.findElementsByClassName("android.widget.TextView");
		System.out.println("Total Flights  On The Screen :" +button.size());
		for(int i=1; i<button.size(); i++) {
			System.out.println(button.get(i).getAttribute("text"));
		}
		Thread.sleep(6000);
		 */
		// OneWay  ...........................................................................................................................

		// Search Flight:
		//	dvr.findElementById("com.cheapticket:id/searchBtn").click();
		//	Thread.sleep(15000);

		//((WebElement) dvr.findElementsByClassName("android.widget.TextView")).getText();
		/*
		List<WebElement> button2 = dvr.findElementsByClassName("android.widget.TextView");
		System.out.println("Total Flights  On The Screen :" +button2.size());
		for(int i=1; i<button2.size(); i++) {
			System.out.println(button2.get(i).getAttribute("text"));
		}
		Thread.sleep(4000);

		System.out.println(dvr.manage().window().getSize().getWidth());
		System.out.println(dvr.manage().window().getSize().getHeight());
		int screenWidth = dvr.manage().window().getSize().getWidth();
		int screenHeight= dvr.manage().window().getSize().getHeight();

		//swipe Down
		int startx = screenWidth/2;
		int endx = screenWidth/2;
		int starty = screenHeight*4/6;  
		int endy =  screenHeight/6;


		for(int i=1; i<4; i++) {
			for(int j=1; j<=i; j++) {
				new TouchAction(dvr).press(startx, starty).waitAction().moveTo(endx, endy).release().perform();


				List<WebElement> button1 = dvr.findElementsByClassName("android.widget.TextView");
				System.out.println("Total Flights  On The Screen ............................. :" +button1.size());
				for(int l=1; i<button1.size(); l++) {
					System.out.println(button1.get(1).getAttribute("text"));
				}

			}

		}

		Thread.sleep(6000);
		startx = screenWidth/2;
		endx = screenWidth/2;
		starty = screenHeight*4/6;  
		endy =  screenHeight/6;
		new TouchAction(dvr).press(startx, starty).waitAction().moveTo(endx, endy).release().perform();

		for(int i=1; i<4; i++) {
			for(int j=1; j<=i; j++) {


			}
		}

		List<WebElement> button1 = dvr.findElementsByClassName("android.widget.TextView");
		System.out.println("Total Flights  On The Screen :" +button1.size());

		for(int m=1; m<button1.size(); m++) {
			System.out.println(button1.get(1).getAttribute("text"));
		}

		 */


	}
}


















