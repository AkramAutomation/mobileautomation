package GenieTalk;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class genieTest{

	@SuppressWarnings({ "rawtypes" })
	AndroidDriver dvr;

	@SuppressWarnings("rawtypes")
	@Test
	public void testAppium() throws InterruptedException, IOException {


		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("deviceName", "Coolpad 3600l");
		capability.setCapability("deviceVersion", "6.0.1");
		capability.setCapability("devicePlatForm", "Android");
		//capability.setCapability("noReset","true");
		//capability.setCapability("fullReset","false");

		File file = new File("C:\\Users\\Akram\\eclipse-workspace\\Appium\\apk\\GenieTalk.apk");
		capability.setCapability("app",file.getAbsolutePath());
		dvr = new AndroidDriver(new URL("http://192.168.31.202:4723/wd/hub"), capability);                                                                              
		dvr.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		Thread.sleep(13000);

		// Let's get you started ...........
		dvr.findElementById("com.genietalk.app:id/btn_multibutton").click();

		// How many buttons on the page
		Thread.sleep(5000);
		@SuppressWarnings("unchecked")
		List<WebElement> button = dvr.findElementsByXPath("//android.widget.ImageButton[@index='1' and @NAF='true']");
		System.out.println("Buttons on the screen :"+button.size());
		for(int i=0; i<button.size(); i++)
		{
			System.out.println(button.get(i).getAttribute("text"));
		}

		//See Full Screen:  How many buttons on the page
		Thread.sleep(5000);
		@SuppressWarnings("unchecked")
		List<WebElement> button1 = dvr.findElementsById("com.genietalk.app:id/action_bar_root");
		System.out.println("Buttons on the screen :"+button1.size());
		for(int i=0; i<button1.size(); i++)
		{
			System.out.println(button.get(i).getAttribute("text"));
		}

		// Send your feedback 
		Thread.sleep(4000);
		dvr.findElementById("com.genietalk.app:id/fab").click();
		Thread.sleep(2000);

		// type your feedback here...........
		//Note: It should be Like: Type your feedback here...
		dvr.findElementById("com.genietalk.app:id/edt_bugreport").click();
		Thread.sleep(8000);

		// Total limits of input words should be show, as the user type words then total words should be less. 
		dvr.findElementById("com.genietalk.app:id/edt_bugreport").sendKeys("Test report");
		Thread.sleep(6000);

		// Send
		dvr.findElementById("com.genietalk.app:id/click2").click();
		Thread.sleep(4000);

		// After send  bug report, keyboard should be move..............
		dvr.findElementById("com.genietalk.app:id/fab").click();
		Thread.sleep(8000);

		try{
			// Find Height & Width
			System.out.println(dvr.manage().window().getSize().getWidth());
			System.out.println(dvr.manage().window().getSize().getHeight());
			int screenWidth = dvr.manage().window().getSize().getWidth();
			int screenHeight = dvr.manage().window().getSize().getHeight();

			//Swipe Down:
			int startx = screenWidth/2;
			int endx  =screenWidth/2;
			int starty =screenHeight*5/6;
			int endy = screenHeight/6;
			new TouchAction(dvr).press(startx, starty).waitAction().moveTo(endx, endy).release().perform();
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			// Get Screenshot
			File file1  = ((TakesScreenshot)dvr).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file1, new File("C:\\Users\\Akram\\Desktop\\screenshot\\test.png"));
			Thread.sleep(4000);
		}
	}

	@AfterTest
	public void afterTest()
	{
		dvr.quit();
	}
}