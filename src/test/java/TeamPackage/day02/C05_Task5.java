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

       // Yeni bir Class olusturalim.C05_NavigationMethods
       // Youtube ana sayfasina gidelim . https://www.youtube.com/
       // Amazon soyfasina gidelim. https://www.amazon.com/
       // Tekrar YouTube'sayfasina donelim
      //  Yeniden Amazon sayfasina gidelim
      //  Sayfayi Refresh(yenile) yapalim
       // Sayfayi kapatalim / Tum sayfalari kapatalim
    }
}
