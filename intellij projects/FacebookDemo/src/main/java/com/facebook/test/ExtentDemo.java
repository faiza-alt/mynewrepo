package com.facebook.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.facebook.base.Library;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ExtentDemo {
    public WebDriver driver;
     ExtentReports extent;
    ExtentTest logger;
    ExtentHtmlReporter reporter;

    @BeforeTest
    public void setExtent(){
        reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"./Reports/demo.html");
       // ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Reports/extentDemo.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        logger = extent.createTest("freeCrm");
    }
    @Test
    public void freeCrm(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get("https://www.freecrm.com/");
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"1Free CRM software can boost your sales by 30%");

    }
    @AfterTest
    public void tearDown(ITestResult result) throws IOException {
        if (ITestResult.FAILURE==result.getStatus()){
            logger.log(Status.FAIL,"Test Is Failed"+result.getName());
            logger.log(Status.FAIL,"Test Is Failed"+result.getThrowable());
            String screenShotPath = Library.getScrnShot(driver);
            logger.log(Status.FAIL, (Markup) logger.addScreenCaptureFromPath(screenShotPath));
            logger.log(Status.FAIL, "Snapshot below: " + logger.addScreenCaptureFromPath(screenShotPath));
        }
        else if (ITestResult.SKIP==result.getStatus()){
            logger.log(Status.SKIP,"Test Is SKIPPED"+result.getName());
        }
        else if (ITestResult.SUCCESS==result.getStatus()){
            logger.log(Status.PASS,"Test Is PASSED"+result.getName());
        }
        extent.flush();
        driver.quit();
//
//        @AfterMethod
////    public void tearDown(ITestResult result) throws IOException {
////        if(ITestResult.FAILURE == result.getStatus())
////        {
////            String temp =  getScreenShot(driver);
////           logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
//////            String screenShotPath = Library.getScrnShot(driver);
//////            logger.log(Status.FAIL, result.getThrowable());
//////            logger.log(Status.FAIL, "Snapshot below: " + logger.addScreenCaptureFromPath(screenShotPath));
////        }
////        driver.quit();
////        extent.flush();
//    }
//

   // }
//    public static String  getScreenShot(WebDriver driver){
//        //String dateName = new SimpleDateFormat("yyyymmddhhmm").format(new Date());
//        TakesScreenshot scrShot = ((TakesScreenshot) driver);
//        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
//        String destination=System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()+".png";
//
//        File DestFile = new File(destination);
//        try {
//            FileUtils.copyFile(SrcFile, DestFile);
//        } catch (IOException e) {
//           System.out.println("capture failed"+e.getMessage());
//        }
//        return destination;
    }

}
