package com.cybertek.tests.day4_basiclocators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class classNameTest {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //maximize the window
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement homeLink = driver.findElement(By.className("nav-link"));
        homeLink.click();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");


        // print multiple buttons header
        //System.out.println(driver.findElement(By.className("h3"))); //with this we get reference adress
        //System.out.println(driver.findElement(By.className("h3")).getText()); -->print web element to use className
        System.out.println(driver.findElement(By.tagName("h3")).getText()); //print web element to use tagName
        //driver.quit();




    }
}
