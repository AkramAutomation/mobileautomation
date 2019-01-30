package app;

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

public class AppLaunch{

	@SuppressWarnings({ "rawtypes" })
	AndroidDriver dvr;
	@SuppressWarnings({ "rawtypes" })
	@Test
	public void testAppium() throws MalformedURLException, InterruptedException {


		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("deviceName", "Coolpad 3600l");
		capability.setCapability("deviceVersion", "6.0.1");
		capability.setCapability("devicePlatForm", "Android");

		File file = new File("C:\\Users\\Akram\\eclipse-workspace\\Appium\\apk\\cheapticket_appV2.8.apk");
		capability.setCapability("app",file.getAbsolutePath());
		dvr = new AndroidDriver(new URL("http://192.168.1.8:4723/wd/hub"), capability);                                                                              
		dvr.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		Thread.sleep(9000);
		
		// Click Toggle
				dvr.findElementByClassName("android.widget.ImageButton").click();
		
				// Click Sign In Button
				dvr.findElementByXPath("//android.widget.CheckedTextView[@text='Sign In' and@index='0']").click();
				
				// Enter Email ID
				dvr.findElementById("com.cheapticket:id/emailIdEditText").clear();
				dvr.findElementById("com.cheapticket:id/emailIdEditText").sendKeys("akram@yopmail.com");
				
				// Enter Password
				Thread.sleep(1000);
				dvr.findElementById("com.cheapticket:id/passwordEditText").clear();
				Thread.sleep(1000);
				dvr.findElementByXPath("//android.widget.EditText[@index='1']").clear();
				Thread.sleep(1000);
				dvr.findElementByXPath("//android.widget.EditText[@index='1']").sendKeys("123456");
				
				// Click Sign In Button
				dvr.findElementById("com.cheapticket:id/signInButton").click();
				

		
	}

}

