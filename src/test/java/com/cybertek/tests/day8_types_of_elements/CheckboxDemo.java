package com.cybertek.tests.day8_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxDemo {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement checkBox1= driver.findElement(By.xpath("//input[1]"));
        WebElement checkBox2= driver.findElement(By.xpath("//input[2]"));

        //WebElement checkBox1= driver.findElement(By.cssSelector("#checkboxes>input:nth-of-type(1)"));
        //WebElement checkBox2= driver.findElement(By.cssSelector("#checkboxes>input:nth-of-type(2)"));
        //checkBox1.click();
        //checkBox2.click();

        //How to verify checkBox is selected?
        System.out.println("checkBox1 = " + checkBox1.isSelected());
        System.out.println("checkBox2 = " + checkBox2.isSelected());

        //verify checkbox 1 is not selected, 2 is selected

        Assert.assertFalse(checkBox1.isSelected(),"verify checkbox 1 not selected");
        Assert.assertTrue(checkBox2.isSelected(),"verify checkbox is selected");

        //how to check checkbox?
        checkBox1.click();


        //verify after click
        Assert.assertTrue(checkBox1.isSelected(),"verify checkbox is selected");
        Assert.assertTrue(checkBox2.isSelected(),"verify checkbox is selected");
        Thread.sleep(3000);
        driver.quit();
    }


}
