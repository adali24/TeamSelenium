package TeamPackage.day04;

import com.beust.jcommander.StringKey;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;
import java.util.List;

public class testCase {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.facebook.com");
        Thread.sleep(1500);

        driver.findElement(By.xpath("//*[@id='u_0_k_qF']"));
        Thread.sleep(1000);
      // List<WebElement> cerez = driver.findElements(By.xpath("(//*[@value='1'])[1]"));


        WebElement kullaniciAdi = driver.findElement(By.xpath("//*[@id='email']"));
        kullaniciAdi.sendKeys("deneme");

        WebElement kullaniciSifre = driver.findElement(By.xpath("//*[@id='passContainer']"));
        kullaniciSifre.sendKeys("sifre");

        driver.findElement(By.xpath("//*[@name='login']")).click();


    }
}
