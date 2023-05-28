package TeamPackage.day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Task4 {
    public static void main(String[] args) {
        System.setProperty("chromDriver", " src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

      //  Yeni bir package olusturalim : day01
        //Yeni bir class olusturalim : C03_GetMethods
        //Amazon sayfasina gidelim. https://www.amazon.com/
        //Sayfa basligini(title) yazdirin
        //Sayfa basliginin "Amazon" icerdigini test edin
        //Sayfa adresini(url) yazdirin
        //Sayfa url'inin "amazon" icerdigini test edin.
        //Sayfa handle degerini yazdirin
        //Sayfa HTML kodlarinda "Gateway" kelimesi gectigini test edin
       //  Sayfayi kapatin.
    }
}
