package com.cybertek.tests.day8_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        driver.manage().window().maximize();

        WebElement userNameInput = driver.findElement(By.name("username"));

        //we checked the "username" which is part of html but it is not on the screen
        // so, in order to .isDisplayed method we use, and result is false, Because the element is not part of the screen
        System.out.println("userNameInput.isDisplayed() = " + userNameInput.isDisplayed()); //boolean result

        //TASK
        //verify username input is not display on the screen

        Assert.assertFalse(userNameInput.isDisplayed(),"verify inputbox is NOT displayed");

        //click start button
        //find start button and click in one line
        driver.findElement(By.cssSelector("#start>button")).click();

        // to wait the element displayed we wrote the Thread time;
        // (otherwise While the page was opening , due to time it  gave fail)
        Thread.sleep(6000); //wait until elements displayed on the screen

        //verify username displayed on the screen
        Assert.assertTrue(userNameInput.isDisplayed(),"verify username inputbox is displayed");


        Thread.sleep(3000);
        driver.quit();

    }


}
