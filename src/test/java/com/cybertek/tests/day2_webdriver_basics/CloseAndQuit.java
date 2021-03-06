package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com");

       Thread.sleep(2000);

       //close current tab
       driver.close();// executing stop here due to browser closes here then next code couldn't find the browser,
        //we don't create new object after the .close(),
        // normally we don't do this at the test case, test starts and finishes(close)


       driver = new ChromeDriver(); // to open again tab web pade, to create new oject ,
        // we want to same object name with the above the object for this we deleted the  <<<WebDriver>>>

        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(5000);

        //driver.close();//.close --> only effect tab that is only open by the selenium,
        // if our test case or web side trigger the new tab, it is not gonna close it

        driver.quit(); // .quit-> closes all tabs




    }
}
