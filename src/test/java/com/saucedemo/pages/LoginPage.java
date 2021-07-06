package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class LoginPage {

     WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public  void login(String userName, String  key){
        WebElement user_Name = driver.findElement(By.id("user-name"));
        WebElement passWord = driver.findElement(By.id("password"));
        WebElement loginBtn= driver.findElement(By.id("login-button"));

        user_Name.sendKeys(userName);
        passWord.sendKeys(key);
        loginBtn.click();

    }

    public  boolean verifyLogin(){
        WebElement shopping_cart_Icon = driver.findElement(By.className("shopping_cart_link"));
       return shopping_cart_Icon.isDisplayed();
    }

    public  boolean verifyUnsuccessfulLogin(){
        WebElement errorMsg = driver.findElement(By.xpath("//h3[@data-test = 'error']"));
        return  errorMsg.isDisplayed();
    }
}
