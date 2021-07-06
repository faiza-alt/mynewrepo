package com.facebook.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
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

public class extentReportWithScreenShot {
    public WebDriver driver;
    public ExtentReports extent;
    public ExtentTest logger;
    private ITestResult result;

    public static String capture(WebDriver driver,String screenShotName) throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") +"/ErrorScreenshots/"+screenShotName+".png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);
        return dest;
    }
    @BeforeTest
    public void init()
    {
       // ExtentHtmlReporter reporter=new ExtentHtmlReporter("/test-output/ExtentScreenshot.html");

        //System.getProperty("user.dir") + "/test-output/ExtentScreenshot.html",true);
        ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/reportsWithScreenshots.html");
        extent = new ExtentReports();
       extent.attachReporter(reporter);
        logger = extent.createTest("LoginTest");
        logger.log(Status.INFO, "Login to CRM");
       logger.log(Status.PASS, "Title verified");

    }

    @Test
    public void captureScreenshot()
    {
        driver = new ChromeDriver();
        driver.get("https://www.freecrm.com/");
        String title = driver.getTitle();
        Assert.assertEquals("23Free CRM software can boost your sales by 30%", title);
        logger.log(Status.PASS, "Test Passed");
    }

    @AfterMethod
    public void getResult(ITestResult result) throws IOException
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            String screenShotPath = capture(driver, "screenShotName");
            logger.log(Status.FAIL, result.getThrowable());
            logger.log(Status.FAIL, "Snapshot below: " + logger.addScreenCaptureFromPath(screenShotPath));
        }
       // extent.removeTest(logger);
    }


    @AfterTest
    public void endreport()
    {
        extent.flush();
        driver.quit();
    }
}
