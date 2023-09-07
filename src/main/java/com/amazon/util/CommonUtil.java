package com.amazon.util;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonUtil {

    public static void click(WebElement element){
        element.click();
    }

    public static void waitForElementVisible(WebDriver driver, WebElement element,String elementName, int duration){
        try {
            Logs.info("Waiting for element - "+elementName);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public static String getElementText(WebElement element){
        String text = null;
        text = element.getText();
        if(text==null || text.isEmpty() ){
            text = element.getAttribute("value");
        }
        return text;
    }

    public static boolean isElementDisplayed(WebElement element, String elementName){
        Logs.info("Checking the presence of : "+elementName);
        boolean flag=true;
        try {
            if(!element.isDisplayed()){
                flag=false;
            }
        } catch (NoSuchElementException e) {
            flag=false;
        }
        return flag;
    }
}
