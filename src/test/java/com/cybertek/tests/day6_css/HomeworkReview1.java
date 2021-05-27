package com.cybertek.tests.day6_css;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeworkReview1 {


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void testCase1() throws InterruptedException {
        driver.get("https://www.ebay.com/");
        System.out.println("driver.getTitle() = " + driver.getTitle());
        String expectedResult = "Electronics, Cars, Fashion, Collectibles & More | eBay";
        Assert.assertEquals(driver.getTitle(), expectedResult, "Verify the title Electronics, Cars, Fashion, Collectibles & More | eBay");

        WebElement inputBox = driver.findElement(By.cssSelector(".gh-tb.ui-autocomplete-input"));
        inputBox.sendKeys("adidas Yeezy 500 Enflame - FREE SHIPPING");

        WebElement searchButton = driver.findElement(By.cssSelector(".btn.btn-prim.gh-spr"));
        searchButton.click();

        WebElement resultOfSearch = driver.findElement(By.cssSelector(".srp-controls__count-heading"));
        System.out.println("resultOfSearch.getText() = " + resultOfSearch.getText());


    }

    @Test
    public void testCase2() {
        driver.get("https://www.ebay.com/");

        WebElement inputBox = driver.findElement(By.cssSelector(".gh-tb.ui-autocomplete-input"));
        inputBox.sendKeys("Selenium");

        WebElement searchButton = driver.findElement(By.cssSelector(".btn.btn-prim.gh-spr"));
        searchButton.click();

        WebElement resultOfSearch = driver.findElement(By.cssSelector(".srp-controls__count-heading"));
        System.out.println("resultOfSearch.getText() = " + resultOfSearch.getText());

        System.out.println("driver.getTitle() = " + driver.getTitle());
        String expectedResult = "Selenium";
        String actual = driver.getTitle();
        Assert.assertTrue(actual.contains(expectedResult), "Verify title contains Selenium");


    }


    @Test
    public void testCase3() {
        driver.get("https://www.wikipedia.org/");
        driver.findElement(By.cssSelector("#search-input>input")).sendKeys("selenium webdriver");
        driver.findElement(By.xpath("//button[@type]/i")).click();
        driver.findElement(By.xpath("//a[@href='/wiki/Selenium_(software)']/span")).click();
        String actual = driver.getCurrentUrl();
        String expected = "Selenium_(software)";
        System.out.println("actual = " + actual);
        Assert.assertTrue(actual.endsWith(expected), "verify url ends with Selenium_(software)");

    }
}
