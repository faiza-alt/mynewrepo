package com.facebook.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Library {

    private final WebDriver driver;

    public Library(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By by, String name) {
        driver.findElement(by).click();
        System.out.println(" Clicked  : " + name);
    }

    public void click(String name, WebElement element) {
        element.click();
        System.out.println(" Clicked  : " + name);
    }

    public void sendKeys(String keys, By by, String name) {
        driver.findElement(by).sendKeys(keys);
        System.out.println(" Sending keys  : " + keys + " to " + name);
    }

    public void waitSeconds(int amount) {
        try {
            Thread.sleep(amount * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void select(By by, String name, String way, String selection) {
        WebElement selectFrom = driver.findElement(by);
        Select select = new Select(selectFrom);

        if (way.equals("byValue")) {
            select.selectByValue(selection);
            System.out.println(name + " is selected" + selection + " by " + way);
        } else if (way.equals("byIndex")) {
            select.selectByIndex(Integer.parseInt(selection));
            System.out.println(name + " is selected" + selection + " by " + way);
        } else if (way.equals("byVisibleText")) {
            select.selectByVisibleText(selection);
            System.out.println(name + " is selected" + selection + " by " + way);
        } else {
            System.out.println("Please provide a valid selector from following selectors");
            System.out.println("1)  byIndex\t 2) byValue\t 3) byVisibleText\t");

        }


    }

    public void waitInMillis(int amount) {
        try {
            Thread.sleep(amount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scroll(int x, int y) {
        waitInMillis(500);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(" + x + ", " + y + ")");
        waitInMillis(500);
    }

    public void moveToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        waitSeconds(2);
    }

    public void scrollIntoView(By by) {
        waitInMillis(260);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(by);
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
        waitInMillis(260);
    }

    public void highlightWebelements(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 1; i < 3; i++) {
            js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
            waitInMillis(100);
            //js. executeScript("arguments[0].setAttribute('style');", element);
            js.executeScript("arguments[0].style=''", element, "");
        }


    }

    public WebElement explicitlyWaituntilvisible(By by) {
        WebElement element = new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
        return element;
    }

    public WebElement waitUntilPresenceOfWebElement(By by) {
        WebElement element = new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(by));
        return element;
    }

    public WebElement explicitlyWaituntilclickable(By by) {
        WebElement element = new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(by));
        return element;
    }

    public void explicitlyWaituntilalertispresent() {
        new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent());

    }

    public void waitUntilPageLoad() {
        new WebDriverWait(driver, 8).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void switchTabs(int index) {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(index));

    }

    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) {
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        //Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile = new File(fileWithPath);
        //Copy file at destination
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void takeScrnShot(WebDriver webdriver, String scrnShotName) {
        try {
            TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(SrcFile, new File("src/main/resources/scrnShots" + scrnShotName + ".png"));
            System.out.println("ScreenShot is taken ");
        } catch (Exception e) {
            System.out.println("exception while taking screenshot" + e.getMessage());
        }
    }

    public static String  getScrnShot(WebDriver webdriver) {
     // String dateName  = new SimpleDateFormat("yyyymmddhhmm").format(new Date());
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("User.dir")+ "/Screenshot/" +System.currentTimeMillis()+".png";
        File DestFile = new File(path);
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            System.out.println("capture failed"+e.getMessage());
        }
        return path;
    }
}
