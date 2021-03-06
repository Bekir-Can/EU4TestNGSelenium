package com.cybertek.tests.day9_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

    /* QUESTION: How to locate all of the web buttons in ONE SHOOT
     * Answer is: driver.findElements(); that works just like a driver.findElement() the different is;
     * it will return us List<WebElement> but in order to find one than more element in one shoot,
     * for this we are going to look for  in between one locator highlighter in 6(button) common locator.
     *  it will be something else but it will common
     * */

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");


    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1()  {

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        // save our web elements inside the list
        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        // . size will show us how many button we have inside list
        System.out.println("button.size() = " + buttons.size());
        //verify button size
        Assert.assertEquals(buttons.size(), 6, "verify button size");

        //we want to text the all of the buttons in one by one for this we use loop for each loop
        // to get for each loop with shortcut -> to write -> iter + enter
        for (WebElement button : buttons) { // button.getText().soutv + enter

            System.out.println("button.isDisplayed() = " + button.isDisplayed());
            //System.out.println("button.getText() = " + button.getText());
            Assert.assertTrue(button.isDisplayed(),"Verify buttons are displayed");
        }

        //click second button for this -> .get(index).click();
        buttons.get(1).click();


    }
    @Test
    public void test2(){

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        //regular findElement method will throw NoSuchElement if locator does not exist
       // driver.findElement(By.tagName("affgfgtgtgs"));

        //passing locator which does not exist, it will not throw NoSuchElement
        //Alt+Enter or OPTION+enter then one more enter for the shortcut
       List<WebElement> buttons = driver.findElements(By.tagName("affgfgtgtgs")); //wrong location
        System.out.println("buttons.size() = " + buttons.size());// result -> 0(zero)
        /*findElements() method does not throw the exception but if it cannot find any WebElement.
         It will keep 0 as a result.because There is no WebElement with example's tag,
         it doesn't give exception result, it gives 0. Even if we provide wrong locator it will not give fail.
         So We are going to VERIFY .size() all the time.
         */

    }

}













