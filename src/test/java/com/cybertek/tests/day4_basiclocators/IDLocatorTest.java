package com.cybertek.tests.day4_basiclocators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IDLocatorTest {

    public static void main(String[] args) throws InterruptedException {

        //open chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to http://practice.cybertekschool.com/multiple_buttons to navigate the web page
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        //driver; representing our browser

        Thread.sleep(2000);

        //click  Don't click button
        WebElement dontClickButton = driver.findElement(By.id("disappearing_button"));
        dontClickButton.click();

        Thread.sleep(2000);

        driver.quit();

    }

}
