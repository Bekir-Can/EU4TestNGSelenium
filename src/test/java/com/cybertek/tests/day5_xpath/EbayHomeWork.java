package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EbayHomeWork {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com");
        driver.manage().window().maximize();

        WebElement searchBox = driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']"));
        searchBox.sendKeys("selenium");

        WebElement searchButton = driver.findElement(By.xpath("//input[@class='btn btn-prim gh-spr']"));
        searchButton.click();

        WebElement text = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']"));
        System.out.println("text.getText() = " + text.getText());


        System.out.println("driver.getTitle() = " + driver.getTitle());
        String actualTitle = driver.getTitle();
        String expectedTitle = "selenium";
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Pass");

        }else{
            System.out.println("Fail");
            System.out.println("ActualTitle= "+actualTitle);
            System.out.println("ExpectedTitle= "+expectedTitle);
        }


            driver.quit();
    }
}
