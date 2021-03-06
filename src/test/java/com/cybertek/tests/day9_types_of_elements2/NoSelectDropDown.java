package com.cybertek.tests.day9_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropDown {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tear() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void test1(){

        driver.get("http://practice.cybertekschool.com/dropdown");

        // 1. Locate your dropdown just like any other webelement with unique locator
        WebElement dropdownElement = driver.findElement(By.cssSelector("#dropdownMenuLink"));

        // we need to click the dropdown to see available options
        dropdownElement.click();
        List<WebElement> dropdownOptions = driver.findElements(By.className("dropdown-item"));
        //We don't use selenium  method here ,used regular method due to we don't have optional selection

        System.out.println("dropdownOptions.size() = " + dropdownOptions.size()); //result will be 5
        Assert.assertEquals(dropdownOptions.size(),5,"verify size of options");


        // print all the one by one
        for (WebElement dropdownOption : dropdownOptions) {

            System.out.println(dropdownOption.getText());

        }

        //click yahoo
        dropdownOptions.get(2).click();




    }

}
