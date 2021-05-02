package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorHW_2 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get(" http://practice.cybertekschool.com/forgot_password");
        driver.manage().window().maximize();

        WebElement home = driver.findElement(By.xpath("//a[@class='nav-link']"));
        System.out.println("home.getText() = " + home.getText());

        WebElement forgetPassWord = driver.findElement(By.xpath("//div[@class='example']/h2"));
        System.out.println("forgetPassWord.getText() = " + forgetPassWord.getText());

        WebElement emailText = driver.findElement(By.xpath("//label[contains(text(),'E-mail')]"));
        System.out.println("emailText.getText() = " + emailText.getText());

        WebElement emailInputBox = driver.findElement(By.xpath("//div[@class='large-6 small-12 columns']/input"));
        System.out.println("emailInputBox.getText() = " + emailInputBox.getText());
        emailInputBox.sendKeys("pass@gmail.com");

        WebElement retrievePassword = driver.findElement(By.xpath("//button[@id='form_submit']/i"));
        System.out.println("retrievePassword.getText() = " + retrievePassword.getText());

        driver.quit();
    }
}
