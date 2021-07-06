package Purchase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonPurchase {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.amazon.com");

        WebElement  searchBox =  driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.click();
        searchBox.sendKeys("selenium");
        WebElement  searchBtn =  driver.findElement(By.xpath("//input[@value='Go']"));
        searchBtn.click();
        WebElement  product =  driver.findElement(By.xpath("//img[@src='https://m.media-amazon.com/images/I/61K6lpYCz6L._AC_UL320_.jpg']"));
        product.click();
        Thread.sleep(3000);

        WebElement  radioBtn =  driver.findElement(By.xpath("//a[@data-action='a-accordion']"));
        radioBtn.click();

        WebElement  cartBtn =  driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
        cartBtn.click();

        Thread.sleep(1000);
        WebElement  proceedBtn =  driver.findElement(By.xpath("//a[@id='hlb-ptc-btn-native']"));
        proceedBtn.click();

        Thread.sleep(9000);
        driver.quit();
    }
}
