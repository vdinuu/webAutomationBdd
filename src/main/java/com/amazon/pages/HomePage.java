package com.amazon.pages;

import com.amazon.util.CommonUtil;
import com.amazon.util.Constants;
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

    @FindBy(id = "nav-link-accountList-nav-line-1")
    private WebElement accountList;

    @FindBy(css = "div#nav-flyout-ya-signin a.nav-action-signin-button span")
    private WebElement signInButton;

    public String getHomePageTitle(){
        return driver.getTitle();
    }

    public LoginPage navigateToLoginPage(){
        Actions actions = new Actions(driver);
        actions.moveToElement(accountList).build().perform();
        CommonUtil.waitForElementVisible(driver, signInButton, "Sign In Button", Constants.mediumWait);
        signInButton.click();
        return new LoginPage(driver);
    }
}
