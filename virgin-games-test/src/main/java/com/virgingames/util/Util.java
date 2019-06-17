package com.virgingames.util;

import com.virgingames.basepage.BasePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

/**
 * Created by Archita Patel
 */
public class Util extends BasePage {

    //click on element
    public void clickOnElement(WebElement element) {
        element.click();
    }

    //send text to element
    public void sendTextToElement(WebElement element, String str) {
        element.clear();
        element.sendKeys(str);
    }

    //get text from element
    public String getTextFromElement(WebElement element) {
        return element.getText();
    }

    //verify that element is displayed
    public boolean verifyThatElementIsDisplayed(WebElement element) {
        if (element.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    //verify that text is displayed
    public boolean verifyThatTextIsDisplayed(WebElement element, String text) {
        if (text.equals(element.getText())) {
            return true;
        } else {
            return false;
        }
    }

    public static String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    public void takeScreenShot(String fileName) {
        String filePath = System.getProperty("user.dir")+"\\src\\main\\java\\com\\virgingames\\screenshots\\";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scr1, new File(filePath + fileName + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
