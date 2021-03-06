package com.cybertek.tests.reviews;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
public class moreXpath {
    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");
        String menuName = "Best Sellers";
        String xpathLocator = "//div[@id='nav-xshop']/*[.='"+menuName+"']";
        WebElement menu = driver.findElement(By.xpath(xpathLocator));
        menu.click();
    }
}
/*HW
go to etsy.com
create one locator to click Clothing & Shoes
then do string manipulation to separate your locator part and text
create one variable for menuName and change value to Home & Living
your locator should work for different menus, without changing xpath part.
*/