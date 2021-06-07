package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageReview {

    public LoginPageReview(){

        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id="predentedInput")
    public WebElement usernameInput;

    @FindBy(id="predentedInput2")
    public WebElement passwordInput;

    @FindBy(id="_submit")
    public WebElement loginBtn;

}
