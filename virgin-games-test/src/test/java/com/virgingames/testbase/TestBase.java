package com.virgingames.testbase;

import com.virgingames.basepage.BasePage;
import com.virgingames.browserselector.BrowserSelector;
import com.virgingames.properties.LoadProperty;
import com.virgingames.util.Util;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by Archita Patel
 */
public class TestBase extends BasePage {

    BrowserSelector browserSelector = new BrowserSelector();
    LoadProperty loadProperty = new LoadProperty();
    String browser = loadProperty.getProperty("browser");
    String baseUrl = loadProperty.getProperty("baseUrl");
    String time = loadProperty.getProperty("time");

    @BeforeClass
    public static void setUpBeforeClass() {
        PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\java\\com\\virgingames\\resources\\configfiles\\log4j.properties");
    }

    @BeforeMethod
    public void setUp() {
        browserSelector.selectBrowser(browser);
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.valueOf(time), TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }

    @AfterMethod
    public void tearDown(ITestResult testResult) {
        new Util().takeScreenShot(testResult.getName());
        driver.quit();
    }
}
