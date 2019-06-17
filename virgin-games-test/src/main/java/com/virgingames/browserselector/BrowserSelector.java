package com.virgingames.browserselector;

import com.virgingames.basepage.BasePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by Archita Patel
 */
public class BrowserSelector extends BasePage {

    public void selectBrowser(String browser) {
        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\java\\com\\virgingames\\resources\\drivers\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-popup-blocking");
            options.addArguments("disable-infobars");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-browser-side-navigation");
            options.addArguments("--disable-blink-features-BlockCredentials");
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\java\\com\\virgingames\\resources\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\test\\java\\com\\virgingames\\resources\\drivers\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        } else {
            System.out.println("Wrong Browser Selected");
        }
    driver.manage().deleteAllCookies();
    }
}
