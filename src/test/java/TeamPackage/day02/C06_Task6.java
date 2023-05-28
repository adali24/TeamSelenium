package TeamPackage.day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_Task6 {
    public static void main(String[] args) {
        System.setProperty("chromDriver", " src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Yeni bir Class olusturalim.C06_ManageWindow
        //.Amazon soyfasina gidelim. https://www.amazon.com/
       //Sayfanin konumunu ve boyutlarini yazdirin
        //Sayfayi simge durumuna getirin
       //simge durumunda 3 saniye bekleyip sayfayi maximize yapin
       //Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        //Sayfayi fullscreen yapin
        //.Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        //Sayfayi kapatin
    }
}
