package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EbayHomeWork {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("selenium");
        WebElement searchButton = driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']"));
        searchButton.click();
        WebElement value = driver.findElement(By.xpath("//span[contains(text(),'results for')]"));
        value.getText();
        String expectValue = "1-48 of 261 results for";

        if (value.getText().equals(expectValue)){
            System.out.println("Pass");

        }else {
            System.out.println("False");
            System.out.println("expectedResult = " + expectValue);
            System.out.println("resultText = " + value.getText());
        }
        Thread.sleep(3000);
        driver.quit();
    }
}
