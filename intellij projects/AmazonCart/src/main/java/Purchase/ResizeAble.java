package Purchase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ResizeAble {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Resizable.html");


       WebElement resizeable =  driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));
       Actions actions = new Actions(driver);
        int y = 30;
        for(int x= 200; x < 500; x++){
            if(y < 80){

                y++;

            }
            actions.dragAndDropBy(resizeable, x, y).build().perform();
            Thread.sleep(3000);
        }
     Thread.sleep(3000);
        driver.quit();
    }
}
