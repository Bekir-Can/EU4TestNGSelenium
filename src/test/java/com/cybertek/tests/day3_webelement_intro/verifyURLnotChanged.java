package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class verifyURLnotChanged {

    public static void main(String[] args) {

        /*First Test Case Class
         Verify URL not changed
        -open chrome browser (it should be understandable;open browser -> not clear explaination)
        -go to http://practice.cybertekschool.com/forgot_password      Links to an external site.
        -click on Retrieve password
        -verify that url did not change

        */

        //open chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //save expected url before clicking button
        String expectedUrl = driver.getCurrentUrl();


        //click on Retrieve password
        //WebElement --> Interface that represent elements on the webpage
        //retrievePasswordButton--> special class type
        //findElement --> method used to find element on a page
        // .... =driver.findElement(By.id("form_submit"));--> right sight represent,
                                                           //which keyword(object) only represent our browser
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit")); // Hey selenium I want to;
        // findElement, By.id, By. is special class of selenium, id is locator type
        retrievePasswordButton.click();


        //save actual url after clicking button
        String actualUrl = driver.getCurrentUrl();

        //verify that url did not change

        if(expectedUrl.equals(actualUrl)){

            System.out.println("PASS");
        }else {

            System.out.println("FAIL");
        }

         // to close browser
        // driver.quit();


    }
}
