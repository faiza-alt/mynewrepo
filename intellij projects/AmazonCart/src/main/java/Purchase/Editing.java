package Purchase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Editing {


    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/TinyMCE.html");

        Thread.sleep(3000);
//
        WebElement imageBtn = driver.findElement(By.xpath("//div[@aria-label='Insert/edit image']"));
        imageBtn.click();
        //driver.switchTo().alert();
        Thread.sleep(3000);

        WebElement imageBtn1 = driver.findElement(By.xpath("//input[@class='mce-textbox']"));
        //imageBtn1.click();
        imageBtn1.sendKeys("This PC");
        WebElement imageBtn2 = driver.findElement(By.xpath("//input[@id='mceu_21']"));
        imageBtn2.sendKeys("Cooking Stuff");

       WebElement dimensions1 = driver.findElement(By.xpath("//input[@id='mceu_23']"));
       dimensions1.sendKeys("1300");
       WebElement dimenseions2 = driver.findElement(By.xpath("//input[@id='mceu_25']"));
        dimenseions2.sendKeys("900");
        WebElement checkbtn = driver.findElement(By.xpath("//div[@aria-labelledby='mceu_27-l']"));
       checkbtn.click();

        WebElement okBtn = driver.findElement(By.xpath("//span[text()='Ok']"));
        okBtn.click();


//        Thread.sleep(1000);
//       WebElement BUTTON = driver.findElement(By.xpath("//button[@id='mceu_9-open']"));
//       BUTTON.click();
//        Thread.sleep(1000);
//
//        WebElement BUTTON1 = driver.findElement(By.xpath("//div[@id='mceu_25']"));
//        BUTTON1.click();
//        WebElement BUTTON2 = driver.findElement(By.xpath("//div[@id='mceu_29']"));
//        BUTTON2.click();
//        WebElement BUTTON3 = driver.findElement(By.xpath("//span[@id='mceu_34-text']"));
//        BUTTON3.click();
//
//        Thread.sleep(1000);
//
//        WebElement body = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
//
//        driver.switchTo().frame(body);
//
//
//        WebElement body2 = driver.findElement(By.xpath("//body[@id='tinymce']"));
//        body2.sendKeys("Faiza Ramzan");
//
//

        Thread.sleep(1000);
driver.quit();
    }
}
