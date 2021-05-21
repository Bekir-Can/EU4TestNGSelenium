package com.cybertek.tests.day8_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Radio2 {

    @Test
    public void test1() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioButton = driver.findElement(By.cssSelector("#blue"));

        WebElement redRadioButton = driver.findElement(By.id("red"));


        Assert.assertTrue(blueRadioButton.isSelected(), "Blue is selected");

        Assert.assertFalse(redRadioButton.isSelected(), "Red not selected");

        driver.quit();
    }

}
