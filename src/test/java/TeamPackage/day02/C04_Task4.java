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



        //Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //Sayfa basligini(title) yazdirin
        System.out.println("Amazon title = "+driver.getTitle());

        //Sayfa basliginin "Amazon" icerdigini test edin
        String guncelBaslik= driver.getTitle();
        String beklenenBaslik = "Amazon";
        if (guncelBaslik.contains(beklenenBaslik)){
            System.out.println("Amazon test passed 1 =" + driver.getTitle());
        }else System.out.println("Amazon test failed 1");

        //Sayfa adresini(url) yazdirin
        System.out.println("Current url ="+driver.getCurrentUrl());

        //Sayfa url'inin "amazon" icerdigini test edin.
        String guncelUrl = driver.getCurrentUrl();
        String beklenenUrl = "amazon";

        if (guncelUrl.contains(beklenenUrl)){
            System.out.println("Amazon test passed = "+driver.getCurrentUrl());
        }else System.out.println("amazon test failed");

        //Sayfa handle degerini yazdirin
        System.out.println("Sayfa haskod = "+driver.getWindowHandle());

        //Sayfa HTML kodlarinda "Gateway" kelimesi gectigini test edin
        String actualHtmlCode = driver.getPageSource();
        String expecteCode = " Gateway";

        if (actualHtmlCode.contains(expecteCode)){
            System.out.println("HTML Test PASSED");
        }else System.out.println("HTML Test failed");


       //  Sayfayi kapatin.
        driver.close();
    }
}
