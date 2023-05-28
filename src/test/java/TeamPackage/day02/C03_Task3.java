package TeamPackage.day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Task3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("chromDriver", " src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


//        Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın  (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        driver.get("https://www.youtube.com");
        String guncelBaslik = driver.getTitle();
        String beklenenBaslik = "youtube";
        if (guncelBaslik.equals(beklenenBaslik)) {
            System.out.println("youtube test passed 1 = "+driver.getTitle());
        }else System.out.println("Youtube test failed = "+ guncelBaslik);



//        Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru  URL'yi yazdırın.
        driver.get("https://www.youtube.com");
        String guncelBaslik1 = driver.getCurrentUrl();
        String beklenenBaslik1 = "youtube";
        if (guncelBaslik1.contains(beklenenBaslik1)){
            System.out.println("youtube test passed 2 = "+driver.getCurrentUrl());
        }else System.out.println("Youtube test failed = "+ driver.getCurrentUrl());

//        Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.get( "https://www.amazon.com/");
        Thread.sleep(2000);

//        Youtube sayfasina geri donun
        driver.navigate().back();
        Thread.sleep(2000);

//        Sayfayi yenileyin
        driver.navigate().refresh();

//        Amazon sayfasina donun
        driver.navigate().forward();
        Thread.sleep(2000);

//        Sayfayi tamsayfa yapin
        driver.manage().window().fullscreen();
        Thread.sleep(3000);

//        Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa  doğru başlığı(Actual Title) yazdırın.
        String beklenenBaslik2 = driver.getTitle();
        String guncelBaslik2= "Amazon";
        if (beklenenBaslik2.contains(guncelBaslik2)){
            System.out.println("Amazon test passed 2 =");
        }else System.out.println("Amazon test failed 2 = "+guncelBaslik2);

//        Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru  URL'yi yazdırın
            String beklenenUrl = driver.getCurrentUrl();
            String  guncelUrl = "https://www.amazon.com/";
            if (beklenenUrl.equals(guncelUrl)){
                System.out.println("Amazon link correct =" + driver.getCurrentUrl());
            }else System.out.println("Amazon link not correct ");

//        Sayfayi kapatin
        driver.close();
    }
}
