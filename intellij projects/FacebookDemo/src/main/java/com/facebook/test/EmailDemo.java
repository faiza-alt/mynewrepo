package com.facebook.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.facebook.base.Library;
import com.facebook.base.TestBase;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class EmailDemo extends TestBase {
    public  static ChromeDriver driver;
    public static Library lib;
    private  ExtentReports extent;
    ExtentTest logger;
   private  ExtentTest extentTest;
    @BeforeTest
    public void facebookLogin() throws IOException {

        ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/learn_automation1.html");
         extent = new ExtentReports();
        extent.attachReporter(reporter);
        logger = extent.createTest("LoginTest");
         logger.log(Status.INFO, "Login to amazon");
            logger.log(Status.PASS, "Title verified");

    }
    @Test
    public void test(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        lib = new Library(driver);
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("faiza"));

    }
    @AfterTest
    public void after(ITestResult result) throws IOException {
        if(ITestResult.FAILURE==result.getStatus()){
            logger.log(Status.FAIL,"test is failed"+result.getName());
            logger.log(Status.FAIL,"test is failed"+result.getThrowable());
           // String temp = Library.getScrnShot(driver,result.getName());
           // logger.log(Status.FAIL, (Markup) extentTest.addScreencastFromPath(temp));
        }
        extent.flush();
        driver.quit();
    }

    }

