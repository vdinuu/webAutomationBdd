package com.amazon.pages;

import com.amazon.util.CommonUtil;
import com.amazon.util.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    private WebElement ipLoginId;

    @FindBy(id = "passwd")
    private WebElement ipPassword;

    @FindBy(id = "SubmitLogin")
    private WebElement btnSubmit;

    public void enterUserId(String userName){
        ipLoginId.sendKeys(userName);
    }

    public void enterPassword(String password){
        ipPassword.sendKeys(password);
    }

    public void loginToAmazon(String userId, String pwd){
        enterUserId(userId);
        CommonUtil.waitForElementVisible(driver, ipPassword, "Password", Constants.mediumWait);
        enterPassword(pwd);

    }

    public ShoppingPage doLogin(){
        btnSubmit.click();
        return new ShoppingPage(driver);
    }
}
