package com.cybertek.tests.day8_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonsTest {

    // Today we will learn how to verify radio button selected or not!!!

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        //First Step: how to check radio button is selected!!
        // locating radio buttons
        WebElement buleRadioButton = driver.findElement(By.cssSelector("#blue"));
        //WebElement blueRadButton = driver.findElement(By.xpath("//input[@id='blue']"));

        WebElement redRadioButton = driver.findElement(By.id("red"));
        //WebElement redRadButton = driver.findElement(By.cssSelector("#red"));

        //How to check the radio button is selected(.isSelected) ?
        System.out.println("buleRadioButton.isSelected() = " + buleRadioButton.isSelected());
        System.out.println("redRadioButton.isSelected() = "+ redRadioButton.isSelected());

        // How to verify blue is selected, red is not selected
        //blue--> true, blue is default in this example
        Assert.assertTrue(buleRadioButton.isSelected(),"verify that blue is selected");
        //red -->false
        Assert.assertFalse(redRadioButton.isSelected(),"verify that red is not selected");

        //How to click red radio button?
        //clicking the red button
        redRadioButton.click();// after click situation change the below so result changed

        //blue -->false
        Assert.assertFalse(buleRadioButton.isSelected(),"verify that blue is NOT selected");

        //red -->true
        Assert.assertTrue(redRadioButton.isSelected(),"verify that red is  selected");


        Thread.sleep(3000);
        //driver.quit();
    }
}
