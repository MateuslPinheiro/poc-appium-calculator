package calculator;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Calc {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:appPackage", "com.google.android.calculator");
        desiredCapabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability("appium:platformVersion", "11.0");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
//        desiredCapabilities.setCapability("deviceName", "emulator-5554"); //dispositivo físico

        URL remoteUrl = new URL("http://0.0.0.0:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void somaDoisNumeros() {
        MobileElement botao2 = (MobileElement) driver.findElementByAccessibilityId("2");
        botao2.click();
        MobileElement botaoSomar = (MobileElement) driver.findElementByAccessibilityId("plus");
        botaoSomar.click();
        MobileElement botao3 = (MobileElement) driver.findElementByAccessibilityId("3");
        botao3.click();
        MobileElement botaoIgual = (MobileElement) driver.findElementByAccessibilityId("equals");
        botaoIgual.click();
        MobileElement display = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
        Assert.assertEquals(5,Integer.parseInt(display.getText()));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

