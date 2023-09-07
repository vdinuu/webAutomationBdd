package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='login']")
    private WebElement lnkSignIn;



    public String getHomePageTitle(){
        return driver.getTitle();
    }

    public LoginPage navigateToLoginPage(){
        lnkSignIn.click();
        return new LoginPage(driver);
    }
}
