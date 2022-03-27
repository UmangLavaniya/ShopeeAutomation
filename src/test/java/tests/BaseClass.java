package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BasePage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseClass {
AppiumDriver driver;
DesiredCapabilities capabilities;
BasePage basePage;
// Can be stored in properties file
String appiumDriverURL="http://127.0.0.1:4723/wd/hub";

    @BeforeTest
    public void setUp()
    {
        try {
            capabilities=new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"ANDROID");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11 RKQ1.201112.002");
            capabilities.setCapability(MobileCapabilityType.UDID,"1b9bad86");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Mi 11X Pro");
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,360);
            capabilities.setCapability("appPackage","com.shopee.in");
            capabilities.setCapability("appActivity","com.shopee.app.ui.home.HomeActivity_");
            capabilities.setCapability("automationName","UiAutomator2");
            URL url=new URL(appiumDriverURL);
            driver=new AppiumDriver(url,capabilities);
            basePage=new BasePage(driver);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    @AfterTest
    public void tearDown()
    {
        System.out.println("Completed");
    }

    @Test
    public void test()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        basePage.homePage();
        basePage.selectAnItemFromCategory();
        basePage.addToCart();
        basePage.login();
        basePage.addToCart();
        basePage.clickOnBuyNow();
        basePage.confirmBuyNow();
        basePage.clickOnCheckOut();
    }


}
