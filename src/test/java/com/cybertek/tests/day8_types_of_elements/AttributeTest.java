package com.cybertek.tests.day8_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AttributeTest {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioButton = driver.findElement(By.id("blue"));

        blueRadioButton.click();
        blueRadioButton.getAttribute("value");

        //get the value of type attribute
        blueRadioButton.getAttribute("type");
        System.out.println("blueRadioButton = " + blueRadioButton.getAttribute("type"));

        // get the value of name attribute
        blueRadioButton.getAttribute("name");
        System.out.println("blueRadioButton = " + blueRadioButton.getAttribute("name"));

        //get the value of checked -->if we have checked attributes result will be->true or false based on the condition
        blueRadioButton.getAttribute("checked");
        System.out.println("blueRadioButton = " + blueRadioButton.getAttribute("checked"));

        // trying to get attribute that does not exist...
        //when we used non exist attribute it will return null class
        System.out.println(blueRadioButton.getAttribute("href"));

        //to bring html of full elements as a String
        System.out.println(blueRadioButton.getAttribute("outerHTML"));

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement button2 = driver.findElement(By.name("button2"));

        //If we cannot solve to get three different ways of the text, we can use outerHTML
        // So, get.Attribute("outerHTML");
        System.out.println(button2.getAttribute("outerHTML"));
        String outerHTML = button2.getAttribute("outerHTML");
        Assert.assertTrue(outerHTML.contains("Button 2"));

        //If we cannot solve to get three different ways of the text, we can use innerHTML,
        // So, get.Attribute("innerHTML");
        System.out.println("Inner HTML: "+button2.getAttribute("innerHTML"));

        driver.quit();

    }
}