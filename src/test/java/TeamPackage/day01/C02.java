package TeamPackage.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://amazon.com");
        System.out.println("sayfa basligi : "+driver.getTitle());
        Thread.sleep(3000);
        driver.get("https://yahoo.com");


    }
}
