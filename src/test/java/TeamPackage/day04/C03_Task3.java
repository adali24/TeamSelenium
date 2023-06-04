package TeamPackage.day04;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_Task3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/ ");

        //3- cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("(//*[@class='QS5gu sy4vM'])[2]")).click();

        //  4. Sayfa basliginin "Google" ifadesi icerdigini test edin
       String baslik = driver.getTitle();
       if (baslik.contains("Google")){
           System.out.println("test passed");
       }else System.out.println("test failed");


        //    5. Arama cubuguna "Nutella" yazip aratin
         driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Nutella",Keys.ENTER);
         driver.findElement(By.xpath("(//*[@class='gNO89b'])[2]")).click();

        //  6. Bulunan sonuc sayisini yazdirin
        WebElement sonuc = driver.findElement(By.xpath("//*[@id='result-stats']"));
        String SonucSayisi [] = sonuc.getText().split(" ");
        System.out.println("sonuc = " +SonucSayisi[1]);


        //7. sonuc sayisinin 10 milyon'dan fazla oldugunu test edin
        String gercekSayi = "110000000";
        if (gercekSayi.equals("10000000")){
            System.out.println("evet esit");
        }else System.out.println(" hayir degil");


      // if (SonucSayisi[1]10000000){




        //8. Sayfayi kapatin

    }
}
