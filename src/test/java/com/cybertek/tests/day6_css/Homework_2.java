package com.cybertek.tests.day6_css;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homework_2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        WebElement homeLink = driver.findElement(By.xpath("//a [@class='nav-link']"));
        homeLink.click();
        System.out.println("homeLink.getText() = " + homeLink.getText());
//       Thread.sleep(2000);
//       driver.navigate().back();
//
//        WebElement forgotPassworHeader = driver.findElement(By.xpath("//div[@class='example']/child::h2"));
//        forgotPassworHeader.click();
//
//        WebElement emailText = driver.findElement(By.xpath("//*[.=\"E-mail\"]"));
//        emailText.click();
//
//        WebElement emailInputBox = driver.findElement(By.xpath("//input[@name='email']"));
//        emailInputBox.click();
//        emailInputBox.sendKeys("sofargood@gmail.com");
//
//        WebElement retrievePasswordButton = driver.findElement(By.xpath("//i[.='Retrieve password']"));
//        retrievePasswordButton.click();
//        //String homeText = driver.findElement(By.xpath("//a[@class='nav-link']"));
//
//
//        Thread.sleep(3000);
//        //driver.quit();

    }
}
