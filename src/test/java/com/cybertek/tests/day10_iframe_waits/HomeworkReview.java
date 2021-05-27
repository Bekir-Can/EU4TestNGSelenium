package com.cybertek.tests.day10_iframe_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeworkReview {


    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }


    @AfterMethod
    public  void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit;

    }

    @Test
    public void test1(){
        driver.get("");
    }
}
