package Purchase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class dragAndDrop {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Dynamic.html");
        Thread.sleep(3000);
        WebElement from = driver.findElement(By.xpath("//img[@id='mongo']"));
        WebElement to = driver.findElement(By.xpath("//div[@id='droparea']"));
        Actions builder = new Actions(driver);
        //builder.dragAndDropBy(from,500,400).build().perform();

        builder.moveToElement(from).dragAndDrop(from,to).build().perform();
        Thread.sleep(3000);




    }
}
