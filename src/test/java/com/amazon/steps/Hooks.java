package com.amazon.steps;

import com.amazon.driverfactory.DriverFactory;
import com.amazon.util.ConfigReader;
import com.amazon.util.Logs;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;


public class Hooks {
    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    public static Properties prop;

    @Before(value = "@skip", order = 0)
    public void skipScenario(Scenario scenario){
        Logs.info("SKIPPED : "+scenario.getName());
        Assume.assumeTrue(false);

    }
    @Before(order = 1)
    public void getProperty(){
        configReader = new ConfigReader();
        prop = configReader.initProp();
    }

    @Before(order = 2)
    public void launchBrowser(Scenario scenario){
        String browserName = System.getProperty("browser");
        if(null==browserName){
            browserName = prop.getProperty("browser");
        }
        String url = prop.getProperty("testUrl");
        driverFactory = new DriverFactory();
        driver = driverFactory.initDriver(browserName, url);
        Logs.startTestCase(scenario.getName());
    }


    @After(order = 0)
    public void quitBrowser(){
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
            Logs.error("Test case failed : "+scenario.getName());
        }else {
            Logs.endTestCase();
        }
    }

}
