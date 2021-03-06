package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactsPage extends BasePage{

    //since we are extending BasePage we do not need explicit constructor for this class

//    @FindBy(xpath = "//td[contains(text(),'mbrackstone9@example.com')][@data-column-label='Email']")
//    we dont wanna static email, it should be dynamic
//    public WebElement email;

    public WebElement getContactEmail(String email){ // this is very useful approach of method to do dynamic convert,
                                                    // to manipulate the locator
        String xpath ="//td[contains(text(),'"+email+"')][@data-column-label='Email']";//dynamic locator
        return Driver.get().findElement(By.xpath(xpath));//singleton design day13
    }
}