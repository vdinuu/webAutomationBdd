package com.amazon.pages;

import com.amazon.util.CommonUtil;
import com.amazon.util.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ConcurrentModificationException;

public class ShoppingPage {
    private WebDriver driver;

    public ShoppingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='account']/span")
    public WebElement userHeader;

    @FindBy(xpath = "//span[@class='navigation_page']")
    public WebElement myAccountHeader;

    @FindBy(css = "div#auth-error-message-box")
    public WebElement loginError;

    public String getConfirmLoginText(){
        return CommonUtil.getElementText(userHeader);
    }

    public boolean isAccountHeaderPresent(){
        return CommonUtil.isElementDisplayed(myAccountHeader, "Account Header");
    }

    public boolean isLoginErrorDisplayed(){
        boolean flag;
        try {
            CommonUtil.waitForElementVisible(driver, loginError, "Login Error", Constants.mediumWait);
            flag = loginError.isDisplayed();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
}
