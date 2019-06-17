package com.virgingames.pagefactory;

import com.virgingames.util.Util;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Archita Patel
 */

public class HomePage extends Util {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    @FindBy(xpath = "//a[contains(text(), 'Login')]")
    WebElement _loginLink;

    public void clickOnLoginLink() {
        clickOnElement(_loginLink);
        log.info("user clicks on Login Link");
    }
}
