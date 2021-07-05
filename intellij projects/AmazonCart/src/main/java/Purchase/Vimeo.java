package Purchase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Vimeo {
    //iframe[@src='https://player.vimeo.com/video/169794007']
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Vimeo.html");

        driver.switchTo().frame(0);
       WebElement play_button =  driver.findElement(By.xpath("//div[@class='play-icon']"));
       play_button.click();
       Thread.sleep(8000);
       driver.quit();
    }
}
