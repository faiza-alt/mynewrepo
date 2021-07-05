package Purchase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class selectable {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Selectable.html");
        Thread.sleep(3000);
        List<WebElement> lists = driver.findElements(By.xpath("//ul[@class='deaultFunc']/li"));
        for( int i = 0; i < lists.size(); i++){
            lists.get(i).click();
            Thread.sleep(3000);
        }
        Thread.sleep(3000);
        driver.quit();

    }
}
