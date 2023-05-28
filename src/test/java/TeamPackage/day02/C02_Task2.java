package TeamPackage.day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Task2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("chromDriver", " src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


//        ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook” oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
//        Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
        driver.get("https://www.facebook.com");
        String actualTitle = driver.getTitle();
        String expectedTitle = "facebook";
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Test PASSED");
        } else System.out.println("Test FAILED = " + actualTitle);

//         https://www.walmart.com/ sayfasina gidin.
        driver.get("https://www.walmart.com/");

//        Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String actuelTitle1 = driver.getTitle();
        String ecpectedTirle1 = "Walmart.com";
        if (actuelTitle1.contains(ecpectedTirle1)) {
            System.out.println("Walmart test passed ");
        } else System.out.println("walmart test failed = " + actuelTitle1);

//        Tekrar “facebook” sayfasina donun
        driver.navigate().back();
        Thread.sleep(3000);

//        Sayfayi yenileyin
        driver.navigate().refresh();

//        Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();

//        9.Browser’i kapatin
        driver.close();
    }
}
