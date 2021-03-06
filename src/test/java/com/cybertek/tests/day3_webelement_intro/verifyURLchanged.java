package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLchanged {


    public static void main(String[] args) throws InterruptedException {

        /* Verify URL changed
             open chrome browser
             go to http://practice.cybertekschool.com/forgot_password Links to an external site.
             enter any email
             click on Retrieve password
             verify that url changed to http://practice.cybertekschool.com/email_sent

        */

        //open chrome browser
        WebDriver driver = WebDriverFactory.getDriver("cHRome");//because browser type is toLowercase in the utilities package

        //go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //enter any email
        WebElement emailInputBox = driver.findElement(By.name("email"));

        //sendKeys()--> send keyboard action to the web element means fill the box out
        emailInputBox.sendKeys("mike@cybertek.com");

        //click on Retrieve password
       WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
       retrievePasswordButton.click();

       Thread.sleep(3000);

        //verify that url changed to http://practice.cybertekschool.com/email_sent

        //create expectedUrl
        String expectedUrl ="http://practice.cybertekschool.com/email_sentt";//we wrote wrong url to see FAil Result

        //saving actual url from browser after we enter any email and click retrieve password button
        String actualUrl = driver.getCurrentUrl();

        if(expectedUrl.equals(actualUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedUrl = " + expectedUrl);//we wrote,if to give fail, we can see the difference
            System.out.println("actualUrl = " + actualUrl);//we wrote,if to give fail, we can see the difference
        }

        //close browser
        driver.quit();
    }
}
