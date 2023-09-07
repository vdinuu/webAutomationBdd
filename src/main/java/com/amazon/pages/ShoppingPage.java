package com.amazon.pages;

import com.amazon.util.CommonUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public String getConfirmLoginText(){
        return CommonUtil.getElementText(userHeader);
    }

    public boolean isAccountHeaderPresent(){
        return CommonUtil.isElementDisplayed(myAccountHeader, "Account Header");
    }
}
