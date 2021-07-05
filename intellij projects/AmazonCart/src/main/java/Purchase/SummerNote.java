package Purchase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SummerNote {

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(" http://demo.automationtesting.in/SummerNote.html");



      WebElement fullScreen =  driver.findElement(By.xpath("//button[@data-original-title='Full Screen']"));
      fullScreen.click();

        Thread.sleep(3000);


        WebElement style =  driver.findElement(By.xpath("//button[@data-original-title='Style']"));
        style.click();

        WebElement styleh1 =  driver.findElement(By.xpath("//a[@data-value='h1']"));
        styleh1.click();
        //WebElement note =  driver.findElement(By.xpath("//div[@id='summernote']"));
       // note.clear();
        WebElement table =  driver.findElement(By.xpath("//i[@class='note-icon-picture']"));
         table.click();
        Thread.sleep(3000);

        WebElement upload =  driver.findElement(By.xpath("//input[@class='note-image-input form-control']"));
        upload.sendKeys("C:/Users/ramza/Pictures/my_image.jpg");

        WebElement video =  driver.findElement(By.xpath("//i[@class='note-icon-video']"));
        video.click();
        WebElement video1 =  driver.findElement(By.xpath("//input[@class='note-video-url form-control span12']"));
        video1.sendKeys("https://youtu.be/mOAXEQevCAE");

        WebElement Button =  driver.findElement(By.xpath("//button[text()='Insert Video']"));
        Button.click();
        Thread.sleep(2000);
        driver.switchTo().frame(0);

        Thread.sleep(2000);
        WebElement Buttonplay =  driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']"));
        Buttonplay.click();

        Thread.sleep(8000);
        driver.quit();


    }
}
