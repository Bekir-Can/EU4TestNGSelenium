package com.cybertek.tests.day4_basiclocators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //make browser full screen(web page)
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");

        // we want to write Full name in the Full name of box
        WebElement fullNameInput = driver.findElement(By.name("full_name"));
        fullNameInput.sendKeys("Mike Smith");

        //enter the email in the Email box
        // proper way of locator of web element all until now and we can use same variable name in this page
        WebElement putEmail = driver.findElement(By.name("email"));
        putEmail.sendKeys("mikesmith@gmail.com");

        //there is lazy way as well but can can not use again same way it complains
        //driver.findElement(By.name("email")).sendKeys("wood_spoon");

        Thread.sleep(2000);

        //click the sign up button

        WebElement signUpButton = driver.findElement(By.name("wooden_spoon"));
        signUpButton.click();

        // driver.findElement(By.name("wooden_spoon")).click(); -->lazy way syntax


        Thread.sleep(2000);

        //driver.quit();


    }
}
