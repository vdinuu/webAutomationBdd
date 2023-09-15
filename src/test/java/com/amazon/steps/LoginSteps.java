package com.amazon.steps;

import com.amazon.driverfactory.DriverFactory;
import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.ShoppingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {
    private HomePage homePage = new HomePage(DriverFactory.getDriver());
    private LoginPage loginPage;
    private ShoppingPage shoppingPage;


    @Given("User is on login page")
    public void goToLoginPage(){
        String homePageTitle = homePage.getHomePageTitle();
        Assert.assertEquals(homePageTitle, "Swag Labs");
//        loginPage = homePage.navigateToLoginPage();
    }

    @When("user enters username as {string} and password as {string}")
    public void enterLoginCredentials(String userName, String password){
        loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.loginToAmazon(userName, password);
    }
    @And("clicks on Submit button")
    public void clickSubmit(){
        shoppingPage = loginPage.doLogin();
    }
    @Then("Login should not be successful")
    public void isLoginSuccessful(){
//        String loggedInText = shoppingPage.getConfirmLoginText();
//        Assert.assertTrue(loggedInText.contains("Dinu"));
        Assert.assertTrue(shoppingPage.isLoginErrorDisplayed(), "Login error is not displayed");
    }
    @And("Accounts banner is displayed")
    public void isAccountBannerDisplayed(){
        boolean flag = shoppingPage.isAccountHeaderPresent();
        Assert.assertTrue(flag);
    }
}
