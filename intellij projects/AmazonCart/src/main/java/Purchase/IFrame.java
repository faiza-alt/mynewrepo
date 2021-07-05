package Purchase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrame {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Frames.html");

       WebElement iframe =  driver.findElement(By.xpath("//iframe[@id='singleframe']"));
       driver.switchTo().frame(iframe);
        Thread.sleep(3000);
        WebElement searchBox =  driver.findElement(By.xpath("/html/body/section/div/div/div/input"));
        searchBox.sendKeys("selenium java ");

        Thread.sleep(3000);
        driver.quit();

    }
}
