package com.virgingames.basepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Archita Patel
 */
public class BasePage {

    public static WebDriver driver;
    public BasePage(){
        PageFactory.initElements(driver, this);
    }
}
