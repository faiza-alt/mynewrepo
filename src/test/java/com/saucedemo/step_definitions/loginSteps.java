package com.saucedemo.step_definitions;
import static  com.saucedemo.base.Hook.*;
import com.saucedemo.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class loginSteps {


   LoginPage loginPage = new LoginPage(driver);

    @Given("user enter correct account information")
    public void user_enter_correct_account_information() {
       loginPage.login("standard_user", "secret_sauce");
    }
    @Then("system should let the user to login")
    public void system_should_let_the_user_to_login() {
        boolean shopping_cart_Icon = loginPage.verifyLogin();
        Assert.assertTrue(shopping_cart_Icon);

    }




    @Given("user enter invalid account information")
    public void user_enter_invalid_account_information() {
        loginPage.login("222", "2wsdf");
    }
    @Then("system should not let the user to login")
    public void system_should_not_let_the_user_to_login() {
        boolean errorMsg = loginPage.verifyUnsuccessfulLogin();
        Assert.assertTrue(errorMsg);
    }





}
