package TeamPackage.day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Task5 {
    public static void main(String[] args) {
        System.setProperty("chromDriver", " src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        // Youtube ana sayfasina gidelim . https://www.youtube.com/
        driver.get("https://www.youtube.com/");

        // Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        // Tekrar YouTube'sayfasina donelim
        driver.navigate().back();

        //  Yeniden Amazon sayfasina gidelim
        driver.navigate().forward();

        //  Sayfayi Refresh(yenile) yapalim
        driver.navigate().refresh();

        // Sayfayi kapatalim / Tum sayfalari kapatalim

        driver.close();
        driver.quit();
    }
}
