package Mobile;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * Android Browser Local Test.
 */
public class NewTest {

	@BeforeTest
	public void startServer() throws Exception {
		//while(true)
		//{
		try {
			Process process = Runtime.getRuntime().exec("adb devices");
			BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = null;

			Pattern pattern = Pattern.compile("^([a-zA-Z0-9\\-]+)(\\s+)(device)");
			Matcher matcher;

			while ((line = in.readLine()) != null) {
				if (line.matches(pattern.pattern())) {
					matcher = pattern.matcher(line);
					if (matcher.find())
						System.out.println(matcher.group(1));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");

	}

	@SuppressWarnings("rawtypes")
	static AndroidDriver dvr;
	public static AppiumDriver<MobileElement> mobiledriver;

	@Test
	public void LaunchApplication() throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability("automationName", "Appium");
		capabilities.setCapability("app", "C:\\Users\\akram.khan\\Desktop\\apk\\ebay.apk");
		mobiledriver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

	}

	@AfterTest
	public void stopServer() throws Exception {
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}

}
