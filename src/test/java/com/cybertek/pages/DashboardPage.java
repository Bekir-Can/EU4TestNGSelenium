package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage{//We want to reach the BasePage and the log in end it up DashBoardPage
                                            // that is the reason to create it.

//    public DashboardPage(){  //WE DONT NEED THIS HERE because of parents constructor
//        PageFactory.initElements(Driver.get(),this);
//    }

    //no need to explicitly write constructor, because it will use its parents constructor
    // If something commons between the pages => it could be BasePage class
}