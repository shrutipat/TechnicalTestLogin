package com.virgingames.pagefactory;

import com.virgingames.util.Util;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Archita Patel
 */
public class LoginPage extends Util {

    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());

    @FindBy(id = "field-username")
    WebElement _username;

    @FindBy(id = "field-password")
    WebElement _password;

    @FindBy(xpath = "//button[@class = 'button button-login']")
    WebElement _loginButton;

    @FindBy(xpath = "//div[@class = 'output']")
    WebElement _errorMessage;

    //verify that user is on dashboard page
    public boolean verifyThatUserIsOnLoginPage() {
        log.info("verify that user is on Login page");
        if (driver.getCurrentUrl().contains("quick-login")) {
            return true;
        } else {
            return false;
        }
    }

    //enter username
    public void enterUsername(String str) {
        log.info("enter user name");
        sendTextToElement(_username, str);
    }

    //enter password
    public void enterPassword(String pwd) {
        log.info("enter password");
        sendTextToElement(_password, pwd);
    }

    //click on login button
    public void clickLoginButton() {
        log.info("click on login button");
        clickOnElement(_loginButton);
    }

    //verify that error message is displayed
    public boolean verifyThatErrorMessageIsDisplayed() {
        log.info("verify that error message is displayed");
        if (verifyThatElementIsDisplayed(_errorMessage)) {
            return true;
        } else {
            return false;
        }
    }
}
