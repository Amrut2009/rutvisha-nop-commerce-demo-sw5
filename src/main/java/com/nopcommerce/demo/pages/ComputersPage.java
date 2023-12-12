package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ComputersPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Computers']")
    WebElement welcomeText;
    @CacheLookup
    @FindBy(xpath = "//li[@class='active last']//a[normalize-space()='Desktops']")
    WebElement desktopsMenuLink;


    public String getWelcomeText() {

        return getTextFromElement(welcomeText);
    }

    public void clickOnDesktopsLink()
    {
        clickOnElement(desktopsMenuLink);
    }



}
