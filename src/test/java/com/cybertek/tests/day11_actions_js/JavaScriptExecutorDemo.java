package com.cybertek.tests.day11_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorDemo {
    /*
    * NOTE: If the regular codes don’t work , we use JavaScript codes.For example;
    *  There is not scroll up and down method in selenium.
    *  We can write to disable input box with javaScript.
    * So this type works we use javaScriptExecutor
    * Now. We will learn just what we need to do!!!! Not all javaScript
     * */
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        // driver.quit();
    }

    @Test
    public void clickWithJS(){

        // to execute the Dropdown  as use javaScript code and ask to google

        driver.get("http://practice.cybertekschool.com/");

        WebElement dropdownLink = driver.findElement(By.linkText("Dropdown"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click();", dropdownLink);// we took the code(arguments[0].click();) from google

    }

    @Test
    public void typeWithJS() {

        //to execute the disable input box as use javaScript code

        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));

        // to click--> we will use-> JavascriptExecutor object, not JavascriptExecution BE CAREFUL!!!
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        String text = "Hello Disabled Input";

        jse.executeScript("arguments[0].setAttribute('value', '" + text + "')", inputBox);
        //just only javScript code is-> <<<arguments[0].setAttribute('value', '" + text +"') >>>the all others java code
        // we only manipulated variable which is <<text>>
    }

    @Test
    public void ScrollDownAndUp() throws InterruptedException {

        //to execute the ScrollDownAndUp as use javaScript code

        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        driver.manage().window().maximize();


        JavascriptExecutor jse = (JavascriptExecutor) driver;

        // For example : We want to scroll down more for this loop

        // This for loop for Scroll Down
        for (int i = 0; i < 10; i++) {   // for loop short cut -> itar + enter
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,250)");// for this we used google

        }
        // This for loop for Scroll up
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,-250)");// to change the -0,250

        }

    }

    @Test
    public void scrollToElement() throws InterruptedException {
        /*
        QUESTION? HOW DECIDETHE STOP WEB ELEMENT PASS THE TEST OR NOT?
        ANSWER IS GOOGLE then to write down
        */

        driver.get("https://www.amazon.com/");
        WebElement eng = driver.findElement(By.id("icp-touch-link-language"));
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].scrollIntoView(true);",eng);


    }



}