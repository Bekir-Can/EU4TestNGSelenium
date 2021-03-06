package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonHomework {
    /*TASK
     * go to amazon.com
     * search for selenium
     * click search button
     * verify 1-48 of 304 results for "Java"*/

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        Thread.sleep(2000);
        searchBox.sendKeys("Selenium");
        Thread.sleep(2000);
        WebElement searchButton = driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']"));
        searchButton.click();
        Thread.sleep(2000);

        WebElement actualResult = driver.findElement(By.xpath("//*[contains(text(),'results for')]"));
        String result = actualResult.getText();
        System.out.println(result);
        String expResult = "1-48 of 304 results for";

        if(actualResult.equals(expResult)){
            System.out.println("PASS");
        }else {

            System.out.println("FAIL");
            System.out.println("Expexted result-->" + expResult);
            System.out.println("Actual result-->"+result);

        }


        //driver.quit();



    }
}
