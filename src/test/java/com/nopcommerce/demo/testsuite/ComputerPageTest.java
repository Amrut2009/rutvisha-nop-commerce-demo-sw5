package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.BuildYourOwnComputerPage;
import com.nopcommerce.demo.pages.ComputersPage;
import com.nopcommerce.demo.pages.DesktopPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.testbase.BaseTest;
import lombok.Data;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.awt.*;

@Listeners(CustomListeners.class)
public class ComputerPageTest extends BaseTest {
    HomePage homePage;
    ComputerPageTest computersPage;
    DesktopPage desktopPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;


    @BeforeMethod(alwaysRun = true)
    public void inIt() {
       homePage=new HomePage();
      computersPage=new ComputerPageTest();
      desktopPage=new DesktopPage();
      buildYourOwnComputerPage=new BuildYourOwnComputerPage();
    }
    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldNavigateToComputerPageSuccessfully(){
        homePage.clickOnComputersMenu();
        String expectedMessage = "Computers";
        String actualMessage = computersPage.getWelcomeText;
        Assert.assertEquals(actualMessage, expectedMessage, "Computers page not displayed");
    }




    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        homePage.clickOnComputersMenu();
        homePage.clickOnComputersMenu();
        String expectedMessage = "Desktops";
        String actualMessage = desktopPage.getWelcomeText();
        Assert.assertEquals(actualMessage, expectedMessage, "Desktops page not displayed");
    }

    @Test(dataProvider = "builtYourOwnComputer", dataProviderClass = Data.class , groups = {"regression"})
    public void verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram, String hdd, String os, String software){
        homePage.clickOnComputersMenu();
        computersPage.clickOnDesktopMenu;
        desktopPage.clickOnBuildYourOwnComputerLink();
        buildYourOwnComputerPage.optionsToBuiltYourOwnComputer(processor, ram, hdd, os, software);
        buildYourOwnComputerPage.clickOnAddToCart();
        String expectedMessage = "The product has been added to your shopping cart";
        String actualMessage = buildYourOwnComputerPage.getAddToCartSuccessfulMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "Product is not added successfully");
    }






}

