package TeamPackage.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Task1 {
    public static void main(String[] args) {
        System.setProperty("chromDriver", " src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Amazon sayfasına gidiniz
        driver.get("https://www.amazon.com");

        //iphone aratınız
        driver.findElement(By.id("twotabsearchtextbox") ).sendKeys("i phone 14", Keys.ENTER);

        //çıkan sonuç yazısını konsola yazdırınız



        //çıkan ürünlerden ilk 5 tanesine tıklayıp sayfa başlıklarını yazdırınız


    }
}
