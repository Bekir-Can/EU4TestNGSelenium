package com.cybertek.tests.day7_testing;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Before_After {

    @BeforeClass
    public void setUpClass() {


        System.out.println("Before Class");


    }

    @Test
    public void test1() {

        System.out.println("First Test Case");

    }

    @Test
    public void test2() {
        System.out.println("Second Test case");

    }

    @BeforeMethod
    public void setUp() {
        System.out.println("WebDriver, Opening Browser");
        //  WebDriver driver = WebDriverFactory.getDriver("chrome");
        //  driver.get("http://practice.cybertekschool.com/multiple_buttons");

    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Closing Browser, Quit");

    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("Afterclass");

    }
}
