package com.cybertek.tests.day11_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsTest {


    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }

    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1 = driver.findElement(By.tagName("img"));
        //Actions --> class that contains all the user interactions
        //how to create actions object --> passing driver as a constructor
        Actions actions = new Actions(driver);
        //perform() --> perform the action, complete the action
        //moveToElement --> move you mouse to webelement(hover over)
        Thread.sleep(2000);
        actions.moveToElement(img1).perform();

        WebElement viewLink = driver.findElement(By.linkText("View profile"));

        Assert.assertTrue(viewLink.isDisplayed(),"verify view link is displayed");

    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        Actions actions = new Actions(driver);

//        System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv"); // just to close the different versions cookies
//
//
//        List<WebElement> acceptAndClose = driver.findElements(By.xpath("//*[.='Accept and Close']"));
//        List<WebElement> acceptCookies = driver.findElements(By.xpath("//*[.='Accept Cookies']"));
//        Thread.sleep(1000);
//        if(acceptAndClose.size()>0){
//            acceptAndClose.get(0).click();
//        }else if(acceptCookies.size()>0){
//            acceptCookies.get(0).click();
//        }
//        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");// just to close the different versions cookies

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        Thread.sleep(2000);
        actions.dragAndDrop(source,target).perform();
    }

    @Test
    public void dragAndDropChaining() throws InterruptedException {      //dragAndDrop different way

        /*
            FIRST thing is hover over to the web element,
            for this syntax starts--> actions.moveToElement(source)

            SECOND thing is click hold the web element,
            for this syntax starts--> actions.moveToElement(source).clickAndHold()

            THIRD thing is move to the mouse to the target,
            for this syntax starts--> actions.moveToElement(source).clickAndHold().moveToElement(target)

            FOURTH thing is release the finger from click the mouse,
            for this syntax starts--> actions.moveToElement(source).clickAndHold().moveToElement(target).release().perform();
         */

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        driver.findElement(By.id("onetrust-accept-btn-handler")).click(); // to close popUps, cookies--> Accept and Close button
        Actions actions = new Actions(driver);



        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        Thread.sleep(2000);
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().perform();

    }

}