package com.facebook.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.facebook.base.Library;
import com.facebook.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FacebookDemo extends TestBase {
    public  static ChromeDriver driver;
    public static Library lib;
      ExtentReports extent;
    ExtentTest logger;
    ExtentHtmlReporter reporter;

    @Test
    public void facebookLogin(){

        Library.takeScrnShot(driver,"BrowserStared");
        WebElement firstName = driver.findElement(By.cssSelector("[name='firstname']"));
        firstName.sendKeys("Faiza");
        Library.takeScrnShot(driver,"TypeName");
    }

    @Test
    public void faceBookTest(){
        WebElement firstName = driver.findElement(By.cssSelector("[name='123firstname']"));
        firstName.sendKeys("Faiza");
    }

    @BeforeTest
    public void beforeTest(){
        reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"./Reports/demo.html");
        //ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Reports/learn_automation1.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        logger=extent.createTest("LoginTest");

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        lib = new Library(driver);
    }
    @AfterTest
    public void after(ITestResult result) throws IOException {
        if(ITestResult.FAILURE==result.getStatus()){
            String temp = Library.getScrnShot(driver);
            //logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            String screenShotPath = Library.getScrnShot(driver);
            logger.log(Status.FAIL, result.getThrowable());
            logger.log(Status.FAIL, "Snapshot below: " + logger.addScreenCaptureFromPath(screenShotPath));
        }
        extent.flush();
        driver.quit();
    }

    @Test
    public void MyFirstTestCase() {
        System.out.println("title is verified"+driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("faiza"));


//
//        ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Reports/learn_automation1.html");
//        // Create object of ExtentReports class- This is main class which will create report
//        extent = new ExtentReports();
//
//        // attach the reporter which we created in Step 1
//        extent.attachReporter(reporter);
//
//        // call createTest method and pass the name of TestCase- Based on your requirement
//        logger=extent.createTest("LoginTest");

//            // log method will add logs in report and provide the log steps which will come in report
//            logger.log(Status.INFO, "Login to amazon");
//
//            logger.log(Status.PASS, "Title verified");
//
//            // Flush method will write the test in report- This is mandatory step
//            extent.flush();



//        // You can call createTest method multiple times depends on your requirement
//        // In our case we are calling twice which will add 2 testcases in our report
//        ExtentTest logger2=extent.createTest("Logoff Test");
//
//        logger2.log(Status.FAIL, "Title verified");
//
//       logger2.fail("Failed because of some issues", MediaEntityBuilder.createScreenCaptureFromPath("src/main/resources/scrnShotsscrnShotName.png").build());
//       logger2.pass("Failed because of some issues", MediaEntityBuilder.createScreenCaptureFromPath("src/main/resources/scrnShots/login.png").build());
//
//        // This will add another test in report
//       extent.flush();
    }
}
