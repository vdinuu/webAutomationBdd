package com.amazon.driverfactory;

import com.amazon.util.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {
    public WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver initDriver(String browser, String url){
        System.out.println("Browser is "+browser);
        if(browser.equals("chrome")){
//            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
        } else if(browser.equals("firefox")){
//            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.mediumWait));
        getDriver().get(url);
        return getDriver();
    }
    public static synchronized WebDriver getDriver(){
        return tlDriver.get();
    }
}
