package com.amazon.pages;

import com.amazon.util.CommonUtil;
import com.amazon.util.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "ap_email")
    private WebElement ipLoginId;

    @FindBy(id = "ap_password")
    private WebElement ipPassword;

    @FindBy(id = "signInSubmit")
    private WebElement btnSubmit;

    @FindBy(id = "continue")
    private WebElement btnContinue;



    public void enterUserId(String userName){
        ipLoginId.sendKeys(userName);
    }

    public void enterPassword(String password){
        ipPassword.sendKeys(password);
    }

    public void loginToAmazon(String userId, String pwd){
        enterUserId(userId);
        btnContinue.click();
        CommonUtil.waitForElementVisible(driver, ipPassword, "Password", Constants.mediumWait);
        enterPassword(pwd);

    }


    public ShoppingPage doLogin(){
        btnSubmit.click();
        return new ShoppingPage(driver);
    }
}
