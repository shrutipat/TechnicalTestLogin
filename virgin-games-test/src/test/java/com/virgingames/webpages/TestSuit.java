package com.virgingames.webpages;

import com.virgingames.pagefactory.HomePage;
import com.virgingames.pagefactory.LoginPage;
import com.virgingames.resources.testdata.TestData;
import com.virgingames.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Archita Patel
 */
public class TestSuit extends TestBase{

    @Test
    public void verify_That_User_Is_Navigated_To_Login_Page_Successfully(){
        new HomePage().clickOnLoginLink();
        Assert.assertTrue(new LoginPage().verifyThatUserIsOnLoginPage());
    }

    @Test(dataProvider="inputs", dataProviderClass= TestData.class)
    public void verify_That_User_Login_Fails_With_Invalid_Credentials(String username, String password){
        new HomePage().clickOnLoginLink();
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.verifyThatErrorMessageIsDisplayed());
    }
}
