package com.facebook.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {

   public  static ChromeDriver driver;
   public static Library lib;

       // @BeforeTest
    public   void startUp(){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        lib = new Library(driver);
        }

      //  @AfterTest
    public  void tearDown(){
            driver.quit();
        }


//    @AfterMethod
//    public void tearDown(ITestResult result) {
//        // Here will compare if test is failing then only it will enter into if condition
//        if(ITestResult.FAILURE==result.getStatus()) {
//            try {
//                // Create refernce of TakesScreenshot
//                TakesScreenshot ts=(TakesScreenshot)driver;
//                 // Call method to capture screenshot
//                File source=ts.getScreenshotAs(OutputType.FILE);
//                 // Copy files to specific location here it will save all screenshot in our project home directory and
//                 // result.getName() will return name of test case so that screenshot name will be same
//                FileUtils.copyFile(source, new File("src/main/resources/scrnShots"+result.getName()+".png"));
//                System.out.println("Screenshot taken");
//            }
//            catch (Exception e) {
//                System.out.println("Exception while taking screenshot "+e.getMessage());
//            }
//        }
//        driver.quit();
//    }



}
