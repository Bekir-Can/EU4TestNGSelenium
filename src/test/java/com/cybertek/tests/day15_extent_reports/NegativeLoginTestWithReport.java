package com.cybertek.tests.day15_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {

    @Test
    public void wrongPasswordTest() {
        //name of the test
        extentLogger = report.createTest("Wrong Password Test");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter Username: user1");
        loginPage.usernameInput.sendKeys("user1");

        extentLogger.info("Enter Password: somepassword");
        loginPage.passwordInput.sendKeys("somepassword");

        extentLogger.info("Click login Button");
        loginPage.loginBtn.click();

        extentLogger.info("Verify Page URL"); // here is important
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login");

        extentLogger.pass("Wrong Password Test is Passed");// here is important, we put this syntax for to see everything went
        // well in Test, it gives fail it will not execute this

    }

    @Test
    public void wrongUsernameTest() {
        //name of the test
        extentLogger = report.createTest("Wrong Username Test");

        LoginPage loginPage = new LoginPage();
        extentLogger.info("Enter username: someusername");
        loginPage.usernameInput.sendKeys("someusername");

        extentLogger.info("Enter password: UserUser123");
        loginPage.passwordInput.sendKeys("UserUser123");

        extentLogger.info("Click Login button");
        loginPage.loginBtn.click();

        extentLogger.info("verify page url");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/loginQWE");
        //we intentionaly added(QWE) change the expected result to give fail
        extentLogger.pass("PASSED");// here is important, we put this syntax for to see everything went
        // well in Test, it gives fail it will not execute this
    }


}