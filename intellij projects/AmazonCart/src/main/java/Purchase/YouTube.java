package Purchase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class YouTube {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Youtube.html");
        Thread.sleep(3000);

        driver.switchTo().frame(0);

       WebElement play_btn =  driver.findElement(By.xpath("//button[@aria-label='Play']"));
        play_btn.click();
        Thread.sleep(8000);
        driver.quit();

    }
}
