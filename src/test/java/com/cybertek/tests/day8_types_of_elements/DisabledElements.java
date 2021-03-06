package com.cybertek.tests.day8_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElements {

    @Test
    public void test1(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");


        WebElement greenDisabledButton = driver.findElement(By.cssSelector("#green"));



        //If we have disabled web element and if we want to see to click
        //How to check any element is enable or not?
        greenDisabledButton.isEnabled();
        Assert.assertFalse(greenDisabledButton.isEnabled(),"verify green radio button NOT enabled ");

        greenDisabledButton.click();// we try to click but it didn't work, because it is disable button


    }

    @Test
    public void test2() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/dynamic_controls");


        WebElement disabledInputBox = driver.findElement(By.cssSelector("#input-example>input"));
        disabledInputBox.sendKeys("TEST PASS");

        driver.quit();
        //As a result;look below
        //No action will be happen but we can get ElementNotIntractableException: element not intractable
    }
}
