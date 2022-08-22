package com.demo.exercises;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.MutableCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import static com.demo.Config.region;

public class ex1_CreateAndroidDriver {

    private String SAUCE_EU_URL = "https://ondemand.eu-central-1.saucelabs.com/wd/hub";
    private String SAUCE_US_URL = "https://ondemand.us-west-1.saucelabs.com/wd/hub";

    // (1) define a driver
    private AndroidDriver driver;

    @BeforeMethod
    public void setup(Method method) throws MalformedURLException {

        String methodName = method.getName();
        System.out.println("*** BeforeMethod hook. Running method " + methodName + " ***");
        URL url;

        switch (region) {
            case "us":
                System.out.println("region is us");
                url = new URL(SAUCE_US_URL);
                break;
            case "eu":
            default:
                System.out.println("region is eu");
                url = new URL(SAUCE_EU_URL);
                break;
        }

        // (2) create the needed capabilities
        MutableCapabilities capabilities = new MutableCapabilities();
        MutableCapabilities sauceOptions = new MutableCapabilities();

        // Capabilities: platformName , automationName, appium:deviceName , appium:platformVersion
        // Values: Samsung.* , UiAutomator2, 12, android

        capabilities.setCapability("platformName","android");
        capabilities.setCapability("appium:deviceName","samsung.*");
        capabilities.setCapability("appium:app",
               "https://github.com/saucelabs/sample-app-mobile/releases/download/2.7.1/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        capabilities.setCapability("appium:appWaitActivity","com.swaglabsmobileapp.MainActivity");
        capabilities.setCapability("appium:automationName","UiAutomator2");

        // Sauce capabilities
        sauceOptions.setCapability("name", methodName);
        sauceOptions.setCapability("username", System.getenv("SAUCE_USERNAME"));
        sauceOptions.setCapability("accessKey", System.getenv("SAUCE_ACCESS_KEY"));
        capabilities.setCapability("sauce:options", sauceOptions);

        driver = new AndroidDriver(url, capabilities);

    }

    @Test
    public void ex1_CreateAndroidDriver() {
        System.out.println("*** Start demoTest test ***");
    }

    @AfterMethod
    public void teardown(ITestResult result) {
        System.out.println("*** AfterMethod hook ***");

        // (3) quit the driver
        driver.quit();
    }

    // (4) in resources -> config -> myDemoTests.xml point to this class
    // <class name="com.demo.exercises.ex1_CreateAndroidDriver"></class>

    // (5) In the terminal run the cmd : "mvn clean test"

}
